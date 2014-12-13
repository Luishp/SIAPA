/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.JaulaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Jaula;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */ 
@Service(value="jaulaService")
public class JaulaService extends GenericService<Jaula, Integer>{
     @Autowired
    private JaulaDao jaulaDao;

    @Override
    public GenericDao<Jaula, Integer> getDao() {
        return jaulaDao;
    }
    
    public List<Jaula> findAllActives() {
        return jaulaDao.findAll();
    }
    
    
    public Long sumAllJ() {
        return jaulaDao.sumAll();
    }
}
