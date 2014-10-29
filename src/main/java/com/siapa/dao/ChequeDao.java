/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Cheque;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JosueRogelio
 */
@Repository(value="chequeDao")
public class ChequeDao extends GenericDao<Cheque, Integer>{
    
      public List<Cheque> findChequesByDesembolso(Integer id) {
          Query q= getSessionFactory().getCurrentSession().createQuery("Select chq from Cheque chq where chq.desembolsoId.desembolsoId= "+id);
          return q.list();
      }
    
}
