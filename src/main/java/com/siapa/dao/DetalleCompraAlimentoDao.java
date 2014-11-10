/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.DetalleCompraAlimento;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joao
 */
@Repository
public class DetalleCompraAlimentoDao extends GenericDao<DetalleCompraAlimento, Integer>{
     
    
    public List <DetalleCompraAlimento>getDetalleCompraAlimento(){
        
        Query q=getSessionFactory().getCurrentSession().createQuery("SELECT detalle FROM DetalleCompraAlimento detalle JOIN FETCH detalle.idCompra");
        return q.list();
        
    }
}
