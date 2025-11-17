package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.*;

import java.util.List;

public class AsignarPedidoController {
    private App app;
    private Administrador administrador;
    private EmpresaLogistica empresaLogistica = EmpresaLogistica.getInstance();
    public AsignarPedidoController(Administrador administrador) {
        this.administrador = administrador;
    }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    public List<Pedido> obtenerPedidos(){
        return administrador.getListPedidos();
    }
    public List<Repartidor> obtenerRepartidores(){
        return empresaLogistica.getListRepartidores();
    }
    public boolean crearEnvio(Envio envio){
        return administrador.agregarEnvio(envio);
    }
    public boolean asignarPedidoAlEnvio(Envio envio, Pedido pedido){
        return envio.agregarPedido(pedido);
    }
    public List<Ruta> obtenerRutas(){
        return administrador.getListRutas();
    }
    public void volver(){
        app.openAdministrador(administrador);
    }
    public void setApp(App app) {
        this.app = app;
    }
}
