package DBD.repositories;
import DBD.models.Valoracion_Cuenta_Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
@Repository
public class Valoracion_Cuenta_UsuarioRepositoryImp implements Valoracion_Cuenta_UsuarioRepository{
    @Autowired
    private Sql2o sql2o;
    @Override
    public Valoracion_Cuenta_Usuario crear(Valoracion_Cuenta_Usuario valoracion_cuenta_usuario) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO valoracion_cuenta_usuario (id_usuario, id_valoracion) VALUES (:id_usuario, :id_valoracion)")
                    .addParameter("id_usuario", valoracion_cuenta_usuario.getID_Usuario())
                    .addParameter("id_valoracion", valoracion_cuenta_usuario.getID_Valoracion())
                    .executeUpdate();
            return valoracion_cuenta_usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Valoracion_Cuenta_Usuario update(Valoracion_Cuenta_Usuario valoracion_cuenta_usuario) {
        try (Connection conn = sql2o.open()) {
            Integer id = valoracion_cuenta_usuario.getID_Usuario(); //se obtiene ID usuario
            conn.createQuery("UPDATE valoracion_cuenta_usuario SET id_valoracion = :id_valoracion WHERE id_usuario = :id")
                    .addParameter("id", id)
                    .addParameter("id_valoracion", valoracion_cuenta_usuario.getID_Valoracion())
                    .executeUpdate();
            return valoracion_cuenta_usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Valoracion_Cuenta_Usuario> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from valoracion_cuenta_usuario order by id_usuario ASC")
                    .executeAndFetch(Valoracion_Cuenta_Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Valoracion_Cuenta_Usuario> show(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from valoracion_cuenta_usuario where id_usuario = :id ")
                    .addParameter("id", id)
                    .executeAndFetch(Valoracion_Cuenta_Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String delete(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from valoracion_cuenta_usuario WHERE id_usuario = :id")
                    .addParameter("id", id)
                    .executeUpdate();
            return "Se ha eliminado la valoracion de la cuenta de usuario";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
