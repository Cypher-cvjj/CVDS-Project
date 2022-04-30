package edu.eci.cvds.services;

import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.entities.Ubicacion;
import edu.eci.cvds.persistence.TipoRecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisTipoRecursoDAO;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ECILibraryServices {

    public List<Recurso> consultarRecursos() throws BibliotecaException;

    public List<TipoRecurso> consultarTiporec() throws BibliotecaException;

    public List<Ubicacion> consultarUbicacion() throws BibliotecaException;

    public void registrarRecursos(Recurso recurso) throws BibliotecaException;

    public void cambiarEstadoRecurso(Recurso recurso) throws  BibliotecaException;

}
