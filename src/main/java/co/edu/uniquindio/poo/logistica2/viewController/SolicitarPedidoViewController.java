package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.SolicitarPedidoController;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SolicitarPedidoViewController {
    private App app;
    private SolicitarPedidoController controller;

    @FXML
    private Label lblIdUsuario, lblIdPedido, lblTotal, lblFechaEstimadaEntrega;
    @FXML
    private DatePicker dtpFecha;
    @FXML
    private ComboBox<String> cbxDireccionOrigen,cbxDireccionDestino ;//PROVISIONAL
    @FXML
    private ComboBox<String> cbxIdPaquete;//STRING PROVISIONAL
    @FXML
    private TableView<String> tbvPedidos;//STRING PROVISIONAL
    //FALTAN COLUMNAS
    @FXML
    public void onRealizarPedido(){}
    @FXML
    public void onActualizar(){}
    @FXML
    public void onDescargarReporte(){}
    @FXML
    public void onEliminar(){}
    @FXML
    public void onRegresar(){
        controller.irAlUsuario();
    }
    public void setApp(App app) {
        this.app = app;
    }
    public void setController(SolicitarPedidoController controller) {
        this.controller = controller;
    }
}
