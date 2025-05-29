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
    public Mensaje() {
    }

    @Override
    public String toString() {
        return this.remitente +" "+ this.destinatario +" "+ this.texto;
    }
}

