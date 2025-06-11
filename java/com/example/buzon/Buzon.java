package com.example.buzon;

import java.util.ArrayList;

public class Buzon {
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
        mensajes.add(mensaje);
    }

    public void listarMensajes(){
        for (Mensaje mensaje : mensajes){
            System.out.println(mensaje);
        }
    }
}
