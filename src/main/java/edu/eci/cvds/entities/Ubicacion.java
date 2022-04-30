package edu.eci.cvds.entities;

import java.io.Serializable;

public class Ubicacion implements Serializable {
    private String idubicacion;

    public Ubicacion(String idubicacion){
        this.idubicacion = idubicacion;
    }

    public String getIdubicacion() {
        return idubicacion;
    }

    public void setIdubicacion(String idubicacion) {
        this.idubicacion = idubicacion;
    }
}
