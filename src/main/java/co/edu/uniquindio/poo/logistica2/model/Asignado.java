package co.edu.uniquindio.poo.logistica2.model;

public class Asignado implements IEstado {

    // Estado "Asignado": indica que el envío ya fue asignado a un repartidor
    @Override
    public void asignar(Envio envio) {
        // Si el envío ya está en estado Asignado, no se puede volver a asignar
        System.out.println("El envío ya está asignado.");
    }

    @Override
    public void EnRuta(Envio envio) {
        // Cambia el estado del envío al estado "EnRuta"
        envio.cambiarEstado(new EnRuta());
        System.out.println("El envío ahora está en ruta hacia su destino.");
    }

    @Override
    public void entregar(Envio envio) {
        // No se puede entregar si no está en ruta primero
        System.out.println("No se puede entregar sin antes estar en ruta.");
    }

    @Override
    public void reportarIncidencia(Envio envio) {
        // Cambia el estado a "Incidencia"
        envio.cambiarEstado(new Incidencia());
        System.out.println("Se ha reportado una incidencia en el envío.");
    }




    @Override
    public String getNombre() {
        // Devuelve el nombre del estado actual
        return "Asignado";
    }
}
