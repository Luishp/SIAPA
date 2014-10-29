/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Registrogarantiahipotecaria;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JosueRogelio
 */
@Repository(value = "garantiaHipotecariaDao")
public class GarantiaHipotecariaDao extends GenericDao<Registrogarantiahipotecaria, Integer> {

    public List<Registrogarantiahipotecaria> findGarantiasByIdAnalisis(Integer idAnalisis) {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT gh  FROM  Registrogarantiahipotecaria gh JOIN FETCH gh.tipoInmuebleId tipo WHERE gh.analisisId.analisisId = :idAnalisis");
        q.setParameter("idAnalisis", idAnalisis);
        return q.list();
    }
}
