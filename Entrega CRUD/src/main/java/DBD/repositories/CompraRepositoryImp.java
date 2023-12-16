package DBD.repositories;
import DBD.models.Compra;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
@Repository
public class CompraRepositoryImp implements CompraRepository{
    @Autowired
    private Sql2o sql2o;
    @Override
    public Compra crear(Compra compra) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Compra (id_compra, total_pagado, juegos_comprados, id_pago, id_boleta, id_carro) VALUES(:id_compra, :total_pagado, :juegos_comprados, :id_pago, :id_boleta, :id_carro)";
            conn.createQuery(sql)
                    .addParameter("id_compra", compra.getID_Compra())
                    .addParameter("total_pagado", compra.getTotal_Pagado())
                    .addParameter("juegos_comprados", compra.getJuegos_Comprados())
                    .addParameter("id_pago", compra.getID_Pago())
                    .addParameter("id_boleta", compra.getID_Boleta())
                    .addParameter("id_carro", compra.getID_Carro())
                    .executeUpdate();
            return compra;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Compra update(Compra compra) {
        try (Connection conn = sql2o.open()) {
            int id = compra.getID_Compra(); //se obtiene ID compra
            conn.createQuery("UPDATE Compra SET total_pagado = :total_pagado, juegos_comprados = :juegos_comprados, id_pago = :id_pago, id_boleta = :id_boleta, id_carro = :id_carro WHERE id_compra = :id")
                    .addParameter("id", id)
                    .addParameter("total_pagado", compra.getTotal_Pagado())
                    .addParameter("juegos_comprados", compra.getJuegos_Comprados())
                    .addParameter("id_pago", compra.getID_Pago())
                    .addParameter("id_boleta", compra.getID_Boleta())
                    .addParameter("id_carro", compra.getID_Carro())
                    .executeUpdate();
            return compra;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Compra> getAll(){
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from Compra order by id_compra ASC")
                    .executeAndFetch(Compra.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Compra> show(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from Compra where id_compra = :id ")
                    .addParameter("id", id)
                    .executeAndFetch(Compra.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String delete(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from Compra where id_compra = :id ")
                    .addParameter("id", id)
                    .executeUpdate();
            return "Compra eliminada";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
