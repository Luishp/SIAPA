/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.DetalleVentaDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.DetalleVenta;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value="DetalleVentaService")
public class DetalleVentaService extends GenericService<DetalleVenta, Long> {
      @Autowired
    private DetalleVentaDao detalleVentaDao;

    @Override
    public GenericDao<DetalleVenta, Long> getDao() {
        return detalleVentaDao;
    }
}
