package co.edu.uniquindio.poo.logistica2.model;

public class Solicitado implements IEstadoEnvio{
    @Override
    public void solicitar(Envio envio) {
        System.out.println("El envío ya fue solictado");
    }
    @Override
    public void asignar(Envio envio) {
        envio.cambiarEstado(new Asignado());
        System.out.println("El envío ha sido asignado a un repartidor.");
    }

    @Override
    public void EnRuta(Envio envio) {
        System.out.println("No se puede poner en ruta sin asignar primero.");
    }

    @Override
    public void entregar(Envio envio) {
        System.out.println("No se puede entregar sin estar en ruta.");
    }

    @Override
    public void reportarIncidencia(Envio envio) {
        envio.setEstadoEnvio(new Incidencia());
        System.out.println("Se ha reportado una incidencia en el envío.");
    }


    @Override
    public String getNombre() {
        return "Solictado";
    }
}
