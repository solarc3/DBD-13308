package DBD.repositories;
import DBD.models.Seguimiento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
@Repository
public class SeguimientoRepositoryImp implements SeguimientoRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Seguimiento crear(Seguimiento seguimiento) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO seguimiento (id_usuario_seguidor, id_usuario_seguido) VALUES (:id_usuario_seguidor, :id_usuario_seguido)")
                    .addParameter("id_usuario_seguidor", seguimiento.getID_Usuario_Seguidor())
                    .addParameter("id_usuario_seguido", seguimiento.getID_Usuario_Seguido())
                    .executeUpdate();
            return seguimiento;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Seguimiento update(Seguimiento seguimiento) {
        try (Connection conn = sql2o.open()) {
            int id = seguimiento.getID_Usuario_Seguidor(); //se obtiene ID usuario seguidor
            conn.createQuery("UPDATE seguimiento SET id_usuario_seguido = :id_usuario_seguido WHERE id_usuario_seguidor = :id")
                    .addParameter("id", id)
                    .addParameter("id_usuario_seguido", seguimiento.getID_Usuario_Seguido())
                    .executeUpdate();
            return seguimiento;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Seguimiento> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from seguimiento order by id_usuario_seguidor ASC")
                    .executeAndFetch(Seguimiento.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Seguimiento> show(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from seguimiento where id_usuario_seguidor = :id ")
                    .addParameter("id", id)
                    .executeAndFetch(Seguimiento.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String delete(int idUsuarioSeguidor, int idUsuarioSeguido) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM seguimiento WHERE id_usuario_seguidor = :id_usuario_seguidor AND id_usuario_seguido = :id_usuario_seguido")
                    .addParameter("id_usuario_seguidor", idUsuarioSeguidor)
                    .addParameter("id_usuario_seguido", idUsuarioSeguido)
                    .executeUpdate();
            return "Relacion de seguimiento eliminada";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean yaSigue(int idUsuarioSeguidor, int idUsuarioSeguido) {
        try (Connection conn = sql2o.open()) {
            List<Seguimiento> lista = conn.createQuery("select * from seguimiento where id_usuario_seguidor = :id_usuario_seguidor AND id_usuario_seguido = :id_usuario_seguido ")
                    .addParameter("id_usuario_seguidor", idUsuarioSeguidor)
                    .addParameter("id_usuario_seguido", idUsuarioSeguido)
                    .executeAndFetch(Seguimiento.class);
            return !lista.isEmpty();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void seguirUsuario(int idUsuarioSeguidor, int idUsuarioSeguido) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO seguimiento (id_usuario_seguidor, id_usuario_seguido) VALUES (:id_usuario_seguidor, :id_usuario_seguido)")
                    .addParameter("id_usuario_seguidor", idUsuarioSeguidor)
                    .addParameter("id_usuario_seguido", idUsuarioSeguido)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
