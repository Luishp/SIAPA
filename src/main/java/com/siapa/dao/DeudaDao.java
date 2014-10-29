/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Deuda;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Repository(value = "deudaDao")
public class DeudaDao extends GenericDao<Deuda, Integer> {

    public List<Deuda> findDeudasComercialesByIdAsociado(Integer idSolicitud) {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT dc FROM Deuda dc WHERE dc.solicitudId.solicitudId = :idSolicitud and dc.tdId.tdId = :dc");
        q.setParameter("dc", 3);
        q.setParameter("idSolicitud", idSolicitud);
        return q.list();
    }

    public List<Deuda> findDeudasTarjetasByIdAsociado(Integer idSolicitud) {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT dt FROM Deuda dt WHERE dt.solicitudId.solicitudId = :idSolicitud and dt.tdId.tdId = :dt");
        q.setParameter("dt", 1);
        q.setParameter("idSolicitud", idSolicitud);
        return q.list();
    }

    public List<Deuda> deudasPrestamosFinByIdSolicitud(Integer idAnalisisId) {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT dt FROM Deuda dt WHERE dt.solicitudId.solicitudId = :idSolicitud and dt.tdId.tdId = :presfin");
        q.setParameter("presfin", 2);
        q.setParameter("idSolicitud", idAnalisisId);
        return q.list();
    }
    
    
    //Analisis
    public List<Deuda> findDeudasComercialesByAnalisis(Integer idAnalisisId) {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT dc FROM Deuda dc WHERE dc.analisisId.analisisId = :idAnalisisId and dc.tdId.tdId = :dc");
        q.setParameter("dc", 3);
        q.setParameter("idAnalisisId", idAnalisisId);
        return q.list();
    }

    public List<Deuda> findDeudasTarjetasByAnalisis(Integer idAnalisisId) {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT dt FROM Deuda dt WHERE dt.analisisId.analisisId = :idAnalisisId and dt.tdId.tdId = :dt");
        q.setParameter("dt", 1);
        q.setParameter("idAnalisisId", idAnalisisId);
        return q.list();
    }

    public List<Deuda> deudasPrestamosFinByAnalisis(Integer idAnalisisId) {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT dt FROM Deuda dt WHERE dt.analisisId.analisisId = :idAnalisisId and dt.tdId.tdId = :presfin");
        q.setParameter("presfin", 2);
        q.setParameter("idAnalisisId", idAnalisisId);
        return q.list();
    }
    
    

}
