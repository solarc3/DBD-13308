package DBD.repositories;
import DBD.models.Juego_Cuenta_Usuario;

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
public class Juego_Cuenta_UsuarioRepositoryImp implements Juego_Cuenta_UsuarioRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Juego_Cuenta_Usuario crear(Juego_Cuenta_Usuario juego_cuenta_usuario) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO juego_cuenta_usuario (id_juego, id_usuario,es_favorito) VALUES (:id_juego, :id_usuario, :es_favorito)")
                    .addParameter("id_juego", juego_cuenta_usuario.getID_Juego())
                    .addParameter("id_usuario", juego_cuenta_usuario.getID_Usuario())
                    .addParameter("es_favorito", juego_cuenta_usuario.isEs_favorito())
                    .executeUpdate();
            return juego_cuenta_usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Juego_Cuenta_Usuario update(Juego_Cuenta_Usuario juego_cuenta_usuario) {
        try (Connection conn = sql2o.open()){
            int id = juego_cuenta_usuario.getID_Juego(); //se obtiene ID juego
            conn.createQuery("UPDATE juego_cuenta_usuario SET id_usuario = :id_usuario, es_favorito = :es_favorito WHERE id_juego = :id")
                    .addParameter("id", id)
                    .addParameter("id_usuario", juego_cuenta_usuario.getID_Usuario())
                    .addParameter("es_favorito", juego_cuenta_usuario.isEs_favorito())
                    .executeUpdate();
            return juego_cuenta_usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Juego_Cuenta_Usuario> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from juego_cuenta_usuario order by id_juego ASC")
                    .executeAndFetch(Juego_Cuenta_Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Juego_Cuenta_Usuario> show(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from juego_cuenta_usuario where id_juego = :id ")
                    .addParameter("id", id)
                    .executeAndFetch(Juego_Cuenta_Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String delete(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from juego_cuenta_usuario where id_juego = :id ")
                    .addParameter("id", id)
                    .executeUpdate();
            return "Juego eliminado";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void agregarJuegoACuenta(int idUsuario, int idJuego) {
    try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO juego_cuenta_usuario (id_juego, id_usuario) VALUES (:id_juego, :id_usuario)")
                    .addParameter("id_juego", idJuego)
                    .addParameter("id_usuario", idUsuario)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Juego_Cuenta_Usuario> getJuegosUsuario(int idUsuario) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from juego_cuenta_usuario where id_usuario = :id ")
                    .addParameter("id", idUsuario)
                    .executeAndFetch(Juego_Cuenta_Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<JsonNode> misFavoritos(int idUsuario) {
        String sql = "select nombre_juego, juego.id_juego from juego_cuenta_usuario join juego on juego_cuenta_usuario.id_juego = juego.id_juego where id_usuario = :idUsuario and es_favorito = true";
        return getJsonNodes(sql, idUsuario);
    }
    private final ObjectMapper objectMapper = new ObjectMapper();
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
