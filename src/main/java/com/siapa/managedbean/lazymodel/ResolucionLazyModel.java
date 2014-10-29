package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.Resolucion;
import com.siapa.service.generic.GenericService;

public class ResolucionLazyModel extends GenericLazyModel<Resolucion, Integer> {

    public ResolucionLazyModel(GenericService<Resolucion, Integer> service) {
        super(service);
    }

    @Override
    public Resolucion getRowData(String rowKey) {
        for (Resolucion resolucion : getDatasource()) {
            if (resolucion.getResolucionId().equals(Integer.valueOf(rowKey))) {
                return resolucion;
            }
        }
        return null;
    }

    @Override
    public Integer getRowKey(Resolucion element) {
        return element.getResolucionId();
    }

}
