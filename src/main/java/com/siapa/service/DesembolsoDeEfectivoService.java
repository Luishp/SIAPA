/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.DesembolsoDeEfectivoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Efectivo;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Angel
 */
@Service(value = "desembolsoDeEfectivoService")
public class DesembolsoDeEfectivoService extends GenericService<Efectivo, Integer> {

    @Autowired
    private DesembolsoDeEfectivoDao desembolsoDeEfectivoDao;

    public GenericDao<Efectivo, Integer> getDao() {
        return desembolsoDeEfectivoDao;
    }

    public List<Efectivo> efectivoPendienteDeEntrega() {
        return desembolsoDeEfectivoDao.efectivoPendienteDeEntrega();
    }

}
