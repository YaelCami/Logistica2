package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.RegistrarseController;
import co.edu.uniquindio.poo.logistica2.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.ResourceBundle;

public class RegistrarseViewController {
    private App app;
    private RegistrarseController controller;

    @FXML
    public TextField txtId, txtNombre, txtCorreo, txtTelefono;
    @FXML
    public void onRegresar(){
        controller.volver();
    }
    @FXML
    public void onRegistrar(){
        try {
            Usuario usuario = buildUsuario();
            if (usuario == null) {
                mostrarAlerta("Error", "Completa todos los campos");
                return;
            }
            if (controller.registrar(usuario)) {
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo agregar al usuario correctamente");
            }
        } catch (Exception e) {
            mostrarAlerta("Error", "Datos invalidos:" + e.getMessage());
        }
    }
    private Usuario buildUsuario(){
        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String telefono = txtTelefono.getText();
        String id = txtId.getText();
        return (Usuario)  new Usuario.Builder()
                .id(id)
                .nombre(nombre)
                .correo(correo)
                .telefono(telefono)
                .build();
    }
    private void limpiarCampos(){
        txtId.clear();
        txtNombre.clear();
        txtCorreo.clear();
        txtTelefono.clear();
    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    public void setApp(App app) {
        this.app = app;
    }
    public void setController(RegistrarseController controller) {
        this.controller = controller;
    }
}
