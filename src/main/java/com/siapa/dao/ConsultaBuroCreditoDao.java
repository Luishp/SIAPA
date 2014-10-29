/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Consultaburocredito;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JosueRogelio
 */
@Repository(value = "consultaBuroCreditoDao")
public class ConsultaBuroCreditoDao extends GenericDao<Consultaburocredito, Integer> {

   
    public List<Consultaburocredito> findBuroByAnalisis(Integer id){
        Query q= getSessionFactory().getCurrentSession().createQuery("SELECT cb from Consultaburocredito cb where cb.analisisId.analisisId="+id);
        return q.list();
    }
  
}
