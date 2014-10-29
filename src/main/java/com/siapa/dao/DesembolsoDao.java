package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Desembolso;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author monte
 */
@Repository(value = "desembolsoDao")
public class DesembolsoDao extends GenericDao<Desembolso, Integer> {

    public List<Desembolso> buscarParaEditar() {
        Query q = getSessionFactory().
                getCurrentSession().
                createQuery("SELECT d FROM Desembolso d "
                        + "LEFT JOIN FETCH d.resolucionId resolucionId "
                        + "LEFT JOIN FETCH resolucionId.analisisId analisisId "
                        + "LEFT JOIN FETCH analisisId.solicitudId solicitudId "
                        + "WHERE d.desembolsoListo = false");
        return q.list();
    }
    
    public List<Desembolso> buscarParaAplicar() {
        Query q = getSessionFactory().
                getCurrentSession().
                createQuery("SELECT d FROM Desembolso d "
                        + "LEFT JOIN FETCH d.resolucionId resolucionId "
                        + "LEFT JOIN FETCH resolucionId.analisisId analisisId "
                        + "LEFT JOIN FETCH analisisId.solicitudId solicitudId "
                        + "WHERE d.desembolsoListo = true "
                        + "AND (d.desembolsoCompleto IS NULL OR d.desembolsoCompleto = false)");
        return q.list();
    }
    public List<Desembolso> buscarParaReporte() {
        Query q = getSessionFactory().
                getCurrentSession().
                createQuery("SELECT d FROM Desembolso d "
                        + "LEFT JOIN FETCH d.resolucionId resolucionId "
                        + "LEFT JOIN FETCH resolucionId.analisisId analisisId "
                        + "LEFT JOIN FETCH analisisId.solicitudId solicitudId "
                        + "WHERE d.desembolsoListo = true "
                        + "AND d.desembolsoCompleto = true");
        return q.list();
    }

    public Desembolso fillDesembolso(Desembolso desembolso) {
        Query q = getSessionFactory().
                getCurrentSession().
                createQuery("SELECT d FROM Desembolso d "
                        + "LEFT JOIN FETCH d.resolucionId resolucionId "
                        + "LEFT JOIN FETCH d.pagaduriaId pagaduriaId "
                        + "LEFT JOIN FETCH resolucionId.analisisId analisisId "
                        + "LEFT JOIN FETCH analisisId.solicitudId solicitudId "
                        + "LEFT JOIN FETCH analisisId.tsId tsId "
                        + "LEFT JOIN FETCH solicitudId.ppId ppId "
                        + "LEFT JOIN FETCH solicitudId.asesoriaId asesoriaId "
                        + "LEFT JOIN FETCH asesoriaId.detallelineacreditoId detallelineacreditoId "
                        + "LEFT JOIN FETCH detallelineacreditoId.lineacreditoId lineacreditoId "
                        + "LEFT JOIN FETCH resolucionId.nrId nrId "
                        + "WHERE d.desembolsoId = :id");
       q.setParameter("id", desembolso.getDesembolsoId());
        return (Desembolso) q.uniqueResult();
    }

}
