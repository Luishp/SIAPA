/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.service;

import com.siapa.dao.TipoDeduccionDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Tipodeduccion;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josue
 */
@Service(value="tipoDeduccionService")
public class TipoDeduccionService extends GenericService<Tipodeduccion, Integer>{

        @Autowired
    private TipoDeduccionDao tipoDevolucionDao;
    
    @Override
    public GenericDao<Tipodeduccion, Integer> getDao() {
      return tipoDevolucionDao;
    }
    
      public List<Tipodeduccion> findAllActives() {
        return tipoDevolucionDao.findAllActives();
    }
    
}
