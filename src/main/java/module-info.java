module org.example.cbuap {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.cbuap to javafx.fxml;
    exports org.example.cbuap;
}