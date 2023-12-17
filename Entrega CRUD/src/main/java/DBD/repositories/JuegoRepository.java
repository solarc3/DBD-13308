package DBD.repositories;
import DBD.models.Juego;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Map;

public interface JuegoRepository {
    /**
     * Inserta un juego en la tabla juego
     * Como sus atributos son obligatorios, si uno de estos es NULL o vacios
     * o si la conexión falla resultará en una excepción
     *
     * @param juego de la clase juego con los atributos a ingresar
     * @return Retorna el juego creado o NULL si se tiene una excepción
     */
    public Juego crear(Juego juego);

    /**
     * Actualiza un juego en la tabla juego según su ID
     * Si uno de estos parametros es NULL o vacios o si la conexión falla
     * resultará en una excepción
     *
     * @param juego de la clase juego con los atributos a actualizar
     * @return Retorna el juego actualizado o NULL si se tiene una excepción
     */
    public Juego update(Juego juego);

    /**
     * Obtiene todos los juego de la tabla juego
     * Si la conexión falla resultará en una excepción
     *
     * @return Retorna todos los juego de
     * la tabla juego o NULL si se tiene una excepción
     */
    public List<Juego> getAll();

    /**
     * Muestra todos los juego que coincidan con el ID ingresado
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del juego a obtener
     * @return Retorna los juego coincidentes
     * o NULL si se tiene una excepción
     */
    public List<Juego> show(int id);

    /**
     * Elimina un juego de la tabla juego según su ID
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del juego a eliminar
     * @return Retorna un mensaje de confirmación o un mensaje de error
     * si se tiene una excepción
     */
    public String delete(int id);

    public List<JsonNode> ranking();

    public List<JsonNode> rankingFavoritos();

    public Juego findByID(int id);
}
