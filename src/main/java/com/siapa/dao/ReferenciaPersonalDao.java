package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Referenciapersonal;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Repository(value = "referenciaPersonalDao")
public class ReferenciaPersonalDao extends GenericDao<Referenciapersonal, Integer> {

    public List<Referenciapersonal> findAllReferenciasPersonalesBySolicitud(Integer idSolicitud) {
        Query q = getSessionFactory()
                .getCurrentSession()
                .createQuery("SELECT rp FROM Referenciapersonal rp WHERE rp.solicitudId.solicitudId = " + idSolicitud);
        
        return q.list();
    }
    
    
}
