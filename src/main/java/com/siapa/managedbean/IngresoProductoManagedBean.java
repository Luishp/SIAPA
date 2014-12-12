/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.IngresoProductoLazyModel;
import com.siapa.model.IngresoProducto;
import com.siapa.model.Jaula;
import com.siapa.model.Producto;
import com.siapa.service.IngresoProductoService;
import com.siapa.service.JaulaService;
import com.siapa.service.ProductoService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
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
 * @author Jarvis
 */
@Named("ingresoProductoManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class IngresoProductoManagedBean extends GenericManagedBean<IngresoProducto, Integer>{
    
    @Autowired
    @Qualifier(value = "IngresoProductoService")
    private IngresoProductoService ingresoProductoService;

    @Autowired
    @Qualifier(value = "jaulaService")
    private JaulaService jaulaService;
    
    @Autowired
    @Qualifier(value = "productoService")
    private ProductoService productoService;
    
    private Producto producto;
    private Jaula jaula;
    private IngresoProducto ingresoProducto;
    private List<Producto> productos;
    private List<Jaula> jaulas;
    
    @PostConstruct
    public void init() {
        loadLazyModels();
        jaulas = jaulaService.findAll();
        productos=productoService.findAll();
        ingresoProducto =new IngresoProducto();
    }

    public IngresoProductoService getIngresoProductoService() {
        return ingresoProductoService;
    }

    public void setIngresoProductoService(IngresoProductoService ingresoProductoService) {
        this.ingresoProductoService = ingresoProductoService;
    }

    public JaulaService getJaulaService() {
        return jaulaService;
    }

    public void setJaulaService(JaulaService jaulaService) {
        this.jaulaService = jaulaService;
    }

    public ProductoService getProductoService() {
        return productoService;
    }

    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Jaula getJaula() {
        return jaula;
    }

    public void setJaula(Jaula jaula) {
        this.jaula = jaula;
    }

    public IngresoProducto getIngresoProducto() {
        return ingresoProducto;
    }

    public void setIngresoProducto(IngresoProducto ingresoProducto) {
        this.ingresoProducto = ingresoProducto;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Jaula> getJaulas() {
        return jaulas;
    }

    public void setJaulas(List<Jaula> jaulas) {
        this.jaulas = jaulas;
    }
    

    @Override
    public GenericService<IngresoProducto, Integer> getService() {
        return ingresoProductoService;
    }

    @Override
    public LazyDataModel<IngresoProducto> getNewLazyModel() {
        return new IngresoProductoLazyModel(ingresoProductoService);
    }
    
    public void toCreateIngresoProducto(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            jaulas = jaulaService.findAll();
            productos =productoService.findAll();
            setSelected(new IngresoProducto());
            contex.getExternalContext().redirect("/siapa/views/ingresoProducto/Create.xhtml");
        } catch (IOException ex) {
            //   log.error("Error al rederigir a la pagina de asesoria", null, ex);
        }
    }
    
    public void llenar() {
        //System.out.println("punto");

    }

    @Override
    public void saveNew(ActionEvent event) {

        IngresoProducto ingresoProducto= getIngresoProducto();
        ingresoProducto.setIdJaula(jaula);
        ingresoProducto.setIdProducto(producto);
        ingresoProducto.setUsuarioIngresoProducto(getUsuario());
        ingresoProductoService.save(ingresoProducto);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Insercion completada"));
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/siapa/views/ingresoProducto/index.xhtml");
        } catch (IOException ex) {
            //   log.error("Error al rederigir a la pagina de asesoria", null, ex);
        }
        }
}