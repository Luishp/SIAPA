/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.JaulaLazyModel;
import com.siapa.model.DetalleCompraAlimento;
import com.siapa.model.Jaula;
import com.siapa.model.TipoJaula;
import com.siapa.service.JaulaService;
import com.siapa.service.TipoJaulaService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;


@Named("jaulaManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class JaulaManangedBean extends GenericManagedBean<Jaula, Integer> {

    @Autowired
    @Qualifier(value = "jaulaService")
    private JaulaService jaulaService;
    
    
    @Autowired
    @Qualifier(value = "TipoJaulaService")
    private TipoJaulaService tipoJaulaService;
    
    
    private List<TipoJaula> tipoJaulaList;
    private TipoJaula tipoJaula;
    private Boolean jaulaVenta;
    private Long suma;

    @PostConstruct
    public void init() {
        loadLazyModels();
        cargarListas();
    }
    
    @Override
    public GenericService<Jaula, Integer> getService() {
        return jaulaService;
    }

    @Override
    public LazyDataModel<Jaula> getNewLazyModel() {
        return new JaulaLazyModel(jaulaService);
    }

   
    @Override
    public void saveNew(ActionEvent event) {
       if(getUsuario()!=null){
        String msg = ResourceBundle.getBundle("/crudbundle").getString(Jaula.class.getSimpleName() + "Created");
        getSelected().setFechaSiembraJaula(new Date());
        getSelected().setFechaVentaJaula(new Date());
        getSelected().setIdTipoJaula(getTipoJaula());
        getSelected().setListaVentaJaula(getJaulaVenta());
        persist(PersistAction.CREATE, msg);
        tipoJaulaList=tipoJaulaService.findAllActives();
        setSuma(this.jaulaService.sumAllJ());
        toCreateJaula();
       }
    } 
    
    @Override
    
    public void save(ActionEvent event) {    
        String msg = ResourceBundle.getBundle("/crudbundle").getString(Jaula.class.getSimpleName() + "Updated");
        //getSelected().setIdTipoJaula(getTipoJaula());
        getSelected().setListaVentaJaula(getJaulaVenta());
        persist(PersistAction.UPDATE, msg);
        tipoJaulaList=tipoJaulaService.findAllActives();
        setSuma(this.jaulaService.sumAllJ());
        toCreateJaula();
    }
    
    @Override
    public void delete(ActionEvent event) {
       
        String msg = ResourceBundle.getBundle("/crudbundle").getString(Jaula.class.getSimpleName() + "Deleted");
        persist(PersistAction.DELETE, msg);
        tipoJaulaList=tipoJaulaService.findAllActives();
        setSuma(this.jaulaService.sumAllJ());
        toCreateJaula();
        if (!isValidationFailed()) {
            items = null; // Invalidate list of items to trigger re-query.
        }
    }
    
    

    public void cargarListas() {

        tipoJaulaList=tipoJaulaService.findAllActives();
        setSuma(this.jaulaService.sumAllJ());
        System.out.println(getSuma());
       // this.jaulaService=new JaulaService();

    }


    /**
     * @return the jaulaList
     */
    public List<TipoJaula> getJaulaList() {
        return tipoJaulaList;
    }

    /**
     * @param jaulaList the jaulaList to set
     */
    public void setJaulaList(List<TipoJaula> jaulaList) {
        this.tipoJaulaList = jaulaList;
    }

    /**
     * @return the tipoJaula
     */
    public TipoJaula getTipoJaula() {
        return tipoJaula;
    }

    /**
     * @param tipoJaula the tipoJaula to set
     */
    public void setTipoJaula(TipoJaula tipoJaula) {
        this.tipoJaula = tipoJaula;
    }

    /**
     * @return the jaulaVenta
     */
    public Boolean getJaulaVenta() {
        return jaulaVenta;
    }

    /**
     * @param jaulaVenta the jaulaVenta to set
     */
    public void setJaulaVenta(Boolean jaulaVenta) {
        this.jaulaVenta = jaulaVenta;
    }

    /**
     * @return the suma
     */
    public Long getSuma() {
        return suma;
    }

    /**
     * @param suma the suma to set
     */
    public void setSuma(Long suma) {
        this.suma = suma;
    }
    public void toCreateJaula() {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();

            setSelected(new Jaula());
            contex.getExternalContext().redirect("/siapa/views/jaula/index.xhtml");
        } catch (IOException ex) {
            //   log.error("Error al rederigir a la pagina de asesoria", null, ex);
        }
    }
   
}
