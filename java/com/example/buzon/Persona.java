package com.example.buzon;

public class Persona {
    private String nombre;
    private String cuit;
    private boolean subActivo = false;


    public Persona(String nombre, String cuit){
        this.nombre = nombre;
        this.cuit = cuit;
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

    public boolean isSubActivo() {
        return subActivo;
    }

    public void subActivo(boolean subActivo) {
        this.subActivo = subActivo;
    }
}

