package DBD.models;

public class Seguimiento {
    //Atributos
    private int ID_Usuario_Seguidor;
    private int ID_Usuario_Seguido;
    //Constructor
    public Seguimiento(int ID_Usuario_Seguidor, int ID_Usuario_Seguido) {
        this.ID_Usuario_Seguidor = ID_Usuario_Seguidor;
        this.ID_Usuario_Seguido = ID_Usuario_Seguido;
    }
    //Getters

    public int getID_Usuario_Seguidor() {
        return ID_Usuario_Seguidor;
    }

    public int getID_Usuario_Seguido() {
        return ID_Usuario_Seguido;
    }

    //Setters

    public void setID_Usuario_Seguidor(int ID_Usuario_Seguidor) {
        this.ID_Usuario_Seguidor = ID_Usuario_Seguidor;
    }

    public void setID_Usuario_Seguido(int ID_Usuario_Seguido) {
        this.ID_Usuario_Seguido = ID_Usuario_Seguido;
    }
}
