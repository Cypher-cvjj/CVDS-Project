package edu.eci.cvds.view;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;
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

    public ECILibraryServices getEciLibraryServices() {
        return eciLibraryServices;
    }

    public void setEciLibraryServices(ECILibraryServices eciLibraryServices) {
        this.eciLibraryServices = eciLibraryServices;
    }

    private ScheduleModel eventModel = new DefaultScheduleModel();


    public LocalDateTime getFechaini() {
        return fechaini;
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

    private ScheduleEvent<?> event = new DefaultScheduleEvent<>();
    private LocalDateTime fechaini;
    private LocalDateTime fechafin;

    public void inicializar(int id) throws IOException{
        System.out.println("incializo");
        this.idRecurso = id;
        eventModel = new DefaultScheduleModel();
        loadEventos();
        FacesContext.getCurrentInstance().getExternalContext().redirect("./CVDS.Project/horarios.xhtml");
    }

    private void loadEventos() {
        try {
            List<Reserva> reservas = eciLibraryServices.consultarReservas();
            LocalDateTime hoy = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
            for (int i = 0; i < 30; i++) {
                for (Reserva reserva : reservas) {
                    LocalDateTime dia = hoy.plusDays(i);
                    if (reserva.getFechasoli().getDay() == dia.getDayOfWeek().getValue()) {
                        LocalDateTime fechaini = dia.plusHours(reserva.getFechaini().getHours());
                        LocalDateTime hasta = dia.plusHours(reserva.getFechafin().getHours());
                        DefaultScheduleEvent<?> event1 = DefaultScheduleEvent.builder()
                                .title(dia.getDayOfWeek().name())
                                .startDate(fechaini)
                                .endDate(fechafin)
                                .borderColor("orange")
                                .overlapAllowed(true)
                                .id(dia.getDayOfWeek().name())
                                .build();
                        eventModel.addEvent(event1);
                    }
                }
            }
//            List<Reserva> r = eciLibraryServices.consultarReservas();
//            for (Reserva reserva : r) {
//                LocalDateTime fechaini = reserva.getFechaini().toLocalDateTime();
//                LocalDateTime fechafin = reserva.getFechafin().toLocalDateTime();
//                if (fechaini.isAfter(hoy)) {
//                    DefaultScheduleEvent<?> event1 = DefaultScheduleEvent.builder()
//                            .title("Reserva")
//                            .startDate(fechaini)
//                            .endDate(fechafin)
//                            .borderColor("blue")
//                            .overlapAllowed(true)
//                            .build();
//                    eventModel.addEvent(event1);
//                }
//            }
        } catch (Exception e) {
            System.out.println(e);
        }
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

    public void onEventSelect(SelectEvent selectEvent) {
        this.event = (ScheduleEvent<?>) selectEvent.getObject();
        this.fechaini = event.getStartDate();
        this.fechafin = event.getStartDate();
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }



}