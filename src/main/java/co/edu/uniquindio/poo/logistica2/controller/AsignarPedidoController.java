package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Administrador;
import co.edu.uniquindio.poo.logistica2.model.Envio;
import co.edu.uniquindio.poo.logistica2.model.Pedido;

import java.util.List;

public class AsignarPedidoController {
    private App app;
    private Administrador administrador;
    public AsignarPedidoController(Administrador administrador) {
        this.administrador = administrador;
    }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    public List<Pedido> obtenerPedidos(){
        return administrador.getListPedidos();
    }
    public boolean crearEnvio(Envio envio){
        return administrador.agregarEnvio(envio);
    }
    public boolean asignarPedidoAlEnvio(Envio envio, Pedido pedido){
        return envio.agregarPedido(pedido);
    }
    public void volver(){
        app.openAdministrador(administrador);
    }
    public void setApp(App app) {
        this.app = app;
    }
}
