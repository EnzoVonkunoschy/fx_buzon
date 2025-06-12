package com.example.buzon;

import java.util.Objects;

public class Persona {
    private String nombre;
    private String cuit;

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
        return this.nombre + this.cuit;
    }


    //Agrego equals y hashCode para que el metodo eliminarsuscriptor(); en Buzon funcione correctamente
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre) && Objects.equals(cuit, persona.cuit);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre, cuit);
    }
}

