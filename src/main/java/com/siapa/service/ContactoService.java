/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.ContactoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Contacto;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value="ContactoService")
public class ContactoService extends GenericService<Contacto, Long>{
        @Autowired
    private ContactoDao contactoDao;

    @Override
    public GenericDao<Contacto, Long> getDao() {
        return contactoDao;
    }
}
