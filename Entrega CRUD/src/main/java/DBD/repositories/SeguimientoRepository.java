package DBD.repositories;
import DBD.models.Seguimiento;
import java.util.List;

public interface SeguimientoRepository {
    /**
     * Inserta un seguimiento en la tabla seguimiento
     * Como sus atributos son obligatorios, si uno de estos es NULL o vacios
     * o si la conexión falla resultará en una excepción
     *
     * @param seguimiento de la clase seguimiento con los atributos a ingresar
     * @return Retorna el seguimiento creado o NULL si se tiene una excepción
     */
    public Seguimiento crear(Seguimiento seguimiento);

    /**
     * Actualiza un seguimiento en la tabla seguimiento según su ID
     * Si uno de estos parametros es NULL o vacios o si la conexión falla
     * resultará en una excepción
     *
     * @param seguimiento de la clase seguimiento con los atributos a actualizar
     * @return Retorna el seguimiento actualizado o NULL si se tiene una excepción
     */
    public Seguimiento update(Seguimiento seguimiento);

    /**
     * Obtiene todos los seguimiento de la tabla seguimiento
     * Si la conexión falla resultará en una excepción
     *
     * @return Retorna todos los seguimiento de
     * la tabla seguimiento o NULL si se tiene una excepción
     */
    public List<Seguimiento> getAll();

    /**
     * Muestra todos los seguimiento que coincidan con el ID ingresado
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param id del seguimiento a obtener
     * @return Retorna los seguimiento coincidentes
     * o NULL si se tiene una excepción
     */
    public List<Seguimiento> show(int id);

    /**
     * Elimina la relación de seguimiento de dos usuarios según su ID
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param idUsuarioSeguidor id del seguidor
     * @param idUsuarioSeguido id del seguido
     * @return Retorna un mensaje de confirmación o un mensaje de error
     * si se tiene una excepción
     */
    public String delete(int idUsuarioSeguidor, int idUsuarioSeguido);

    public boolean yaSigue(int idUsuarioSeguidor, int idUsuarioSeguido);
    public void seguirUsuario(int idUsuarioSeguidor, int idUsuarioSeguido);
}
