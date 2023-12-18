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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    private CompraRepositoryImp compraRepository;
    @Autowired
    private Juego_Cuenta_UsuarioRepositoryImp juegoCuentaRepository;
    @Autowired
    private BoletaRepositoryImp boletaRepository;
    @Autowired
    private Medio_de_PagoRepositoryImp pagoRepository;
    @GetMapping("/Requerimientos/comprarCarro")
    public ResponseEntity<?> comprarCarro(HttpServletRequest request) throws ParseException {
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
        List<JsonNode> juegos = carroComprasRepository.obtenerJuegosEnCarro(idUsuario);
        System.out.println("Total de juegos en el carro: " + (juegos != null ? juegos.size() : "null"));
        // CORREGIR PQ ES UN JSON TRABAJAR CON METODOS DE JSON
        //if (juegos.isEmpty()) {
            //return ResponseEntity.status(409).body("El carro de compras está vacío.");
        //}
        // Calculo del total de la compra, considerando descuentos
        int total = 0;
        for (JsonNode juego : juegos) {
            int precioOriginal = juego.get("precio_original").asInt();
            JsonNode precioOfertaNode = juego.get("precio_oferta");

            int precioFinal;
            if (precioOfertaNode != null && !precioOfertaNode.isNull()) {
                precioFinal = precioOfertaNode.asInt();
            } else {
                precioFinal = precioOriginal;
            }
            total += precioFinal;
        }
        // printear precioFinal
        System.out.println("Total de la compra: " + total);
        // Verificar que el usuario no tenga ninguno de los juegos en su cuenta que este intenando comprar
        List<Juego_Cuenta_Usuario> juegosEnCuenta = juegoCuentaRepository.getJuegosUsuario(idUsuario);
        for (JsonNode juego : juegos) {
            int idJuego = juego.get("id_juego").asInt();
            for (Juego_Cuenta_Usuario juegoEnCuenta : juegosEnCuenta) {
                if (juegoEnCuenta.getID_Juego() == idJuego) {
                    return ResponseEntity.status(409).body("El usuario ya tiene el juego con ID: " + idJuego + " en su cuenta.");
                }
            }
        }
        // Agregar los juegos a la cuenta del usuario via Juego_Cuenta_Usuario
        for (JsonNode juego : juegos) {
            int idJuego = juego.get("id_juego").asInt();
            System.out.println("Agregando juego con ID: " + idJuego + " a la cuenta del usuario.");
            juegoCuentaRepository.agregarJuegoACuenta(idUsuario, idJuego);
            System.out.println("Juego agregado correctamente.");
        }
        // Generar una boleta
        System.out.println("Creando boleta...");
        Boleta boleta = new Boleta();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(new Date());
        Date dateWithoutTime = formatter.parse(formattedDate);
        boleta.setFecha(dateWithoutTime);
        boleta = boletaRepository.crear(boleta);
        int idBoleta = boleta.getID_Boleta(); // Tenemos el id de la boleta
        System.out.println("Boleta creada con ID: " + idBoleta);
        // Generar un pago
        System.out.println("Creando pago...");
        Medio_de_Pago pago = new Medio_de_Pago();
        pago.setNombre_del_medio("Tarjeta de crédito");
        pago.setDatos_del_medio("1234-5678-9012-3456");
        pago = pagoRepository.crear(pago);
        int idPago = pago.getID_pago(); // Obtenemos su id
        System.out.println("Pago creado con ID: " + idPago);
        // Agregar a la compra: id_boleta, id_carro, id_pago, total_pagado, juegos_comprados
        System.out.println("Creando compra...");
        Compra compra = new Compra();
        compra.setID_Boleta(idBoleta);
        compra.setID_Carro(idCarro);
        compra.setID_Pago(idPago);
        compra.setTotal_Pagado(total);
        compra.setJuegos_Comprados(juegos.size());
        compraRepository.crear(compra);
        System.out.println("Compra creada.");

        // Se agregaron los juegos a la persona, se generó la boleta y se generó el pago
        carroComprasJuegoRepository.vaciarCarro(idCarro);
        //BORRAR CARRO DE COMPRAS TAMBIEN
        carroComprasRepository.delete(idCarro);
        System.out.println("Compra realizada exitosamente.");
        return ResponseEntity.ok().body("Compra realizada exitosamente.");
    }
    // REQUERIMIENTO VER LOS JUEGOS QUE SE PUEDEN AGREGAR DEPENDIENDO DE LA EDAD
    @GetMapping("/Requerimientos/verJuegos")
    public ResponseEntity<?> verJuegos(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer idUsuario = (Integer) session.getAttribute("ID_usuario");
        if (idUsuario == null) {
            return ResponseEntity.status(401).body("Usuario no identificado.");
        }
        boolean esMenorDeEdad = verificarMenorDeEdad(idUsuario);
        List<Juego> juegos = juegoRepository.verJuegos(esMenorDeEdad);
        return ResponseEntity.ok().body(juegos);
    }
    private boolean verificarMenorDeEdad(int idUsuario) {
        Cuenta_Usuario usuario = cuentaUsuarioRepository.findbyID(idUsuario);
        if (usuario == null || usuario.getFecha_Nacimiento() == null) {
            return false;
        }
        Date fechaNacimiento = usuario.getFecha_Nacimiento();
        Calendar fechaNacimientoCal = Calendar.getInstance();
        fechaNacimientoCal.setTime(fechaNacimiento);

        Calendar hoy = Calendar.getInstance();
        int edad = hoy.get(Calendar.YEAR) - fechaNacimientoCal.get(Calendar.YEAR);
        if (fechaNacimientoCal.get(Calendar.DAY_OF_YEAR) > hoy.get(Calendar.DAY_OF_YEAR)) {
            edad--;
        }
        return edad < 18;
    }
}
