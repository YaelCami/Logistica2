package co.edu.uniquindio.poo.logistica2.model;

import java.util.ArrayList;
import java.util.List;

public class Repartidor extends Persona {

    private String documento;
    private Disponibilidad disponibilidad;
    private List<Camion> listCamiones;
    private List<Ruta> listRutas;
    private List<Envio> listEnvios;

    public Repartidor(Builder builder, String documento, Disponibilidad disponibilidad) {
        super(builder);
        this.documento = documento;
        this.disponibilidad = disponibilidad;
        this.listCamiones = new ArrayList<>();
        this.listRutas = new ArrayList<>();
        this.listEnvios = new ArrayList<>();
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
