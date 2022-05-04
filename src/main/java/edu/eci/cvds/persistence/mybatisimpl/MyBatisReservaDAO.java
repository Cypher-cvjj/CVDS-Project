package edu.eci.cvds.persistence.mybatisimpl;

import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.persistence.mappers.ReservaMapper;
import edu.eci.cvds.persistence.ReservaDAO;
import org.apache.ibatis.exceptions.PersistenceException;

import javax.inject.Inject;

public class MyBatisReservaDAO implements ReservaDAO{

    @Inject
    private ReservaMapper reservaMapper;

    @Override
    public void reservarRecurso(Reserva reserva) {
        try{
            reservaMapper.reservarRecurso(reserva);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar recurso",e);
        }
    }
}
