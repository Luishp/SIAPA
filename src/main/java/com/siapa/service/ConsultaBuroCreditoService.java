/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.service;

import com.siapa.dao.ConsultaBuroCreditoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Consultaburocredito;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JosueRogelio
 */
@Service(value = "consultaBuroCreditoService")
public class ConsultaBuroCreditoService extends GenericService<Consultaburocredito, Integer>{

    @Autowired
    private ConsultaBuroCreditoDao consultaBuroCreditoDao;
    
    @Override
    public GenericDao<Consultaburocredito, Integer> getDao() {
        return consultaBuroCreditoDao;
    }
    
    
    public List<Consultaburocredito> findBurosByAnalisis(Integer id){
        return consultaBuroCreditoDao.findBuroByAnalisis(id);
    }
    
}
