package DBD.repositories;
import DBD.models.Medio_de_Pago;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
@Repository
public class Medio_de_PagoRepositoryImp implements Medio_de_PagoRepository{
    @Autowired
    private Sql2o sql2o;
    public Medio_de_Pago crear(Medio_de_Pago pago) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Medio_de_Pago (nombre_del_medio, datos_del_medio) VALUES (:nombre, :datos) RETURNING id_pago";
            Integer idPago = (Integer) conn.createQuery(sql, true)
                    .addParameter("nombre", pago.getNombre_del_medio())
                    .addParameter("datos", pago.getDatos_del_medio())
                    .executeUpdate()
                    .getKey();
            pago.setID_pago(idPago);
            return pago;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public Medio_de_Pago update(Medio_de_Pago medio_de_pago) {
        try(Connection conn = sql2o.open()){
            int id = medio_de_pago.getID_pago(); //se obtiene ID medio de pago
            conn.createQuery("UPDATE Medio_de_Pago SET nombre_del_medio = :Nombre_Medio_de_Pago, datos_del_medio = :Datos_Medio_de_Pago WHERE id_pago = :id")
                    .addParameter("id", id)
                    .addParameter("Nombre_Medio_de_Pago", medio_de_pago.getNombre_del_medio())
                    .addParameter("Datos_Medio_de_Pago", medio_de_pago.getDatos_del_medio())
                    .executeUpdate();
            return medio_de_pago;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Medio_de_Pago> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Medio_de_Pago order by id_pago ASC")
                    .executeAndFetch(Medio_de_Pago.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Medio_de_Pago> show(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Medio_de_Pago where id_pago = :id ")
                    .addParameter("id",id)
                    .executeAndFetch(Medio_de_Pago.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String delete(int id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Medio_de_Pago where id_pago = :id ")
                    .addParameter("id",id)
                    .executeUpdate();
            return "Se ha eliminado el medio de pago con id: "+id;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
