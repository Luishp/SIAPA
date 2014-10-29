/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Pagaduria;
import com.siapa.service.generic.GenericService;


/**
 *
 * @author Josue
 */
public class PagaduriaLazyModel extends GenericLazyModel<Pagaduria, Integer> {

    public PagaduriaLazyModel(GenericService<Pagaduria, Integer> service) {
        super(service);
    }

    @Override
    public Pagaduria getRowData(String rowKey) {
        for (Pagaduria pagaduria : getDatasource()) {
            if (pagaduria.getPagaduriaId().equals(Integer.valueOf(rowKey))) {
                return pagaduria;
            }
        }
        return null;
    }

    @Override
    public Integer getRowKey(Pagaduria element) {
        return element.getPagaduriaId();
    }
    
}
