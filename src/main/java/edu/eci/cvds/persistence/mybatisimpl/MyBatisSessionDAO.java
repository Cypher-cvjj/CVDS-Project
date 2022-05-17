package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Session;
import edu.eci.cvds.persistence.SessionDAO;
import edu.eci.cvds.persistence.mappers.SessionMapper;

public class MyBatisSessionDAO implements SessionDAO{

    @Inject
    SessionMapper SessionMapper;

    @Override
    public Session consultarSession(String email, String password) {
        return SessionMapper.consultarSession(email, password);    
    }
    
}
