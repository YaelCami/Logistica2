package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.AsignarPedidoController;
import co.edu.uniquindio.poo.logistica2.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

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
    public TableColumn<Pedido, String> tbcRuta;
    @FXML
    public TableColumn<Pedido, String> tbcPedido;
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
        Pedido seleccionado = cbxPedido.getSelectionModel().getSelectedItem();
        if(seleccionado != null){
            pedidosAsignados.add(seleccionado);
            cbxPedido.setValue(null);
            tbvEnvio.setItems(pedidosAsignados);
        } else {
            mostrarAlerta("Error", "Seleccione un pedido");
        }
    }
    @FXML
    public void onCrearEnvio(){}
    public void setApp(App app) {
        this.app = app;
    }
    public void setController(AsignarPedidoController controller) {
        this.controller = controller;
        cargarPedidos();
        cargarRutas();
        cargarRepartidores();
    }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    public void initialize() {
        tbcPedido.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));
        tbcRuta.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getRuta().toString()));

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
    public void cargarPedidos(){
        cbxPedido.getItems().clear();
        cbxPedido.getItems().addAll(controller.obtenerPedidos());
        cbxPedido.setConverter(new StringConverter<Pedido>(){
            @Override
            public String toString(Pedido p) {
                return p != null ? p.getId() + " - " + p.getCosto(): "";
            }
            @Override
            public Pedido fromString(String s) {
                return null;
            }
        });
    }
    private void cargarRutas(){
        cbxRuta.getItems().clear();
        cbxRuta.getItems().addAll(controller.obtenerRutas());
        cbxRuta.setConverter(new StringConverter<Ruta>() {
            @Override
            public String toString(Ruta ruta) {
                return ruta != null ? ruta.getCiudadOrigen().getNombre() + " - " + ruta.getCiudadDestino().getNombre() : "";
            }

            @Override
            public Ruta fromString(String string) {
                return null;
            }
        });
    }
    private void cargarRepartidores(){
        cbxRepartidor.getItems().clear();
        cbxRepartidor.getItems().addAll(controller.obtenerRepartidores());
        cbxRepartidor.setConverter(new StringConverter<Repartidor>() {
            @Override
            public String toString(Repartidor repartidor) {
                return repartidor != null ? repartidor.getNombre() + " - " + repartidor.getId() : "";
            }

            @Override
            public Repartidor fromString(String string) {
                return null;
            }
        });
    }

}
