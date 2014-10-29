/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Prestamo;
import com.siapa.service.generic.GenericService;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
public class PrestamoLazyModel extends GenericLazyModel<Prestamo, Integer>{

    public PrestamoLazyModel(GenericService<Prestamo, Integer> service) {
        super(service);
    }

    @Override
    public Prestamo getRowData(String rowKey) {
      for (Prestamo prestamo : getDatasource()) {
            if (prestamo.getPrestamoId().equals(Integer.valueOf(rowKey))) {
                return prestamo;
            }
        }
        return null;
    }

    @Override
    public Integer getRowKey(Prestamo element) {
         return element.getPrestamoId();
    }
    
}
