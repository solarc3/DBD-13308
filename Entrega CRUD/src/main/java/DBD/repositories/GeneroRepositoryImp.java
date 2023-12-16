package DBD.repositories;
import DBD.models.Genero;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
@Repository
public class GeneroRepositoryImp implements GeneroRepository{
    @Autowired
    private Sql2o sql2o;
    @Override
    public Genero crear(Genero genero) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO genero (id_genero, nombre_genero) VALUES (:id_genero, :nombre_genero)")
                    .addParameter("id_genero", genero.getID_Genero())
                    .addParameter("nombre_genero", genero.getNombre_Genero())
                    .executeUpdate();
            return genero;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Genero update(Genero genero) {
        try (Connection conn = sql2o.open()) {
            int id = genero.getID_Genero(); //se obtiene ID genero
            conn.createQuery("UPDATE genero SET nombre_genero = :nombre_genero WHERE id_genero = :id")
                    .addParameter("id", id)
                    .addParameter("nombre_genero", genero.getNombre_Genero())
                    .executeUpdate();
            return genero;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Genero> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from genero order by id_genero ASC")
                    .executeAndFetch(Genero.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Genero> show(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from genero where id_genero = :id ")
                    .addParameter("id", id)
                    .executeAndFetch(Genero.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String delete(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from genero where id_genero = :id ")
                    .addParameter("id", id)
                    .executeUpdate();
            return "Genero eliminado";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
