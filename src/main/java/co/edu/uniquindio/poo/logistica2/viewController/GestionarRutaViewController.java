package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.GestionarRutaController;
import co.edu.uniquindio.poo.logistica2.model.Ciudad;
import co.edu.uniquindio.poo.logistica2.model.Ruta;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GestionarRutaViewController {
    private App app;
    private GestionarRutaController controller;
    ObservableList<Ruta> list = FXCollections.observableArrayList();
    Ruta selectedRuta;

    @FXML
    private URL location;
    @FXML
    private ResourceBundle resources;
    public void setApp(App app) {
        this.app = app;
    }
    @FXML
    public TextField txtId, txtDistancia;
    @FXML
    public ComboBox<Ciudad> cbxOrigen, cbxDestino;
    @FXML
    public TableView<Ruta> tbvRuta;
    @FXML
    public TableColumn<Ruta, String> tbcId;
    @FXML
    public TableColumn<Ruta, Double> tbcDistancia;
    @FXML
    public TableColumn<Ruta, String> tbcOrigen, tbcDestino;
    @FXML
    public void onRegresar(){
        controller.volver();
    }
    @FXML
    public void onRegistrar(){
        registro();
    }
    @FXML
    public void onActualizar(){
        if(selectedRuta != null){
            try{
                Ruta nueva = buildRuta();
                boolean actualizada = controller.actualizarRuta(selectedRuta.getId(), nueva);
                if(actualizada){
                    int index = list.indexOf(selectedRuta);
                    limpiarCampos();
                    mostrarAlerta("Exito", "Ruta actualizada correctamente");
                } else {
                    mostrarAlerta("Error", "No se pudo actualizar correctamente.");
                }
            } catch (Exception e){
                mostrarAlerta("Error", "Datos inválidos:" + e.getMessage());
            }
        } else {
            mostrarAlerta("Error", "Seleccione una ruta que desea actualizar.");
        }
    }
    @FXML
    public void onEliminar(){
        if(selectedRuta != null){
            boolean eliminada = controller.eliminarRuta(selectedRuta.getId());
            if(eliminada){
                list.remove(selectedRuta);
                limpiarCampos();
                mostrarAlerta("Exito", "Ruta eliminada correctamente");
            } else {
                mostrarAlerta("Error", "No se pudo eliminar correctamente.");
            }
        } else {
            mostrarAlerta("Atención", "Seleccione una ruta que desea eliminar.");
        }
    }

    public void registro(){
        try{
            Ruta ruta = buildRuta();
            if(ruta == null){
                mostrarAlerta("Error", "Complete los campos");
                return;
            }
            if(controller.agregarRuta(ruta)){
                list.add(ruta);
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo agregar correctamente");
            }
        } catch (Exception e){
            mostrarAlerta("Error", "Datos inválidos:" +e.getMessage());
        }
    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    private Ruta buildRuta(){
        String id = txtId.getText();
        Double distancia = Double.parseDouble(txtDistancia.getText());
        Ciudad origen = cbxOrigen.getSelectionModel().getSelectedItem();
        Ciudad destino = cbxDestino.getSelectionModel().getSelectedItem();
        return new Ruta(id,origen,destino,distancia);
    }
    public void initialize(){
        tbcId.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));
        tbcDistancia.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getDistancia()));
        tbcOrigen.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCiudadOrigen().getNombre()));
        tbcDestino.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCiudadDestino().getNombre()));
        tbvRuta.setItems(list);
        listenerSelection();
    }
    private void limpiarCampos(){
        txtId.clear();
        txtDistancia.clear();
        cbxOrigen.getSelectionModel().clearSelection();
        cbxDestino.getSelectionModel().clearSelection();
    }
    private void listenerSelection(){
        tbvRuta.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> {
            selectedRuta = newSelection;
            mostrarInformacion(selectedRuta);
        });
    }
    public void setController(GestionarRutaController controller) {
        this.controller = controller;
        obtenerRutas();
        cargarCiudades();
    }
    public void obtenerRutas(){
        List<Ruta> rutas = controller.obtenerListaRutas();
        if(rutas != null){
            list.setAll(rutas);
            tbvRuta.setItems(list);
        } else {
            tbvRuta.getItems().clear();
        }
    }

    private void mostrarInformacion(Ruta ruta){
        if(ruta != null){
            txtId.setText(ruta.getId());
            txtDistancia.setText(Double.toString(ruta.getDistancia()));
            cbxOrigen.setValue(ruta.getCiudadOrigen());
            cbxDestino.setValue(ruta.getCiudadDestino());
        }
    }
    private void cargarCiudades() {
        cbxOrigen.getItems().clear();
        cbxOrigen.getItems().addAll(controller.obtenerListaCiudades());
        cbxOrigen.setConverter(new StringConverter<Ciudad>() {
            @Override
            public String toString(Ciudad ciudad) {
                return ciudad != null ? ciudad.getNombre() : "";
            }

            @Override
            public Ciudad fromString(String string) {
                return null;
            }
        });
        cbxDestino.getItems().clear();
        cbxDestino.getItems().addAll(controller.obtenerListaCiudades());
        cbxDestino.setConverter(new StringConverter<Ciudad>() {
            @Override
            public String toString(Ciudad ciudad) {
                return ciudad != null ? ciudad.getNombre() : "";
            }

            @Override
            public Ciudad fromString(String string) {
                return null;
            }
        });
    }
}
