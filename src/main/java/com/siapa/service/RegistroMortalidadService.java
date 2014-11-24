/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.RegistroMortalidadDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.RegistroMortalidad;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value="RegistroMortalidadService")
public class RegistroMortalidadService extends GenericService<RegistroMortalidad, Integer>{
     @Autowired
    private RegistroMortalidadDao registroMortalidadDao;

    @Override
    public GenericDao<RegistroMortalidad, Integer> getDao() {
        return registroMortalidadDao;
    }
    public List<RegistroMortalidad> getRegistroMortalidad(){
         return registroMortalidadDao.getRegistroMortalidad();
    }
}