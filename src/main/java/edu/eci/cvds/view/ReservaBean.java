package edu.eci.cvds.view;


import com.google.inject.Inject;
import edu.eci.cvds.services.ECILibraryServices;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "ReservaBean")
@RequestScoped
public class ReservaBean extends BasePageBean {


    @Inject
    private ECILibraryServices eciLibraryServices;



}
