package co.edu.uniquindio.poo.logistica2.model;

public class PedidoFirma extends PedidoDecorator{

    public PedidoFirma(IPedido pedido) {
        super(pedido);
    }
    @Override
    public String getDescripcion() {
        return pedido.getDescripcion() + " |FIRMA";
    }
    @Override
    public double getExtras() {
        return pedido.getExtras() +5000.0;
    }
}
