package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.ActualizarEstadoEnvioController;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class ActualizarEstadoEnvioViewController {
    private App app;
    private ActualizarEstadoEnvioController controller;
    //FALTA TABLA
    @FXML
    public ComboBox<String> cbxEstado, cbxRepartidor;//CAMBIAR
    @FXML
    public void onRegresar(){
        controller.volver();
    }
    @FXML
    public void onActualizar(){}
    @FXML
    public void onEliminar(){}
    public void setApp(App app) {
        this.app = app;
    }
    public void setController(ActualizarEstadoEnvioController controller) {
        this.controller = controller;
    }

}
