package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Referenciafamiliar;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Repository(value = "referenciaFamiliarDao")
public class ReferenciaFamiliarDao extends GenericDao<Referenciafamiliar, Integer> {

    public List<Referenciafamiliar> findAllReferenciasFamiliaresBySolicitud(Integer idSolicitud) {
        Query q = getSessionFactory()
                .getCurrentSession()
                .createQuery("SELECT rf FROM Referenciafamiliar rf WHERE rf.solicitudId.solicitudId = " + idSolicitud);
        
        return q.list();
    }
    
    
}
