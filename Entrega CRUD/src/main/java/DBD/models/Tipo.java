package DBD.models;

public class Tipo {
    // Atributos
    private int ID_Tipo;
    private String Nombre_Tipo;
    // Constructor

    public Tipo(int ID_Tipo, String Nombre_Tipo) {
        this.ID_Tipo = ID_Tipo;
        this.Nombre_Tipo = Nombre_Tipo;
    }
    // Getters
    public int getID_Tipo() {
        return ID_Tipo;
    }

    public String getNombre_Tipo() {
        return Nombre_Tipo;
    }
    // Setters
    public void setID_Tipo(int ID_Tipo) {
        this.ID_Tipo = ID_Tipo;
    }
    public void setNombre_Tipo(String nombre_Tipo) {
        this.Nombre_Tipo = nombre_Tipo;
    }
}
