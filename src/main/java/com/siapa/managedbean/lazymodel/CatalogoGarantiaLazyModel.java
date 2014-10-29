/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Garantia;
import com.siapa.service.CatalogoGarantiaService;
import com.siapa.service.generic.GenericService;
import java.io.Serializable;

/**
 *
 * @author Josue
 */
public class CatalogoGarantiaLazyModel extends GenericLazyModel<Garantia, Integer> {

    public CatalogoGarantiaLazyModel(GenericService<Garantia, Integer> service) {
        super(service);
    }

    
    @Override
    public Garantia getRowData(String rowKey) {
        for (Garantia garantia : getDatasource()) {
            if (garantia.getGarantiaId().equals(Integer.valueOf(rowKey))) {
                return garantia;
            }
        }
        return null;
    }

    
    @Override
    public Integer getRowKey(Garantia element) {
        return element.getGarantiaId();
    }

    

}
