/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Sucursal;
import com.siapa.service.generic.GenericService;


public class SucursalLazyModel  extends GenericLazyModel<Sucursal, Integer>{

    public SucursalLazyModel(GenericService<Sucursal, Integer> service) {
        super(service);
    }

    @Override
    public Sucursal getRowData(String rowKey) {
        for (Sucursal sucursal : getDatasource()) {
            if (sucursal.getSucursalId().equals(Integer.valueOf(rowKey))) {
                return sucursal;
            }
        }
        return null;
    }

    @Override
    public Integer getRowKey(Sucursal element) {
        return element.getSucursalId();
    }
    
}
