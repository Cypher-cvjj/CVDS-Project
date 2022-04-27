package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.entities.Ubicacion;
import edu.eci.cvds.services.ECILibraryServices;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "RecursoBean")
@RequestScoped
public class RecursoBean extends BasePageBean {

    @Inject
    private ECILibraryServices eciLibraryServices;

    private TipoRecurso typeRecursore;
    private Ubicacion ubicacion;
    private int id;
    private Date time1;
    private Date time2;

    private List<SelectItem> listaUbicaciones;
    private List<SelectItem> listaTipoRecursos;

    @PostConstruct
    public void init(){
        //
        listaUbicaciones = new ArrayList<SelectItem>();
        int j=0;
        for(Ubicacion u: Ubicacion.values()) {
            if(j<Ubicacion.values().length) {
                listaUbicaciones.add(new SelectItem(u, u.getLabel()));
                j += 1;
            }
        }
        //
        listaTipoRecursos = new ArrayList<SelectItem>();
        int i=0;
        for(TipoRecurso r: TipoRecurso.values()) {
            if(i<TipoRecurso.values().length) {
                listaTipoRecursos.add(new SelectItem(r, r.getLabel()));
                i += 1;
            }
        }

        time1= new Date();
        time2 = new Date();
    }
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


    public void registrarRecursos(int id,String nombre,int capacidad,boolean disponiblidad) {
        try {
            eciLibraryServices.registrarRecursos(new Recurso(id,nombre,ubicacion,capacidad, time1, time2,disponiblidad,typeRecursore));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO , "registro exitoso", null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ECILibraryServices getEciLibraryServices() {
        return eciLibraryServices;
    }

        public void cambiarEstadoRecurso (Recurso recurso){
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }



        public void setEciLibraryServices (ECILibraryServices eciLibraryServices){
            this.eciLibraryServices = eciLibraryServices;
        }


        public TipoRecurso getTypeRecursore () {
            return typeRecursore;
        }

        public void setTypeRecursore (TipoRecurso typeRecursore){
            this.typeRecursore = typeRecursore;
        }

        public Ubicacion getUbicacion () {
            return ubicacion;
        }

        public void setUbicacion (Ubicacion ubicacion){
            this.ubicacion = ubicacion;
        }

        public int getId () {
            return id;
        }

        public void setId ( int id){
            this.id = id;
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
    }