package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.HistorialEnviosController;
import co.edu.uniquindio.poo.logistica2.model.Pedido;
import co.edu.uniquindio.poo.logistica2.model.Usuario;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    public TableColumn<Pedido, String> tbcId, tbcDireccion;
    @FXML
    public TableColumn<Pedido, LocalDate> tbcFechaEstimada;
    @FXML
    public ComboBox<String> cbxEstado;
    @FXML
    public DatePicker dtpFecha;
    public void setController(HistorialEnviosController controller) {
        this.controller = controller;
        verPedidos();
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    @FXML
    public void onDescargar(){}
    @FXML
    public void onRegresar(){
        controller.irAlInicio();
    }
    public void initialize(){
        tbcId.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));
        tbcFechaEstimada.setCellValueFactory(
                cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getFechaEstimadaEntrega()));
        tbvHistorial.setItems(list);
        cargarEvento();
    }
    public void cargarEvento(){
        dtpFecha.valueProperty().addListener((obs, old, newVal) -> mostrarPedidos());
    }
    private void mostrarPedidos(){
        LocalDate fecha = dtpFecha.getValue();
        if(fecha != null){
            list.setAll(controller.verHistorial(fecha));
        }
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
