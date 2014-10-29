/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Referenciafamiliar;
import com.siapa.service.generic.GenericService;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
public class ReferanciaFamiliarLazyModel extends GenericLazyModel<Referenciafamiliar, Integer> {

    public ReferanciaFamiliarLazyModel(GenericService<Referenciafamiliar, Integer> service) {
        super(service);
    }

    @Override
    public Referenciafamiliar getRowData(String rowKey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getRowKey(Referenciafamiliar element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
