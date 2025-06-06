package com.example.buzon;

public class Persona {
    private String nombre;
    private String cuit;

   public Persona(String nombre, String cuit){
      this.nombre = nombre;
      this.cuit = cuit;
   }

    public String getNombre() {
        return nombre;
    }

    public String getCuit() {
        return cuit;
    }

    @Override
    public String toString() {
       return nombre + " (CUIT: " + cuit + ")";
    }
}
