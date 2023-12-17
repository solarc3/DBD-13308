package DBD.repositories;
import DBD.models.Juego_Genero;
import java.util.List;

public interface Juego_GeneroRepository {
    /**
     * Inserta un juego_genero en la tabla juego_genero
     * Como sus atributos son obligatorios, si uno de estos es NULL o vacios
     * o si la conexión falla resultará en una excepción
     *
     * @param juego_genero de la clase juego_genero con los atributos a ingresar
     * @return Retorna el juego_genero creado o NULL si se tiene una excepción
     */
    public Juego_Genero crear(Juego_Genero juego_genero);

    /**
     * Actualiza un juego_genero en la tabla juego_genero según su ID
     * Si uno de estos parametros es NULL o vacios o si la conexión falla
     * resultará en una excepción
     *
     * @param juego_genero de la clase juego_genero con los atributos a actualizar
     * @return Retorna el juego_genero actualizado o NULL si se tiene una excepción
     */
    public Juego_Genero update(Juego_Genero juego_genero);

    /**
     * Obtiene todos los juego_genero de la tabla juego_genero
     * Si la conexión falla resultará en una excepción
     *
     * @return Retorna todos los juego_genero de
     * la tabla juego_genero o NULL si se tiene una excepción
     */
    public List<Juego_Genero> getAll();

    /**
     * Muestra todos los juego_genero que coincidan con el ID ingresado
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del juego_genero a obtener
     * @return Retorna los juego_genero coincidentes
     * o NULL si se tiene una excepción
     */
    public List<Juego_Genero> show(int id);

    /**
     * Elimina un juego_genero de la tabla juego_genero según su ID
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del juego_genero a eliminar
     * @return Retorna un mensaje de confirmación o un mensaje de error
     * si se tiene una excepción
     */
    public String delete(int id);
}
