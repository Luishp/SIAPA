/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Producto;
import com.siapa.service.generic.GenericService;

/**
 *
 * @author Jarvis
 */
public class ProductoLazyModel extends GenericLazyModel<Producto, Integer>{
    public ProductoLazyModel(GenericService<Producto, Integer> service) {
        super(service);
    }

    @Override
    public Producto getRowData(String rowKey) {
        for (Producto producto : getDatasource()) {
            if(producto.getIdProducto().equals(Integer.valueOf(rowKey)));
            return producto;
        }
        return null;
    }

    @Override
    public Integer getRowKey(Producto element) {
        return element.getIdProducto();
    }
    
}
