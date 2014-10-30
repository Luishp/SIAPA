/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.VentaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Venta;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value="VentaService")
public class VentaService extends GenericService<Venta, Long>{
    @Autowired
    private VentaDao ventaDao;

    @Override
    public GenericDao<Venta, Long> getDao() {
        return ventaDao;
    }
}
