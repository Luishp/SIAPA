package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Asesoria;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Repository(value = "asesoriaDao")
public class AsesoriaDao extends GenericDao<Asesoria, Integer> {

    public Asesoria findAsesoriaById(Integer idAsesoria) {

        Query q = getSessionFactory()
                .getCurrentSession()
                .createQuery(
                        "SELECT a FROM  Asesoria a JOIN FETCH  a.idasociados asocia LEFT JOIN FETCH asocia.idasocnatu asocnatu LEFT JOIN FETCH asocia.idasocjuri asocju LEFT JOIN FETCH a.taId ta  WHERE a.asesoriaId = "
                        + idAsesoria);
        Asesoria asesoria = (Asesoria) q.uniqueResult();

        return asesoria;
    }

    public List<Asesoria> findAsesoriaWithoutSolicitud() {

        Query q = getSessionFactory()
                .getCurrentSession()
                .createQuery(
                        "SELECT a FROM  Asesoria a JOIN FETCH  a.idasociados asocia LEFT JOIN FETCH asocia.idasocnatu asocnatu LEFT JOIN FETCH asocia.idasocjuri asocju LEFT JOIN FETCH  a.taId ta WHERE a.solicitudId is null ");
        return q.list();
    }

    public Asesoria findAsesoriaBySolicitud(Integer idSolicitud ) {

        Query q = getSessionFactory()
                .getCurrentSession()
                .createQuery(
                        "SELECT a FROM  Asesoria a JOIN FETCH  a.idasociados asocia LEFT JOIN FETCH asocia.idasocnatu asocnatu LEFT JOIN FETCH asocia.idasocjuri asocju LEFT JOIN FETCH  a.taId ta WHERE a.solicitudId.solicitudId = :idSolicitud");
       q.setParameter("idSolicitud", idSolicitud);
        return (Asesoria) q.uniqueResult();
    }
    
    public Asesoria fillAsesoria(Asesoria asesoria ) {

        Query q = getSessionFactory()
                .getCurrentSession()
                .createQuery(
                        "SELECT a FROM  Asesoria a LEFT JOIN FETCH  a.idasociados asocia LEFT JOIN FETCH asocia.idasocnatu asocnatu LEFT JOIN FETCH asocia.idasocjuri asocju LEFT JOIN FETCH  a.taId ta LEFT JOIN FETCH a.detallelineacreditoId detallelineacreditoId LEFT JOIN FETCH detallelineacreditoId.lineacreditoId lineacreditoId LEFT JOIN FETCH a.fpId fpId  WHERE a.asesoriaId = :p_asesoriaId");
       q.setParameter("p_asesoriaId", asesoria.getAsesoriaId());
        return (Asesoria) q.uniqueResult();
    }
    
    
}
