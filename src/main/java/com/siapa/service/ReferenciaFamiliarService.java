package com.siapa.service;

import com.siapa.dao.ReferenciaFamiliarDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Referenciafamiliar;
import com.siapa.service.generic.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Service(value = "referenciaFamiliarService")
public class ReferenciaFamiliarService extends GenericService<Referenciafamiliar, Integer> {

    @Autowired
    private ReferenciaFamiliarDao referenciaFamiliarDao;
        
    @Override
    public GenericDao<Referenciafamiliar, Integer> getDao() {
           return referenciaFamiliarDao;
    }
    
    public List<Referenciafamiliar> findAllReferenciasFamiliaresBySolicitud(Integer idSolicitud) {
        return referenciaFamiliarDao.findAllReferenciasFamiliaresBySolicitud(idSolicitud);
    }
    
    

}
