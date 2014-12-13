/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.ProductoLazyModel;
import com.siapa.model.Producto;
import com.siapa.service.ProductoService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
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

@Named("productoManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ProductoManagedBean extends GenericManagedBean<Producto, Integer> {

    @Autowired
    @Qualifier(value = "productoService")
    private ProductoService productoService;
    
    private Producto producto;
    
     @PostConstruct
    public void init() {
        loadLazyModels();
    }
    
    @Override
    public GenericService<Producto, Integer> getService() {
       return productoService;
    }

    @Override
    public LazyDataModel<Producto> getNewLazyModel() {
        return new ProductoLazyModel(productoService);
    }
    
    
    
    
    public void toCreateProducto(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();       
            setSelected(new Producto());
            contex.getExternalContext().redirect("/siapa/views/producto/index.xhtml");
        } catch (IOException ex) {
         //   log.error("Error al rederigir a la pagina de asesoria", null, ex);
        }
    }
    
}
