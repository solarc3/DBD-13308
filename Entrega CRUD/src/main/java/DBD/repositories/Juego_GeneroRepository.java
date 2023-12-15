package DBD.repositories;
import DBD.models.Juego_Genero;
import java.util.List;

public interface Juego_GeneroRepository {
    public Juego_Genero crear(Juego_Genero juego_genero);
    public Juego_Genero update(Juego_Genero juego_genero);
    public List<Juego_Genero> getAll();
    public List<Juego_Genero> show(int id);
    public String delete(int id);
}
