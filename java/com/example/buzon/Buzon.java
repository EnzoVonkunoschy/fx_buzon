package com.example.buzon;

import java.util.ArrayList;

public class Buzon {
    private String nombre;
    private ArrayList<Mensaje> mensajes = new ArrayList<>();
    private ArrayList<Persona> suscriptores = new ArrayList<>();


    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public boolean hayMensajes(Persona destinatario){
        for (Mensaje mensaje : mensajes){
            if (mensaje.getDestinatario().equals(destinatario) && suscriptores.contains(destinatario)){
                return true;
            }
        }
        return false;
    }

    public void agregarSuscriptor(Persona persona){
        suscriptores.add(persona);
        System.out.println("persona añadida");
    }

    public void eliminarSuscriptor(Persona personaAEliminar){
        for (Persona persona : suscriptores){
            if (persona.equals(personaAEliminar)){
                suscriptores.remove(personaAEliminar);
                System.out.println("persona eliminada");
                break;
            }
        }
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

    public void listarSuscriptores(){
        for (Persona suscriptores : suscriptores){
            System.out.println(suscriptores);
        }
    }
}
