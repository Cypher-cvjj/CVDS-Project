package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Reserva;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public interface ReservaDAO {
    public List<Reserva> consultarReservas() throws PersistenceException;

    public void reservarRecurso(Reserva reserva) throws PersistenceException;

    public List<Reserva> consultarReservasRecurso(int idrecurso) throws PersistenceException;

    public List<Reserva> consultarReservasUser(int documento) throws PersistenceException;

    Reserva consultarReserva(int idReserva)throws PersistenceException;

    public void CancelarReserva(int idReserva) throws PersistenceException;
}
