/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.managedbean.lazymodel;

import com.siapa.managedbean.lazymodel.generic.GenericLazyModel;
import com.siapa.model.SsUsuarios;
import com.siapa.service.generic.GenericService;

/**
 *
 * @author Josue
 */
public class UsuarioLazyModel extends GenericLazyModel<SsUsuarios, Integer>{

    public UsuarioLazyModel(GenericService<SsUsuarios, Integer> service) {
        super(service);
    }

    @Override
    public SsUsuarios getRowData(String rowKey) {
         for (SsUsuarios ssusuarios : getDatasource()) {
            if (ssusuarios.getIdUsuario().equals(Integer.valueOf(rowKey))) {
                return ssusuarios;
            }
        }
        return null;
    }

    @Override
    public Integer getRowKey(SsUsuarios element) {
        return element.getIdUsuario();
    }
    
}
