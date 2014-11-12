package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Jaula;
import com.siapa.service.generic.GenericService;


public class JaulaLazyModel extends GenericLazyModel<Jaula, Integer> {

    public JaulaLazyModel(GenericService<Jaula, Integer> service) {
        super(service);
    }

    @Override
    public Jaula getRowData(String rowKey) {
        for (Jaula alimento : getDatasource()) {
            if (alimento.getIdJaula().equals(Integer.valueOf(rowKey)));
            return alimento;
        }
        return null;
    }

    @Override
    public Integer getRowKey(Jaula element) {
        return element.getIdJaula();
    }


}
