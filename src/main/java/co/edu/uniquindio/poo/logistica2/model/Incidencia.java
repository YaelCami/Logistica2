package co.edu.uniquindio.poo.logistica2.model;

public class Incidencia implements IEstado {

    /**
     * No permite asignar un repartidor porque el envío se encuentra en estado de incidencia.
     *
     * @param envio envío sobre el cual se intenta realizar la acción
     */
    @Override
    public void asignar(Envio envio) {
        System.out.println("El envío está en estado de incidencia. No se puede asignar un repartidor hasta resolverla.");
    }
    /**
     * No permite poner en ruta el envío mientras exista una incidencia.
     *
     * @param envio envío sobre el cual se intenta realizar la acción
     */
    @Override
    public void EnRuta(Envio envio) {
        System.out.println("El envío está en incidencia. No puede ponerse en ruta hasta que se solucione el problema.");
    }
    /**
     * No permite entregar el envío debido a la incidencia presente.
     *
     * @param envio envío sobre el cual se intenta realizar la acción
     */
    @Override
    public void entregar(Envio envio) {
        System.out.println("El envío está en incidencia. No puede entregarse hasta que se resuelva.");
    }
    /**
     * Informa que el envío ya se encuentra en estado de incidencia.
     *
     * @param envio envío sobre el cual se intenta realizar la acción
     */
    @Override
    public void reportarIncidencia(Envio envio) {
        System.out.println("El envío ya se encuentra en estado de incidencia.");
    }
    /**
     * Resuelve la incidencia del envío, retornándolo al estado "En Ruta".
     *
     * @param envio envío cuya incidencia será resuelta
     * @return mensaje indicando que la incidencia fue solucionada
     */
    public String resolver(Envio envio) {
        envio.cambiarEstado(new EnRuta());
        return "✅ La incidencia ha sido resuelta. El envío vuelve a estar en ruta.";
    }
    /**
     * Obtiene el nombre del estado actual.
     *
     * @return cadena que representa el estado: "Incidencia"
     */
    @Override
    public String getNombre() {
        return "Incidencia";
    }
}
