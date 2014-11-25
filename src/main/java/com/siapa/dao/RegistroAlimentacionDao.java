/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.RegistroAlimentacion;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joao
 */

@Repository
public class RegistroAlimentacionDao extends GenericDao<RegistroAlimentacion, Integer>{
    public List <RegistroAlimentacion>getRegistroAlimentacion(){
        
        Query q=getSessionFactory().getCurrentSession().createQuery("SELECT prov FROM registro_alimentacion prov JOIN FETCH prov.idAlimentacion");
        return q.list();
        
    }
    
}
