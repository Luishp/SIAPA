/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Prestamo;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Repository(value = "prestamoDao")
public class PrestamoDao extends GenericDao<Prestamo, Integer> {

    public List<Prestamo> findPrestamosByDesembolso(Integer desembolsoId) {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT pres FROM Prestamo pres WHERE pres.desembolsoId.desembolsoId = :p_desembolsoId");
        q.setParameter("p_desembolsoId", desembolsoId);
        return q.list();
    }
    
    public Prestamo fillPrestamo(Prestamo prestamo) {
        Query q = getSessionFactory().
                getCurrentSession().
                createQuery("SELECT p FROM Prestamo p "
                        + "LEFT JOIN FETCH p.desembolsoId desembolsoId "
                        + "LEFT JOIN FETCH desembolsoId.resolucionId resolucionId "
                        + "LEFT JOIN FETCH resolucionId.analisisId analisisId "
                        + "LEFT JOIN FETCH analisisId.solicitudId solicitudId "
                        + "WHERE p.prestamoId = :p_prestamoId");
        q.setParameter("p_prestamoId", prestamo.getPrestamoId());
        return  (Prestamo) q.uniqueResult();
    }
    
    
}
