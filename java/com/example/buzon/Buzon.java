package com.example.buzon;

import java.util.ArrayList;

public class Buzon {
    ArrayList<Mensaje> mensajes = new ArrayList<>();
    ArrayList<Persona> suscriptores = new ArrayList<>();

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
        if (suscriptores.contains(mensaje.getDestinatario())){
            mensajes.add(mensaje);
        }else{
            System.out.println("no suscripto");
        }
    }

    public void listarMensajes(){
        for (Mensaje mensaje : mensajes){
            System.out.println(mensaje);
        }
    }
    public void agregarSuscriptores(Persona suscriptor){
        suscriptores.add(suscriptor);
    }

    public void mostrarSuscritores() {
        for (Persona persona : suscriptores) {
            System.out.println("Nombre: " + persona.getNombre() + ", Cuit: " + persona.getCuit());
        }

    }
}
