package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.ClienteLazyModel;
import com.siapa.model.Categorias;
import com.siapa.model.Cliente;
import com.siapa.model.Persona;
import com.siapa.service.CategoriasService;
import com.siapa.service.ClienteService;
import com.siapa.service.PersonaService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
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
@Named("clienteManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ClienteManagedBean extends GenericManagedBean<Cliente, Integer> {

    @Autowired
    @Qualifier(value = "clienteService")
    private ClienteService clienteService;

    @Autowired
    @Qualifier(value = "personaService")
    private PersonaService personaService;

    @Autowired
    @Qualifier(value = "categoriasService")
    private CategoriasService categoriasService;

    private Persona persona;
     private Categorias categoria;

    private List<Persona> personas;
    private List<Categorias> categorias;

    @PostConstruct
    public void init() {
        loadLazyModels();
    }

    @Override
    public GenericService<Cliente, Integer> getService() {
        return clienteService;
    }

    @Override
    public LazyDataModel<Cliente> getNewLazyModel() {
        return new ClienteLazyModel(clienteService);
    }

    public void toCreateCliente(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            personas = personaService.findAll();
            categorias = categoriasService.findAll();
          //  setSelected(new Categorias());
            setSelected(new Cliente());
            contex.getExternalContext().redirect("/siapa/views/cliente/Create.xhtml");
        } catch (IOException ex) {
            //   log.error("Error al rederigir a la pagina de asesoria", null, ex);
        }
    }
    
    
    @Override
        public void save(ActionEvent event) {
            
        Cliente cliente=new Cliente();
        cliente.setIdPersona(persona);
        cliente.setIdCategorias(categoria);
        cliente.setNombreClienteCompVenta(persona.getNombrePersona());
        cliente.setDireccionCliente(persona.getDireccionPersona());
        cliente.setTipoCliente(categoria.getNombreCategorias());
        clienteService.save(cliente);
        
        System.out.println(""+getSelected());    
        System.out.println(""+getPersona());    
        System.out.println(""+categoria);    
        
            
        
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

    public CategoriasService getCategoriasService() {
        return categoriasService;
    }

    public void setCategoriasService(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    public List<Categorias> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categorias> categorias) {
        this.categorias = categorias;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

}
