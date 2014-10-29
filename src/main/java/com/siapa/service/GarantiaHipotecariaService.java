/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.service;

import com.siapa.dao.GarantiaHipotecariaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Registrogarantiahipotecaria;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JosueRogelio
 */             
@Service(value="garantiaHipotecariaService")
public class GarantiaHipotecariaService extends GenericService<Registrogarantiahipotecaria, Integer>{
    
    @Autowired
    private GarantiaHipotecariaDao garantiaHipotecariaDao;

    @Override
    public GenericDao<Registrogarantiahipotecaria, Integer> getDao() {
        return garantiaHipotecariaDao;
    }
    
    public List<Registrogarantiahipotecaria> findGarantiasByAnalisis(Integer idAnalisis) {
        return garantiaHipotecariaDao.findGarantiasByIdAnalisis(idAnalisis);
    }
    
    
}
