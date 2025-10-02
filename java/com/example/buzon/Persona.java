package com.example.buzon;

public class Persona {
    private String nombre;
    private String cuit;
    private boolean suscrito;

    public Persona(String nombre, String cuit,boolean suscrito){
        this.nombre = nombre;
        this.cuit = cuit;
        this.suscrito=suscrito;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getCuit() {
        return this.cuit;
    }
    public boolean getSuscrito(){return this.suscrito;}

    public void setSuscribido(boolean suscribido){
        this.suscrito=suscribido;
    }
    public String toString(){
        return this.nombre + " " + this.cuit+ " " + this.suscrito;
    }
}

