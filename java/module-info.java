module com.example.buzon {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.buzon to javafx.fxml;
    exports com.example.buzon;
}