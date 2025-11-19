package co.edu.uniquindio.poo.logistica2.model;

public class Nequi implements IMetodoPago {
    /**
     * Realiza un pago usando la plataforma Nequi.
     *
     * @param monto Monto total a pagar.
     * @return Mensaje confirmando que el pago se realizó correctamente.
     */
    @Override
    public String pagar(double monto) {
        return "Pago en NEQUI realizado por una cantidad: " + monto;
    }
    /**
     * Representación en texto del método de pago.
     *
     * @return Nombre del método de pago.
     */
    @Override
    public String toString() {
        return "Nequi";
    }
}
