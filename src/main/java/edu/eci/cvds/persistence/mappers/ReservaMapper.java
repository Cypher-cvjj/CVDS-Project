package edu.eci.cvds.persistence.mappers;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ReservaMapper{

    public List<Reserva> consultarReserva();

}
