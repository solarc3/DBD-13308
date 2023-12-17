package DBD.repositories;
import DBD.repositories.Cuenta_UsuarioRepository;
import DBD.models.Cuenta_Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class RequerimientosRepository {
    @Autowired
    private Cuenta_UsuarioRepository cuenta_usuarioRepository;

    public Cuenta_Usuario autenticar(String correo, String password){
        Cuenta_Usuario cuenta_usuario = cuenta_usuarioRepository.findbyEmail(correo);
        if(cuenta_usuario != null){
            if(cuenta_usuario.getContrasena().equals(password)){
                return cuenta_usuario;
            }
        }
        return null;
    }

}
