/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Descuento;
import com.siapa.service.generic.GenericService;

/**
 *
 * @author Jarvis
 */
public class DescuentoLazyModel extends GenericLazyModel<Descuento , Integer>{
    
      public DescuentoLazyModel(GenericService<Descuento, Integer> service) {
        super(service);
    }

    @Override
    public Descuento getRowData(String rowKey) {
        for (Descuento descuento : getDatasource()) {
            if (descuento.getIdDescuento().equals(Integer.valueOf(rowKey)));
            return descuento;
        }
        return null;
    }

    @Override
    public Integer getRowKey(Descuento element) {
          return element.getIdDescuento();
    }
}
