/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.MuestreoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Muestreo;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value="muestreoService")
public class MuestreoService extends GenericService<Muestreo, Integer>{
     @Autowired
    private MuestreoDao muestreoDao;

    @Override
    public GenericDao<Muestreo, Integer> getDao() {
        return muestreoDao;
    }
}
