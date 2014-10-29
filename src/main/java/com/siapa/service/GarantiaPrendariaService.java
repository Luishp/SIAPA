/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.GarantiaPrendariaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Registrogarantiaprendaria;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JosueRogelio
 */
@Service(value = "garantiaPrendariaService")
public class GarantiaPrendariaService extends GenericService<Registrogarantiaprendaria, Integer> {

    @Autowired
    private GarantiaPrendariaDao garantiaPrendariaDao;

    @Override
    public GenericDao<Registrogarantiaprendaria, Integer> getDao() {
        return garantiaPrendariaDao;
    }
}
