package co.edu.uniquindio.poo.logistica2.model;

public class Incidencia implements IEstado {
    @Override
    public void asignar(Envio envio) {
        System.out.println("El envío está en estado de incidencia. No se puede asignar un repartidor hasta resolverla.");
    }

    @Override
    public void EnRuta(Envio envio) {
        System.out.println("El envío está en incidencia. No puede ponerse en ruta hasta que se solucione el problema.");
    }

    @Override
    public void entregar(Envio envio) {
        System.out.println("El envío está en incidencia. No puede entregarse hasta que se resuelva.");
    }

    @Override
    public void reportarIncidencia(Envio envio) {
        System.out.println("El envío ya se encuentra en estado de incidencia.");
    }

    public String resolver(Envio envio) {
        envio.cambiarEstado(new EnRuta());
        return "✅ La incidencia ha sido resuelta. El envío vuelve a estar en ruta.";
    }

    @Override
    public String getNombre() {
        return "Incidencia";
    }
}