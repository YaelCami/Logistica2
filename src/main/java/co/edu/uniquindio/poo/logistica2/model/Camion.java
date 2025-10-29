package co.edu.uniquindio.poo.logistica2.model;

public class Camion {
    private String capacidad;
    private String placa;
    private String modelo;

    public Camion(String capacidad, String placa, String modelo) {
        this.capacidad = capacidad;
        this.placa = placa;
        this.modelo = modelo;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
