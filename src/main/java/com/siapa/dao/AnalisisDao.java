package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Analisis;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository(value = "analisisDao")
public class AnalisisDao extends GenericDao<Analisis, Integer> {

    public List<Analisis> buscarListosParaAgenda() {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT a FROM Analisis a LEFT JOIN FETCH a.solicitudId solicitud  WHERE a.analisisCompleto=true AND a.resolucionId IS NULL AND (a.nrId.nrId=3 OR a.nrId.nrId=4)");
        return q.list();
    }

    public List<Analisis> buscarParaEnvioResolucion() {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT a FROM Analisis a JOIN FETCH a.solicitudId solicitud  WHERE a.analisisCompleto=true AND a.resolucionId IS NULL AND a.nrId IS NULL");
        return q.list();
    }

    public List<Analisis> buscarParaDesembolso() {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT a FROM Analisis a LEFT JOIN FETCH a.solicitudId solicitud WHERE a.resolucionId.tiporesolucionId.tiporesolucionId=1 AND a.resolucionId.desembolsoId IS NULL");
        return q.list();
    }

    public List<Analisis> findByAccId(Integer accId) {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT a FROM Analisis a LEFT JOIN FETCH a.solicitudId Solicitud LEFT JOIN FETCH a.analisisenagendacomitecreditosList  analisisenagendacomitecreditos WHERE analisisenagendacomitecreditos.analisisenagendacomitecreditosPK.accId=:accId");
        q.setParameter("accId", accId);
        return q.list();
    }

    public List<Analisis> buscarAnalisisIncompletos() {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT distinct a from Analisis a "
                + "LEFT JOIN FETCH a.solicitudId solicitud "
                + "LEFT JOIN FETCH a.deudaList deudas "
                + "LEFT JOIN FETCH a.consultaburocreditoList buros"
                + "LEFT JOIN FETCH solicitud.asesoriaId asesoria "
                + "LEFT JOIN FETCH asesoria.idasociados asociado "
                + "LEFT JOIN FETCH asociado.idasocnatu natural "
                + "WHERE a.analisisCompleto is 0");
        return q.list();
    }

    public List<Analisis> buscarParaResolucion(Integer nivelResolucion) {
        String sql = "";
        if (nivelResolucion == 1 || nivelResolucion == 2) {
            sql = "SELECT a FROM Analisis a "
                    + "LEFT JOIN FETCH a.solicitudId solicitud "
                    + "WHERE a.resolucionId IS NULL "
                    + "AND a.nrId.nrId= :nivelResolucion";

        } else if (nivelResolucion == 3 || nivelResolucion == 4) {
            sql = "SELECT DISTINCT a FROM Analisis a "
                    + "LEFT JOIN FETCH a.solicitudId solicitud  "
                    + "JOIN FETCH a.analisisenagendacomitecreditosList analisisenagendacomitecreditos "
                    + "WHERE a.resolucionId IS NULL "
                    + "AND a.nrId.nrId= :nivelResolucion "
                    + "AND analisisenagendacomitecreditos.tiporesolucionId IS NOT NULL";
        }

        Query q = getSessionFactory().getCurrentSession().createQuery(sql);
        q.setParameter("nivelResolucion", nivelResolucion);
        return q.list();
    }

    public Analisis fillAnalisis(Analisis analisis) {
        Query q = getSessionFactory().
                getCurrentSession().
                createQuery("SELECT a FROM Analisis a "
                        + "LEFT JOIN FETCH a.solicitudId solicitud  "
                        + "LEFT JOIN FETCH a.tsId tsId "
                        + "LEFT JOIN FETCH a.deudaList deuda "
                        + "LEFT JOIN FETCH a.consultaburocreditoList buros "
                        + "LEFT JOIN FETCH solicitud.ppId ppId "
                        + "LEFT JOIN FETCH solicitud.fpId fpId  "
                        + "LEFT JOIN FETCH solicitud.asesoriaId asesoria  "
                        + "LEFT JOIN FETCH asesoria.detallelineacreditoId detallelineacredito "
                        + "LEFT JOIN FETCH detallelineacredito.lineacreditoId lineacreditoId "
                        + "LEFT JOIN FETCH a.resolucionId resolucion "
                        + "LEFT JOIN FETCH resolucion.nrId nrId  "
                        + "WHERE a.analisisId = :id");
        q.setParameter("id", analisis.getAnalisisId());
        return (Analisis) q.uniqueResult();
    }

    public Analisis fillAnalisisForReport(Analisis analisis) {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT a FROM Analisis a "
                + "LEFT JOIN FETCH a.solicitudId solicitud  "
                + "LEFT JOIN FETCH a.tsId tsId "
                + "LEFT JOIN FETCH a.registrogarantiaprendariaList gprendaria "
                + "LEFT JOIN FETCH a.registrogarantiarealList greal "
                + "LEFT JOIN FETCH a.registrogarantiahipotecariaList ghipotecaria "
                + "LEFT JOIN FETCH a.registrogarantiacodeudorList gcodeudor "
                + "LEFT JOIN FETCH a.deudaList deuda "
                + "LEFT JOIN FETCH a.consultaburocreditoList buros "
                + "LEFT JOIN FETCH solicitud.ppId ppId "
                + "LEFT JOIN FETCH solicitud.fpId fpId  "
                + "LEFT JOIN FETCH solicitud.asesoriaId asesoria  "
                + "LEFT JOIN FETCH asesoria.detallelineacreditoId detallelineacredito "
                + "LEFT JOIN FETCH detallelineacredito.lineacreditoId lineacreditoId "
                + "WHERE a.analisisId = :id");
        q.setParameter("id", analisis.getAnalisisId());
        return (Analisis) q.uniqueResult();
    }

}
