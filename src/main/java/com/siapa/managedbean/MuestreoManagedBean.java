/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.MuestreoLazyModel;
import com.siapa.model.Muestreo;
import com.siapa.service.MuestreoService;
import com.siapa.service.generic.GenericService;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
 * @author WalterGM
 */
@Named("muestreoManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class MuestreoManagedBean extends GenericManagedBean<Muestreo, Integer> {

    @Autowired
    @Qualifier(value = "muestreoService")
    private MuestreoService muestreoService;

    @PostConstruct
    public void init() {
        loadLazyModels();
    }

    @Override
    public GenericService<Muestreo, Integer> getService() {
        return muestreoService;
    }

    @Override
    public LazyDataModel<Muestreo> getNewLazyModel() {
        return new MuestreoLazyModel(muestreoService);
    }

}
