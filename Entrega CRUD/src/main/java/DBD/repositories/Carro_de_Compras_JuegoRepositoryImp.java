package DBD.repositories;
import java.util.List;
import DBD.models.Carro_de_Compras_Juego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
@Repository
public class Carro_de_Compras_JuegoRepositoryImp implements Carro_de_Compras_JuegoRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Carro_de_Compras_Juego crear(Carro_de_Compras_Juego carro_de_compras_juego) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO carro_de_compras_juego (ID_Carro, ID_Juego) VALUES (:ID_Carro, :ID_Juego)")
                    .addParameter("ID_Carro", carro_de_compras_juego.getID_Carro())
                    .addParameter("ID_Juego", carro_de_compras_juego.getID_Juego())
                    .executeUpdate();
            return carro_de_compras_juego;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Carro_de_Compras_Juego update(Carro_de_Compras_Juego carro_de_compras_juego) {
        try (Connection conn = sql2o.open()) {
            int id = carro_de_compras_juego.getID_Carro(); //se obtiene ID carro
            conn.createQuery("UPDATE carro_de_compras_juego SET ID_Juego = :ID_Juego WHERE ID_Carro = :id")
                    .addParameter("id", id)
                    .addParameter("ID_Juego", carro_de_compras_juego.getID_Juego())
                    .executeUpdate();
            return carro_de_compras_juego;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Carro_de_Compras_Juego> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from carro_de_compras_juego order by ID_Carro ASC")
                    .executeAndFetch(Carro_de_Compras_Juego.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Carro_de_Compras_Juego> show(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from carro_de_compras_juego where ID_Carro = :id ")
                    .addParameter("id", id)
                    .executeAndFetch(Carro_de_Compras_Juego.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String delete(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from carro_de_compras_juego WHERE ID_Carro = :id")
                    .addParameter("id", id)
                    .executeUpdate();
            return "Se ha eliminado el carro de compras con ID: " + id;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean existeJuegoEnCarro(int idCarro, int idJuego) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT COUNT(*) FROM carro_de_compras_juego " +
                    "WHERE id_carro = :idCarro AND id_juego = :idJuego";

            int count = conn.createQuery(sql)
                    .addParameter("idCarro", idCarro)
                    .addParameter("idJuego", idJuego)
                    .executeScalar(Integer.class);

            return count > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void agregarJuegoAlCarro(int idCarro, int idJuego) {
        try (Connection conn = sql2o.open()) {
            // Obtener la cantidad actual de juegos en el carro
            String selectSql = "SELECT juegos_en_carro FROM carro_de_compras WHERE id_carro = :idCarro";
            Integer cantidadActual = conn.createQuery(selectSql)
                    .addParameter("idCarro", idCarro)
                    .executeScalar(Integer.class);

            if (cantidadActual == null) {
                cantidadActual = 0;
            }

            // Incrementar la cantidad en 1
            int nuevaCantidad = cantidadActual + 1;

            // Actualizar la cantidad de juegos en el carro
            String updateSql = "UPDATE carro_de_compras SET juegos_en_carro = :nuevaCantidad WHERE id_carro = :idCarro";
            conn.createQuery(updateSql)
                    .addParameter("nuevaCantidad", nuevaCantidad)
                    .addParameter("idCarro", idCarro)
                    .executeUpdate();

            // Insertar el nuevo juego en el carro
            String insertSql = "INSERT INTO carro_de_compras_juego (id_carro, id_juego) VALUES (:idCarro, :idJuego)";
            conn.createQuery(insertSql)
                    .addParameter("idCarro", idCarro)
                    .addParameter("idJuego", idJuego)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al agregar juego al carro: " + e.getMessage());
        }
    }


    @Override
    public void eliminarJuegoDelCarro(int idCarro, int idJuego) {
        try (Connection conn = sql2o.open()) {
            String deleteSql = "DELETE FROM carro_de_compras_juego WHERE id_carro = :idCarro AND id_juego = :idJuego";
            conn.createQuery(deleteSql)
                    .addParameter("idCarro", idCarro)
                    .addParameter("idJuego", idJuego)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar juego del carro: " + e.getMessage());
        }
    }

    @Override
    public void vaciarCarro(int idCarro) {
        try (Connection conn = sql2o.open()) {
            String deleteSql = "DELETE FROM carro_de_compras_juego WHERE id_carro = :idCarro";
            conn.createQuery(deleteSql)
                    .addParameter("idCarro", idCarro)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al vaciar carro: " + e.getMessage());
        }
    }
}
