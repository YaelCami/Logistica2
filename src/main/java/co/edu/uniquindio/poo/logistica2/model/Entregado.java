package co.edu.uniquindio.poo.logistica2.model;

public class Entregado implements IEstado {
    /**
     * No permite asignar un repartidor porque el envío ya ha sido entregado.
     *
     * @param envio envío sobre el cual se intenta realizar la acción
     */
    @Override
    public void asignar(Envio envio) {
        System.out.println("El envío ya fue entregado. No se puede asignar un repartidor.");
    }
    /**
     * No permite poner el envío en ruta porque ya fue entregado.
     *
     * @param envio envío sobre el cual se intenta realizar la acción
     */
    @Override
    public void EnRuta(Envio envio) {
        System.out.println("El envío ya fue entregado. No se puede volver a poner en ruta.");
    }
    /**
     * No permite entregar nuevamente el envío, ya que su estado actual es entregado.
     *
     * @param envio envío sobre el cual se intenta realizar la acción
     */

    @Override
    public void entregar(Envio envio) {
        System.out.println("El envío ya fue entregado anteriormente.");
    }
    /**
     * No permite reportar incidencias porque el envío ya llegó correctamente a su destino.
     *
     * @param envio envío sobre el cual se intenta realizar la acción
     */
    @Override
    public void reportarIncidencia(Envio envio) {
        System.out.println("El envío ya fue entregado. No se pueden reportar incidencias.");
    }
    /**
     * Obtiene el nombre del estado actual.
     *
     * @return cadena que representa el estado: "Entregado"
     */
    @Override
    public String getNombre() {
        return "Entregado";
    }
}
