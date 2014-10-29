/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Tipodeduccion;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josue
 */
@Repository(value="tipoDevolucionDao")
public class TipoDeduccionDao extends GenericDao<Tipodeduccion, Integer>{
    
    
       public List<Tipodeduccion> findAllActives() {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT td  FROM Tipodeduccion td LEFT JOIN FETCH  td.ccId2 Cuentacontable  WHERE td.activo='SI'");
        return q.list();
    }

}
