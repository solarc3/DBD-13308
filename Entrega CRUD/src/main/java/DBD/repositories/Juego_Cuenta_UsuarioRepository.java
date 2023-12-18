package DBD.repositories;
import DBD.models.Juego_Cuenta_Usuario;
import java.util.List;

public interface Juego_Cuenta_UsuarioRepository {
    /**
     * Inserta un objeto juego_cuenta_usuario en la tabla juego_cuenta_usuario
     * Como sus atributos son obligatorios, si uno de estos es NULL o vacios
     * o si la conexión falla resultará en una excepción
     *
     * @param juego_cuenta_usuario de la clase
     *               juego_cuenta_usuario con los atributos a ingresar
     * @return Retorna el juego_cuenta_usuario creado o NULL si se tiene una excepción
     */
    public Juego_Cuenta_Usuario crear(Juego_Cuenta_Usuario juego_cuenta_usuario);

    /**
     * Actualiza un objeto juego_cuenta_usuario en la tabla
     * juego_cuenta_usuario según su ID
     * Si uno de estos parametros es NULL o vacios o si la conexión falla
     * resultará en una excepción
     *
     * @param juego_cuenta_usuario de la clase
     *               juego_cuenta_usuario con los atributos a actualizar
     * @return Retorna el juego_cuenta_usuario actualizado o NULL si se tiene una excepción
     */
    public Juego_Cuenta_Usuario update(Juego_Cuenta_Usuario juego_cuenta_usuario);

    /**
     * Obtiene todos los objetos juego_cuenta_usuario de la tabla
     * juego_cuenta_usuario
     * Si la conexión falla resultará en una excepción
     *
     * @return Retorna todos los objetos juego_cuenta_usuario de
     * la tabla juego_cuenta_usuario o NULL si se tiene una excepción
     */
    public List<Juego_Cuenta_Usuario> getAll();

    /**
     * Muestra todos los objetos juego_cuenta_usuario que coincidan con el ID ingresado
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del juego_cuenta_usuario a obtener
     * @return Retorna los objetos juego_cuenta_usuario coincidentes
     * o NULL si se tiene una excepción
     */
    public List<Juego_Cuenta_Usuario> show(int id);

    /**
     * Elimina un objeto juego_cuenta_usuario de la tabla
     * juego_cuenta_usuario según su ID
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del juego_cuenta_usuario a eliminar
     * @return Retorna un mensaje de confirmación o un mensaje de error
     * si se tiene una excepción
     */
    public String delete(int id);

    public void agregarJuegoACuenta(int idUsuario, int idJuego);

    public List<Juego_Cuenta_Usuario> getJuegosUsuario(int idUsuario);
}
