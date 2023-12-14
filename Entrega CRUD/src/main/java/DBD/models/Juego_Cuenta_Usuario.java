package DBD.models;

public class Juego_Cuenta_Usuario {
    // Atributos
    private int ID_Juego;
    private int ID_Usuario;
    private Boolean Es_favorito;

    // Constructor
    public Juego_Cuenta_Usuario(int ID_Juego, int ID_Usuario, Boolean Es_favorito) {
        this.ID_Juego = ID_Juego;
        this.ID_Usuario = ID_Usuario;
        this.Es_favorito = Es_favorito;
    }

    // Getters

    public int getID_Juego() {
        return ID_Juego;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public Boolean getEs_favorito() {
        return Es_favorito;
    }

    // Setters

    public void setID_Juego(int ID_Juego) {
        this.ID_Juego = ID_Juego;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public void setEs_favorito(Boolean Es_favorito) {
        this.Es_favorito = Es_favorito;
    }

}
