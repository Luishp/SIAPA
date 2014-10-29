/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Promocion;
import com.siapa.service.generic.GenericService;

/**
 *
 * @author monte
 */
public class PromocionLazyModel extends GenericLazyModel<Promocion, Integer> {

    public PromocionLazyModel(GenericService<Promocion, Integer> service) {
        super(service);
    }

    @Override
    public Promocion getRowData(String rowKey) {
        for (Promocion promocion : getDatasource()) {
            if (promocion.getPromocionId().equals(Integer.valueOf(rowKey))) {
                return promocion;
            }
        }
        return null;
    }

    @Override
    public Integer getRowKey(Promocion element) {
        return element.getPromocionId();
    }

}
