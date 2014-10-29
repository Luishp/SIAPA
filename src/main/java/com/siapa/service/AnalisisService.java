/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.AnalisisDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Analisis;
import com.siapa.model.Consultaburocredito;
import com.siapa.model.Nivelresolucion;
import com.siapa.pojos.rpt.analisis.ReporteAnalisisPojo;
import com.siapa.pojos.rpt.analisis.RptAnalisisPerfilAsociadoPojo;
import com.siapa.pojos.rpt.analisis.RptBurosCredito;
import com.siapa.pojos.rpt.analisis.RptFormaPago;
import com.siapa.pojos.rpt.informegerencial.RptInformeGerencial;
import com.siapa.pojos.rpt.solicitudesaprobadas.ReporteBuroDeCreditoPojo;
import com.siapa.pojos.rpt.solicitudesaprobadas.ReporteDesignacionAseguradoraPojo;
import com.siapa.pojos.rpt.solicitudesaprobadas.ReporteDesignacionNotarialpojo;
import com.siapa.pojos.rpt.solicitudesaprobadas.ReporteOrdenDescuentoPojo;
import com.siapa.service.generic.GenericService;
import com.siapa.utils.NumberToLetterConverter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kof
 */
@Service(value = "analisisService")
public class AnalisisService extends GenericService<Analisis, Integer> {

    @Autowired
    private AnalisisDao analisisDao;

    @Override
    public GenericDao<Analisis, Integer> getDao() {
        return analisisDao;
    }

    public List<Analisis> buscarListosParaAgenda() {
        return analisisDao.buscarListosParaAgenda();
    }

    public List<Analisis> buscarParaEnvioResolucion() {
        return analisisDao.buscarParaEnvioResolucion();
    }

    public List<Analisis> buscarParaDesembolso() {
        return analisisDao.buscarParaDesembolso();
    }

    public List<Analisis> findByAccId(Integer accId) {
        return analisisDao.findByAccId(accId);
    }

    public List<Analisis> buscarParaResolucion(Integer nivelResolucion) {
        return analisisDao.buscarParaResolucion(nivelResolucion);
    }

    public Analisis fillAnalisis(Analisis analisis) {
        return analisisDao.fillAnalisis(analisis);
    }

    public List<Analisis> buscarAnalisisIncompletos() {
        return analisisDao.buscarAnalisisIncompletos();
    }

    /**
     * Metodo
     *
     * @param listadeAnalisis
     * @param nivel
     * @return
     */
    public boolean enviarResolucion(List<Analisis> listadeAnalisis, Nivelresolucion nivel) {

        try {
            for (Analisis analisis : listadeAnalisis) {
                analisis.setNrId(nivel);
                analisisDao.merge(analisis);
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public ReporteAnalisisPojo fillAnalisisForReport(Analisis analisis) {
        ReporteAnalisisPojo pojo = null;
        Analisis a = analisisDao.fillAnalisisForReport(analisis);

        //Pojo Perfil Asociado
        RptAnalisisPerfilAsociadoPojo datosAsociado = new RptAnalisisPerfilAsociadoPojo();
        datosAsociado.setFechaIngreso("23/04/2013");
        datosAsociado.setFechaReIngreso("");
        datosAsociado.setProfesion(a.getSolicitudId().getAsesoriaId().getIdasociados().getIdasocnatu().getNivelEstudio());
        datosAsociado.setReferidoPor("Jose Perez");
        datosAsociado.setSaldoActualEnAportaciones(a.getSolicitudId().getSolicitudAportacionactivo() != null ? a.getSolicitudId().getSolicitudAportacionactivo().toString() : "0.0");
        datosAsociado.setComplementoDeAportaciones("0.0");

        //falta asegurabilidad
        //buros de credito
        List<RptBurosCredito> burosList = new ArrayList<RptBurosCredito>();
        for (Consultaburocredito buro : a.getConsultaburocreditoList()) {
            RptBurosCredito temp = new RptBurosCredito();
            temp.setNombre(buro.getCbcNombre());
            temp.setCalificacion(buro.getCbdCalificacion());;
            temp.setComentario(buro.getCbcComentario());
            burosList.add(temp);
        }
        
        RptFormaPago fp = new RptFormaPago();
        fp.setPeriodicidad(a.getSolicitudId().getPpId().getPpNombre());

        return pojo;
    }

    public RptInformeGerencial fillAnalisisParaInformeGerencial(Analisis analisis) {

        RptInformeGerencial pojo = new RptInformeGerencial();
        Analisis tmp = analisisDao.fillAnalisis(analisis);

        pojo.setSolicitante(tmp.getSolicitudId().getNombreCompleto());
        pojo.setFingreso("23/04/2013");
        pojo.setCodigo(tmp.getSolicitudId().getSolicitudCodigoasociado());
        pojo.setSaldoaportacion(tmp.getAnalisisAportaciones() != null ? tmp.getAnalisisAportaciones().toString() : "0.00");
        pojo.setTipogarantia("");
        pojo.setTotalingreso(tmp.getAnalisisTotalingreso() != null ? tmp.getAnalisisTotalingreso().toString() : "0.00");
        pojo.setAhorroaplazo("0.00");
        pojo.setSuveinte(tmp.getAnalisisTotalingreso().multiply(new BigDecimal("0.20")).toString());
        pojo.setDisponible(tmp.getAnalisisRentaneta() != null ? tmp.getAnalisisRentaneta().toString() : "0.00");
        pojo.setAhorroalavista("0.00");
        pojo.setDestino(tmp.getSolicitudId().getSolicitudDestino());
        pojo.setSaldo("0.00");

        pojo.setMontosolic(tmp.getAnalisisMonto().toString());
        pojo.setLinea(tmp.getSolicitudId().getAsesoriaId().getDetallelineacreditoId().getLineacreditoId().getLineacreditoNombre());
        pojo.setTasa(tmp.getAnalisisTasa() != null ? tmp.getAnalisisTasa().toString() : "0.00");
        pojo.setPlazo(tmp.getAnalisisPlazo() != null ? tmp.getAnalisisPlazo().toString() : "0.00");

        pojo.setTramite(tmp.getSolicitudId().getAsesoriaId().getAsesoriaHonorariojuridico() != null ? tmp.getSolicitudId().getAsesoriaId().getAsesoriaHonorariojuridico().toString() : "0.00");
        pojo.setSaldoprestamo("0.00");
        pojo.setInteresal("0.00");
        pojo.setMora("0.00");
        pojo.setSeguro(tmp.getAnalisisSegurodeuda() != null ? tmp.getAnalisisSegurodeuda().toString() : "0.00");
        pojo.setAportaciones(tmp.getAnalisisAportaciones() != null ? tmp.getAnalisisAportaciones().toString() : "0.00");
        pojo.setOtros("0.00");

        pojo.setCuotaCapitaleintereses(tmp.getAnalisisCuotacapitalmasintereses() != null ? tmp.getAnalisisCuotacapitalmasintereses().toString() : "0.00");
        pojo.setCuotaSeguro(tmp.getAnalisisSegurodeuda() != null ? tmp.getAnalisisSegurodeuda().toString() : "0.00");
        pojo.setCuotaAportaciones("10.00");
        pojo.setCuotaAhorrosimultaneo("10.00");
        pojo.setCuotaSegurodaños(tmp.getAnalisisSegurodano() != null ? tmp.getAnalisisSegurodano().toString() : "0.00");

        pojo.setComentarios(tmp.getAnalisisObservacion());

        return pojo;
    }

    public ReporteDesignacionNotarialpojo fillAnalisisParaDesignacionNotarial(Analisis analisis) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        ReporteDesignacionNotarialpojo pojo = new ReporteDesignacionNotarialpojo();
        Analisis tmp = analisisDao.fillAnalisis(analisis);

        pojo.setAsociadoCodigo(tmp.getSolicitudId().getAsesoriaId().getIdasociados().getCodigo());
        pojo.setAsociadoNombre(tmp.getSolicitudId().getNombreCompleto());
        pojo.setAsociadoDui(tmp.getSolicitudId().getAsesoriaId().getIdasociados().getIdasocnatu().getNoDui());

        pojo.setNotarioNombre("Lic. Francisco Cotto");

        pojo.setPrestamoMonto(tmp.getAnalisisMonto().toString());
        // pojo.setPrestamoMontoLetras("Diez mil dolares con 00/100 centavos");
        pojo.setPrestamoMontoLetras(NumberToLetterConverter.convertNumberToLetter(tmp.getAnalisisMonto().doubleValue()));
        pojo.setPrestamoNumero(tmp.getResolucionId().getAnalisisId().getSolicitudId().getAsesoriaId().getDetallelineacreditoId().getLineacreditoId().getLineacreditoNombre());
        pojo.setFecha(df.format(tmp.getFechaRegistro()));

        return pojo;

    }

    public ReporteBuroDeCreditoPojo fillAnalisisParaCartaBuroCredito(Analisis analisis) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        ReporteBuroDeCreditoPojo pojo = new ReporteBuroDeCreditoPojo();
        Analisis tmp = analisisDao.fillAnalisis(analisis);

        pojo.setAsociadoCodigo(tmp.getSolicitudId().getAsesoriaId().getIdasociados().getCodigo());
        pojo.setAsociadoNombre(tmp.getSolicitudId().getNombreCompleto());
        pojo.setAsociadoDui(tmp.getSolicitudId().getAsesoriaId().getIdasociados().getIdasocnatu().getNoDui());

        pojo.setFecha(df.format(tmp.getFechaRegistro()));

        return pojo;

    }

    public ReporteDesignacionAseguradoraPojo fillAnalisisParaDesignacionAseguradora(Analisis analisis) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Analisis tmp = analisisDao.fillAnalisis(analisis);
        ReporteDesignacionAseguradoraPojo pojo = new ReporteDesignacionAseguradoraPojo();

        pojo.setAsociadoCodigo(tmp.getSolicitudId().getAsesoriaId().getIdasociados().getCodigo());
        pojo.setAsociadoNombre(tmp.getSolicitudId().getNombreCompleto());
        pojo.setAsociadoDui(tmp.getSolicitudId().getAsesoriaId().getIdasociados().getIdasocnatu().getNoDui());

        pojo.setFecha(df.format(tmp.getFechaRegistro()));

        return pojo;
    }

    public ReporteOrdenDescuentoPojo fillAnalisisParaOrdenDescuento(Analisis analisis) {
        ReporteOrdenDescuentoPojo pojo = new ReporteOrdenDescuentoPojo();

        return pojo;
    }
}
