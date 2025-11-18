package co.edu.uniquindio.poo.logistica2.model;

public class PedidoPrioridad extends PedidoDecorator{

    /**
     * Constructor del decorador de prioridad.
     *
     * @param pedido El pedido original al que se le agregará la prioridad.
     */
    public PedidoPrioridad(IPedido pedido) {
        super(pedido);
    }
    /**
     * Retorna la descripción del pedido agregando la etiqueta de prioridad.
     *
     * @return Descripción del pedido con la marca de "PRIORIDAD".
     */
    @Override
    public String getDescripcion() {
        return pedido.getDescripcion() + " |PRIORIDAD";
    }
    /**
     * Retorna el costo extra del pedido sumando el valor adicional
     * correspondiente al servicio de prioridad.
     *
     * @return Costo adicional total con prioridad incluida.
     */
    @Override
    public double getExtras() {
        return pedido.getExtras() +10000.0;
    }
}
