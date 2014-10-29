/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Miembroscomitecreditos;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author monte
 */
@Repository(value = "miembrosComiteCreditosDao")
public class MiembrosComiteCreditosDao extends GenericDao<Miembroscomitecreditos, Integer> {

    public List<Miembroscomitecreditos> findAllActives() {
        Query q = getSessionFactory().getCurrentSession().createQuery(" SELECT m FROM Miembroscomitecreditos m WHERE m.activo='SI'");
        return q.list();
    }

    public List<Miembroscomitecreditos> findByAccId(Integer accId) {
        Query q = getSessionFactory().getCurrentSession().createQuery(" SELECT m FROM Miembroscomitecreditos m  LEFT JOIN FETCH m.asistenteList asistente  WHERE asistente.asistentePK.accId= :accId");
        q.setParameter("accId", accId);
        return q.list();
    }

}
