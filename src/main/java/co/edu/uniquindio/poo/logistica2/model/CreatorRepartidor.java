package co.edu.uniquindio.poo.logistica2.model;

public class CreatorRepartidor extends CreatorPersona<RepartidorDTO>{
    /**
     * Crea un objeto Repartidor} utilizando los datos
     * proporcionados en un {@link RepartidorDTO}.
     *
     * @param dto objeto que contiene la información necesaria para crear un repartidor
     * @return una instancia de {@link Persona} del tipo {@link Repartidor}
     */
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
