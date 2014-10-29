/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.DeduccionesLazyModel;
import com.siapa.model.Deducciones;
import com.siapa.service.DeduccionesService;
import com.siapa.service.generic.GenericService;
import java.util.Date;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Josue
 */
@Named("DeduccionManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class DeduccionesManagedBean extends GenericManagedBean<Deducciones, Integer> {

    @Autowired
    @Qualifier(value = "deduccionesService")
    private DeduccionesService deduccionesService;

    @PostConstruct
    public void init() {
        loadLazyModels();
    }

    @Override
    public GenericService<Deducciones, Integer> getService() {
        return deduccionesService;
    }

    @Override
    public LazyDataModel<Deducciones> getNewLazyModel() {
        return new DeduccionesLazyModel(deduccionesService);
    }
    
    
    @Override
    public void saveNew(ActionEvent event) {
       if(getUsuario()!=null){
        String msg = ResourceBundle.getBundle("/crudbundle").getString(Deducciones.class.getSimpleName() + "Created");
        getSelected().setUsuarioRegistro(getUsuario());
        getSelected().setFechaRegistro(new Date());
        persist(PersistAction.CREATE, msg);
       }
    }

    @Override
    public void save(ActionEvent event) {
        String msg = ResourceBundle.getBundle("/crudbundle").getString(Deducciones.class.getSimpleName() + "Updated");
        getSelected().setUsuarioUltimamodificacion(getUsuario());
        getSelected().setFechaUltimamodificacion(new Date());
        persist(PersistAction.UPDATE, msg);
        if (!isValidationFailed()) {
           items = null; // Invalidate list of items to trigger re-query.
        }
    }

}
