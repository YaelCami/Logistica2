package co.edu.uniquindio.poo.logistica2.model;

import javax.swing.*;

public class Efectivo implements IMetodoPago {
    @Override
    public String pagar(double monto) {
        return "Pago en EFECTIVO realizado por una cantidad: " + monto;

    }
}
