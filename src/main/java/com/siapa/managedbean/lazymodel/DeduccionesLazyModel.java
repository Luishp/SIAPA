/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Deducciones;
import com.siapa.service.generic.GenericService;


/**
 *
 * @author Josue
 */
public class DeduccionesLazyModel extends GenericLazyModel<Deducciones, Integer>{

    public DeduccionesLazyModel(GenericService<Deducciones, Integer> service) {
        super(service);
    }

    @Override
    public Deducciones getRowData(String rowKey) {
        for (Deducciones deducciones : getDatasource()) {
            if (deducciones.getDeduccionesId().equals(Integer.valueOf(rowKey))) {
                return deducciones;
            }
        }
        return null;
        
    }

    @Override
    public Integer getRowKey(Deducciones element) {
        return element.getDeduccionesId();
    }
    
    
}
