/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.ClienteDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Cliente;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value="ClienteService")
public class ClienteService extends GenericService<Cliente, Long>{
    
    @Autowired
    private ClienteDao clienteDao;
   
    @Override
    public GenericDao<Cliente, Long> getDao() {
        return clienteDao;
    }
}
