/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.MuestreoLazyModel;
import com.siapa.model.Jaula;
import com.siapa.model.Muestreo;
import com.siapa.service.JaulaService;
import com.siapa.service.MuestreoService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@Named("muestreoManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class MuestreoManagedBean extends GenericManagedBean<Muestreo, Integer> {

    @Autowired
    @Qualifier(value = "muestreoService")
    private MuestreoService muestreoService;

    @Autowired
    @Qualifier(value = "jaulaService")
    private JaulaService jaulaService;

    private Muestreo muestreo;
    private Jaula jaula;
    private List<Jaula> listJaula;

    @PostConstruct
    public void init() {
        loadLazyModels();
        muestreo = new Muestreo();
    }

    @Override
    public GenericService<Muestreo, Integer> getService() {
        return muestreoService;
    }

    @Override
    public LazyDataModel<Muestreo> getNewLazyModel() {
        return new MuestreoLazyModel(muestreoService);
    }

    public void toCreateMuestreo(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            listJaula = jaulaService.findAllActives();
            setSelected(new Muestreo());
            contex.getExternalContext().redirect("/siapa/views/muestreo/Create.xhtml");

        } catch (IOException ex) {

        }
    }
     
    

    @Override
    public void saveNew(ActionEvent event) {
        Muestreo muestreo = getMuestreo();
        muestreo.setIdJaula(jaula);
        muestreo.setUsuarioMuestreo(getUsuario());
        muestreo.setFechaRegistroMuestreo(new Date());
        muestreo.setPesoPromedioMuestreo(BigDecimal.ZERO);
        muestreoService.save(muestreo);
        loadLazyModels();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful"));
        try{
          FacesContext context1 = FacesContext.getCurrentInstance();
          context1.getExternalContext().redirect("/siapa/views/muestreo/index.xhtml");  
        }
        catch(IOException e)
        {
            
        }
    }

    public Jaula getJaula() {
        return jaula;
    }

    public void setJaula(Jaula jaula) {
        this.jaula = jaula;
    }

    public List<Jaula> getListJaula() {
        return listJaula;
    }

    public void setListJaula(List<Jaula> listJaula) {
        this.listJaula = listJaula;
    }

    public Muestreo getMuestreo() {
        return muestreo;
    }

    public void setMuestreo(Muestreo muestreo) {
        this.muestreo = muestreo;
    }

}
