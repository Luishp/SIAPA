/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.DetalleVenta;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joao
 */
@Repository
public class DetalleVentaDao extends GenericDao<DetalleVenta, Integer> {
    
    
    public List <DetalleVenta>getDetalleVentaAll(){
        
        //Query q=getSessionFactory().getCurrentSession().createQuery("SELECT detalle FROM DetalleCompraAlimento detalle JOIN FETCH detalle.idCompra JOIN FETCH detalle.idAlimento alimento JOIN FETCH alimento.idTipoAlimento");
        Query q=getSessionFactory().getCurrentSession().createQuery("SELECT detalle FROM DetalleVenta detalle JOIN FETCH detalle.idVenta JOIN FETCH  detalle.idVenta comventa JOIN FETCH comventa.idComprobanteVenta " );
        return q.list();
        
    }
    
}
