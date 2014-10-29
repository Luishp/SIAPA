/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Pagaduria;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josue
 */
@Repository(value = "pagaduriaDao")
public class PagaduriaDao extends GenericDao<Pagaduria, Integer> {

    public List<Pagaduria> findAllActives() {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT p FROM Pagaduria p WHERE p.activo='SI'");
        return q.list();

    }

}
