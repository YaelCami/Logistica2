package co.edu.uniquindio.poo.logistica2.model;

import java.util.ArrayList;
import java.util.List;

public class Repartidor extends Persona {
    private String documento;
    private Disponibilidad disponibilidad;
    private List<Ruta> zonaCobertura;
    private List<Envio> listEnvios;

    public Repartidor(Builder builder) {
        super(builder);
        this.documento = builder.documento;
        this.disponibilidad = builder.disponibilidad;
        this.zonaCobertura = builder.zonaCobertura;
        this.listEnvios = builder.listEnvios;

    }
    /**
     * Clase Builder para construir objetos Repartidor de forma flexible.
     * Permite establecer documento, disponibilidad, zona de cobertura y lista de envíos.
     */
    public static class Builder extends Persona.Builder<Builder> {
        private String documento;
        private Disponibilidad disponibilidad;
        private List<Ruta> zonaCobertura = new ArrayList<>();
        private List<Envio> listEnvios =  new ArrayList<>();


        public Builder documento(String documento) {
            this.documento = documento;
            return this;
        }
        public Builder disponibilidad(Disponibilidad disponibilidad) {
            this.disponibilidad = disponibilidad;
            return this;
        }
        public Builder zonaCobertura(List<Ruta> zonaCobertura) {
            this.zonaCobertura = zonaCobertura;
            return this;
        }
        public Builder listEnvios(List<Envio> listEnvios) {
            this.listEnvios = listEnvios;
            return this;
        }

        @Override
        public Repartidor build() {
            return new Repartidor(this);
        }
    }

    /**
     * Agrega una ruta a la zona de cobertura del repartidor.
     * @param ruta ruta a agregar.
     */
    public void agregarRuta(Ruta ruta) {
        zonaCobertura.add(ruta);
    }
    /**
     * Agrega un envío a la lista del repartidor si no existe previamente.
     * @param envio envío a agregar.
     * @return true si fue agregado, false si el envío ya existía.
     */


    public List<Envio> getListEnvios() {
        return listEnvios;
    }

    public void setListEnvios(List<Envio> listEnvios) {
        this.listEnvios = listEnvios;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    public List<Ruta> getZonaCobertura() {
        return zonaCobertura;
    }

    public void setZonaCobertura(List<Ruta> zonaCobertura) {
        this.zonaCobertura = zonaCobertura;
    }
}