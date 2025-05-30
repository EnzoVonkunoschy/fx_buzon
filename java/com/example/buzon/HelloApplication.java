package com.example.buzon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication {
    public static void main(String[] args) {
        System.out.println("Iniciando sistema de mensajes...");

        Buzon buzon = new Buzon();

        Mensaje m1 = new Mensaje("Enzo", "Claudia", "Hola Claudia. ¿Cómo estás?");
        Mensaje m2 = new Mensaje("Laura", "Claudia", "Recordá la reunión de mañana.");
        Mensaje m3 = new Mensaje("Carlos", "Luis", "Pasame el informe cuando puedas.");

        buzon.recibirMensaje(m1);
        buzon.recibirMensaje(m2);
        buzon.recibirMensaje(m3);

        System.out.println("\n--- Mensajes en el buzón ---");
        buzon.listarMensajes();

        System.out.println("\n¿Hay mensajes para Claudia? " + buzon.hayMensajes("Claudia"));

        System.out.println("\n--- Retirando mensajes para Claudia ---");
        for (Mensaje mensaje : buzon.retirarMensajes("Claudia")) {
            System.out.println(mensaje);
        }

        System.out.println("\n--- Mensajes restantes en el buzón ---");
        buzon.listarMensajes();
    }
}
