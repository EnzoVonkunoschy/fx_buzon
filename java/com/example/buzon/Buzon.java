package com.example.buzon;

import java.util.ArrayList;
import java.util.List;

public class Buzon {
    private String nombre;
    private List<Persona> suscriptores = new ArrayList<>();
    ArrayList<Mensaje> mensajes = new ArrayList<>();

    //Deberia haber un constructor que inicialize los atributos


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


    public void agregarSuscriptor(Persona suscriptor){
        suscriptores.add(suscriptor);
    }
    public void eliminarSuscriptor(Persona suscriptor){
        suscriptores.remove(suscriptor);
    }
}
