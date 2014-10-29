package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.CajaLazyModel;
import com.siapa.model.Banco;
import com.siapa.model.Caja;
import com.siapa.service.CajaService;
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

@Named("cajaManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class CajaManagedBean extends GenericManagedBean<Caja, Integer> {

     @Autowired
     @Qualifier(value="cajaService")
     private CajaService cajaService;
     
     
     public CajaManagedBean() {
    }
    
    @PostConstruct
    public void init() {
        loadLazyModels();
    }

    @Override
    public GenericService<Caja, Integer> getService() {
       return cajaService;
    }

    @Override
    public LazyDataModel<Caja> getNewLazyModel() {
        return new CajaLazyModel(cajaService);
    }

    @Override
    public void saveNew(ActionEvent event) {
       if(getUsuario()!=null){
        String msg = ResourceBundle.getBundle("/crudbundle").getString(Caja.class.getSimpleName() + "Created");
        getSelected().setUsuarioRegistro(getUsuario());
        getSelected().setFechaRegistro(new Date());
        persist(PersistAction.CREATE, msg);
       }
    }

    @Override
    public void save(ActionEvent event) {
        String msg = ResourceBundle.getBundle("/crudbundle").getString(Caja.class.getSimpleName() + "Updated");
        getSelected().setUsuarioUltimamodificacion(getUsuario());
        getSelected().setFechaUltimamodificacion(new Date());
        persist(PersistAction.UPDATE, msg);
        if (!isValidationFailed()) {
           items = null; // Invalidate list of items to trigger re-query.
        }
    }
}
