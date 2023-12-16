package DBD.repositories;

import DBD.models.Carro_de_Compras;

import java.util.List;

public interface Carro_de_ComprasRepository {
    public Carro_de_Compras crear(Carro_de_Compras carro_de_compras);
    /**
     * Inserta un carro_de_compras en la tabla carro_de_compras
     * Como sus atributos son obligatorios, si uno de estos es NULL o vacios
     * o si la conexión falla resultará en una excepción
     *
     * @param Objeto carro_de_compras de la clase carro_de_compras
     *               con los atributos a ingresar
     * @return Retorna el carro_de_compras creado o NULL si se tiene una excepción
     * @throws Excepción si uno de los atributos es NULL o vacío
     */
    public Carro_de_Compras update(Carro_de_Compras carro_de_compras);
    /**
     * Actualiza un carro_de_compras en la tabla carro_de_compras según su ID
     * Si uno de estos parametros es NULL o vacios o si la conexión falla
     * resultará en una excepción
     *
     * @param Objeto carro_de_compras de la clase carro_de_compras
     *               con los atributos a actualizar
     * @return Retorna el carro_de_compras actualizado o NULL si se tiene una excepción
     * @throws Excepción si uno de los atributos es NULL o vacío
     */
    public List<Carro_de_Compras> getAll();
    /**
     * Obtiene todos los carro_de_compras de la tabla carro_de_compras
     * Si la conexión falla resultará en una excepción
     *
     * @return Retorna todos los carro_de_compras de
     * la tabla carro_de_compras o NULL si se tiene una excepción
     * @throws Excepción si la conexión falla
     */
    public List<Carro_de_Compras> show(int id);
    /**
     * Muestra todos los carro_de_compras que coincidan con el ID ingresado
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param ID del carro_de_compras a obtener
     * @return Retorna los carro_de_compras coincidentes
     * o NULL si se tiene una excepción
     * @throws Excepción si la conexión falla
     */
    public String delete(int id);
    /**
     * Elimina un carro_de_compras de la tabla carro_de_compras según su ID
     * Si el ID es NULL o si la conexión falla resultará en una excepción
     *
     * @param ID del carro_de_compras a eliminar
     * @return Retorna un mensaje de confirmación o un mensaje de error
     * si se tiene una excepción
     * @throws Excepción si la conexión falla o si el ID es NULL
     */
}
