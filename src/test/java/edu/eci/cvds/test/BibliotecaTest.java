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
    public void deberiaConsultarRecurso() throws BibliotecaException{
        List<Recurso> listarecursos = eciLibraryServices.consultarRecursos();
        int long1 = listarecursos.size();
        assertTrue(long1>0);
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
        re.setEstado(true);
        re.setRecurso(new Recurso(id,"libro R",new Ubicacion(1,"BloqueG"),3,horaFinal,horasol,true,new TipoRecurso(1,"Equipodecomputo")));
        re.setUsuario(new User(0000,"pepito","98765","pepito@gmail.com","6383743","user"));
        re.setTiporeserva(new TipoReserva(1,"Diario"));
        eciLibraryServices.reservarRecurso(re);
        assertTrue(re.isEstado() == true);
    }


    @Test
    public void deberiaregistrarRecursotipo() throws BibliotecaException, ParseException {
        Timestamp horaInicio =  Timestamp.valueOf("2022-05-11 7:00:00");
        Timestamp horaFinal = Timestamp.valueOf("2022-05-12 19:00:00");
        List<Recurso> listarecursos = eciLibraryServices.consultarRecursos();
        int long1 = listarecursos.size();
        int id = (int) Math.floor(Math.random()*(2000-1000+1)+2000);
        Recurso r = new Recurso();
        r.setId(id);
        r.setNombre("Recurso profesores");
        r.setUbicacion(new Ubicacion(3,"BibliotecaJorgeAlvarez"));
        r.setCapacidad(2);
        r.setHorario_inicial(horaInicio);
        r.setHorario_final(horaFinal);
        r.setDisponibilidad(true);
        r.setTiporecurso(new TipoRecurso(2,"Saladeestudio"));
        eciLibraryServices.registrarRecursos(r);
        List<Recurso> listarecursos2 = eciLibraryServices.consultarRecursos();
        int long2 = listarecursos2.size();
        assertTrue(long2>long1);

    }



    @Test
    public void deberiareservarRecursosemanal() throws BibliotecaException, ParseException {
        Timestamp horaInicio = Timestamp.valueOf("2022-05-12 8:00:00");
        Timestamp horaFinal = Timestamp.valueOf("2022-05-12 9:00:00");
        Timestamp horasol = Timestamp.valueOf(LocalDateTime.now());
        int id = (int) Math.floor(Math.random()*(3000-1000+1)+3000);
        Recurso rec = new Recurso(id,"recurso de ingenieria",new Ubicacion(2,"BloqueB"),3,horaFinal,horasol,true,new TipoRecurso(2,"Saladeestudio"));
        eciLibraryServices.registrarRecursos(rec);
        Reserva re = new Reserva();
        re.setNombre("reserva sala inge");
        re.setId_reserva(id);
        re.setFechasoli(horasol);
        re.setFechaini(horaInicio);
        re.setFechafin(horaFinal);
        re.setEstado(true);
        re.setRecurso(new Recurso(id,"recurso de ingenieria",new Ubicacion(2,"BloqueB"),3,horaFinal,horasol,true,new TipoRecurso(2,"Saladeestudio")));
        re.setUsuario(new User(0000,"pepito","98765","pepito@gmail.com","6383743","user"));
        re.setTiporeserva(new TipoReserva(2,"Semanal"));
        eciLibraryServices.reservarRecurso(re);
        assertTrue(re.isEstado() == true);
    }


    @Test
    public void deberiareservarRecursomensual() throws BibliotecaException, ParseException {
        Timestamp horaInicio = Timestamp.valueOf("2022-05-12 8:00:00");
        Timestamp horaFinal = Timestamp.valueOf("2022-05-12 9:00:00");
        Timestamp horasol = Timestamp.valueOf(LocalDateTime.now());
        int id = (int) Math.floor(Math.random()*(3000-1000+1)+3000);
        Recurso rec = new Recurso(id,"recurso de ingenieria",new Ubicacion(2,"BloqueB"),3,horaFinal,horasol,true,new TipoRecurso(2,"Saladeestudio"));
        eciLibraryServices.registrarRecursos(rec);
        Reserva re = new Reserva();
        re.setNombre("reserva sala inge");
        re.setId_reserva(id);
        re.setFechasoli(horasol);
        re.setFechaini(horaInicio);
        re.setFechafin(horaFinal);
        re.setEstado(true);
        re.setRecurso(new Recurso(id,"recurso de ingenieria",new Ubicacion(2,"BloqueB"),3,horaFinal,horasol,true,new TipoRecurso(2,"Saladeestudio")));
        re.setUsuario(new User(0000,"pepito","98765","pepito@gmail.com","6383743","user"));
        re.setTiporeserva(new TipoReserva(2,"Semanal"));
        eciLibraryServices.reservarRecurso(re);
        assertTrue(re.isEstado() == true);
    }

    @Test
    public  void deberiaconsultarReserva() throws BibliotecaException{
        List<Reserva> listare = eciLibraryServices.consultarReservas();
        int long1 = listare.size();
        assertTrue(long1>0);
    }

    @Test
    public void deberiareservarRecursomensual2() throws BibliotecaException, ParseException {
        Timestamp horaInicio = Timestamp.valueOf("2022-05-12 8:00:00");
        Timestamp horaFinal = Timestamp.valueOf("2022-05-12 9:00:00");
        Timestamp horasol = Timestamp.valueOf(LocalDateTime.now());
        int id = (int) Math.floor(Math.random()*(3000-1000+1)+3000);
        Recurso rec = new Recurso(id,"recurso bloque b",new Ubicacion(2,"BloqueB"),3,horaFinal,horasol,true,new TipoRecurso(2,"Saladeestudio"));
        eciLibraryServices.registrarRecursos(rec);
        Reserva re = new Reserva();
        re.setNombre("reserva sala inge");
        re.setId_reserva(id);
        re.setFechasoli(horasol);
        re.setFechaini(horaInicio);
        re.setFechafin(horaFinal);
        re.setEstado(true);
        re.setRecurso(new Recurso(id,"recurso bloque b",new Ubicacion(2,"BloqueB"),3,horaFinal,horasol,true,new TipoRecurso(2,"Saladeestudio")));
        re.setUsuario(new User(0000,"pepito","98765","pepito@gmail.com","6383743","user"));
        re.setTiporeserva(new TipoReserva(2,"Semanal"));
        eciLibraryServices.reservarRecurso(re);
        assertTrue(re.isEstado() == true);
    }

    @Test
    public void deberiacancelarReserva() throws BibliotecaException, ParseException {
        Timestamp horaInicio =  Timestamp.valueOf("2022-05-11 7:00:00");
        Timestamp horaFinal = Timestamp.valueOf("2022-05-12 19:00:00");
        Timestamp fechasoli = Timestamp.valueOf("2022-05-12 19:00:00");
        List<Recurso> listarecursos = eciLibraryServices.consultarRecursos();
        int long1 = listarecursos.size();
        int id = (int) Math.floor(Math.random()*(3000-1000+1)+3000);
        Recurso r = new Recurso();
        r.setId(id);
        r.setNombre("Recurso monitoria");
        r.setUbicacion(new Ubicacion(1,"BloqueG"));
        r.setCapacidad(2);
        r.setHorario_inicial(horaInicio);
        r.setHorario_final(horaFinal);
        r.setDisponibilidad(true);
        r.setTiporecurso(new TipoRecurso(1,"Equipodecomputo"));
        eciLibraryServices.registrarRecursos(r);
        Reserva re = new Reserva();
        re.setNombre("reserva4");
        re.setId_reserva(id);
        re.setFechasoli(fechasoli);
        re.setFechaini(horaInicio);
        re.setFechafin(horaFinal);
        re.setEstado(false);
        re.setRecurso(new Recurso(id,"Recurso monitoria",new Ubicacion(1,"BloqueG"),3,horaFinal,fechasoli,true,new TipoRecurso(1,"Equipodecomputo")));
        re.setUsuario(new User(0000,"pepito","98765","pepito@gmail.com","6383743","user"));
        re.setTiporeserva(new TipoReserva(3,"mensual"));
        eciLibraryServices.reservarRecurso(re);
        eciLibraryServices.CancelarReserva(re.getId_reserva());
        assertTrue(re.isEstado() == false);
    }


    @Test
    public void deberiacancelarReserva2() throws BibliotecaException, ParseException {
        Timestamp horaInicio =  Timestamp.valueOf("2022-05-11 7:00:00");
        Timestamp horaFinal = Timestamp.valueOf("2022-05-12 19:00:00");
        Timestamp fechasoli = Timestamp.valueOf("2022-05-12 19:00:00");
        List<Recurso> listarecursos = eciLibraryServices.consultarRecursos();
        int long1 = listarecursos.size();
        int id = (int) Math.floor(Math.random()*(3000-1000+1)+3000);
        Recurso r = new Recurso();
        r.setId(id);
        r.setNombre("Recurso ingenieria civil");
        r.setUbicacion(new Ubicacion(1,"BloqueG"));
        r.setCapacidad(2);
        r.setHorario_inicial(horaInicio);
        r.setHorario_final(horaFinal);
        r.setDisponibilidad(true);
        r.setTiporecurso(new TipoRecurso(1,"Equipodecomputo"));
        eciLibraryServices.registrarRecursos(r);
        Reserva re = new Reserva();
        re.setNombre("reserva4");
        re.setId_reserva(id);
        re.setFechasoli(fechasoli);
        re.setFechaini(horaInicio);
        re.setFechafin(horaFinal);
        re.setEstado(false);
        re.setRecurso(new Recurso(id,"Recurso ingenieria civil",new Ubicacion(1,"BloqueG"),3,horaFinal,fechasoli,true,new TipoRecurso(1,"Equipodecomputo")));
        re.setUsuario(new User(0000,"pepito","98765","pepito@gmail.com","6383743","user"));
        re.setTiporeserva(new TipoReserva(3,"mensual"));
        eciLibraryServices.reservarRecurso(re);
        eciLibraryServices.CancelarReserva(re.getId_reserva());
        assertTrue(re.isEstado() == false);
    }


}

