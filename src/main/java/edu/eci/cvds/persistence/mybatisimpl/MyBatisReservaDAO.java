package edu.eci.cvds.persistence.mybatisimpl;

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
    public List<Reserva> consultarReservas() throws PersistenceException {
        List<Reserva> lisreserva = null;
        try{
            lisreserva = reservaMapper.consultarReservas();
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar recursos mb",e);
        }
        return lisreserva;
    }

    @Override
    public void reservarRecurso(Reserva reserva) {
        try{
            reservaMapper.reservarRecurso(reserva);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar recurso",e);
        }
    }

    @Override
    public List<Reserva> consultarReservasRecurso(int idrecurso) {
        List<Reserva> lisreservasrecurso = null;
        try{
            lisreservasrecurso = reservaMapper.consultarReservasRecurso(idrecurso);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar reservas recurso",e);
        }
        return lisreservasrecurso;
    }


    @Override
    public void CancelarReserva(int idReserva){
        try{
            reservaMapper.CancelarReserva(idReserva);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar recurso",e);
        }
    }

    @Override
    public Reserva consultarReserva(int idReserva) throws PersistenceException {
        System.out.println("entro mybatis");
        try{
            return reservaMapper.consultarReserva(idReserva);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar recursos mb",e);
        }
    }
}
