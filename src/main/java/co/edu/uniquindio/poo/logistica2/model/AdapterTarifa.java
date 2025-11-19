package co.edu.uniquindio.poo.logistica2.model;
/**
 * Adaptador que permite utilizar un objeto Pedido
 * a través de la interfaz ITarifa.
 *
 * <p>Esta clase implementa el patrón Adapter, delegando el
 * cálculo del costo al método del pedido recibido.</p>
 */
public class AdapterTarifa implements ITarifa{

    private Pedido pedido;


    public AdapterTarifa(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * Calcula el costo del pedido adaptado.
     *
     * @return el costo total calculado del pedido
     */
    @Override
    public double calcularCosto() {
        return pedido.calcularCostoPedido();
    }
}