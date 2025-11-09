package co.edu.uniquindio.poo.logistica2.model;

public interface IEstadoEnvio {
    String solicitar(Envio envio);
    String asignar(Envio envio);
    String EnRuta(Envio envio);
    String entregar(Envio envio);
    String getNombre();
    String reportarIncidencia(Envio envio);
    String ejecutarAccion(Envio envio, String accion);
}
