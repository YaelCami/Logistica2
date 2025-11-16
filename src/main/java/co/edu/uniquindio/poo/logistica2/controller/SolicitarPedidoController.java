package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.*;

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
