package com.example.buzon;

public class Persona {
    private String nombre;
    private String cuit;
    private boolean suscripto;

    public Persona(String nombre, String cuit){
        this.nombre = nombre;
        this.cuit = cuit;
        this.suscripto = false;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getCuit() {
        return this.cuit;
    }

    public boolean isSuscripto(){ return suscripto; }

    public void setSuscripto(boolean suscripto) {
        this.suscripto = suscripto;
    }

    public String toString(){
        return this.nombre + " " + this.cuit;
    }
}
