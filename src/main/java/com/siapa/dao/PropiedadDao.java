/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Propiedad;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Repository(value = "propiedadDao")
public class PropiedadDao extends GenericDao<Propiedad, Integer> {

    public List<Propiedad> findAllPropiedadesBySolicitud(Integer idSolicitud) {
        Query q = getSessionFactory()
                .getCurrentSession()
                .createQuery("SELECT p FROM Propiedad p WHERE p.solicitudId.solicitudId = " + idSolicitud);
        List<Propiedad> propiedades = q.list();
        return propiedades;
    }
    
    
}
