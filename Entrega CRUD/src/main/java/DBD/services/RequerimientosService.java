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
        Cuenta_Usuario usuario = cuentaUsuarioRepository.findbyEmail(email);
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
}
