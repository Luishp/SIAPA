package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.LineaCreditoLazyModel;
import com.siapa.model.Detallelineacredito;
import com.siapa.model.Lineacredito;
import com.siapa.model.Requisitolineacreditoempleado;
import com.siapa.model.Requisitolineacreditonegocio;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.service.DetalleLineaCreditoService;
import com.siapa.service.LineaCreditoService;
import com.siapa.service.RequisitoLineaCreditoEmpleadoService;
import com.siapa.service.RequisitoLineaCreditoNegocioService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;
import org.primefaces.model.LazyDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@Named("lineaCreditoManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class LineaCreditoManagedBean extends GenericManagedBean<Lineacredito, Integer> {

    private static final Logger log = LoggerFactory.getLogger(LineaCreditoManagedBean.class);
    @Autowired
    @Qualifier(value = "lineaCreditoService")
    private LineaCreditoService lineaCreditoService;

    @Autowired
    @Qualifier(value = "requisitoLineaCreditoEmpleadoService")
    private RequisitoLineaCreditoEmpleadoService requisitoLineaCreditoEmpleado;

    @Autowired
    @Qualifier(value = "requisitoLineaCreditoNegocioService")
    private RequisitoLineaCreditoNegocioService requisitoLineaCreditoNegocio;

    @Autowired
    @Qualifier(value = "detalleLineaCreditoService")
    private DetalleLineaCreditoService detalleLineaCredito;

    //variables estaticas
    private static final String PREFIX = "/siacofinges/views/configuracionInicial/lineaCredito/";

    //linea de credito de sesion
    Lineacredito lineaCredito;
    private List<Lineacredito> lineaCreditoList;

    // listados
    private Requisitolineacreditonegocio rlcnSelected;
    private List<Requisitolineacreditonegocio> reqLineaCreditoNegocioList;

    private Requisitolineacreditoempleado rlceSelected;
    private List<Requisitolineacreditoempleado> reqLineaCreditoEmpleadoList;

    private Detallelineacredito detalleLCSelected;
    private List<Detallelineacredito> detalleLineaCreditoList;

    @PostConstruct
    public void init() {
        loadLazyModels();
        cargarLineaCredito();

    }

    @Override
    public GenericService<Lineacredito, Integer> getService() {
        return lineaCreditoService;
    }

    @Override
    public LazyDataModel<Lineacredito> getNewLazyModel() {
        return new LineaCreditoLazyModel(lineaCreditoService);
    }

    public void cargarLineaCredito() {
        lineaCreditoList = lineaCreditoService.findAllLC();

    }

    public void saveDetalle(ActionEvent event) {

        try {

            if (getUsuario() != null) {
                String msj = "Registro de Detalle Creado";
                getDetalleLCSelected().setUsuarioRegistro(getUsuario());
                getDetalleLCSelected().setLineacreditoId(lineaCredito);
                getDetalleLCSelected().setFechaRegistro(new Date());
                detalleLineaCredito.save(detalleLCSelected);
                JsfUtil.addSuccessMessage(msj);
            }
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Error, no se pudo crear el Detalle de linea de credito." + e);
        }
        cargarListas();
    }

    public void updateDetalle(ActionEvent event) {
        String msg = "Detalle de Linea de credito Actualizada";
        detalleLineaCredito.merge(detalleLCSelected);
        if (!isValidationFailed()) {
            items = null;
        }
        cargarListas();
    }

    public void deleteDetalle(ActionEvent event) {
        try {
            detalleLineaCredito.delete(detalleLCSelected);
            cargarListas();
        } catch (Exception e) {
            cargarListas();
            String msge = "";
            Throwable cause = JsfUtil.getRootCause(e.getCause());
            if (cause != null) {
                msge = cause.getLocalizedMessage();
            }
            if (msge.length() > 0) {
                JsfUtil.addErrorMessage("ERROR ELIMINANDO DETALLE LINEA DE CREDITO " + detalleLCSelected.getDetallelineacreditoId());
            } else {
                JsfUtil.addErrorMessage(e, "ERROR ELIMINANDO DETALLE LINEA DE CREDITO" + detalleLCSelected.getDetallelineacreditoId());
            }
        }
    }

    public void saveReqEmpleado(ActionEvent event) {

        try {

            if (getUsuario() != null) {
                String msj = "Registro del requisito de empleado creado:";
                getRlceSelected().setUsuarioRegistro(getUsuario());
                getRlceSelected().setLineacreditoId(lineaCredito);
                getRlceSelected().setFechaRegistro(new Date());
                requisitoLineaCreditoEmpleado.save(rlceSelected);
                JsfUtil.addSuccessMessage(msj);
            }
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Error, no se pudo crear el Requisito de empleado." + e);
        }
        cargarListas();
    }

    public void updateReqEmpleado(ActionEvent event) {
        String msg = "Requisitos de Empleado Actualizado exitosamente.";
        getRlceSelected().setUsuarioUltimamodificacion(getUsuario());
        getRlceSelected().setFechaUltimamodificacion(new Date());
        requisitoLineaCreditoEmpleado.merge(rlceSelected);
        if (!isValidationFailed()) {
            items = null;
        }
    }

    public void deleteReqEmpleado(ActionEvent event) {
        try {
            requisitoLineaCreditoEmpleado.delete(rlceSelected);
            cargarListas();
        } catch (Exception e) {
            cargarListas();
            String msge = "";
            Throwable cause = JsfUtil.getRootCause(e.getCause());
            if (cause != null) {
                msge = cause.getLocalizedMessage();
            }
            if (msge.length() > 0) {
                JsfUtil.addErrorMessage("ERROR ELIMINANDO EL REQUISITO DE EMPLEADO, " + rlceSelected.getRequisitolineacreditoempleadoNombre());
            } else {
                JsfUtil.addErrorMessage(e, "ERROR ELIMINANDO EL REQUISITO DE EMPLEADO," + rlceSelected.getRequisitolineacreditoempleadoNombre());
            }
        }
    }

    public void saveReqNegocio(ActionEvent event) {

        try {

            if (getUsuario() != null) {
                String msj = "Registro del requisito de negocio creado exitosamente.";
                getRlcnSelected().setUsuarioRegistro(getUsuario());
                getRlcnSelected().setLineacreditoId(lineaCredito);
                getRlcnSelected().setFechaRegistro(new Date());
                requisitoLineaCreditoNegocio.save(rlcnSelected);
                JsfUtil.addSuccessMessage(msj);
            }
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Error, no se pudo crear el Requisito de negocio." + e);
        }
        cargarListas();
    }

    public void updateReqNegocio(ActionEvent event) {
        String msg = "Requisitos de Negocio Actualizado exitosamente.";
        getRlcnSelected().setUsuarioUltimamodificacion(getUsuario());
        getRlcnSelected().setFechaUltimamodificacion(new Date());
        requisitoLineaCreditoNegocio.merge(rlcnSelected);
        if (!isValidationFailed()) {
            items = null;
        }
    }

    public void deleteReqNegocio(ActionEvent event) {
        try {
            requisitoLineaCreditoNegocio.delete(rlcnSelected);
            cargarListas();
        } catch (Exception e) {
            cargarListas();
            String msge = "";
            Throwable cause = JsfUtil.getRootCause(e.getCause());
            if (cause != null) {
                msge = cause.getLocalizedMessage();
            }
            if (msge.length() > 0) {
                JsfUtil.addErrorMessage("ERROR ELIMINANDO EL REQUISITO DE NEGOCIO, " + rlcnSelected.getRequisitoLineacreditonegocioNombre());
            } else {
                JsfUtil.addErrorMessage(e, "ERROR ELIMINANDO EL REQUISITO DE NEGOCIO," + rlcnSelected.getRequisitoLineacreditonegocioNombre());
            }
        }
    }

    public void cargarListas() {
        reqLineaCreditoNegocioList = requisitoLineaCreditoNegocio.findRequisitosByIdLineaCredito(lineaCredito.getLineacreditoId());
        reqLineaCreditoEmpleadoList = requisitoLineaCreditoEmpleado.findRequisitosByIdEmpleado(lineaCredito.getLineacreditoId());
        detalleLineaCreditoList = detalleLineaCredito.findDetallebyLineaCredito(lineaCredito.getLineacreditoId());

    }

    public void update(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            lineaCreditoService.merge(lineaCredito);
            lineaCredito = null;
            try {
                cargarLineaCredito();
                contex.getExternalContext().redirect("/siacofinges/views/configuracionInicial/lineaCredito/index.xhtml");
                JsfUtil.addSuccessMessage("Operacion realizada con Exito");
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(LineaCreditoManagedBean.class.getName()).log(Level.SEVERE, null, ex);
                log.debug("Error al actualizar la linea de credito. " + ex);
            }
        } catch (Exception e) {
        }

    }

    public void cancelar(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            lineaCreditoService.merge(lineaCredito);
            lineaCredito = null;
            try {
                contex.getExternalContext().redirect("/siacofinges/views/configuracionInicial/lineaCredito/index.xhtml");
            } catch (IOException ex) {
                log.debug("Error al redirigir a el listado de lineas de credito" + ex);
            }
        } catch (HibernateException e) {
            log.debug("Error al actualizar la solicitud de Credito " + e);
        }

    }

    public void toCreateLinea(ActionEvent event) {
        FacesContext contex = FacesContext.getCurrentInstance();
        lineaCredito = new Lineacredito();
        try {

            lineaCredito.setUsuarioRegistro(getUsuario());
            lineaCredito.setFechaRegistro(new Date());
            lineaCredito.setActivo("SI");
            lineaCreditoService.save(lineaCredito);
            cargarListas();
            HttpServletRequest request = (HttpServletRequest) contex.getExternalContext().getRequest();
            contex.getExternalContext().redirect("/siacofinges/views/configuracionInicial/lineaCredito/Create.xhtml");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LineaCreditoManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toEditLinea(ActionEvent event) {
        FacesContext contex = FacesContext.getCurrentInstance();
        try {
            lineaCredito = lineaCreditoService.findAllDet(getSelected().getLineacreditoId());
            if (lineaCredito != null) {
                cargarListas();
                contex.getExternalContext().redirect("/siacofinges/views/configuracionInicial/lineaCredito/Create.xhtml");
            } else {
                contex.getExternalContext().redirect("/siacofinges/views/configuracionInicial/lineaCredito/index.xhtml");
            }

        } catch (IOException e) {
            java.util.logging.Logger.getLogger(LineaCreditoManagedBean.class.getName()).log(Level.SEVERE, null, e);

        }

    }

    public Detallelineacredito detalleLCPrepareCreate(ActionEvent event) {
        Detallelineacredito newItem;
        newItem = new Detallelineacredito();
        this.detalleLCSelected = newItem;
        initializeEmbeddableKey();
        return newItem;

    }

    public Requisitolineacreditoempleado requisitoEmpleadorepareCreate(ActionEvent event) {
        Requisitolineacreditoempleado newItem;
        newItem = new Requisitolineacreditoempleado();
        this.rlceSelected = newItem;
        initializeEmbeddableKey();
        return newItem;

    }

    public Requisitolineacreditonegocio requisitoNegociorepareCreate(ActionEvent event) {
        Requisitolineacreditonegocio newItem;
        newItem = new Requisitolineacreditonegocio();
        this.rlcnSelected = newItem;
        initializeEmbeddableKey();
        return newItem;

    }

    public List<Requisitolineacreditonegocio> getReqLineaCreditoNegocioList() {
        return reqLineaCreditoNegocioList;
    }

    public void setReqLineaCreditoNegocioList(List<Requisitolineacreditonegocio> reqLineaCreditoNegocioList) {
        this.reqLineaCreditoNegocioList = reqLineaCreditoNegocioList;
    }

    public List<Requisitolineacreditoempleado> getReqLineaCreditoEmpleadoList() {
        return reqLineaCreditoEmpleadoList;
    }

    public void setReqLineaCreditoEmpleadoList(List<Requisitolineacreditoempleado> reqLineaCreditoEmpleadoList) {
        this.reqLineaCreditoEmpleadoList = reqLineaCreditoEmpleadoList;
    }

    public List<Detallelineacredito> getDetalleLineaCreditoList() {
        return detalleLineaCreditoList;
    }

    public void setDetalleLineaCreditoList(List<Detallelineacredito> detalleLineaCreditoList) {
        this.detalleLineaCreditoList = detalleLineaCreditoList;
    }

    public Requisitolineacreditonegocio getRlcnSelected() {
        return rlcnSelected;
    }

    public void setRlcnSelected(Requisitolineacreditonegocio rlcnSelected) {
        this.rlcnSelected = rlcnSelected;
    }

    public Requisitolineacreditoempleado getRlceSelected() {
        return rlceSelected;
    }

    public void setRlceSelected(Requisitolineacreditoempleado rlceSelected) {
        this.rlceSelected = rlceSelected;
    }

    public Detallelineacredito getDetalleLCSelected() {
        return detalleLCSelected;
    }

    public void setDetalleLCSelected(Detallelineacredito detalleLCSelected) {
        this.detalleLCSelected = detalleLCSelected;
    }

    public Lineacredito getLineaCredito() {
        return lineaCredito;
    }

    public void setLineaCredito(Lineacredito lineaCredito) {
        this.lineaCredito = lineaCredito;
    }

    public List<Lineacredito> getLineaCreditoList() {
        return lineaCreditoList;
    }

    public void setLineaCreditoList(List<Lineacredito> lineaCreditoList) {
        this.lineaCreditoList = lineaCreditoList;
    }

}
