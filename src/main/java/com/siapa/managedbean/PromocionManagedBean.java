package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.PromocionLazyModel;
import com.siapa.model.Promocion;
import com.siapa.service.PromocionService;
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

@Named("promocionManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class PromocionManagedBean extends GenericManagedBean<Promocion, Integer> {

    @Autowired
    @Qualifier(value = "promocionService")
    private PromocionService promocionService;

    @Override
    public GenericService<Promocion, Integer> getService() {
        return promocionService;
    }

    @PostConstruct
    public void init() {
        loadLazyModels();
    }

    public PromocionManagedBean() {

    }

    @Override
    public LazyDataModel<Promocion> getNewLazyModel() {
        return new PromocionLazyModel(promocionService);
    }

    @Override
    public void saveNew(ActionEvent event) {

        if (getUsuario() != null) {
            String msg = ResourceBundle.getBundle("/crudbundle").getString(Promocion.class.getSimpleName() + "Created");
            getSelected().setUsuarioRegistro(getUsuario());
            getSelected().setFechaRegistro(new Date());
            persist(PersistAction.CREATE, msg);
        }

    }

    @Override
    public void save(ActionEvent event) {

        String msg = ResourceBundle.getBundle("/crudbundle").getString(Promocion.class.getSimpleName() + "Updated");
        getSelected().setUsuarioUltimamodificacion(getUsuario());
        getSelected().setFechaUltimamodificacion(new Date());
        persist(PersistAction.UPDATE, msg);
        if (!isValidationFailed()) {
            items = null; // Invalidate list of items to trigger re-query.
        }

    }

}
