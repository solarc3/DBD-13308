package DBD.models;

public class Juego {

    // Atributos
    private int ID_Juego;
    private String nombre_Juego;
    private String descripcion;
    private int precio_original;
    private int precio_oferta; // Puede ser null
    private int descuento;    // Puede ser null
    private boolean restriccion_edad;
    // Constructor

    public Juego(int id_Juego, String nombreJuego, String descripcion, int precioOriginal, Integer precioOferta, Integer descuento, boolean restriccionEdad) {
        this.ID_Juego = id_Juego;
        this.nombre_Juego = nombreJuego;
        this.descripcion = descripcion;
        this.precio_original = precioOriginal;
        this.precio_oferta = precioOferta;
        this.descuento = descuento;
        this.restriccion_edad = restriccionEdad;
    }

    public Juego() {
    }

    //Getters

    public int getIdJuego() {
        return ID_Juego;
    }

    public String getNombreJuego() {
        return nombre_Juego;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecioOriginal() {
        return precio_original;
    }

    public int getPrecioOferta() {
        return precio_oferta;
    }

    public int getDescuento() {
        return descuento;
    }

    public boolean isRestriccionEdad() {
        return restriccion_edad;
    }

    //Setters

    public void setIDJuego(int idJuego) {
        this.ID_Juego = idJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombre_Juego = nombreJuego;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioOriginal(int precioOriginal) {
        this.precio_original = precioOriginal;
    }

    public void setPrecioOferta(int precioOferta) {
        this.precio_oferta = precioOferta;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public void setRestriccionEdad(boolean restriccionEdad) {
        this.restriccion_edad = restriccionEdad;
    }
}