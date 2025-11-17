package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.SolicitarPedidoController;
import co.edu.uniquindio.poo.logistica2.model.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class SolicitarPedidoViewController {
    private App app;
    private SolicitarPedidoController controller;
    private Usuario usuario;
    private LocalDate fechaEstimadaEntrega;
    ObservableList<Pedido> list = FXCollections.observableArrayList();
    Pedido selectedPedido;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        lblIdUsuario.setText(usuario.getId());
    }
    @FXML
    public Label lblIdUsuario, lblIdPedido, lblTotal, lblFechaEstimadaEntrega;
    @FXML
    public Button btnEspecificacion;
    @FXML
    public DatePicker dtpFecha;
    @FXML
    public ComboBox<Direccion> cbxDireccionOrigen,cbxDireccionDestino ;
    @FXML
    public ComboBox<Paquete> cbxIdPaquete;
    @FXML
    public TableView<Pedido> tbvPedidos;
    @FXML
    public TableColumn<Pedido, String> tbcIdPedido;
    @FXML
    public TableColumn<Pedido, LocalDate> tbcFechaCreacion;
    @FXML
    public void onRealizarPedido() {
        try {
            Pedido pedido = buildPedido();
            pedido.setId(lblIdPedido.getText());
            pedido.setFechaEstimadaEntrega(fechaEstimadaEntrega);
            pedido.setCosto(Double.parseDouble(lblTotal.getText()));
            if (controller.realizarPedido(pedido)) {
                list.add(pedido);
                limpiarCampos();

            } else {
                mostrarAlerta("Error", "No se pudo agregar el pedido");
            }

        } catch (Exception e) {
            mostrarAlerta("Error", "Datos inválidos: " + e.getMessage());
        }
    }


    @FXML
    public void onActualizar(){
        if (selectedPedido != null) {
            try{
                Pedido nuevo = buildPedido();
                boolean actualizado = controller.actualizarPedido(selectedPedido.getId(), nuevo);
                if (actualizado) {
                    int index = list.indexOf(selectedPedido);
                    list.set(index, nuevo);
                    limpiarCampos();
                    mostrarAlerta("Exito", "Datos actualizados correctamente");
                } else {
                    mostrarAlerta("Error", "No se pudo actualizar el pedido");
                }
            } catch (Exception e) {
                mostrarAlerta("Error", "Datos invalidos: " + e.getMessage());
            }
        }
    }
    @FXML
    public void onDescargarReporte(){
        if(selectedPedido != null){
            try {
                String ruta = "pedidos_exportados/" + selectedPedido.getId() + ".txt";
                controller.exportarPedido(selectedPedido, ruta);
                mostrarAlerta("Pedido exportado", "Se generó el archivo: " + ruta);
            } catch (IOException e) {
                mostrarAlerta("Exportación fallida", "No se pudo exportar el pedido: " + e.getMessage());
            }
        }
    }
    @FXML
    public void onEspecificacion(){
    }
    @FXML
    public void onEliminar(){
        if (selectedPedido != null) {
           boolean eliminado = controller.eliminarPedido(selectedPedido.getId());
           if (eliminado) {
               list.remove(selectedPedido);
               limpiarCampos();
               mostrarAlerta("Exito", "Pedido eliminado");
           } else {
               mostrarAlerta("Error", "No se pudo eliminar el pedido");
           }
        } else {
            mostrarAlerta("Atención", "Selecciona un pedido");
        }
    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    @FXML
    public void onRegresar(){
        controller.irAlUsuario();
    }
    public void setApp(App app) {
        this.app = app;
    }
    public void setController(SolicitarPedidoController controller) {
        this.controller = controller;
        cargarDirecciones();
        cargarPaquetes();
        cargarPedidos();
    }

    public void initialize() {
        tbcIdPedido.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));
        tbcFechaCreacion.setCellValueFactory(
                cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getFechaCreacion()));
        tbvPedidos.setItems(list);
        listenerSelection();
        cargarEvento();
    }
    public void cargarEvento(){
        btnEspecificacion.setOnAction(e -> abrirDialogoEspecificacion());
        cbxIdPaquete.valueProperty().addListener((obs, oldValue, horaSeleccionada) -> {
            actualizarId();
        });
        dtpFecha.valueProperty().addListener((obs, old, newVal) -> calcularFechaEstimada());
        cbxDireccionOrigen.valueProperty().addListener((obs, old, newVal) -> calcularFechaEstimada());
        cbxDireccionDestino.valueProperty().addListener((obs, old, newVal) -> calcularFechaEstimada());
        lblFechaEstimadaEntrega.setText("Fecha");
    }
    private void actualizarId() {
        Paquete seleccionado = cbxIdPaquete.getValue();
        if (seleccionado != null) {
            lblIdPedido.setText(seleccionado.getId());
        } else {
            lblIdPedido.setText("");
        }
    }
    private void abrirDialogoEspecificacion() {
        List<String> opciones = Arrays.asList("Ninguna", "Seguro", "Frágil", "Firma", "Prioridad");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Ninguna", opciones);
        dialog.setTitle("Especificación del Pedido");
        dialog.setHeaderText("Seleccione una especificación adicional");
        dialog.setContentText("Opciones:");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(opcion -> {
            controller.guardarEspecificacion(opcion);
            calcularCosto();
        });
    }
    private void calcularCosto() {
        Paquete paquete = cbxIdPaquete.getValue();
        Direccion origen = cbxDireccionOrigen.getValue();
        Direccion destino = cbxDireccionDestino.getValue();

        if (paquete == null || origen == null || destino == null) {
            lblTotal.setText("Total: $0");
            return;
        }

        double total = controller.calcularCosto(paquete, origen, destino);
        lblTotal.setText(String.valueOf(total));
    }


    private void calcularFechaEstimada() {
        LocalDate fechaSeleccionada = dtpFecha.getValue();
        Direccion origen = cbxDireccionOrigen.getValue();
        Direccion destino = cbxDireccionDestino.getValue();

        LocalDate fecha = controller.calcularFechaEstimada(fechaSeleccionada, origen, destino);

        if (fecha == null) {
            lblFechaEstimadaEntrega.setText("Fecha");
            fechaEstimadaEntrega = null;
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        lblFechaEstimadaEntrega.setText(fecha.format(formatter));
        fechaEstimadaEntrega = fecha;
    }

    private Pedido buildPedido() {
        String id = lblIdPedido.getText();
        LocalDate fecha = dtpFecha.getValue();
        Direccion origen = cbxDireccionOrigen.getSelectionModel().getSelectedItem();
        Direccion destino = cbxDireccionDestino.getSelectionModel().getSelectedItem();
        Paquete paquete = cbxIdPaquete.getSelectionModel().getSelectedItem();
        LocalDate fechaEstimadaEntrega = LocalDate.parse(lblFechaEstimadaEntrega.getText());
        return new Pedido(id,fecha,origen,destino, usuario, fechaEstimadaEntrega,paquete);
    }
    private void listenerSelection(){
        tbvPedidos.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> {
            selectedPedido = newSelection;
            mostrarInformacion(selectedPedido);
        });
    }
    private void mostrarInformacion(Pedido pedido) {
        if (pedido != null) {
            lblIdUsuario.setText(pedido.getUsuario().getId());
            lblIdPedido.setText(pedido.getId());
            dtpFecha.setValue(pedido.getFechaCreacion());//????
            cbxDireccionOrigen.setValue(pedido.getOrigen());
            cbxDireccionDestino.setValue(pedido.getDestino());
            cbxIdPaquete.setValue(pedido.getPaquete());
            lblFechaEstimadaEntrega.setText(pedido.getFechaEstimadaEntrega().toString());
        }
    }
    private void cargarDirecciones(){
        cbxDireccionOrigen.getItems().clear();
        cbxDireccionOrigen.getItems().addAll(controller.obtenerDirecciones());
        cbxDireccionOrigen.setConverter(new StringConverter<Direccion>() {
            @Override
            public String toString(Direccion direccion) {
                return direccion != null ? direccion.getCalle() : "";
            }

            @Override
            public Direccion fromString(String s) {
                return null;
            }
        });
        cbxDireccionDestino.getItems().clear();
        cbxDireccionDestino.getItems().addAll(controller.obtenerDirecciones());
        cbxDireccionDestino.setConverter(new StringConverter<Direccion>() {
            @Override
            public String toString(Direccion direccion) {
                return direccion != null ? direccion.getCalle() : "";
            }

            @Override
            public Direccion fromString(String s) {
                return null;
            }
        });
    }
    public void cargarPaquetes(){
        cbxIdPaquete.getItems().clear();
        cbxIdPaquete.getItems().addAll(controller.obtenerPaquetes());
        cbxIdPaquete.setConverter(new StringConverter<Paquete>() {
            @Override
            public String toString(Paquete paquete) {
                return paquete != null ? paquete.getId() : "";
            }
            @Override
            public Paquete fromString(String s) {
                return null;
            }
        });
    }
    public void cargarPedidos(){
        List<Pedido> pedidos = controller.obtenerPedidos();
        if(pedidos != null){
            list.setAll(pedidos);
            tbvPedidos.setItems(list);
        } else {
            tbvPedidos.getItems().clear();
        }
    }
    private void limpiarCampos(){
        lblIdPedido.setText("");
        lblFechaEstimadaEntrega.setText("Fecha");
        lblTotal.setText("Total: $0");
        cbxDireccionOrigen.getSelectionModel().clearSelection();
        cbxDireccionDestino.getSelectionModel().clearSelection();
        cbxIdPaquete.getSelectionModel().clearSelection();
        dtpFecha.setValue(null);
    }
}
