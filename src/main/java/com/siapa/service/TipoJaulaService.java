/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.TipoJaulaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.TipoJaula;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value="TipoJaulaService")
public class TipoJaulaService extends GenericService<TipoJaula, Long> {
      @Autowired
    private TipoJaulaDao tipoJaulaDao;

    @Override
    public GenericDao<TipoJaula, Long> getDao() {
        return tipoJaulaDao;
    }
}
