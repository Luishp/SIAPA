/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.ClienteLazyModel;
import com.siapa.model.Cliente;
import com.siapa.model.Persona;
import com.siapa.service.ClienteService;
import com.siapa.service.PersonaService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import java.util.List;
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
@Named("clienteManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ClienteManagedBean extends GenericManagedBean<Cliente, Integer> {

    @Autowired
    @Qualifier(value = "clienteService")
    private ClienteService clienteService;
    
    @Autowired
    @Qualifier(value = "personaService")
    private PersonaService personaService;
    
    private Persona persona;
    
    private List<Persona> personas;

    @PostConstruct
    public void init() {
        loadLazyModels();
    }

    @Override
    public GenericService<Cliente, Integer> getService() {
        return clienteService;
    }

    @Override
    public LazyDataModel<Cliente> getNewLazyModel() {
        return new ClienteLazyModel(clienteService);
    }

    public void toCreateCliente(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            personas=personaService.findAll();
            contex.getExternalContext().redirect("/siapa/views/cliente/Create.xhtml");
        } catch (IOException ex) {
         //   log.error("Error al rederigir a la pagina de asesoria", null, ex);
        }
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
}
