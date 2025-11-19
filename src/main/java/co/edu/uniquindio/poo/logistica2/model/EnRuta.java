package co.edu.uniquindio.poo.logistica2.model;

public class EnRuta implements IEstado {

    /**
     * Intenta asignar el envío, pero no es posible porque ya se encuentra en ruta.
     *
     * @param envio envío sobre el cual se intenta realizar la acción
     */
    @Override
    public void asignar(Envio envio) {
        System.out.println("El envío ya está en ruta, no se puede volver a asignar.");
    }
    /**
     * Indica que el envío ya está en ruta, por lo que no hay cambios de estado.
     *
     * @param envio envío sobre el cual se intenta informar el estado
     */
    @Override
    public void EnRuta(Envio envio) {
        System.out.println("El envío ya está en ruta hacia su destino.");
    }
    /**
     * Marca el envío como entregado, cambiando su estado al estado {@code Entregado}.
     *
     * @param envio envío que ha sido entregado
     */
    @Override
    public void entregar(Envio envio) {
        envio.cambiarEstado(new Entregado());
        System.out.println("El paquete ha sido entregado exitosamente.");
    }
    /**
     * Reporta una incidencia durante el trayecto del envío,
     * cambiando su estado al estado {@code Incidencia}.
     *
     * @param envio envío en el cual se reporta la incidencia
     */
    @Override
    public void reportarIncidencia(Envio envio) {
        envio.cambiarEstado(new Incidencia());
        System.out.println("Se ha reportado una incidencia durante el trayecto.");
    }

    /**
     * Obtiene el nombre del estado actual.
     *
     * @return cadena que representa el nombre del estado: "EnRuta"
     */
    @Override
    public String getNombre() {
        return "EnRuta";
    }
}
