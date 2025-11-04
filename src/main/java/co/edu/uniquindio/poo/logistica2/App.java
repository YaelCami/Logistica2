package co.edu.uniquindio.poo.logistica2;

import co.edu.uniquindio.poo.logistica2.controller.*;
import co.edu.uniquindio.poo.logistica2.model.Administrador;
import co.edu.uniquindio.poo.logistica2.model.EmpresaLogistica;
import co.edu.uniquindio.poo.logistica2.model.Persona;
import co.edu.uniquindio.poo.logistica2.model.Usuario;
import co.edu.uniquindio.poo.logistica2.viewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private Stage primaryStage;
    private EmpresaLogistica empresa = EmpresaLogistica.getInstance();
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestion de Pedidos");
        openViewPrincipal();
    }
    public void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudPrimary.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            PrimaryViewController primaryViewController = loader.getController();
            PrimaryController primaryController = new PrimaryController();
            primaryController.setApp(this);
            primaryViewController.setPrimaryController(primaryController);
            primaryViewController.setApp(this);


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
    public void openCotizarTarifa() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CotizarTarifa.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            CotizarTarifaViewController viewController = loader.getController();
            CotizarTarifaController controller = new CotizarTarifaController();
            controller.setApp(this);
            viewController.setController(controller);
            viewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openRastrearPedido() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("RastrearPedido.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            RastrearPedidoViewController viewController = loader.getController();
            RastrearPedidoController controller = new RastrearPedidoController();
            controller.setApp(this);
            viewController.setController(controller);
            viewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openUsuario(Usuario u) {//Necesito pasarle un usuario para que pueda mostrar su nombre
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Usuario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            UsuarioViewController viewController = loader.getController();
            UsuarioController controller = new UsuarioController();
            controller.setApp(this);
            viewController.setController(controller);
            viewController.setApp(this);
            viewController.setUsuario(u);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openAdministrador(Administrador a){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Administrador.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            AdministradorViewController viewController = loader.getController();
            AdministradorController controller = new AdministradorController();
            controller.setApp(this);
            controller.setAdministrador(a);
            viewController.setController(controller);
            viewController.setApp(this);
            viewController.setAdministrador(a);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openHistorialEnvios() {//Agregarle el usuario, necesita un usuario para ver su hustorial
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("HistorialEnvios.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            HistorialEnviosViewController viewController = loader.getController();
            HistorialEnviosController controller = new HistorialEnviosController();
            controller.setApp(this);
            viewController.setController(controller);
            viewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openAgregarDireccion(Usuario u){//Agregarle el usuario, necesita un usuario al cual agregarle la direccion
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("AgregarDireccion.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            AgregarDireccionViewController viewController = loader.getController();
            AgregarDireccionController controller = new AgregarDireccionController(u);
            controller.setApp(this);
            controller.setUsuario(u);
            viewController.setController(controller);
            viewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openSolicitarPedido(){//Pasarle usuario para que registre pedido con su id y direcciones
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("SolicitarPedido.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            SolicitarPedidoViewController viewController = loader.getController();
            SolicitarPedidoController controller = new SolicitarPedidoController();
            controller.setApp(this);
            viewController.setController(controller);
            viewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrearPaquete(){//Creeria yo que tambien hay que pasarle al usuario
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrearPaquete.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            CrearPaqueteViewController viewController = loader.getController();
            CrearPaqueteController controller = new CrearPaqueteController();
            controller.setApp(this);
            viewController.setController(controller);
            viewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openGestionRepartidor(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("GestionRepartidor.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            GestionRepartidorViewController viewController = loader.getController();
            GestionRepartidorController controller = new GestionRepartidorController();
            controller.setApp(this);
            viewController.setController(controller);
            viewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openActualizarEnvio(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("ActualizarEstadoEnvio.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ActualizarEstadoEnvioViewController viewController = loader.getController();
            ActualizarEstadoEnvioController controller = new ActualizarEstadoEnvioController();
            controller.setApp(this);
            viewController.setController(controller);
            viewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openAsignarPedido(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("AsignarEnvio.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            AsignarEnvioViewController viewController = loader.getController();
            AsignarPedidoController controller = new AsignarPedidoController();
            controller.setApp(this);
            viewController.setController(controller);
            viewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openRegistrarse(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Registrarse.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            RegistrarseViewController viewController = loader.getController();
            RegistrarseController controller = new RegistrarseController();
            controller.setApp(this);
            viewController.setController(controller);
            viewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openGestionarUsuario(Administrador a){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("GestionarUsuario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            GestionarUsuarioViewController viewController = loader.getController();
            GestionarUsuarioController controller = new GestionarUsuarioController();
            controller.setApp(this);
            controller.setAdministrador(a);
            viewController.setController(controller);
            viewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void inicializarData() {
        Persona usuario1 = new Usuario.Builder().id("1230").nombre("Raul").telefono("322470").build();
        Persona administrador1 = new Administrador.Builder().id("0321").nombre("Susana").correo("Susana@gmail.com").build();
        empresa.agregarPersona(usuario1);
        empresa.agregarPersona(administrador1);
        System.out.println("DEBUG - Lista de administradores en la empresa:");
        for (Administrador s : empresa.getListAdministradores()) {
            System.out.println(" -> " + s.getId() + " - " + s.getNombre());
        }
    }

}