package edu.eci.cvds.persistence.mybatisimpl;

import edu.eci.cvds.persistence.mappers.ReservaMapper;
import edu.eci.cvds.persistence.ReservaDAO;
import javax.inject.Inject;

public class MyBatisReservaDAO implements ReservaDAO{

    @Inject

    private ReservaMapper reservaMapper;
}
