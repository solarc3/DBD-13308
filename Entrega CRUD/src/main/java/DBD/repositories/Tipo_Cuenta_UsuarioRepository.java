package DBD.repositories;
import DBD.models.Tipo_Cuenta_Usuario;
import java.util.List;
public interface Tipo_Cuenta_UsuarioRepository {
    /**
     * Inserta un objeto tipo_cuenta_usuario en la tabla tipo_cuenta_usuario
     * Como sus atributos son obligatorios, si uno de estos es NULL o vacios
     * o si la conexión falla resultará en una excepción
     *
     * @param tipo_cuenta_usuario de la clase
     *               tipo_cuenta_usuario con los atributos a ingresar
     * @return Retorna el tipo_cuenta_usuario creado o NULL si se tiene una excepción
     */
    public Tipo_Cuenta_Usuario crear(Tipo_Cuenta_Usuario tipo_cuenta_usuario);

    /**
     * Actualiza un objeto tipo_cuenta_usuario en la tabla
     * tipo_cuenta_usuario según su ID
     * Si uno de estos parametros es NULL o vacios o si la conexión falla
     * resultará en una excepción
     *
     * @param tipo_cuenta_usuario de la clase
     *               tipo_cuenta_usuario con los atributos a actualizar
     * @return Retorna el tipo_cuenta_usuario actualizado o NULL si se tiene una excepción
     */
    public Tipo_Cuenta_Usuario update(Tipo_Cuenta_Usuario tipo_cuenta_usuario);

    /**
     * Elimina un objeto tipo_cuenta_usuario de la tabla
     * tipo_cuenta_usuario según su ID
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del tipo_cuenta_usuario a eliminar
     * @return Retorna un mensaje de confirmación o un mensaje de error
     * si se tiene una excepción
     */
    public String delete(int id);

    /**
     * Muestra todos los objetos tipo_cuenta_usuario que coincidan con el ID ingresado
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del tipo_cuenta_usuario a obtener
     * @return Retorna los objetos tipo_cuenta_usuario coincidentes
     * o NULL si se tiene una excepción
     */
    public List<Tipo_Cuenta_Usuario> show(int id);

    /**
     * Obtiene todos los objetos tipo_cuenta_usuario de la tabla
     * tipo_cuenta_usuario
     * Si la conexión falla resultará en una excepción
     *
     * @return Retorna todos los objetos tipo_cuenta_usuario de
     * la tabla tipo_cuenta_usuario o NULL si se tiene una excepción
     */
    public List<Tipo_Cuenta_Usuario> getAll();
}
