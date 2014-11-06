package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.ProveedorLazyModel;
import com.siapa.model.Persona;
import com.siapa.model.Proveedor;
import com.siapa.service.PersonaService;
import com.siapa.service.ProveedorService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import java.util.List;
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
@Named("proveedorManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ProveedorManagedBean extends GenericManagedBean<Proveedor, Integer> {

    @Autowired
    @Qualifier(value = "proveedorService")
    private ProveedorService proveedorService;

    @Autowired
    @Qualifier(value = "personaService")
    private PersonaService personaService;

    private Persona persona;
    private Proveedor proveedor;
    private List<Persona> personas;

    @PostConstruct
    public void init() {
        loadLazyModels();
        personas = personaService.findAll();
        proveedor =new Proveedor();
    }

    @Override
    public GenericService<Proveedor, Integer> getService() {
        return proveedorService;
    }

    @Override
    public LazyDataModel<Proveedor> getNewLazyModel() {
        return new ProveedorLazyModel(proveedorService);
    }

    public void toCreateProveedor(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            personas = personaService.findAll();
            setSelected(new Proveedor());
            contex.getExternalContext().redirect("/siapa/views/proveedor/Create.xhtml");
        } catch (IOException ex) {
            //   log.error("Error al rederigir a la pagina de asesoria", null, ex);
        }
    }
    
    public void llenar() {
        System.out.println("punto");

    }

    @Override
    public void saveNew(ActionEvent event) {

        Proveedor proveedor = getProveedor();
        proveedor.setIdPersona(persona);
        proveedor.setUsuarioProveedor(getUsuario());
        proveedorService.save(proveedor);
    }

    public void llenar() {
        System.out.println("punto");

    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

}
