package com.siapa.service;

import com.siapa.dao.ReferenciaPersonalDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Referenciapersonal;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Service(value = "referenciaPersonalService")
public class ReferenciaPersonalService extends GenericService<Referenciapersonal, Integer> {

    @Autowired
    private ReferenciaPersonalDao referenciaPersonalDao;
        
    @Override
    public GenericDao<Referenciapersonal, Integer> getDao() {
           return referenciaPersonalDao;
    }
    
    public List<Referenciapersonal> findAllReferenciasPersonalesBySolicitud(Integer idSolicitud) {
        return referenciaPersonalDao.findAllReferenciasPersonalesBySolicitud(idSolicitud);
    }
    
    

}
