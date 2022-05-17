package edu.eci.cvds.entities;


import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Timestamp;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.time.LocalTime.NOON;

/**
 * clase que representa un recurso
 */
public class Recurso implements Serializable {

    private int id;
    private String nombre;
    private Ubicacion ubicacion;
    private int capacidad;

    private Timestamp horario_inicial;
    private Timestamp horaini;
    private Timestamp horafin;
    private Timestamp horario_final;
    private boolean disponibilidad;
    private TipoRecurso tiporecurso;



    public Recurso(){super();}

    public Recurso(int id){this.id=id;}

    public Recurso(int id, String nombre, Ubicacion ubicacion, int capacidad, Timestamp horario_inicial, Timestamp horario_final,boolean disponibilidad,TipoRecurso tiporecurso){
        this.id = id;
        this.nombre = nombre;
        this.ubicacion=ubicacion;
        this.capacidad = capacidad;
        this.horario_inicial=horario_inicial;
        this.horario_final=horario_final;
        this.disponibilidad=disponibilidad;
        this.tiporecurso=tiporecurso;

    }



    @Override
    public String toString() {
        return "Recurso{" + " id= " + id + " nombre= " + nombre + " ubicacion= " + ubicacion.getUbicacion() + " capacidad= "+ capacidad + " Hora_inicial= " + horario_inicial + " Hora_final= " + horario_final + " disponibilidad= " + disponibilidad + " tipo= " + tiporecurso.getTipo() + "}";
    }

    public String getHoraini(){
        Date temp = new Date();
        temp.setTime(horario_inicial.getTime());
        String formattedDate = new SimpleDateFormat("HH:mm").format(temp);
        return formattedDate;

    }

    public String getHorafin(){
        Date temp = new Date();
        temp.setTime(horario_final.getTime());
        String formattedDate = new SimpleDateFormat("HH:mm").format(temp);
        return formattedDate;

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

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public LocalDateTime getHorario_inicial() {return  horario_inicial.toLocalDateTime();}

    public void setHorario_inicial(Timestamp horario_inicial) {
        this.horario_inicial = horario_inicial;
    }

    public LocalDateTime getHorario_final() {return  horario_final.toLocalDateTime();}

    public void setHorario_final(Timestamp horario_final) {
        this.horario_final = horario_final;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean nuevoDisponibilidad) {
        this.disponibilidad = nuevoDisponibilidad;
    }

    public TipoRecurso getTiporecurso() {
        return tiporecurso;
    }

    public void setTiporecurso(TipoRecurso tiporecurso) {
        this.tiporecurso = tiporecurso;
    }

}