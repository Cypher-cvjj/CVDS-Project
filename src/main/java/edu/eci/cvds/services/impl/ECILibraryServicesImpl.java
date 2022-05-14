package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.persistence.*;
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

    @Inject
    private ReservaDAO reservaDAO;

    @Inject
    private TipoReservaDAO tipoReservaDAO;

    @Override
    public List<Reserva> consultarReservas() throws BibliotecaException {
        try{
            return reservaDAO.consultarReservas();
        }catch (PersistenceException ex){
            throw new BibliotecaException("Error al consultar recursos",ex);
        }
    }

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
        try{
            RecursoDAO.cambiarEstadoRecurso(recurso);
        }catch (PersistenceException ex){
            throw  new BibliotecaException("Error al cambiar estado del recurso",ex);
        }
    }

    @Override
    public void reservarRecurso(Reserva reserva) throws BibliotecaException {
        try{
            reservaDAO.reservarRecurso(reserva);
        }catch (PersistenceException ex){
            throw  new BibliotecaException("Error al reservar un recursos",ex);
        }
    }

    @Override
    public List<TipoReserva> consultarTipores() throws BibliotecaException {
        try{
            return tipoReservaDAO.consultarTipores();
        }catch (PersistenceException ex){
            throw new BibliotecaException("Error al consultar tipos de reservas",ex);
        }
    }

    @Override
    public void CancelarReserva(Reserva reserva) throws BibliotecaException {
        try{
            reservaDAO.CancelarReserva(reserva);
        }catch (PersistenceException ex){
            throw new BibliotecaException("Error al consultar tipos de reservas",ex);
        }
    }
}
