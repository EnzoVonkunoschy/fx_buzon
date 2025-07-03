package com.example.buzon;

import java.util.ArrayList;

public class Buzon {
    ArrayList<Persona> suscriptores = new ArrayList<>();
    ArrayList<Mensaje> mensajes = new ArrayList<>();
    private Buzon siguienteBuzon; // ✅ Nuevo atributo

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
        for (Mensaje mensaje : mensajes) {
            if (mensaje.getDestinatario().equals(destinatario)) {
                mensajesARetirar.add(mensaje);
            }
        }
        return mensajesARetirar;
    }

    public void recibirMensaje(Mensaje mensaje) {
        if (suscriptores.contains(mensaje.getDestinatario())) {
            mensajes.add(mensaje);
            System.out.println("Mensaje añadido en este buzón: persona suscripta");
        } else if (siguienteBuzon != null) {
            System.out.println("Destinatario no suscripto en este buzón. Pasando al siguiente buzón...");
            siguienteBuzon.recibirMensaje(mensaje);
        } else {
            System.out.println("Mensaje no añadido: persona no suscripta y no hay siguiente buzón.");
        }
    }


    public void listarMensajes() {
        for (Mensaje mensaje : mensajes) {
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

    public void setSiguienteBuzon(Buzon buzon) {
        this.siguienteBuzon = buzon;
        System.out.println("Siguiente buzón definido correctamente.");
    }

    public Buzon getSiguienteBuzon() {
        return siguienteBuzon;
    }
}

