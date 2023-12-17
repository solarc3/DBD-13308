package DBD.repositories;
import DBD.models.Valoracion;
import java.util.List;
public interface ValoracionRepository {
    /**
     * Inserta un objeto valoracion en la tabla valoracion
     * Como sus atributos son obligatorios, si uno de estos es NULL o vacios
     * o si la conexión falla resultará en una excepción
     *
     * @param valoracion de la clase valoracion con los atributos a ingresar
     * @return Retorna el valoracion creado o NULL si se tiene una excepción
     */
    public Valoracion crear(Valoracion valoracion);

    /**
     * Actualiza un objeto valoracion en la tabla valoracion según su ID
     * Si uno de estos parametros es NULL o vacios o si la conexión falla
     * resultará en una excepción
     *
     * @param valoracion de la clase valoracion con los atributos a actualizar
     * @return Retorna el valoracion actualizado o NULL si se tiene una excepción
     */
    public Valoracion update(Valoracion valoracion);

    /**
     * Obtiene todos los objeto valoracion de la tabla valoracion
     * Si la conexión falla resultará en una excepción
     *
     * @return Retorna todos los objeto valoracion de
     * la tabla valoracion o NULL si se tiene una excepción
     */
    public List<Valoracion> getAll();

    /**
     * Muestra todos los objeto valoracion que coincidan con el ID ingresado
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del valoracion a obtener
     * @return Retorna los objeto valoracion coincidentes
     * o NULL si se tiene una excepción
     */
    public List<Valoracion> show(int id);

    /**
     * Elimina un objeto valoracion de la tabla valoracion según su ID
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del valoracion a eliminar
     * @return Retorna un mensaje de confirmación o un mensaje de error
     * si se tiene una excepción
     */
    public String delete(int id);

}
