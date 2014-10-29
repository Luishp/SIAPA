/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Deuda;
import com.siapa.service.generic.GenericService;
import java.io.Serializable;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
public class DeudaLazyModel extends GenericLazyModel<Deuda, Serializable>{

    public DeudaLazyModel(GenericService<Deuda, Serializable> service) {
        super(service);
    }

    @Override
    public Deuda getRowData(String rowKey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Serializable getRowKey(Deuda element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
