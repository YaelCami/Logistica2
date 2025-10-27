package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;

public class SolicitarPedidoController {
    private App app;

    public void irAlUsuario() {
        app.openUsuario();
    }
    public void setApp(App app) {
        this.app = app;
    }
}
