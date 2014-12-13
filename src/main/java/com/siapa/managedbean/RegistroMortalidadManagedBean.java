/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.RegistroMortalidadLazyModel;
import com.siapa.model.Jaula;
import com.siapa.model.RegistroMortalidad;
import com.siapa.service.JaulaService;
import com.siapa.service.RegistroMortalidadService;
import com.siapa.service.generic.GenericService;
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
 * @author Jarvis
 */
@Named("registroMortalidadManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class RegistroMortalidadManagedBean extends GenericManagedBean<RegistroMortalidad, Integer> {

    @Autowired
    @Qualifier(value = "RegistroMortalidadService")
    private RegistroMortalidadService registroMortalidadService;

    @Autowired
    @Qualifier(value = "jaulaService")
    private JaulaService jaulaService;

    private Jaula jaula;
    private RegistroMortalidad registroMortalidad;
    private List<Jaula> jaulas;

    public RegistroMortalidadService getRegistroMortalidadService() {
        return registroMortalidadService;
    }

    public void setRegistroMortalidadService(RegistroMortalidadService registroMortalidadService) {
        this.registroMortalidadService = registroMortalidadService;
    }

    public JaulaService getJaulaService() {
        return jaulaService;
    }

    public void setJaulaService(JaulaService jaulaService) {
        this.jaulaService = jaulaService;
    }

    public Jaula getJaula() {
        return jaula;
    }

    public void setJaula(Jaula jaula) {
        this.jaula = jaula;
    }

    public RegistroMortalidad getRegistroMortalidad() {
        return registroMortalidad;
    }

    public void setRegistroMortalidad(RegistroMortalidad registroMortalidad) {
        this.registroMortalidad = registroMortalidad;
    }

    public List<Jaula> getJaulas() {
        return jaulas;
    }

    public void setJaulas(List<Jaula> jaulas) {
        this.jaulas = jaulas;
    }

    @PostConstruct
    public void init() {
        loadLazyModels();
        jaulas = jaulaService.findAll();
        registroMortalidad = new RegistroMortalidad();
    }

    @Override
    public GenericService<RegistroMortalidad, Integer> getService() {
        return registroMortalidadService;
    }

    @Override
    public LazyDataModel<RegistroMortalidad> getNewLazyModel() {
        return new RegistroMortalidadLazyModel(registroMortalidadService);
    }

    public void toCreateRegistroMortalidad(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            jaulas = jaulaService.findAll();
            setSelected(new RegistroMortalidad());
            contex.getExternalContext().redirect("/siapa/views/registroMortalidad/Create.xhtml");
        } catch (IOException ex) {
            //   log.error("Error al rederigir a la pagina de asesoria", null, ex);
        }
    }

    public void llenar() {
        //System.out.println("punto");

    }

    @Override
    public void saveNew(ActionEvent event) {

        RegistroMortalidad registroMortalidad = getRegistroMortalidad();
        registroMortalidad.setIdJaula(jaula);
        registroMortalidad.setUsuarioRegistroMortalidad(getUsuario());
        registroMortalidadService.save(registroMortalidad);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Insercion realizada"));
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/siapa/views/registroMortalidad/index.xhtml");
        } catch (IOException ex) {
            //   log.error("Error al rederigir a la pagina de asesoria", null, ex);
        }

    }

}