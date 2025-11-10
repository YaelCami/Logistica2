package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.AgregarDireccionController;
import co.edu.uniquindio.poo.logistica2.model.Ciudad;
import co.edu.uniquindio.poo.logistica2.model.Direccion;
import co.edu.uniquindio.poo.logistica2.model.Usuario;
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

public class AgregarDireccionViewController {
    private AgregarDireccionController controller;
    private App app;
    private Usuario usuario;
    ObservableList<Direccion> listDirecciones = FXCollections.observableArrayList();
    Direccion selectedDireccion;
    @FXML
    private URL location;
    @FXML
    private ResourceBundle resources;
    @FXML
    public TextField txtId, txtAlias, txtCalle, txtCoordenadas;
    @FXML
    public ComboBox<Ciudad> cbxCiudad;
    @FXML
    public TableView<Direccion> tbvDireccion;
    @FXML
    public TableColumn<Direccion, String> tbcId, tbcCalle, tbcCiudad, tbcCoordenadas;
    @FXML
    public void onAgregar(){
        agregarDireccion();
    }
    @FXML
    public void onActualizar(){
        if(selectedDireccion != null){
            try{
                Direccion nueva = buildDireccion();
                boolean actualizada = controller.actualizarDireccion(selectedDireccion.getId(), nueva);
                if(actualizada){
                    int index = listDirecciones.indexOf(selectedDireccion);
                    listDirecciones.set(index, nueva);
                    limpiarCampos();
                    mostrarAlerta("Exito", "Direccion actualizada correctamente");
                } else{
                    mostrarAlerta("Error", "No se pudo actualizar correctamente.");
                }
            } catch (Exception e){
                mostrarAlerta("Atencion", "Selecciona una direccion para actualizar.");
            }
        } else{
            mostrarAlerta("Error", "Por favor completa todos los campos.");
        }
    }
    @FXML
    public void onEliminar(){
        if (selectedDireccion != null){
            boolean eliminada = controller.eliminarDireccion(selectedDireccion.getId());
            if(eliminada){
                listDirecciones.remove(selectedDireccion);
                limpiarCampos();
                mostrarAlerta("Exito", "Direccion eliminada correctamente");
            } else{
                mostrarAlerta("Error", "No se pudo eliminar correctamente.");
            }
        } else{
            mostrarAlerta("Atencion", "Seleccione una direccion para eliminar");
        }
    }

    @FXML
    private void agregarDireccion(){
        try {
            Direccion direccion = buildDireccion();
            if (direccion == null) {
                mostrarAlerta("Error", "Completa todos los campos");
            }
            else if (controller.agregarDireccion(direccion)) {
                listDirecciones.add(direccion);
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo agregar la direccion correctamente");
            }
        } catch (Exception e) {
            mostrarAlerta("Error", "Datos invalidos:" + e.getMessage());
        }
    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    public void initialize(){
        tbcId.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));
        tbcCalle.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCalle()));
        tbcCoordenadas.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCoordenadas()));
        tbcCiudad.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getCiudad().getNombre()));
        tbvDireccion.setItems(listDirecciones);
        listenerSelection();
    }
    private void cargarCiudad(){
        cbxCiudad.getItems().clear();
        cbxCiudad.getItems().addAll(controller.obtenerCiudades());
        cbxCiudad.setConverter(new StringConverter<Ciudad>() {
            public String toString(Ciudad ciudad) {
                return ciudad != null ? ciudad.getNombre() : "";
            }

            @Override
            public Ciudad fromString(String string) {
                return null;
            }
        });
    }
    private Direccion buildDireccion(){
        String id = txtId.getText();
        String alias = txtAlias.getText();
        String calle = txtCalle.getText();
        String coord = txtCoordenadas.getText();
        Ciudad ciudad = cbxCiudad.getValue();
        Direccion direccion = new Direccion(id, alias, calle, ciudad, coord);
        if (direccion == null){
            return null;
        }
        return direccion;
    }
    @FXML
    public void onRegresar(){
        controller.irAlInicio();
    }

    public void setApp(App app) {
        this.app = app;
    }

    public void setController(AgregarDireccionController controller) {
        this.controller = controller;
        cargarCiudad();
        obtenerDirecciones();
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void obtenerDirecciones(){
        List<Direccion> direcciones = controller.obtenerDirecciones();
        if(direcciones != null){
            listDirecciones.setAll(direcciones);
            tbvDireccion.setItems(listDirecciones);
        } else {
            tbvDireccion.getItems().clear();
        }
    }
    private void listenerSelection(){
        tbvDireccion.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> {
            selectedDireccion = newSelection;
            mostrarInformacion(selectedDireccion);
        });
    }
    private void mostrarInformacion(Direccion direccion){
        if(direccion != null){
            txtId.setText(direccion.getId());
            txtAlias.setText(direccion.getAlias());
            txtCalle.setText(direccion.getCalle());
            txtCoordenadas.setText(direccion.getCoordenadas());
            cbxCiudad.setValue(direccion.getCiudad());
        }
    }
    private void limpiarCampos(){
        txtId.clear();
        txtAlias.clear();
        txtCalle.clear();
        txtCoordenadas.clear();
        cbxCiudad.setValue(null);
    }
}
