/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.ProductoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Producto;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value = "ProductoService")
public class ProductoService extends GenericService<Producto, Long>{
     @Autowired
    private ProductoDao productoDao;

    @Override
    public GenericDao<Producto, Long> getDao() {
        return productoDao;
    }
}
