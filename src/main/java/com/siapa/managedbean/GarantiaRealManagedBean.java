package com.siapa.managedbean;

import com.siapa.jasper.Reporte;
import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.model.Analisis;
import com.siapa.model.Asociados;
import com.siapa.model.Garantiaasignadaasesoria;
import com.siapa.model.Registrogarantiareal;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.service.AnalisisService;
import com.siapa.service.AsociadoService;
import com.siapa.service.GarantiaRealService;
import com.siapa.service.RegistrarGarantiasService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
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
@Named("garantiaRealManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class GarantiaRealManagedBean extends GenericManagedBean<Registrogarantiareal, Integer> {

    @Autowired
    @Qualifier(value = "garantiaRealService")
    private GarantiaRealService garantiaRealService;
    private String reportName;
    private Integer idAnalisis;
    private List<Registrogarantiareal> garantiasReales;
    private Integer idTipoGarantia;
    private Registrogarantiareal garantiaReal;
    private Asociados asociado;
    private String nombreAsociado;
    private String codigoSocio;
    private String codigoSolicitud;
    @Autowired
    @Qualifier(value = "analisisService")
    private AnalisisService analisisService;
    private final String urlgarantias = "/siacofinges/views/garantia/index.xhtml";
    @Override
    public GenericService<Registrogarantiareal, Integer> getService() {
        return garantiaRealService;
    }

    @PostConstruct
    public void init() {

        FacesContext context = FacesContext.getCurrentInstance();
        idAnalisis = (Integer) context.getExternalContext().getSessionMap().get("idAnalisis");
        idTipoGarantia=(Integer) context.getExternalContext().getSessionMap().get("idGarantia");
        
        nombreAsociado=(String) context.getExternalContext().getSessionMap().get("nombreSocio");
        codigoSocio=(String) context.getExternalContext().getSessionMap().get("codigoSocio");
        codigoSolicitud=(String) context.getExternalContext().getSessionMap().get("codigoSolicitud");
        
        garantiasReales = garantiaRealService.findGarantiasRealesByAnalisis(idAnalisis);
        context.getExternalContext().getSessionMap().remove("idAnalisis");
        context.getExternalContext().getSessionMap().remove("idGarantia");
        context.getExternalContext().getSessionMap().remove("nombreSocio");
        context.getExternalContext().getSessionMap().remove("codigoSocio");
        context.getExternalContext().getSessionMap().remove("codigoSolicitud");
    }

    public GarantiaRealManagedBean() {
    }

    @Override
    public LazyDataModel<Registrogarantiareal> getNewLazyModel() {
        return null;
    }
       
    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        setGarantiaReal(null);
    }
    
        /**
     * Metodo para asignar valores en el dialogo de asignar el estado registral
     *
     * @param event
     */
    public void dialogCrearGarantiaReal(ActionEvent event) {
        System.out.println("");
    }
    
    public void cancelar(ActionEvent event) {

        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect(urlgarantias);

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Registrogarantiareal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

/**
 * Metodo para prepararla creacion de una garantiaReal
 * @param event
 * @return 
 */
    public Registrogarantiareal agregarGarantiaRealDialog(ActionEvent event) {
        Registrogarantiareal newItem;
        newItem = new Registrogarantiareal();
        this.garantiaReal = newItem;
        return newItem;
    }

    public void print() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        Reporte reporte = new Reporte("mnt", "bancos", request);
        reporte.setDataSource(new JRBeanCollectionDataSource(new HashSet<Registrogarantiareal>(garantiaRealService.findAll())));
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

    @Override
    public void saveNew(ActionEvent event) {
        if (getUsuario() != null) {
            String msg = "garantia creada";

            try {
                Analisis anlst = analisisService.findById(idAnalisis);
                garantiaReal.setAnalisisId(anlst);
                garantiaReal.setUsuarioRegistro(getUsuario());
                garantiaReal.setFechaRegistro(new Date());
                garantiaReal.setActivo("SI");
                garantiaReal.setRgrValidar(true);
                BigDecimal porcentaje;
                porcentaje=garantiaReal.getRgrPorcentajepignorado();
                garantiaReal.setRgrPorcentajepignorado(porcentaje.divide(new BigDecimal(100)));
                garantiaRealService.save(garantiaReal);
                garantiasReales=garantiaRealService.findGarantiasRealesByAnalisis(idAnalisis);
                JsfUtil.addSuccessMessage(msg);
            } catch (Exception e) {
                JsfUtil.addErrorMessage(ResourceBundle.getBundle("/crudbundle").getString("PersistenceErrorOccured"));
            }


        }
    }

    /**
     * Metodo para quitar una Garantia Real asociada a una solicitud de Credito
     * @param event 
     */
        public void quitarGarantiaReal(ActionEvent event) {
        try {
            garantiaRealService.delete(getSelected());
            garantiasReales=garantiaRealService.findGarantiasRealesByAnalisis(idAnalisis);
        } catch (Exception e) {
            garantiasReales=garantiaRealService.findGarantiasRealesByAnalisis(idAnalisis);
            String msge = "";
            Throwable cause = JsfUtil.getRootCause(e.getCause());
            if (cause != null) {
                msge = cause.getLocalizedMessage();
            }
            if (msge.length() > 0) {
                JsfUtil.addErrorMessage("ERROR ELIMINANDO GARANTIA REAL" + garantiaReal.getRgrId());
            } else {
                JsfUtil.addErrorMessage(e, "ERROR ELIMINANDO GARANTIA REAL " + garantiaReal.getRgrId());
            }
        }

    }
        
    @Override
    public void save(ActionEvent event) {
        String msg = ResourceBundle.getBundle("/crudbundle").getString(Registrogarantiareal.class.getSimpleName() + "Updated");
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

    public List<Registrogarantiareal> getGarantiasReales() {
        return garantiasReales;
    }

    public void setGarantiasReales(List<Registrogarantiareal> garantiasReales) {
        this.garantiasReales = garantiasReales;
    }

    public Registrogarantiareal getGarantiaReal() {
        return garantiaReal;
    }

    public void setGarantiaReal(Registrogarantiareal garantiaReal) {
        this.garantiaReal = garantiaReal;
    }

    public Asociados getAsociado() {
        return asociado;
    }

    public void setAsociado(Asociados asociado) {
        this.asociado = asociado;
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
