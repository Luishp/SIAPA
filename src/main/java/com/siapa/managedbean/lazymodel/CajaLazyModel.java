package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Caja;
import com.siapa.service.generic.GenericService;
import java.io.Serializable;

public class CajaLazyModel extends GenericLazyModel<Caja, Integer> {

    public CajaLazyModel(GenericService<Caja, Integer> service) {
        super(service);
    }

    @Override
    public Caja getRowData(String rowKey) {
       for (Caja caja : getDatasource()) {
            if (caja.getCajaId().equals(Integer.valueOf(rowKey))) {
                return caja;
            }
        }
        return null;
    }

    @Override
    public Integer getRowKey(Caja element) {
        return element.getCajaId();
    }

}
