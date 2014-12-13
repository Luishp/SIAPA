/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.DetalleMuestreoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.DetalleMuestreo;
import com.siapa.service.generic.GenericService;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value = "DetalleMuestreoService")
public class DetalleMuestreoService extends GenericService<DetalleMuestreo, Integer> {

    @Autowired
    private DetalleMuestreoDao detalleMuestreoDao;

    @Override
    public GenericDao<DetalleMuestreo, Integer> getDao() {
        return detalleMuestreoDao;
    }

    public BigInteger cantidad(Integer i) {
        return detalleMuestreoDao.cantidad(i);
    }
    public BigDecimal sumatoria(Integer i){
        return detalleMuestreoDao.sumatoria(i);
    }
 
}
