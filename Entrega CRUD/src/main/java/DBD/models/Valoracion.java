package DBD.models;

public class Valoracion {
    // Atributos
    private int ID_Valoracion;
    private int Puntuacion;
    private int ID_Juego;

    // Constructor

    public Valoracion(int ID_Valoracion, int Puntuacion, int ID_Juego) {
        this.ID_Valoracion = ID_Valoracion;
        this.Puntuacion = Puntuacion;
        this.ID_Juego = ID_Juego;
    }

    // Getters

    public int getID_Valoracion() {
        return ID_Valoracion;
    }

    public int getPuntuacion() {
        return Puntuacion;
    }

    public int getID_Juego() {
        return ID_Juego;
    }

    // Setters

    public void setID_Valoracion(int ID_Valoracion) {
        this.ID_Valoracion = ID_Valoracion;
    }

    public void setPuntuacion(int puntuacion) {
        Puntuacion = puntuacion;
    }

    public void setID_Juego(int ID_Juego) {
        this.ID_Juego = ID_Juego;
    }
}
