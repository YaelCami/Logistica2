package co.edu.uniquindio.poo.logistica2.model;

public class Asignado implements IEstadoEnvio{

    @Override
    public void solicitar(Envio envio) {
        System.out.println("El envío ya fue solicitado y está asignado a un repartidor.");
    }

    @Override
    public void asignar(Envio envio) {
        System.out.println("El envío ya está asignado.");
    }

    @Override
    public void EnRuta(Envio envio) {
        envio.cambiarEstado(new EnRuta());
        System.out.println("El envío ahora está en ruta hacia su destino.");
    }

    @Override
    public void entregar(Envio envio) {
        System.out.println("No se puede entregar sin antes estar en ruta.");
    }

    @Override
    public void reportarIncidencia(Envio envio) {
        envio.cambiarEstado(new Incidencia());
        System.out.println("Se ha reportado una incidencia en el envío.");
    }




    @Override
    public String getNombre() {
        return "Asignado";
    }
}