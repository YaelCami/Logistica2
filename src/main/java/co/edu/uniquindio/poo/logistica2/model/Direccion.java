package co.edu.uniquindio.poo.logistica2.model;

public class Direccion {
    private String id;
    private String alias;
    private String calle;
    private Ciudad  ciudad;
    private String coordenadas;

    /**
     * Construye una nueva dirección con todos sus atributos.
     *
     * @param id           identificador único de la dirección
     * @param alias        alias asignado a la dirección
     * @param calle        nombre de la calle
     * @param ciudad       ciudad donde se encuentra la dirección
     * @param coordenadas  coordenadas geográficas
     */
    public Direccion(String id, String alias, String calle, Ciudad ciudad, String coordenadas) {
        this.id = id;
        this.alias = alias;
        this.calle = calle;
        this.ciudad = ciudad;
        this.coordenadas = coordenadas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    /**
     * Devuelve una representación legible de la dirección,
     * formato amigable para mostrar en listas o reportes.
     *
     * @return cadena formateada con los datos principales de la dirección
     */
    @Override
    public String toString() {
        return String.format(
                "Alias: %-15s\n" +
                        "  Calle: %-25s\n" +
                        "  Ciudad: %-20s\n" +
                        "  Coordenadas: %-15s",
                alias,
                calle,
                ciudad,
                coordenadas
        );
    }
}
