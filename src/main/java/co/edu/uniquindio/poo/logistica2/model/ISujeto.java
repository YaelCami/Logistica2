package co.edu.uniquindio.poo.logistica2.model;

public interface ISujeto {
    void agregarObservador(IObservador observador);
    void eliminarObservador(IObservador observador);
    void notificarObservador(String mensaje);

}
