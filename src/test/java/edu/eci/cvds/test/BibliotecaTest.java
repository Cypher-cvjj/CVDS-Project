package edu.eci.cvds.test;

import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.entities.Ubicacion;
import edu.eci.cvds.services.ECILibraryServices;
import edu.eci.cvds.services.ECILibraryServicesFactory;
import org.junit.Test;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
        SimpleDateFormat fechaHora = new SimpleDateFormat("yyyMMdd");
        Date horaInicio = fechaHora.parse("20110210");
        java.sql.Date sql = new java.sql.Date(horaInicio.getTime());
        SimpleDateFormat fechafi = new SimpleDateFormat("yyyMMdd");
        Date horaFinal = fechaHora.parse("20110210");
        java.sql.Date sql2 = new java.sql.Date(horaFinal.getTime());
        List<Recurso> listarecursos = eciLibraryServices.consultarRecursos();
        int long1 = listarecursos.size();
        int id = (int) Math.floor(Math.random()*(2000-1000+1)+2000);
        Recurso r = new Recurso();
        r.setId(id);
        r.setNombre("libroo");
        r.setUbicacion(new Ubicacion(1,"BloqueG"));
        r.setCapacidad(2);
        r.setHorario_inicial(sql);
        r.setHorario_final(sql2);
        r.setDisponibilidad(true);
        r.setTiporecurso(new TipoRecurso(1,"Equipodecomputo"));
        eciLibraryServices.registrarRecursos(r);
        List<Recurso> listarecursos2 = eciLibraryServices.consultarRecursos();
        int long2 = listarecursos2.size();
        assertTrue(long2>long1);

    }

}
