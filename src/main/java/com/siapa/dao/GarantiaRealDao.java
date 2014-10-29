/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Registrogarantiareal;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JosueRogelio
 */
@Repository(value = "garantiaRealDao")
public class GarantiaRealDao extends GenericDao<Registrogarantiareal, Integer> {

    public List<Registrogarantiareal> findGarantiasRealesByAnalisis(Integer idAnalisis) {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT gr  FROM Registrogarantiareal gr WHERE gr.analisisId.analisisId = :idAnalisis");
        q.setParameter("idAnalisis" ,idAnalisis);
        return q.list();
    }
}
