/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.TipoJaula;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joao
 */

@Repository
public class TipoJaulaDao extends GenericDao<TipoJaula, Integer>{
        public List<TipoJaula> findAllActives() {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT t  FROM TipoJaula t ");
        return q.list();
    }   
}
