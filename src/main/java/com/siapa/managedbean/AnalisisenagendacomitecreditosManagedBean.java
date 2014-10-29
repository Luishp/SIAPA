/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.jasper.Reporte;
import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.AnalisisEnAgendaComiteCreditosLazyModel;
import com.siapa.model.Analisisenagendacomitecreditos;
import com.siapa.model.AnalisisenagendacomitecreditosPK;
import com.siapa.service.AnalisisEnAgendaComiteCreditosService;
import com.siapa.service.generic.GenericService;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Angel
 *
 */
@Named("analisisenagendacomitecreditosManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class AnalisisenagendacomitecreditosManagedBean extends GenericManagedBean<Analisisenagendacomitecreditos, AnalisisenagendacomitecreditosPK> {

    @Autowired
    @Qualifier(value = "analisisEnAgendaComiteCreditosService")
    private AnalisisEnAgendaComiteCreditosService analisisEnAgendaComiteCreditosService;

    private String reportName;

    @PostConstruct
    public void init() {
        loadLazyModels();
    }

    public void print() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        Reporte reporte = new Reporte("mnt", "dondetienequeestar", request);
        // reporte.setDataSource(new JRBeanCollectionDataSource(new HashSet<Actacomitecredito>(actaComiteCreditoService.findAll())));
        reporte.setReportInSession(request, response);
        reportName = reporte.getNombreLogico();
        RequestContext.getCurrentInstance().
                addCallbackParam("reportName", reportName);
    }

    @Override
    public GenericService<Analisisenagendacomitecreditos, AnalisisenagendacomitecreditosPK> getService() {
        return analisisEnAgendaComiteCreditosService;
    }

   @Override
    public LazyDataModel<Analisisenagendacomitecreditos> getNewLazyModel() {
        return new AnalisisEnAgendaComiteCreditosLazyModel(analisisEnAgendaComiteCreditosService);
    }
}
