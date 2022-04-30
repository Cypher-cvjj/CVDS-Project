package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.persistence.TipoRecursoDAO;
import edu.eci.cvds.persistence.mappers.TipoRecursoMapper;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public class MyBatisTipoRecursoDAO implements TipoRecursoDAO {

    @Inject
    TipoRecursoMapper tipoRecursoMapper;

    @Override
    public List<TipoRecurso> consultarTiporec() throws PersistenceException {
        try {
            return tipoRecursoMapper.consultarTiporec();
        }catch (Exception e) {
            throw new PersistenceException(e.getMessage());
        }
    }

}
