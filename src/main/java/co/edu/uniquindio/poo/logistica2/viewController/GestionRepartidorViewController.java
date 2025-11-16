package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.GestionRepartidorController;
import co.edu.uniquindio.poo.logistica2.model.Ciudad;
import co.edu.uniquindio.poo.logistica2.model.Repartidor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class GestionRepartidorViewController {
    private App app;
    private GestionRepartidorController controller;
    ObservableList<Repartidor> list = FXCollections.observableArrayList();
    ObservableList<Ciudad> listaCiudades = FXCollections.observableArrayList();
    Repartidor selectedRepartidor;

    @FXML
    public TextField txtId,txtNombre, txtTelefono;
    @FXML
    public ComboBox<Estado> cbxEstado;
    @FXML
    public ComboBox<Ciudad> cbxCiudades;
    @FXML
    public TableView<Ciudad> tbvCiudad;
    @FXML
    public TableColumn<Ciudad, String> tbcCiudades;
    @FXML
    public void onRegresar(){
        controller.volver();
    }
    @FXML
    public void onRegistrar(){}
    @FXML
    public void onActualizar(){}
    @FXML
    public void onEliminar(){}
    @FXML
    public void onGuardar(){}
    public void setApp(App app) {
        this.app = app;
    }
    public void setController(GestionRepartidorController controller) {
        this.controller = controller;
    }
    private void mostrarInformacion(Repartidor repartidor) {
        if(repartidor != null){
            txtNombre.setText(repartidor.getNombre());
            txtTelefono.setText(repartidor.getTelefono());
            txtId.setText(repartidor.getId());
        }
    }
    private void cargarCiudades() {
        cbxCiudades.getItems().clear();
        cbxCiudades.getItems().addAll(controller.obtenerListaCiudades());
        cbxCiudades.setConverter(new StringConverter<Ciudad>() {
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
