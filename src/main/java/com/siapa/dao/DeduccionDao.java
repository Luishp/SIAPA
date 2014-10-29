/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Deducciones;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JosueRogelio
 */
@Repository(value = "deduccionDao")
public class DeduccionDao extends GenericDao<Deducciones, Integer> {

    public List<Deducciones> findDeduccionesByDesembolso(Integer id) {
        Query q = getSessionFactory().getCurrentSession().createQuery("Select deduc from Deducciones deduc where deduc.desembolsoId.desembolsoId=:p_id ");
        q.setParameter("p_id", id);
        return q.list();

    }

}
