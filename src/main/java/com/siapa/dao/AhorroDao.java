/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Ahorro;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JosueRogelio
 */
@Repository(value = "ahorroDao")
public class AhorroDao extends GenericDao<Ahorro, Integer> {

     public List<Ahorro> findAhorroByDesembolso(Integer id) {
         Query q= getSessionFactory().getCurrentSession().createQuery("Select aho from Ahorro aho where aho.desembolsoId.desembolsoId="+id);
         return q.list();
     }
    
}
