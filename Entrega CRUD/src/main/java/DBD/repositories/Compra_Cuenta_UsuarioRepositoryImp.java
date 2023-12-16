package DBD.repositories;
import DBD.models.Compra_Cuenta_Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Compra_Cuenta_UsuarioRepositoryImp implements Compra_Cuenta_UsuarioRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Compra_Cuenta_Usuario crear(Compra_Cuenta_Usuario compra_cuenta_usuario) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Compra_Cuenta_Usuario (id_compra, id_usuario) VALUES (:id_compra, :id_usuario)";
            conn.createQuery(sql)
                    .addParameter("id_compra", compra_cuenta_usuario.getID_Compra())
                    .addParameter("id_usuario", compra_cuenta_usuario.getID_Usuario())
                    .executeUpdate();
            return compra_cuenta_usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Compra_Cuenta_Usuario update(Compra_Cuenta_Usuario compra_cuenta_usuario) {
        try (Connection conn = sql2o.open()) {
            int id = compra_cuenta_usuario.getID_Compra(); //se obtiene ID compra
            conn.createQuery("UPDATE Compra_Cuenta_Usuario SET id_usuario = :id_usuario WHERE id_compra = :id")
                    .addParameter("id", id)
                    .addParameter("id_usuario", compra_cuenta_usuario.getID_Usuario())
                    .executeUpdate();
            return compra_cuenta_usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Compra_Cuenta_Usuario> getAll(){
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from Compra_Cuenta_Usuario order by id_compra ASC")
                    .executeAndFetch(Compra_Cuenta_Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Compra_Cuenta_Usuario> show(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from Compra_Cuenta_Usuario where id_compra = :id ")
                    .addParameter("id", id)
                    .executeAndFetch(Compra_Cuenta_Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public String delete(int id) {
    try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from Compra_Cuenta_Usuario where id_compra = :id ")
                    .addParameter("id", id)
                    .executeUpdate();
            return "Compra_Cuenta_Usuario eliminado";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
