/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.DetalleMuestreo;
import com.siapa.service.generic.GenericService;


/**
 *
 * @author WalterGM
 */
public class DetalleMuestreoLazyModel  extends GenericLazyModel<DetalleMuestreo, Integer>{
    
     public DetalleMuestreoLazyModel(GenericService<DetalleMuestreo, Integer> service) {
        super(service);
    }

    @Override
    public DetalleMuestreo getRowData(String rowKey) {
        for (DetalleMuestreo detallemuestreo : getDatasource()) {
            if (detallemuestreo.getIdDetalleMuestreo().equals(Integer.valueOf(rowKey)));
            return detallemuestreo;
        }
        return null;
    }

    @Override
    public Integer getRowKey(DetalleMuestreo element) {
        return element.getIdDetalleMuestreo();
    }
}
