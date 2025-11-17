package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.AsignarPedidoController;
import co.edu.uniquindio.poo.logistica2.model.Envio;
import co.edu.uniquindio.poo.logistica2.model.Pedido;
import co.edu.uniquindio.poo.logistica2.model.Repartidor;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AsignarEnvioViewController {
    private App app;
    private AsignarPedidoController controller;

    @FXML
    public TableView<Envio> tbvEnvio;
    @FXML
    public TableColumn<Envio, String> tbcPedido, tbcRepartidor, tbcOrigen, tbcDestino;
    @FXML
    public TextField txtId;
    @FXML
    public DatePicker dtpFecha;
    @FXML
    public ComboBox<Pedido> cbxPedido;
    @FXML
    public ComboBox<Repartidor> cbxRepartidor;
    @FXML
    public void onRegresa(){
        controller.volver();
    }
    @FXML
    public void onAsignar(){

    }
    @FXML
    public void onCrearEnvio(){}
    public void setApp(App app) {
        this.app = app;
    }
    public void setController(AsignarPedidoController controller) {
        this.controller = controller;
    }
}
