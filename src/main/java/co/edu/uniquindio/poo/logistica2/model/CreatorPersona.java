package co.edu.uniquindio.poo.logistica2.model;

/**
 * Clase abstracta que define un creador genérico de objetos {@link Persona}.
 *
 * <p>Forma parte de un patrón Factory Method, donde las subclases
 * implementan la lógica necesaria para crear una persona a partir
 * de un objeto DTO.</p>
 *
 * @param <T> el tipo del DTO utilizado para crear la persona
 */
public abstract class CreatorPersona<T> {
    /**
     * Crea una instancia de  Persona a partir del DTO proporcionado.
     *
     * @param dto objeto que contiene la información necesaria para crear una persona
     * @return una nueva instancia de Persona creada a partir del DTO
     */
    public abstract Persona crearPersona(T dto);
}
