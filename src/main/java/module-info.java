module org.example.demobmi {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.demobmi to javafx.fxml;
    exports org.example.demobmi;
}