/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.GarantiaRealDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Registrogarantiareal;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JosueRogelio
 */
@Service(value = "garantiaRealService")
public class GarantiaRealService extends GenericService<Registrogarantiareal, Integer> {

    @Autowired
    private GarantiaRealDao garantiaRealDao;

    @Override
    public GenericDao<Registrogarantiareal, Integer> getDao() {
        return garantiaRealDao;
    }

    /**
     * Metodo para buscar garantias Reales en base al Identificador de el
     * analisis
     *
     * @param idAnalisis
     * @return List<Registrogarantiareal> que contiene el listado de garantias
     * reales asociadas al analisis de credito de un asociado
     */
    public List<Registrogarantiareal> findGarantiasRealesByAnalisis(Integer idAnalisis) {
        return garantiaRealDao.findGarantiasRealesByAnalisis(idAnalisis);
    }

}
