/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Referenciapersonal;
import com.siapa.service.generic.GenericService;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
public class ReferenciaPersonalLazyModel extends GenericLazyModel<Referenciapersonal, Integer>{

    public ReferenciaPersonalLazyModel(GenericService<Referenciapersonal, Integer> service) {
        super(service);
    }

    @Override
    public Referenciapersonal getRowData(String rowKey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getRowKey(Referenciapersonal element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
