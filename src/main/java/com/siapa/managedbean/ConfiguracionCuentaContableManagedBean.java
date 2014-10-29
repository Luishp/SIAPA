package com.siapa.managedbean;

import com.siapa.model.Banco;
import com.siapa.model.Caja;
import com.siapa.model.Cuentacontable;
import com.siapa.model.Deducciones;
import com.siapa.model.Lineacredito;
import com.siapa.model.Tipodeduccion;
import com.siapa.service.BancoService;
import com.siapa.service.CajaService;
import com.siapa.service.CuentacontableService;
import com.siapa.service.DeduccionesService;
import com.siapa.service.LineaCreditoService;
import com.siapa.service.TipoDeduccionService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@Named("configuracionCuentaContableManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ConfiguracionCuentaContableManagedBean {

    private List<Banco> bancoList;
    private List<Cuentacontable> cuentacontableList;
    private List<Caja> cajasList;
    private List<Lineacredito> lineaCreditoList;
    private List<Tipodeduccion> tipoDeduccionList;
    
    @Autowired
    @Qualifier(value = "bancoService")
    private BancoService bancoService;
    
    @Autowired
    @Qualifier(value = "cajaService")
    private CajaService cajaService;
    
    @Autowired
    @Qualifier(value = "lineaCreditoService")
    private LineaCreditoService lineaCreditoService;

    @Autowired
    @Qualifier(value = "tipoDeduccionService")
    private TipoDeduccionService tipoDeduccionService;

    @Autowired
    @Qualifier(value = "cuentacontableService")
    private CuentacontableService cuentacontableService;

    @PostConstruct
    public void init() {
        loadList();
    }

    public ConfiguracionCuentaContableManagedBean() {
    }

    private void loadList() {
        try {
            bancoList = bancoService.findAllActives();
            cajasList = cajaService.findAllActives();
            lineaCreditoList = lineaCreditoService.findAllActives();
            tipoDeduccionList = tipoDeduccionService.findAllActives();
            cuentacontableList = cuentacontableService.findAll();
        } catch (Exception e) {
            bancoList = new ArrayList<Banco>();
            cuentacontableList = new ArrayList<Cuentacontable>();
        }
    }

       public void onEditCaja(RowEditEvent event) {
        try {
            cajaService.merge((Caja) event.getObject());
            FacesMessage msg = new FacesMessage("Edicion Completada", ((Caja) event.getObject()).getCajaNombre());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("No se pudo aplicar la edicion", ((Caja) event.getObject()).getCajaNombre());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }
    
    public void onEditBanco(RowEditEvent event) {
        try {
            bancoService.merge((Banco) event.getObject());
            FacesMessage msg = new FacesMessage("Edicion Completada", ((Banco) event.getObject()).getBancoNombre());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("No se pudo aplicar la edicion", ((Banco) event.getObject()).getBancoNombre());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }
    
    public void onEditLinea(RowEditEvent event) {
        try {
            lineaCreditoService.merge((Lineacredito) event.getObject());
            FacesMessage msg = new FacesMessage("Edicion Completada", ((Lineacredito) event.getObject()).getLineacreditoNombre());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("No se pudo aplicar la edicion", ((Lineacredito) event.getObject()).getLineacreditoNombre());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }
    
     public void onEditTipoDeduccion(RowEditEvent event) {
        try {
            tipoDeduccionService.merge((Tipodeduccion) event.getObject());
            FacesMessage msg = new FacesMessage("Edicion Completada", ((Tipodeduccion) event.getObject()).getTipodeduccionNombre());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("No se pudo aplicar la edicion", ((Tipodeduccion) event.getObject()).getTipodeduccionNombre());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<Banco> getBancoList() {
        return bancoList;
    }

    public void setBancoList(List<Banco> bancoList) {
        this.bancoList = bancoList;
    }

    public List<Cuentacontable> getCuentacontableList() {
        return cuentacontableList;
    }

    public void setCuentacontableList(List<Cuentacontable> cuentacontableList) {
        this.cuentacontableList = cuentacontableList;
    }

    public List<Caja> getCajasList() {
        return cajasList;
    }

    public void setCajasList(List<Caja> cajasList) {
        this.cajasList = cajasList;
    }

    public List<Lineacredito> getLineaCreditoList() {
        return lineaCreditoList;
    }

    public void setLineaCreditoList(List<Lineacredito> lineaCreditoList) {
        this.lineaCreditoList = lineaCreditoList;
    }

    public List<Tipodeduccion> getTipoDeduccionList() {
        return tipoDeduccionList;
    }

    public void setTipoDeduccionList(List<Tipodeduccion> tipoDeduccionList) {
        this.tipoDeduccionList = tipoDeduccionList;
    }

}
