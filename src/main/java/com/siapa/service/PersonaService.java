/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.PersonaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Persona;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value="PersonaService")
public class PersonaService extends GenericService<Persona, Long>{
      @Autowired
    private PersonaDao personaDao;

    @Override
    public GenericDao<Persona, Long> getDao() {
        return personaDao;
    }
}
