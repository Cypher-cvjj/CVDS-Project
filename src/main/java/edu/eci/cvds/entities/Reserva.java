package edu.eci.cvds.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Reserva implements Serializable{

    private int id_reserva;
    private String nombre;
    private Timestamp fechasoli;
    private Timestamp fechaini;
    private Timestamp fechafin;
    private boolean estado;
    private User usuario;
    private Recurso recurso;
    private TipoReserva tiporeserva;

    public Reserva() {super(); }

    public Reserva(int id_reserva, String nombre, Timestamp fechasoli, Timestamp fechaini, Timestamp fechafin, boolean estado,  User usuario, Recurso recurso, TipoReserva tiporeserva) {
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

    public LocalDateTime getFechasoli() {
        return fechasoli.toLocalDateTime();
    }

    public void setFechasoli(Timestamp fechasoli) {
        this.fechasoli = fechasoli;
    }

    public LocalDateTime getFechaini() {
        return fechaini.toLocalDateTime();
    }

    public void setFechaini(Timestamp fechaini) {
        this.fechaini = fechaini;
    }

    public LocalDateTime getFechafin() {
        return fechafin.toLocalDateTime();
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setFechafin(Timestamp fechafin) {
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
                ", estado= " + estado +
                ", usuario=" + usuario +
                ", recurso=" + recurso.getId() +
                ", tiporeserva=" + tiporeserva +
                '}';
    }
}
