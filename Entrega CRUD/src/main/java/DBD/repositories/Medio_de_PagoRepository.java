package DBD.repositories;
import DBD.models.Medio_de_Pago;
import java.util.List;

public interface Medio_de_PagoRepository {
    /**
     * Inserta un medio_de_pago en la tabla medio_de_pago
     * Como sus atributos son obligatorios, si uno de estos es NULL o vacios
     * o si la conexión falla resultará en una excepción
     *
     * @param medio_de_pago de la clase medio_de_pago con los atributos a ingresar
     * @return Retorna el medio_de_pago creado o NULL si se tiene una excepción
     */
    public Medio_de_Pago crear(Medio_de_Pago medio_de_pago);

    /**
     * Actualiza un medio_de_pago en la tabla medio_de_pago según su ID
     * Si uno de estos parametros es NULL o vacios o si la conexión falla
     * resultará en una excepción
     *
     * @param medio_de_pago de la clase medio_de_pago con los atributos a actualizar
     * @return Retorna el medio_de_pago actualizado o NULL si se tiene una excepción
     */
    public Medio_de_Pago update(Medio_de_Pago medio_de_pago);

    /**
     * Obtiene todos los medio_de_pago de la tabla medio_de_pago
     * Si la conexión falla resultará en una excepción
     *
     * @return Retorna todos los medio_de_pago de
     * la tabla medio_de_pago o NULL si se tiene una excepción
     */
    public List<Medio_de_Pago> getAll();

    /**
     * Muestra todos los medio_de_pago que coincidan con el ID ingresado
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del medio_de_pago a obtener
     * @return Retorna los medio_de_pago coincidentes
     * o NULL si se tiene una excepción
     */
    public List<Medio_de_Pago> show(int id);

    /**
     * Elimina un medio_de_pago de la tabla medio_de_pago según su ID
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del medio_de_pago a eliminar
     * @return Retorna un mensaje de confirmación o un mensaje de error
     * si se tiene una excepción
     */
    public String delete(int id);
}
