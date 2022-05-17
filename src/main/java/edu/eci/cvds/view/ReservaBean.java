package edu.eci.cvds.view;


import com.google.inject.Inject;
import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.services.ECILibraryServices;
import org.primefaces.model.DefaultScheduleModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.json.bind.annotation.JsonbProperty;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "ReservaBean")
@RequestScoped
public class ReservaBean extends BasePageBean {


    @Inject
    private ECILibraryServices eciLibraryServices;

    private int tiporeserva;
    private int idreserva;
    private String nombre;
    private Date fechainicialreserva;
    private Date fechafinalreserva;
    private Date fechasolicitud;
    private boolean estado;
    private int usuario;
    private int recurso;
    private DefaultScheduleModel eventModel;


    /**
     * Consulta la reserva de un recurso
     * @param id
     * @return
     * @throws BibliotecaException
     */
    public List<Reserva> consultarReserva(int id) throws BibliotecaException {
        List<Reserva> r = null;
        try {
            r = eciLibraryServices.consultarReservasRecurso(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    /**
     * consultar reserva por id
     * @param idReserva
     * @return
     */
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

    /**
     * Cancelar reserva
     * @param idReserva
     * @throws ParseException
     */
    public void CancelarReserva(int idReserva) throws ParseException{
        try{
            eciLibraryServices.CancelarReserva(idReserva);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * reservar un recurso
     * @throws BibliotecaException
     */
    public void addReserva(int idRecurso) throws BibliotecaException {
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println(idRecurso);
        System.out.println("----------------------------------------------------------------------------------------------------");
        Timestamp time2sql = new Timestamp(fechainicialreserva.getTime());
            Timestamp time1sql = new Timestamp(fechafinalreserva.getTime());
            Date datenow = new Date(System.currentTimeMillis());
            Timestamp time3sql = new Timestamp(datenow.getTime());
            try {
                Reserva r = new Reserva();
                r.setId_reserva(idreserva);
                r.setNombre(nombre);
                r.setFechasoli(time3sql);
                r.setFechaini(time2sql);
                r.setFechafin(time1sql);
                r.setEstado(true);
                r.setTiporeserva(new TipoReserva(tiporeserva, ""));
                r.setUsuario(new User());
                r.setRecurso(new Recurso(idRecurso));
                eciLibraryServices.reservarRecurso(r);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int getTiporeserva() {
        return tiporeserva;
    }

    public void setTiporeserva(int tiporeserva) {
        this.tiporeserva = tiporeserva;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechainicialreserva() {
        return fechainicialreserva;
    }

    public void setFechainicialreserva(Date fechainicialreserva) {
        this.fechainicialreserva = fechainicialreserva;
    }

    public Date getFechafinalreserva() {
        return fechafinalreserva;
    }

    public void setFechafinalreserva(Date fechafinalreserva) {
        this.fechafinalreserva = fechafinalreserva;
    }

    public Date getFechasolicitud() {
        return fechasolicitud;
    }

    public void setFechasolicitud(Date fechasolicitud) {
        this.fechasolicitud = fechasolicitud;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getRecurso() {
        return recurso;
    }

    public void setRecurso(int recurso) {
        this.recurso = recurso;
    }
}
