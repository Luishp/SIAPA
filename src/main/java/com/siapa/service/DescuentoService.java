/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.DescuentoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Descuento;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value="DescuentoService")
public class DescuentoService extends GenericService<Descuento, Long>{
    @Autowired
    private DescuentoDao descuentoDao;

    @Override
    public GenericDao<Descuento, Long> getDao() {
        return descuentoDao;
    }
}
