package co.edu.uniquindio.poo.logistica2.model;

public class CreatorRepartidor extends CreatorPersona<RepartidorDTO>{

    @Override
    public Persona crearPersona(RepartidorDTO dto) {
        return new Repartidor.Builder().nombre(dto.nombre)
                .telefono(dto.telefono)
                .correo(dto.correo)
                .id(dto.id)
                .documento(dto.documento)
                .disponibilidad(dto.disponibilidad)
                .zonaCobertura(dto.zonaCobertura)
                .listEnvios(dto.envios)
                .build();

    }

}