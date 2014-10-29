package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Banco;
import com.siapa.service.generic.GenericService;

public class BancoLazyModel extends GenericLazyModel<Banco, Integer> {

    public BancoLazyModel(GenericService<Banco, Integer> service) {
        super(service);
    }

    @Override
    public Banco getRowData(String rowKey) {
        for (Banco banco : getDatasource()) {
            if (banco.getBancoId().equals(Integer.valueOf(rowKey))) {
                return banco;
            }
        }
        return null;
    }

    @Override
    public Integer getRowKey(Banco element) {
        return element.getBancoId();
    }

}
