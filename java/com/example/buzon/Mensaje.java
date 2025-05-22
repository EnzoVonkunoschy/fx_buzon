package com.example.buzon;

public class Mensaje {
    private String remitente;
    private String destinatario;
    private String mensaje;

    public Mensaje(String remitente, String destinatario, String mensaje) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Mensaje [remitente=" + remitente + ", destinatario=" + destinatario + ", mensaje=" + mensaje + "]";
    }
}
