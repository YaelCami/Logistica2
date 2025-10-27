package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.UsuarioController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UsuarioViewController {
    private App app;
    private UsuarioController controller;

    @FXML
    private Label lblNombreUsuario;
    @FXML
    private void onGestionDireccion(){
        controller.irAgregarDireccion();
    }
    @FXML
    private void onVisualizarHistorial(){
        controller.irAlHistorial();
    }
    @FXML
    private void onSolicitarPedido(){
        controller.irSolicitarPedido();
    }
    @FXML
    private void onCrearPaquete(){
        controller.irACrearPaquete();
    }
    @FXML
    private void onRegresar(){
        controller.irAlInicio();
    }
    public void setController(UsuarioController controller) {
        this.controller = controller;
    }
    public void setApp(App app) {
        this.app = app;
    }
}
