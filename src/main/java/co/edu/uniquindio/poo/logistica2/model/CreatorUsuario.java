package co.edu.uniquindio.poo.logistica2.model;

public class CreatorUsuario extends CreatorPersona<UsuarioDTO> {
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
