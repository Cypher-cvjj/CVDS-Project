package edu.eci.cvds.persistence.mappers;

import edu.eci.cvds.entities.Reserva;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReservaMapper {
    public void reservarRecurso(@Param("Reserva") Reserva reserva);

    public List<Reserva> consultarReservas();

    public List<Reserva> consultarReservasRecurso(@Param("rRecurso") int idrecurso);

    public void CancelarReserva(@Param("reserva") Reserva reserva);

    public Reserva consultarReserva(@Param("idReserva") int idReserva);
    public void CancelarReserva(@Param("idReserva") int idReserva);
}
