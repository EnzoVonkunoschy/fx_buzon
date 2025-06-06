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

    public static void main(String[] args) {
        System.out.println("Starting system.");

        // Aca creo las personas
        Persona enzo = new Persona("Enzo", "20-12345678-9");
        Persona claudia = new Persona("Claudia", "27-87654321-0");
        Persona laura = new Persona("Laura", "23-22222222-2");
        Persona carlos = new Persona("Carlos", "24-33333333-3");
        Persona luis = new Persona("Luis", "21-44444444-4");

        // Creo mensajes con personas
        Mensaje mensaje = new Mensaje(enzo, claudia, "Hola Claudia. ¿Como estás?");
        System.out.println(mensaje);

        Buzon buzon = new Buzon();

        Mensaje m1 = new Mensaje(enzo, claudia, "Hola Claudia. ¿Cómo estás?");
        Mensaje m2 = new Mensaje(laura, claudia, "Recordá la reunión de mañana.");
        Mensaje m3 = new Mensaje(carlos, luis, "Pasame el informe cuando puedas.");

        buzon.recibirMensaje(m1);
        buzon.recibirMensaje(m2);
        buzon.recibirMensaje(m3);

        System.out.println("\n--- Mensajes en el buzón ---");
        buzon.listarMensajes();

        System.out.println("\n¿Hay mensajes para Claudia? " + buzon.hayMensajes("Claudia"));

        System.out.println("\n--- Retirando mensajes para Claudia ---");
        System.out.println(buzon.retirarMensajes("Claudia"));

        System.out.println("\n--- Mensajes restantes en el buzón ---");
        buzon.listarMensajes();
    }
}
