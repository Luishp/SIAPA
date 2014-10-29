/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Caja;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josue
 */
@Repository(value="cajaDao")
public class CajaDao extends GenericDao<Caja, Integer>{
    
    public List<Caja> findAllActives() {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT c  FROM Caja c LEFT JOIN FETCH  c.ccId2 Cuentacontable  WHERE c.activo='SI'");
        return q.list();
    }
    
}
