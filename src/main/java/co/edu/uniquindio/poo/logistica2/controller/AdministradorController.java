package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Administrador;
import co.edu.uniquindio.poo.logistica2.model.EmpresaLogistica;

public class AdministradorController {
    private App app;
    private Administrador administrador;
    private EmpresaLogistica empresa;

    public void setApp(App app) {
        this.app = app;
    }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public void irAGestionUsuario(){
        app.openGestionarUsuario(administrador);
    }
    public void irAActualizarEstadoEnvio(){
        app.openActualizarEnvio();
    }
    public void irAAsignarPedido(){
        app.openAsignarPedido();
    }
    public void irAGestionRepartidor(){
        app.openGestionRepartidor(administrador);
    }
    public void irAlInicio() {
        app.openViewPrincipal();
    }
    public void irAGestionCiudad() {
        app.openGestionarCiudad(administrador);
    }
    public void irAGestionRuta(){
        app.openGestionarRuta(administrador);
    }

}
