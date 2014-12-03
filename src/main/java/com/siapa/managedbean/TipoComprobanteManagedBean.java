/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.model.Alimento;
import com.siapa.model.TipoComprobante;
import com.siapa.service.AlimentoService;
import com.siapa.service.TipoComprobanteService;
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
@Named("tipoComprobanteManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)


   
public class TipoComprobanteManagedBean extends GenericManagedBean<TipoComprobante, Integer>{

    @Autowired
    @Qualifier(value = "tipoComprobanteService")
    private TipoComprobanteService tipoComprobanteService;
    
    
    @Override
    public GenericService<TipoComprobante, Integer> getService() {
        return tipoComprobanteService;
    }

    @Override
    public LazyDataModel<TipoComprobante> getNewLazyModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
