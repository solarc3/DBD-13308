package DBD.models;

public class Juego_Genero {
    // Atributos
    private int ID_Juego;
    private int ID_Genero;

    // Constructor
    public Juego_Genero(int ID_Juego, int ID_Genero) {
        this.ID_Juego = ID_Juego;
        this.ID_Genero = ID_Genero;
    }

    // Getters

    public int getID_Juego() {
        return ID_Juego;
    }

    public int getID_Genero() {
        return ID_Genero;
    }

    // Setters

    public void setID_Juego(int ID_Juego) {
        this.ID_Juego = ID_Juego;
    }

    public void setID_Genero(int ID_Genero) {
        this.ID_Genero = ID_Genero;
    }
}
