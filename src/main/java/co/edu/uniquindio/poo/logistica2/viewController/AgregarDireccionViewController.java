package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.AgregarDireccionController;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AgregarDireccionViewController {
    private AgregarDireccionController controller;
    private App app;
    //FALTA TABLA
    @FXML
    public TextField txtId, txtAlias, txtCalle, txtCoordenadas;
    @FXML
    public ComboBox<String> cbxCiudad;//PROVISIONAL
    @FXML
    public void onAgregar(){}
    @FXML
    public void onActualizar(){}
    @FXML
    public void onEliminar(){}
    @FXML
    public void onRegresar(){
        controller.irAlInicio();
    }

    public void setApp(App app) {
        this.app = app;
    }

    public void setController(AgregarDireccionController controller) {
        this.controller = controller;
    }
}
