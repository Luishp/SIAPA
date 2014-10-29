/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.TipoResolucionDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Tiporesolucion;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Angel
 */
@Service(value = "tipoResolucionService")
public class TipoResolucionService extends GenericService<Tiporesolucion, Integer> {

    @Autowired
    private TipoResolucionDao tipoResolucionDao;

    @Override
    public GenericDao<Tiporesolucion, Integer> getDao() {
        return tipoResolucionDao;
    }

    public List<Tiporesolucion> findAllActives() {
        return tipoResolucionDao.findAllActives();
    }

    public Tiporesolucion findTipoResolucion(Integer tiporesolucionId) {
        Tiporesolucion tr = tipoResolucionDao.findTipoResolucion(tiporesolucionId);
        tr.setAnalisisenagendacomitecreditosList(null);
        tr.setResolucionList(null);
        return tr;
    }

}
