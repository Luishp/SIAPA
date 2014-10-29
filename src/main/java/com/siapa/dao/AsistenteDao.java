/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Asistente;
import com.siapa.model.AsistentePK;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author monte
 */
@Repository(value = "asistenteDao")
public class AsistenteDao extends GenericDao<Asistente, AsistentePK>{
  
     public List<Asistente> findByAccId(Integer accId) {
        Query q = getSessionFactory().getCurrentSession().createQuery(" SELECT a FROM Asistente a  LEFT JOIN FETCH a.miembroscomitecreditos miembroscomitecreditos WHERE a.asistentePK.accId = :accId ");
        q.setParameter("accId", accId);
        return q.list();
    }
    
}
