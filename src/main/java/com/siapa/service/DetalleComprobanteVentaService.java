/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.DetalleComprobanteVentaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.DetalleComprobanteVenta;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value="DetalleComprobanteVentaService")
public class DetalleComprobanteVentaService extends GenericService<DetalleComprobanteVenta, Long>{
     @Autowired
    private DetalleComprobanteVentaDao detalleComprobanteVentaDao;

    @Override
    public GenericDao<DetalleComprobanteVenta, Long> getDao() {
        return detalleComprobanteVentaDao;
    }
}
