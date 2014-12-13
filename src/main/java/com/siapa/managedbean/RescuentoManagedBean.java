/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.DescuentoLazyModel;
import com.siapa.model.Descuento;
import com.siapa.service.DescuentoService;
import com.siapa.service.generic.GenericService;
import javax.annotation.PostConstruct;
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
@Named("descuentoManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class RescuentoManagedBean extends GenericManagedBean<Descuento,Integer>{
    
    
    @Autowired
    @Qualifier(value = "descuentoService")
    private DescuentoService descuentoService;

    @PostConstruct
    public void init() {
        loadLazyModels();
    }

    @Override
    public GenericService<Descuento, Integer> getService() {
       return descuentoService;
    }

    @Override
    public LazyDataModel<Descuento> getNewLazyModel() {
        return new DescuentoLazyModel(descuentoService);
    }

    
}
