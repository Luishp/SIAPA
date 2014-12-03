/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.model.Cliente;
import com.siapa.model.DetalleVenta;
import com.siapa.service.ClienteService;
import com.siapa.service.generic.GenericService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
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
@Named("detalleVentaManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class DetalleVentaManagedBean extends GenericManagedBean<DetalleVenta, Integer> {

    @Autowired
    @Qualifier(value = "clienteService")
    private ClienteService clienteService;
    private List<Cliente> clienteList;
    
     @PostConstruct
    public void init() {
         clienteList=clienteService.getCliente();
     }
    
    
    @Override
    public GenericService<DetalleVenta, Integer> getService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LazyDataModel<DetalleVenta> getNewLazyModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }
    
    
    
    
    
    
}
