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
    // Getters

    /**
     * Retorna el id del juego
     * @return id del juego
     */
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

    public Integer getPrecioOferta() {
        return precioOferta;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public boolean isRestriccionEdad() {
        return restriccionEdad;
    }
    // Setters

    /**
     * Setea el id del juego
     * @param idJuego id del juego
     */
    public void setIdJuego(int idJuego) {
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

    public void setPrecioOferta(Integer precioOferta) {
        this.precioOferta = precioOferta;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public void setRestriccionEdad(boolean restriccionEdad) {
        this.restriccionEdad = restriccionEdad;
    }
}