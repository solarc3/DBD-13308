package DBD.repositories;
import DBD.models.Valoracion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
@Repository
public class ValoracionRepositoryImp implements ValoracionRepository{
    @Autowired
    private Sql2o sql2o;
    @Override
    public Valoracion crear(Valoracion valoracion) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO valoracion (id_valoracion, puntuacion, id_juego) VALUES (:id_valoracion, :puntuacion, :id_juego)")
                    .addParameter("id_valoracion", valoracion.getID_Valoracion())
                    .addParameter("puntuacion", valoracion.getPuntuacion())
                    .addParameter("id_juego", valoracion.getID_Juego())
                    .executeUpdate();
            return valoracion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public Valoracion update(Valoracion valoracion) {
        try (Connection conn = sql2o.open()) {
            Integer id = valoracion.getID_Valoracion(); //se obtiene ID valoracion
            conn.createQuery("UPDATE valoracion SET puntuacion = :puntuacion, id_juego = :id_juego WHERE id_valoracion = :id")
                    .addParameter("id", id)
                    .addParameter("puntuacion", valoracion.getPuntuacion())
                    .addParameter("id_juego", valoracion.getID_Juego())
                    .executeUpdate();
            return valoracion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public List<Valoracion> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from valoracion order by id_valoracion ASC")
                    .executeAndFetch(Valoracion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Valoracion> show(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from valoracion where id_valoracion = :id ")
                    .addParameter("id", id)
                    .executeAndFetch(Valoracion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String delete(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from valoracion WHERE id_valoracion = :id")
                    .addParameter("id", id)
                    .executeUpdate();
            return "Se ha eliminado la valoracion";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
