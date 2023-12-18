package DBD.repositories;
import DBD.models.Cuenta_Usuario;
import java.util.List;
public interface Cuenta_UsuarioRepository {
    public Cuenta_Usuario crear(Cuenta_Usuario cuenta_usuario);
    public Cuenta_Usuario update(Cuenta_Usuario cuenta_usuario);
    public List<Cuenta_Usuario> getAll();
    public List<Cuenta_Usuario> show(int id);
    public String delete(int id);
    public Cuenta_Usuario findbyEmail(String email);
    public Cuenta_Usuario findByEmailAndUsername(String email, String username);

    public Cuenta_Usuario findbyID(int id);

}
