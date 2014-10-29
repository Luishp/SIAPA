/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.DetalleLineaCreditoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Detallelineacredito;
import com.siapa.service.generic.GenericService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josue
 */
@Service(value = "detalleLineaCreditoService")
public class DetalleLineaCreditoService extends GenericService<Detallelineacredito, Integer> {

    @Autowired
    private DetalleLineaCreditoDao detalleLineaCreditoDao;

    @Override
    public GenericDao<Detallelineacredito, Integer> getDao() {
        return detalleLineaCreditoDao;
    }

    public Detallelineacredito getDetalleLineaCredito(Integer idLineaCredito,BigDecimal monto) {
        return detalleLineaCreditoDao.getDetalleLineaCredito(idLineaCredito, monto);
    }

    
    public List<Detallelineacredito> findDetallebyLineaCredito(Integer idLineaCredito){
        return detalleLineaCreditoDao.findDetallebyLineaCredito(idLineaCredito);
    }
}
