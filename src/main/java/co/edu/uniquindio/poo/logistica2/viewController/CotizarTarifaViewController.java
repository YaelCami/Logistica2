package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.CotizarTarifaController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CotizarTarifaViewController {
    private App app;
    private CotizarTarifaController controller;

    @FXML
    private Button btnRegresar;
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
