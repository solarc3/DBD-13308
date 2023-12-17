package DBD.repositories;
import DBD.models.Compra;

import java.util.List;

public interface CompraRepository {
    /**
     * Inserta un compra en la tabla compra
     * Como sus atributos son obligatorios, si uno de estos es NULL o vacios
     * o si la conexión falla resultará en una excepción
     *
     * @param compra de la clase compra con los atributos a ingresar
     * @return Retorna el compra creado o NULL si se tiene una excepción
     */
    public Compra crear(Compra compra);

    /**
     * Actualiza un objeto compra en la tabla compra según su ID
     * Si uno de estos parametros es NULL o vacios o si la conexión falla
     * resultará en una excepción
     *
     * @param compra de la clase compra con los atributos a actualizar
     * @return Retorna el objeto compra actualizado o NULL si se tiene una excepción
     */
    public Compra update(Compra compra);

    /**
     * Obtiene todos los objetos compra de la tabla compra
     * Si la conexión falla resultará en una excepción
     *
     * @return Retorna los objetos compra coincidentes
     * o NULL si se tiene una excepción
     */
    public List<Compra> getAll();

    /**
     * Muestra todos los objetos compra que coincidan con el ID ingresado
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del compra a obtener
     * @return Retorna los objetos compra coincidentes
     */
    public List<Compra> show(int id);

    /**
     * Elimina un objeto compra de la tabla compra según su ID
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del compra a eliminar
     * @return Retorna un mensaje de confirmación o un mensaje de error
     * si se tiene una excepción
     */
    public String delete(int id);
}
