/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.AlimentoLazyModel;
import com.siapa.model.Alimento;
import com.siapa.service.AlimentoService;
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

/**
 *
 * @author Joao
 */
@Named("alimentoManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class AlimentoManangedBean extends GenericManagedBean<Alimento, Long> {

    @Autowired
    @Qualifier(value = "alimentoService")
    private AlimentoService alimentoService;

    @PostConstruct
    public void init() {
        loadLazyModels();
    }
    
    @Override
    public GenericService<Alimento, Long> getService() {
        return alimentoService;
    }

    @Override
    public LazyDataModel<Alimento> getNewLazyModel() {
        return new AlimentoLazyModel(alimentoService);
    }

    
//    @Override
//    public void saveNew(ActionEvent event) {
//       if(getUsuario()!=null){
//        String msg = ResourceBundle.getBundle("/crudbundle").getString(Alimento.class.getSimpleName() + "Usuario creado con exito");
////        getSelected().setUsuarioRegistro(getUsuario());
////        getSelected().setFechaRegistro(new Date());
//        persist(PersistAction.CREATE, msg);
//       }
//    }
//
//    @Override
//    public void save(ActionEvent event) {
//        String msg = ResourceBundle.getBundle("/crudbundle").getString(Alimento.class.getSimpleName() + "Usuario actualizado con exito");
////        getSelected().setUsuarioUltimamodificacion(getUsuario());
////        getSelected().setFechaUltimamodificacion(new Date());
//        persist(PersistAction.UPDATE, msg);
//        if (!isValidationFailed()) {
//           items = null; // Invalidate list of items to trigger re-query.
//        }
//    }
}
