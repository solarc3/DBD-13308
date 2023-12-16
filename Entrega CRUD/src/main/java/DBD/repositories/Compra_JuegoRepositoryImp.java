package DBD.repositories;
import DBD.models.Compra_Juego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
@Repository
public class Compra_JuegoRepositoryImp implements Compra_JuegoRepository{
    @Autowired
    private Sql2o sql2o;
    @Override
    public Compra_Juego crear(Compra_Juego compra_juego) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Compra_Juego (id_compra, id_juego) VALUES (:id_compra, :id_juego)";
            conn.createQuery(sql)
                    .addParameter("id_compra", compra_juego.getID_Compra())
                    .addParameter("id_juego", compra_juego.getID_Juego())
                    .executeUpdate();
            return compra_juego;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Compra_Juego update(Compra_Juego compra_juego) {
        try (Connection conn = sql2o.open()) {
            int id = compra_juego.getID_Compra(); //se obtiene ID compra
            conn.createQuery("UPDATE Compra_Juego SET id_juego = :id_juego WHERE id_compra = :id")
                    .addParameter("id", id)
                    .addParameter("id_juego", compra_juego.getID_Juego())
                    .executeUpdate();
            return compra_juego;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Compra_Juego> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from Compra_Juego order by id_compra ASC")
                    .executeAndFetch(Compra_Juego.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Compra_Juego> show(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from Compra_Juego where id_compra = :id ")
                    .addParameter("id", id)
                    .executeAndFetch(Compra_Juego.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String delete(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from Compra_Juego where id_compra = :id ")
                    .addParameter("id", id)
                    .executeUpdate();
            return "Se ha eliminado la compra con id: " + id;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
