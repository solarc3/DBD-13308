package DBD.repositories;
import DBD.models.Tipo_Cuenta_Usuario;
public interface Tipo_Cuenta_UsuarioRepository {
    public Tipo_Cuenta_Usuario crear(Tipo_Cuenta_Usuario tipo_cuenta_usuario);
    public Tipo_Cuenta_Usuario update(Tipo_Cuenta_Usuario tipo_cuenta_usuario);
    public String delete(int id);
    public Tipo_Cuenta_Usuario show(int id);
    public Tipo_Cuenta_Usuario showByNombre(String nombre);
}
