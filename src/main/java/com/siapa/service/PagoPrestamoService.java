/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.PagoPrestamoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Pagoprestamo;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fm
 */
@Service(value = "pagoPrestamoService")
public class PagoPrestamoService extends GenericService<Pagoprestamo, Integer> {

    @Autowired
    private PagoPrestamoDao pagoPrestamoDao;

    @Override
    public GenericDao<Pagoprestamo, Integer> getDao() {
        return pagoPrestamoDao;
    }

}
