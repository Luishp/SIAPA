/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Registrogarantiaprendaria;
import com.siapa.service.generic.GenericService;

/**
 * 
 * @author Cristian Oswaldo Fuentes
 */
public class GarantiaPrendariaLazyModel extends GenericLazyModel<Registrogarantiaprendaria, Integer>{

    public GarantiaPrendariaLazyModel(GenericService<Registrogarantiaprendaria, Integer> service) {
        super(service);
    }

    @Override
    public Registrogarantiaprendaria getRowData(String rowKey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getRowKey(Registrogarantiaprendaria element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
