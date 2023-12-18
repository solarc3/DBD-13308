package DBD.repositories;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import DBD.models.Carro_de_Compras;
import DBD.models.Juego;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
            String insertSql = "INSERT INTO carro_de_compras (juegos_en_carro, id_Usuario) VALUES (:Juegos_en_Carro, :ID_Usuario)";

            int idGenerado = (int) conn.createQuery(insertSql, true)
                    .addParameter("Juegos_en_Carro", carro_de_compras.getJuegos_en_Carro())
                    .addParameter("ID_Usuario", carro_de_compras.getID_Usuario())
                    .executeUpdate()
                    .getKey();
            carro_de_compras.setID_Carro(idGenerado);

            return carro_de_compras;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Carro_de_Compras update(Carro_de_Compras carro_de_compras){
        try (Connection conn = sql2o.open()){
            int id = carro_de_compras.getID_Carro(); //se obtiene ID carro
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
    @Override
    public Carro_de_Compras existByUser(int id_usuario) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from carro_de_compras where ID_Usuario = :id_usuario")
                    .addParameter("id_usuario", id_usuario)
                    .executeAndFetchFirst(Carro_de_Compras.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public List<JsonNode> obtenerJuegosEnCarro(int idUsuario) {
        String sql = "SELECT j.id_juego AS id_juego, j.nombre_juego AS nombre_juego, " +
                "j.precio_original AS precio_original, j.precio_oferta AS precio_oferta " +
                "FROM juego j " +
                "JOIN carro_de_compras_juego ccj ON j.id_juego = ccj.id_juego " +
                "JOIN carro_de_compras cc ON ccj.id_carro = cc.id_carro " +
                "WHERE cc.id_usuario = :idUsuario";
        return getJsonNodes(sql, idUsuario);
    }
    private List<JsonNode> getJsonNodes(String sql, int idUsuario) {
        try (Connection conn = sql2o.open()) {
            List<Map<String, Object>> results = conn.createQuery(sql)
                    .addParameter("idUsuario", idUsuario)
                    .executeAndFetchTable()
                    .asList();
            return convertToJSON(results);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
    private List<JsonNode> convertToJSON(List<Map<String, Object>> results) {
        List<JsonNode> jsonResults = new ArrayList<>();
        for (Map<String, Object> row : results) {
            jsonResults.add(objectMapper.valueToTree(row));
        }
        return jsonResults;
    }
}
