package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Usuario;

public class HistorialEnviosController {
    private App app;
    private Usuario usuario;

    public void irAlInicio() {
        app.openUsuario(usuario);
    }
    public void setApp(App app) {
        this.app = app;
    }
}
