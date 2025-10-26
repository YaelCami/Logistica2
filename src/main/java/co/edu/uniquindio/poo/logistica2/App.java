package co.edu.uniquindio.poo.logistica2;

import co.edu.uniquindio.poo.logistica2.controller.*;
import co.edu.uniquindio.poo.logistica2.viewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private Stage primaryStage;
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
    public void openUsuario() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Usuario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            UsuarioViewController viewController = loader.getController();
            UsuarioController controller = new UsuarioController();
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
    public void openHistorialEnvios() {
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


    public static void main(String[] args) {
        launch();
    }
    public void inicializarData() {}

}