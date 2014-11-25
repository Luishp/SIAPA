/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.RegistroAlimentacionDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.RegistroAlimentacion;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value="RegistroAlimentacionService")
public class RegistroAlimentacionService extends GenericService<RegistroAlimentacion, Integer>{
     @Autowired
    private RegistroAlimentacionDao registroAlimentacionDao;

    @Override
    public GenericDao<RegistroAlimentacion, Integer> getDao() {
        return registroAlimentacionDao;
    }
}
