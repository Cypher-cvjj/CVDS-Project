package edu.eci.cvds.services;
import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Ubicacion;
import edu.eci.cvds.services.ECILibraryServices;
import edu.eci.cvds.services.impl.ECILibraryServicesImpl;

import javax.faces.model.SelectItem;


public class main {
    public static void main(String[] args) throws BibliotecaException {
        ECILibraryServices instance = ECILibraryServicesFactory.getInstance().getECILibraryServices();
//        System.out.println(instance.consultarCliente(2165711).toString());
//        System.out.println(instance.consultarRecursos());
        for(Recurso r: instance.consultarRecursos()){
            System.out.println(r.toString());
        }


    }
}