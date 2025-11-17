package co.edu.uniquindio.poo.logistica2.model;

import java.time.LocalDate;

public class Pago {
    private String id;
    private double monto;
    private LocalDate fecha;
    private Pedido pedido;
    private IMetodoPago metodoPago;

    public Pago(String id, double monto, LocalDate fecha, Pedido pedido,  IMetodoPago metodoPago) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.pedido = pedido;
        this.metodoPago = metodoPago;
    }

    public String ejecutarPago(double monto){
        metodoPago.pagar(monto);
        return "Pago realizado con éxito por el monto de: " + monto ;
    }

    public IMetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(IMetodoPago metodoPago) {
        this.metodoPago = metodoPago;
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


    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}