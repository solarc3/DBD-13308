package DBD.repositories;
import DBD.models.Boleta;

import java.util.List;


public interface BoletaRepository {
    public Boleta crear(Boleta boleta);
    public Boleta update(Boleta boleta);
    public List<Boleta> getAll();
    public List<Boleta> show(int id);
    public String delete(int id);
}
