/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.CategoriasLazyModel;
import com.siapa.model.Categorias;
import com.siapa.service.CategoriasService;
import com.siapa.service.generic.GenericService;
import javax.annotation.PostConstruct;
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
@Named("categoriasManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class CategoriasManagedBean extends GenericManagedBean<Categorias, Integer> {

    @Autowired
    @Qualifier(value = "categoriasService")
    private CategoriasService categoriasService;

    @PostConstruct
    public void init() {
        loadLazyModels();
    }

    @Override
    public GenericService<Categorias, Integer> getService() {
       return categoriasService;
    }

    @Override
    public LazyDataModel<Categorias> getNewLazyModel() {
        return new CategoriasLazyModel(categoriasService);
    }

}
