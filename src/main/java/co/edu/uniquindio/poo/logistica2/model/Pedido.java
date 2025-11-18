package co.edu.uniquindio.poo.logistica2.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements IPedido{
    private EmpresaLogistica empresaLogistica = EmpresaLogistica.getInstance();
    private String id;
    private double costo;
    private double extra;
    private String descripcion;
    private LocalDate fechaCreacion;
    private LocalDate fechaEntrega;
    private LocalDate fechaEstimadaEntrega;
    private String estado;
    private Direccion origen;
    private Direccion destino;
    private Ruta ruta;
    private Usuario usuario;
    private Pago pago;
    private Envio envio;
    private IPedido iPedido;
    private Paquete paquete;

    /**
     * Constructor de la clase Pedido.
     *
     * @param id ID único del pedido.
     * @param fechaCreacion Fecha en la que se creó el pedido.
     * @param origen Dirección de origen.
     * @param destino Dirección de destino.
     * @param usuario Usuario que solicita el pedido.
     * @param fechaEstimadaEntrega Fecha estimada de entrega calculada.
     * @param paquete Paquete asociado al pedido.
     */
    public Pedido(String id, LocalDate fechaCreacion, Direccion origen, Direccion destino, Usuario usuario, LocalDate fechaEstimadaEntrega, Paquete paquete) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.ruta = ruta;
        this.usuario = usuario;
        this.costo = costo;
        this.extra = extra;
        this.descripcion = descripcion;
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.origen = origen;
        this.destino = destino;
        this.paquete = paquete;
        this.iPedido = iPedido;
        this.pago = pago;
    }
    /**
     * Devuelve la descripción base del pedido.
     *
     * @return "Paquete normal".
     */
    @Override
    public String getDescripcion() {
        return "Paquete normal";
    }
    /**
     * Devuelve el costo adicional del pedido (usado en decoradores).
     *
     * @return Valor adicional, por defecto 0.0.
     */
    @Override
    public double getExtras() {
        return 0.0;
    }
    /**
     * Obtiene el estado del pedido. Si el pedido no tiene envío asignado,
     * devuelve "Solicitado". En caso contrario, toma el estado desde el envío.
     *
     * @return Estado actual del pedido.
     */
    public String getEstado() {
        if(this.getEnvio() == null){
            return estado = "Solicitado";
        }
        return this.getEnvio().getEstadoEnvio().getNombre();
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    /**
     * Calcula el costo total del pedido basado en:
     * - Distancia de la ruta
     * - Peso del paquete
     * - Volumen del paquete
     * - Extras aplicados por decoradores
     *
     * @return Costo total del pedido.
     */
    public double calcularCostoPedido(){
        double costoBase = 0;
        double distancia = ruta.getDistancia();
        if (distancia > 100) {
            costoBase = 8000;
        } else {
            costoBase = 4000;
        }
        double peso = paquete.getPeso();
        if(peso <= 6){
            costoBase += 2000;
        } else {
            costoBase += 5000;
        }
        double volumen = paquete.getVolumen();
        if (volumen <= 50000){
            costoBase += 3000;
        } else {
            costoBase += 7000;
        }
        double extras = getExtras();

        return costoBase + extras;
    }
    /**
     * Verifica si existe una ruta disponible entre el origen y el destino del pedido.
     *
     * @param origen Dirección de origen.
     * @param destino Dirección de destino.
     * @return Ruta válida si existe, o null si no se encontró coincidencia.
     */
    public Ruta puedePedir(Direccion origen, Direccion destino){
        ruta= null;
        List<Ruta> listaRutas = empresaLogistica.getListRutas();
        for(Ruta r: listaRutas){
            if(origen.getCiudad().equals(r.getCiudadOrigen()) && destino.getCiudad().equals(r.getCiudadDestino())){
                ruta= r;
                break;
            }
        }
        return ruta;
    }
    /**
     * Calcula una fecha estimada de entrega basada en la distancia.
     *
     * @param fechaCreacion Fecha en la que se realizó el pedido.
     * @param ruta Ruta del pedido.
     * @return Fecha estimada calculada.
     */
    public LocalDate calcularFechaEstimadaEntrega(LocalDate fechaCreacion, Ruta ruta) {
        double distancia = ruta.getDistancia();
        int diasAdicionales = 0;
        if (distancia > 0 && distancia < 50) {
            diasAdicionales = 5;
        } else if (distancia >= 50 && distancia < 100) {
            diasAdicionales = 10;
        } else {
            diasAdicionales = 15;
        }
        LocalDate fechaCalculada = fechaCreacion.plusDays(diasAdicionales);
        this.fechaEstimadaEntrega = fechaCalculada;
        return fechaCalculada;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public LocalDate getFechaEstimadaEntrega() {
        return fechaEstimadaEntrega;
    }

    public void setFechaEstimadaEntrega(LocalDate fechaEstimadaEntrega) {
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getExtra() {
        return extra;
    }

    public void setExtra(double extra) {
        this.extra = extra;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    public IPedido getiPedido() {
        return iPedido;
    }

    public void setiPedido(IPedido iPedido) {
        this.iPedido = iPedido;
    }

    public Direccion getOrigen() {
        return origen;
    }

    public void setOrigen(Direccion origen) {
        this.origen = origen;
    }

    public Direccion getDestino() {
        return destino;
    }

    public void setDestino(Direccion destino) {
        this.destino = destino;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
    public void setDecorador(IPedido iPedido) {
        this.iPedido = iPedido;
    }
    public void setExtras(Double extras) {
        this.extra = extras;
    }
}