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
    public boolean agregarEnvio(Envio envio) {
        boolean centinela = false;
        for (Envio e : listEnvios) {
            if (!verificarEnvio(e.getId())) {
                listEnvios.add(e);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    /**
     * Verifica si una ruta existe en la zona de cobertura mediante su ID.
     * @param id identificador de la ruta.
     * @return true si la ruta existe, false en caso contrario.
     */
    public boolean verificarRuta(String id) {
        boolean centinela = false;
        for (Ruta r: zonaCobertura) {
            if (r.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    /**
     * Verifica si un envío existe en la lista según su ID.
     * @param id identificador del envío.
     * @return true si el envío existe, false si no.
     */
    public boolean verificarEnvio(String id) {
        boolean centinela = false;
        for (Envio e : listEnvios) {
            if (e.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    /**
     * Elimina una ruta de la zona de cobertura usando su ID.
     * @param id identificador de la ruta.
     * @return true si se eliminó correctamente, false si no existe.
     */
    public boolean eliminarRuta(String id) {
        boolean centinela = false;
        for (Ruta r: zonaCobertura) {
            if (r.getId().equals(id)) {
                zonaCobertura.remove(r);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    /**
     * Elimina un envío de la lista según su ID.
     * @param id identificador del envío.
     * @return true si se eliminó, false si no existe.
     */
    public boolean eliminarEnvio(String id) {
        boolean centinela = false;
        for (Envio e : listEnvios) {
            if (e.getId().equals(id)) {
                listEnvios.remove(e);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    /**
     * Actualiza una ruta existente con nuevos valores.
     * @param id ID de la ruta a actualizar.
     * @param actualizado ruta con los nuevos valores.
     * @return true si se actualizó correctamente, false en caso contrario.
     */
    public boolean actualizarRuta(String id, Ruta actualizado) {
        boolean centinela = false;
        for (Ruta r: zonaCobertura) {
            if (r.getId().equals(id)) {
                r.setId(actualizado.getId());
                r.setCiudadOrigen(actualizado.getCiudadOrigen());
                r.setCiudadDestino(actualizado.getCiudadDestino());
                r.setDistancia(actualizado.getDistancia());
                centinela = true;
                break;
            }

        }
        return centinela;
    }
    /**
     * Actualiza los datos de un envío asignado al repartidor.
     * @param id ID del envío a actualizar.
     * @param actualizado envío con nuevos valores.
     * @return true si se actualizó, false si no existe.
     */
    public boolean actualizarEnvio(String id, Envio actualizado) {
        boolean centinela = false;
        for (Envio e:  listEnvios) {
            if (e.getId().equals(id)) {
                e.setFechaInicio(actualizado.getFechaInicio());
                e.setFechaEstimadaEntrega(actualizado.getFechaEstimadaEntrega());
                e.setFechaEntrega(actualizado.getFechaEntrega());
                e.setCosto(actualizado.getCosto());
                e.setEstadoEnvio(actualizado.getEstadoEnvio());
                e.setRuta(actualizado.getRuta());
                e.setRepartidor(actualizado.getRepartidor());
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    /**
     * Busca y retorna una ruta según su ID.
     * @param id identificador de la ruta.
     * @return la ruta encontrada, o null si no existe.
     */
    public Ruta buscarRuta(String id) {
        for (Ruta r: zonaCobertura) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }
    /**
     * Busca y retorna un envío según su ID.
     * @param id identificador del envío.
     * @return el envío encontrado o null si no existe.
     */
    public Envio buscarEnvio(String id) {
        for (Envio e: listEnvios) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

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