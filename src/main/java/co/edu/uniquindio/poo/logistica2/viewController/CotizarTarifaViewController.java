package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.CotizarTarifaController;
import co.edu.uniquindio.poo.logistica2.model.Ciudad;
import co.edu.uniquindio.poo.logistica2.model.Direccion;
import co.edu.uniquindio.poo.logistica2.model.Paquete;
import co.edu.uniquindio.poo.logistica2.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CotizarTarifaViewController {
    private App app;
    private CotizarTarifaController controller;

    @FXML
    public Label lblPrecio;
    @FXML
    public TextField txtVolumen, txtPeso, txtCodigoDestino, txtCodigoOrigen;
    @FXML
    public ComboBox<Ciudad> cbxCiudadOrigen, cbxCiudadDestino;
    @FXML
    public void onCalcularTarifa(){
        calcularTarifa();
    }
    @FXML
    public void onCondicion(){
        List<String> opciones = Arrays.asList("Ninguna", "Seguro", "Frágil", "Firma", "Prioridad");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Ninguna", opciones);
        dialog.setTitle("Especificación del Pedido");
        dialog.setHeaderText("Seleccione una especificación adicional");
        dialog.setContentText("Opciones:");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(opcion -> {
            controller.guardarEspecificacion(opcion);
        });
    }

    @FXML
    public void onRegresar(){
        controller.irAlInicio();
    }
    public void setApp(App app) {
        this.app = app;
    }
    private Paquete buildPaquete(){
        double peso = Double.parseDouble(txtPeso.getText());
        double volumen = Double.parseDouble(txtVolumen.getText());
        return new Paquete.Builder().peso(peso).volumen(volumen).build();
    }
    public Direccion buildOrigen(){
        Ciudad ciudad = cbxCiudadOrigen.getSelectionModel().getSelectedItem();
        String coordenadas = txtCodigoOrigen.getText();
        return new Direccion("id", "casa","cra15", ciudad, coordenadas);
    }
    public Direccion buildDestino(){
        Ciudad ciudad = cbxCiudadDestino.getSelectionModel().getSelectedItem();
        String coordenadas = txtCodigoDestino.getText();
        return new Direccion("destino", "casa", "cra 34", ciudad, coordenadas);
    }
    public Usuario buildUsuario(){
        return new Usuario.Builder().build();
    }
    private void calcularTarifa(){
        Paquete paquete = buildPaquete();
        Direccion origen = buildOrigen();
        Direccion destino = buildDestino();
        Usuario usuario = buildUsuario();
        if (paquete == null || origen == null || destino == null) {
            lblPrecio.setText("Total: $0");
            return;
        }

        double total = controller.calcularPrecio(paquete, origen, destino, usuario);
        lblPrecio.setText("Total: $"+ String.valueOf(total));
    }
    public void setController(CotizarTarifaController controller) {
        this.controller = controller;
        cargarCiudades();
    }
    private void cargarCiudades(){
        cbxCiudadOrigen.getItems().clear();
        cbxCiudadOrigen.getItems().addAll(controller.obtenerCiudades());
        cbxCiudadOrigen.setConverter(new StringConverter<Ciudad>() {
            @Override
            public String toString(Ciudad ciudad) {
                return ciudad != null ? ciudad.getNombre() : "";
            }

            @Override
            public Ciudad fromString(String string) {
                return null;
            }
        });
        cbxCiudadDestino.getItems().clear();
        cbxCiudadDestino.getItems().addAll(controller.obtenerCiudades());
        cbxCiudadDestino.setConverter(new StringConverter<Ciudad>() {
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
