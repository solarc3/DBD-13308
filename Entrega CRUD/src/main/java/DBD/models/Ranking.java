package DBD.models;

public class Ranking {
    // Atributos
    private int ID_Ranking;
    private int ID_Juego;
    private int Cantidad_Comprados;
    private int Cantidad_Favoritos;

    // Constructor
    public Ranking(int ID_Ranking, int ID_Juego, int Cantidad_Comprados, int Cantidad_Favoritos) {
        this.ID_Ranking = ID_Ranking;
        this.ID_Juego = ID_Juego;
        this.Cantidad_Comprados = Cantidad_Comprados;
        this.Cantidad_Favoritos = Cantidad_Favoritos;
    }
    // Getters
    public int getID_Ranking() {
        return ID_Ranking;
    }

    public int getID_Juego() {
        return ID_Juego;
    }

    public int getCantidad_Comprados() {
        return Cantidad_Comprados;
    }

    public int getCantidad_Favoritos() {
        return Cantidad_Favoritos;
    }

    // Setters

    public void setID_Ranking(int ID_Ranking) {
        this.ID_Ranking = ID_Ranking;
    }

    public void setID_Juego(int ID_Juego) {
        this.ID_Juego = ID_Juego;
    }

    public void setCantidad_Comprados(int Cantidad_Comprados) {
        this.Cantidad_Comprados = Cantidad_Comprados;
    }

    public void setCantidad_Favoritos(int Cantidad_Favoritos) {
        this.Cantidad_Favoritos = Cantidad_Favoritos;
    }

}
