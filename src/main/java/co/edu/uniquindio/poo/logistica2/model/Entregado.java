package co.edu.uniquindio.poo.logistica2.model;

public class Entregado implements IEstadoEnvio{
    @Override
    public void solicitar(Envio envio) {

        System.out.println("El envío ya fue entregado. No se puede solicitar nuevamente.");
    }

    @Override
    public void asignar(Envio envio) {
        System.out.println("El envío ya fue entregado. No se puede asignar un repartidor.");
    }

    @Override
    public void EnRuta(Envio envio) {
        System.out.println("El envío ya fue entregado. No se puede volver a poner en ruta.");
    }

    @Override
    public void entregar(Envio envio) {
        System.out.println("El envío ya fue entregado anteriormente.");
    }

    @Override
    public void reportarIncidencia(Envio envio) {
        System.out.println("El envío ya fue entregado. No se pueden reportar incidencias.");
    }


    @Override
    public String getNombre() {
        return "Entregado";
    }
}
