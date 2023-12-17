package DBD.models;

import java.util.Date;

public class Cuenta_Usuario {
    // Atributos
    private int ID_Usuario;
    private String Nombre_Usuario;
    private String Correo;
    private String Contrasena;

    private Date Fecha_Nacimiento;

    // Constructor
    public Cuenta_Usuario(int ID_Usuario, String Nombre_Usuario, String Correo, String Contrasena, Date Fecha_Nacimiento) {
        this.ID_Usuario = ID_Usuario;
        this.Nombre_Usuario = Nombre_Usuario;
        this.Correo = Correo;
        this.Contrasena = Contrasena;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    public Cuenta_Usuario() {
    }

    // Getters
    public int getID_Usuario() {
        return ID_Usuario;
    }

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public Date getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    // Setters

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public void setNombre_Usuario(String Nombre_Usuario) {
        this.Nombre_Usuario = Nombre_Usuario;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public void setFecha_Nacimiento(Date Fecha_Nacimiento) {
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }
}