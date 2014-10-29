/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.service;

import com.siapa.dao.RequisitoLineaCreditoNegocioDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Requisitolineacreditonegocio;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josue
 */
@Service(value="requisitoLineaCreditoNegocioService")
public class RequisitoLineaCreditoNegocioService extends GenericService<Requisitolineacreditonegocio, Integer>{
    
    
    @Autowired 
    private RequisitoLineaCreditoNegocioDao requisitoLineaCreditoNegocioDao;

    @Override
    public GenericDao<Requisitolineacreditonegocio, Integer> getDao() {
        return requisitoLineaCreditoNegocioDao;
    }
    
    public List<Requisitolineacreditonegocio> findRequisitosByIdLineaCredito(Integer idLineaCredito){
        return requisitoLineaCreditoNegocioDao.findRequisitosByIdLineaCredito(idLineaCredito);
    }
}
