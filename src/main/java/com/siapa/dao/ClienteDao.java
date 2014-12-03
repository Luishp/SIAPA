/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Cliente;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joao
 */
@Repository
public class ClienteDao extends GenericDao<Cliente, Integer>{
    
    
     public List <Cliente>getCliente(){
        
        Query q=getSessionFactory().getCurrentSession().createQuery("SELECT clie FROM Cliente clie JOIN FETCH clie.idPersona");
        return q.list();
        
    }
    
}
