package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.TipoRecurso;

import java.util.List;

public interface TipoRecursoDAO {
    public List<TipoRecurso> consultarTiporec();
}
