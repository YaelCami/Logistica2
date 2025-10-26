package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.UsuarioController;

public class UsuarioViewController {
    private App app;
    private UsuarioController controller;

    public void setController(UsuarioController controller) {
        this.controller = controller;
    }
    public void setApp(App app) {
        this.app = app;
    }
}
