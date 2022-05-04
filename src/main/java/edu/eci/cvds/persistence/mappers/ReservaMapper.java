package edu.eci.cvds.persistence.mappers;

import edu.eci.cvds.entities.Reserva;
import org.apache.ibatis.annotations.Param;

public interface ReservaMapper {
    public void reservarRecurso(@Param("Reserva") Reserva reserva);
}
