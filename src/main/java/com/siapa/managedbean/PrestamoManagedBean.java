package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.PrestamoLazyModel;
import com.siapa.model.Prestamo;
import com.siapa.service.PrestamoService;
import com.siapa.service.generic.GenericService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Fm
 */
@Named("prestamoManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)

public class PrestamoManagedBean extends GenericManagedBean<Prestamo, Integer> {
 
    @Autowired
    @Qualifier(value = "prestamoService")
    private PrestamoService prestamoService;

    private List<Prestamo> prestamosActivosItems;
    private Prestamo prestamoSelected;

    @PostConstruct
    public void init() {
        actualizarPrestamosActivosItems();
        loadLazyModels();
    }

    public PrestamoManagedBean() {
    }

    @Override
    public GenericService<Prestamo, Integer> getService() {
        return prestamoService;
    }

    @Override
    public LazyDataModel<Prestamo> getNewLazyModel() {
        return new PrestamoLazyModel(prestamoService);
    }

    public void actualizarPrestamosActivosItems() {
        prestamosActivosItems = prestamoService.findAll();
    }

    public List<Prestamo> getPrestamosActivosItems() {
        return prestamosActivosItems;
    }

    public void setPrestamosActivosItems(List<Prestamo> prestamosActivosItems) {
        this.prestamosActivosItems = prestamosActivosItems;
    }

    public Prestamo getPrestamoSelected() {
        return prestamoSelected;
    }

    public void setPrestamoSelected(Prestamo prestamoSelected) {
        this.prestamoSelected = prestamoSelected;
    }

}
