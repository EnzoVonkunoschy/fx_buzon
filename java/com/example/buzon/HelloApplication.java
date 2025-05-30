package com.example.buzon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    //public static void main(String[] args) {launch();}
    public static void main(String[] args) {
        System.out.println("Starting system.");
        Mensaje mensaje = new Mensaje("Enzo","Claudia","Hola Claudia. ¿Como estás?");
        System.out.println(mensaje);
        Buzon miBuzon = new Buzon();
        if (miBuzon != null) {
            System.out.println("El objeto Buzon fue creado correctamente.");
            // Cuando implementemos los métodos de Buzon, podremos llamar a miBuzon.hayMensaje()
            // para una verificación más robusta.
        } else {
            System.out.println("Error: El objeto Buzon no pudo ser creado.");
        }
    }
}
