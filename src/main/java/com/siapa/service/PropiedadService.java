/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.service;

import com.siapa.dao.PropiedadDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Propiedad;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Service(value = "propiedadService")
public class PropiedadService extends GenericService<Propiedad, Integer> {

    @Autowired
    private PropiedadDao propiedadDao;
        
    @Override
    public GenericDao<Propiedad, Integer> getDao() {
           return propiedadDao;
    }
    
    public List<Propiedad> findAllPropiedadesBySolicitud(Integer idSolicitud) {
        return propiedadDao.findAllPropiedadesBySolicitud(idSolicitud);
    }
    
    

}
