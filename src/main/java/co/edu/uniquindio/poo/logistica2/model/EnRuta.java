package co.edu.uniquindio.poo.logistica2.model;

public class EnRuta implements IEstadoEnvio {

    @Override
    public void solicitar(Envio envio) {
        System.out.println("El envío ya fue solicitado y está actualmente en ruta.");
    }

    @Override
    public void asignar(Envio envio) {
        System.out.println("El envío ya está en ruta, no se puede volver a asignar.");
    }

    @Override
    public void EnRuta(Envio envio) {
        System.out.println("El envío ya está en ruta hacia su destino.");
    }

    @Override
    public void entregar(Envio envio) {
        envio.cambiarEstado(new Entregado());
        System.out.println("El paquete ha sido entregado exitosamente.");
    }

    @Override
    public void reportarIncidencia(Envio envio) {
        envio.cambiarEstado(new Incidencia());
        System.out.println("Se ha reportado una incidencia durante el trayecto.");
    }


    @Override
    public String getNombre() {
        return "EnRuta";
    }
}
