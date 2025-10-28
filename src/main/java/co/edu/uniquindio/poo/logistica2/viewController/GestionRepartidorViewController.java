package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.GestionRepartidorController;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class GestionRepartidorViewController {
    private App app;
    private GestionRepartidorController controller;
    //FALTAN TABLAS
    @FXML
    public TextField txtId,txtNombre, txtTelefono;
    @FXML
    public ComboBox<String> cbxEstado, cbxCiudades;//CAMBIAR
    @FXML
    public void onRegresar(){}
    @FXML
    public void onRegistrar(){}
    @FXML
    public void onActualizar(){}
    @FXML
    public void onEliminar(){}
    @FXML
    public void onGuardar(){}
    public void setApp(App app) {
        this.app = app;
    }
    public void setController(GestionRepartidorController controller) {
        this.controller = controller;
    }
}
