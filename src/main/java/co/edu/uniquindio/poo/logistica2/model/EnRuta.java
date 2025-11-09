package co.edu.uniquindio.poo.logistica2.model;

public class EnRuta implements IEstadoEnvio {

    @Override
    public String solicitar(Envio envio) {
        return "El envío ya fue solicitado y está actualmente en ruta.";
    }

    @Override
    public String asignar(Envio envio) {
        return "El envío ya está en ruta, no se puede volver a asignar.";
    }

    @Override
    public String EnRuta(Envio envio) {
        return "El envío ya está en ruta hacia su destino.";
    }

    @Override
    public String entregar(Envio envio) {
        envio.setEstadoEnvio(new Entregado());
        return "El paquete ha sido entregado exitosamente.";
    }

    @Override
    public String reportarIncidencia(Envio envio) {
        envio.setEstadoEnvio(new Incidencia());
        return "Se ha reportado una incidencia durante el trayecto.";
    }
    @Override
    public String ejecutarAccion(Envio envio, String accion) {
        switch (accion.toLowerCase()) {
            case "entregar" -> { return entregar(envio); }
            case "incidencia" -> { return reportarIncidencia(envio); }
            default -> { return "⚠️ No puedes ejecutar esa acción en estado EN RUTA."; }
        }
    }

    @Override
    public String getNombre() {
        return "EnRuta";
    }
}
