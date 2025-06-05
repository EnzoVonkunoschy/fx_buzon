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
        // Crear instancia del buzón
        Buzon buzon = new Buzon();

        // Crear mensajes
        Mensaje m1 = new Mensaje("Enzo", "Claudia", "Hola Claudia. ¿Cómo estás?");
        Mensaje m2 = new Mensaje("Laura", "Claudia", "Recordá la reunión de mañana.");
        Mensaje m3 = new Mensaje("Carlos", "Luis", "Pasame el informe cuando puedas.");

        // Recibir mensajes en el buzón
        buzon.recibirMensaje(m1);
        buzon.recibirMensaje(m2);
        buzon.recibirMensaje(m3);
        // Listar todos los mensajes
        System.out.println("\n--- Mensajes en el buzón ---");
        buzon.listarMensajes();

        // Verificar si hay mensajes para Claudia
        System.out.println("\n¿Hay mensajes para Claudia? " + buzon.hayMensajes("Claudia"));

        // Retirar mensajes para Claudia
        System.out.println("\n--- Retirando mensajes para Claudia ---");
        System.out.println(buzon.retirarMensajes("Claudia"));

        // Listar mensajes restantes
        System.out.println("\n--- Mensajes restantes en el buzón ---");
        buzon.listarMensajes();
    }
}
