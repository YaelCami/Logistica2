package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.*;

import java.time.LocalDate;
import java.util.List;

public class SolicitarPedidoController {
    private App app;
    private Usuario usuario;
    private EmpresaLogistica empresa;
    private Pedido pedido;

    public SolicitarPedidoController() {
        this.empresa= EmpresaLogistica.getInstance();
    }
    public void irAlUsuario() {
        app.openUsuario(usuario);
    }
    public void setApp(App app) {
        this.app = app;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public boolean realizarPedido(Pedido pedido) {
        usuario.solicitarPedido(pedido);
        return true;
    }
    public LocalDate calcularFechaEstimadaEntrega(Pedido pedido,Direccion origen, Direccion destino, LocalDate fecha) {
        Ruta ruta = pedido.puedePedir(origen, destino);
        return pedido.calcularFechaEstimadaEntrega(ruta);
    }

    public double calcularCostoPedido(Pedido pedido) {
        return pedido.calcularCostoPedido();
    }

    public List<Pedido> obtenerPedidos() {
        return usuario.getListPedidos();
    }
    public List<Direccion> obtenerDirecciones() {
        return usuario.getListDirecciones();
    }
    public List<Paquete> obtenerPaquetes() {
        return usuario.getListPaquetes();
    }
}
