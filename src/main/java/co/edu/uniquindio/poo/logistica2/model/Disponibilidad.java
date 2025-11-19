package co.edu.uniquindio.poo.logistica2.model;

/**
 * Representa el estado de disponibilidad de un repartidor.
 * Indica si puede recibir pedidos, si está inactivo o si se encuentra
 * actualmente realizando una entrega.
 */
public enum Disponibilidad {
    ACTIVO,
    INACTIVO,
    ENRUTA;
}
