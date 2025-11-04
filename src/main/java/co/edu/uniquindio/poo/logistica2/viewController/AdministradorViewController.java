package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.AdministradorController;
import co.edu.uniquindio.poo.logistica2.model.Administrador;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AdministradorViewController {
    private App app;
    private AdministradorController controller;
    private Administrador administrador;

    public void setController(AdministradorController controller) {
        this.controller = controller;
    }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
        lblNombre.setText(administrador.getNombre());
    }
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    public void setApp(App app) {
        this.app = app;
    }
    @FXML
    public Label lblNombre;
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
    public void onGestionUsuario(){
        controller.irAGestionUsuario();
    }
    @FXML
    public void onAsignarEnvio(){
        controller.irAAsignarPedido();
    }


}
