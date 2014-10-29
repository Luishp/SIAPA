/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.AnalisisEnAgendaComiteCreditosDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Analisisenagendacomitecreditos;
import com.siapa.model.AnalisisenagendacomitecreditosPK;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author monte
 */
@Service(value = "analisisEnAgendaComiteCreditosService")
public class AnalisisEnAgendaComiteCreditosService extends GenericService<Analisisenagendacomitecreditos, AnalisisenagendacomitecreditosPK> {

    @Autowired
    private AnalisisEnAgendaComiteCreditosDao analisisEnAgendaComiteCreditosDao;

    @Override
    public GenericDao<Analisisenagendacomitecreditos, AnalisisenagendacomitecreditosPK> getDao() {
        return analisisEnAgendaComiteCreditosDao;
    }

    public List<Analisisenagendacomitecreditos> buscarAnalisisEnAgenda(Integer agenda) {
        return analisisEnAgendaComiteCreditosDao.buscarAnalisisEnAgenda(agenda);
    }
  
}
