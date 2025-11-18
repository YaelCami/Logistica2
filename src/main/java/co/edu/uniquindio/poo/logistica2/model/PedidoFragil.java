package co.edu.uniquindio.poo.logistica2.model;

public class PedidoFragil extends PedidoDecorator {

    /**
     * Constructor del decorador de fragilidad.
     *
     * @param pedido El pedido al que se le agregará el manejo especial para productos frágiles.
     */
    public PedidoFragil(IPedido pedido) {
        super(pedido);
    }
   /**
            * Retorna la descripción del pedido agregando la etiqueta de manejo frágil.
     *
             * @return Descripción del pedido con el extra de "FRÁGIL".
            */
    @Override
    public String getDescripcion() {
        return pedido.getDescripcion() + " |FRÁGIL";
    }
    /**
     * Retorna el costo extra del pedido sumando el valor adicional
     * correspondiente al manejo de pedidos frágiles.
     *
     * @return Costo adicional total con la fragilidad incluida.
     */
    @Override
    public double getExtras() {
        return pedido.getExtras() +8000.0;
    }
}
