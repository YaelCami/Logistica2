package co.edu.uniquindio.poo.logistica2.model;

public class Nequi implements IMetodoPago {
    @Override
    public String pagar(double monto) {
        return "Pago en NEQUI realizado por una cantidad: " + monto;
    }
}
