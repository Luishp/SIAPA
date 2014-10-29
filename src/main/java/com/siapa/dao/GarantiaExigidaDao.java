/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Garantiaexigida;
import com.siapa.model.GarantiaexigidaPK;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Repository(value = "garantiaExigidaDao")
public class GarantiaExigidaDao extends GenericDao<Garantiaexigida, GarantiaexigidaPK> {

    public List<Garantiaexigida> findByDlcId(Integer dlcId) {
        Query q = getSessionFactory().getCurrentSession().createQuery(" SELECT ge FROM Garantiaexigida ge  LEFT JOIN FETCH ge.detallelineacredito detalleLineaCredito JOIN FETCH ge.garantia WHERE ge.garantiaexigidaPK.detallelineacreditoId = :dlcId ");
        q.setParameter("dlcId", dlcId);
        return q.list();
    }

}
