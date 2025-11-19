package co.edu.uniquindio.poo.logistica2.model;

public class UsuarioDTO {
    public String id;
    public String nombre;
    public String correo;
    public String telefono;

    /**
     * Construye un nuevo UsuarioDTO con los datos proporcionados.
     *
     * @param id Identificador del usuario.
     * @param nombre Nombre del usuario.
     * @param correo Correo electrónico del usuario.
     * @param telefono Número de teléfono del usuario.
     */
    public UsuarioDTO(String id, String nombre, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }
}
