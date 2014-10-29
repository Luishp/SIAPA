/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.DeduccionesDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Deducciones;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josue
 */
@Service(value="deduccionesService")
public class DeduccionesService extends GenericService<Deducciones, Integer> {

    @Autowired
    private DeduccionesDao deduccionesDao;

    @Override
    public GenericDao<Deducciones, Integer> getDao() {
        return deduccionesDao;
    }

}
