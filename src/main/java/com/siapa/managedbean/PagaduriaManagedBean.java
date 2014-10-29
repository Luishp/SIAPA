package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.PagaduriaLazyModel;
import com.siapa.model.Banco;
import com.siapa.model.Pagaduria;
import com.siapa.service.PagaduriaService;
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



@Named("pagaduriaManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class PagaduriaManagedBean extends GenericManagedBean<Pagaduria, Integer> {

    @Autowired
    @Qualifier(value="pagaduriaService")
    private PagaduriaService pagaduriaService;
    
    @PostConstruct
    public void init() {
        loadLazyModels();
    }

    public PagaduriaManagedBean() {
    }
    
    @Override
    public GenericService<Pagaduria, Integer> getService() {
        return pagaduriaService;
    }

    @Override
    public LazyDataModel<Pagaduria> getNewLazyModel() {
        return new PagaduriaLazyModel(pagaduriaService);
    }
    
    @Override
    public void saveNew(ActionEvent event) {
       if(getUsuario()!=null){
        String msg = ResourceBundle.getBundle("/crudbundle").getString(Pagaduria.class.getSimpleName() + "Created");
        getSelected().setUsuarioRegistro(getUsuario());
        getSelected().setFechaRegistro(new Date());
        persist(PersistAction.CREATE, msg);
       }
    }

    @Override
    public void save(ActionEvent event) {
        String msg = ResourceBundle.getBundle("/crudbundle").getString(Pagaduria.class.getSimpleName() + "Updated");
        getSelected().setUsuarioUltimamodificacion(getUsuario());
        getSelected().setFechaUltimamodificacion(new Date());
        persist(PersistAction.UPDATE, msg);
        if (!isValidationFailed()) {
           items = null; // Invalidate list of items to trigger re-query.
        }
    }
}