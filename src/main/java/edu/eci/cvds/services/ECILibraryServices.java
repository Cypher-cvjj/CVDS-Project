package edu.eci.cvds.services;

import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.persistence.TipoRecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisTipoRecursoDAO;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ECILibraryServices {

    public List<Reserva> consultarReservas() throws BibliotecaException;

    public List<Reserva> consultarReservasRecurso(int idrecurso) throws BibliotecaException;

    public List<Recurso> consultarRecursos() throws BibliotecaException;

    public List<TipoRecurso> consultarTiporec() throws BibliotecaException;

    public List<Ubicacion> consultarUbicacion() throws BibliotecaException;

    public void registrarRecursos(Recurso recurso) throws BibliotecaException;

    public void cambiarEstadoRecurso(int idRecurso) throws  BibliotecaException;

    public void reservarRecurso(Reserva reserva) throws BibliotecaException;

    public List<TipoReserva> consultarTipores() throws BibliotecaException;

    public List<User> consultarUsuarios() throws BibliotecaException;

    public Reserva consultarReserva(int idReserva) throws BibliotecaException;

    public void CancelarReserva(int idReserva) throws BibliotecaException;

    public List<Reserva> consultarReservasUser(int documento) throws BibliotecaException;

    public Session consultarSession(String email, String password) throws BibliotecaException;

    public Recurso consultarRecurso(int idRecurso) throws BibliotecaException;
}
