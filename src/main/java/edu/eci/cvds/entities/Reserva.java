package edu.eci.cvds.entities;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class Reserva implements Serializable{

    private int id_reserva;
    private String nombre;
    private Date fechasoli;
    private Date fechaini;
    private Date fechafin;
    private boolean estado;
    private User usuario;
    private Recurso recurso;
    private TipoReserva tiporeserva;

    public Reserva() {super(); }

    public Reserva(int id_reserva, String nombre, Date fechasoli, Date fechaini, Date fechafin, boolean estado,  User usuario, Recurso recurso, TipoReserva tiporeserva) {
        this.id_reserva = id_reserva;
        this.nombre = nombre;
        this.fechasoli = fechasoli;
        this.fechaini = fechaini;
        this.fechafin = fechafin;
        this.estado = estado;
        this.usuario = usuario;
        this.recurso = recurso;
        this.tiporeserva = tiporeserva;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechasoli() {
        return fechasoli;
    }

    public void setFechasoli(Date fechasoli) {
        this.fechasoli = fechasoli;
    }

    public Date getFechaini() {
        return fechaini;
    }

    public void setFechaini(Date fechaini) {
        this.fechaini = fechaini;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public TipoReserva getTiporeserva() {
        return tiporeserva;
    }

    public void setTiporeserva(TipoReserva tiporeserva) {
        this.tiporeserva = tiporeserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id_reserva=" + id_reserva +
                ", nombre='" + nombre + '\'' +
                ", fechasoli=" + fechasoli +
                ", fechaini=" + fechaini +
                ", fechafin=" + fechafin +
                ", usuario=" + usuario +
                ", recurso=" + recurso +
                ", tiporeserva=" + tiporeserva +
                '}';
    }
}
