package edu.eci.cvds.persistence.mappers;

import edu.eci.cvds.entities.Session;

import org.apache.ibatis.annotations.Param;

public interface SessionMapper {

    public Session consultarSession(@Param("email") String email, @Param("password") String password);
   }
