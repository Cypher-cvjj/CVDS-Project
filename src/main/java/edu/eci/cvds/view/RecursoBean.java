package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.entities.Ubicacion;
import edu.eci.cvds.services.ECILibraryServices;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "RecursoBean")
@RequestScoped
public class RecursoBean extends BasePageBean {


    @Inject
    private ECILibraryServices eciLibraryServices;

    private int typeRecursore;
    private int ubicacion;
    private Date time1;
    private Date time2;
    private int id;
    private String nombre;
    private int capacidad;
    private Boolean disponibilidad;

    private List<SelectItem> listaUbicaciones;
    private List<SelectItem> listaTipoRecursos;




    /**
     * consultar los recursos de la biblioteca
     *
     * @return lista de recursos
     * @throws BibliotecaException
     */
    public List<Recurso> consultarRecursos() throws BibliotecaException {
        List<Recurso> recursos = new ArrayList<>();
        try {
            recursos = eciLibraryServices.consultarRecursos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recursos;
    }

    /**
     * reistrar un recurso si es administrador
     * @throws ParseException
     */
    public void registrarRecursos() throws ParseException {
        System.out.println("entro");
        System.out.println(ubicacion);
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(typeRecursore);
        java.sql.Date time2sql = new java.sql.Date(time2.getTime());
        java.sql.Date time1sql = new java.sql.Date(time1.getTime());

        try {
            Recurso r = new Recurso();
            r.setId(id);
            r.setNombre(nombre);
            //Ubicacion u = eciLibraryServices.getubicacion(ubicacion);
            //r.setUbicacion(u);
            r.setUbicacion(new Ubicacion(ubicacion,""));
            r.setCapacidad(capacidad);
            r.setHorario_inicial(time1sql);
            r.setHorario_final(time2sql);
            r.setDisponibilidad(disponibilidad);
            r.setTiporecurso(new TipoRecurso(typeRecursore,""));
            eciLibraryServices.registrarRecursos(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ECILibraryServices getEciLibraryServices() {
        return this.eciLibraryServices;
    }

    public void cambiarEstadoRecurso (Recurso recurso){
        try {
            recurso.setDisponibilidad(!recurso.getDisponibilidad());
            eciLibraryServices.cambiarEstadoRecurso(recurso);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setEciLibraryServices (ECILibraryServices eciLibraryServices){
            this.eciLibraryServices = eciLibraryServices;
    }


        public int getTypeRecursore () {
            return typeRecursore;
        }

        public void setTypeRecursore (int typeRecursore){
            this.typeRecursore = typeRecursore;
        }

        public int getUbicacion () {
            return ubicacion;
        }

        public void setUbicacion (int ubicacion){
            this.ubicacion = ubicacion;
        }


        public Date getTime1 () {
            return time1;
        }

        public void setTime1 (Date time1){
            this.time1 = time1;
        }

        public Date getTime2 () {
            return time2;
        }

        public void setTime2 (Date time2){
            this.time2 = time2;
        }

        public List<SelectItem> getListaUbicaciones () {
            return listaUbicaciones;
        }

        public void setListaUbicaciones (List < SelectItem > listaUbicaciones) {
            this.listaUbicaciones = listaUbicaciones;
        }

        public List<SelectItem> getListaTipoRecursos () {
            return listaTipoRecursos;
        }

        public void setListaTipoRecursos (List < SelectItem > listaTipoRecursos) {
            this.listaTipoRecursos = listaTipoRecursos;
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

    public void setNombre(String nombres) {
        this.nombre = nombres;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}