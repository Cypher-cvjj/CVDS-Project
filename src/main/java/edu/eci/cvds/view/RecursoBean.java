package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.entities.Ubicacion;
import edu.eci.cvds.services.ECILibraryServices;
import edu.eci.cvds.services.ECILibraryServicesFactory;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "RecursoBean")
@SessionScoped
public class RecursoBean extends BasePageBean {


    @Inject
    private ECILibraryServices eciLibraryServices;

    private String typeRecursore;
    private String ubicacion;
    private String time1;
    private String time2;
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


    public void registrarRecursos() throws ParseException {
        System.out.println("entro");
        System.out.println(ubicacion);
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(typeRecursore);

        try {
            DateFormat fechaHora = new SimpleDateFormat("HH:mm");
            java.util.Date time_1 = fechaHora.parse(time1);
            DateFormat fechaHora2 = new SimpleDateFormat("HH:mm");
            java.util.Date time_2 = fechaHora2.parse(time2);
            Recurso recurso = new Recurso(id,nombre, ubicacion,capacidad,time_1,time_2,disponibilidad,typeRecursore);
            eciLibraryServices.registrarRecursos(recurso);
            System.out.println("Recurso Agregado: "+ recurso.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ECILibraryServices getEciLibraryServices() {
        return this.eciLibraryServices;
    }

    public void cambiarEstadoRecurso (Recurso recurso){
        try {
            eciLibraryServices.cambiarEstadoRecurso(recurso);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setEciLibraryServices (ECILibraryServices eciLibraryServices){
            this.eciLibraryServices = eciLibraryServices;
    }


        public String getTypeRecursore () {
            return typeRecursore;
        }

        public void setTypeRecursore (String typeRecursore){
            this.typeRecursore = typeRecursore;
        }

        public String getUbicacion () {
            return ubicacion;
        }

        public void setUbicacion (String ubicacion){
            this.ubicacion = ubicacion;
        }


        public String getTime1 () {
            return time1;
        }

        public void setTime1 (String time1){
            this.time1 = time1;
        }

        public String getTime2 () {
            return time2;
        }

        public void setTime2 (String time2){
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