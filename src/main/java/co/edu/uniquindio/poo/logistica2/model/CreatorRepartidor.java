package co.edu.uniquindio.poo.logistica2.model;

public class CreatorRepartidor extends CreatorPersona<RepartidorDTO>{
    private static int secuencia = 0;

    private String generarDocumento() {
        secuencia++;
        return String.format("%04d", secuencia);
    }
    @Override
    public Persona crearPersona(RepartidorDTO dto) {
        return new Repartidor.Builder().nombre(dto.nombre)
                .telefono(dto.telefono)
                .correo(dto.correo)
                .id(dto.id)
                .documento(generarDocumento())
                .disponibilidad(dto.disponibilidad)
                .zonaCobertura(dto.zonaCobertura)
                .listEnvios(dto.envios)
                .build();

    }

}
