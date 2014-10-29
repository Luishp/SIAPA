/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.service;

import com.siapa.dao.GarantiaExigidaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Garantiaexigida;
import com.siapa.model.GarantiaexigidaPK;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian oswaldo fuentes
 */
@Service(value = "garantiaExigidaService")
public class GarantiaExigidaService extends GenericService<Garantiaexigida, GarantiaexigidaPK>{

    
    @Autowired
    private GarantiaExigidaDao garantiaExigidaDao;
    
    @Override
    public GenericDao<Garantiaexigida, GarantiaexigidaPK> getDao() {
       return garantiaExigidaDao;
    }
    
    public List<Garantiaexigida> findByDlcId(Integer dlcId){
       return garantiaExigidaDao.findByDlcId(dlcId);
     }
    
    
}
