/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Consultaburocredito;
import com.siapa.service.generic.GenericService;
import java.io.Serializable;

/**
 *
 * @author JosueRogelio
 */
public class ConsultaBuroCreditoLazyModel extends GenericLazyModel<Consultaburocredito, Integer>{

    public ConsultaBuroCreditoLazyModel(GenericService<Consultaburocredito, Integer> service) {
        super(service);
    }

    @Override
    public Consultaburocredito getRowData(String rowKey) {
        for (Consultaburocredito consultaBC : getDatasource()) {
            if (consultaBC.getCbcId().equals(Integer.valueOf(rowKey))) {
                return consultaBC;
            }
        }
        return null;
    }

    @Override
    public Integer getRowKey(Consultaburocredito element) {
       return element.getCbcId();
    }
    
}
