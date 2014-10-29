/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.service;

import com.siapa.dao.RequisitoLineaCreditoEmpleadoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Requisitolineacreditoempleado;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josue
 */
@Service(value="requisitoLineaCreditoEmpleadoService")
public class RequisitoLineaCreditoEmpleadoService extends GenericService<Requisitolineacreditoempleado, Integer>{
    
    @Autowired 
    private RequisitoLineaCreditoEmpleadoDao requisitoLineaCreditoEmpleadoDao;

    @Override
    public GenericDao<Requisitolineacreditoempleado, Integer> getDao() {
        return requisitoLineaCreditoEmpleadoDao;
    }

    public List<Requisitolineacreditoempleado> findRequisitosByIdEmpleado(Integer idLineaCredito){
        return requisitoLineaCreditoEmpleadoDao.findRequisitosByIdLineaCredito(idLineaCredito);
    }
          
}
