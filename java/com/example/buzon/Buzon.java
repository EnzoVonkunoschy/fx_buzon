import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Buzon {
    private List<Mensaje> mensajes;

    public Buzon() {
        mensajes = new ArrayList<>();
    }

    public void recibirMensaje(Mensaje mensaje) {
        mensajes.add(mensaje);
    }

    public boolean hayMensajes(String destinatario) {
        for (Mensaje mensaje : mensajes) {
            if (mensaje.getDestinatario().equals(destinatario)) {
                return true;
            }
        }
        return false;
    }

    public List<Mensaje> retirarMensajes(String destinatario) {
        List<Mensaje> mensajesRetirados = new ArrayList<>();
        Iterator<Mensaje> iterador = mensajes.iterator();

        while (iterador.hasNext()) {
            Mensaje mensaje = iterador.next();
            if (mensaje.getDestinatario().equals(destinatario)) {
                mensajesRetirados.add(mensaje);
                iterador.remove();
            }
        }

        return mensajesRetirados;
    }

    public void listarMensajes() {
        if (mensajes.isEmpty()) {
            System.out.println("No hay mensajes en el buzón.");
        } else {
            for (Mensaje mensaje : mensajes) {
                System.out.println(mensaje);
                System.out.println("-----------------------------");
            }
        }
}