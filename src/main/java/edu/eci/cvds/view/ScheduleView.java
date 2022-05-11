package edu.eci.cvds.view;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;
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
    private LocalDateTime fechaini;
    private LocalDateTime fechafin;

    public void inicializar(int id) throws IOException{
        this.idRecurso = id;
        eventModel = new DefaultScheduleModel();
        loadEventos();
        FacesContext.getCurrentInstance().getExternalContext().redirect("./CVDS.Project/horarios.xhtml");
    }

    private void loadEventos() {
        try {
            List<Recurso> recursos = eciLibraryServices.consultarRecursos();
            LocalDateTime hoy = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
            for (int i = 0; i < 30; i++) {
                for (Recurso recurso : recursos) {
                    System.out.println("entro for: "+recurso.getHorario_inicial() );

                    LocalDateTime dia = hoy.plusDays(i);
                    if (recurso.getHorario_inicial().getDay() == dia.getDayOfWeek().getValue()) {
                        System.out.println("entro if");
                        LocalDateTime fechaini = dia.plusHours(recurso.getHorario_inicial().getHours());
                        LocalDateTime fechafin = dia.plusHours(recurso.getHorario_final().getHours());
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
//            for (Reserva r : reservas) {
//                LocalDateTime fechaini = r.getFechaini().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//                LocalDateTime fechafin = r.getFechafin().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
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

    public void onEventSelect(SelectEvent selectEvent) {
        this.event = (ScheduleEvent<?>) selectEvent.getObject();
        this.fechaini = event.getStartDate();
        this.fechafin = event.getStartDate();
    }

    public ECILibraryServices getEciLibraryServices() {
        return eciLibraryServices;
    }

    public void setEciLibraryServices(ECILibraryServices eciLibraryServices) {
        this.eciLibraryServices = eciLibraryServices;
    }

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



}