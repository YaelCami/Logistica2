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
import java.time.LocalDate;
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
    public void openRastrearPedido(Usuario u) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("RastrearPedido.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            RastrearPedidoViewController viewController = loader.getController();
            RastrearPedidoController controller = new RastrearPedidoController();
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
    public void openHistorialEnvios(Usuario u) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("HistorialEnvios.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            HistorialEnviosViewController viewController = loader.getController();
            HistorialEnviosController controller = new HistorialEnviosController();
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
    public void openSolicitarPedido(Usuario u){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("SolicitarPedido.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            SolicitarPedidoViewController viewController = loader.getController();
            SolicitarPedidoController controller = new SolicitarPedidoController();
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
    public void openAsignarPedido(Administrador a){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("AsignarEnvio.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            AsignarEnvioViewController viewController = loader.getController();
            AsignarPedidoController controller = new AsignarPedidoController(a);
            controller.setApp(this);
            controller.setAdministrador(a);
            viewController.setAdministrador(a);
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
        Usuario usuario1 = new Usuario.Builder().id("1230").nombre("Raul").telefono("322470").build();
        Usuario usuario2 = new Usuario.Builder().id("2222").nombre("Camila").telefono("322470").build();
        Usuario usuario3 = new Usuario.Builder().id("3333").nombre("Sofia").telefono("322470").correo("@sofi").build();
        Administrador administrador1 = new Administrador.Builder().id("0321").nombre("Susana").correo("Susana@gmail.com").build();
        Ciudad ciudad1 = new Ciudad("634020", "Quimbaya", 32175);
        Ciudad ciudad2 = new Ciudad("630001", "Armenia", 309474);
        Ciudad ciudad3 = new Ciudad("631001", "Circasia", 29789);
        Ciudad ciudad4 = new Ciudad("633020", "Tebaida", 35000);
        Ciudad ciudad5 = new Ciudad("633001","Montenegro",38460);
        Ruta ruta1 = new Ruta("0000", ciudad1, ciudad2, 22.2);
        Ruta ruta2 = new Ruta("0001", ciudad1, ciudad5, 11);
        Ruta ruta3 = new Ruta("0002", ciudad3, ciudad1, 26.8); 
        Ruta ruta4 = new Ruta("0003", ciudad3, ciudad2, 12.8);
        Ruta ruta5 = new Ruta("0004", ciudad1, ciudad4, 28.9);
        Direccion direccion1 = new Direccion("3333", "Casa", "Cra 60", ciudad1, "634020");
        Direccion direccion2 = new Direccion("2222", "Oficina", "Cra 4", ciudad2, "630001");
        Direccion direccion3 = new Direccion("3000", "Parque", "Cra 8", ciudad3, "631001");
        Direccion direccion4 = new Direccion("4000", "Casa", "Cra 9", ciudad4, "633020");
        Direccion direccion5 = new Direccion("5000", "Casa", "Cra 10", ciudad5, "633001");
        Producto producto1 = new Producto.Builder().id("2020").nombre("Pestañina").marca("prosa").peso(4).categoria(Categoria.JUGUETES).cantidad(1).build();
        Paquete paquete1 = new Paquete.Builder().id("5002").peso(4).volumen(3).build();
        Pedido pedido1 = new Pedido("0101", LocalDate.of(2025, 11, 2), direccion3, direccion2,usuario1, LocalDate.of(2025,11,7), paquete1);
        Pedido pedido2 = new Pedido("0202", LocalDate.of(2025, 11,8), direccion1, direccion4,usuario1, LocalDate.of(2025,11,13), paquete1);
        Repartidor repartidor1 = new Repartidor.Builder().id("0304").nombre("Lucia").correo("@lucia").documento("0909").disponibilidad(Disponibilidad.ACTIVO).build();
        if (repartidor1 != null) {
            repartidor1.agregarRuta(ruta1);
            repartidor1.agregarRuta(ruta2);
            repartidor1.agregarRuta(ruta3);
            repartidor1.agregarRuta(ruta4);

        } else {
            System.out.println("Error: El objeto no es un Repartidor.");
        }
        if (paquete1 != null) {
            paquete1.agregarProductos(producto1);
        } else {
            System.out.println("Error: el objeto no es paquete ");
        }
        empresa.agregarPersona(usuario1);
        empresa.agregarPersona(usuario2);
        empresa.agregarPersona(usuario3);
        empresa.agregarPersona(administrador1);
        empresa.agregarCiudad(ciudad1);
        empresa.agregarCiudad(ciudad2);
        empresa.agregarCiudad(ciudad3);
        empresa.agregarCiudad(ciudad4);
        empresa.agregarCiudad(ciudad5);
        empresa.agregarRuta(ruta1);
        empresa.agregarRuta(ruta2);
        empresa.agregarRuta(ruta3);
        empresa.agregarRuta(ruta4);
        empresa.agregarRuta(ruta5);
        empresa.agregarPersona(repartidor1);
        if(usuario1 != null){
            usuario1.agregarPaquete(paquete1);
            usuario1.agregarDireccion(direccion1);
            usuario1.agregarDireccion(direccion2);
            usuario1.agregarDireccion(direccion3);
            usuario1.agregarDireccion(direccion4);
            usuario1.agregarDireccion(direccion5);
            usuario1.solicitarPedido(pedido1);
            usuario1.solicitarPedido(pedido2);
        }
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