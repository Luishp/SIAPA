/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.IngresoProductoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.IngresoProducto;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value="IngresoProductoService")
public class IngresoProductoService extends GenericService<IngresoProducto, Integer> {
    @Autowired
    private IngresoProductoDao ingresoProductoDao;

    @Override
    public GenericDao<IngresoProducto, Integer> getDao() {
        return ingresoProductoDao;
    } 
}
