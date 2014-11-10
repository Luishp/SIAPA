/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Proveedor;
import java.util.List;
import org.hibernate.Query;

import org.springframework.stereotype.Repository;

/**
 *
 * @author Joao
 */
@Repository
public class ProveedorDao extends GenericDao<Proveedor, Integer>{
    
       public List <Proveedor>getProveedor(){
        
        Query q=getSessionFactory().getCurrentSession().createQuery("SELECT prov FROM Proveedor prov JOIN FETCH proveedor.idPersona");
        return q.list();
        
    }
    
    
}
