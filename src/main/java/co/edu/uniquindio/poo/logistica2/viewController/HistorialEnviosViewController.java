package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.HistorialEnviosController;
import co.edu.uniquindio.poo.logistica2.model.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.List;

public class HistorialEnviosViewController {
    private App app;
    private Usuario usuario;
    private HistorialEnviosController controller;
    ObservableList<Pedido> list =  FXCollections.observableArrayList();
    Pedido selectedPedido;
    @FXML
    public TableView<Pedido> tbvHistorial;
    @FXML
    public TableColumn<Pedido, String> tbcId, tbcDireccion, tbcEstado;
    @FXML
    public TableColumn<Pedido, LocalDate> tbcFechaEstimada;
    @FXML
    public ComboBox<String> cbxEstado;
    @FXML
    public DatePicker dtpFecha;
    public void setController(HistorialEnviosController controller) {
        this.controller = controller;
        verPedidos();
        cargarEstados();
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    @FXML
    public void onRegresar(){
        controller.irAlInicio();
    }
    public void initialize(){
        tbcId.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));
        tbcDireccion.setCellValueFactory(cellData ->
                new SimpleStringProperty(
                        cellData.getValue().getDestino().getCiudad().getNombre()
                                + " - " +
                                cellData.getValue().getDestino().getCalle()
                )
        );
        tbcEstado.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getEstado()));
        tbcFechaEstimada.setCellValueFactory(
                cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getFechaEstimadaEntrega()));
        tbvHistorial.setItems(list);
        cargarEvento();
    }
    public void cargarEvento(){
        dtpFecha.valueProperty().addListener((obs, old, newVal) -> mostrarPedidos());
        cbxEstado.getSelectionModel().selectedItemProperty().addListener((obs, old, newVal) -> {mostrarPedidos();});
    }
    private void mostrarPedidos(){
        LocalDate fecha = dtpFecha.getValue();
        String estado = cbxEstado.getSelectionModel().getSelectedItem();
        if(fecha != null){
            list.setAll(controller.verHistorial(estado, fecha));
        }
    }
    private void cargarEstados(){
        cbxEstado.getItems().addAll( "Solicitado", "Asignado", "EnRuta", "Entregado", "Incidencia"
        );

    }
    private void verPedidos(){
        List<Pedido> pedidos = controller.verPedidos();
        if(pedidos != null){
            list.setAll(pedidos);
            tbvHistorial.setItems(list);
        } else {
            tbvHistorial.getItems().clear();
        }

    }
    public void setApp(App app) {
        this.app = app;
    }

}
