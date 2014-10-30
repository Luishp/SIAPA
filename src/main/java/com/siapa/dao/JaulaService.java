/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Jaula;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value="JaulaService")
public class JaulaService extends GenericService<Jaula, Long>{
     @Autowired
    private JaulaDao jaulaDao;

    @Override
    public GenericDao<Jaula, Long> getDao() {
        return jaulaDao;
    }
}
