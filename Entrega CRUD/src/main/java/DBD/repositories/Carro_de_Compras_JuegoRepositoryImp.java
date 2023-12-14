package DBD.repositories;
import java.util.List;
import DBD.models.Carro_de_Compras_Juego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
@Repository
public class Carro_de_Compras_JuegoRepositoryImp implements Carro_de_Compras_JuegoRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Carro_de_Compras_Juego crear(Carro_de_Compras_Juego carro_de_compras_juego) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO carro_de_compras_juego (ID_Carro, ID_Juego) VALUES (:ID_Carro, :ID_Juego)")
                    .addParameter("ID_Carro", carro_de_compras_juego.getID_Carro())
                    .addParameter("ID_Juego", carro_de_compras_juego.getID_Juego())
                    .executeUpdate();
            return carro_de_compras_juego;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    @Override
    public Carro_de_Compras_Juego update(Carro_de_Compras_Juego carro_de_compras_juego) {
        try (Connection conn = sql2o.open()) {
            Integer id = carro_de_compras_juego.getID_Carro(); //se obtiene ID carro
            conn.createQuery("UPDATE carro_de_compras_juego SET ID_Juego = :ID_Juego WHERE ID_Carro = :id")
                    .addParameter("id", id)
                    .addParameter("ID_Juego", carro_de_compras_juego.getID_Juego())
                    .executeUpdate();
            return carro_de_compras_juego;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public List<Carro_de_Compras_Juego> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from carro_de_compras_juego order by ID_Carro ASC")
                    .executeAndFetch(Carro_de_Compras_Juego.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public List<Carro_de_Compras_Juego> show(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from carro_de_compras_juego where ID_Carro = :id ")
                    .addParameter("id", id)
                    .executeAndFetch(Carro_de_Compras_Juego.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public String delete(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from carro_de_compras_juego WHERE ID_Carro = :id")
                    .addParameter("id", id)
                    .executeUpdate();
            return "Se ha eliminado el carro de compras con ID: " + id;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
