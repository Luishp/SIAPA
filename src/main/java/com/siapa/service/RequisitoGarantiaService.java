/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.service;

import com.siapa.dao.RequisitoGarantiaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Requisitogarantia;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josue
 */
@Service(value="requisitoGarantiaService")
public class RequisitoGarantiaService extends GenericService<Requisitogarantia, Integer> {

    @Autowired
    private RequisitoGarantiaDao requisitoGarantiaDao;
    
    
    @Override
    public GenericDao<Requisitogarantia, Integer> getDao() {
        return requisitoGarantiaDao;
    }
    
    
}
