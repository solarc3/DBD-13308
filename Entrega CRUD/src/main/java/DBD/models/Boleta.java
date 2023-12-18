package DBD.models;

import java.time.LocalDate;
import java.util.Date;

public class Boleta {
    // Atributos
    private int ID_Boleta;
    private Date Fecha;

    // Constructor
    public Boleta(int ID_Boleta, Date Fecha) {
        this.ID_Boleta = ID_Boleta;
        this.Fecha = Fecha;
    }
    public Boleta() {
    }

    // Getters

    public int getID_Boleta() {
        return ID_Boleta;
    }

    public Date getFecha() {
        return Fecha;
    }

    // Setters

    public void setID_Boleta(int ID_Boleta) {
        this.ID_Boleta = ID_Boleta;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
}
