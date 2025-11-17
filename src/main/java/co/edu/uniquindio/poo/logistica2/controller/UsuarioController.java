package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Usuario;

public class UsuarioController {
    private App app;
    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void irAgregarDireccion() {
        if (usuario == null) {
            System.out.println("Error: usuario es null en UsuarioController");
            return;
        }
        app.openAgregarDireccion(usuario);
    }

    public void irAlHistorial(){
        app.openHistorialEnvios(usuario);
    }
    public void irSolicitarPedido(){
        app.openSolicitarPedido(usuario);
    }
    public void irACrearPaquete(){
        app.openCrearPaquete(usuario);
    }
    public void irAlInicio(){
        app.openViewPrincipal();
    }
    public void setApp(App app) {
        this.app = app;
    }
}
