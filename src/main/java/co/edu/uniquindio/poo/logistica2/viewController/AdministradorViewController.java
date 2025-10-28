package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.AdministradorController;
import javafx.fxml.FXML;

public class AdministradorViewController {
    private App app;
    private AdministradorController controller;

    @FXML
    public void onActualizarEnvio(){
        controller.irAActualizarEstadoEnvio();
    }
    @FXML
    public void onRegresar(){
        controller.irAlInicio();
    }
    @FXML
    public void onGestionRepartidor(){
        controller.irAGestionRepartidor();
    }
    @FXML
    public void onAsignarEnvio(){
        controller.irAAsignarPedido();
    }
    public void setApp(App app) {
        this.app = app;
    }
    public void setController(AdministradorController controller) {
        this.controller = controller;
    }
}
