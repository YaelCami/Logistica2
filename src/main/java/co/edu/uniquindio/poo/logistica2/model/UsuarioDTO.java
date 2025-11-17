package co.edu.uniquindio.poo.logistica2.model;

public class UsuarioDTO {
    public String id;
    public String nombre;
    public String correo;
    public String telefono;

    public UsuarioDTO(String id, String nombre, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }
}
