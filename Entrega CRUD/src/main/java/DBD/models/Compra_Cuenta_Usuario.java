package DBD.models;

public class Compra_Cuenta_Usuario {
    // Atributos
    private int ID_Compra;
    private int ID_Usuario;

    // Constructor
    public Compra_Cuenta_Usuario(int ID_Compra, int ID_Usuario) {
        this.ID_Compra = ID_Compra;
        this.ID_Usuario = ID_Usuario;
    }

    // Getters

    public int getID_Compra() {
        return ID_Compra;
    }

    public int getID_Cuenta_Usuario() {
        return ID_Usuario;
    }

    // Setters

    public void setID_Compra(int ID_Compra) {
        this.ID_Compra = ID_Compra;
    }

    public void setID_Cuenta_Usuario(int ID_Cuenta_Usuario) {
        this.ID_Usuario = ID_Cuenta_Usuario;
    }
}
