/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Ingreso;
import com.siapa.model.IngresoPK;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cristian OswaldoFuentes
 */
@Repository(value = "ingresoDao")
public class IngresoDao extends GenericDao<Ingreso, IngresoPK> {

    public List<Ingreso> findIngresosBySolicitud(Integer idSolicitud) {
         Query q = getSessionFactory().getCurrentSession().createQuery("SELECT ing FROM Ingreso ing JOIN FETCH ing.fuenteingreso WHERE ing.ingresoPK.solicitudId = :idSolicitud ");
         q.setParameter("idSolicitud", idSolicitud);
         return q.list();
    }

}
