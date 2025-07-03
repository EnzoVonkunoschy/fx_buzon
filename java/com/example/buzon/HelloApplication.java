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
        Persona p1 = new Persona("Enzo", "38388399");
        Persona p2 = new Persona("Claudia", "45455455");
        Persona p3 = new Persona("Laura", "23233233");
        Persona p4 = new Persona("Carlos", "35355553");
        Mensaje mensaje = new Mensaje(p1,p2,"Hola Claudia. ¿Como estás?");
        System.out.println(mensaje);
        // Crear instancia del buzón
        Buzon buzon = new Buzon();

        // Crear mensajes
        Mensaje m1 = new Mensaje(p1, p2, "Hola Claudia. ¿Cómo estás?");
        Mensaje m2 = new Mensaje(p3, p2, "Recordá la reunión de mañana.");
        Mensaje m3 = new Mensaje(p3, p4, "Pasame el informe cuando puedas.");

        //Mensaje ignorado
        Mensaje ig1 = new Mensaje(p3, p2, "Hola, me podes llamar");



        // Recibir mensajes en el buzón

        buzon.recibirMensaje(m2);
        buzon.recibirMensaje(m3);
        // Listar todos los mensajes
        System.out.println("\n--- Mensajes en el buzón ---");
        buzon.listarMensajes();

        // Verificar si hay mensajes para Claudia
        System.out.println("\n¿Hay mensajes para Claudia? " + buzon.hayMensajes(p2));

        // Retirar mensajes para Claudia
        System.out.println("\n--- Retirando mensajes para Claudia ---");
        System.out.println(buzon.retirarMensajes(p2));

        // Listar mensajes restantes
        System.out.println("\n--- Mensajes restantes en el buzón ---");
        buzon.listarMensajes();

        //Agregar suscriptores
        Persona s1 = new Persona("Sofía", "39438399");
        Persona s2 = new Persona("Gabriel", "47455454");
        Persona s3 = new Persona("Lucas", "25234233");

        Mensaje m5 = new Mensaje(s1, s2, "hol");

        System.out.println("\n--- Agregados como suscriptor ---");


        buzon.agregarSuscriptor(s2);
        buzon.agregarSuscriptor(s3);

        buzon.recibirMensaje(m5);



        System.out.println("\n--- Suscriptor eliminado ---");
        
        buzon.eliminarSuscriptor(s2);

        System.out.println("\n--- Lista de suscriptor ---");

        buzon.listarSuscriptores();


        Buzon buzon1 = new Buzon();
        Buzon buzon2 = new Buzon();

        buzon1.setSiguienteBuzon(buzon2);

        Persona s4 = new Persona("Mariana", "12345678");
        buzon2.agregarSuscriptor(s4);

        Mensaje m6 = new Mensaje(p1, s4, "Hola Mariana, mensaje de prueba.");

        buzon1.recibirMensaje(m6);

        System.out.println("\n--- Mensajes en Buzón 2 ---");
        buzon2.listarMensajes();


    }


}
