package com.example.buzon;

import java.util.ArrayList;
import java.util.Iterator;

public class Buzon {
    ArrayList<Persona> suscriptores = new ArrayList<>();
    ArrayList<Mensaje> mensajes = new ArrayList<>();
    private Buzon siguienteBuzon; // ✅ Nuevo atributo
    private static int totalBuzones = 0; //contadoor de buzones
    private static final Persona acuseRecibo = new Persona("ADMINISTRACION DE CORREO", "-");

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
            //llamamos al metodo emitirconfirmacion
            if (mensaje.getRemitente() != acuseRecibo){
                String textoConfirmacion = "CONFIRMACIÓN: Su mensaje para "+
                                            mensaje.getDestinatario().getNombre() +
                                            " ha sido entregado EXITOSAMENTE. ";
                this.enviarAcuseRemitente(mensaje, textoConfirmacion);
            }
        } else if (siguienteBuzon != null && mensaje.getContadorBuzones() < Buzon.getTotalBuzones()) {
            mensaje.incrementarContador(); // se suma en el contador
            System.out.println("Destinatario no suscripto en este buzón. Pasando al siguiente buzón...");
            siguienteBuzon.recibirMensaje(mensaje);
        } else {
            System.out.println("Mensaje no añadido: se alcanzó el límite de buzones o no hay siguiente.");
            if (mensaje.getRemitente() != acuseRecibo) {
                String textoFallo = "FALLO DE ENTREGA: Mensaje para :" + mensaje.getDestinatario().getNombre() +
                                     " no pudo ser entregado.";
                this.enviarAcuseRemitente(mensaje, textoFallo);
            }
        }
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

    public Buzon buscarBuzonDePersona( Persona p){
        if (suscriptores.contains(p)) {
            return this;
        }

        if (siguienteBuzon != null) {
            return siguienteBuzon.buscarBuzonDePersona(p);
        }
        return null;
    }
    
    private void enviarAcuseRemitente(Mensaje mensajeOriginal, String textoAcuse) {
        Persona remitenteOriginal = mensajeOriginal.getRemitente();// obtenemos la persona remmitente

        if (remitenteOriginal == null) {
            System.out.println( "No se puede enviar confirmación de Mensaje, no tiene remitente");
            return;
        }

        // el remitente del nuevo mensaje
        // el destinatario del mensaje de notificacion
        Mensaje acuse = new Mensaje(
                acuseRecibo, //sistema de acuse
                remitenteOriginal,// destinatario de confirmacion
                textoAcuse// texto
        );

        Buzon buzonRemitente = this.buscarBuzonDePersona(remitenteOriginal);

        if (buzonRemitente != null) {
            buzonRemitente.recibirMensaje(acuse);
        } else  {
            System.out.println( "Error no se puede encotrar el buzon del remitente: "+remitenteOriginal.getNombre());
        }
    }

    public Buzon getSiguienteBuzon() {
        return siguienteBuzon;
    }
}