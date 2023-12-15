package DBD.repositories;
import DBD.models.Medio_de_Pago;
import java.util.List;

public interface Medio_de_PagoRepository {
    public Medio_de_Pago crear(Medio_de_Pago medio_de_pago);
    public Medio_de_Pago update(Medio_de_Pago medio_de_pago);
    public List<Medio_de_Pago> getAll();
    public List<Medio_de_Pago> show(int id);
    public String delete(int id);
}
