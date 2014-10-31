/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.model.Persona;
import com.siapa.service.PersonaService;
import com.siapa.service.generic.GenericService;
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
public class PersonaManagedBean extends GenericManagedBean<Persona, Long> {

    @Autowired
    @Qualifier(value = "personaService")
    private PersonaService personaService;

    @Override
    public GenericService<Persona, Long> getService() {
      return personaService;
    }

    @Override
    public LazyDataModel<Persona> getNewLazyModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
