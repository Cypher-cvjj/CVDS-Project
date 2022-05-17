package edu.eci.cvds.view;

import java.io.IOException;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;
import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.services.ECILibraryServices;
import edu.eci.cvds.services.impl.ECILibraryServicesImpl;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

@ManagedBean(name = "scheduleView")
@SessionScoped
public class ScheduleView extends BasePageBean {

    @Inject
    private ECILibraryServices eciLibraryServices;

    private int idRecurso;
    private ScheduleModel eventModel;
    private ScheduleEvent<?> event = new DefaultScheduleEvent<>();
    private LocalDateTime fechaini ;
    private LocalDateTime fechafin;
    private int idReserva;
    private Reserva r;

    public void inicializar(int id) throws IOException{
        this.idRecurso = id;
        eventModel = new DefaultScheduleModel();
        loadEventos();
        FacesContext.getCurrentInstance().getExternalContext().redirect("./CVDS.Project/horarios.xhtml");
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    private void loadEventos() {
        try {
            List<Reserva> reservas = eciLibraryServices.consultarReservasRecurso(idRecurso);
            LocalDateTime hoy = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
            for (Reserva reserva : reservas) {
                this.fechaini = reserva.getFechaini();
                this.fechafin = reserva.getFechafin();
                this.idReserva = reserva.getId_reserva();
                this.r = reserva;
//                this.idRecurso = reserva.getRecurso().getId();
                if (fechafin.isAfter(hoy)) {
                    DefaultScheduleEvent<?> event1 = DefaultScheduleEvent.builder()
                            .title("prueba")
                            .startDate(fechaini)
                            .endDate(fechafin)
                            .borderColor("blue")
                            .overlapAllowed(true)
                            .build();
                    eventModel.addEvent(event1);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void onEventSelect(SelectEvent selectEvent) {
        this.event = (ScheduleEvent<?>) selectEvent.getObject();
    }

    public void onDateSelect(SelectEvent<LocalDateTime> selectEvent) {
        event = DefaultScheduleEvent.builder()
                .startDate(selectEvent.getObject())
                .endDate(selectEvent.getObject().plusHours(1))
                .build();
    }

    public ECILibraryServices getEciLibraryServices() {
        return eciLibraryServices;
    }

    public void setEciLibraryServices(ECILibraryServices eciLibraryServices) {
        this.eciLibraryServices = eciLibraryServices;
    }

    public String getreservaName() throws BibliotecaException {
        r = eciLibraryServices.consultarReserva(idReserva);
        return r.getNombre();
    }



    public String getfechasol() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = r.getFechasoli().format(dateTimeFormatter);
        return formattedDateTime;
    }

    public LocalDateTime getFechaini() {
        return fechaini;
    }

    public String getSfechaini(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = fechaini.format(dateTimeFormatter);
        return formattedDateTime;
    }

    public String getSfechafin(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = fechafin.format(dateTimeFormatter);
        return formattedDateTime;
    }

    public void setFechaini(LocalDateTime fechaini) {
        this.fechaini = fechaini;
    }

    public LocalDateTime getFechafin() {
        return fechafin;
    }

    public void setFechafin(LocalDateTime fechafin) {
        this.fechafin = fechafin;
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public ScheduleEvent<?> getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent<?> event) {
        this.event = event;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Reserva getR() {
        return r;
    }

    public boolean getEstado(){
        return r.isEstado();
    }

    public void addReserva() throws BibliotecaException {
        try{
            eciLibraryServices.reservarRecurso(r);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}