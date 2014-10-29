/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Lineacredito;
import com.siapa.service.generic.GenericService;

/**
 *
 * @author Josue
 */
public class LineaCreditoLazyModel extends GenericLazyModel<Lineacredito, Integer>{

    public LineaCreditoLazyModel(GenericService<Lineacredito, Integer> service) {
        super(service);
    }

    @Override
    public Lineacredito getRowData(String rowKey) {
        for (Lineacredito lineacredito : getDatasource()) {
            if (lineacredito.getLineacreditoId().equals(Integer.valueOf(rowKey))) {
                return lineacredito;
            }
        }
        return null;
    }

    @Override
    public Integer getRowKey(Lineacredito element) {
        return element.getLineacreditoId();
    }
    
}
