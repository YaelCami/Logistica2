package co.edu.uniquindio.poo.logistica2.model;

public class AdapterTarifa implements ITarifa{

    private Pedido pedido;

    public AdapterTarifa(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public double calcularCosto() {
        return pedido.calcularCostoPedido();
    }
}
