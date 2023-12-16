package DBD.repositories;
import DBD.models.Boleta;

import java.util.List;


public interface BoletaRepository {
    public Boleta crear(Boleta boleta);
    /**
     * Inserta una boleta en la tabla boleta
     * Como todos los atributos son obligatorios, si uno de estos es NULL o vacios
     * o si la conexión falla resultará en una excepción
     *
     * @param Objeto boleta de la clase boleta con los atributos a ingresar
     * @return Retorna la boleta creada o NULL si se tiene una excepción
     * @throws Excepción si uno de los atributos es NULL o vacío
    */
    public Boleta update(Boleta boleta);
    /**
     * Actualiza una boleta en la tabla boleta según su ID
     * Si uno de estos es NULL o vacios o si la conexión falla resultará en una excepción
     *
     * @param Objeto boleta de la clase boleta con los atributos a actualizar
     * @return Retorna la boleta actualizada o NULL si se tiene una excepción
     * @throws Excepción si uno de los atributos es NULL o vacío
    */
    public List<Boleta> getAll();
    /**
     * Obtiene todas las boletas de la tabla boleta
     * Si la conexión falla resultará en una excepción
     *
     * @return Retorna todas las boletas de la tabla boleta o NULL si se tiene una excepción
     * @throws Excepción si la conexión falla
    */
    public List<Boleta> show(int id);
    /**
     * Muestra todas las boletas que coincidan con el ID ingresado
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param ID de la boleta a obtener
     * @return Retorna las boletas coincidentes o NULL si se tiene una excepción
     * @throws Excepción si la conexión falla
    */
    public String delete(int id);
    /**
     * Elimina una boleta de la tabla boleta según su ID
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param ID de la boleta a eliminar
     * @return Retorna un mensaje de confirmación o un mensaje de error
     * si se tiene una excepción
     * @throws Excepción si la conexión falla o si el ID es NULL
    */
}
