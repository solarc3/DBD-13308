package DBD.repositories;
import DBD.models.Compra_Cuenta_Usuario;
import java.util.List;
public interface Compra_Cuenta_UsuarioRepository {
    /**
     * Inserta un objeto compra_cuenta_usuario en la tabla compra_cuenta_usuario
     * Como sus atributos son obligatorios, si uno de estos es NULL o vacios
     * o si la conexión falla resultará en una excepción
     *
     * @param compra_cuenta_usuario de la clase
     *               compra_cuenta_usuario con los atributos a ingresar
     * @return Retorna el compra_cuenta_usuario creado o NULL si se tiene una excepción
     */
    public Compra_Cuenta_Usuario crear(Compra_Cuenta_Usuario compra_cuenta_usuario);

    /**
     * Actualiza un objeto compra_cuenta_usuario en la tabla
     * compra_cuenta_usuario según su ID
     * Si uno de estos parametros es NULL o vacios o si la conexión falla
     * resultará en una excepción
     *
     * @param compra_cuenta_usuario de la clase
     *               compra_cuenta_usuario con los atributos a actualizar
     * @return Retorna el compra_cuenta_usuario actualizado o NULL si se tiene una excepción
     */
    public Compra_Cuenta_Usuario update(Compra_Cuenta_Usuario compra_cuenta_usuario);

    /**
     * Obtiene todos los objetos compra_cuenta_usuario de la tabla
     * compra_cuenta_usuario
     * Si la conexión falla resultará en una excepción
     *
     * @return Retorna todos los objetos compra_cuenta_usuario de
     * la tabla compra_cuenta_usuario o NULL si se tiene una excepción
     */
    public List<Compra_Cuenta_Usuario> getAll();

    /**
     * Muestra todos los objetos compra_cuenta_usuario que coincidan con el ID ingresado
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del compra_cuenta_usuario a obtener
     * @return Retorna los objetos compra_cuenta_usuario coincidentes
     * o NULL si se tiene una excepción
     */
    public List<Compra_Cuenta_Usuario> show(int id);

    /**
     * Elimina un objeto compra_cuenta_usuario de la tabla
     * compra_cuenta_usuario según su ID
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del compra_cuenta_usuario a eliminar
     * @return Retorna un mensaje de confirmación o un mensaje de error
     * si se tiene una excepción
     */
    public String delete(int id);
}
