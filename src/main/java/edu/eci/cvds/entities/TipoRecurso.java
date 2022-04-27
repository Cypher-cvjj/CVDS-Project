package edu.eci.cvds.entities;

public enum TipoRecurso {
    Equipodecomputo("Equipo de computo"),
    Saladeestudio("Sala de Estudio"),
    Equiposdemultimedia("Equipos de multimedia");

    private String label;

    TipoRecurso(String item){
        this.label = item;
    }

    public String getLabel(){
        return this.label;
    }
}
