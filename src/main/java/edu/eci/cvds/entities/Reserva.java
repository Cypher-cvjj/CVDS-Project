package edu.eci.cvds.entities;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class Reserva implements  Serializable{

    private int id_reserva;
    private String nombre;
    private int recurso;
    private Date fechasoli;
    private Date fechaini;
    private Date fechafin;

    public Reserva(){super();}

    public Reserva(int id_reserva, String nombre, int recurso, Date fechasoli, Date fechaini, Date fechafin){
        this.id_reserva = id_reserva;
        this.nombre = nombre;
        this.recurso = recurso;
        this.fechasoli = fechasoli;
        this.fechaini = fechaini;
        this.fechafin = fechafin;
    }

    @Override
    public String toString(){
        return "Reserva{" + "id=" + id_reserva + " nombre= " + nombre + " recurso= " + recurso + " fechaSoli= "+ fechasoli +  " fecha = " + fechaini + " fechaFinal= " + fechafin + "}";
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRecurso(int recurso) {
        this.recurso = recurso;
    }

    public void setFechasoli(Date fechasoli) {
        this.fechasoli = fechasoli;
    }

    public void setFechaini(Date fechaini) {
        this.fechaini = fechaini;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public String getNombre(){
        return nombre;
    }

    public int getRecurso() {
        return recurso;
    }

    public Date getFechasoli() {
        return fechasoli;
    }

    public Date getFechaini() {
        return fechaini;
    }

    public Date getFechafin() {
        return fechafin;
    }
}
