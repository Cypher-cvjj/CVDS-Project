package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Ubicacion;
import edu.eci.cvds.persistence.UbicacionDAO;
import edu.eci.cvds.persistence.mappers.UbicacionMapper;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public class MyBatisUbicacionDAO implements UbicacionDAO {

    @Inject
    UbicacionMapper ubicacionMapper;
    @Override
    public List<Ubicacion> consultarUbicacion() throws PersistenceException{
        try {
            return ubicacionMapper.consultarUbicacion();
        }catch (Exception e) {
            throw new PersistenceException(e.getMessage());
        }
    }
}
