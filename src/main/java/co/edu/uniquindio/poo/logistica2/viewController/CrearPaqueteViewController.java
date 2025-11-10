package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.CrearPaqueteController;
import co.edu.uniquindio.poo.logistica2.model.Categoria;
import co.edu.uniquindio.poo.logistica2.model.Paquete;
import co.edu.uniquindio.poo.logistica2.model.Producto;
import co.edu.uniquindio.poo.logistica2.model.Usuario;
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
            // Construye el producto desde los campos (txtIdProducto, etc.)
            Producto producto = buildProducto();  // Implementa este método para crear un Producto
            if (producto != null) {
                productosDelPaquete.add(producto);
                tbvProductos.setItems(productosDelPaquete);
                // Recalcula peso total (peso del producto * cantidad)
                double pesoAgregado = producto.getPeso() * producto.getCantidad();
                pesoTotalPaquete += pesoAgregado;
                lblPesoTotal.setText(String.format("%.2f kg", pesoTotalPaquete));
                limpiarCamposProducto();  // Limpia los campos de producto
            }
        } catch (Exception e) {
            mostrarAlerta("Error", "Datos inválidos: " + e.getMessage());
        }
    }
    @FXML
    private void onAgregarPaquete() {
        try {
            String idPaquete = txtIdPaquete.getText();
            double volumen = Double.parseDouble(txtVolumen.getText());
            // Crea el paquete con la lista de productos y peso total
            Paquete paquete = new Paquete.Builder()
                    .id(idPaquete)
                    .listproductos(new ArrayList<>(productosDelPaquete))  // Copia de la lista temporal
                    .peso(pesoTotalPaquete)
                    .volumen(volumen)
                    .build();
            if (controller.agregarPaquete(paquete)) {  // Asumiendo que tienes este método en el controller
                // Agrega a la TableView de paquetes
                list.add(paquete);
                // Resetea la lista temporal y peso
                productosDelPaquete.clear();
                limpiarCamposPaquete();
            } else{
                mostrarAlerta("Error", "No se pudo agregar el paquete");
            }
        } catch (Exception e) {
            mostrarAlerta("Error", "Datos inválidos: " + e.getMessage());
        }
    }

    @FXML
    public void onActualizarProducto(){}
    @FXML
    public void onEliminarProducto(){}
    @FXML
    public void onActualizarPaquete(){}
    @FXML
    public void onEliminarPaquete(){}
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
                new SimpleStringProperty(cellData.getValue().getNombre()));  // Asume que Producto tiene getNombre()
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
