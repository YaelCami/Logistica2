package co.edu.uniquindio.poo.logistica2.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String id;
    private double costo;
    private LocalDate fechaCreacion;
    private LocalDate fechaEntrega;
    private LocalDate fechaEstimadaEntrega;
    private List<Direccion> listDirecciones;
    private Ruta ruta;
    private Usuario usuario;
    private Pago pago;
    private List<Paquete> listpaquetes;

    public Pedido(String id, LocalDate fechaCreacion, Ruta ruta, Usuario usuario){
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.ruta = ruta;
        this.usuario = usuario;
        this.costo = costo;
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
        this.fechaEntrega = fechaEntrega;
        this.listDirecciones = new ArrayList<>();
        this.listpaquetes = new ArrayList<>();
        this.pago = pago;
    }

    public void realizarAccion(String accion) {
        String resultado = envio.ejecutarAccion(accion);
        System.out.println("📦 Pedido " + id + ": " + resultado);
    }

    public boolean agregarPaquete(Paquete paquete){
        boolean centinela = false;
        for (Paquete p: listpaquetes) {
            if (!verificarPaquete(p.getId())) {
                listpaquetes.add(p);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean agregarDireccion(Direccion direccion){
        boolean centinela = false;
        for (Direccion d: listDirecciones) {
            if (!verificarDireccion(d.getId())) {
                listDirecciones.add(d);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarPaquete(String id){
        boolean centinela = false;
        for (Paquete p: listpaquetes) {
            if (p.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean verificarDireccion(String id){
        boolean centinela = false;
        for (Direccion d: listDirecciones) {
            if (d.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean eliminarPaquete(String id){
        boolean centinela = false;
        for (Paquete p: listpaquetes) {
            if (p.getId().equals(id)) {
                listpaquetes.remove(p);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean eliminarDireccion(String id){
        boolean centinela = false;
        for (Direccion d: listDirecciones) {
            if (d.getId().equals(id)) {
                listDirecciones.remove(d);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean actualizarPaquete(String id, Paquete actualizado){
        boolean centinela = false;
        for (Paquete p: listpaquetes) {
            if (p.getId().equals(id)) {
                p.setId(actualizado.getId());
                p.setPeso(actualizado.getPeso());
                p.setVolumen(actualizado.getVolumen());
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean actualizarDireecion(String id, Direccion actualizado){
        boolean centinela = false;
        for (Direccion d: listDirecciones) {
            if (d.getId().equals(id)) {
                d.setId(actualizado.getId());
                d.setAlias(actualizado.getAlias());
                d.setCalle(actualizado.getCalle());
                d.setCalle(actualizado.getCalle());
                d.setCiudad(actualizado.getCiudad());
                d.setCoordenadas(actualizado.getCoordenadas());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public Paquete buscarPaquete(String id){
        for (Paquete p: listpaquetes) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public double calcularCosto(){
        return costo;
    }

    public List<Paquete> getListpaquetes() {
        return listpaquetes;
    }

    public void setListpaquetes(List<Paquete> listpaquetes) {
        this.listpaquetes = listpaquetes;
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

    public List<Direccion> getListDirecciones() {
        return listDirecciones;
    }

    public void setListDirecciones(List<Direccion> listDirecciones) {
        this.listDirecciones = listDirecciones;
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
}
