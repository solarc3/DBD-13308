package DBD.repositories;
import DBD.models.Carro_de_Compras_Juego;
import java.util.List;
public interface Carro_de_Compras_JuegoRepository {
    /**
     * Inserta un carro_de_compras_juego en la tabla carro_de_compras_juego
     * Como sus atributos son obligatorios, si uno de estos es NULL o vacios
     * o si la conexión falla resultará en una excepción
     *
     * @param carro_de_compras_juego de la clase
     *               carro_de_compras_juego con los atributos a ingresar
     * @return Retorna el carro_de_compras_juego creado o NULL si se tiene una excepción
     */
    public Carro_de_Compras_Juego crear(Carro_de_Compras_Juego carro_de_compras_juego);

    /**
     * Actualiza un carro_de_compras_juego en la tabla carro_de_compras_juego según su ID
     * Si uno de estos parametros es NULL o vacios o si la conexión falla
     * resultará en una excepción
     *
     * @param carro_de_compras_juego de la clase
     *               carro_de_compras_juego con los atributos a actualizar
     * @return Retorna el carro_de_compras_juego actualizado o NULL si se tiene una excepción
     */
    public Carro_de_Compras_Juego update(Carro_de_Compras_Juego carro_de_compras_juego);

    /**
     * Obtiene todos los carro_de_compras_juego de la tabla carro_de_compras_juego
     * Si la conexión falla resultará en una excepción
     *
     * @return Retorna todos los carro_de_compras_juego de
     * la tabla carro_de_compras_juego o NULL si se tiene una excepción
     */
    public List<Carro_de_Compras_Juego> getAll();

    /**
     * Muestra todos los carro_de_compras_juego que coincidan con el ID ingresado
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del carro_de_compras_juego a obtener
     * @return Retorna los carro_de_compras_juego coincidentes
     * o NULL si se tiene una excepción
     */
    public List<Carro_de_Compras_Juego> show(int id);

    /**
     * Elimina un carro_de_compras_juego de la tabla carro_de_compras_juego según su ID
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del carro_de_compras_juego a eliminar
     * @return Retorna un mensaje de confirmación o un mensaje de error
     * si se tiene una excepción
     */
    public String delete(int id);

    public boolean existeJuegoEnCarro(int idCarro, int idJuego);

    public void agregarJuegoAlCarro(int idCarro, int idJuego);

    public void eliminarJuegoDelCarro(int idCarro, int idJuego);
}
