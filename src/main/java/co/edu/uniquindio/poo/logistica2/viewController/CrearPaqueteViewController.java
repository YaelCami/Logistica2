package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.CrearPaqueteController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CrearPaqueteViewController {
    private App app;
    private CrearPaqueteController controller;
    //FALTAN LAS TABLAS
    @FXML
    public TextField txtIdProducto,txtNombreP,txtMarcaP, txtPesoP,txtCantidadP, txtIdPaquete, txtVolumen;
    @FXML
    public Label lblPesoTotal;
    @FXML
    public void onAgregarProductoAlPaquete(){}
    @FXML
    public void onActualizarProducto(){}
    @FXML
    public void onEliminarProducto(){}
    @FXML
    public void onAgregarPaquete(){}
    @FXML
    public void onActualizarPaquete(){}
    @FXML
    public void onEliminarPaquete(){}
    @FXML
    public void onRegresar(){
        controller.regresar();
    }
    public void setApp(App app) {
        this.app = app;
    }
    public void setController(CrearPaqueteController controller) {
        this.controller = controller;
    }
}
