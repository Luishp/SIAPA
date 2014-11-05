/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.ProveedorDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Proveedor;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value = "proveedorService")
public class ProveedorService extends GenericService<Proveedor, Integer> {

    @Autowired
    private ProveedorDao proveedorDao;

    @Override
    public GenericDao<Proveedor, Integer> getDao() {
        return proveedorDao;
    }
}
