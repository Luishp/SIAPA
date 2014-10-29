package com.siapa.service;

import com.siapa.dao.AgendaComiteCreditosDao;
import com.siapa.dao.AnalisisDao;
import com.siapa.dao.AnalisisEnAgendaComiteCreditosDao;
import com.siapa.dao.AsistenteDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Agendacomitecreditos;
import com.siapa.model.Analisis;
import com.siapa.model.Analisisenagendacomitecreditos;
import com.siapa.model.Asistente;
import com.siapa.model.managedbean.pojos.AgendaComiteCreditosCounterPojo;
import com.siapa.pojos.rpt.actacomitecredito.ReporteActaComiteCreditopojo;
import com.siapa.service.generic.GenericService;
import com.siapa.utils.PagedResult;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kof
 */
@Service(value = "agendaComiteCreditosService")
public class AgendaComiteCreditosService extends GenericService<Agendacomitecreditos, Integer> {

    @Autowired
    private AgendaComiteCreditosDao agendaComiteCreditosDao;

    @Autowired
    private AsistenteDao asistenteDao;

    @Autowired
    private AnalisisEnAgendaComiteCreditosDao analisisEnAgendaComiteCreditosDao;

    @Autowired
    private AnalisisDao analisisDao;

    @Override
    public GenericDao<Agendacomitecreditos, Integer> getDao() {
        return agendaComiteCreditosDao;
    }

    public Boolean saveNew(Agendacomitecreditos agenda, List<Asistente> asistentes, List<Analisis> analisis) {
        try {
            agendaComiteCreditosDao.save(agenda);

            if (agenda.getAccId() != null) {

                for (Asistente asistente : asistentes) {
                    asistente.getAsistentePK().setAccId(agenda.getAccId());
                    asistenteDao.save(asistente);
                }

                for (Analisis anls : analisis) {
                    if (anls.isSelected()) {
                        Analisisenagendacomitecreditos analisisenagendacomitecreditos = new Analisisenagendacomitecreditos(agenda.getAccId(), anls.getAnalisisId());
                        analisisEnAgendaComiteCreditosDao.save(analisisenagendacomitecreditos);
                    }
                }

                return true;
            } else {

                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    public Boolean update(Agendacomitecreditos agenda, List<Asistente> asistentes, List<Analisis> analisis) {
        try {
            agendaComiteCreditosDao.merge(agenda);

            if (agenda.getAccId() != null) {

                for (Asistente asistente : asistentes) {
                    asistente.getAsistentePK().setAccId(agenda.getAccId());
                    asistenteDao.merge(asistente);
                }

                for (Analisis anls : analisis) {
                    if (!anls.isSelected()) {
                        Analisisenagendacomitecreditos analisisenagendacomitecreditos = new Analisisenagendacomitecreditos(agenda.getAccId(), anls.getAnalisisId());
                        analisisEnAgendaComiteCreditosDao.merge(analisisenagendacomitecreditos);
                    }
                }

                return true;
            } else {

                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    public Boolean close(Agendacomitecreditos agenda, List<Asistente> asistentes, List<Analisisenagendacomitecreditos> analisis) {
        try {

            if (agenda.getAccId() != null) {

                for (Asistente asistente : asistentes) {
                    asistenteDao.merge(asistente);
                }

                for (Analisisenagendacomitecreditos analisisenagendacomitecreditos : analisis) {
                    analisisEnAgendaComiteCreditosDao.merge(analisisenagendacomitecreditos);
                    analisisenagendacomitecreditos.getAnalisis().setTiporesolucionId(analisisenagendacomitecreditos.getTiporesolucionId());
                    analisisDao.merge(analisisenagendacomitecreditos.getAnalisis());
                }

                agendaComiteCreditosDao.merge(agenda);

                return true;
            } else {

                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public PagedResult getPage(int page, int pageSize, String sortProperty, String sortDirection, List criterions) {
        List<Agendacomitecreditos> ret = new ArrayList<Agendacomitecreditos>();

        PagedResult rs = agendaComiteCreditosDao.getPage(page, pageSize, sortProperty, sortDirection, criterions); //To change body of generated methods, choose Tools | Templates.
        ret = rs.getList();

        for (Agendacomitecreditos agendacomitecreditos : ret) {
            AgendaComiteCreditosCounterPojo agendaComiteCreditosCounterPojo = new AgendaComiteCreditosCounterPojo();
            agendaComiteCreditosCounterPojo = agendaComiteCreditosDao.getCountByAccId(agendacomitecreditos.getAccId());

            agendacomitecreditos.setEsperados(agendaComiteCreditosCounterPojo.getEsperados().intValue());
            agendacomitecreditos.setPermisos(agendaComiteCreditosCounterPojo.getPermisos().intValue());
            agendacomitecreditos.setAsistencia(agendaComiteCreditosCounterPojo.getAsistencia().intValue());
            agendacomitecreditos.setSolicitudes(agendaComiteCreditosCounterPojo.getSolicitudes().intValue());
        }

        rs.setList(ret);
        return rs;
    }

    public List<Agendacomitecreditos> reunionesPendientes() {
        List<Agendacomitecreditos> ret = agendaComiteCreditosDao.reunionesPendientes();

        for (Agendacomitecreditos agendacomitecreditos : ret) {
            AgendaComiteCreditosCounterPojo agendaComiteCreditosCounterPojo = new AgendaComiteCreditosCounterPojo();
            agendaComiteCreditosCounterPojo = agendaComiteCreditosDao.getCountByAccId(agendacomitecreditos.getAccId());

            agendacomitecreditos.setEsperados(agendaComiteCreditosCounterPojo.getEsperados().intValue());
            agendacomitecreditos.setPermisos(agendaComiteCreditosCounterPojo.getPermisos().intValue());
            agendacomitecreditos.setAsistencia(agendaComiteCreditosCounterPojo.getAsistencia().intValue());
            agendacomitecreditos.setSolicitudes(agendaComiteCreditosCounterPojo.getSolicitudes().intValue());
        }

        return ret;
    }

    public List<Agendacomitecreditos> buscarRealizadas(Date fechaInicial, Date fechaFinal) {
        List<Agendacomitecreditos> ret = agendaComiteCreditosDao.buscarRealizadas(fechaInicial, fechaFinal);

        for (Agendacomitecreditos agendacomitecreditos : ret) {
            AgendaComiteCreditosCounterPojo agendaComiteCreditosCounterPojo = new AgendaComiteCreditosCounterPojo();
            agendaComiteCreditosCounterPojo = agendaComiteCreditosDao.getCountByAccId(agendacomitecreditos.getAccId());

            agendacomitecreditos.setEsperados(agendaComiteCreditosCounterPojo.getEsperados().intValue());
            agendacomitecreditos.setPermisos(agendaComiteCreditosCounterPojo.getPermisos().intValue());
            agendacomitecreditos.setAsistencia(agendaComiteCreditosCounterPojo.getAsistencia().intValue());
            agendacomitecreditos.setSolicitudes(agendaComiteCreditosCounterPojo.getSolicitudes().intValue());
        }

        return ret;
    }

    public ReporteActaComiteCreditopojo fillAgendaParaActaComite(Agendacomitecreditos agendacomitecreditos) {
        ReporteActaComiteCreditopojo pojo = new ReporteActaComiteCreditopojo();
        Agendacomitecreditos tmp = agendaComiteCreditosDao.fillParaActaComite(agendacomitecreditos);
        String asistentes = "";
        String aprobadas = "";
        String denegadas = "";
        String devueltas = "";

        pojo.setActaNumero(tmp.getAccId().toString());
        pojo.setReunionLugar(tmp.getAccLugarreunion());
        pojo.setReunionFecha("05 de agosto de 2014");
        pojo.setReunionHora("Dieciseis ");

        for (Asistente asistente : tmp.getAsistenteList()) {
            if (asistentes.isEmpty()) {
                asistentes = asistentes + asistente.getMiembroscomitecreditos().getMccNombre() + ", " + asistente.getMiembroscomitecreditos().getMccCargo();
            } else {
                asistentes = asistentes + ", " + asistente.getMiembroscomitecreditos().getMccNombre() + ", " + asistente.getMiembroscomitecreditos().getMccCargo();
            }
        }

        for (Analisisenagendacomitecreditos analisisenagendacomitecreditos : tmp.getAnalisisenagendacomitecreditosList()) {
            if (analisisenagendacomitecreditos.getTiporesolucionId() != null && analisisenagendacomitecreditos.getTiporesolucionId().getTiporesolucionId() == 1) {

                if (aprobadas.isEmpty()) {
                    aprobadas = aprobadas
                            + analisisenagendacomitecreditos.getAnalisis().getSolicitudId().getNombreCompleto()
                            + ", Monto Aprobado: $ " + analisisenagendacomitecreditos.getAnalisis().getAnalisisMonto()
                            + ", Plazo: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisPlazo() + " meses"
                            + ", Tasa de interes anual: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisTasa().multiply(new BigDecimal("100")) + " %"
                            + ", Cuota: $ " + analisisenagendacomitecreditos.getAnalisis().getAnalisisCuotacapitalmasintereses() + ", Abonando a: capital, intereses, seguro de deuda y aportaciones"
                            + ", Linea de prestamo: " + analisisenagendacomitecreditos.getAnalisis().getSolicitudId().getAsesoriaId().getDetallelineacreditoId().getLineacreditoId().getLineacreditoNombre();
                } else {
                    aprobadas = aprobadas + ", "
                            + analisisenagendacomitecreditos.getAnalisis().getSolicitudId().getNombreCompleto()
                            + ", Monto Aprobado: $ " + analisisenagendacomitecreditos.getAnalisis().getAnalisisMonto()
                            + ", Plazo: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisPlazo() + " meses"
                            + ", Tasa de interes anual: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisTasa().multiply(new BigDecimal("100")) + " %"
                            + ", Cuota: $ " + analisisenagendacomitecreditos.getAnalisis().getAnalisisCuotacapitalmasintereses() + ", Abonando a: capital, intereses, seguro de deuda y aportaciones"
                            + ", Linea de prestamo: " + analisisenagendacomitecreditos.getAnalisis().getSolicitudId().getAsesoriaId().getDetallelineacreditoId().getLineacreditoId().getLineacreditoNombre();
                }
            }

            if (analisisenagendacomitecreditos.getTiporesolucionId() != null && analisisenagendacomitecreditos.getTiporesolucionId().getTiporesolucionId() == 2) {

                if (denegadas.isEmpty()) {
                    denegadas = denegadas
                            + analisisenagendacomitecreditos.getAnalisis().getSolicitudId().getNombreCompleto()
                            + ", Monto Aprobado: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisMonto()
                            + ", Plazo: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisPlazo()
                            + ", Tasa de interes anual: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisTasa()
                            + ", Cuota: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisCuotacapitalmasintereses() + ", Abonando a: capital, intereses, seguro de deuda y aportaciones"
                            + ", Linea de prestamo: " + analisisenagendacomitecreditos.getAnalisis().getSolicitudId().getAsesoriaId().getDetallelineacreditoId().getLineacreditoId().getLineacreditoNombre();
                } else {
                    denegadas = denegadas + ", "
                            + analisisenagendacomitecreditos.getAnalisis().getSolicitudId().getNombreCompleto()
                            + ", Monto Solicitado: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisMonto()
                            + ", Plazo: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisPlazo()
                            + ", Tasa de interes anual: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisTasa()
                            + ", Cuota: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisCuotacapitalmasintereses() + ", Abonando a: capital, intereses, seguro de deuda y aportaciones"
                            + ", Linea de prestamo: " + analisisenagendacomitecreditos.getAnalisis().getSolicitudId().getAsesoriaId().getDetallelineacreditoId().getLineacreditoId().getLineacreditoNombre();
                }
            }

            if (analisisenagendacomitecreditos.getTiporesolucionId() != null && analisisenagendacomitecreditos.getTiporesolucionId().getTiporesolucionId() == 3) {

                if (devueltas.isEmpty()) {
                    devueltas = devueltas
                            + analisisenagendacomitecreditos.getAnalisis().getSolicitudId().getNombreCompleto()
                            + ", Monto Aprobado: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisMonto()
                            + ", Plazo: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisPlazo()
                            + ", Tasa de interes anual: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisTasa()
                            + ", Cuota: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisCuotacapitalmasintereses() + ", Abonando a: capital, intereses, seguro de deuda y aportaciones"
                            + ", Linea de prestamo: " + analisisenagendacomitecreditos.getAnalisis().getSolicitudId().getAsesoriaId().getDetallelineacreditoId().getLineacreditoId().getLineacreditoNombre();
                } else {
                    devueltas = devueltas + ", "
                            + analisisenagendacomitecreditos.getAnalisis().getSolicitudId().getNombreCompleto()
                            + ", Monto Solicitado: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisMonto()
                            + ", Plazo: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisPlazo()
                            + ", Tasa de interes anual: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisTasa()
                            + ", Cuota: " + analisisenagendacomitecreditos.getAnalisis().getAnalisisCuotacapitalmasintereses() + ", Abonando a: capital, intereses, seguro de deuda y aportaciones"
                            + ", Linea de prestamo: " + analisisenagendacomitecreditos.getAnalisis().getSolicitudId().getAsesoriaId().getDetallelineacreditoId().getLineacreditoId().getLineacreditoNombre();
                }
            }
        }

        if (aprobadas.isEmpty()) {
            aprobadas = "Ninguna solicitud";
        }
        
        if (denegadas.isEmpty()) {
            denegadas = "Ningun asociado";
        }
        
        if (devueltas.isEmpty()) {
            devueltas = "Ningun asociado";
        }

        pojo.setAsistentes(asistentes);
        pojo.setSolicitudesAprobadas(aprobadas);
        pojo.setSolicitudesDenegadas(denegadas);
        pojo.setSolicitudesDevueltas(devueltas);
        
        return pojo;
    }
}
