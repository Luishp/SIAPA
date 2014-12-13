/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Jaula;
import java.io.Serializable;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joao
 */
@Repository
public class JaulaDao extends GenericDao<Jaula, Integer> {

    public Long sumAll() {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT sum(j.ventaJaula) from Jaula as j");
        Long var = (Long) q.list().get(0);
        //   System.out.println(var);
        return var;
    }
}
