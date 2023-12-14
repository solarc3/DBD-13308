package DBD.models;

public class Medio_de_Pago {
    // Atributos
    private int ID_pago;
    private String Nombre_del_medio;
    private String Datos_del_medio;

    // Constructor
    public Medio_de_Pago(int ID_pago, String Nombre_del_medio, String Datos_del_medio) {
        this.ID_pago = ID_pago;
        this.Nombre_del_medio = Nombre_del_medio;
        this.Datos_del_medio = Datos_del_medio;
    }

    // Getters
    public int getID_pago() {
        return ID_pago;
    }

    public String getNombre_del_medio() {
        return Nombre_del_medio;
    }

    public String getDatos_del_medio() {
        return Datos_del_medio;
    }

    // Setters

    public void setID_pago(int ID_pago) {
        this.ID_pago = ID_pago;
    }

    public void setNombre_del_medio(String nombre_del_medio) {
        Nombre_del_medio = nombre_del_medio;
    }

    public void setDatos_del_medio(String datos_del_medio) {
        Datos_del_medio = datos_del_medio;
    }
}
