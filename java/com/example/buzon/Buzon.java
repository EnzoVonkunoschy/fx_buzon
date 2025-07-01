package com.example.buzon;

//import javax.swing.*;
import java.util.ArrayList;

public class Buzon {
    //private String nombre;
    ArrayList<Persona> suscriptores = new ArrayList<>();
    ArrayList<Mensaje> mensajes = new ArrayList<>();


    public boolean hayMensajes(Persona destinatario){
        for (Mensaje mensaje : mensajes){
            if (mensaje.getDestinatario().equals(destinatario)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Mensaje> retirarMensajes(Persona destinatario){
        ArrayList<Mensaje> mensajesARetirar = new ArrayList<>();
        for (Mensaje mensaje : mensajes){
            if (mensaje.getDestinatario().equals(destinatario)){
                mensajesARetirar.add(mensaje);
            }
        }
        return mensajesARetirar;
    }

    public void recibirMensaje(Mensaje mensaje){


        if(suscriptores.contains(mensaje.getDestinatario())){
            mensajes.add(mensaje);
            System.out.println("Mensaje añadido: persona suscripta");

        }else{
            System.out.println("Mensaje no añadido: persona no suscripta");

        }

    }

    public void listarMensajes(){
        for (Mensaje mensaje : mensajes){
            System.out.println(mensaje);
        }
    }

    public void agregarSuscriptor(Persona persona) {
        for (Persona p : suscriptores) {
            if (p.equals(persona)) {
                System.out.println(persona.getNombre() + " ya está suscripto.");
                return;
            }
        }
        suscriptores.add(persona);
        System.out.println(persona.getNombre() + " fue agregado como suscriptor.");
    }

    public void eliminarSuscriptor(Persona persona) {
        suscriptores.remove(persona);
        System.out.println(persona + " fue eliminado como suscriptor");
    }

    public void listarSuscriptores() {
        for (Persona p : suscriptores) {
            System.out.println(p);
        }
    }

    public void ignorarMensaje(Mensaje mensaje) {
        System.out.println("Mensaje de " + mensaje.getRemitente().getNombre() +
                " a " + mensaje.getDestinatario().getNombre() + " fue ignorado.");

    }

}
