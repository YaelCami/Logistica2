package co.edu.uniquindio.poo.logistica2.model;

import java.util.List;

public class RepartidorDTO {
    public String id;
    public String nombre;
    public String correo;
    public String telefono;
    public String documento;
    public Disponibilidad disponibilidad;
    public List<Ruta> zonaCobertura;
    public List<Envio> envios;

    /**
     * Constructor principal del DTO Repartidor.
     *
     * @param id identificador único del repartidor.
     * @param nombre nombre completo del repartidor.
     * @param correo correo electrónico del repartidor.
     * @param telefono número telefónico del repartidor.
     * @param documento documento de identidad del repartidor.
     * @param disponibilidad disponibilidad actual del repartidor.
     * @param zonaCobertura lista de rutas que cubre el repartidor.
     * @param envios lista de envíos asignados.
     */
    public RepartidorDTO(String id, String nombre, String correo, String telefono,String documento, Disponibilidad disponibilidad, List<Ruta> zonaCobertura, List<Envio> envios) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.documento = documento;
        this.disponibilidad = disponibilidad;
        this.zonaCobertura = zonaCobertura;
        this.envios = envios;
    }
}
