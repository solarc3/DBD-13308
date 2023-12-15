package DBD.repositories;
import DBD.models.Juego;
import java.util.List;

public interface JuegoRepository {
    public Juego crear(Juego juego);
    public Juego update(Juego juego);
    public List<Juego> getAll();
    public List<Juego> show(int id);
    public String delete(int id);
}
