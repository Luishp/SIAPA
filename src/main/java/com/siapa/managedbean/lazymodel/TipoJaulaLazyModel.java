package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.TipoJaula;
import com.siapa.service.generic.GenericService;

/**
 *
 * @author Joao
 */
public class TipoJaulaLazyModel extends GenericLazyModel<TipoJaula, Integer> {

    public TipoJaulaLazyModel(GenericService<TipoJaula, Integer> service) {
        super(service);
    }

    @Override
    public TipoJaula getRowData(String rowKey) {
        for (TipoJaula tipojaula : getDatasource()) {
            if (tipojaula.getIdTipoJaula().equals(Integer.valueOf(rowKey)));
            return tipojaula;
        }
        return null;
    }

    @Override
    public Integer getRowKey(TipoJaula element) {
        return element.getIdTipoJaula();
    }

}
