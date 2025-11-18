package co.edu.uniquindio.poo.logistica2.model;

public class PedidoDecorator implements IPedido {
    protected IPedido pedido;
    /**
     * Constructor del decorador.
     * @param pedido Pedido base que será decorado.
     */
    public PedidoDecorator(IPedido pedido) {
        this.pedido = pedido;
    }
    /**
     * Devuelve la descripción del pedido.
     * Por defecto, retorna la descripción del pedido original.
     *
     * @return Descripción del pedido.
     */
    @Override
    public String getDescripcion() {
        return pedido.getDescripcion();
    }
    /**
            * Devuelve el costo adicional del pedido.
            * Por defecto, retorna los extras del pedido original.
     *
             * @return Costo adicional.
            */
    @Override
    public double getExtras() {
        return pedido.getExtras();
    }
}
