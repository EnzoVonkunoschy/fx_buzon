package com.example.buzon;

import java.util.ArrayList;

public class Buzon {
    ArrayList<Mensaje> mensajes = new ArrayList<>();


    public boolean hayMensajes(String destinatario){
        for (Mensaje mensajes : mensajes){
            if (mensajes.getDestinatario().equals(destinatario)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Mensaje> retirarMensajes(String destinatario){
        ArrayList<Mensaje> mensajesARetirar = new ArrayList<>();
        for (Mensaje mensajes : mensajes){
            if (mensajes.getDestinatario().equals(destinatario)){
                mensajesARetirar.add(mensajes);
            }
        }
        return mensajesARetirar;
    }

    public void recibirMensaje(Mensaje mensaje){
        mensajes.add(mensaje);
    }

    public void listarMensajes(){
        for (Mensaje mensajes : mensajes){
            System.out.println(mensajes);
        }
    }
}
