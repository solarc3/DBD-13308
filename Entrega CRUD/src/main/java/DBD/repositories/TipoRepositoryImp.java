package DBD.repositories;
import DBD.models.Tipo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
@Repository
public class TipoRepositoryImp implements TipoRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Tipo crear(Tipo tipo) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO tipo (ID_Tipo, Nombre_Tipo) VALUES (:ID_Tipo, :Nombre_Tipo)")
                    .addParameter("ID_Tipo", tipo.getID_Tipo())
                    .addParameter("Nombre_Tipo", tipo.getNombre_Tipo())
                    .executeUpdate();
            return tipo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tipo update(Tipo tipo) {
        try (Connection conn = sql2o.open()) {
            Integer id = tipo.getID_Tipo(); //se obtiene ID tipo
            conn.createQuery("UPDATE tipo SET Nombre_Tipo = :Nombre_Tipo WHERE ID_Tipo = :id")
                    .addParameter("id", id)
                    .addParameter("Nombre_Tipo", tipo.getNombre_Tipo())
                    .executeUpdate();
            return tipo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tipo> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from tipo order by ID_Tipo ASC")
                    .executeAndFetch(Tipo.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tipo> show(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from tipo where ID_Tipo = :id ")
                    .addParameter("id", id)
                    .executeAndFetch(Tipo.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String delete(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from tipo WHERE ID_Tipo = :id")
                    .addParameter("id", id)
                    .executeUpdate();
            return "Se ha eliminado el tipo";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
