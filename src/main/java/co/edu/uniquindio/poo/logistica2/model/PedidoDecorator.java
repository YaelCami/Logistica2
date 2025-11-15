package co.edu.uniquindio.poo.logistica2.model;

public class PedidoDecorator implements IPedido {
    protected IPedido pedido;
    public PedidoDecorator(IPedido pedido) {
        this.pedido = pedido;
    }
    @Override
    public String getDescripcion() {
        return pedido.getDescripcion();
    }
    @Override
    public double getExtras() {
        return pedido.getExtras();
    }
}
