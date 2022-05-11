package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.entities.Ubicacion;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.ReservaDAO;
import edu.eci.cvds.persistence.TipoRecursoDAO;
import edu.eci.cvds.persistence.UbicacionDAO;
import edu.eci.cvds.services.ECILibraryServices;
import org.apache.ibatis.exceptions.PersistenceException;
import org.mybatis.guice.transactional.Transactional;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Singleton
public class ECILibraryServicesImpl implements ECILibraryServices {

    @Inject
    private RecursoDAO RecursoDAO;

    @Inject
    private TipoRecursoDAO tipoRecursoDAO;

    @Inject
    private UbicacionDAO ubicacionDAO;

    @Override
    public List<Recurso> consultarRecursos() throws BibliotecaException {
        try{
            return RecursoDAO.consultarRecursos();
        }catch (PersistenceException ex){
            throw new BibliotecaException("Error al consultar recursos",ex);
        }
    }

    @Override
    public List<TipoRecurso> consultarTiporec() throws BibliotecaException {
        try {
            return tipoRecursoDAO.consultarTiporec();
        }catch (PersistenceException ex){
            throw new BibliotecaException("Error al consultar tipo de recursos",ex);
        }
    }

    @Override
    public List<Ubicacion> consultarUbicacion() throws BibliotecaException {
        try {
            return ubicacionDAO.consultarUbicacion();
        }catch (PersistenceException ex){
            throw new BibliotecaException("Error al consultar ubicaciones",ex);
        }
    }


    @Override
    public void registrarRecursos(Recurso recurso) throws BibliotecaException {
        try{
            RecursoDAO.agregarRecursos(recurso);
        }catch (PersistenceException ex){
            throw  new BibliotecaException("Error al registrar recursos",ex);
        }
    }

    @Override
    public void cambiarEstadoRecurso(Recurso recurso) throws BibliotecaException{

    }

    @Override
    public List<Reserva> consultarReserva() throws BibliotecaException {
        try{
            return null;
            //return ReservaDAO.consultarReserva();
        }catch (PersistenceException ex){
            throw new BibliotecaException("Error al consultar Reserva",ex);
        }
    }
}
