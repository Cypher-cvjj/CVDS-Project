package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.ECILibraryServices;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "UserBean")
@RequestScoped
public class UserBean extends BasePageBean{

    @Inject
    private ECILibraryServices eciLibraryServices;

    private int documento;
    private String nombre;
    private String contrasena;
    private String correo;
    private String telefono;
    private int tipousuario;

    public List<User> consultarUsuarios() throws BibliotecaException {
        List<User> usuarios = new ArrayList<>();
        try {
            usuarios = eciLibraryServices.consultarUsuarios();
        }catch (Exception e){
            e.printStackTrace();
        }
        return usuarios;
    }

    public ECILibraryServices getEciLibraryServices() {
        return eciLibraryServices;
    }

    public void setEciLibraryServices(ECILibraryServices eciLibraryServices) {
        this.eciLibraryServices = eciLibraryServices;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(int tipousuario) {
        this.tipousuario = tipousuario;
    }
}
