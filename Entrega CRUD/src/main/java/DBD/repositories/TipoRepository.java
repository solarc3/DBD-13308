package DBD.repositories;
import DBD.models.Tipo;
import java.util.List;
public interface TipoRepository {
    /**
     * Inserta un objeto tipo en la tabla tipo
     * Como sus atributos son obligatorios, si uno de estos es NULL o vacios
     * o si la conexión falla resultará en una excepción
     *
     * @param tipo de la clase tipo con los atributos a ingresar
     * @return Retorna el tipo creado o NULL si se tiene una excepción
     */
    public Tipo crear(Tipo tipo);

    /**
     * Actualiza un objeto tipo en la tabla tipo según su ID
     * Si uno de estos parametros es NULL o vacios o si la conexión falla
     * resultará en una excepción
     *
     * @param tipo de la clase tipo con los atributos a actualizar
     * @return Retorna el tipo actualizado o NULL si se tiene una excepción
     */
    public Tipo update(Tipo tipo);

    /**
     * Obtiene todos los tipo de la tabla tipo
     * Si la conexión falla resultará en una excepción
     *
     * @return Retorna todos los tipo de
     * la tabla tipo o NULL si se tiene una excepción
     */
    public List<Tipo> getAll();

    /**
     * Muestra todos los tipo que coincidan con el ID ingresado
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del tipo a obtener
     * @return Retorna los tipo coincidentes
     * o NULL si se tiene una excepción
     */
    public List<Tipo> show(int id);

    /**
     * Elimina un tipo de la tabla tipo según su ID
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del tipo a eliminar
     * @return Retorna un mensaje de confirmación o un mensaje de error
     * si se tiene una excepción
     */
    public String delete(int id);
}
