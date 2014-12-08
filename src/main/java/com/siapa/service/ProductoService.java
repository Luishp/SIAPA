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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value = "productoService")
public class ProductoService extends GenericService<Producto, Integer>{
     @Autowired
    private ProductoDao productoDao;

    @Override
    public GenericDao<Producto, Integer> getDao() {
        return productoDao;
    }
    
    public List<Producto> getProducto() {
        return productoDao.getProducto();
    }
    
    
}
