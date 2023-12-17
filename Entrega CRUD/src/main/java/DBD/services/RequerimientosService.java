package DBD.services;
import DBD.models.*;
import DBD.repositories.*;
import com.fasterxml.jackson.databind.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
@CrossOrigin
@RestController
public class RequerimientosService {
    // LOGIN DE USUARIOS CON INFORMACION PERSISTENTE
    @Autowired
    private Cuenta_UsuarioRepositoryImp cuentaUsuarioRepository;
    @PostMapping("/Requerimientos/login")
    public ResponseEntity<?> login(@RequestBody JsonNode requestBody, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = requestBody.get("correo").asText();
        String password = requestBody.get("contrasena").asText();
        // prints debug
        System.out.println("email: " + email);
        System.out.println("password: " + password);
        Cuenta_Usuario usuario = cuentaUsuarioRepository.findbyEmail(email);
        System.out.println("usuario: " + usuario);
        if (usuario != null && usuario.getContrasena().equals(password)) {
            session.setAttribute("ID_usuario", usuario.getID_Usuario());
            return ResponseEntity.ok().body("Usuario autenticado exitosamente");
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }
    // REQUERIMIENTO OPCIONAL: RECUPERAR CONTRASEÑA VIA EMAIL
    @Autowired
    private JavaMailSender mailSender;
    @PostMapping("/Requerimientos/recoverPassword")
    public ResponseEntity<?> recoverPassword(@RequestBody JsonNode requestBody) {
        String email = requestBody.get("correo").asText();
        String username = requestBody.get("nombre_usuario").asText();
        Cuenta_Usuario usuario = cuentaUsuarioRepository.findByEmailAndUsername(email, username);
        if (usuario != null) {
            sendPasswordEmail(email, usuario.getContrasena());
            return ResponseEntity.ok().body("Contraseña enviada al correo electrónico proporcionado.");
        } else {
            return ResponseEntity.status(404).body("Datos de usuario no válidos.");
        }
    }
    private void sendPasswordEmail(String email, String password) {
        String messageText = "Su contraseña es: " + password;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Recuperación de contraseña");
        message.setText(messageText);
        mailSender.send(message);
    }
    // REQUERIMIENTO RANKING DE LOS JUEGOS MAS COMPRADOS
    @Autowired
    private JuegoRepositoryImp juegoRepository;
    @GetMapping("/Requerimientos/ranking")
    public ResponseEntity<?> ranking() {
        return ResponseEntity.ok().body(juegoRepository.ranking());
    }
    // REQUERIMIENTO RAKING DE LOS JUEGOS QUE MAS TIENEN EN FAVORITO
    @GetMapping("/Requerimientos/rankingFavoritos")
    public ResponseEntity<?> rankingFavoritos() {
        return ResponseEntity.ok().body(juegoRepository.rankingFavoritos());
    }
    // REQUERIMIENTOS CARRO DE COMPRAS Y SIMULACION DE COMPRA
    @Autowired
    private Carro_de_ComprasRepositoryImp carroComprasRepository;

    @GetMapping("/Requerimientos/crearCarro")
    public ResponseEntity<?> crearCarro(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer idUsuario = (Integer) session.getAttribute("ID_usuario");
        if (idUsuario == null) {
            return ResponseEntity.status(401).body("Usuario no identificado.");
        }
        Carro_de_Compras carro = carroComprasRepository.existByUser(idUsuario);
        if (carro != null) {
            return ResponseEntity.ok().body("El usuario ya tiene un carro de compras.");
        }
        // Si no existe, crea uno nuevo
        Carro_de_Compras nuevoCarro = new Carro_de_Compras();
        nuevoCarro.setID_Usuario(idUsuario);
        nuevoCarro = carroComprasRepository.crear(nuevoCarro);
        return ResponseEntity.ok().body("Carro de compras creado exitosamente para el usuario.");
    }
    // ahora vemos los juegos del carrito de compras
    @GetMapping("/Requerimientos/verCarro")
    public ResponseEntity<?> verCarro(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer idUsuario = (Integer) session.getAttribute("ID_usuario");
        if (idUsuario == null) {
            return ResponseEntity.status(401).body("Usuario no identificado.");
        }
        Carro_de_Compras carro = carroComprasRepository.existByUser(idUsuario);
        if (carro == null) {
            return ResponseEntity.ok().body("El usuario no tiene un carro de compras.");
        }
        return ResponseEntity.ok().body(carroComprasRepository.obtenerJuegosEnCarro(idUsuario));
    }
    @Autowired
    private Carro_de_Compras_JuegoRepository carroComprasJuegoRepository;
    @PostMapping("/Requerimientos/agregarJuegoAlCarro")
    public ResponseEntity<?> agregarJuegoAlCarro(@RequestBody JsonNode requestBody, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer idUsuario = (Integer) session.getAttribute("ID_usuario");
        if (idUsuario == null) {
            return ResponseEntity.status(400).body("Usuario no identificado.");
        }
        Carro_de_Compras carro = carroComprasRepository.existByUser(idUsuario);
        if (carro == null) {
            return ResponseEntity.status(404).body("Carro de compras no encontrado.");
        }
        int idCarro = carro.getID_Carro(); // Asumiendo que getID_Carro() nunca retorna null si carro existe.
        Integer idJuego = requestBody.has("idJuego") ? requestBody.get("idJuego").asInt() : null;
        if (idJuego == null) {
            return ResponseEntity.status(400).body("ID de juego no proporcionado.");
        }
        boolean juegoYaEnCarro = carroComprasJuegoRepository.existeJuegoEnCarro(idCarro, idJuego);
        if (juegoYaEnCarro) {
            return ResponseEntity.status(409).body("El juego ya está en el carro de compras.");
        }

        carroComprasJuegoRepository.agregarJuegoAlCarro(idCarro, idJuego);
        return ResponseEntity.ok().body("Juego agregado exitosamente al carro de compras.");
    }
    @DeleteMapping("/Requerimientos/eliminarJuegoDelCarro")
    public ResponseEntity<?> eliminarJuegoDelCarro(@RequestBody JsonNode requestBody, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer idUsuario = (Integer) session.getAttribute("ID_usuario");
        if (idUsuario == null) {
            return ResponseEntity.status(400).body("Usuario no identificado.");
        }

        Carro_de_Compras carro = carroComprasRepository.existByUser(idUsuario);
        if (carro == null) {
            return ResponseEntity.status(404).body("Carro de compras no encontrado.");
        }
        int idCarro = carro.getID_Carro();

        Integer idJuego = requestBody.has("idJuego") ? requestBody.get("idJuego").asInt() : null;
        if (idJuego == null) {
            return ResponseEntity.status(400).body("ID de juego no proporcionado.");
        }

        boolean juegoEnCarro = carroComprasJuegoRepository.existeJuegoEnCarro(idCarro, idJuego);
        if (!juegoEnCarro) {
            return ResponseEntity.status(409).body("El juego no está en el carro de compras.");
        }

        carroComprasJuegoRepository.eliminarJuegoDelCarro(idCarro, idJuego);
        return ResponseEntity.ok().body("Juego eliminado exitosamente del carro de compras.");
    }

}
