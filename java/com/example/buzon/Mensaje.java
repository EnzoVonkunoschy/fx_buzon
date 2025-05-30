package com.example.buzon;

public class Mensaje {
    private String remitente;
    private String destinatario;
    private String texto;

    public Mensaje(String remitente, String destinatario, String texto) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.texto = texto;
    }

    public String getRemitente() {
        return remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        return "Remitente: " + remitente + "\n" +
                "Destinatario: " + destinatario + "\n" +
                "Texto: " + texto;
    }
}