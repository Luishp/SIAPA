/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Alimento;
import com.siapa.service.generic.GenericService;

/**
 *
 * @author Joao
 */
public class AlimentoLazyModel extends GenericLazyModel<Alimento, Long> {

    public AlimentoLazyModel(GenericService<Alimento, Long> service) {
        super(service);
    }

    @Override
    public Alimento getRowData(String rowKey) {
        for (Alimento alimento : getDatasource()) {
            if(alimento.getIdAlimento().equals(Long.valueOf(rowKey)));
            return alimento;
        }
        return null;
    }

    @Override
    public Long getRowKey(Alimento element) {
        return element.getIdAlimento();
    }

}
