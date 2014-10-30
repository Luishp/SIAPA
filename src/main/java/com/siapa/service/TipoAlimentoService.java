/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.TipoAlimentoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.TipoAlimento;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value="TipoAlimentoService")
public class TipoAlimentoService extends GenericService<TipoAlimento, Long> {
      @Autowired
    private TipoAlimentoDao tipoAlimentoDao;

    @Override
    public GenericDao<TipoAlimento, Long> getDao() {
        return tipoAlimentoDao;
    }
}
