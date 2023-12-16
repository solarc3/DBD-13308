package DBD.repositories;
import DBD.models.Compra_Cuenta_Usuario;
import java.util.List;
public interface Compra_Cuenta_UsuarioRepository {
    public Compra_Cuenta_Usuario crear(Compra_Cuenta_Usuario compra_cuenta_usuario);
    public Compra_Cuenta_Usuario update(Compra_Cuenta_Usuario compra_cuenta_usuario);
    public List<Compra_Cuenta_Usuario> getAll();
    public List<Compra_Cuenta_Usuario> show(int id);
    public String delete(int id);
}
