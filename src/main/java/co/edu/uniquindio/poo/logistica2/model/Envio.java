package co.edu.uniquindio.poo.logistica2.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Envio implements ITarifa, ISujeto {
    private String id;
    private LocalDate fechaInicio;
    private LocalDate fechaEstimadaEntrega;
    private LocalDate fechaEntrega;
    private double costo;
    private Ruta ruta;
    private Repartidor repartidor;
    private List<Pedido> listPedidos;
    private List<IObservador> listObservadores;
    private IEstado estadoEnvio;

    public Envio (String id, LocalDate fechaInicio, LocalDate fechaEstimadaEntrega, Ruta ruta, Repartidor repartidor) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
        this.costo = costo;
        this.ruta = ruta;
        this.repartidor = repartidor;
        this.listPedidos = new ArrayList<>();
        this.listObservadores = new ArrayList<>();
        this.estadoEnvio = new Asignado();
    }

    @Override
    public double calcularCosto() {
        return ruta.getDistancia() * 2000;
    }

    public void cambiarEstado(IEstado nuevoEstado) {
        this.estadoEnvio = nuevoEstado;
        for (Pedido p: listPedidos){
            p.setEstado(nuevoEstado.getNombre());
            notificarObservador("El envío ahora está: " + estadoEnvio.getNombre());
        }
    }
    public String ejecutarAccion(String accion){
        return "";
    }
    // Métodos de estado

    public void asignar() { estadoEnvio.asignar(this); }
    public void enRuta() { estadoEnvio.EnRuta(this); }
    public void entregar() { estadoEnvio.entregar(this); }
    public void reportarIncidencia() { estadoEnvio.reportarIncidencia(this); }



    @Override
    public void agregarObservador(IObservador observador) {
        listObservadores.add(observador);
    }

    @Override
    public void eliminarObservador(IObservador observador) {
        listObservadores.remove(observador);
    }

    @Override
    public void notificarObservador(String mensaje) {
        for (IObservador o : listObservadores) {
            o.actualizar(mensaje);
        }

    }

    public LocalDate calcularFechaEstimadaEntrega(LocalDate fecha, Ruta ruta){
        double distancia = ruta.getDistancia();
        int diasAdicionales = 0;
        if (distancia > 0 && distancia < 50) {
            diasAdicionales = 5;
        } else if (distancia >= 50 && distancia < 100) {
            diasAdicionales = 10;
        } else {
            diasAdicionales = 15;
        }
        LocalDate fechaCalculada = fecha.plusDays(diasAdicionales);
        this.fechaEstimadaEntrega = fechaCalculada;
        return fechaCalculada;
    }

    public boolean revisarFechaInicio(LocalDate fecha){
        boolean centinela= true;
        for(Pedido p: listPedidos){
            if(p.getFechaCreacion().isAfter(fecha)){
                centinela= false;
            }
        }
        return centinela;
    }


    public boolean agregarPedido(Pedido pedido) {
        boolean centinela = false;
        if (!verificarPedido(pedido.getId())) {
            listPedidos.add(pedido);
            centinela = true;

        }

        return centinela;
    }

    public boolean verificarPedido(String id) {
        boolean centinela = false;
        for (Pedido p:  listPedidos) {
            if (p.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean eliminarPedido(String id) {
        boolean centinela = false;
        for (Pedido p:  listPedidos) {
            if (p.getId().equals(id)) {
                listPedidos.remove(p);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean actualizarPedido(String id, Pedido actualizado) {
        boolean centinela = false;
        for (Pedido p:  listPedidos) {
            if (p.getId().equals(id)) {
                p.setId(actualizado.getId());
                p.setFechaCreacion(actualizado.getFechaCreacion());
                p.setRuta(actualizado.getRuta());
                p.setUsuario(actualizado.getUsuario());
                p.setCosto(actualizado.getCosto());
                p.setFechaEstimadaEntrega(actualizado.getFechaEstimadaEntrega());
                p.setFechaEntrega(actualizado.getFechaEntrega());
                p.setPago(actualizado.getPago());
                centinela = true;
                break;

            }
        }
        return centinela;
    }

    public Pedido buscarPedido(String id) {
        for (Pedido p:   listPedidos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public List<IObservador> getListObservadores() {
        return listObservadores;
    }

    public void setListObservadores(List<IObservador> listObservadores) {
        this.listObservadores = listObservadores;
    }

    public IEstado getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(IEstado estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
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



    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public List<Pedido> getListPedidos() {
        return listPedidos;
    }

    public void setListPedidos(List<Pedido> listPedidos) {
        this.listPedidos = listPedidos;
    }
}