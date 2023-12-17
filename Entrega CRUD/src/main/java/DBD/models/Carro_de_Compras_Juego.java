package DBD.models;

public class Carro_de_Compras_Juego {
    // Atributos
    private int ID_Carro;
    private int ID_Juego;

    // Constructor

    public Carro_de_Compras_Juego(int ID_Carro, int ID_Juego) {
        this.ID_Carro = ID_Carro;
        this.ID_Juego = ID_Juego;
    }

    public Carro_de_Compras_Juego() {
    }

    // Getters

    public int getID_Carro() {
        return ID_Carro;
    }

    public int getID_Juego() {
        return ID_Juego;
    }

    // Setters

    public void setID_Carro(int ID_Carro) {
        this.ID_Carro = ID_Carro;
    }

    public void setID_Juego(int ID_Juego) {
        this.ID_Juego = ID_Juego;
    }
}
