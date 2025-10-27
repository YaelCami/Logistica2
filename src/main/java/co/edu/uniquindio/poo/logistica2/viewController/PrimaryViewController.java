package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.PrimaryController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryViewController {
    private App app;
    private PrimaryController controller;
    public void setApp(App app) {
        this.app = app;
    }
    public void setPrimaryController(PrimaryController controller) {
        this.controller = controller;
    }
    @FXML
    public Button btnIngresarId, btnCotizarTarifa, btnRastrearPedido;
    @FXML
    public TextField txtIngresarId;
    @FXML
    private void onAdmi(){
        controller.irALAdmi();//PROVISIONAL
    }
    @FXML
    private void onIngresar(){
        controller.irAUsuario();//PROVISIONAL
    }
    @FXML
    private void onCotizar(){
        controller.irACotizar();
    }
    @FXML
    private void onRastrear(){
        controller.irAlRastreo();
    }
}
