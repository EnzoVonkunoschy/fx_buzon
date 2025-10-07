package com.example.buzon;

public class Persona {
    private String nombre;
    private String cuit;
    private Buzon buzon;

    public Persona(String nombre, String cuit){
        this.nombre = nombre;
        this.cuit = cuit;
    }


    public Buzon getBuzon() {
        return this.buzon;
    }

    public void setBuzon(Buzon buzon) {
        this.buzon = buzon;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getCuit() {
        return this.cuit;
    }

    public String toString(){
        return this.nombre + " " + this.cuit;
    }
}

