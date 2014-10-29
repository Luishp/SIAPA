/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.service;

import com.siapa.dao.GarantiaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Garantia;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josue
 */
@Service(value="garantiaService")
public class GarantiaService extends GenericService<Garantia, Integer>{

    @Autowired
    private GarantiaDao garantiaDao;
    
    
    @Override
    public GenericDao<Garantia, Integer> getDao() {
        return garantiaDao;
    }
    
}
