package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Usuario;

public class SolicitarPedidoController {
    private App app;
    private Usuario usuario;

    public void irAlUsuario() {
        app.openUsuario(usuario);
    }
    public void setApp(App app) {
        this.app = app;
    }
}
