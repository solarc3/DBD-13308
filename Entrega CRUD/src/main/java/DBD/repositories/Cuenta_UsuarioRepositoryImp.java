package DBD.repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import DBD.models.Cuenta_Usuario;
import java.util.List;
@Repository
public class Cuenta_UsuarioRepositoryImp implements Cuenta_UsuarioRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Cuenta_Usuario crear(Cuenta_Usuario cuenta_usuario) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO cuenta_usuario (id_usuario, nombre_usuario,correo,contrasena,fecha_nacimiento) VALUES (:id_usuario, :nombre_usuario,:correo,:contrasena,:fecha_nacimiento)")
                    .addParameter("id_usuario", cuenta_usuario.getID_Usuario())
                    .addParameter("nombre_usuario", cuenta_usuario.getNombre_Usuario())
                    .addParameter("correo", cuenta_usuario.getCorreo())
                    .addParameter("contrasena", cuenta_usuario.getContrasena())
                    .addParameter("fecha_nacimiento", cuenta_usuario.getFecha_Nacimiento())
                    .executeUpdate();
            return cuenta_usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Cuenta_Usuario update(Cuenta_Usuario cuenta_usuario) {
        try (Connection conn = sql2o.open()) {
            int id = cuenta_usuario.getID_Usuario(); //se obtiene ID usuario
            conn.createQuery("UPDATE cuenta_usuario SET nombre_usuario = :nombre_usuario, correo = :correo, contrasena = :contrasena, fecha_nacimiento = :fecha_nacimiento WHERE id_usuario = :id")
                    .addParameter("id", id)
                    .addParameter("nombre_usuario", cuenta_usuario.getNombre_Usuario())
                    .addParameter("correo", cuenta_usuario.getCorreo())
                    .addParameter("contrasena", cuenta_usuario.getContrasena())
                    .addParameter("fecha_nacimiento", cuenta_usuario.getFecha_Nacimiento())
                    .executeUpdate();
            return cuenta_usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Cuenta_Usuario> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from cuenta_usuario order by id_usuario ASC")
                    .executeAndFetch(Cuenta_Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Cuenta_Usuario> show(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from cuenta_usuario where id_usuario = :id ")
                    .addParameter("id", id)
                    .executeAndFetch(Cuenta_Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String delete(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from cuenta_usuario where id_usuario = :id ")
                    .addParameter("id", id)
                    .executeUpdate();
            return "Cuenta de usuario eliminada";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //si es que lo encuentra, retornar tipo Cuenta_Usuario, si no, retornar null
    @Override
    public Cuenta_Usuario findbyEmail(String email) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from cuenta_usuario where correo = :email ")
                    .addParameter("email", email)
                    .executeAndFetchFirst(Cuenta_Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Cuenta_Usuario findByEmailAndUsername(String email, String username) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from cuenta_usuario where correo = :email and nombre_usuario = :username")
                    .addParameter("email", email)
                    .addParameter("username", username)
                    .executeAndFetchFirst(Cuenta_Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
