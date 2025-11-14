package co.edu.uniquindio.poo.logistica2.model;

import java.util.ArrayList;
import java.util.List;

public class Repartidor extends Persona {

    private String documento;
    private Disponibilidad disponibilidad;
    private Ciudad zonaCobertura;
    private List<Camion> listCamiones;
    private List<Ruta> listRutas;
    private List<Envio> listEnvios;

    public Repartidor(Builder builder, String documento, Disponibilidad disponibilidad, Ciudad zonaCobertura) {
        super(builder);
        this.documento = builder.documento;
        this.disponibilidad = builder.disponibilidad;
        this.zonaCobertura = builder.zonaCobertura;
        this.listCamiones = builder.listCamiones;
        this.listRutas = builder.listRutas;
        this.listEnvios = builder.listEnvios;

    }
    public static class Builder extends Persona.Builder {
        private String documento;
        private Disponibilidad disponibilidad;
        private Ciudad zonaCobertura;
        private List<Camion> listCamiones = new ArrayList<>();
        private List<Ruta> listRutas = new ArrayList<>();
        private List<Envio> listEnvios =  new ArrayList<>();

        @Override
        public Repartidor build() {
            return new Repartidor(this, documento,  disponibilidad, zonaCobertura);
        }

        public Builder documento(String documento) {
            this.documento = documento;
            return this;
        }
        public Builder disponibilidad(Disponibilidad disponibilidad) {
            this.disponibilidad = disponibilidad;
            return this;
        }
        public Builder zonaCobertura(Ciudad zonaCobertura) {
            this.zonaCobertura = zonaCobertura;
            return this;
        }
        public Builder listCamiones(List<Camion> listCamiones) {
            this.listCamiones = listCamiones;
            return this;
        }
        public Builder listRutas(List<Ruta> listRutas) {
            this.listRutas = listRutas;
            return this;
        }
        public Builder listEnvios(List<Envio> listEnvios) {
            this.listEnvios = listEnvios;
            return this;
        }
    }

    public boolean agregarCamion(Camion camion){
        boolean centinela = false;
        for (Camion c: listCamiones) {
            if (!verificarCamion(c.getPlaca())) {
                listCamiones.add(c);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean agregarRuta(Ruta  ruta){
        boolean centinela = false;
        for (Ruta  r: listRutas) {
            if (!verificarRuta(r.getId())) {
                listRutas.add(r);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
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
    public boolean verificarCamion(String placa) {
        boolean centinela = false;
        for (Camion c: listCamiones) {
            if (c.getPlaca().equals(placa)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean verificarRuta(String id) {
        boolean centinela = false;
        for (Ruta r: listRutas) {
            if (r.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }
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
    public boolean eliminarCamion(String placa) {
        boolean centinela = false;
        for (Camion c: listCamiones) {
            if (c.getPlaca().equals(placa)) {
                listCamiones.remove(c);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean eliminarRuta(String id) {
        boolean centinela = false;
        for (Ruta r: listRutas) {
            if (r.getId().equals(id)) {
                listRutas.remove(r);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
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

    public boolean actualizarCamion(String placa, Camion actualizado) {
        boolean centinela = false;
        for (Camion c: listCamiones) {
            if (c.getPlaca().equals(placa)) {
                c.setCapacidad(actualizado.getCapacidad());
                c.setPlaca(actualizado.getPlaca());
                c.setModelo(actualizado.getModelo());

                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean actualizarRuta(String id, Ruta actualizado) {
        boolean centinela = false;
        for (Ruta r: listRutas) {
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

    public Camion buscarCamion(String placa) {
        for (Camion  c: listCamiones) {
            if (c.getPlaca().equals(placa)) {
                return c;
            }
        }
        return null;
    }
    public Ruta buscarRuta(String id) {
        for (Ruta r: listRutas) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }
    public Envio buscarEnvio(String id) {
        for (Envio e: listEnvios) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
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

    public List<Camion> getListCamiones() {
        return listCamiones;
    }

    public void setListCamiones(List<Camion> listCamiones) {
        this.listCamiones = listCamiones;
    }

    public List<Ruta> getListRutas() {
        return listRutas;
    }

    public void setListRutas(List<Ruta> listRutas) {
        this.listRutas = listRutas;
    }
}