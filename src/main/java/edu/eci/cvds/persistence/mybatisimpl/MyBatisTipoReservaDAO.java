package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.TipoReserva;
import edu.eci.cvds.persistence.TipoReservaDAO;
import edu.eci.cvds.persistence.mappers.TipoReservaMapper;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public class MyBatisTipoReservaDAO implements TipoReservaDAO {

    @Inject
    TipoReservaMapper tipoReservaMapper;

    public List<TipoReserva> consultarTipores() throws PersistenceException {
        try {
            return tipoReservaMapper.consultarTipores();
        }catch (Exception e) {
            throw new PersistenceException(e.getMessage());
        }
    }
}
