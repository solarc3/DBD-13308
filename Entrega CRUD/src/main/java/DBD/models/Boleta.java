package DBD.models;

public class Boleta {
    // Atributos
    private int ID_Boleta;
    private String Detalle;

    // Constructor
    public Boleta(int ID_Boleta, String Detalle) {
        this.ID_Boleta = ID_Boleta;
        this.Detalle = Detalle;
    }

    // Getters
    public int getID_Boleta() {
        return ID_Boleta;
    }

    public String getDetalle() {
        return Detalle;
    }

    // Setters

    public void setID_Boleta(int ID_Boleta) {
        this.ID_Boleta = ID_Boleta;
    }

    public void setDetalle(String detalle) {
        Detalle = detalle;
    }
}
