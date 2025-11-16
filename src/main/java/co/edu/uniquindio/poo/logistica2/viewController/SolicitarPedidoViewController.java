package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.SolicitarPedidoController;
import co.edu.uniquindio.poo.logistica2.model.Direccion;
import co.edu.uniquindio.poo.logistica2.model.Paquete;
import co.edu.uniquindio.poo.logistica2.model.Pedido;
import co.edu.uniquindio.poo.logistica2.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.util.List;

public class SolicitarPedidoViewController {
    private App app;
    private SolicitarPedidoController controller;
    private Usuario usuario;
    ObservableList<Pedido> list = FXCollections.observableArrayList();
    Pedido selectedPedido;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        lblIdUsuario.setText(usuario.getId());
    }
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
        cargarDirecciones();
        cargarPaquetes();
        cargarPedidos();
    }
    private Pedido buildPedido() {
        String id = lblIdPedido.getText();
        LocalDate fecha = dtpFecha.getValue();
        Direccion origen = cbxDireccionOrigen.getSelectionModel().getSelectedItem();
        Direccion destino = cbxDireccionDestino.getSelectionModel().getSelectedItem();
        Paquete paquete = cbxIdPaquete.getSelectionModel().getSelectedItem();
        return new Pedido(id,fecha,origen,destino, usuario);
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
        cbxIdPaquete.getItems().addAll(controller.obtenerPaquetes());
        cbxIdPaquete.setConverter(new StringConverter<Paquete>() {
            @Override
            public String toString(Paquete paquete) {
                return paquete != null ? paquete.getId() : "";
            }
            @Override
            public Paquete fromString(String s) {
                return null;
            }
        });
    }
    public void cargarPedidos(){
        List<Pedido> pedidos = controller.obtenerPedidos();
        if(pedidos != null){
            list.setAll(pedidos);
            tbvPedidos.setItems(list);
        } else {
            tbvPedidos.getItems().clear();
        }
    }
}
