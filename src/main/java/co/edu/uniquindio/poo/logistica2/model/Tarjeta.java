package co.edu.uniquindio.poo.logistica2.model;

public class Tarjeta implements IMetodoPago{
    /**
     * Ejecuta el proceso de pago utilizando una tarjeta.
     *
     * @param monto valor que se desea pagar.
     * @return mensaje confirmando que el pago fue realizado mediante tarjeta.
     */
    @Override
    public String pagar(double monto) {
        return "Pago en TARJETA realizado por una cantidad: " + monto;
    }
    /**
     * Retorna el nombre del método de pago.
     *
     * @return cadena que representa este método de pago.
     */
    @Override
    public String toString() {
        return "Tarjeta";
    }
}
