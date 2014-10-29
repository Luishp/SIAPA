package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Resolucion;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Angel Montenegro
 */
@Repository(value = "resolucionDao")
public class ResolucionDao extends GenericDao<Resolucion, Integer> {

    public Resolucion findResolucion(Resolucion resolucion) {
        Query q = getSessionFactory()
                .getCurrentSession()
                .createQuery("SELECT r FROM Resolucion r "
                        + "LEFT JOIN FETCH r.nrId nrId "
                        + "LEFT JOIN FETCH r.tiporesolucionId tiporesolucionId   "
                        + "WHERE r.resolucionId = :p_id ");

        q.setParameter("p_id", resolucion.getResolucionId());

        return (Resolucion) q.uniqueResult();

    }

    public List<Resolucion> buscarParaEditar(Integer nivelResolucion) {
        Query q = getSessionFactory().
                getCurrentSession().
                createQuery("SELECT r FROM Resolucion r "
                        + "LEFT JOIN FETCH r.analisisId analisisId "
                        + "LEFT JOIN FETCH analisisId.solicitudId solicitudId  "
                        + "WHERE r.nrId.nrId=:nivelResolucion AND r.desembolsoId IS NULL");
       q.setParameter("nivelResolucion", nivelResolucion);
        return q.list();
    }
   
    public Resolucion fillResolucion(Resolucion resolucion) {
        Query q = getSessionFactory().
                getCurrentSession().
                createQuery("SELECT r FROM Resolucion r "
                        + "LEFT JOIN FETCH r.analisisId analisis "
                        + "LEFT JOIN FETCH analisis.solicitudId solicitud  "
                        + "LEFT JOIN FETCH analisis.tsId tsId "
                        + "LEFT JOIN FETCH solicitud.ppId ppId "
                        + "LEFT JOIN FETCH solicitud.fpId fpId "
                        + "LEFT JOIN FETCH solicitud.asesoriaId asesoria "
                        + "LEFT JOIN FETCH asesoria.detallelineacreditoId detallelineacredito "
                        + "LEFT JOIN FETCH detallelineacredito.lineacreditoId lineacreditoId "
                        + "LEFT JOIN FETCH r.nrId nrId "
                        + "WHERE r.resolucionId=:id");
       q.setParameter("id", resolucion.getResolucionId());
        return (Resolucion) q.uniqueResult();
    }

}
