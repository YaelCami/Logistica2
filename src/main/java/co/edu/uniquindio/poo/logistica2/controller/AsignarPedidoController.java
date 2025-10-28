package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;

public class AsignarPedidoController {
    private App app;

    public void volver(){
        app.openAdministrador();
    }
    public void setApp(App app) {
        this.app = app;
    }
}
