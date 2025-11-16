package co.edu.uniquindio.poo.logistica2.model;

public class PedidoFragil extends PedidoDecorator {

    public PedidoFragil(IPedido pedido) {
        super(pedido);
    }
    @Override
    public String getDescripcion() {
        return pedido.getDescripcion() + " |FRÁGIL";
    }
    @Override
    public double getExtras() {
        return pedido.getExtras() +8000.0;
    }
}