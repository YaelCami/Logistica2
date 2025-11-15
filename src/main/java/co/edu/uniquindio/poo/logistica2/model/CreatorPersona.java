package co.edu.uniquindio.poo.logistica2.model;

public abstract class CreatorPersona<T> {
    public abstract Persona crearPersona(T dto);
}
