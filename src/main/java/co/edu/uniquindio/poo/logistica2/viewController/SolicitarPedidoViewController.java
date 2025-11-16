package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.SolicitarPedidoController;
import co.edu.uniquindio.poo.logistica2.model.Direccion;
import co.edu.uniquindio.poo.logistica2.model.Paquete;
import co.edu.uniquindio.poo.logistica2.model.Pedido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

public class SolicitarPedidoViewController {
    private App app;
    private SolicitarPedidoController controller;
    ObservableList<Pedido> list = FXCollections.observableArrayList();
    Pedido selectedPedido;

    @FXML
    public Label lblIdUsuario, lblIdPedido, lblTotal, lblFechaEstimadaEntrega;
    @FXML
    public DatePicker dtpFecha;
    @FXML
    public ComboBox<Direccion> cbxDireccionOrigen,cbxDireccionDestino ;
    @FXML
    public ComboBox<Paquete> cbxIdPaquete;
    @FXML
    public TableView<Pedido> tbvPedidos;
    @FXML
    public TableColumn<Pedido, String> tbcIdPedido, tbcEstadoPedido;
    @FXML
    public void onRealizarPedido(){}
    @FXML
    public void onActualizar(){}
    @FXML
    public void onDescargarReporte(){}
    @FXML
    public void onEliminar(){}
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
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
    private void listenerSelection(){
        tbvPedidos.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> {
            selectedPedido = newSelection;
            mostrarInformacion(selectedPedido);
        });
    }
    private void mostrarInformacion(Pedido pedido) {
        if (pedido != null) {
            lblIdUsuario.setText(pedido.getUsuario().getId());
            lblIdPedido.setText(pedido.getId());
            dtpFecha.setValue(pedido.getFechaCreacion());//????
            cbxDireccionOrigen.setValue(pedido.getOrigen());
            cbxDireccionDestino.setValue(pedido.getDestino());
            cbxIdPaquete.setValue(pedido.getPaquete());
            lblFechaEstimadaEntrega.setText(pedido.getFechaEstimadaEntrega().toString());
        }
    }
    private void cargarDirecciones(){
        cbxDireccionOrigen.getItems().clear();
        cbxDireccionOrigen.getItems().addAll(controller.obtenerDirecciones());
        cbxDireccionOrigen.setConverter(new StringConverter<Direccion>() {
            @Override
            public String toString(Direccion direccion) {
                return direccion != null ? direccion.getCalle() : "";
            }

            @Override
            public Direccion fromString(String s) {
                return null;
            }
        });
        cbxDireccionDestino.getItems().clear();
        cbxDireccionDestino.getItems().addAll(controller.obtenerDirecciones());
        cbxDireccionDestino.setConverter(new StringConverter<Direccion>() {
            @Override
            public String toString(Direccion direccion) {
                return direccion != null ? direccion.getCalle() : "";
            }

            @Override
            public Direccion fromString(String s) {
                return null;
            }
        });
    }
    public void cargarPaquetes(){
        cbxIdPaquete.getItems().clear();
        cbxIdPaquete.getItems().addAll(controller.obte)
    }
}
