package edu.eci.cvds.view;


import com.google.inject.Inject;
import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.services.ECILibraryServices;
import org.primefaces.model.DefaultScheduleModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "ReservaBean")
@RequestScoped
public class ReservaBean extends BasePageBean {


    @Inject
    private ECILibraryServices eciLibraryServices;

    private int id_recurso;
    private String nombre_recurso;
    private LocalDateTime fechainicialreserva;
    private LocalDateTime fechafinalreserva;
    private DefaultScheduleModel eventModel;


    public List<Reserva> consultarReserva(int id) throws BibliotecaException {
        List<Reserva> r = null;
        try {
            r = eciLibraryServices.consultarReservasRecurso(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public Reserva consultarReservaid(int idReserva) {
        System.out.println("entro bean");
        Reserva reserva = null;
        try{
            reserva = eciLibraryServices.consultarReserva(idReserva);
        }catch (Exception e){
            e.printStackTrace();
        }
        return reserva;
    }


    public LocalDateTime getFechainicialreserva() {
        return fechainicialreserva;
    }

    public LocalDateTime getFechafinalreserva() {
        return fechafinalreserva;
    }

    public void setFechainicialreserva(LocalDateTime fechainicialreserva) {
        this.fechainicialreserva = fechainicialreserva;
        System.out.println(fechainicialreserva);
    }

    public void setFechafinalreserva(LocalDateTime fechafinalreserva) {
        this.fechafinalreserva = fechafinalreserva;
        System.out.println(fechafinalreserva);
    }

    public ECILibraryServices getEciLibraryServices() {
        return eciLibraryServices;
    }

    public int getId_recurso() {
        return id_recurso;
    }

    public void setEciLibraryServices(ECILibraryServices eciLibraryServices) {
        this.eciLibraryServices = eciLibraryServices;
    }

    public void setId_recurso(int id_recurso) {
        this.id_recurso = id_recurso;
    }

    public void setNombre_recurso(String nombre_recurso) {
        this.nombre_recurso = nombre_recurso;
    }

    public String getNombre_recurso() {
        return nombre_recurso;
    }


}
