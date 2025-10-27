package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import javafx.application.Application;

public class AgregarDireccionController {
    private App app;

    public void irAlInicio() {
        app.openUsuario();
    }
    public void setApp(App app) {
        this.app = app;
    }
}
