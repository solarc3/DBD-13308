package DBD.models;

public class Genero {
    // Atributos
    private int ID_Genero;
    private String Nombre_Genero;

    // Constructor
    public Genero(int ID_Genero, String Nombre_Genero) {
        this.ID_Genero = ID_Genero;
        this.Nombre_Genero = Nombre_Genero;
    }

    // Getters
    public int getID_Genero() {
        return ID_Genero;
    }

    public String getNombre_Genero() {
        return Nombre_Genero;
    }

    // Setters

    public void setID_Genero(int ID_Genero) {
        this.ID_Genero = ID_Genero;
    }

    public void setNombre_Genero(String nombre_Genero) {
        Nombre_Genero = nombre_Genero;
    }
}
