module com.example.buzon {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.buzon to javafx.fxml;
    exports com.example.buzon;
}