package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Reserva;
import org.apache.ibatis.exceptions.PersistenceException;

public interface ReservaDAO {
    public void reservarRecurso(Reserva reserva) throws PersistenceException;
}
