package com.siapa.managedbean;

import com.siapa.jasper.Reporte;
import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.ResolucionLazyModel;
import com.siapa.model.Analisis;
import com.siapa.model.Resolucion;
import com.siapa.model.SsRoles;
import com.siapa.model.Sucursal;
import com.siapa.model.Tiporesolucion;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.security.AppUserDetails;
import com.siapa.service.AnalisisService;
import com.siapa.service.ResolucionService;
import com.siapa.service.TipoResolucionService;
import com.siapa.service.generic.GenericService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Angel
 */
@Named("resolucionManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ResolucionManagedBean extends GenericManagedBean<Resolucion, Integer> {

    @Autowired
    @Qualifier(value = "resolucionService")
    private ResolucionService resolucionService;
    @Autowired
    @Qualifier(value = "analisisService")
    private AnalisisService analisisService;
    @Autowired
    @Qualifier(value = "tipoResolucionService")
    private TipoResolucionService tipoResolucionService;
    private String reportName;

    //listas
    private List<Analisis> analisisList;
    private List<Resolucion> resolucionList;
    private List<Tiporesolucion> tiporesolucionList;

    //variables
    private Analisis analisisSelected;
    private Resolucion resolucionSelected;
    private Resolucion resolucionToEdit;
    private AppUserDetails sessionUser;
    private Integer tipoResolucionSelected;
    private Integer tipoResolucionSelectedInEdit;

    @Override
    public GenericService<Resolucion, Integer> getService() {
        return resolucionService;
    }

    @PostConstruct
    public void init() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        setSessionUser((AppUserDetails) authentication.getPrincipal());
        cargarAnalisisParaResolucion();
        cargarResolucionesParaEditar();
        tiporesolucionList = tipoResolucionService.findAllActives();
        tipoResolucionSelected = 1;

    }

    public ResolucionManagedBean() {
    }

    @Override
    public LazyDataModel<Resolucion> getNewLazyModel() {
        return new ResolucionLazyModel(resolucionService);
    }

    public void print() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        Reporte reporte = new Reporte("mnt", "bancos", request);
        reporte.setDataSource(new JRBeanCollectionDataSource(new HashSet<Resolucion>(resolucionService.findAll())));
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
            String msg = ResourceBundle.getBundle("/crudbundle").getString(Resolucion.class.getSimpleName() + "Created");
            Date hoy = new Date();

            try {
                //Guardar resolucion
                Tiporesolucion tr = new Tiporesolucion(tipoResolucionSelected);
                getResolucionSelected().setTiporesolucionId(tr);

                getResolucionSelected().setNrId(getAnalisisSelected().getNrId());
                getResolucionSelected().setSucursalId(new Sucursal(1));

                getResolucionSelected().setAnalisisId(analisisSelected);
                getResolucionSelected().setUsuarioRegistro(getUsuario());
                getResolucionSelected().setFechaRegistro(hoy);
                getResolucionSelected().setActivo("SI");
                resolucionSelected = resolucionService.merge(resolucionSelected);

                //actualizar analisis
                getAnalisisSelected().setUsuarioUltimamodificacion(getUsuario());
                getAnalisisSelected().setFechaUltimamodificacion(hoy);
                getAnalisisSelected().setResolucionId(resolucionSelected);
                analisisService.merge(analisisSelected);

                cargarAnalisisParaResolucion();
                JsfUtil.addSuccessMessage(msg);

            } catch (Exception e) {
                if (resolucionSelected.getResolucionId() != null) {
                    resolucionService.delete(resolucionSelected);
                }

                getAnalisisSelected().setUsuarioUltimamodificacion(null);
                getAnalisisSelected().setFechaUltimamodificacion(null);
                analisisSelected.setResolucionId(null);
                analisisService.merge(analisisSelected);

                JsfUtil.addErrorMessage("No se pudo guardar la resolucion");
            }

        }
    }

    @Override
    public void save(ActionEvent event) {
        if (getUsuario() != null) {
            String msg = ResourceBundle.getBundle("/crudbundle").getString(Resolucion.class.getSimpleName() + "Updated");
            Date hoy = new Date();

            try {
                //Guardar resolucion
                Tiporesolucion tr = new Tiporesolucion(tipoResolucionSelectedInEdit);
                getResolucionToEdit().setTiporesolucionId(tr);

                getResolucionToEdit().setUsuarioUltimamodificacion(getUsuario());
                getResolucionToEdit().setFechaUltimamodificacion(hoy);
                resolucionSelected = resolucionService.merge(resolucionToEdit);

                cargarResolucionesParaEditar();
                JsfUtil.addSuccessMessage(msg);

            } catch (Exception e) {
                JsfUtil.addErrorMessage("No se pudo modificar la resolucion");
            }

        }
    }

    @Override
    public Resolucion prepareCreate(ActionEvent event) {

        System.out.println("");

        return null;
    }

    public Resolucion prepareView(ActionEvent event) {

        System.out.println("");

        return null;
    }

    public void toCreate() {
        resolucionSelected = new Resolucion();
        resolucionSelected.setFechaResolucion(new Date());
        analisisSelected = analisisService.fillAnalisis(getAnalisisSelected());

        for (SsRoles rol : getSessionUser().getUsuario().getSsRolesList()) {
            if (rol.getCodigoRol().equalsIgnoreCase("scret")) {                 //nivel III
                tipoResolucionSelected = analisisSelected.getTiporesolucionId().getTiporesolucionId();
            }
        }
    }

    public void toEdit() {
        resolucionToEdit = resolucionService.fillResolucion(getResolucionToEdit());
        tipoResolucionSelectedInEdit = resolucionToEdit.getTiporesolucionId().getTiporesolucionId();
    }

    public void cargarAnalisisParaResolucion() {
        analisisList = new ArrayList<Analisis>();

        for (SsRoles rol : getSessionUser().getUsuario().getSsRolesList()) {
            if (rol.getCodigoRol().equalsIgnoreCase("grent")) {                 //nivel I
                analisisList.addAll(analisisService.buscarParaResolucion(1));
            } else if (rol.getCodigoRol().equalsIgnoreCase("jefop")) {
                analisisList.addAll(analisisService.buscarParaResolucion(2));   //nivel II
            } else if (rol.getCodigoRol().equalsIgnoreCase("scret")) {
                analisisList.addAll(analisisService.buscarParaResolucion(3));   //nivel III
                analisisList.addAll(analisisService.buscarParaResolucion(4));   //nivel IV
            }
        }
    }

    public void cargarResolucionesParaEditar() {
        resolucionList = new ArrayList<Resolucion>();

        for (SsRoles rol : getSessionUser().getUsuario().getSsRolesList()) {
            if (rol.getCodigoRol().equalsIgnoreCase("grent")) {                 //nivel I
                resolucionList.addAll(resolucionService.buscarParaEditar(1));
            } else if (rol.getCodigoRol().equalsIgnoreCase("jefop")) {
                resolucionList.addAll(resolucionService.buscarParaEditar(2));   //nivel II
            } else if (rol.getCodigoRol().equalsIgnoreCase("scret")) {
                resolucionList.addAll(resolucionService.buscarParaEditar(3));   //nivel III
                resolucionList.addAll(resolucionService.buscarParaEditar(4));   //nivel IV
            }
        }
    }

    public List<Analisis> getAnalisisList() {
        return analisisList;
    }

    public void setAnalisisList(List<Analisis> analisisList) {
        this.analisisList = analisisList;
    }

    public Analisis getAnalisisSelected() {
        return analisisSelected;
    }

    public void setAnalisisSelected(Analisis analisisSelected) {
        this.analisisSelected = analisisSelected;
    }

    public AppUserDetails getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(AppUserDetails sessionUser) {
        this.sessionUser = sessionUser;
    }

    public List<Tiporesolucion> getTiporesolucionList() {
        return tiporesolucionList;
    }

    public void setTiporesolucionList(List<Tiporesolucion> tiporesolucionList) {
        this.tiporesolucionList = tiporesolucionList;
    }

    public Resolucion getResolucionSelected() {
        return resolucionSelected;
    }

    public void setResolucionSelected(Resolucion resolucionSelected) {
        this.resolucionSelected = resolucionSelected;
    }

    public Integer getTipoResolucionSelected() {
        return tipoResolucionSelected;
    }

    public void setTipoResolucionSelected(Integer tipoResolucionSelected) {
        this.tipoResolucionSelected = tipoResolucionSelected;
    }

    public List<Resolucion> getResolucionList() {
        return resolucionList;
    }

    public void setResolucionList(List<Resolucion> resolucionList) {
        this.resolucionList = resolucionList;
    }

    public Resolucion getResolucionToEdit() {
        return resolucionToEdit;
    }

    public void setResolucionToEdit(Resolucion resolucionToEdit) {
        this.resolucionToEdit = resolucionToEdit;
    }

    public Integer getTipoResolucionSelectedInEdit() {
        return tipoResolucionSelectedInEdit;
    }

    public void setTipoResolucionSelectedInEdit(Integer tipoResolucionSelectedInEdit) {
        this.tipoResolucionSelectedInEdit = tipoResolucionSelectedInEdit;
    }
}
