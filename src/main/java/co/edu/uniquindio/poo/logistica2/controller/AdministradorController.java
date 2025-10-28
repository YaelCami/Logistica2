package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;

public class AdministradorController {
    private App app;

    public void irAActualizarEstadoEnvio(){
        app.openActualizarEnvio();
    }
    public void irAAsignarPedido(){
        app.openAsignarPedido();
    }
    public void irAGestionRepartidor(){
        app.openGestionRepartidor();
    }
    public void irAlInicio() {
        app.openViewPrincipal();
    }
    public void setApp(App app) {
        this.app = app;
    }
}
