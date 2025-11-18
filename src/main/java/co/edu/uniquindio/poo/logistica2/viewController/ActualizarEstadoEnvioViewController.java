package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.ActualizarEstadoEnvioController;
import co.edu.uniquindio.poo.logistica2.model.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.StringConverter;

import java.util.List;

public class ActualizarEstadoEnvioViewController {
    private App app;
    private ActualizarEstadoEnvioController controller;
    private Administrador administrador;
    ObservableList<Envio> list = FXCollections.observableArrayList();
    Envio selectedEnvio;

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    @FXML
    public TableView<Envio> tbvEnvio;
    @FXML
    public TableColumn<Envio, String> tbcId, tbcRepartidor, tbcDirOrigen, tbcDirDestino;
    @FXML
    public TableColumn<Envio, String> tbcEstado;
    @FXML
    public ComboBox<IEstado> cbxEstado;
    @FXML
    public void onRegresar(){
        controller.volver();
    }
    @FXML
    public void onActualizar(){}
    @FXML
    public void onEliminar(){}
    public void initialize(){
        cbxEstado.getItems().addAll(
                new Asignado(),
                new EnRuta(),
                new Entregado(),
                new Incidencia()
        );
        cbxEstado.setConverter(new StringConverter<IEstado>() {
            @Override
            public String toString(IEstado estado) {
                return estado != null ? estado.getNombre() : "";
            }
            @Override
            public IEstado fromString(String s) { return null; }
        });
        // cuando cambie el estado en el combo
        cbxEstado.valueProperty().addListener((obs, oldValue, nuevoEstado) -> {
            cambiarEstado();
        });
        tbcEstado.setCellValueFactory(cellData ->
                new SimpleStringProperty(
                        cellData.getValue().getEstadoEnvio().getNombre()
                )
        );
        tbcId.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));
        tbcDirOrigen.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getRuta().getCiudadOrigen().getNombre()));
        tbcDirDestino.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getRuta().getCiudadDestino().getNombre()));
        tbcRepartidor.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getRepartidor().getNombre()));
        tbvEnvio.setItems(list);
        listenerSelection();
    }
    private void cambiarEstado() {
        Envio envioSeleccionado = tbvEnvio.getSelectionModel().getSelectedItem();
        IEstado estadoSeleccionado = cbxEstado.getValue();

        if (envioSeleccionado != null && estadoSeleccionado != null) {
            controller.cambiarEstadoEnvio(envioSeleccionado, estadoSeleccionado);
            tbvEnvio.refresh(); // refresca el estado mostrado en la tabla
        }
    }

    private void listenerSelection(){
        tbvEnvio.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> {
            selectedEnvio = newSelection;
            mostrarInformacion(selectedEnvio);
        });
    }
    public void obtenerEnvios(){
        List<Envio> envios = controller.obtenerEnvios();
        if(envios != null){
            list.setAll(envios);
            tbvEnvio.setItems(list);
        } else {
            tbvEnvio.getItems().clear();
        }
    }
    private void mostrarInformacion(Envio envio){
        if(envio != null){
            cbxEstado.setValue(envio.getEstadoEnvio());
        }
    }
    public void setApp(App app) {
        this.app = app;
    }
    public void setController(ActualizarEstadoEnvioController controller) {
        this.controller = controller;
        obtenerEnvios();
    }

}
