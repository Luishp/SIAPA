/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.model.Cliente;
import com.siapa.service.ClienteService;
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

@Named("clienteManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ClienteManagedBean extends GenericManagedBean<Cliente, Long>{

    @Autowired
    @Qualifier(value = "clienteService")
    private ClienteService clienteService;
    
    @Override
    public GenericService<Cliente, Long> getService() {
        return clienteService;
    }

    @Override
    public LazyDataModel<Cliente> getNewLazyModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
