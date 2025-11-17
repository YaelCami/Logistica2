package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.AsignarPedidoController;
import co.edu.uniquindio.poo.logistica2.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.List;

public class AsignarEnvioViewController {
    private App app;
    private AsignarPedidoController controller;
    private Administrador administrador;
    ObservableList<Pedido> pedidosAsignados = FXCollections.observableArrayList();

    @FXML
    public TableView<Pedido> tbvEnvio;
    @FXML
    public TableColumn<Pedido, String> tbcPedido, tbcRepartidor, tbcOrigen, tbcDestino;
    @FXML
    public TextField txtId;
    @FXML
    public DatePicker dtpFecha;
    @FXML
    public ComboBox<Pedido> cbxPedido;
    @FXML
    public ComboBox<Ruta> cbxRuta;
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
        obtenerPedidos();
    }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    public void initialize() {
        tbcPedido.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));
        tbcDestino.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDestino().getCiudad().getNombre()));
        tbcOrigen.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getOrigen().getCiudad().getNombre()));
        tbvEnvio.setItems(pedidosAsignados);

    }
    private Envio buildEnvio(){
        String id = txtId.getText();
        LocalDate fecha = dtpFecha.getValue();
        Repartidor repartidor = cbxRepartidor.getValue();
        Ruta ruta = cbxRuta.getValue();
        Pedido pedido = cbxPedido.getValue();
        return new Envio(id, fecha, pedido.getFechaEstimadaEntrega(), ruta, repartidor);//MODIFICAR FECHA ESTIMADA DE ENTREGA

    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    private void limpiarCampos() {
        txtId.clear();
        dtpFecha.setValue(null);
        cbxPedido.setValue(null);
        cbxRepartidor.setValue(null);
    }
    public void obtenerPedidos(){
        List<Pedido> pedidos = controller.obtenerPedidos();
    }
}
