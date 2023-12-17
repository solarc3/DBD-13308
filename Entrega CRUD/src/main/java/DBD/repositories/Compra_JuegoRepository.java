package DBD.repositories;
import java.util.List;
import DBD.models.Compra_Juego;
public interface Compra_JuegoRepository {
    /**
     * Inserta un compra_juego en la tabla compra_juego
     * Como sus atributos son obligatorios, si uno de estos es NULL o vacios
     * o si la conexión falla resultará en una excepción
     *
     * @param compra_juego de la clase compra_juego con los atributos a ingresar
     * @return Retorna el compra_juego creado o NULL si se tiene una excepción
     */
    public Compra_Juego crear(Compra_Juego compra_juego);

    /**
     * Actualiza un objeto compra_juego en la tabla compra_juego según su ID
     *
     * @param compra_juego de la clase compra_juego con los atributos a actualizar
     * @return Retorna el objeto compra_juego actualizado o NULL si se tiene una excepción
     */
    public Compra_Juego update(Compra_Juego compra_juego);

    /**
     * Obtiene todos los objetos compra_juego de la tabla compra_juego
     * Si la conexión falla resultará en una excepción
     *
     * @return Retorna los objetos compra_juego coincidentes
     * o NULL si se tiene una excepción
     */
    public List<Compra_Juego> getAll();

    /**
     * Muestra todos los objetos compra_juego que coincidan con el ID ingresado
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del compra_juego a obtener
     * @return Retorna los objetos compra_juego coincidentes
     */
    public List<Compra_Juego> show(int id);

    /**
     * Elimina un objeto compra_juego de la tabla compra_juego según su ID
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del compra_juego a eliminar
     * @return Retorna un mensaje de confirmación o un mensaje de error
     * si se tiene una excepción
     */
    public String delete(int id);
}
