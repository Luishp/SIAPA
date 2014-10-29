package com.siapa.dao;

import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Solicitud;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository(value = "solicitudDao")
public class SolicitudDao extends GenericDao<Solicitud, Integer> {

    public List<Solicitud> findAllReadies() {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT s FROM Solicitud s  LEFT JOIN FETCH s.asesoriaId A LEFT JOIN FETCH A.idasociados aso LEFT JOIN FETCH aso.idasocnatu natural LEFT JOIN FETCH aso.idasocjuri juridico WHERE  s.solicitudCompleta=true and s.analisisList is EMPTY ");
        return q.list();
    }

    public Solicitud findSolicitudByIdAsesoria(Integer idAsesoria) {

        Query q = getSessionFactory()
                .getCurrentSession()
                .createQuery(
                        "SELECT s FROM  Solicitud s JOIN FETCH  s.asesoriaId WHERE s.asesoriaId.asesoriaId = "
                        + idAsesoria);
        Solicitud solicitud = (Solicitud) q.uniqueResult();

        return solicitud;
    }

    public Solicitud findSolicitudByIdSolicitud(Integer idSolicitud) {
        Query q = getSessionFactory().getCurrentSession().createQuery("SELECT s FROM Solicitud s  LEFT JOIN FETCH s.asesoriaId A LEFT JOIN FETCH A.promocionList promo LEFT JOIN FETCH A.detallelineacreditoId deta LEFT JOIN FETCH deta.lineacreditoId linea LEFT JOIN FETCH s.fpId fp LEFT JOIN FETCH s.ppId pp LEFT JOIN FETCH A.idasociados aso LEFT JOIN FETCH aso.idasocnatu natural LEFT JOIN FETCH aso.idasocjuri juridico WHERE  s.solicitudId= " + idSolicitud);
        Solicitud solicitud = (Solicitud) q.uniqueResult();
        return solicitud;

    }

    public Solicitud fillSolicitud(Solicitud solicitud) {
        Query q = getSessionFactory().
                getCurrentSession().
                createQuery("SELECT s FROM Solicitud s "
                        + "LEFT JOIN FETCH s.asesoriaId asesoria "
                        + "LEFT JOIN FETCH asesoria.garantiaasignadaasesoriaList listagarantia "
                        + "LEFT JOIN FETCH listagarantia.garantia garantia "
                        + "LEFT JOIN FETCH asesoria.promocionList promocionList "
                        + "LEFT JOIN FETCH asesoria.idasociados asociado "
                        + "LEFT JOIN FETCH asociado.idasocjuri idasocjuri "
                        + "LEFT JOIN FETCH asociado.idasocnatu idasocnatu "
                        + "LEFT JOIN FETCH s.fpId fpId "
                        + "LEFT JOIN FETCH s.ppId ppId "
                        + "LEFT JOIN FETCH s.deudaList deudaList "
                        + "LEFT JOIN FETCH deudaList.tdId tdId "
                        + "LEFT JOIN FETCH s.ingresoList ingresoList "
                        + "LEFT JOIN FETCH ingresoList.fuenteingreso fuenteingreso "
                        + "LEFT JOIN FETCH s.propiedadList propiedadList "
                        + "LEFT JOIN FETCH s.referenciafamiliarList referenciafamiliarList "
                        + "LEFT JOIN FETCH s.referenciapersonalList referenciapersonalList "
                        + "LEFT JOIN FETCH s.tipoempresaList tipoempresaList "
                        + "LEFT JOIN FETCH s.tiporesidenciaList tiporesidenciaList "
                        + "WHERE s.solicitudId = :id");
        q.setParameter("id", solicitud.getSolicitudId());
        return (Solicitud) q.uniqueResult();
    }

//    public List<Solicitud> findSolicitudesTerminadas(){
//       Query q= getSessionFactory().getCurrentSession().createQuery("SELECT s from Solicitud s LEFT OUTER JOIN FETCH s.asesoriaId Asesoria where s.solicitudListaparaanalisis = true "); 
//       
//       return q.list();
//    }
}
