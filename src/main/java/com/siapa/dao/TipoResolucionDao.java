/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Tiporesolucion;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Angel
 */
@Repository(value = "tipoResolucionDao")
public class TipoResolucionDao extends GenericDao<Tiporesolucion, Integer> {

    public List<Tiporesolucion> findAllActives() {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT o FROM Tiporesolucion o WHERE o.activo='SI'");
        return q.list();
    }

    public Tiporesolucion findTipoResolucion(Integer tiporesolucionId) {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT o FROM Tiporesolucion o WHERE o.tiporesolucionId=:p_id");
        q.setParameter("p_id", tiporesolucionId);
        return (Tiporesolucion) q.uniqueResult();
    }

}
