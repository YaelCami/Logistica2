package co.edu.uniquindio.poo.logistica2.model;

public class CreatorUsuario extends CreatorPersona<UsuarioDTO> {
    /**
     * Crea un objeto {@link Usuario} utilizando los datos
     * proporcionados en un {@link UsuarioDTO}.
     *
     * @param dto objeto que contiene la información necesaria para crear un usuario
     * @return una instancia de {@link Persona} del tipo {@link Usuario}
     */
    @Override
    public Persona crearPersona(UsuarioDTO dto) {
        return new Usuario.Builder()
                .nombre(dto.nombre)
                .telefono(dto.telefono)
                .correo(dto.correo)
                .id(dto.id)
                .build();
    }
}
