/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.service;

import com.siapa.dao.PropietarioInmuebleDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.PropietarioinmueblePK;
import com.siapa.model.Propietarioinmueble;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian oswaldo fuentes
 */
@Service(value = "propietarioInmuebleService")
public class PropietarioInmuebleService extends GenericService<Propietarioinmueble, PropietarioinmueblePK>{

    
    @Autowired
    private PropietarioInmuebleDao propietarioInmuebleDao;
    
    @Override
    public GenericDao<Propietarioinmueble, PropietarioinmueblePK> getDao() {
       return propietarioInmuebleDao;
    }
    
    public List<Propietarioinmueble> findByDlcId(Integer dlcId){
       return propietarioInmuebleDao.findByDlcId(dlcId);
     }
    
    
}
