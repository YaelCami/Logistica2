package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.GestionarUsuarioController;
import co.edu.uniquindio.poo.logistica2.model.Usuario;
import co.edu.uniquindio.poo.logistica2.model.UsuarioDTO;
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

public class GestionarUsuarioViewController {
    private App app;
    private GestionarUsuarioController controller;
    ObservableList<Usuario> list = FXCollections.observableArrayList();
    Usuario selectedUsuario;
    @FXML
    private URL location;
    public void setApp(App app) {
        this.app = app;
    }
    @FXML
    private ResourceBundle resources;
    @FXML
    public TableView<Usuario> tbvUsuario;
    @FXML
    public TableColumn<Usuario, String> tbcNombre, tbcId, tbcCorreo, tbcTelefono;
    @FXML
    public TextField txtNombre, txtId, txtCorreo, txtTelefono;
    @FXML
    public void onRegresar(){
        controller.volver();
    }
    @FXML
    public void onRegistrar(){
        registrar();
    }
    @FXML
    public void onActualizar(){
        if(selectedUsuario != null){
            try{
                Usuario nuevo = buildUsuario();
                boolean actualizado = controller.actualizar(selectedUsuario.getId(), nuevo);
                if(actualizado){
                    int index = list.indexOf(selectedUsuario);
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
        if(selectedUsuario != null){
            boolean eliminado = controller.eliminar(selectedUsuario.getId());
            if(eliminado){
                list.remove(selectedUsuario);
                limpiarCampos();
                mostrarAlerta("Exito", "Usuario eliminado correctamente");
            } else {
                mostrarAlerta("Error", "No se pudo eliminar correctamente.");
            }
        } else{
            mostrarAlerta("Atencion", "Selecciona un usuario para eliminar");
        }
    }
    public void registrar(){
        try {
            UsuarioDTO dto = buildUsuarioDTO();
            if (dto == null) {
                mostrarAlerta("Error", "Completa todos los campos");
                return;
            }
            Usuario usuario = controller.agregarUsuario(dto);
            if (usuario != null) {
                list.add(usuario);
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo agregar al usuario correctamente");
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
        tbcNombre.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcId.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));
        tbcTelefono.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTelefono()));
        tbcCorreo.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCorreo()));
        tbvUsuario.setItems(list);
        listenerSelection();
    }
    private UsuarioDTO buildUsuarioDTO() {
        return new UsuarioDTO(
                txtNombre.getText(),
                txtId.getText(),
                txtCorreo.getText(),
                txtTelefono.getText()
        );
    }
    private Usuario buildUsuario() {
        String nombre = txtNombre.getText();
        String id = txtId.getText();
        String correo = txtCorreo.getText();
        String telefono = txtTelefono.getText();
        return (Usuario) new Usuario.Builder()
                .nombre(nombre)
                .telefono(telefono)
                .correo(correo)
                .id(id)
                .build();
    }

    public void setController(GestionarUsuarioController controller){
        this.controller = controller;
        obtenerUsuarios();
    }
    public void obtenerUsuarios(){
        List<Usuario> usuarios = controller.obtenerListaUsuarios();
        if(usuarios != null){
            list.setAll(usuarios);
            tbvUsuario.setItems(list);
        } else{
            tbvUsuario.getItems().clear();
        }
    }
    private void listenerSelection(){
        tbvUsuario.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> {
            selectedUsuario = newSelection;
            mostrarInformacionUsuario(selectedUsuario);
        });
    }
    private void mostrarInformacionUsuario(Usuario usuario){
        if(usuario != null){
            txtNombre.setText(usuario.getNombre());
            txtCorreo.setText(usuario.getCorreo());
            txtTelefono.setText(usuario.getTelefono());
            txtId.setText(usuario.getId());
        }
    }
    private void limpiarCampos(){
        txtId.clear();
        txtNombre.clear();
        txtCorreo.clear();
        txtTelefono.clear();
    }
}
