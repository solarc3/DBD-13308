package DBD.repositories;
import DBD.models.Tipo;
import java.util.List;
public interface TipoRepository {
    public Tipo crear(Tipo tipo);
    public Tipo update(Tipo tipo);
    public List<Tipo> getAll();
    public List<Tipo> show(int id);
    public String delete(int id);
}
