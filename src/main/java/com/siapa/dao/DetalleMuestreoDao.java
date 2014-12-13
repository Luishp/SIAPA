/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Alimento;
import com.siapa.model.DetalleMuestreo;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joao
 */
@Repository
public class DetalleMuestreoDao extends GenericDao<DetalleMuestreo, Integer> {

    public BigInteger cantidad(Integer i) {

        Query q = getSessionFactory().getCurrentSession().createSQLQuery("SELECT COUNT(*) FROM detalle_muestreo WHERE detalle_muestreo.id_muestreo=" + i);
        return (BigInteger) q.uniqueResult();
    }

    public BigDecimal sumatoria(Integer i) {
        Query q = getSessionFactory().getCurrentSession().createSQLQuery("SELECT SUM(PESO_DETALLE_MUESTREO) FROM detalle_muestreo WHERE detalle_muestreo.id_muestreo=" + i);

        return (BigDecimal) q.uniqueResult();
    }



}
