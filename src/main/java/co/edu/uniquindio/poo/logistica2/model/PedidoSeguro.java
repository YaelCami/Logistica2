package co.edu.uniquindio.poo.logistica2.model;

public class PedidoSeguro extends PedidoDecorator{

    /**
     * Constructor del decorador de seguro.
     *
     * @param pedido El pedido que recibirá el servicio adicional de seguro.
     */
    public PedidoSeguro(IPedido pedido) {
        super(pedido);
    }
    /**
     * Retorna la descripción del pedido agregando la etiqueta de seguro.
     *
     * @return Descripción del pedido con la marca "SEGURO".
     */
    @Override
    public String getDescripcion() {
        return pedido.getDescripcion() +" |SEGURO";
    }
    /**
     * Retorna el costo extra del pedido sumando el valor adicional
     * correspondiente al servicio de seguro.
     *
     * @return Costo adicional total con el seguro incluído.
     */
    @Override
    public double getExtras() {
        return pedido.getExtras() +2000.0;
    }
}
