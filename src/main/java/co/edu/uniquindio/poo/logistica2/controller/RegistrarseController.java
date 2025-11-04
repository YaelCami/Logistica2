package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;

public class RegistrarseController {
    private App app;
    public void volver(){
        app.openViewPrincipal();
    }
    public void setApp(App app) {
        this.app = app;
    }
}
