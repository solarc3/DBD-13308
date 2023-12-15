package DBD.repositories;
import java.util.List;
import DBD.models.Compra_Juego;
public interface Compra_JuegoRepository {
    public Compra_Juego crear(Compra_Juego compra_juego);
    public Compra_Juego update(Compra_Juego compra_juego);
    public List<Compra_Juego> getAll();
    public List<Compra_Juego> show(int id);
    public String delete(int id);
}
