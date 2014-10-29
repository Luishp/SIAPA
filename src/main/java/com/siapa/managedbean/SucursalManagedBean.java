package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.SucursalLazyModel;
import com.siapa.model.Sucursal;
import com.siapa.service.SucursalService;
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

@Named("sucursalManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class SucursalManagedBean extends GenericManagedBean<Sucursal, Integer> {

    @Autowired
    @Qualifier(value = "sucursalService")
    private SucursalService sucursalService;

    @Override
    public GenericService<Sucursal, Integer> getService() {
        return sucursalService;
    }

    @PostConstruct
    public void init() {
        loadLazyModels();
    }

    public SucursalManagedBean() {
    }

    @Override
    public LazyDataModel<Sucursal> getNewLazyModel() {
        return new SucursalLazyModel(sucursalService);
    }
    
        @Override
    public void saveNew(ActionEvent event) {
       if(getUsuario()!=null){
        String msg = ResourceBundle.getBundle("/crudbundle").getString(Sucursal.class.getSimpleName() + "Created");
        getSelected().setUsuarioRegistro(getUsuario());
        getSelected().setFechaRegistro(new Date());
        persist(PersistAction.CREATE, msg);
       }
    }

    @Override
    public void save(ActionEvent event) {
        String msg = ResourceBundle.getBundle("/crudbundle").getString(Sucursal.class.getSimpleName() + "Updated");
        getSelected().setUsuarioUltimamodificacion(getUsuario());
        getSelected().setFechaUltimamodificacion(new Date());
        persist(PersistAction.UPDATE, msg);
        if (!isValidationFailed()) {
           items = null; // Invalidate list of items to trigger re-query.
        }
    }

}
