package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Desembolso;
import com.siapa.service.generic.GenericService;

public class DesembolsoLazyModel extends GenericLazyModel<Desembolso, Integer> {

    public DesembolsoLazyModel(GenericService<Desembolso, Integer> service) {
        super(service);
    }

    @Override
    public Desembolso getRowData(String rowKey) {
        for (Desembolso desembolso : getDatasource()) {
            if (desembolso.getDesembolsoId().equals(Integer.valueOf(rowKey))) {
                return desembolso;
            }
        }
        return null;
    }

    @Override
    public Integer getRowKey(Desembolso element) {
        return element.getDesembolsoId();
    }

}
