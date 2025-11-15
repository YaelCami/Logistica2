package co.edu.uniquindio.poo.logistica2.model;

public interface IEstadoEnvio {
    void solicitar(Envio envio);
    void asignar(Envio envio);
    void EnRuta(Envio envio);
    void entregar(Envio envio);
    String getNombre();
    void reportarIncidencia(Envio envio);

}
