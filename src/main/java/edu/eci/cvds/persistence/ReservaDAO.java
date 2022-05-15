package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Reserva;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public interface ReservaDAO {
    public List<Reserva> consultarReservas() throws PersistenceException;

    public void reservarRecurso(Reserva reserva) throws PersistenceException;

    public List<Reserva> consultarReservasRecurso(int idrecurso);

    public void CancelarReserva(Reserva reserva) throws PersistenceException;
}
