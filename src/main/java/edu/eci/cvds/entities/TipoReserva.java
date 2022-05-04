package edu.eci.cvds.entities;

import java.io.Serializable;

public class TipoReserva implements Serializable {
    private int id;
    private String tipore;

    public TipoReserva(){}

    public TipoReserva(int id, String tipo) {
        this.id = id;
        this.tipore = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipore;
    }

    public void setTipo(String tipo) {
        this.tipore = tipo;
    }
}
