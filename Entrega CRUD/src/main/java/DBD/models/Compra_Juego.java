package DBD.models;

public class Compra_Juego {
    // Atributos
    private int ID_Compra;
    private int ID_Juego;

    // Constructor
    public Compra_Juego(int ID_Compra, int ID_Juego) {
        this.ID_Compra = ID_Compra;
        this.ID_Juego = ID_Juego;
    }

    public Compra_Juego() {
    }

    // Getters

    public int getID_Compra() {
        return ID_Compra;
    }

    public int getID_Juego() {
        return ID_Juego;
    }

    // Setters

    public void setID_Compra(int ID_Compra) {
        this.ID_Compra = ID_Compra;
    }

    public void setID_Juego(int ID_Juego) {
        this.ID_Juego = ID_Juego;
    }
}
