/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.TipoJaulaLazyModel;
import com.siapa.model.DetalleCompraAlimento;
import com.siapa.model.TipoJaula;
import com.siapa.service.TipoJaulaService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Joao
 */

@Named("tipoJaulaManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class TipoJaulaManagedBean extends GenericManagedBean<TipoJaula, Integer>  {

    
    @Autowired
    @Qualifier(value = "TipoJaulaService")
    private TipoJaulaService tipoJaulaService;

    @PostConstruct
    public void init() {
        loadLazyModels();
    }
    
    
    public void toCreateJaula() {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();

            setSelected(new TipoJaula());
            contex.getExternalContext().redirect("/siapa/views/jaula/NuevoTipoJaula.xhtml");
        } catch (IOException ex) {
            //   log.error("Error al rederigir a la pagina de asesoria", null, ex);
        }
    }
    
    @Override
    public GenericService<TipoJaula, Integer> getService() {
       return tipoJaulaService;
     }
    @Override 
    public LazyDataModel<TipoJaula> getNewLazyModel() {
       return new TipoJaulaLazyModel(tipoJaulaService);
    }
}
