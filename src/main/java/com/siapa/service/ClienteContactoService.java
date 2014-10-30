/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.ClienteContactoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.ClienteContacto;
import com.siapa.model.ClienteContactoPK;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */

@Service(value="ClienteContactoService")
public class ClienteContactoService extends GenericService<ClienteContacto, ClienteContactoPK> {
     @Autowired
    private ClienteContactoDao clienteContactoDao;
   
    @Override
    public GenericDao<ClienteContacto, ClienteContactoPK> getDao() {
        return clienteContactoDao;
    }
}
