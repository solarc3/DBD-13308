package DBD.repositories;
import java.util.List;
import DBD.models.Carro_de_Compras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class Carro_de_ComprasRepositoryImp implements Carro_de_ComprasRepository {
    @Autowired
    private Sql2o sql2o;
    @Override
    public Carro_de_Compras crear(Carro_de_Compras carro_de_compras) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO carro_de_compras (id_Carro, juegos_en_carro, id_Usuario) VALUES (:ID_Carro, :Juegos_en_Carro, :ID_Usuario)")
                    .addParameter("id_Carro", carro_de_compras.getID_Carro())
                    .addParameter("Juegos_en_Carro", carro_de_compras.getJuegos_en_Carro())
                    .addParameter("id_Usuario", carro_de_compras.getID_Usuario())
                    .executeUpdate();
            return carro_de_compras;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public Carro_de_Compras update(Carro_de_Compras carro_de_compras){
        try (Connection conn = sql2o.open()){
            Integer id = carro_de_compras.getID_Carro(); //se obtiene ID carro
            conn.createQuery("UPDATE carro_de_compras SET Juegos_en_Carro = :Juegos_en_Carro, ID_Usuario = :ID_Usuario WHERE ID_Carro = :id")
                    .addParameter("id", id)
                    .addParameter("Juegos_en_Carro", carro_de_compras.getJuegos_en_Carro())
                    .addParameter("ID_Usuario", carro_de_compras.getID_Usuario())
                    .executeUpdate();
            return carro_de_compras;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Carro_de_Compras> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from carro_de_compras order by ID_Carro ASC")
                    .executeAndFetch(Carro_de_Compras.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public List<Carro_de_Compras> show(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from carro_de_compras where ID_Carro = :id ")
                    .addParameter("id", id)
                    .executeAndFetch(Carro_de_Compras.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public String delete(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from carro_de_compras where ID_Carro = :id ")
                    .addParameter("id", id)
                    .executeUpdate();
            return "Carro de compras eliminado";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
