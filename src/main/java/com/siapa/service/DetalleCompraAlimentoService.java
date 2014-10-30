/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.DetalleCompraAlimentoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.DetalleCompraAlimento;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */

@Service(value="DetalleCompraAlimentoService")
public class DetalleCompraAlimentoService extends GenericService<DetalleCompraAlimento, Long>{
    @Autowired
    private DetalleCompraAlimentoDao detalleCompraAlimentoDao;

    @Override
    public GenericDao<DetalleCompraAlimento, Long> getDao() {
        return detalleCompraAlimentoDao;
    }
}
