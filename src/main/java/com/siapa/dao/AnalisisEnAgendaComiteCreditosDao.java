/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Analisisenagendacomitecreditos;
import com.siapa.model.AnalisisenagendacomitecreditosPK;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author monte
 */
@Repository(value = "analisisEnAgendaComiteCreditosDao")
public class AnalisisEnAgendaComiteCreditosDao extends GenericDao<Analisisenagendacomitecreditos, AnalisisenagendacomitecreditosPK> {

    public List<Analisisenagendacomitecreditos> buscarAnalisisEnAgenda(Integer agenda) {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT o FROM Analisisenagendacomitecreditos o LEFT JOIN FETCH o.analisis analisis LEFT JOIN FETCH analisis.solicitudId solicitud LEFT JOIN FETCH o.tiporesolucionId tiporesolucion WHERE o.analisisenagendacomitecreditosPK.accId = :p_agenda");
        q.setParameter("p_agenda", agenda);
        return q.list();
    }
}
