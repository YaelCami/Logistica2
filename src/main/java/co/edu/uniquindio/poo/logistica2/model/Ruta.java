package co.edu.uniquindio.poo.logistica2.model;

import java.util.List;
import java.util.Objects;

public class Ruta {
    private String id;
    private Ciudad ciudadOrigen;
    private Ciudad ciudadDestino;
    private double distancia;
    private List<Envio> listEnvios;

    public Ruta(String id, Ciudad ciudadOrigen, Ciudad ciudadDestino, double distancia) {
        this.id = id;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.distancia = distancia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(Ciudad ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(Ciudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return ciudadOrigen.getNombre() +
                " - " + ciudadDestino.getNombre() ;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ruta ruta = (Ruta) o;
        return ciudadOrigen.equals(ruta.ciudadOrigen) &&
                ciudadDestino.equals(ruta.ciudadDestino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ciudadOrigen, ciudadDestino);
    }

}