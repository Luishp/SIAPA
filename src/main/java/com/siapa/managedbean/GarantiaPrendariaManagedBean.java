package com.siapa.managedbean;

import com.siapa.jasper.Reporte;
import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.GarantiaPrendariaLazyModel;
import com.siapa.model.Analisis;
import com.siapa.model.Registrogarantiaprendaria;
import com.siapa.service.AnalisisService;
import com.siapa.service.GarantiaPrendariaService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
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
 * @author Cristian Oswaldo Fuentes
 */
@Named("garantiaPrendariaManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class GarantiaPrendariaManagedBean extends GenericManagedBean<Registrogarantiaprendaria, Integer> {

    @Autowired
    @Qualifier(value = "garantiaPrendariaService")
    private GarantiaPrendariaService garantiaPrendariaService;
    private String reportName;
    private Integer idAnalisis;
    private Integer idTipoGarantia;
    private String nombreAsociado;
    private String codigoSocio;
    private String codigoSolicitud;
    private final String urlgarantias = "/siacofinges/views/garantia/index.xhtml";
    @Autowired
    @Qualifier(value = "analisisService")
    private AnalisisService analisisService;

    @Override
    public GenericService<Registrogarantiaprendaria, Integer> getService() {
        return garantiaPrendariaService;
    }

    @PostConstruct
    public void init() {
        Registrogarantiaprendaria ga = new Registrogarantiaprendaria();
        setSelected(ga);
        FacesContext context = FacesContext.getCurrentInstance();
        idAnalisis = (Integer) context.getExternalContext().getSessionMap().get("idAnalisis");
        idTipoGarantia=(Integer) context.getExternalContext().getSessionMap().get("idGarantia");
        nombreAsociado=(String) context.getExternalContext().getSessionMap().get("nombreSocio");
        codigoSocio=(String) context.getExternalContext().getSessionMap().get("codigoSocio");
        codigoSolicitud=(String) context.getExternalContext().getSessionMap().get("codigoSolicitud");
        
        context.getExternalContext().getSessionMap().remove("idAnalisis");
        context.getExternalContext().getSessionMap().remove("idGarantia");
        context.getExternalContext().getSessionMap().remove("nombreSocio");
        context.getExternalContext().getSessionMap().remove("codigoSocio");
        context.getExternalContext().getSessionMap().remove("codigoSolicitud");
    }

    public GarantiaPrendariaManagedBean() {
    }

    @Override
    public LazyDataModel<Registrogarantiaprendaria> getNewLazyModel() {
        return new GarantiaPrendariaLazyModel(garantiaPrendariaService);
    }

    public void print() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        Reporte reporte = new Reporte("mnt", "bancos", request);
        reporte.setDataSource(new JRBeanCollectionDataSource(new HashSet<Registrogarantiaprendaria>(garantiaPrendariaService.findAll())));
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

    public void cancelar(ActionEvent event) {

        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect(urlgarantias);

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(GarantiaPrendariaManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        
    @Override
    public void saveNew(ActionEvent event) {
        if (getUsuario() != null) {
            String msg = "garantia creada";
            Analisis anlst = analisisService.findById(idAnalisis);
            getSelected().setAnalisisId(anlst);
            getSelected().setUsuarioRegistro(getUsuario());
            getSelected().setFechaRegistro(new Date());
            getSelected().setActivo("SI");
            persist(PersistAction.CREATE, msg);
        }
    }

    @Override
    public void save(ActionEvent event) {
        String msg = ResourceBundle.getBundle("/crudbundle").getString(Registrogarantiaprendaria.class.getSimpleName() + "Updated");
        getSelected().setUsuarioUltimamodificacion(getUsuario());
        getSelected().setFechaUltimamodificacion(new Date());
        persist(PersistAction.UPDATE, msg);
        if (!isValidationFailed()) {
            items = null; // Invalidate list of items to trigger re-query.
        }
    }

    public Integer getIdAnalisis() {
        return idAnalisis;
    }

    public void setIdAnalisis(Integer idAnalisis) {
        this.idAnalisis = idAnalisis;
    }

    public Integer getIdTipoGarantia() {
        return idTipoGarantia;
    }

    public void setIdTipoGarantia(Integer idTipoGarantia) {
        this.idTipoGarantia = idTipoGarantia;
    }

    public String getNombreAsociado() {
        return nombreAsociado;
    }

    public void setNombreAsociado(String nombreAsociado) {
        this.nombreAsociado = nombreAsociado;
    }

    public String getCodigoSocio() {
        return codigoSocio;
    }

    public void setCodigoSocio(String codigoSocio) {
        this.codigoSocio = codigoSocio;
    }

    public String getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public void setCodigoSolicitud(String codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }

}
