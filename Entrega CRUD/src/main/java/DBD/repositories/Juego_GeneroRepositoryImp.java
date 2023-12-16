package DBD.repositories;
import DBD.models.Juego_Genero;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
@Repository
public class Juego_GeneroRepositoryImp implements Juego_GeneroRepository{
    @Autowired
    private Sql2o sql2o;
    @Override
    public Juego_Genero crear(Juego_Genero juego_genero) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO juego_genero (id_juego, id_genero) VALUES (:id_juego, :id_genero)")
                    .addParameter("id_juego", juego_genero.getID_Juego())
                    .addParameter("id_genero", juego_genero.getID_Genero())
                    .executeUpdate();
            return juego_genero;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Juego_Genero update(Juego_Genero juego_genero) {
        try (Connection conn = sql2o.open()) {
            int id = juego_genero.getID_Juego(); //se obtiene ID juego
            conn.createQuery("UPDATE juego_genero SET id_genero = :id_genero WHERE id_juego = :id")
                    .addParameter("id", id)
                    .addParameter("id_genero", juego_genero.getID_Genero())
                    .executeUpdate();
            return juego_genero;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Juego_Genero> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from juego_genero order by id_juego ASC")
                    .executeAndFetch(Juego_Genero.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Juego_Genero> show(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from juego_genero where id_juego = :id ")
                    .addParameter("id", id)
                    .executeAndFetch(Juego_Genero.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String delete(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from juego_genero WHERE id_juego = :id")
                    .addParameter("id", id)
                    .executeUpdate();
            return "Se ha eliminado el juego_genero con id " + id;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
