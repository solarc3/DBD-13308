package DBD.repositories;
import DBD.models.Compra;

import java.util.List;

public interface CompraRepository {
    public Compra crear(Compra compra);
    public Compra update(Compra compra);
    public List<Compra> getAll();
    public List<Compra> show(int id);
    public String delete(int id);
}
