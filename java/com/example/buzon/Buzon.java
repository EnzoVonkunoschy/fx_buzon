package com.example.buzon;

import java.util.ArrayList;
import java.util.Iterator;

public class Buzon {
    ArrayList<Persona> suscriptores = new ArrayList<>();
    ArrayList<Mensaje> mensajes = new ArrayList<>();
    private Buzon siguienteBuzon; // ✅ Nuevo atributo
    private static int totalBuzones = 0; //contadoor de buzones
    final Persona NoReply = new Persona("NoReply", null);

    public Buzon() {
        totalBuzones++; // cada vez que se crea un buzón se incrementa
    }

    public static int getTotalBuzones() {
        return totalBuzones;
    }
    public boolean hayMensajes(Persona destinatario) {
        for (Mensaje mensaje : mensajes) {
            if (mensaje.getDestinatario().equals(destinatario)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Mensaje> retirarMensajes(Persona destinatario) {
        ArrayList<Mensaje> mensajesARetirar = new ArrayList<>();
        // for (Mensaje mensaje : mensajes) {
        //     if (mensaje.getDestinatario().equals(destinatario)) {
        //         mensajesARetirar.add(mensaje);
        //     }
        // }
        Iterator<Mensaje> iterador = mensajes.iterator();
        while (iterador.hasNext()) {
            Mensaje mensaje = iterador.next();
            if (mensaje.getDestinatario().equals(destinatario)) {
                mensajesARetirar.add(mensaje);// agrega el mensaje a la lista retorno
                iterador.remove();//eliminamos de la lista
            }
        }
        return mensajesARetirar;
    }

    public void recibirMensaje(Mensaje mensaje) {
        if (suscriptores.contains(mensaje.getDestinatario())) {
            mensajes.add(mensaje);
            System.out.println("Mensaje añadido en este buzón: persona suscripta");
            crearNoReply(mensaje);
        } else if (siguienteBuzon != null && mensaje.getContadorBuzones() < Buzon.getTotalBuzones()) {
            mensaje.incrementarContador(); // se suma en el contador
            System.out.println("Destinatario no suscripto en este buzón. Pasando al siguiente buzón...");
            siguienteBuzon.recibirMensaje(mensaje);
        } else {
            System.out.println("Mensaje no añadido: se alcanzó el límite de buzones o no hay siguiente.");
          }
    }

    public void recibirNoReply(Mensaje mensaje){
        if (suscriptores.contains(mensaje.getDestinatario())) {
            mensajes.add(mensaje);
        } else if (siguienteBuzon != null && mensaje.getContadorBuzones() < Buzon.getTotalBuzones()) {
            mensaje.incrementarContador(); // se suma en el contador
            siguienteBuzon.recibirNoReply(mensaje);
        }
    }

    private void crearNoReply(Mensaje mensaje){
        Mensaje noreply = new Mensaje(NoReply, mensaje.getRemitente(), "Mensaje para " + mensaje.getDestinatario() + " fue entregado");
        recibirNoReply(noreply);
    }


    public void listarMensajes() {
        System.out.println("Mensajes:");
        for (Mensaje mensaje : mensajes) {
            System.out.println(mensaje);
        }
        System.out.println("----------------------------");
    }

    public void agregarSuscriptor(Persona persona) {
        if (persona.getSuscripto()) {
            System.out.println(persona.getNombre() + " ya está suscripto.");
        } else {
            suscriptores.add(persona);
            persona.setSuscripto(true);
            System.out.println(persona.getNombre() + " fue agregado como suscriptor.");
        }
    }

    public void eliminarSuscriptor(Persona persona) {
        if(suscriptores.remove(persona)) {
            persona.setSuscripto(false);
            System.out.println(persona + " fue eliminado como suscriptor");
        }
    }

    public void listarSuscriptores() {
        System.out.println("Suscriptores:");
        for (Persona p : suscriptores) {
            System.out.println(p);
        }
    }

    public void ignorarMensaje(Mensaje mensaje) {
        System.out.println("Mensaje de " + mensaje.getRemitente().getNombre() +
                " a " + mensaje.getDestinatario().getNombre() + " fue ignorado.");
    }

    public void setSiguienteBuzon(Buzon buzon) {
        this.siguienteBuzon = buzon;
        System.out.println("Siguiente buzón definido correctamente.");
    }

    public Buzon getSiguienteBuzon() {
        return siguienteBuzon;
    }
}