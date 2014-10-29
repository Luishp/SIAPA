/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Registrogarantiacodeudor;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JosueRogelio
 */
@Repository(value="garantiaCodeudorDao")
public class GarantiaCodeudorDao extends GenericDao<Registrogarantiacodeudor, Integer>{
    
    public List<Registrogarantiacodeudor> findByAnalisisId(Integer idAnalisis) {
        Query q = getSessionFactory().getCurrentSession()
                .createQuery("SELECT gc FROM Registrogarantiacodeudor gc LEFT JOIN FETCH gc.codeudorId codeudor  WHERE gc.analisisId.analisisId = :idAnalisis ");
        q.setParameter("idAnalisis", idAnalisis);
       
        return q.list();
    }
    
}
