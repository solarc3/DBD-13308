package DBD.repositories;

import DBD.models.Carro_de_Compras;

import java.util.List;

public interface Carro_de_ComprasRepository {
    public Carro_de_Compras crear(Carro_de_Compras carro_de_compras);
    public Carro_de_Compras update(Carro_de_Compras carro_de_compras);
    public List<Carro_de_Compras> getAll();
    public List<Carro_de_Compras> show(int id);
    public String delete(int id);
}
