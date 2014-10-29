/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.service;

import com.siapa.dao.SucursalDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Sucursal;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="sucursalService")
public class SucursalService  extends GenericService<Sucursal, Integer>{

    @Autowired
    private SucursalDao sucursalDao;
    
    @Override
    public GenericDao<Sucursal, Integer> getDao() {
        return sucursalDao;
    }
    
}
