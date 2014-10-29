/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.AhorroDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Ahorro;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JosueRogelio
 */
@Service(value = "ahorroService")
public class AhorroService extends GenericService<Ahorro, Integer> {
    
    @Autowired
    private AhorroDao ahorroDao;
    
    @Override
    public GenericDao<Ahorro, Integer> getDao() {
        return ahorroDao;
    }
    
    public List<Ahorro> findAhorroByDesembolso(Integer id) {
        return ahorroDao.findAhorroByDesembolso(id);
    }
    
}
