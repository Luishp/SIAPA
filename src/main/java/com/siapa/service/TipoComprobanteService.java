/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.TipoComprobanteDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.TipoComprobante;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */
@Service(value = "TipoComprobanteService")
public class TipoComprobanteService extends GenericService<TipoComprobante, Long> {

    @Autowired
    private TipoComprobanteDao tipoComprobanteDao;

    @Override
    public GenericDao<TipoComprobante, Long> getDao() {
        return tipoComprobanteDao;
    }
}
