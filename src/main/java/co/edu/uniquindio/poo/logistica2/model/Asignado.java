package co.edu.uniquindio.poo.logistica2.model;

public class Asignado implements IEstadoEnvio{

    @Override
    public String solicitar(Envio envio) {
        return "El envío ya fue solicitado y está asignado a un repartidor.";
    }

    @Override
    public String asignar(Envio envio) {
        return "El envío ya está asignado.";
    }

    @Override
    public String EnRuta(Envio envio) {
        envio.setEstadoEnvio(new EnRuta());
        return "El envío ahora está en ruta hacia su destino.";
    }

    @Override
    public String entregar(Envio envio) {
        return "No se puede entregar sin antes estar en ruta.";
    }

    @Override
    public String reportarIncidencia(Envio envio) {
        envio.setEstadoEnvio(new Incidencia());
        return "Se ha reportado una incidencia en el envío.";
    }

    @Override
    public String ejecutarAccion(Envio envio, String accion) {
        switch (accion.toLowerCase()) {
            case "enrutar" -> { return EnRuta(envio); }
            case "incidencia" -> { return reportarIncidencia(envio); }
            default -> { return "⚠️ No puedes ejecutar esa acción en estado ASIGNADO."; }
        }
    }


    @Override
    public String getNombre() {
        return "Asignado";
    }
}
