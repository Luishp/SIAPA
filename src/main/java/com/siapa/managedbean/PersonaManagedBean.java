/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.PersonaLazyModel;
import com.siapa.model.Persona;
import com.siapa.service.PersonaService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import javax.annotation.PostConstruct;
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
 * @author Joao
 */
@Named("personaManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class PersonaManagedBean extends GenericManagedBean<Persona, Integer> {

    @Autowired
    @Qualifier(value = "personaService")
    private PersonaService personaService;

    @PostConstruct
    public void init() {
        loadLazyModels();
    }

    @Override
    public GenericService<Persona, Integer> getService() {
        return personaService;
    }

    @Override
    public LazyDataModel<Persona> getNewLazyModel() {
        return new PersonaLazyModel(personaService);
    }
    
     public void toCreatePersona() {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();       
            setSelected(new Persona());
            contex.getExternalContext().redirect("/siapa/views/persona/index.xhtml");
        } catch (IOException ex) {
         //   log.error("Error al rederigir a la pagina de asesoria", null, ex);
        }
    }

}
