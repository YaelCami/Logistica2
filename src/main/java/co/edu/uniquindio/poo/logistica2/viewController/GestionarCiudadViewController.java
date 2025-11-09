package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.GestionarCiudadController;
import co.edu.uniquindio.poo.logistica2.model.Ciudad;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GestionarCiudadViewController {
    private App app;
    private GestionarCiudadController controller;
    ObservableList<Ciudad> list = FXCollections.observableArrayList();
    Ciudad selectedCiudad;
    @FXML
    private URL location;
    @FXML
    private ResourceBundle resources;
    public void setApp(App app) {
        this.app = app;
    }
    @FXML
    public TextField txtId, txtNombre, txtHabitantes;
    @FXML
    public TableView<Ciudad> tbvCiudad;
    @FXML
    public TableColumn<Ciudad, String> tbcId, tbcNombre;
    @FXML
    public TableColumn<Ciudad, Integer> tbcHabitantes;
    @FXML
    public void onRegresar(){
        controller.volver();
    }
    @FXML
    public void onActualizar(){
        if(selectedCiudad != null){
            try{
                Ciudad nueva = buildCiudad();
                boolean actualizada = controller.actualizar(selectedCiudad.getId(), nueva);
                if(actualizada){
                    int index = list.indexOf(selectedCiudad);
                    list.set(index, nueva);
                    limpiarCampos();
                    mostrarAlerta("Exito", "Ciudad actualizada correctamente");
                } else{
                    mostrarAlerta("Error", "No se pudo actualizar correctamente.");
                }
            } catch (Exception e){
                mostrarAlerta("Error", "Datos inválidos:"+ e.getMessage());
            }
        } else{
            mostrarAlerta("Error", "Seleccione un ciudad.");
        }
    }
    @FXML
    public void onEliminar(){
        if(selectedCiudad != null){
            boolean eliminada = controller.eliminar(selectedCiudad.getId());
            if(eliminada){
                list.remove(selectedCiudad);
                limpiarCampos();
                mostrarAlerta("Éxito", "Ciudad eliminada correctamente");
            } else{
                mostrarAlerta("Error", "No se pudo eliminar correctamente.");
            }
        } else {
            mostrarAlerta("Atención", "Seleccione un ciudad.");
        }
    }
    @FXML
    public void onRegistrar(){
        registrar();
    }
    public void registrar(){
        try{
            Ciudad ciudad = buildCiudad();
            if(ciudad == null){
                mostrarAlerta("Error", "Completa todos los campos");
                return;
            }
            if (controller.agregarCiudad(ciudad)){
                list.add(ciudad);
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo agregar correctamente");
            }
        } catch (Exception e){
            mostrarAlerta("Error", "Datos inválidos:"+ e.getMessage());
        }
    }

    private Ciudad buildCiudad(){
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        Integer habitantes = Integer.parseInt(txtHabitantes.getText());
        return new Ciudad(id, nombre, habitantes);
    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    public void initialize(){
        tbcNombre.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcId.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));
        tbcHabitantes.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getHabitantes()));
        tbvCiudad.setItems(list);
        listenerSelection();
    }
    private void limpiarCampos(){
        txtId.clear();
        txtNombre.clear();
        txtHabitantes.clear();
    }
    private void listenerSelection(){
        tbvCiudad.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> {
            selectedCiudad = newSelection;
            mostrarInformacion(selectedCiudad);
        });
    }

    public void setController(GestionarCiudadController controller) {
        this.controller = controller;
        obtenerCiudades();
    }
    public void obtenerCiudades(){
        List<Ciudad> ciudades = controller.obtenerListaCiudades();
        if(ciudades != null){
            list.setAll(ciudades);
            tbvCiudad.setItems(list);
        } else {
            tbvCiudad.getItems().clear();
        }
    }
    private void mostrarInformacion(Ciudad ciudad){
        if(ciudad != null){
            txtId.setText(ciudad.getId());
            txtNombre.setText(ciudad.getNombre());
            txtHabitantes.setText(String.valueOf(ciudad.getHabitantes()));
        }
    }

}
