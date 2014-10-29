/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.jasper.Reporte;
import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.AsesoriaLazyModel;
import com.siapa.model.Asesoria;
import com.siapa.service.AsesoriaService;
import com.siapa.service.generic.GenericService;
import java.util.HashSet;
import javax.annotation.PostConstruct;
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

/**
 *
 * @author marlon.andrade
 */
@Named("asesoriasSolictudManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class AsesoriasSolicitudManagedBean extends GenericManagedBean<Asesoria, Integer> {

    @Autowired
    @Qualifier(value = "asesoriaService")
    private AsesoriaService asesoriaService;
    private String reportName;

    @Override
    public GenericService<Asesoria, Integer> getService() {
        return asesoriaService;
    }

    @PostConstruct
    public void init() {
        loadLazyModels();
    }

    public AsesoriasSolicitudManagedBean() {
    }

    @Override
    public LazyDataModel<Asesoria> getNewLazyModel() {
        return new AsesoriaLazyModel(asesoriaService);
    }

    public void print() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        Reporte reporte = new Reporte("mnt", "asesorias", request);
        reporte.setDataSource(new JRBeanCollectionDataSource(new HashSet<Asesoria>(asesoriaService.findAll())));
        reporte.setReportInSession(request, response);
        reportName = reporte.getNombreLogico();
        RequestContext.getCurrentInstance().
                addCallbackParam("reportName", reportName);
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

}
