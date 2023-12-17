package DBD.models;

public class Tipo_Cuenta_Usuario {
    // Atributos
    private int ID_Tipo;
    private int ID_Usuario;

    // Constructor
    public Tipo_Cuenta_Usuario(int ID_Tipo, int ID_Usuario) {
        this.ID_Tipo = ID_Tipo;
        this.ID_Usuario = ID_Usuario;
    }

    public Tipo_Cuenta_Usuario() {
    }

    // Getters

    public int getID_Tipo() {
        return ID_Tipo;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    // Setters

    public void setID_Tipo(int ID_Tipo) {
        this.ID_Tipo = ID_Tipo;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }
}
