/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Efectivo;
import com.siapa.service.generic.GenericService;

/**
 *
 * @author Angel
 */
public class DesembolsoDeEfectivoLazyModel extends GenericLazyModel<Efectivo, Integer> {

    public DesembolsoDeEfectivoLazyModel(GenericService<Efectivo, Integer> service) {
        super(service);
    }

    @Override
    public Efectivo getRowData(String rowKey) {
        for (Efectivo efectivo : getDatasource()) {
            if (efectivo.getEfectivoId().equals(Integer.valueOf(rowKey))) {
                return efectivo;
            }
        }
        return null;
    }

    @Override
    public Integer getRowKey(Efectivo element) {
        return element.getEfectivoId();
    }
}
