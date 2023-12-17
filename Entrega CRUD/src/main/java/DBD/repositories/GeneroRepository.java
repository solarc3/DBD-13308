package DBD.repositories;
import DBD.models.Genero;
import java.util.List;
public interface GeneroRepository {
    /**
     * Inserta un genero en la tabla genero
     * Como sus atributos son obligatorios, si uno de estos es NULL o vacios
     * o si la conexión falla resultará en una excepción
     *
     * @param genero de la clase genero
     *               con los atributos a ingresar
     * @return Retorna el genero creado o NULL si se tiene una excepción
     */
    public Genero crear(Genero genero);

    /**
     * Actualiza un genero en la tabla genero según su ID
     * Si uno de estos parametros es NULL o vacios o si la conexión falla
     * resultará en una excepción
     *
     * @param genero de la clase genero
     *               con los atributos a actualizar
     * @return Retorna el genero actualizado o NULL si se tiene una excepción
     */
    public Genero update(Genero genero);

    /**
     * Obtiene todos los genero de la tabla genero
     * Si la conexión falla resultará en una excepción
     *
     * @return Retorna todos los genero de
     * la tabla genero o NULL si se tiene una excepción
     */
    public List<Genero> getAll();

    /**
     * Muestra todos los genero que coincidan con el ID ingresado
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del genero a obtener
     * @return Retorna los genero coincidentes
     * o NULL si se tiene una excepción
     */
    public List<Genero> show(int id);

    /**
     * Elimina un genero de la tabla genero según su ID
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del genero a eliminar
     * @return Retorna un mensaje de confirmación o un mensaje de error
     * si se tiene una excepción
     */
    public String delete(int id);
}
