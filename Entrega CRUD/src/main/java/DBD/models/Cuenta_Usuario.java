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
    public Cuenta_Usuario(int ID_Usuaario, String Nombre_Usuario, String Correo, String Contrasena, Date Fecha_Nacimiento) {
        this.ID_Usuario = ID_Usuaario;
        this.Nombre_Usuario = Nombre_Usuario;
        this.Correo = Correo;
        this.Contrasena = Contrasena;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
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

    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    // Setters

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        Nombre_Usuario = nombre_Usuario;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }

    public void setFecha_Nacimiento(String fecha_Nacimiento) {
        Fecha_Nacimiento = fecha_Nacimiento;
    }
}