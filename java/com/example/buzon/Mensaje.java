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

    public String getDestinatario(){
        return this.destinatario;
    }

    public String getRemitente(){
        return this.remitente;
    }

    public String getTexto() {
        return this.texto;
    }

    @Override
    public String toString() {
        return "Remitente= " + remitente + ", Destinatario= " + destinatario + ", Texto= " + texto + "\n";
    }
}