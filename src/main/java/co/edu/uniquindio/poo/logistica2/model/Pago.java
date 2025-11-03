package co.edu.uniquindio.poo.logistica2.model;

import java.time.LocalDate;

public class Pago {
    private String id;
    private double monto;
    private LocalDate fecha;
    private MetodoPago metodoPago;
    private Pedido pedido;

    public Pago(String id, double monto, LocalDate fecha, MetodoPago metodoPago, Pedido pedido) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.pedido = pedido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
