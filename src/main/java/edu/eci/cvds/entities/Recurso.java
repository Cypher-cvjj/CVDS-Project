package edu.eci.cvds.entities;


import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

/**
 * clase que representa un recurso
 */
public class Recurso implements Serializable {

    private int id;
    private String nombre;
    private String ubicacion;
    private int capacidad;

    private Date horario_inicial;
    private Date horario_final;
    private boolean disponibilidad;
    private String tiporecurso;



    public Recurso(){super();}


    public Recurso(int id, String nombre, String ubicacion, int capacidad, Date horario_inicial, Date horario_final,boolean disponibilidad,String tiporecurso){
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.horario_inicial=horario_inicial;
        this.horario_final=horario_final;
        this.disponibilidad=disponibilidad;
        this.tiporecurso=tiporecurso;

    }

    @Override
    public String toString() {
        return "Recurso{" + " id= " + id + " nombre= " + nombre + " ubicacion= " + ubicacion + " capacidad= "+ capacidad + " Hora_inicial= " + horario_inicial + " Hora_final= " + horario_final + " disponibilidad= " + disponibilidad + " tipo= " + tiporecurso + "}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Date getHorario_inicial() {
        return horario_inicial;
    }

    public void setHorario_inicial(Date horario_inicial) {
        this.horario_inicial = horario_inicial;
    }

    public Date getHorario_final() {
        return horario_final;
    }

    public void setHorario_final(Date horario_final) {
        this.horario_final = horario_final;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getTiporecurso() {
        return tiporecurso;
    }

    public void setTiporecurso(String tiporecurso) {
        this.tiporecurso = tiporecurso;
    }
}