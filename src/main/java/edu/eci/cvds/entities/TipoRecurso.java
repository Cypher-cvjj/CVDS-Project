package edu.eci.cvds.entities;

import java.io.Serializable;

public class TipoRecurso implements Serializable {

    private String idtipo;

    public TipoRecurso(String idtipo){
        this.idtipo = idtipo;
    }

    public String getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(String idtipo) {
        this.idtipo = idtipo;
    }
}
