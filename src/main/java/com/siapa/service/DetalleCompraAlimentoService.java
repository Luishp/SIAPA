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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao
 */

@Service(value="detalleCompraAlimentoService")
public class DetalleCompraAlimentoService extends GenericService<DetalleCompraAlimento, Integer>{
    @Autowired
    private DetalleCompraAlimentoDao detalleCompraAlimentoDao;

    @Override
    public GenericDao<DetalleCompraAlimento, Integer> getDao() {
        return detalleCompraAlimentoDao;
    }
     public List<DetalleCompraAlimento> getDetalleCompraAlimento(){
         return detalleCompraAlimentoDao.getDetalleCompraAlimento();
    }
     public List<DetalleCompraAlimento> getDetalleCompraAlimentoAll(){
         return detalleCompraAlimentoDao.getDetalleCompraAlimentoAll();
    }
     
     
}
