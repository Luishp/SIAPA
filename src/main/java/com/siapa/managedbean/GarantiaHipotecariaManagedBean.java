package com.siapa.managedbean;

import com.siapa.jasper.Reporte;
import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.model.Analisis;
import com.siapa.model.Estadoregistral;
import com.siapa.model.Municipios;
import com.siapa.model.Propietarioinmueble;
import com.siapa.model.PropietarioinmueblePK;
import com.siapa.model.Registrogarantiahipotecaria;
import com.siapa.model.Tipoinmueble;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.service.AnalisisService;
import com.siapa.service.GarantiaHipotecariaService;
import com.siapa.service.MunicipioService;
import com.siapa.service.PropietarioInmuebleService;
import com.siapa.service.TipoInmuebleService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.compilers.JavaScriptEvaluatorScope;
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
@Named("garantiaHipotecariaManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class GarantiaHipotecariaManagedBean extends GenericManagedBean<Registrogarantiahipotecaria, Integer> {

    @Autowired
    @Qualifier(value = "garantiaHipotecariaService")
    private GarantiaHipotecariaService garantiaHipotecariaService;
    @Autowired
    @Qualifier(value = "analisisService")
    private AnalisisService analisisService;
    @Autowired
    @Qualifier(value = "municipioService")
    private MunicipioService municipioService;
    @Autowired
    @Qualifier(value = "tipoInmuebleService")
    private TipoInmuebleService tipoInmuebleService;
    @Autowired
    @Qualifier(value = "propietarioInmuebleService")
    private PropietarioInmuebleService propietarioInmuebleService;
    private String reportName;
    private Integer idAnalisis;
    private Integer idTipoGarantia;
    private List<Municipios> municipios;
    private Municipios municipio;
    private List<Tipoinmueble> tiposInmuebles;
    private Tipoinmueble tiposInmueble;
    private Estadoregistral estadoRegistral;
    private List<Propietarioinmueble> propietarios;
    private List<Registrogarantiahipotecaria> garantiasHipotecarias;

    private Propietarioinmueble propietario;
    private int ordenPropietario;
    private String nombreAsociado;
    private String codigoSocio;
    private String codigoSolicitud;
    private final String urlgarantias = "/siacofinges/views/garantia/index.xhtml";

    @Override
    public GenericService<Registrogarantiahipotecaria, Integer> getService() {
        return garantiaHipotecariaService;
    }

    @PostConstruct
    public void init() {
        Registrogarantiahipotecaria ga = new Registrogarantiahipotecaria();
        setSelected(ga);
        FacesContext context = FacesContext.getCurrentInstance();
        idAnalisis = (Integer) context.getExternalContext().getSessionMap().get("idAnalisis");
        idTipoGarantia = (Integer) context.getExternalContext().getSessionMap().get("idGarantia");

        nombreAsociado = (String) context.getExternalContext().getSessionMap().get("nombreSocio");
        codigoSocio = (String) context.getExternalContext().getSessionMap().get("codigoSocio");
        codigoSolicitud = (String) context.getExternalContext().getSessionMap().get("codigoSolicitud");

        context.getExternalContext().getSessionMap().remove("idAnalisis");
        context.getExternalContext().getSessionMap().remove("idGarantia");
        context.getExternalContext().getSessionMap().remove("nombreSocio");
        context.getExternalContext().getSessionMap().remove("codigoSocio");
        context.getExternalContext().getSessionMap().remove("codigoSolicitud");

        garantiasHipotecarias = garantiaHipotecariaService.findGarantiasByAnalisis(idAnalisis);
    }

    public GarantiaHipotecariaManagedBean() {

    }

    @Override
    public LazyDataModel<Registrogarantiahipotecaria> getNewLazyModel() {
        return null;
    }

    public void cargarPropietarios() {
        propietarios = propietarioInmuebleService.findAll();
    }

    public void cargarListas() {
        municipios = municipioService.findAll();
        tiposInmuebles = tipoInmuebleService.findAll();
        propietarios = new ArrayList<Propietarioinmueble>();
        estadoRegistral = new Estadoregistral();
        propietario = new Propietarioinmueble();
        tiposInmueble = new Tipoinmueble();
    }

    public void toCreateGarantiaHipotecaria(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            cargarListas();
            setSelected(new Registrogarantiahipotecaria());
            contex.getExternalContext().redirect("/siacofinges/views/garantia/hipotecaria/hipotecariaindex.xhtml");
        } catch (IOException ex) {
            System.out.println("error" + ex);
        }
    }

    public void cancelar(ActionEvent event) {

        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect(urlgarantias);

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Registrogarantiahipotecaria.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Metodo para asignar valores en el dialogo de asignar el estado registral
     *
     * @param event
     */
    public void dialogAsignarEstadoRegistral(ActionEvent event) {
        System.out.println("");
    }

    /**
     * Metodo para guardar la asignacion de garantias a una asesoria
     *
     * @param event
     */
    public void guardarAsignacionEstadoRegistral(ActionEvent event) {

    }

    public Propietarioinmueble agregarPropietarioUnicoDialog(ActionEvent event) {
        Propietarioinmueble newItem;
        newItem = new Propietarioinmueble();
        this.propietario = newItem;
        return newItem;

    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        setPropietario(null);
    }

    /**
     * Metodo para guardar la asignacion de garantias a una asesoria
     *
     * @param event
     */
    public void guardarPropietario(ActionEvent event) {
        System.out.println("Entro");

        try {
            ordenPropietario = ordenPropietario + 1;
            PropietarioinmueblePK pipk = new PropietarioinmueblePK();
            pipk.setCorrelativo(ordenPropietario);
            propietario.setActivo("SI");
            propietario.setPropietarioinmueblePK(pipk);
            propietario.setUsuarioRegistro(getUsuario());
            propietario.setFechaRegistro(new Date());
            propietarios.add(propietario);
            propietario = new Propietarioinmueble();
        } catch (Exception e) {
            System.out.println("Error al intentar guardar" + e);
        }

    }

    public void print() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        Reporte reporte = new Reporte("mnt", "bancos", request);
        reporte.setDataSource(new JRBeanCollectionDataSource(new HashSet<Registrogarantiahipotecaria>(garantiaHipotecariaService.findAll())));
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
                getSelected().setAnalisisId(anlst);
                Tipoinmueble tipoInmueble = tipoInmuebleService.findById(tiposInmueble.getTipoInmuebleId());
                getSelected().setTipoInmuebleId(tipoInmueble);
                getSelected().setIdMunicipio(municipio);
                getSelected().setActivo("SI");
                getSelected().setUsuarioRegistro(getUsuario());
                getSelected().setFechaRegistro(new Date());
                getService().save(getSelected());
                JsfUtil.addSuccessMessage("Correcto ", "Garantia Hipotecaria Guardada");

                try {
                    FacesContext contex = FacesContext.getCurrentInstance();
                    garantiasHipotecarias = garantiaHipotecariaService.findGarantiasByAnalisis(idAnalisis);
                    contex.getExternalContext().redirect("/siacofinges/views/garantia/hipotecaria/index.xhtml");
                } catch (IOException xe) {
                    JsfUtil.addErrorMessage("Error ", "Error para redirigir a la pagina principal ");
                    System.out.println("Error " + xe);
                }

            } catch (Exception e) {
                JsfUtil.addErrorMessage("Error ", "Error Guardando Garantia Hipotecaria ");
                System.out.println("Error " + e);
            }

        }
    }

    @Override
    public void save(ActionEvent event) {
        String msg = "Garantia Actualizada";
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

    public List<Municipios> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipios> municipios) {
        this.municipios = municipios;
    }

    public Municipios getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipios municipio) {
        this.municipio = municipio;
    }

    public List<Tipoinmueble> getTiposInmuebles() {
        return tiposInmuebles;
    }

    public void setTiposInmuebles(List<Tipoinmueble> tiposInmuebles) {
        this.tiposInmuebles = tiposInmuebles;
    }

    public Tipoinmueble getTiposInmueble() {
        return tiposInmueble;
    }

    public void setTiposInmueble(Tipoinmueble tiposInmueble) {
        this.tiposInmueble = tiposInmueble;
    }

    public Estadoregistral getEstadoRegistral() {
        return estadoRegistral;
    }

    public void setEstadoRegistral(Estadoregistral estadoRegistral) {
        this.estadoRegistral = estadoRegistral;
    }

    public List<Propietarioinmueble> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(List<Propietarioinmueble> propietarios) {
        this.propietarios = propietarios;
    }

    public Propietarioinmueble getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietarioinmueble propietario) {
        this.propietario = propietario;
    }

    public int getOrdenPropietario() {
        return ordenPropietario;
    }

    public void setOrdenPropietario(int ordenPropietario) {
        this.ordenPropietario = ordenPropietario;
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

    public List<Registrogarantiahipotecaria> getGarantiasHipotecarias() {
        return garantiasHipotecarias;
    }

    public void setGarantiasHipotecarias(List<Registrogarantiahipotecaria> garantiasHipotecarias) {
        this.garantiasHipotecarias = garantiasHipotecarias;
    }

}
