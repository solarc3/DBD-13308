package DBD.models;

public class Compra {
    // Atributos
    private int ID_Compra;
    private int ID_Boleta;
    private int ID_Carro;
    private int ID_Pago;
    private int Total_Pagado;
    private int Juegos_Comprados;

    // Constructor
    public Compra(int ID_Compra, int ID_Boleta, int ID_Carro, int ID_Pago, int Total_Pagado, int Juegos_Comprados) {
        this.ID_Compra = ID_Compra;
        this.ID_Boleta = ID_Boleta;
        this.ID_Carro = ID_Carro;
        this.ID_Pago = ID_Pago;
        this.Total_Pagado = Total_Pagado;
        this.Juegos_Comprados = Juegos_Comprados;
    }

    public Compra() {
    }

    // Getters
    public int getID_Compra() {
        return ID_Compra;
    }

    public int getID_Boleta() {
        return ID_Boleta;
    }

    public int getID_Carro() {
        return ID_Carro;
    }

    public int getID_Pago() {
        return ID_Pago;
    }

    public int getTotal_Pagado() {
        return Total_Pagado;
    }

    public int getJuegos_Comprados() {
        return Juegos_Comprados;
    }

    // Setters

    public void setID_Compra(int ID_Compra) {
        this.ID_Compra = ID_Compra;
    }

    public void setID_Boleta(int ID_Boleta) {
        this.ID_Boleta = ID_Boleta;
    }

    public void setID_Carro(int ID_Carro) {
        this.ID_Carro = ID_Carro;
    }

    public void setID_Pago(int ID_Pago) {
        this.ID_Pago = ID_Pago;
    }

    public void setTotal_Pagado(int Total_Pagado) {
        this.Total_Pagado = Total_Pagado;
    }

    public void setJuegos_Comprados(int Juegos_Comprados) {
        this.Juegos_Comprados = Juegos_Comprados;
    }
}
