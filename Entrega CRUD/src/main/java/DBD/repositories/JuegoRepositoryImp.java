package DBD.repositories;
import DBD.models.Juego;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
@Repository
public class JuegoRepositoryImp implements JuegoRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Juego crear(Juego juego) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO juego (id_juego, nombre_juego,descripcion,precio_original,precio_oferta,descuento,restriccion_edad) VALUES (:id_juego, :nombre_juego,:descripcion,:precio_original,:precio_oferta,:descuento,:restriccion_edad)")
                    .addParameter("id_juego", juego.getIdJuego())
                    .addParameter("nombre_juego", juego.getNombreJuego())
                    .addParameter("descripcion", juego.getDescripcion())
                    .addParameter("precio_original", juego.getPrecioOriginal())
                    .addParameter("precio_oferta", juego.getPrecioOferta())
                    .addParameter("descuento", juego.getDescuento())
                    .addParameter("restriccion_edad", juego.isRestriccionEdad())
                    .executeUpdate();
            return juego;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Juego update(Juego juego) {
        try (Connection conn = sql2o.open()) {
            int id = juego.getIdJuego(); //se obtiene ID juego
            conn.createQuery("UPDATE juego SET nombre_juego = :nombre_juego, descripcion = :descripcion, precio_original = :precio_original, precio_oferta = :precio_oferta, descuento = :descuento, restriccion_edad = :restriccion_edad WHERE id_juego = :id")
                    .addParameter("id", id)
                    .addParameter("nombre_juego", juego.getNombreJuego())
                    .addParameter("descripcion", juego.getDescripcion())
                    .addParameter("precio_original", juego.getPrecioOriginal())
                    .addParameter("precio_oferta", juego.getPrecioOferta())
                    .addParameter("descuento", juego.getDescuento())
                    .addParameter("restriccion_edad", juego.isRestriccionEdad())
                    .executeUpdate();
            return juego;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Juego> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from juego order by id_juego ASC")
                    .executeAndFetch(Juego.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Juego> show(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from juego where id_juego = :id ")
                    .addParameter("id", id)
                    .executeAndFetch(Juego.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String delete(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from juego where id_juego = :id ")
                    .addParameter("id", id)
                    .executeUpdate();
            return "Juego eliminado";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
