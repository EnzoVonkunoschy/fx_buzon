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

    @Override
    public String toString() {
        return "Remitente= " + remitente + ", Destinatario= " + destinatario + ", Texto= " + texto;
    }
}