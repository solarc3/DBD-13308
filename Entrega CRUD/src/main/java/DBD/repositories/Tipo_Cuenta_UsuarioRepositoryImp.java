package DBD.repositories;
import DBD.models.Tipo_Cuenta_Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
@Repository
public class Tipo_Cuenta_UsuarioRepositoryImp implements Tipo_Cuenta_UsuarioRepository{
    @Autowired
    private Sql2o sql2o;
    @Override
    public Tipo_Cuenta_Usuario crear(Tipo_Cuenta_Usuario tipo_cuenta_usuario) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO tipo_cuenta_usuario (id_tipo, id_usuario) VALUES (:id_tipo, :id_usuario)")
                    .addParameter("id_tipo", tipo_cuenta_usuario.getID_Tipo())
                    .addParameter("id_usuario", tipo_cuenta_usuario.getID_Usuario())
                    .executeUpdate();
            return tipo_cuenta_usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tipo_Cuenta_Usuario update(Tipo_Cuenta_Usuario tipo_cuenta_usuario) {
        try (Connection conn = sql2o.open()) {
            Integer id = tipo_cuenta_usuario.getID_Tipo(); //se obtiene ID tipo
            conn.createQuery("UPDATE tipo_cuenta_usuario SET id_usuario = :id_usuario WHERE id_tipo = :id")
                    .addParameter("id", id)
                    .addParameter("id_usuario", tipo_cuenta_usuario.getID_Usuario())
                    .executeUpdate();
            return tipo_cuenta_usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String delete(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM tipo_cuenta_usuario WHERE id_tipo = :id")
                    .addParameter("id", id)
                    .executeUpdate();
            return "Se ha eliminado el tipo de cuenta";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tipo_Cuenta_Usuario show(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from tipo_cuenta_usuario where id_tipo = :id ")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Tipo_Cuenta_Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tipo_Cuenta_Usuario showByNombre(String nombre) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from tipo_cuenta_usuario where nombre = :nombre ")
                    .addParameter("nombre", nombre)
                    .executeAndFetchFirst(Tipo_Cuenta_Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
