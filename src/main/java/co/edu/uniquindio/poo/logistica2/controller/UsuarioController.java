package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Usuario;

public class UsuarioController {
    private App app;
    private Usuario usuario;

    public void irAgregarDireccion(){
        app.openAgregarDireccion(usuario);
    }
    public void irAlHistorial(){
        app.openHistorialEnvios();
    }
    public void irSolicitarPedido(){
        app.openSolicitarPedido();
    }
    public void irACrearPaquete(){
        app.openCrearPaquete();
    }
    public void irAlInicio(){
        app.openViewPrincipal();
    }
    public void setApp(App app) {
        this.app = app;
    }
}
