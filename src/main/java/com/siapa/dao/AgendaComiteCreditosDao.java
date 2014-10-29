package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Agendacomitecreditos;
import com.siapa.model.managedbean.pojos.AgendaComiteCreditosCounterPojo;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository(value = "agendaComiteCreditosDao")
public class AgendaComiteCreditosDao extends GenericDao<Agendacomitecreditos, Integer> {

    public AgendaComiteCreditosCounterPojo getCountByAccId(Integer accId) {

        AgendaComiteCreditosCounterPojo agendaComiteCreditosCounterPojo = new AgendaComiteCreditosCounterPojo();

        Query esperados = getSessionFactory().getCurrentSession().createQuery(" SELECT COUNT(a) FROM Asistente a WHERE a.asistentePK.accId= :accId AND a.asistenteAsistira=true");
        Query permisos = getSessionFactory().getCurrentSession().createQuery(" SELECT COUNT(a) FROM Asistente a WHERE a.asistentePK.accId= :accId AND a.assistentePermiso=true");
        Query asistencia = getSessionFactory().getCurrentSession().createQuery(" SELECT COUNT(a) FROM Asistente a WHERE a.asistentePK.accId= :accId AND a.assistenteAsistio=true");
        Query solicitudes = getSessionFactory().getCurrentSession().createQuery(" SELECT COUNT(a) FROM Analisisenagendacomitecreditos a WHERE a.analisisenagendacomitecreditosPK.accId = :accId");

        esperados.setParameter("accId", accId);
        permisos.setParameter("accId", accId);
        asistencia.setParameter("accId", accId);
        solicitudes.setParameter("accId", accId);

        agendaComiteCreditosCounterPojo.setEsperados((Long) esperados.list().get(0));
        agendaComiteCreditosCounterPojo.setPermisos((Long) permisos.list().get(0));
        agendaComiteCreditosCounterPojo.setAsistencia((Long) asistencia.list().get(0));
        agendaComiteCreditosCounterPojo.setSolicitudes((Long) solicitudes.list().get(0));

        return agendaComiteCreditosCounterPojo;
    }

    public List<Agendacomitecreditos> reunionesPendientes() {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT a FROM Agendacomitecreditos a WHERE a.realizada IS NULL");
        return q.list();
    }

    public List<Agendacomitecreditos> buscarRealizadas(Date fechaInicial, Date fechaFinal) {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT a FROM Agendacomitecreditos a WHERE a.realizada = true AND a.accFechareunion BETWEEN :fechaInicial and :fechaFinal");
        q.setParameter("fechaInicial", fechaInicial);
        q.setParameter("fechaFinal", fechaFinal);
        return q.list();
    }

    public Agendacomitecreditos fillParaActaComite(Agendacomitecreditos agendacomitecreditos) {
        Query q = getSessionFactory().
                getCurrentSession().
                createQuery("SELECT a FROM Agendacomitecreditos a "
                        + "LEFT JOIN FETCH a.analisisenagendacomitecreditosList analisisenagendacomitecreditosList "
                        + "LEFT JOIN FETCH analisisenagendacomitecreditosList.analisis analisis "
                        + "LEFT JOIN FETCH analisis.solicitudId solicitudId "
                        + "LEFT JOIN FETCH solicitudId.asesoriaId asesoriaId "
                        + "LEFT JOIN FETCH asesoriaId.detallelineacreditoId detallelineacreditoId "
                        + "LEFT JOIN FETCH detallelineacreditoId.lineacreditoId lineacreditoId "
                        + "WHERE a.accId = :p_accId");
        q.setParameter("p_accId", agendacomitecreditos.getAccId());
        return (Agendacomitecreditos) q.uniqueResult();
    }
}
