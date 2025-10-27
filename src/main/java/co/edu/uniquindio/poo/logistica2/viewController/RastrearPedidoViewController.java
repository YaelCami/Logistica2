package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.RastrearPedidoController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RastrearPedidoViewController {
    private App app;
    private RastrearPedidoController controller;

    @FXML
    private TextArea txaInfoPedido;
    @FXML
    private TextField txtIdPedido;
    @FXML
    public void onLimpiar(){}
    @FXML
    public void onBuscarPedido(){}
    public void setApp(App app) {
        this.app = app;
    }
    public void setController(RastrearPedidoController controller) {
        this.controller = controller;
    }
    @FXML
    public void onRegresar(){
        controller.irAlInicio();
    }
}
