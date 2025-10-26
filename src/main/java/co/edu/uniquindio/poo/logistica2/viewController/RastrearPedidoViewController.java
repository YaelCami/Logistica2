package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.RastrearPedidoController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RastrearPedidoViewController {
    private App app;
    private RastrearPedidoController controller;

    public void setApp(App app) {
        this.app = app;
    }
    public void setController(RastrearPedidoController controller) {
        this.controller = controller;
    }
    @FXML
    private Button btnRegresar;
    @FXML
    public void onRegresar(){
        controller.irAlInicio();
    }
}
