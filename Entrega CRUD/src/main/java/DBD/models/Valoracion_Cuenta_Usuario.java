package DBD.models;

public class Valoracion_Cuenta_Usuario {
    // Atributos
    private int ID_Usuario;
    private int ID_Valoracion;

    // Constructor

    public Valoracion_Cuenta_Usuario(int ID_Usuario, int ID_Valoracion) {
        this.ID_Usuario = ID_Usuario;
        this.ID_Valoracion = ID_Valoracion;
    }

    public Valoracion_Cuenta_Usuario() {
    }
    // Getters

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public int getID_Valoracion() {
        return ID_Valoracion;
    }

    // Setters

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public void setID_Valoracion(int ID_Valoracion) {
        this.ID_Valoracion = ID_Valoracion;
    }
}