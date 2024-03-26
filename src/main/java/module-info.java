module com.example.aiproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.aiproject to javafx.fxml;
    exports com.example.aiproject;
}