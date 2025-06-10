package com.example.buzon;

public class Mensaje {
    private Persona remitente;
    private Persona destinatario;
    private String texto;

    public Mensaje(Persona remitente, Persona destinatario, String texto) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.texto = texto;
    }

    public Persona getDestinatario(){
        return this.destinatario;
    }

    public Persona getRemitente(){
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
