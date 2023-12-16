package DBD.models;

public class Juego {

    // Atributos
    private int idJuego;
    private String nombreJuego;
    private String descripcion;
    private int precioOriginal;
    private int precioOferta; // Puede ser null
    private int descuento;    // Puede ser null
    private boolean restriccionEdad;
    // Constructor
    /**
     * Constructor Juego
     * @param idJuego id del juego
     * @param nombreJuego nombre del juego
     * @param descripcion descripcion del juego
     * @param precioOriginal precio original del juego
     * @param precioOferta precio del juego en oferta
     * @param descuento descuento del juego
     * @param restriccionEdad restriccion de edad del juego
     */
    public Juego(int idJuego, String nombreJuego, String descripcion, int precioOriginal, Integer precioOferta, Integer descuento, boolean restriccionEdad) {
        this.idJuego = idJuego;
        this.nombreJuego = nombreJuego;
        this.descripcion = descripcion;
        this.precioOriginal = precioOriginal;
        this.precioOferta = precioOferta;
        this.descuento = descuento;
        this.restriccionEdad = restriccionEdad;
    }

    //Getters

    public int getIdJuego() {
        return idJuego;
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecioOriginal() {
        return precioOriginal;
    }

    public int getPrecioOferta() {
        return precioOferta;
    }

    public int getDescuento() {
        return descuento;
    }

    public boolean isRestriccionEdad() {
        return restriccionEdad;
    }

    //Setters

    public void setIDJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioOriginal(int precioOriginal) {
        this.precioOriginal = precioOriginal;
    }

    public void setPrecioOferta(int precioOferta) {
        this.precioOferta = precioOferta;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public void setRestriccionEdad(boolean restriccionEdad) {
        this.restriccionEdad = restriccionEdad;
    }
}