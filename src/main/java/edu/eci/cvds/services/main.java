package edu.eci.cvds.services;
import edu.eci.cvds.Exceptions.BibliotecaException;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.Ubicacion;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.ECILibraryServices;
import edu.eci.cvds.services.impl.ECILibraryServicesImpl;

import javax.faces.model.SelectItem;


public class main {
    public static void main(String[] args) throws BibliotecaException {
        ECILibraryServices instance = ECILibraryServicesFactory.getInstance().getECILibraryServices();
//        for(Reserva r: instance.consultarReservasUser(0)) {
            System.out.println(instance.consultarReserva(1).getNombre());
//        }
    }
}