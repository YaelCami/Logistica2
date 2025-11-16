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
    private Direccion origen;
    private Direccion destino;
    private Ruta ruta;
    private Usuario usuario;
    private Pago pago;
    private Envio envio;
    private IPedido iPedido;
    private Paquete paquete;


    public Pedido(String id, LocalDate fechaCreacion, Direccion origen, Direccion destino, Usuario usuario){
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.ruta = ruta;
        this.usuario = usuario;
        this.costo = costo;
        this.extra = extra;
        this.descripcion = descripcion;
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
        this.fechaEntrega = fechaEntrega;
        this.origen = origen;
        this.destino = destino;
        this.paquete = paquete;
        this.pago = pago;
    }
    @Override
    public String getDescripcion() {
        return "Paquete normal";
    }
    @Override
    public double getExtras() {
        return 0.0;
    }

    public double calcularCostoPedido(){
        // 1. Costo por distancia
        double distancia = ruta.getDistancia();
        if(distancia > 100) {
            costo += 8000;
        } // Ejemplo: extra por larga distancia
        else {
            costo += 4000;
        }

        // 2. Extra por el decorator
        costo += iPedido.getExtras();

        return costo;
    }

    public Ruta puedePedir(Direccion origen, Direccion destino){
        Ruta ruta= null;
        List<Ruta> listaRutas = empresaLogistica.getListRutas();
        for(Ruta r: listaRutas){
            if(origen.getCiudad().equals(r.getCiudadOrigen()) && destino.getCiudad().equals(r.getCiudadDestino())){
                ruta= r;
                break;
            }
        }
        return ruta;
    }

    public LocalDate calcularFechaEstimadaEntrega(Ruta ruta){
        double distancia = ruta.getDistancia();
        if(distancia >0 && distancia < 50) {
            fechaEstimadaEntrega.plusDays(5);
        }
        else if(distancia > 50 && distancia < 100) {
            fechaEstimadaEntrega.plusDays(10);
        }
        else{
            fechaEstimadaEntrega.plusDays(15);
        }
        return fechaEstimadaEntrega;
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
}