package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.TipoAlimento;
import com.siapa.service.generic.GenericService;

/**
 *
 * @author Joao
 */
public class TipoAlimentoLazyModel extends GenericLazyModel<TipoAlimento, Integer> {

    public TipoAlimentoLazyModel(GenericService<TipoAlimento, Integer> service) {
        super(service);
    }

    @Override
    public TipoAlimento getRowData(String rowKey) {
        for (TipoAlimento tipoalimento : getDatasource()) {
            if (tipoalimento.getIdTipoAlimento().equals(Integer.valueOf(rowKey)));
            return tipoalimento;
        }
        return null;
    }

    @Override
    public Integer getRowKey(TipoAlimento element) {
        return element.getIdTipoAlimento();
    }

}
