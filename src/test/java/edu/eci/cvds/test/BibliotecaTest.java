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
import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;


public class BibliotecaTest {
    private ECILibraryServices eciLibraryServices;


    public BibliotecaTest(){
        eciLibraryServices = ECILibraryServicesFactory.getInstance().getECILibraryServices();
    }

    @Test
    public void deberiaregistrarRecurso() throws BibliotecaException, ParseException {
        DateFormat fechaHora = new SimpleDateFormat("HH:mm");
        java.util.Date horaInicio = fechaHora.parse("11:30");
        DateFormat fechaHora1 = new SimpleDateFormat("HH:mm");
        java.util.Date horaFinal = fechaHora1.parse("12:30");
        List<Recurso> listarecursos = eciLibraryServices.consultarRecursos();
        int long1 = listarecursos.size();
        int id = (int) Math.floor(Math.random()*(2000-1000+1)+2000);
        eciLibraryServices.registrarRecursos(new Recurso(id,"manejo","BloqueG",8,horaInicio,horaFinal,true,"Saladeestudio"));
        List<Recurso> listarecursos2 = eciLibraryServices.consultarRecursos();
        int long2 = listarecursos2.size();
        assertTrue(long2>long1);

    }

}
