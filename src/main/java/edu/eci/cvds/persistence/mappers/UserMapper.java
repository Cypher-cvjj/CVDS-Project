package edu.eci.cvds.persistence.mappers;

import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.User;

import java.util.List;

public interface UserMapper {
    public List<User> consultarUsuarios();
}
