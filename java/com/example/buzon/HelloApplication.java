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
        testSuscriptorUnico();

    }
    public static void testSuscriptorUnico () {
        System.out.println("running suscriptor Unico");

        Persona p0 = new Persona("Bart Simpson","1234567890");
        Persona p1 = new Persona("Lisa Simpson","1234567891");
        Persona p2 = new Persona("Meg Simpson","1234567891");

        ArrayList<Persona> colPer = new ArrayList<>();
        colPer.add(p0);
        colPer.add(p1);
        colPer.add(p2);
        ArrayList<Buzon> colBuz = new ArrayList<>();
        for(int i=0 ; i<4 ; i++){
            colBuz.add(new Buzon());
        }

        // Anillo de Buzon(es) -------------------------------
        for(int i = 0 ; i<colBuz.size()-1 ; i++){
            colBuz.get(i).setSiguienteBuzon(colBuz.get(i+1));
        }
        colBuz.get(colBuz.size()-1).setSiguienteBuzon(colBuz.get(0));

        // Todas las personas, buzón por buzón
        for(int i=0 ; i<colBuz.size() ; i++){
            for(int j=0 ; j<colPer.size() ; j++){
                colBuz.get(i).agregarSuscriptor(colPer.get(j));
                colBuz.get(i).agregarSuscriptor(colPer.get(j));
            }
        }
        System.out.println("Suscriptores por Buzon------------------------------");
        for(int i=0 ; i<colBuz.size() ; i++){
            System.out.println("Buzon: "+i);
            colBuz.get(i).listarSuscriptores();
        }

        System.out.println("Dessuscribir a todos---------------------------------");
        for(int i=0 ; i<colBuz.size() ; i++){
            for(int j=0 ; j<colPer.size() ; j++){
                colBuz.get(i).eliminarSuscriptor(colPer.get(j));
            }
        }
        System.out.println("Suscriptores por Buzon------------------------------");
        for(int i=0 ; i<colBuz.size() ; i++){
            System.out.println("Buzon: "+i);
            colBuz.get(i).listarSuscriptores();
        }

        System.out.println("Suscribiendo Persona(s)------------------------------");
        int i = -1; boolean duvi = false;
        int j = -1; boolean duvj = false;
        do{
            i += 1; j += 1;
            colBuz.get(i).agregarSuscriptor(colPer.get(j));
            System.out.println("suscribí a "+colPer.get(j).getNombre()+" a Buzon "+i);
            //System.out.println("suscribí a "+j+" a Buzon "+i);
            if(i >= colBuz.size()-1){ i = -1; duvi = true;};
            if(j >= colPer.size()-1){ j = -1; duvj = true;};

        }while(!(duvi && duvj));

        System.out.println("Suscriptores por Buzon------------------------------");
        for(i=0 ; i<colBuz.size() ; i++){
            System.out.println("Buzon: "+i);
            colBuz.get(i).listarSuscriptores();
        }

        /* Mateche de Persona
        Persona p0 = new Persona("Bart Simpson","1234567890");
        Persona p1 = new Persona("Lisa Simpson","1234567891");
        Persona p2 = new Persona("Meg Simpson","1234567891");*/

        Mensaje m0 = new Mensaje(p2,p0,"¿hello chigga?");
        colBuz.get(3).recibirMensaje(m0);

        Mensaje confirmacion = new Mensaje(p1,p0,"Mensaje recibido por "+p1.getNombre());
        //colBuz.get(0).recibirMensaje(confirmacion);  //comentar esta línea al implementar incremento.


        estadoBuzon_es(colBuz);

    }

    public static void estadoBuzon_es(ArrayList<Buzon> alb){
        for(int i=0 ; i<alb.size() ; i++){
            estadoBuzon(i,alb.get(i));
        }
    }

    public static void estadoBuzon(int i,Buzon buzon){
        System.out.println("Buzon: "+i+"------------------");
        buzon.listarSuscriptores();
        buzon.listarMensajes();
    }


}