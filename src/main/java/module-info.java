module co.edu.uniquindio.poo.logistica2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.poo.logistica2 to javafx.fxml;
    exports co.edu.uniquindio.poo.logistica2;
    exports co.edu.uniquindio.poo.logistica2.viewController;
    opens co.edu.uniquindio.poo.logistica2.viewController to javafx.fxml;
}
