package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.CatalogoGarantiaLazyModel;
import com.siapa.model.Garantia;
import com.siapa.model.Requisitogarantia;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.service.CatalogoGarantiaService;
import com.siapa.service.RequisitoGarantiaService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
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

@Named("catalogoGarantiaManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class CatalogoGarantiaManagedBean extends GenericManagedBean<Garantia, Integer> {

    private static final Logger log = LoggerFactory.getLogger(CatalogoGarantiaManagedBean.class);

//decclaracion de Garantia variable de sesion
     Garantia garantia;

    //declaracion de requisito de garantia y lista
    private List<Requisitogarantia> requisitoGarantiaLista;
    private Requisitogarantia requisitoSelected;

    //declaracion de servicios
    @Autowired
    @Qualifier(value = "catalogoGarantiaService")
    private CatalogoGarantiaService catalogoGarantiaService;
    @Autowired
    @Qualifier(value = "requisitoGarantiaService")
    private RequisitoGarantiaService requisitoGarantiaService;

    //declaracion de listas
    @PostConstruct
    public void init() {
        loadLazyModels();
    }

    public void saveRequisito(ActionEvent event) {
        try {
            if (getUsuario() != null) {
                String msg = "Requisito de garantia, creado exitosamente";
                getRequisitoSelected().setUsuarioRegistro(getUsuario());
//                getRequisitoSelected().s;
                getRequisitoSelected().setFechaRegistro(new Date());
                requisitoGarantiaService.save(requisitoSelected);
                JsfUtil.addSuccessMessage(msg);
            }
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Error, no se pudo crear el requisito de la garantia." + e);
        }
    }

    public void updateReqNegocio(ActionEvent event) {
        String msg = "Requisitos de garantia,Actualizado exitosamente.";
        getRequisitoSelected().setUsuarioUltimamodificacion(getUsuario());
        getRequisitoSelected().setFechaUltimamodificacion(new Date());
        requisitoGarantiaService.merge(requisitoSelected);
        if (!isValidationFailed()) {
            items = null;
        }
    }

    public void deleteReqNegocio(ActionEvent event) {
        try {
            requisitoGarantiaService.delete(requisitoSelected);
            cargarListas();
        } catch (Exception e) {
            cargarListas();
            String msge = "";
            Throwable cause = JsfUtil.getRootCause(e.getCause());
            if (cause != null) {
                msge = cause.getLocalizedMessage();
            }
            if (msge.length() > 0) {
                JsfUtil.addErrorMessage("ERROR ELIMINANDO EL REQUISITO DE NEGOCIO, " + requisitoSelected.getRgNombre());
            } else {
                JsfUtil.addErrorMessage(e, "ERROR ELIMINANDO EL REQUISITO DE NEGOCIO," + requisitoSelected.getRgNombre());
            }
        }
    }

    public void toCreateGarantia(ActionEvent event){
        FacesContext contex = FacesContext.getCurrentInstance();
        garantia= new Garantia();
        try {
            garantia.setUsuarioRegistro(getUsuario());
            garantia.setFechaRegistro(new Date());
            garantia.setActivo("SI");
            catalogoGarantiaService.save(garantia);
             HttpServletRequest request = (HttpServletRequest) contex.getExternalContext().getRequest();
            contex.getExternalContext().redirect("/siacofinges/views/configuracionInicial/catalogoGarantias/Create.xhtml");
            
        } catch (Exception e) {
            java.util.logging.Logger.getLogger(CatalogoGarantiaManagedBean.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    public void toEditGarantia(ActionEvent event){
        FacesContext contex = FacesContext.getCurrentInstance();
        try {
            garantia = catalogoGarantiaService.findById(getSelected().getGarantiaId());
            if (garantia != null) {
                cargarListas();
                contex.getExternalContext().redirect("/siacofinges/views/configuracionInicial/catalogoGarantias/Create.xhtml");
            } else {
                contex.getExternalContext().redirect("/siacofinges/views/configuracionInicial/catalogoGarantias/index.xhtml");
            }

        } catch (IOException e) {
            java.util.logging.Logger.getLogger(CatalogoGarantiaManagedBean.class.getName()).log(Level.SEVERE, null, e);

        }

    }
    
    
     public void update(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            catalogoGarantiaService.merge(garantia);
            garantia = null;
            try {
                loadLazyModels();
                contex.getExternalContext().redirect("/siacofinges/views/configuracionInicial/catalogoGarantias/index.xhtml");
                JsfUtil.addSuccessMessage("Operacion realizada con Exito");
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(CatalogoGarantiaManagedBean.class.getName()).log(Level.SEVERE, null, ex);
                log.debug("Error al actualizar la linea de credito. " + ex);
            }
        } catch (Exception e) {
        }

    }
     
     public void cancelar(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            catalogoGarantiaService.merge(garantia);
            garantia = null;
            try {
                contex.getExternalContext().redirect("/siacofinges/views/configuracionInicial/catalogoGarantias/index.xhtml");
            } catch (IOException ex) {
                log.debug("Error al redirigir a el listado del catalogo de garantias" + ex);
            }
        } catch (HibernateException e) {
            log.debug("Error al actualizar la garntia de Credito " + e);
        }

    }

    
    public void cargarListas() {

    }

    @Override
    public GenericService<Garantia, Integer> getService() {
        return catalogoGarantiaService;
    }

    @Override
    public LazyDataModel<Garantia> getNewLazyModel() {
        return new CatalogoGarantiaLazyModel(catalogoGarantiaService);
    }

    public RequisitoGarantiaService getRequisitoGarantiaService() {
        return requisitoGarantiaService;
    }

    public void setRequisitoGarantiaService(RequisitoGarantiaService requisitoGarantiaService) {
        this.requisitoGarantiaService = requisitoGarantiaService;
    }

    public Garantia getGarantia() {
        return garantia;
    }

    public void setGarantia(Garantia garantia) {
        this.garantia = garantia;
    }

    public List<Requisitogarantia> getRequisitoGarantiaLista() {
        return requisitoGarantiaLista;
    }

    public void setRequisitoGarantiaLista(List<Requisitogarantia> requisitoGarantiaLista) {
        this.requisitoGarantiaLista = requisitoGarantiaLista;
    }

    public Requisitogarantia getRequisitoSelected() {
        return requisitoSelected;
    }

    public void setRequisitoSelected(Requisitogarantia requisitoSelected) {
        this.requisitoSelected = requisitoSelected;
    }

    public CatalogoGarantiaService getCatalogoGarantiaService() {
        return catalogoGarantiaService;
    }

    public void setCatalogoGarantiaService(CatalogoGarantiaService catalogoGarantiaService) {
        this.catalogoGarantiaService = catalogoGarantiaService;
    }
}
