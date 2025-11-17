package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Administrador;

public class AsignarPedidoController {
    private App app;
    private Administrador administrador;
    public AsignarPedidoController(Administrador administrador) {
        this.administrador = administrador;
    }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    public void volver(){
        app.openAdministrador(administrador);
    }
    public void setApp(App app) {
        this.app = app;
    }
}
