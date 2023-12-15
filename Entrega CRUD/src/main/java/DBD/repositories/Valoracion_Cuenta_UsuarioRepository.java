package DBD.repositories;
import DBD.models.Valoracion_Cuenta_Usuario;
import java.util.List;

public interface Valoracion_Cuenta_UsuarioRepository {
    public Valoracion_Cuenta_Usuario crear(Valoracion_Cuenta_Usuario valoracion_cuenta_usuario);
    public Valoracion_Cuenta_Usuario update(Valoracion_Cuenta_Usuario valoracion_cuenta_usuario);
    public List<Valoracion_Cuenta_Usuario> getAll();
    public List<Valoracion_Cuenta_Usuario> show(int id);
    public String delete(int id);
}
