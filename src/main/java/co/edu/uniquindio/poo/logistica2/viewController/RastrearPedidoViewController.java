package co.edu.uniquindio.poo.logistica2.viewController;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.controller.RastrearPedidoController;
import co.edu.uniquindio.poo.logistica2.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RastrearPedidoViewController {
    private App app;
    private RastrearPedidoController controller;
    private Usuario usuario;

    @FXML
    private TextArea txaInfoPedido;
    @FXML
    private TextField txtIdPedido;
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    @FXML
    public void onLimpiar(){
        txaInfoPedido.clear();
    }
    @FXML
    public void onBuscarPedido(){
        txaInfoPedido.setText(controller.rastrearPedido(txtIdPedido.getText()));
    }

    public void setApp(App app) {
        this.app = app;
    }

    public void setController(RastrearPedidoController controller) {
        this.controller = controller;
    }
    @FXML
    public void onRegresar(){
        controller.irAlInicio();
    }
}
