/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Descuento;
import com.siapa.model.Producto;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joao
 */
@Repository
public class ProductoDao extends GenericDao<Producto, Integer> {

    public List<Descuento> getProducto() {

        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT descuento FROM Descuento descuento JOIN FETCH descuento.idCategorias JOIN FETCH descuento.idProducto");
        return q.list();

    }
}
