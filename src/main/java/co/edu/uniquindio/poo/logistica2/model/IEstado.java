package co.edu.uniquindio.poo.logistica2.model;

public interface IEstado {
    void asignar(Envio envio);
    void EnRuta(Envio envio);
    void entregar(Envio envio);
    String getNombre();
    void reportarIncidencia(Envio envio);

}
