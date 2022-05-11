package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public interface ReservaDAO {

    public List<Reserva> consultarReserva() throws PersistenceException;

}
