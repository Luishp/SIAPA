/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.jasper.Reporte;
import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.model.Asociados;
import com.siapa.model.managedbean.pojos.SolictudesAprobadasPojo;
import com.siapa.service.generic.GenericService;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@Named("desembolsosIngresadosManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class DesembolsosIngresadosManagedBean extends GenericManagedBean<Object, Serializable> {

    private Asociados asociado;
    private String lineaCredito;
    private String fechaResolucion;
     private List<SolictudesAprobadasPojo> listadoTabla;
      private String reportName;

    @Override
    public GenericService<Object, Serializable> getService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LazyDataModel<Object> getNewLazyModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void print() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        Reporte reporte = new Reporte("mnt", "dondetienequeestar", request);
//        reporte.setDataSource(new JRBeanCollectionDataSource(new HashSet<Actacomitecredito>(actaComiteCreditoService.findAll())));
        reporte.setReportInSession(request, response);
        setReportName(reporte.getNombreLogico());
        RequestContext.getCurrentInstance().
                addCallbackParam("reportName", getReportName());
    }

    public Asociados getAsociado() {
        return asociado;
    }

    public void setAsociado(Asociados asociado) {
        this.asociado = asociado;
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

    public List<SolictudesAprobadasPojo> getListadoTabla() {
        return listadoTabla;
    }

    public void setListadoTabla(List<SolictudesAprobadasPojo> listadoTabla) {
        this.listadoTabla = listadoTabla;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

}