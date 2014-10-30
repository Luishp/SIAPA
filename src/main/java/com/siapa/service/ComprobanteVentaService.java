/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.ComprobanteVentaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.ComprobanteVenta;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */

@Service(value="ComprobanteVentaService")
public class ComprobanteVentaService extends GenericService<ComprobanteVenta, Long>{
     @Autowired
    private ComprobanteVentaDao comprobanteVentaDao;

    @Override
    public GenericDao<ComprobanteVenta, Long> getDao() {
        return comprobanteVentaDao;
    }
}
