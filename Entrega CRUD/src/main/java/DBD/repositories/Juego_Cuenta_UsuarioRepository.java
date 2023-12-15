package DBD.repositories;
import DBD.models.Juego_Cuenta_Usuario;
import java.util.List;

public interface Juego_Cuenta_UsuarioRepository {
    public Juego_Cuenta_Usuario crear(Juego_Cuenta_Usuario juego_cuenta_usuario);
    public Juego_Cuenta_Usuario update(Juego_Cuenta_Usuario juego_cuenta_usuario);
    public List<Juego_Cuenta_Usuario> getAll();
    public List<Juego_Cuenta_Usuario> show(int id);
    public String delete(int id);
}
