package DBD.repositories;
import DBD.models.Boleta;

import java.util.List;


public interface BoletaRepository {
    /**
     * Inserta una boleta en la tabla boleta
     * Como todos los atributos son obligatorios, si uno de estos es NULL o vacios
     * o si la conexión falla resultará en una excepción
     *
     * @param boleta de la clase boleta con los atributos a ingresar
     * @return Retorna la boleta creada o NULL si se tiene una excepción
     */
    public Boleta crear(Boleta boleta);

    /**
     * Actualiza una boleta en la tabla boleta según su ID
     * Si uno de estos parametros es NULL o vacios o si la conexión falla
     * resultará en una excepción
     *
     * @param boleta de la clase boleta con los atributos a actualizar
     * @return Retorna la boleta actualizada o NULL si se tiene una excepción
     */
    public Boleta update(Boleta boleta);

    /**
     * Obtiene todas las boletas de la tabla boleta
     * Si la conexión falla resultará en una excepción
     *
     * @return Retorna todas las boletas de la tabla boleta o NULL si se tiene una excepción
     */
    public List<Boleta> getAll();

    /**
     * Muestra todas las boletas que coincidan con el ID ingresado
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id de la boleta a obtener
     * @return Retorna las boletas coincidentes o NULL si se tiene una excepción
     */
    public List<Boleta> show(int id);

    /**
     * Elimina una boleta de la tabla boleta según su ID
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id de la boleta a eliminar
     * @return Retorna un mensaje de confirmación o un mensaje de error
     * si se tiene una excepción
     */
    public String delete(int id);
}
