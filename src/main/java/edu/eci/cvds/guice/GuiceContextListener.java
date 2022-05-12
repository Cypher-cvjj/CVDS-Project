package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.eci.cvds.entities.TipoReserva;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.persistence.mybatisimpl.*;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.services.ECILibraryServices;
import edu.eci.cvds.services.impl.ECILibraryServicesImpl;

public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
        @Override
        protected void initialize() {

        install(JdbcHelper.PostgreSQL);
        setEnvironmentId("development");
        setClassPathResource("mybatis-config.xml");
        bind(ECILibraryServices.class).to(ECILibraryServicesImpl.class);
        bind(RecursoDAO.class).to(MyBatisRecursoDAO.class);
        bind(UserDAO.class).to(MyBatisUserDAO.class);
        bind(TipoRecursoDAO.class).to(MyBatisTipoRecursoDAO.class);
        bind(UbicacionDAO.class).to(MyBatisUbicacionDAO.class);
        bind(ReservaDAO.class).to(MyBatisReservaDAO.class);
        bind(TipoReservaDAO.class).to(MyBatisTipoReservaDAO.class);

       }
    }
    );

        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(Injector.class.getName(), injector);
    }

}
