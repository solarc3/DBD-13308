package DBD.repositories;
import DBD.models.Valoracion;
import java.util.List;
public interface ValoracionRepository {
    public Valoracion crear(Valoracion valoracion);
    public Valoracion update(Valoracion valoracion);
    public List<Valoracion> getAll();
    public List<Valoracion> show(int id);
    public String delete(int id);
}
