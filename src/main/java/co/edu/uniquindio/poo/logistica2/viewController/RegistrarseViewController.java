package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.RegistrarseController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RegistrarseViewController {
    private App app;
    private RegistrarseController controller;

    @FXML
    public TextField txtId, txtNombre, txtCorreo, txtTelefono;
    @FXML
    public void onRegresar(){
        controller.volver();
    }
    @FXML
    public void onRegistrar(){}
    public void setApp(App app) {
        this.app = app;
    }
    public void setController(RegistrarseController controller) {
        this.controller = controller;
    }
}
