package co.edu.uniquindio.poo.logistica2.model;

public class Solicitado implements IEstadoEnvio{
    @Override
    public String solicitar(Envio envio) {
        return "El envío ya fue solictado";
    }
    @Override
    public String asignar(Envio envio) {
        envio.setEstadoEnvio(new Asignado());
        return "El envío ha sido asignado a un repartidor.";
    }

    @Override
    public String EnRuta(Envio envio) {
        return "No se puede poner en ruta sin asignar primero.";
    }

    @Override
    public String entregar(Envio envio) {
        return "No se puede entregar sin estar en ruta.";
    }

    @Override
    public String reportarIncidencia(Envio envio) {
        envio.setEstadoEnvio(new Incidencia());
        return "Se ha reportado una incidencia en el envío.";
    }
    @Override
    public String ejecutarAccion(Envio envio, String accion) {
        switch (accion.toLowerCase()) {
            case "asignar" -> { return asignar(envio); }
            case "solicitar" -> { return solicitar(envio); }
            case "incidencia" -> { return reportarIncidencia(envio); }
            default -> { return "⚠️ Acción no válida en estado SOLICITADO."; }
        }
    }

    @Override
    public String getNombre() {
        return "Solictado";
    }
}
