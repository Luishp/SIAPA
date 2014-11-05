/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Proveedor;
import com.siapa.service.generic.GenericService;

/**
 *
 * @author Joao
 */
public class ProveedorLazyModel extends GenericLazyModel<Proveedor, Integer> {

    public ProveedorLazyModel(GenericService<Proveedor, Integer> service) {
        super(service);
    }

    @Override
    public Proveedor getRowData(String rowKey) {
        for (Proveedor proveedor : getDatasource()) {
            if (proveedor.getIdProveedor().equals(Integer.valueOf(rowKey)));
            return proveedor;
        }
        return null;
    }

    @Override
    public Integer getRowKey(Proveedor element) {
        return element.getIdProveedor();
    }

}
