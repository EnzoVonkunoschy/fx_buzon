package com.example.buzon;

public class Persona {
    private String nombre;
    private String cuit;
    private Buzon BuzonUnico = null;
    // Atributo creado para verificar si una persona esta vinculada a mas de un buzon
    // Le puse "null" porque al principio no tiene ningun buzon asignado

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

    public Buzon getBuzonUnico(){
        return BuzonUnico;
    }

    public void setBuzonUnico(Buzon buzon) {
        this.BuzonUnico = buzon;
    }
}

