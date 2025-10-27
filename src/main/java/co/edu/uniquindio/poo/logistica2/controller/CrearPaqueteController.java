package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;

public class CrearPaqueteController {
    private App app;

    public void regresar(){
        app.openUsuario();
    }
    public void setApp(App app) {
        this.app = app;
    }
}
