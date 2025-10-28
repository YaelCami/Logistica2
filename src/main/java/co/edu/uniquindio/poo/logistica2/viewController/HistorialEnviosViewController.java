package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.HistorialEnviosController;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class HistorialEnviosViewController {
    private App app;
    private HistorialEnviosController controller;
    //FALTA TABLA
    @FXML
    public ComboBox<String> cbxEstado;//CAMBIAR TIPO
    @FXML
    public DatePicker dtpFecha;
    @FXML
    public void onDescargar(){}
    @FXML
    public void onRegresar(){
        controller.irAlInicio();
    }
    public void setApp(App app) {
        this.app = app;
    }
    public void setController(HistorialEnviosController controller) {
        this.controller = controller;
    }
}
