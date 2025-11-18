package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AsignarPedidoController {
    private App app;
    private Administrador administrador;
    private Repartidor repartidor;
    private EmpresaLogistica empresaLogistica = EmpresaLogistica.getInstance();
    public AsignarPedidoController(Administrador administrador) {
        this.administrador = administrador;
    }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Pedido> getPedidos(Ruta ruta){
        List<Pedido> pedidosSegunRuta = new ArrayList<>();
        List<Pedido> listPedidos = empresaLogistica.getListPedidos();
        for (Pedido pedido : listPedidos){
            if(pedido.getOrigen().getCiudad().equals(ruta.getCiudadOrigen()) && pedido.getDestino().getCiudad().equals(ruta.getCiudadDestino())){
                pedidosSegunRuta.add(pedido);
            }
        }
        return pedidosSegunRuta;
    }
    public List<Repartidor> getRepartidores(Ruta ruta){
        List<Repartidor> repartidors = new ArrayList<>();
        List<Repartidor> listRepartidores = empresaLogistica.getListRepartidores();
        for (Repartidor repartidor : listRepartidores) {
            List<Ruta> rutas = repartidor.getZonaCobertura();
            for(Ruta r: rutas ){
                if(repartidor.getDisponibilidad() == Disponibilidad.ACTIVO && r.equals(ruta)){
                    repartidors.add(repartidor);
                }
            }
        }
        return repartidors;
    }
    public boolean crearEnvio(Envio envio){
        if (administrador.agregarEnvio(envio)){
            List<Pedido> pedidos = envio.getListPedidos();
            for (Pedido pedido : pedidos){
                pedido.setEstado(envio.getEstadoEnvio().getNombre());
                return true;
            }
        }
        return false;
    }
    public LocalDate calcularFechaEstimada(LocalDate fecha, Ruta ruta){
        Envio envio = new Envio("78", fecha, LocalDate.of(2025, 10,17), ruta, repartidor);
        if (fecha == null || ruta == null){
            System.out.println("Algún valor es nulo para calcular fecha estimad de entrega");
            return null;
        }
        try{
            System.out.println("Calculando Fecha Estimada");
            LocalDate fechaEstimada = envio.calcularFechaEstimadaEntrega(fecha, ruta);
            if (fechaEstimada == null){
                System.out.println("Fecha Estimada no encontrada");
                return null;
            }
            System.out.println("Fecha Estimada: " + fechaEstimada);
            return fechaEstimada;
        } catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public boolean asignarPedidoAlEnvio(Envio envio, Pedido pedido){
        return envio.agregarPedido(pedido);

    }
    public List<Ruta> obtenerRutas(){
        return empresaLogistica.getListRutas();
    }
    public void volver(){
        app.openAdministrador(administrador);
    }
    public void setApp(App app) {
        this.app = app;
    }
    public List<Repartidor> obtenerRepartidores(Ruta ruta){
        return administrador.buscarRepartidorRutaDisponible(ruta);
    }
    public List<Pedido> obtenerPedidos(Ruta ruta){
        return administrador.buscarPedidosRuta(ruta);
    }
}
