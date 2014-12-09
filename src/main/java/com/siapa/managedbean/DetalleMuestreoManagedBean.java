/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.DetalleMuestreoLazyModel;
import com.siapa.model.DetalleMuestreo;
import com.siapa.model.Muestreo;
import com.siapa.service.MuestreoService;
import com.siapa.service.generic.GenericService;
import com.siapa.service.DetalleMuestreoService;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author WalterGM
 */
@Named("detallemuestreoManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class DetalleMuestreoManagedBean extends GenericManagedBean<DetalleMuestreo, Integer> {

    @Autowired
    @Qualifier(value = "DetalleMuestreoService")
    private DetalleMuestreoService detallemuestreoService;

    @Autowired
    @Qualifier(value = "muestreoService")
    private MuestreoService muestreoService;

    private DetalleMuestreo detallemuestreo;
    private Muestreo muestreo;
    private List<Muestreo> listMuestreo;
    
     @PostConstruct
    public void init() {
        loadLazyModels();
        detallemuestreo = new DetalleMuestreo();
        listMuestreo=muestreoService.findAll();
    }

    @Override
    public GenericService<DetalleMuestreo, Integer> getService() {
         return detallemuestreoService;
    }
    
    @Override
    public LazyDataModel<DetalleMuestreo> getNewLazyModel() {
        return new DetalleMuestreoLazyModel(detallemuestreoService);
    }

    public void toCreateDetalleMuestreo(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            listMuestreo = muestreoService.findAll();
            setSelected(new DetalleMuestreo());
            contex.getExternalContext().redirect("/siapa/views/detalleMuestreo/Create.xhtml");

        } catch (IOException ex) {

        }
    }
    
    @Override
    public void saveNew(ActionEvent event) {
        DetalleMuestreo detallemuestreo=getDetallemuestreo();
        detallemuestreo.setIdMuestreo(muestreo);
        detallemuestreoService.save(detallemuestreo);
         loadLazyModels();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful"));
      
        
    } 
      public void llenar() {
        System.out.println("punto");

    }

    public DetalleMuestreo getDetallemuestreo() {
        return detallemuestreo;
    }

    public void setDetallemuestreo(DetalleMuestreo detallemuestreo) {
        this.detallemuestreo = detallemuestreo;
    }

    public Muestreo getMuestreo() {
        return muestreo;
    }

    public void setMuestreo(Muestreo muestreo) {
        this.muestreo = muestreo;
    }

    public List<Muestreo> getListMuestreo() {
        return listMuestreo;
    }

    public void setListMuestreo(List<Muestreo> listMuestreo) {
        this.listMuestreo = listMuestreo;
    }

}
