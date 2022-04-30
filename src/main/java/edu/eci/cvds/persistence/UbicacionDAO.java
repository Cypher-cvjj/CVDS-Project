package edu.eci.cvds.persistence;


import edu.eci.cvds.entities.Ubicacion;

import java.util.List;

public interface UbicacionDAO {
    public List<Ubicacion> consultarUbicacion();
}
