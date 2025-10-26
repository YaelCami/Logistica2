package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;

public class RastrearPedidoController {
    private App app;

    public void setApp(App app) {
        this.app = app;
    }
    public void irAlInicio() {
        app.openViewPrincipal();
    }
}
