package DBD.repositories;
import DBD.models.Carro_de_Compras_Juego;
import java.util.List;
public interface Carro_de_Compras_JuegoRepository {
    public Carro_de_Compras_Juego crear(Carro_de_Compras_Juego carro_de_compras_juego);
    public Carro_de_Compras_Juego update(Carro_de_Compras_Juego carro_de_compras_juego);
    public List<Carro_de_Compras_Juego> getAll();
    public List<Carro_de_Compras_Juego> show(int id);
    public String delete(int id);

}
