/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.TipoAlimentoLazyModel;
import com.siapa.model.TipoAlimento;
import com.siapa.service.TipoAlimentoService;
import com.siapa.service.generic.GenericService;
import java.io.Serializable;
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

@Named("tipoAlimentoManageBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class TipoAlimentoManageBean extends GenericManagedBean<TipoAlimento, Integer>{

    
    @Autowired
    @Qualifier(value = "tipoAlimentoService")
    private TipoAlimentoService tipoAlimentoService;
    
    
    @PostConstruct
    public void init() {
        loadLazyModels();
    }
    
    @Override
    public GenericService<TipoAlimento, Integer> getService() {
        return tipoAlimentoService;
    }

    @Override
    public LazyDataModel<TipoAlimento> getNewLazyModel() {
        return new TipoAlimentoLazyModel(tipoAlimentoService);
    }
    
    
}
