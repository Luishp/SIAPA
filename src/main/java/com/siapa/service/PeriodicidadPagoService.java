/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.service;

import com.siapa.dao.PeriodicidadPagoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Periodicidadpago;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Service(value="periodicidadPagoService")
public class PeriodicidadPagoService extends GenericService<Periodicidadpago, Integer> {

    @Autowired
    private PeriodicidadPagoDao periodicidadPagoDao;
        
    @Override
    public GenericDao<Periodicidadpago, Integer> getDao() {
       return periodicidadPagoDao;
    }
    
}
