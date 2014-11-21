/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.AlimentoLazyModel;
import com.siapa.model.Alimento;
import com.siapa.model.TipoAlimento;
import com.siapa.service.AlimentoService;
import com.siapa.service.TipoAlimentoService;
import com.siapa.service.generic.GenericService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
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
@Named("alimentoManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class AlimentoManangedBean extends GenericManagedBean<Alimento, Integer> {

    @Autowired
    @Qualifier(value = "alimentoService")
    private AlimentoService alimentoService;
    
    @Autowired
    @Qualifier(value = "tipoAlimentoService")
    private TipoAlimentoService tipoAlimentoService;
 
    private List<Alimento> alimentoList;
    private List<TipoAlimento> tipoAlimentoList;
    private TipoAlimento tipoAlimento;
    
    @PostConstruct
    public void init() {
       alimentoList=alimentoService.getTypeFood();
       tipoAlimentoList=tipoAlimentoService.findAll();
    }
    
    @Override
    public GenericService<Alimento, Integer> getService() {
        return alimentoService;
    }

    @Override
    public LazyDataModel<Alimento> getNewLazyModel() {
        return new AlimentoLazyModel(alimentoService);
    }

    
     @Override
    public void saveNew(ActionEvent event) {

        Alimento newAlimento = new Alimento();

        newAlimento.setMarcaAlimento(getSelected().getMarcaAlimento());
        newAlimento.setExistenciaAlimento(getSelected().getExistenciaAlimento());
        newAlimento.setIdTipoAlimento(tipoAlimento);

        alimentoService.save(newAlimento);
        tipoAlimentoList = tipoAlimentoService.findAll();

    }

    
  
    public List<Alimento> getAlimentoList() {
        return alimentoList;
    }

    public void setAlimentoList(List<Alimento> alimentoList) {
        this.alimentoList = alimentoList;
    }

    public List<TipoAlimento> getTipoAlimentoList() {
        return tipoAlimentoList;
    }

    public void setTipoAlimentoList(List<TipoAlimento> tipoAlimentoList) {
        this.tipoAlimentoList = tipoAlimentoList;
    }

    public TipoAlimento getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(TipoAlimento tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }
    
    
}
