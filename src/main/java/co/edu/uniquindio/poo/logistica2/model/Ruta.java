package co.edu.uniquindio.poo.logistica2.model;

import java.util.List;
import java.util.Objects;

public class Ruta {
    private String id;
    private Ciudad ciudadOrigen;
    private Ciudad ciudadDestino;
    private double distancia;
    private List<Envio> listEnvios;

    /**
     * Constructor principal de la clase Ruta.
     *
     * @param id identificador único de la ruta.
     * @param ciudadOrigen ciudad desde la cual inicia la ruta.
     * @param ciudadDestino ciudad donde finaliza la ruta.
     * @param distancia distancia total de la ruta en kilómetros.
     */
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

    /**
     * Retorna una representación en texto de la ruta, mostrando
     * la ciudad de origen y destino.
     *
     * @return texto describiendo la ruta.
     */
    @Override
    public String toString() {
        return ciudadOrigen.getNombre() +
                " - " + ciudadDestino.getNombre() ;
    }
    /**
     * Compara dos rutas verificando si tienen la misma ciudad de origen y destino.
     *
     * @param o objeto a comparar.
     * @return true si ambas rutas tienen el mismo origen y destino, false de lo contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ruta ruta = (Ruta) o;
        return ciudadOrigen.equals(ruta.ciudadOrigen) &&
                ciudadDestino.equals(ruta.ciudadDestino);
    }
    /**
     * Genera un hash basado en la ciudad de origen y destino.
     *
     * @return hashcode de la ruta.
     */
    @Override
    public int hashCode() {
        return Objects.hash(ciudadOrigen, ciudadDestino);
    }

}
