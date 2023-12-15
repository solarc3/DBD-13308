package DBD.repositories;
import DBD.models.Seguimiento;
import java.util.List;

public interface SeguimientoRepository {
    public Seguimiento crear(Seguimiento seguimiento);
    public Seguimiento update(Seguimiento seguimiento);
    public List<Seguimiento> getAll();
    public List<Seguimiento> show(int id);
    public String delete(int id);
}
