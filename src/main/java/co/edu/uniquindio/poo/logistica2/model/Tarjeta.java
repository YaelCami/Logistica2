package co.edu.uniquindio.poo.logistica2.model;

public class Tarjeta implements IMetodoPago{

    @Override
    public String pagar(double monto) {
        return "Pago en TARJETA realizado por una cantidad: " + monto;
    }
    @Override
    public String toString() {
        return "Tarjeta";
    }
}
