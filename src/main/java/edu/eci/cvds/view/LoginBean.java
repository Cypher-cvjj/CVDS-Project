package edu.eci.cvds.view;

import java.io.IOException;
import java.io.Serializable;

import edu.eci.cvds.services.ECILibraryServices;
import org.primefaces.model.DefaultScheduleModel;
import com.google.inject.Inject;
import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Session;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import edu.eci.cvds.services.ECILibraryServices;

@RequestScoped
@ManagedBean(name = "LoginBean")
public class LoginBean extends BasePageBean implements Serializable{
    
    @Inject
    private ECILibraryServices eciLibraryServices;

    private static final String URL_0 = "http://localhost:8080/CVDS.Project/horarios.xhtml";
    private static final String URL_1 = "http://localhost:8080/CVDS.Project/anadirrecurso.xhtml";
    private static final String URL_2 = "http://localhost:8080/CVDS.Project/anadirrecurso.xhtml";
    private String email;
    private String password;
    
    public void Login() throws BibliotecaException, IOException {
        Session currentSession =  eciLibraryServices.consultarSession(email, password);
         if (currentSession != null){
             switch (currentSession.getRol()){
                case 0:
                    FacesContext.getCurrentInstance().getExternalContext().redirect(URL_0);
                case 1:
                    FacesContext.getCurrentInstance().getExternalContext().redirect(URL_1);
                case 2:
                    FacesContext.getCurrentInstance().getExternalContext().redirect(URL_2);
             }

         }
        
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
