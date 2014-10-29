/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.service;

import com.siapa.dao.LineaCreditoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Lineacredito;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josue
 */
@Service(value="lineaCreditoService")
public class LineaCreditoService extends GenericService<Lineacredito, Integer>{

    @Autowired
    private LineaCreditoDao lineaCreditoDao;
    
    
    @Override
    public GenericDao<Lineacredito, Integer> getDao() {
       return lineaCreditoDao;
    }
    
    public List<Lineacredito> findAllActives() {
        return lineaCreditoDao.findAllActives();
    }
    
    public List<Lineacredito> findAllLC(){
        return lineaCreditoDao.findAllLC();
    }
    
    public Lineacredito findAllDet(Integer LineacreditoId){
        return lineaCreditoDao.findAllDet(LineacreditoId);
    }
    
}
