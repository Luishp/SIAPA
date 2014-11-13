/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Muestreo;
import com.siapa.service.generic.GenericService;



/**
 *
 * @author WalterGM
 */
public class MuestreoLazyModel extends GenericLazyModel<Muestreo, Integer> {
    
     public MuestreoLazyModel(GenericService<Muestreo, Integer> service) {
        super(service);
    }

    @Override
    public Muestreo getRowData(String rowKey) {
        for (Muestreo muestreo : getDatasource()) {
            if (muestreo.getIdMuestreo().equals(Integer.valueOf(rowKey)));
            return muestreo;
        }
        return null;
    }

    @Override
    public Integer getRowKey(Muestreo element) {
        return element.getIdMuestreo();
    }
}

