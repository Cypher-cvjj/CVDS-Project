package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.persistence.HorarioDAO;
import edu.eci.cvds.persistence.mappers.HorarioMapper;

public class MyBatisHorarioDAO implements HorarioDAO{

    @Inject
    private HorarioMapper horarioMapper;
}
