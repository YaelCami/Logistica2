package co.edu.uniquindio.poo.logistica2.model;

public class PedidoSeguro extends PedidoDecorator{

    public PedidoSeguro(IPedido pedido) {
        super(pedido);
    }
    @Override
    public String getDescripcion() {
        return pedido.getDescripcion() +" |SEGURO";
    }
}
