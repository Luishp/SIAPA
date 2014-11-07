/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.CompraDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Compra;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */

@Service(value="CompraService")
public class CompraService extends GenericService<Compra, Integer>{
     @Autowired
    private CompraDao compraDao;

    @Override
    public GenericDao<Compra, Integer> getDao() {
        return compraDao;
    }
}
