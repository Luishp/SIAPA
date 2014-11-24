/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.RegistroMortalidad;
import com.siapa.service.generic.GenericService;

/**
 *
 * @author Jarvis
 */
public class RegistroMortalidadLazyModel extends GenericLazyModel<RegistroMortalidad, Integer>{

    public RegistroMortalidadLazyModel(GenericService<RegistroMortalidad, Integer> service) {
        super(service);
    }

    @Override
    public RegistroMortalidad getRowData(String rowKey) {
        for (RegistroMortalidad registroMortalidad : getDatasource()) {
            if(registroMortalidad.getIdRegistroMortalidad().equals(Integer.valueOf(rowKey)));
            return registroMortalidad;
        }
        return null;
    }

    @Override
    public Integer getRowKey(RegistroMortalidad element) {
        return element.getIdRegistroMortalidad();
    }
    
}