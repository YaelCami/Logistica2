package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.GestionRepartidorController;
import co.edu.uniquindio.poo.logistica2.model.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.List;

public class GestionRepartidorViewController {
    private App app;
    private GestionRepartidorController controller;
    ObservableList<Repartidor> list = FXCollections.observableArrayList();
    ObservableList<Ruta> listaRutas= FXCollections.observableArrayList();
    Repartidor selectedRepartidor;

    public void setApp(App app) {
        this.app = app;
    }
    @FXML
    public TextField txtId,txtNombre, txtTelefono, txtCorreo;
    @FXML
    public Label lblDocumento;
    @FXML
    public ComboBox<Disponibilidad> cbxDisponibilidad;
    @FXML
    public ComboBox<Ruta> cbxZona;
    @FXML
    public TableView<Ruta> tbvRuta;
    @FXML
    public TableColumn<Ruta, String> tbcIdRuta;
    @FXML
    public TableColumn<Ruta, String> tbcOrigen, tbcDestino;
    @FXML
    public TableView<Repartidor> tbvRepartidor;
    @FXML
    public TableColumn<Repartidor, String> tbcId, tbcNombre, tbcTelefono;
    @FXML
    public TableColumn<Repartidor, Disponibilidad> tbcEstado;
    @FXML
    public void onRegresar(){
        controller.volver();
    }

    @FXML
    public void onRegistrar(){
        try {
            RepartidorDTO dto = buildRepartidorDTO();
            if (dto == null) {
                mostrarAlerta("Error", "Completa todos los campos");
                return;
            }
            Repartidor repartidor = controller.agregarRepartidor(dto);
            if (repartidor != null) {
                list.add(repartidor);
                listaRutas.clear();
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo agregar al usuario correctamente");
            }
        } catch (Exception e) {
            mostrarAlerta("Error", "Datos invalidos:" + e.getMessage());
        }
    }
    @FXML
    public void onActualizar(){
        if(selectedRepartidor != null){
            try{
                Repartidor nuevo = buildRepartidor();
                boolean actualizado = controller.actualizarRepartidor(selectedRepartidor.getId(), nuevo);
                if(actualizado){
                    int index = list.indexOf(selectedRepartidor);
                    list.set(index, nuevo);
                    limpiarCampos();
                    mostrarAlerta("Exito", "Usuario actualizado correctamente");
                } else{
                    mostrarAlerta("Error", "No se pudo actualizar correctamente.");
                }
            } catch (Exception e){
                mostrarAlerta("Error", "Datos invalidos:"+ e.getMessage());
            }
        }else {
            mostrarAlerta("Error", "Por favor completa todos los campos.");
        }
    }
    @FXML
    public void onEliminar(){
        if(selectedRepartidor != null){
            boolean eliminado = controller.eliminarRepartidor(selectedRepartidor.getId());
            if(eliminado){
                list.remove(selectedRepartidor);
                limpiarCampos();
                mostrarAlerta("Exito", "Usuario eliminado correctamente");
            } else {
                mostrarAlerta("Error", "No se pudo eliminar correctamente.");
            }
        } else{
            mostrarAlerta("Atencion", "Selecciona un usuario para eliminar");
        }
    }
    @FXML
    public void onGuardar(){
        Ruta rutaSeleccionada = cbxZona.getValue();
        if (rutaSeleccionada != null) {
            listaRutas.add(rutaSeleccionada);
            cbxZona.setValue(null);
            tbvRuta.setItems(listaRutas);
        } else {
            mostrarAlerta("Error","Selecciona una ruta primero.");
        }
    }
    public void setController(GestionRepartidorController controller) {
        this.controller = controller;
        cargarRutas();
        obtenerRepartidores();
    }

    private void mostrarInformacion(Repartidor repartidor) {
        if(repartidor != null){
            txtNombre.setText(repartidor.getNombre());
            txtTelefono.setText(repartidor.getTelefono());
            txtId.setText(repartidor.getId());
            lblDocumento.setText(repartidor.getDocumento());
            txtCorreo.setText(repartidor.getCorreo());
            cbxDisponibilidad.setValue(repartidor.getDisponibilidad());
            tbvRuta.setItems(FXCollections.observableArrayList(repartidor.getZonaCobertura()));
        }
    }
    private void cargarRutas() {
        cbxZona.getItems().clear();
        cbxZona.getItems().addAll(controller.obtenerListaRutas());
        cbxZona.setConverter(new StringConverter<Ruta>() {
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
    public void obtenerRepartidores() {
        List<Repartidor> repartidores = controller.obtenerListaRepartidores();
        if(repartidores != null) {
            list.setAll(repartidores);
            tbvRepartidor.setItems(list);
        } else {
            tbvRepartidor.getItems().clear();
        }
    }
    public RepartidorDTO buildRepartidorDTO(){
        List<Ruta> zonaCobertura = new ArrayList<>(listaRutas);
        List<Envio> envios = new ArrayList<>();
        Disponibilidad disponibilidad = cbxDisponibilidad.getSelectionModel().getSelectedItem();
        return new RepartidorDTO(txtId.getText(),txtNombre.getText(),txtCorreo.getText(), txtTelefono.getText(),generarDocumento(), disponibilidad, zonaCobertura, envios );
    }
    private Repartidor buildRepartidor(){
        String correo = txtCorreo.getText();
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String documento = lblDocumento.getText();
        String id = txtId.getText();
        Disponibilidad disponibilidad = cbxDisponibilidad.getValue();
        List<Ruta> zonaCobertura = new ArrayList<>(listaRutas);
        return (Repartidor) new Repartidor.Builder().zonaCobertura(zonaCobertura).nombre(nombre).id(id).documento(documento).correo(correo).telefono(telefono).disponibilidad(disponibilidad).build();
    }

    public void initialize(){
        tbcId.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));
        tbcNombre.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcTelefono.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTelefono()));
        tbcEstado.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getDisponibilidad()));
        tbcIdRuta.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));
        tbcOrigen.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCiudadOrigen().getNombre()));
        tbcDestino.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCiudadDestino().getNombre()));
        cbxDisponibilidad.getItems().addAll(Disponibilidad.values());
        tbvRepartidor.setItems(list);
        tbvRuta.setItems(listaRutas);
        listenerSelection();
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
        txtNombre.clear();
        txtCorreo.clear();
        txtTelefono.clear();
        cbxZona.setValue(null);
        cbxDisponibilidad.setValue(null);
        lblDocumento.setText("");
    }
    private void listenerSelection() {
        tbvRepartidor.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> {
            selectedRepartidor = newSelection;
            mostrarInformacion(selectedRepartidor);
        });
    }
    private static int secuencia = 0;

    private String generarDocumento() {
        secuencia++;
        return String.format("%04d", secuencia);
    }
}
