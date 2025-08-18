package com.example.buzon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

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

        // Instancio personas
        Persona p1 = new Persona("Enzo", "38388399");
        Persona p2 = new Persona("Claudia", "45455455");
        Persona p3 = new Persona("Laura", "23233233");
        Persona p4 = new Persona("Carlos", "35355553");
        Persona p5 = new Persona("Charles", "35355553");

        // Coleccion de Persona
        ArrayList<Persona> colPersona = new ArrayList<>();
        colPersona.add(p1);
        colPersona.add(p2);
        colPersona.add(p3);
        colPersona.add(p4);
        colPersona.add(p5);

        // Crear mensajes
        Mensaje m0 = new Mensaje(p1, p2, "Hola, me podes llamar");
        Mensaje m1 = new Mensaje(p2, p3, "Hola Claudia. ¿Cómo estás?");
        Mensaje m2 = new Mensaje(p3, p4, "Recordá la reunión de mañana.");
        Mensaje m3 = new Mensaje(p4, p1, "Pasame el informe cuando puedas.");

        // Coleccion de Mensajes
        ArrayList<Mensaje> colMensajes = new ArrayList<>();
        colMensajes.add(m0);
        colMensajes.add(m1);
        colMensajes.add(m2);
        colMensajes.add(m3);


        // Crear instancia del buzón
        Buzon buzon1 = new Buzon();
        Buzon buzon2 = new Buzon();

        buzon1.agregarSuscriptor(p1);
        buzon1.agregarSuscriptor(p2);

        buzon2.agregarSuscriptor(p3);
        buzon2.agregarSuscriptor(p4);

        buzon1.setSiguienteBuzon(buzon2);

        // Recibir mensajes en el buzón
        for(int i=0 ; i<colMensajes.size() ; i++){
            buzon1.recibirMensaje(colMensajes.get(i));
        }

        System.out.println("Buzon1-----------");
        buzon1.listarMensajes();
        System.out.println("Buzon2------------");
        buzon2.listarMensajes();

        for(int i=0 ; i<colPersona.size() ; i++){
            buzon1.retirarMensajes(colPersona.get(i));
            buzon2.retirarMensajes(colPersona.get(i));
        }
        System.out.println("(buzones luego de retirar los mensajes)");
        System.out.println("Buzon1-----------");
        buzon1.listarMensajes();
        System.out.println("Buzon2------------");
        buzon2.listarMensajes();
    }

}
