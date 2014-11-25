/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.RegistroAlimentacion;
import com.siapa.service.generic.GenericService;

/**
 *
 * @author Jarvis
 */
public class RegistroAlimentacionLazyModel extends GenericLazyModel<RegistroAlimentacion, Integer>{

    public RegistroAlimentacionLazyModel(GenericService<RegistroAlimentacion, Integer> service) {
        super(service);
    }

    @Override
    public RegistroAlimentacion getRowData(String rowKey) {
        for (RegistroAlimentacion registroAlimentacion : getDatasource()) {
            if(registroAlimentacion.getIdRegistroAlimentacion().equals(Integer.valueOf(rowKey)));
            return registroAlimentacion;
        }
        return null;
    }

    @Override
    public Integer getRowKey(RegistroAlimentacion element) {
        return element.getIdRegistroAlimentacion();
    }
    
}
