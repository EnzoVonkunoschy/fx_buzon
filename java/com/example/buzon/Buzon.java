package com.example.buzon;

import java.util.ArrayList;


public class Buzon {
    ArrayList<Mensaje> mensajes = new ArrayList<>();
    ArrayList<Persona> suscriptores = new ArrayList<>();//creo la nueva lista de suscriptores


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
        mensajes.add(mensaje);
    }

    public void listarMensajes(){
        for (Mensaje mensaje : mensajes){
            System.out.println(mensaje);
        }
    }
    //agregar suscriptores
    public void agregarSuscriptores(Persona persona){
        suscriptores.add(persona); //agrega a la lista
        System.out.println("Suscriptor agregado: "+persona);
    }
    //eliminar suscriptores
    public void eliminarSuscriptores(Persona persona){
        suscriptores.remove(persona);//elimina persona
        System.out.println("Se elimino al suscriptor: "+ persona);
    }
    //listar suscriptores
    public void listarSuscriptores(){
        for (Persona suscriptor : suscriptores){
            System.out.println("Suscriptores: "+suscriptor);
        }
    }
    //ignorar mensaje
    public void ignorarMensaje(Mensaje mensaje){
        System.out.println("Mensaje ignorado: "+mensaje);
    }
}
