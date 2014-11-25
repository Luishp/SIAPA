/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.RegistroAlimentacionLazyModel;
import com.siapa.model.Alimento;
import com.siapa.model.Jaula;
import com.siapa.model.RegistroAlimentacion;
import com.siapa.service.AlimentoService;
import com.siapa.service.JaulaService;
import com.siapa.service.RegistroAlimentacionService;
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
 * @author Jarvis
 */
@Named("registroAlimentacionManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class RegistroAlimentacionManagedBean extends GenericManagedBean<RegistroAlimentacion, Integer>{
    
    @Autowired
    @Qualifier(value = "RegistroAlimentacionService")
    private RegistroAlimentacionService registroAlimentacionService;

    @Autowired
    @Qualifier(value = "jaulaService")
    private JaulaService jaulaService;
    @Autowired
    @Qualifier(value = "alimentoService")
    private AlimentoService alimentoService;
    
    private Jaula jaula;
    private Alimento alimento;
    private List<Jaula> jaulas;
    private List<Alimento> alimentos;
    
    @PostConstruct
    public void init() {
        loadLazyModels();
        jaulas = jaulaService.findAll();
        alimentos = alimentoService.findAll();
        registroAlimentacion = new RegistroAlimentacion();
    }

    public AlimentoService getAlimentoService() {
        return alimentoService;
    }

    public void setAlimentoService(AlimentoService alimentoService) {
        this.alimentoService = alimentoService;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }
    private RegistroAlimentacion registroAlimentacion;

    public RegistroAlimentacionService getRegistroAlimentacionService() {
        return registroAlimentacionService;
    }

    public void setRegistroAlimentacionService(RegistroAlimentacionService registroAlimentacionService) {
        this.registroAlimentacionService = registroAlimentacionService;
    }

    public JaulaService getJaulaService() {
        return jaulaService;
    }

    public void setJaulaService(JaulaService jaulaService) {
        this.jaulaService = jaulaService;
    }

    public Jaula getJaula() {
        return jaula;
    }

    public void setJaula(Jaula jaula) {
        this.jaula = jaula;
    }

    public RegistroAlimentacion getRegistroAlimentacion() {
        return registroAlimentacion;
    }

    public void setRegistroAlimentacion(RegistroAlimentacion registroAlimentacion) {
        this.registroAlimentacion = registroAlimentacion;
    }

    public List<Jaula> getJaulas() {
        return jaulas;
    }

    public void setJaulas(List<Jaula> jaulas) {
        this.jaulas = jaulas;
    }

    @Override
    public GenericService<RegistroAlimentacion, Integer> getService() {
        return registroAlimentacionService;
    }

    @Override
    public LazyDataModel<RegistroAlimentacion> getNewLazyModel() {
        return new RegistroAlimentacionLazyModel(registroAlimentacionService);
    }
    
    public void toCreateRegistroAlimentacion(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            jaulas = jaulaService.findAll();
            alimentos = alimentoService.findAll();
            setSelected(new RegistroAlimentacion());
            contex.getExternalContext().redirect("/siapa/views/registroAlimentacion/Create.xhtml");
        } catch (IOException ex) {
            //   log.error("Error al rederigir a la pagina de asesoria", null, ex);
        }
    }
    
    public void llenar() {
        //System.out.println("punto");

    }

    @Override
    public void saveNew(ActionEvent event) {

        RegistroAlimentacion registroAlimentacion = getRegistroAlimentacion();
        registroAlimentacion.setIdJaula(jaula);
        registroAlimentacion.setIdAlimento(alimento);
        registroAlimentacion.setUsuarioRegistroAlimentacion(getUsuario());
        registroAlimentacionService.save(registroAlimentacion);
    }
    
}
