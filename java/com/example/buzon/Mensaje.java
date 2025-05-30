package com.example.buzon;

public class Mensaje {
    String remitente;
    String destinatario;
    String texto;

    public Mensaje( String remitente, String emisor, String texto){
        this.remitente= remitente;
        this.destinatario= emisor;
        this.texto= texto;
    }
    @Override
    public String toString(){
        return "Remitente: "+ remitente + "\n" + "Destinatario: " + destinatario + "\n"+ "Texto: "+ texto;
    }
}
