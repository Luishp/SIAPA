/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.service;

import com.siapa.dao.TipoSolicitudDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Tiposolicitud;
import com.siapa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author JosueRogelio
 */
@Service(value="tipoSolicitudService")
public class TipoSolicitudService extends GenericService<Tiposolicitud, Integer>{

    @Autowired
    private TipoSolicitudDao tipoSolicitudDao;
    
    @Override
    public GenericDao<Tiposolicitud, Integer> getDao() {
        return tipoSolicitudDao;
    }
    
}
