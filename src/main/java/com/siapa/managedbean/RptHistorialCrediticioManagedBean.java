package com.siapa.managedbean;

import com.siapa.jasper.Reporte;
import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.model.Asociados;
import com.siapa.service.generic.GenericService;
import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Mely
 */
@Named("rptHistorialCrediticioManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class RptHistorialCrediticioManagedBean extends GenericManagedBean<Object, Serializable>{

     private Asociados asociado;
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
      public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }
    public Asociados getAsociado() {
        return asociado;
    }

    public void setAsociado(Asociados asociado) {
        this.asociado = asociado;
    }
    
}