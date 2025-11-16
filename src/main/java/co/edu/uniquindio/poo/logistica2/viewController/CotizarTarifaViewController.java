package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.CotizarTarifaController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CotizarTarifaViewController {
    private App app;
    private CotizarTarifaController controller;

    @FXML
    public Label lblPrecio;
    @FXML
    public TextField txtVolumen, txtPeso, txtCoordenadasDestino, txtCoordenadasOrigen;
    @FXML
    public ComboBox<String> cbxCiudadOrigen, cbxCiudadDestino, cbxCondicion;
    @FXML
    public void onCalcularTarifa(){}
    @FXML
    public void onIngresar(){}
    @FXML
    public void onBuscarDireccionDestino(){}
    @FXML
    public void onBuscarDireccionOrigen(){}
    @FXML
    public void onRegresar(){
        controller.irAlInicio();
    }
    public void setApp(App app) {
        this.app = app;
    }
    public void setController(CotizarTarifaController controller) {
        this.controller = controller;
    }
}
