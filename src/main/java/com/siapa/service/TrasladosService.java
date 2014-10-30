/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.TrasladosDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Traslados;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value="TrasladosService")
public class TrasladosService extends GenericService<Traslados, Long> {
     @Autowired
    private TrasladosDao trasladosDao;

    @Override
    public GenericDao<Traslados, Long> getDao() {
        return trasladosDao;
    }
}
