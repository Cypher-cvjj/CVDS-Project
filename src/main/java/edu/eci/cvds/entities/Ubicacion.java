package edu.eci.cvds.entities;

public enum Ubicacion {
    BloqueG("Bloque G"),
    BiliotecaJorgeAlvarez("Biblioteca Jorge Alvarez"),
    BloqueB("Bloque B");

    private String label;

    Ubicacion(String item){
        this.label = item;
    }

    public String getLabel(){
        return this.label;
    }
}
