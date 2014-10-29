/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Prestamofinanciero;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Repository(value = "prestamoFinancieroDao")
public class PrestamoFinancieroDao extends GenericDao<Prestamofinanciero, Integer> {

    
    
    public List<Prestamofinanciero> findPrestamosFinancierosBySolicitud(Integer idSolicitud) {

        Query q = getSessionFactory().getCurrentSession()
                .createQuery("Select pf From Prestamofinanciero pf where pf.solicitudId.solicitudId = :idSolicitud");
                    q.setParameter("idSolicitud", idSolicitud);
        return q.list();
    }
}
