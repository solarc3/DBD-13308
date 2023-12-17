package DBD.services;
import java.util.List;
import DBD.models.*;
import DBD.repositories.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
@CrossOrigin
@RestController
public class RequerimientosService {
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
}
