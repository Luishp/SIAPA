/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;


import com.siapa.dao.CajaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Caja;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "cajaService")
public class CajaService extends GenericService<Caja, Integer> {

    @Autowired
    private CajaDao cajaDao;

    @Override
    public GenericDao<Caja, Integer> getDao() {
        return cajaDao;
    }
    
    public List<Caja> findAllActives() {
        return cajaDao.findAllActives();
    }

}
