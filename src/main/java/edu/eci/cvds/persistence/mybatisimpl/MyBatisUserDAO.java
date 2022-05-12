package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.UserDAO;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.persistence.mappers.UserMapper;
import java.util.List;

public class MyBatisUserDAO implements UserDAO {

    @Inject
    private UserMapper userMapper;

    @Override
    public List<User> consultarUsuarios() throws PersistenceException {
        List<User> usuarios =null;
        try{
            usuarios = userMapper.consultarUsuarios();
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar recursos mb",e);
        }
        return usuarios;
    }
}
