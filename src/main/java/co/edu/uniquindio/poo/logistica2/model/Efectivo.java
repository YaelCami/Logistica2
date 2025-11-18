package co.edu.uniquindio.poo.logistica2.model;

import javax.swing.*;

public class Efectivo implements IMetodoPago {
    /**
     * Procesa un pago en efectivo por el monto especificado.
     *
     * @param monto cantidad de dinero a pagar
     * @return mensaje indicando que el pago en efectivo fue realizado
     */
    @Override
    public String pagar(double monto) {
        return "Pago en EFECTIVO realizado por una cantidad: " + monto;

    }
    /**
     * Representación textual del método de pago.
     *
     * @return cadena "Efectivo"
     */
    @Override
    public String toString() {
        return "Efectivo";
    }
}
