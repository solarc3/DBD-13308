package DBD.repositories;
import DBD.models.Genero;
import java.util.List;
public interface GeneroRepository {
    public Genero crear(Genero genero);
    public Genero update(Genero genero);
    public List<Genero> getAll();
    public List<Genero> show(int id);
    public String delete(int id);
}
