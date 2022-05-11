package edu.eci.cvds.persistence.mybatisimpl;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.persistence.mappers.ReservaMapper;
import edu.eci.cvds.persistence.ReservaDAO;
import org.apache.ibatis.exceptions.PersistenceException;

import javax.inject.Inject;
import java.util.List;

public class MyBatisReservaDAO implements ReservaDAO{

    @Inject

    private ReservaMapper reservaMapper;

    @Override
    public List<Reserva> consultarReserva() throws PersistenceException {
        List<Reserva> lista = null;
        try{
            lista = reservaMapper.consultarReserva();
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar reserva",e);
        }
        return lista;
    }
}
