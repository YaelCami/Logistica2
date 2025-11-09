package co.edu.uniquindio.poo.logistica2.model;

public class Entregado implements IEstadoEnvio{
    @Override
    public String solicitar(Envio envio) {
        return "El envío ya fue entregado. No se puede solicitar nuevamente.";
    }

    @Override
    public String asignar(Envio envio) {
        return "El envío ya fue entregado. No se puede asignar un repartidor.";
    }

    @Override
    public String EnRuta(Envio envio) {
        return "El envío ya fue entregado. No se puede volver a poner en ruta.";
    }

    @Override
    public String entregar(Envio envio) {
        return "El envío ya fue entregado anteriormente.";
    }

    @Override
    public String reportarIncidencia(Envio envio) {
        return "El envío ya fue entregado. No se pueden reportar incidencias.";
    }
    @Override
    public String ejecutarAccion(Envio envio, String accion) {
        switch (accion.toLowerCase()) {
            case "incidencia" -> { return "No se puede reportar incidencia, el envío ya fue entregado."; }
            default -> { return "⚠️ El envío ya está completado. No hay más acciones disponibles."; }
        }
    }


    @Override
    public String getNombre() {
        return "Entregado";
    }
}
