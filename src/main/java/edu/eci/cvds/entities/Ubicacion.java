package edu.eci.cvds.entities;

import java.io.Serializable;

public class Ubicacion implements Serializable {
    private int id;
    private String ubicacion;

    public Ubicacion(){}

    public Ubicacion(int id, String ubicacion) {
        this.id = id;
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
