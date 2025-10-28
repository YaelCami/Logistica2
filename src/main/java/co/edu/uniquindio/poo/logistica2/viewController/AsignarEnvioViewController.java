package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.AsignarPedidoController;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AsignarEnvioViewController {
    private App app;
    private AsignarPedidoController controller;
    //FALTA TABLA
    @FXML
    public TextField txtId;
    @FXML
    public DatePicker dtpFecha;
    @FXML
    public ComboBox<String> cbxPedido, cbxRepartidor; //CAMBIAR
    @FXML
    public void onRegresa(){
        controller.volver();
    }
    @FXML
    public void onAsignar(){}
    @FXML
    public void onCrearEnvio(){}
    public void setApp(App app) {
        this.app = app;
    }
    public void setController(AsignarPedidoController controller) {
        this.controller = controller;
    }
}
