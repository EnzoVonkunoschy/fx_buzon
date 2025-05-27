package com.example.buzon;

public class Mensaje {
    String remitente;
    String emisor;
    String texto;

    public Mensaje( String remitente, String emisor, String texto){
        this.remitente= remitente;
        this.emisor= emisor;
        this.texto= texto;
    }

    public String getRemitente() {
        return remitente;
    }

    public String getEmisor() {
        return emisor;
    }

    public String getTexto() {
        return texto;
    }
    @Override
    public String toString(){
        return "Remitente: "+ remitente + "\n" + "Emisor: " + emisor + "\n"+ "Texto: "+ texto;
    }
}
