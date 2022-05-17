package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Session;

public interface SessionDAO {

    public Session consultarSession(String email, String password);
}
