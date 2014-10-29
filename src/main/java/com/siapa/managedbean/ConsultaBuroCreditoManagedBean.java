/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.model.Consultaburocredito;
import com.siapa.service.ConsultaBuroCreditoService;
import com.siapa.service.generic.GenericService;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author JosueRogelio
 */
@Named("ConsultaBCoManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ConsultaBuroCreditoManagedBean extends GenericManagedBean<Consultaburocredito, Integer>{

    @Autowired
    private ConsultaBuroCreditoService consultaBuroCreditoService;
    
    
    @Override
    public GenericService<Consultaburocredito, Integer> getService() {
      return consultaBuroCreditoService;
    }

    @Override
    public LazyDataModel<Consultaburocredito> getNewLazyModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
