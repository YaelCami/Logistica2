package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.CrearPaqueteController;
import co.edu.uniquindio.poo.logistica2.model.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class CrearPaqueteViewController {
    private App app;
    private CrearPaqueteController controller;
    private Usuario usuario;
    ObservableList<Producto> productosDelPaquete = FXCollections.observableArrayList();
    ObservableList<Paquete> list = FXCollections.observableArrayList();
    private double pesoTotalPaquete = 0.0;
    Producto selectedProducto;
    Paquete selectedPaquete;

    @FXML
    public TableView<Producto> tbvProductos;
    @FXML
    public TableView<Paquete> tbvPaquetes;
    @FXML
    public TableColumn<Paquete, String> tbcIdPaquete;
    @FXML
    public TableColumn<Paquete, Double> tbcPesoPaquete;
    @FXML
    public TableColumn<Producto, String> tbcNombreProducto;
    @FXML
    public TableColumn<Producto, Integer> tbcCantidadP;
    @FXML
    public TextField txtIdProducto,txtNombreP,txtMarcaP, txtPesoP,txtCantidadP, txtIdPaquete, txtVolumen;
    @FXML
    public Label lblPesoTotal;
    @FXML
    public ComboBox<Categoria> cbxCategoriaP;
    @FXML
    private void onAgregarProductoAlPaquete() {
        try {
            Producto producto = buildProducto();
            Paquete paquete = buildPaquete();
            if (producto != null) {
                if(controller.agregarProductoAlPaquete(paquete, producto)){
                    productosDelPaquete.add(producto);
                    tbvProductos.setItems(productosDelPaquete);

                    double pesoAgregado = producto.getPeso() * producto.getCantidad();
                    pesoTotalPaquete += pesoAgregado;
                    lblPesoTotal.setText(String.format("%.2f kg", pesoTotalPaquete));
                    limpiarCamposProducto();
                } else {
                    mostrarAlerta("Error", "No se pudo agregar producto al paquete");
                }
            }
        } catch (Exception e) {
            mostrarAlerta("Error", "Datos inválidos: " + e.getMessage());
        }
    }
    @FXML
    private void onAgregarPaquete() {
        try {
            Paquete paquete = buildPaquete();
            if (controller.agregarPaquete(paquete)) {
                list.add(paquete);
                productosDelPaquete.clear();
                limpiarCamposPaquete();
                limpiarCamposProducto();
            } else{
                mostrarAlerta("Error", "No se pudo agregar el paquete");
            }
        } catch (Exception e) {
            mostrarAlerta("Error", "Datos inválidos: " + e.getMessage());
        }
    }


    @FXML
    public void onActualizarProducto(){
        try {
            if (selectedPaquete == null) {
                mostrarAlerta("Error", "Selecciona un paquete primero.");
                return;
            }
            Producto actualizado = buildProducto();
            if (actualizado != null) {
                if (controller.actualizarProductoEnPaquete(selectedPaquete.getId(), selectedProducto.getId(), actualizado)) {
                    mostrarAlerta("Éxito", "Producto actualizado.");
                    limpiarCamposProducto();
                } else {
                    mostrarAlerta("Error", "No se pudo actualizar el producto.");
                }
            }
        } catch (Exception e) {
            mostrarAlerta("Error", "Datos inválidos: " + e.getMessage());
        }
    }
    @FXML
    public void onEliminarProducto(){
        try {
            if (selectedPaquete == null || selectedProducto == null) {
                mostrarAlerta("Error", "Selecciona un paquete y un producto.");
                return;
            }
            if (controller.eliminarProductoDePaquete(selectedPaquete.getId(), selectedProducto.getId())) {
                mostrarAlerta("Éxito", "Producto eliminado.");
                limpiarCamposProducto();
            } else {
                mostrarAlerta("Error", "No se pudo eliminar el producto.");
            }
        } catch (Exception e) {
            mostrarAlerta("Error", "Datos inválidos: " + e.getMessage());
        }
    }
    @FXML
    public void onActualizarPaquete(){
        if(selectedPaquete != null){
            try{
                Paquete nuevo = buildPaquete();
                nuevo.setListproductos(selectedPaquete.getListproductos());
                boolean actualizado = controller.actualizarPaquete(selectedPaquete.getId(), nuevo);
                if(actualizado){
                    int index = list.indexOf(selectedPaquete);
                    list.set(index, nuevo);
                    limpiarCamposPaquete();
                    mostrarAlerta("Exito", "Paquete actualizado correctamente");
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
    public void onEliminarPaquete(){
        if(selectedPaquete != null){
            boolean eliminado = controller.eliminarPaquete(selectedPaquete.getId());
            if(eliminado){
                list.remove(selectedPaquete);
                limpiarCamposPaquete();
                mostrarAlerta("Exito", "Paquete eliminado correctamente");
            } else {
                mostrarAlerta("Error", "No se pudo eliminar correctamente.");
            }
        } else{
            mostrarAlerta("Atencion", "Selecciona un paquete para eliminar");
        }
    }
    @FXML
    public void onRegresar(){
        controller.regresar();
    }
    public void setApp(App app) {
        this.app = app;
    }
    public void setController(CrearPaqueteController controller) {
        this.controller = controller;
        obtenerPaquetes();
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void initialize(){
        tbcIdPaquete.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));
        tbcPesoPaquete.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getPeso()));
        tbcNombreProducto.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcCantidadP.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getCantidad()));
        cbxCategoriaP.getItems().addAll(Categoria.values());
        tbvProductos.setItems(productosDelPaquete);
        tbvPaquetes.setItems(list);
        listenerSelection();
        listenerSelectionProducto();
    }
    private Producto buildProducto() {
        String id = txtIdProducto.getText();
        String nombre = txtNombreP.getText();
        String marca = txtMarcaP.getText();
        Double peso = Double.parseDouble(txtPesoP.getText());
        Integer cantidad = Integer.parseInt(txtCantidadP.getText());
        Categoria categoria = cbxCategoriaP.getSelectionModel().getSelectedItem();
        Producto producto = new Producto.Builder().id(id).nombre(nombre).marca(marca).cantidad(cantidad).categoria(categoria).peso(peso).build();
        if (producto == null) {
            return null;
        }
        return producto;
    }
    private Paquete buildPaquete() {
        String id = txtIdPaquete.getText();
        Double volumen = Double.valueOf(txtVolumen.getText());
        return new Paquete.Builder()
                .id(id)
                .listproductos(new ArrayList<>(productosDelPaquete))
                .peso(pesoTotalPaquete)
                .volumen(volumen)
                .build();
    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    private void limpiarCamposProducto() {
        txtIdProducto.clear();
        txtNombreP.clear();
        txtMarcaP.clear();
        txtPesoP.clear();
        txtCantidadP.clear();
        cbxCategoriaP.setValue(null);
    }
    private void limpiarCamposPaquete() {
        txtIdPaquete.clear();
        txtVolumen.clear();
        lblPesoTotal.setText("0.0 kg");
    }
    private void listenerSelection() {
        tbvPaquetes.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> {
            selectedPaquete = newSelection;
            mostrarInformacion(selectedPaquete);
        });
    }
    private void listenerSelectionProducto() {
        tbvProductos.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> {
            selectedProducto = newSelection;
            mostrarInformacionProducto(selectedProducto);
        });
    }
    public void obtenerPaquetes(){
        List<Paquete> paquetes = controller.obtenerPaquetes();
        if(paquetes != null){
            list.setAll(paquetes);
            tbvPaquetes.setItems(list);
        } else {
            tbvPaquetes.getItems().clear();
        }
    }
    private void mostrarInformacion(Paquete paquete) {
        if(paquete != null){
            txtIdPaquete.setText(paquete.getId());
            txtVolumen.setText(Double.toString(paquete.getVolumen()));
            lblPesoTotal.setText(Double.toString(paquete.getPeso()));
            tbvProductos.setItems(FXCollections.observableArrayList(paquete.getListproductos()));
        }
    }
    private void mostrarInformacionProducto(Producto producto) {
        if(producto != null){
            txtIdProducto.setText(producto.getId());
            txtNombreP.setText(producto.getNombre());
            txtMarcaP.setText(producto.getMarca());
            txtPesoP.setText(Double.toString(producto.getPeso()));
            txtCantidadP.setText(Integer.toString(producto.getCantidad()));
            cbxCategoriaP.setValue(producto.getCategoria());
        }
    }
}
