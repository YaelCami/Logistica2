package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Usuario;

public class RastrearPedidoController {
    private App app;
    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String rastrearPedido(String id) {
        return usuario.rastrearPedido(id);
    }
    public void setApp(App app) {
        this.app = app;
    }
    public void irAlInicio() {
        app.openUsuario(usuario);
    }
}
