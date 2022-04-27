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
    private Ubicacion ubicacion;
    private int capacidad;
<<<<<<< HEAD
    private Date horario_inicial;
    private Date horario_final;
    private boolean disponibilidad;
    private TipoRecurso tiporecurso;
=======
    private Time horario_inicial;
    private Time horario_final;
    private String disponibilidad;
    private String tiporecurso;
>>>>>>> ad099caa1d32ee0259aea30f18cbaa92f70eaa5c

    public Recurso(){
        this.ubicacion = Ubicacion.BloqueG;
        this.nombre = "";
        this.disponibilidad = true;
    }

    public Recurso(int id, String nombre, Ubicacion ubicacion, int capacidad, Date horario_inicial, Date horario_final,boolean disponibilidad,TipoRecurso tiporecurso){
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

    public String getNombre(){
        return nombre;
    }




    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

<<<<<<< HEAD

    public Date getHorario_inicial(){
=======
    public Time getHorario_inicial(){
>>>>>>> ad099caa1d32ee0259aea30f18cbaa92f70eaa5c
        return horario_inicial;
    }

    public Date getHorario_final(){
        return horario_final;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


<<<<<<< HEAD

=======
>>>>>>> ad099caa1d32ee0259aea30f18cbaa92f70eaa5c
    public void setHorario_inicial(Time horario_inicial) {
        this.horario_inicial = horario_inicial;
    }

    public void setHorario_final(Time horario_final) {
        this.horario_final = horario_final;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public TipoRecurso getTiporecurso() {
        return tiporecurso;
    }

    public void setTiporecurso(TipoRecurso tiporecurso) {
        this.tiporecurso = tiporecurso;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }
}