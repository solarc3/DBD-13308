package DBD.repositories;
import DBD.models.Juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    // Requerimiento
    private final ObjectMapper objectMapper = new ObjectMapper();

    private List<JsonNode> getJsonNodes(String sql) {
        try (Connection conn = sql2o.open()) {
            List<Map<String, Object>> results = conn.createQuery(sql)
                    .executeAndFetchTable()
                    .asList();
            return convertToJSON(results);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<JsonNode> ranking() {
        String sql = "SELECT j.id_juego AS idJuego, j.nombre_juego AS nombreJuego, COUNT(cj.id_compra) AS cantidad_Comprados " +
                "FROM juego j " +
                "JOIN compra_juego cj ON j.id_juego = cj.id_juego " +
                "GROUP BY j.id_juego, j.nombre_juego " +
                "ORDER BY cantidad_Comprados DESC";

        return getJsonNodes(sql);
    }
    @Override
    public List<JsonNode> rankingFavoritos() {
        String sql = "SELECT j.id_juego, j.nombre_juego, COUNT(jcu.id_usuario) AS cantidad_favoritos " +
                "FROM juego_cuenta_usuario jcu " +
                "JOIN juego j ON jcu.id_juego = j.id_juego " +
                "WHERE jcu.es_favorito = true " +
                "GROUP BY j.id_juego, j.nombre_juego " +
                "ORDER BY cantidad_favoritos DESC";

        return getJsonNodes(sql);
    }

    private List<JsonNode> convertToJSON(List<Map<String, Object>> results) {
        List<JsonNode> jsonResults = new ArrayList<>();
        for (Map<String, Object> row : results) {
            jsonResults.add(objectMapper.valueToTree(row));
        }
        return jsonResults;
    }
    // REQUERIMIENTO CARRO DE COMPRAS Y SIMULACION DE PAGO

}
