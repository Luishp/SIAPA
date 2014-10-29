/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.jasper.Reporte;
import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.model.Analisis;
import com.siapa.model.Asociados;
import com.siapa.model.Resolucion;
import com.siapa.model.managedbean.pojos.SolictudesAprobadasPojo;
import com.siapa.pojos.rpt.solicitudesaprobadas.ReporteBuroDeCreditoPojo;
import com.siapa.pojos.rpt.solicitudesaprobadas.ReporteDesignacionAseguradoraPojo;
import com.siapa.pojos.rpt.solicitudesaprobadas.ReporteDesignacionNotarialpojo;
import com.siapa.pojos.rpt.solicitudesaprobadas.ReporteOrdenDescuentoPojo;
import com.siapa.service.AnalisisService;
import com.siapa.service.generic.GenericService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@Named("solicitudesAprobadasManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class SolicitudesAprobadasManagedBean extends GenericManagedBean<Object, Serializable> {

    @Autowired
    @Qualifier(value = "analisisService")
    private AnalisisService analisisService;

    private Asociados asociado;
    private String lineaCredito;
    private String fechaResolucion;
    private Resolucion resolucion;
    private List<Object> resolucionAprobados = new ArrayList<Object>();
    private List<String> selectedbox;
    private List<SolictudesAprobadasPojo> listadoTabla;
    private List<Analisis> analisisItems;
    private Analisis analisisSelected;
    
    private String reportName;

    @Override
    public GenericService<Object, Serializable> getService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LazyDataModel<Object> getNewLazyModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void actualizarAnalisisItems() {
        analisisItems = analisisService.buscarParaDesembolso();
    }

     public void printDesignacionNotarial() {

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        List<ReporteDesignacionNotarialpojo> list = new ArrayList<ReporteDesignacionNotarialpojo>();
        list.add(analisisService.fillAnalisisParaDesignacionNotarial(analisisSelected));
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        Reporte reporte = new Reporte("solicitudesaprobadas", "CartadeDesignacionNotarial", request);
        reporte.setDataSource(new JRBeanCollectionDataSource(new HashSet<ReporteDesignacionNotarialpojo>(list)));
        reporte.setReportInSession(request, response);
        setReportName(reporte.getNombreLogico());
        RequestContext.getCurrentInstance().addCallbackParam("reportName", getReportName());

    }
    
     public void printCartaBuroDeCredito() {

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        List<ReporteBuroDeCreditoPojo> list = new ArrayList<ReporteBuroDeCreditoPojo>();
        list.add(analisisService.fillAnalisisParaCartaBuroCredito(analisisSelected));
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        Reporte reporte = new Reporte("solicitudesaprobadas", "CartaparaBurosdeCreditos", request);
        reporte.setDataSource(new JRBeanCollectionDataSource(new HashSet<ReporteBuroDeCreditoPojo>(list)));
        reporte.setReportInSession(request, response);
        setReportName(reporte.getNombreLogico());
        RequestContext.getCurrentInstance().addCallbackParam("reportName", getReportName());

    }
    
     public void printDesignacionAseguradora() {

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        List<ReporteDesignacionAseguradoraPojo> list = new ArrayList<ReporteDesignacionAseguradoraPojo>();
        list.add(analisisService.fillAnalisisParaDesignacionAseguradora(analisisSelected));
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        Reporte reporte = new Reporte("solicitudesaprobadas", "CartadeFechasdeDesignaciondeAseguradoras", request);
        reporte.setDataSource(new JRBeanCollectionDataSource(new HashSet<ReporteDesignacionAseguradoraPojo>(list)));
        reporte.setReportInSession(request, response);
        setReportName(reporte.getNombreLogico());
        RequestContext.getCurrentInstance().addCallbackParam("reportName", getReportName());

    }
    
     public void printOrdenIrrebocableDescuento() {

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        List<ReporteOrdenDescuentoPojo> list = new ArrayList<ReporteOrdenDescuentoPojo>();
        list.add(analisisService.fillAnalisisParaOrdenDescuento(analisisSelected));
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        Reporte reporte = new Reporte("solicitudesaprobadas", "CartadeOrdendeDescuento", request);
        reporte.setDataSource(new JRBeanCollectionDataSource(new HashSet<ReporteOrdenDescuentoPojo>(list)));
        reporte.setReportInSession(request, response);
        setReportName(reporte.getNombreLogico());
        RequestContext.getCurrentInstance().addCallbackParam("reportName", getReportName());

    }
     public void printConoscaSuCliente() {

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        List<ReporteOrdenDescuentoPojo> list = new ArrayList<ReporteOrdenDescuentoPojo>();
        list.add(new ReporteOrdenDescuentoPojo());
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        Reporte reporte = new Reporte("solicitudesaprobadas", "ConoscaCliente", request);
        reporte.setDataSource(new JRBeanCollectionDataSource(new HashSet<ReporteOrdenDescuentoPojo>(list)));
        reporte.setReportInSession(request, response);
        setReportName(reporte.getNombreLogico());
        RequestContext.getCurrentInstance().addCallbackParam("reportName", getReportName());

    }
    
    
    public Asociados getAsociado() {
        return asociado;
    }

    public void setAsociado(Asociados asociado) {
        this.asociado = asociado;
    }

    public Resolucion getResolucion() {
        return resolucion;
    }

    public void setResolucion(Resolucion resolucion) {
        this.resolucion = resolucion;
    }

    public List<Object> getResolucionAprobados() {
        return resolucionAprobados;
    }

    public void setResolucionAprobados(List<Object> resolucionAprobados) {
        this.resolucionAprobados = resolucionAprobados;
    }

    public String getLineaCredito() {
        return lineaCredito;
    }

    public void setLineaCredito(String lineaCredito) {
        this.lineaCredito = lineaCredito;
    }

    public String getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(String fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public List<String> getSelectedbox() {
        return selectedbox;
    }

    public void setSelectedbox(List<String> selectedbox) {
        this.selectedbox = selectedbox;
    }

    public List<SolictudesAprobadasPojo> getListadoTabla() {
        return listadoTabla;
    }

    public void setListadoTabla(List<SolictudesAprobadasPojo> listadoTabla) {
        this.listadoTabla = listadoTabla;
    }

    public List<Analisis> getAnalisisItems() {
        return analisisItems;
    }

    public void setAnalisisItems(List<Analisis> analisisItems) {
        this.analisisItems = analisisItems;
    }

    public Analisis getAnalisisSelected() {
        return analisisSelected;
    }

    public void setAnalisisSelected(Analisis analisisSelected) {
        this.analisisSelected = analisisSelected;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

}
