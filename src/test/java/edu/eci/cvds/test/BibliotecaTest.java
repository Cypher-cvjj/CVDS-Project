package edu.eci.cvds.test;

import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.services.ECILibraryServices;
import edu.eci.cvds.services.ECILibraryServicesFactory;
import org.junit.Test;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


public class BibliotecaTest {
    private ECILibraryServices eciLibraryServices;


    public BibliotecaTest(){
        eciLibraryServices = ECILibraryServicesFactory.getInstance().getECILibraryServices();
    }

    @Test
    public void deberiaregistrarRecurso() throws BibliotecaException, ParseException {
        Timestamp horaInicio =  Timestamp.valueOf("2022-05-11 7:00:00");
        Timestamp horaFinal = Timestamp.valueOf("2022-05-12 19:00:00");
        List<Recurso> listarecursos = eciLibraryServices.consultarRecursos();
        int long1 = listarecursos.size();
        int id = (int) Math.floor(Math.random()*(2000-1000+1)+2000);
        Recurso r = new Recurso();
        r.setId(id);
        r.setNombre("libroo");
        r.setUbicacion(new Ubicacion(1,"BloqueG"));
        r.setCapacidad(2);
        r.setHorario_inicial(horaInicio);
        r.setHorario_final(horaFinal);
        r.setDisponibilidad(true);
        r.setTiporecurso(new TipoRecurso(1,"Equipodecomputo"));
        eciLibraryServices.registrarRecursos(r);
        List<Recurso> listarecursos2 = eciLibraryServices.consultarRecursos();
        int long2 = listarecursos2.size();
        assertTrue(long2>long1);

    }

    @Test
    public void deberiareservarRecurso() throws BibliotecaException, ParseException {
        Timestamp horaInicio = Timestamp.valueOf("2022-05-12 8:00:00");
        Timestamp horaFinal = Timestamp.valueOf("2022-05-12 9:00:00");
        Timestamp horasol = Timestamp.valueOf(LocalDateTime.now());
        int id = (int) Math.floor(Math.random()*(2000-1000+1)+2000);
        Recurso rec = new Recurso(id,"libro R",new Ubicacion(1,"BloqueG"),3,horaFinal,horasol,true,new TipoRecurso(1,"Equipodecomputo"));
        eciLibraryServices.registrarRecursos(rec);
        Reserva re = new Reserva();
        re.setNombre("reserva4");
        re.setId_reserva(id);
        re.setFechasoli(horasol);
        re.setFechaini(horaInicio);
        re.setFechafin(horaFinal);
        re.setRecurso(new Recurso(id,"libro R",new Ubicacion(1,"BloqueG"),3,horaFinal,horasol,true,new TipoRecurso(1,"Equipodecomputo")));
        re.setUsuario(new User(0000,"pepito","98765","pepito@gmail.com","6383743","user"));
        re.setTiporeserva(new TipoReserva(1,"Diario"));
        eciLibraryServices.reservarRecurso(re);
        assertTrue(re.getNombre() == "reserva4");
    }

    @Test
    public void deberiaCambiarEstadoRecurso() throws  BibliotecaException, ParseException{
        List<Recurso> listarecursos = eciLibraryServices.consultarRecursos();
        boolean flag = listarecursos.get(listarecursos.size() - 1).getDisponibilidad();
        eciLibraryServices.cambiarEstadoRecurso(listarecursos.get(listarecursos.size() - 1));
        assertTrue(listarecursos.get(listarecursos.size() - 1).getDisponibilidad() != flag);
    }

    @Test
    public void deberiacancelarReserva() throws BibliotecaException, ParseException {
        SimpleDateFormat fechaHora = new SimpleDateFormat("yyyMMdd");
        Date horaInicio = fechaHora.parse("20110210");
        java.sql.Date sql = new java.sql.Date(horaInicio.getTime());
        SimpleDateFormat fechafi = new SimpleDateFormat("yyyMMdd");
        Date horaFinal = fechaHora.parse("20110210");
        java.sql.Date sql2 = new java.sql.Date(horaFinal.getTime());
        SimpleDateFormat fechasol = new SimpleDateFormat("yyyMMdd");
        Date horasol = fechaHora.parse("20110210");
        java.sql.Date sql3 = new java.sql.Date(horaFinal.getTime());
        int id = (int) Math.floor(Math.random()*(2000-1000+1)+2000);
        Recurso rec = new Recurso(id,"libro R",new Ubicacion(1,"BloqueG"),3,sql2,sql3,true,new TipoRecurso(1,"Equipodecomputo"));
        eciLibraryServices.registrarRecursos(rec);
        Reserva re = new Reserva();
        re.setNombre("reserva4");
        re.setId_reserva(id);
        re.setFechasoli(sql3);
        re.setFechaini(sql);
        re.setFechafin(sql2);
        re.setEstado(false);
        re.setRecurso(new Recurso(id,"libro R",new Ubicacion(1,"BloqueG"),3,sql2,sql3,true,new TipoRecurso(1,"Equipodecomputo")));
        re.setUsuario(new User(0000,"pepito","98765","pepito@gmail.com","6383743","user"));
        re.setTiporeserva(new TipoReserva(1,"Diario"));
        eciLibraryServices.reservarRecurso(re);
        eciLibraryServices.CancelarReserva(re.getId_reserva());
        assertTrue(re.isEstado() == false);
    }



        assertTrue(re.getNombre() == "reserva4");
    /**
    @Test
    public void deberiaCambiarEstadoRecurso() throws  BibliotecaException, ParseException{
        List<Recurso> listarecursos = eciLibraryServices.consultarRecursos();
        boolean flag = listarecursos.get(listarecursos.size() - 1).getDisponibilidad();
        eciLibraryServices.cambiarEstadoRecurso(listarecursos.get(listarecursos.size() - 1));
        assertTrue(listarecursos.get(listarecursos.size() - 1).getDisponibilidad() != flag);
    }
    **/
}
}
