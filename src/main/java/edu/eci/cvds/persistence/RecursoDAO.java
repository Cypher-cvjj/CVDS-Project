package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Recurso;
import org.apache.ibatis.exceptions.PersistenceException;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public interface RecursoDAO {
    public List<Recurso> consultarRecursos() throws PersistenceException;

    public void agregarRecursos(Recurso recurso) throws PersistenceException;

    public void cambiarEstadoRecurso(int idRecurso) throws  PersistenceException;

    public Recurso consultarRecurso(int idRecurso) throws PersistenceException;
}
