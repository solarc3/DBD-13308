package DBD.repositories;
import DBD.models.Boleta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
@Repository
public class BoletaRepositoryImp implements BoletaRepository {
    @Autowired
    private Sql2o sql2o;
    @Override
    public Boleta crear(Boleta boleta) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Boleta (fecha) VALUES (:Fecha) RETURNING id_boleta";
            Integer idBoleta = (Integer) conn.createQuery(sql, true)
                    .addParameter("Fecha", boleta.getFecha())
                    .executeUpdate()
                    .getKey();
            boleta.setID_Boleta(idBoleta);
            return boleta;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public Boleta update(Boleta boleta) {
        try (Connection conn = sql2o.open()){
            int id = boleta.getID_Boleta(); //se obtiene ID boleta
            conn.createQuery("UPDATE boleta SET Fecha = :Fecha WHERE ID_Boleta = :id")
                    .addParameter("id", id)
                    .addParameter("Fecha", boleta.getFecha())
                    .executeUpdate();
            return boleta;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public List<Boleta> getAll(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Boleta order by ID_Boleta ASC")
                    .executeAndFetch(Boleta.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Boleta> show(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from Boleta where ID_Boleta = :id ")
                    .addParameter("id", id)
                    .executeAndFetch(Boleta.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public String delete(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from Boleta where ID_Boleta = :id ")
                    .addParameter("id", id)
                    .executeUpdate();
            return "Boleta eliminada";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error al eliminar Boleta";
        }
    }
}
