package DBD.models;

public class Carro_de_Compras {
    // Atributos
    private int ID_Carro;
    private int Juegos_en_Carro;
    private int ID_Usuario;

    // Constructor
    public Carro_de_Compras(int ID_Carro, int Juegos_en_Carro, int ID_Usuario) {
        this.ID_Carro = ID_Carro;
        this.Juegos_en_Carro = Juegos_en_Carro;
        this.ID_Usuario = ID_Usuario;
    }
    public Carro_de_Compras() {
    }

    // Getters

    public int getID_Carro() {
        return ID_Carro;
    }

    public int getJuegos_en_Carro() {
        return Juegos_en_Carro;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    // Setters

    public void setID_Carro(int ID_Carro) {
        this.ID_Carro = ID_Carro;
    }

    public void setJuegos_en_Carro(int Juegos_en_Carro) {
        this.Juegos_en_Carro = Juegos_en_Carro;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

}
