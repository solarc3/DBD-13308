package DBD.repositories;
import DBD.models.Cuenta_Usuario;
import java.util.List;
public interface Cuenta_UsuarioRepository {
    /**
     * Inserta un objeto cuenta_usuario en la tabla cuenta_usuario
     * Como sus atributos son obligatorios, si uno de estos es NULL o vacios
     * o si la conexión falla resultará en una excepción
     *
     * @param cuenta_usuario de la clase
     *               cuenta_usuario con los atributos a ingresar
     * @return Retorna el cuenta_usuario creado o NULL si se tiene una excepción
     */
    public Cuenta_Usuario crear(Cuenta_Usuario cuenta_usuario);

    /**
     * Actualiza un objeto cuenta_usuario en la tabla
     * cuenta_usuario según su ID
     * Si uno de estos parametros es NULL o vacios o si la conexión falla
     * resultará en una excepción
     *
     * @param cuenta_usuario de la clase
     *               cuenta_usuario con los atributos a actualizar
     * @return Retorna el cuenta_usuario actualizado o NULL si se tiene una excepción
     */
    public Cuenta_Usuario update(Cuenta_Usuario cuenta_usuario);

    /**
     * Obtiene todos los objetos cuenta_usuario de la tabla
     * cuenta_usuario
     * Si la conexión falla resultará en una excepción
     *
     * @return Retorna todos los objetos cuenta_usuario de
     * la tabla cuenta_usuario o NULL si se tiene una excepción
     */
    public List<Cuenta_Usuario> getAll();

    /**
     * Muestra todos los objetos cuenta_usuario que coincidan con el ID ingresado
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del cuenta_usuario a obtener
     * @return Retorna los objetos cuenta_usuario coincidentes
     * o NULL si se tiene una excepción
     */
    public List<Cuenta_Usuario> show(int id);

    /**
     * Elimina un objeto cuenta_usuario de la tabla
     * cuenta_usuario según su ID
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del cuenta_usuario a eliminar
     * @return Retorna un mensaje de confirmación o un mensaje de error
     * si se tiene una excepción
     */
    public String delete(int id);
}
