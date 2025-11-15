package co.edu.uniquindio.poo.logistica2.model;

public class PedidoPrioridad extends PedidoDecorator{

    public PedidoPrioridad(IPedido pedido) {
        super(pedido);
    }
    @Override
    public String getDescripcion() {
        return pedido.getDescripcion() + " |PRIORIDAD";
    }
}
