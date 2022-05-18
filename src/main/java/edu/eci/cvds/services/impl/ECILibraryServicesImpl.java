package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.services.ECILibraryServices;
import org.apache.ibatis.exceptions.PersistenceException;

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

    @Inject
    private UserDAO userDAO;

    @Inject
    private SessionDAO sessionDAO;

    @Override
    public List<Reserva> consultarReservas() throws BibliotecaException {
        try{
            return reservaDAO.consultarReservas();
        }catch (PersistenceException ex){
            throw new BibliotecaException("Error al consultar recursos",ex);
        }
    }

    @Override
    public List<Reserva> consultarReservasRecurso(int idrecurso) throws BibliotecaException {
        try{
            return reservaDAO.consultarReservasRecurso(idrecurso);
        }catch (PersistenceException ex){
            ex.printStackTrace();
            throw new BibliotecaException("Error al consultar reserva", ex);
        }
    }

    @Override
    public List<Reserva> consultarReservasUser(int documento) throws BibliotecaException{
        try{
            return reservaDAO.consultarReservasUser(documento);
        }catch (PersistenceException ex){
            ex.printStackTrace();
            throw new BibliotecaException("Error al consultar reservas user", ex);
        }
    }

    @Override
    public Reserva consultarReserva(int idReserva) throws BibliotecaException{
        try{
            return reservaDAO.consultarReserva(idReserva);
        }catch (PersistenceException ex){
            throw new BibliotecaException("Error al consultar Reserva", ex);
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
    public void cambiarEstadoRecurso(int idRecurso) throws BibliotecaException{
        try{
            RecursoDAO.cambiarEstadoRecurso(idRecurso);
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
    public List<User> consultarUsuarios() throws BibliotecaException {
        try{
            return userDAO.consultarUsuarios();
        }catch (PersistenceException ex){
            throw new BibliotecaException("Error al consultar usuarios", ex);
        }
    }


    @Override
    public void CancelarReserva(int idReserva) throws BibliotecaException {
        try{
            reservaDAO.CancelarReserva(idReserva);
        }catch (PersistenceException ex){
            throw new BibliotecaException("Error al consultar tipos de reservas",ex);
        }
    }

    @Override
    public Session consultarSession(String email, String password) throws BibliotecaException {
        try{
            return sessionDAO.consultarSession(email, password);
        }catch (PersistenceException ex){
            throw new BibliotecaException("Error al buscar sesión", ex);
        }
    }


    @Override
    public Recurso consultarRecurso(int idRecurso) throws BibliotecaException {
        try{
            return RecursoDAO.consultarRecurso(idRecurso);
        }catch (PersistenceException ex){
            throw new BibliotecaException("Error al consultar recursos",ex);
        }
    }

}
