package co.edu.uniquindio.poo.logistica2.model;

public class Incidencia implements IEstadoEnvio{
    @Override
    public String solicitar(Envio envio) {
        return "El envío tiene una incidencia y no puede ser solicitado nuevamente.";
    }

    @Override
    public String asignar(Envio envio) {
        return "El envío está en estado de incidencia. No se puede asignar un repartidor hasta resolverla.";
    }

    @Override
    public String EnRuta(Envio envio) {
        return "El envío está en incidencia. No puede ponerse en ruta hasta que se solucione el problema.";
    }

    @Override
    public String entregar(Envio envio) {
        return "El envío está en incidencia. No puede entregarse hasta que se resuelva.";
    }

    @Override
    public String reportarIncidencia(Envio envio) {
        return "El envío ya se encuentra en estado de incidencia.";
    }

    public String resolver(Envio envio) {
        envio.setEstadoEnvio(new EnRuta());
        return "✅ La incidencia ha sido resuelta. El envío vuelve a estar en ruta.";
    }

    @Override
    public String ejecutarAccion(Envio envio, String accion) {
        switch (accion.toLowerCase()) {
            case "resolver" -> {
                envio.setEstadoEnvio(new EnRuta());
                return "La incidencia ha sido resuelta. El envío vuelve a estar en ruta.";
            }
            default -> { return "⚠️ El envío está en incidencia. No se pueden ejecutar otras acciones."; }
        }
    }

    @Override
    public String getNombre() {
        return "Incidencia";
    }
}
