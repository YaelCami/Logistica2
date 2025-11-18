package co.edu.uniquindio.poo.logistica2.model;

public class PedidoFirma extends PedidoDecorator{

    /**
     * Constructor del decorador de firma.
     *
     * @param pedido El pedido base al cual se le agregará el servicio de firma.
     */
    public PedidoFirma(IPedido pedido) {
        super(pedido);
    }
    /**
     * Retorna la descripción del pedido incluyendo la indicación
     * de que requiere firma.
     *
     * @return Descripción del pedido con el extra de firma.
     */
    @Override
    public String getDescripcion() {
        return pedido.getDescripcion() + " |FIRMA";
    }/**
     * Retorna el costo adicional del pedido sumando
     * el valor extra por el servicio de firma.
     *
     * @return Costo adicional total con la firma incluida.
     */

    @Override
    public double getExtras() {
        return pedido.getExtras() +5000.0;
    }
}
