package co.edu.uniquindio.poo.logistica2;

import co.edu.uniquindio.poo.logistica2.controller.*;
import co.edu.uniquindio.poo.logistica2.model.*;
import co.edu.uniquindio.poo.logistica2.viewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

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
    public void openUsuario(Usuario u) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Usuario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            UsuarioViewController viewController = loader.getController();
            UsuarioController controller = new UsuarioController();
            controller.setApp(this);
            controller.setUsuario(u);
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
    public void openAgregarDireccion(Usuario u){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("AgregarDireccion.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            AgregarDireccionViewController viewController = loader.getController();
            AgregarDireccionController controller = new AgregarDireccionController(u);
            controller.setApp(this);
            controller.setUsuario(u);
            viewController.setUsuario(u);
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
    public void openCrearPaquete(Usuario u){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrearPaquete.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            CrearPaqueteViewController viewController = loader.getController();
            CrearPaqueteController controller = new CrearPaqueteController(u);
            controller.setApp(this);
            controller.setUsuario(u);
            viewController.setUsuario(u);
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
    public void openGestionRepartidor(Administrador a){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("GestionRepartidor.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            GestionRepartidorViewController viewController = loader.getController();
            GestionRepartidorController controller = new GestionRepartidorController();
            controller.setApp(this);
            viewController.setController(controller);
            controller.setAdministrador(a);
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
    public void openGestionarCiudad(Administrador a){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("GestionarCiudad.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            GestionarCiudadViewController viewController = loader.getController();
            GestionarCiudadController controller = new GestionarCiudadController();
            controller.setApp(this);
            controller.setAdministrador(a);
            viewController.setController(controller);
            viewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void openGestionarRuta(Administrador a){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("GestionarRuta.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            GestionarRutaViewController viewController = loader.getController();
            GestionarRutaController controller = new GestionarRutaController();
            controller.setApp(this);
            controller.setAdministrador(a);
            viewController.setController(controller);
            viewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void inicializarData() {
        Persona usuario1 = new Usuario.Builder().id("1230").nombre("Raul").telefono("322470").build();
        Persona administrador1 = new Administrador.Builder().id("0321").nombre("Susana").correo("Susana@gmail.com").build();
        Ciudad ciudad1 = new Ciudad("2233", "Quimbaya", 32175);
        Ciudad ciudad2 = new Ciudad("3322", "Armenia", 309474);
        Ruta ruta1 = new Ruta("0000", ciudad1, ciudad2, 22.2);
        Repartidor repartidor1 = new Repartidor.Builder().id("0304").nombre("Lucia").correo("@lucia").documento("0909").disponibilidad(Disponibilidad.ACTIVO).build();
        if (repartidor1 != null) {
            repartidor1.agregarRuta(ruta1);
        } else {
            System.out.println("Error: El objeto no es un Repartidor.");
        }
        empresa.agregarPersona(usuario1);
        empresa.agregarPersona(administrador1);
        empresa.agregarCiudad(ciudad1);
        empresa.agregarCiudad(ciudad2);
        empresa.agregarRuta(ruta1);
        empresa.agregarPersona(repartidor1);
        System.out.println("DEBUG - Lista de administradores en la empresa:");
        for (Administrador s : empresa.getListAdministradores()) {
            System.out.println(" -> " + s.getId() + " - " + s.getNombre());
        }
        System.out.println("DEBUG - Lista de usuarios en la empresa:");
        for(Usuario u : empresa.getListUsuarios()){
            System.out.println(" -> " + u.getId() + " - " + u.getNombre());
        }
    }

}