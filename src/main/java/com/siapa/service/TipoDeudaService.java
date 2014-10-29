/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.service;

import com.siapa.dao.TipoDeudaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Tipodeuda;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Service(value="tipoDeudaService")
public class TipoDeudaService extends GenericService<Tipodeuda, Integer>{

    @Autowired
    private TipoDeudaDao tipoDeudaDao;
    
    @Override
    public GenericDao<Tipodeuda, Integer> getDao() {
        return tipoDeudaDao;
    }
    
}
