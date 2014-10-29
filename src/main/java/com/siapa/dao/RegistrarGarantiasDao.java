package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Analisis;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Repository(value = "registrarGarantiasDao")
public class RegistrarGarantiasDao extends GenericDao<Analisis, Integer> {

    public Analisis findGarantiasExigidasByAnalisis(Integer analisisId) {

        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT a FROM Analisis a JOIN FETCH a.solicitudId s JOIN FETCH s.asesoriaId aa LEFT JOIN FETCH aa.garantiaasignadaasesoriaList li WHERE a.analisisId = :analisisId");
        q.setParameter("analisisId", analisisId);
        return (Analisis) q.uniqueResult();
    }

    public Analisis findallGarantiasByAnalisis(Integer analisisId) {

        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT a From Analisis a LEFT JOIN FETCH a.registrogarantiacodeudorList LEFT JOIN FETCH a.registrogarantiahipotecariaList LEFT JOIN FETCH a.registrogarantiaprendariaList LEFT JOIN FETCH a.registrogarantiarealList WHERE a.analisisId = :analisisId");
        q.setParameter("analisisId", analisisId);
        return (Analisis) q.uniqueResult();
    }

}
