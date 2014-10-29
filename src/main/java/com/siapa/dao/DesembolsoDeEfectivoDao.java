/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Efectivo;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Angel
 */
@Repository(value = "desembolsoDeEfectivoDao")
public class DesembolsoDeEfectivoDao extends GenericDao<Efectivo, Integer> {

    public List<Efectivo> efectivoPendienteDeEntrega() {
        Query q = getSessionFactory().
                getCurrentSession().createQuery("SELECT o FROM Efectivo o "
                        + "LEFT JOIN FETCH o.desembolsoId desembolsoId "
                        + "LEFT JOIN FETCH desembolsoId.resolucionId resolucionId "
                        + "LEFT JOIN FETCH resolucionId.analisisId analisisId "
                        + "LEFT JOIN FETCH analisisId.solicitudId solicitudId "
                        + "WHERE o.efectivoEntregado IS NULL "
                        + "OR o.efectivoEntregado=false");
        return q.list();
    }

}
