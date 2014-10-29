/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.DesembolsoDeEfectivoLazyModel;
import com.siapa.model.Efectivo;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.service.DesembolsoDeEfectivoService;
import com.siapa.service.generic.GenericService;
import java.util.Date;
import java.util.List;
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
 * @author Angel
 */
@Named("desembolsoDeEfectivoManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class DesembolsoDeEfectivoManagedBean extends GenericManagedBean<Efectivo, Integer> {

    @Autowired
    @Qualifier(value = "desembolsoDeEfectivoService")
    private DesembolsoDeEfectivoService desembolsoDeEfectivoService;

    private List<Efectivo> desembolsoEfectivoNoEntregadoList;
    private Efectivo efectivoSelected;

    @PostConstruct
    public void init() {
        actualizarEfectivoItems();
        loadLazyModels();
    }

    public DesembolsoDeEfectivoManagedBean() {
    }

    @Override
    public GenericService<Efectivo, Integer> getService() {
        return desembolsoDeEfectivoService;
    }

    @Override
    public LazyDataModel<Efectivo> getNewLazyModel() {
        return new DesembolsoDeEfectivoLazyModel(desembolsoDeEfectivoService);
    }

    @Override
    public void save(ActionEvent event) {
        if (getUsuario() != null) {
            String msg = "Registro de efectivo realizado con exito";
            Date hoy = new Date();

            try {
                //Guardar desembolso

                efectivoSelected.setEfectivoEntregado(Boolean.TRUE);
                efectivoSelected.setUsuarioUltimamodificacion(getUsuario());
                efectivoSelected.setFechaUltimamodificacion(hoy);
                desembolsoDeEfectivoService.merge(efectivoSelected);

                actualizarEfectivoItems();
                             
                JsfUtil.addSuccessMessage(msg);

            } catch (Exception e) {
                JsfUtil.addErrorMessage("No se pudo modificar el desembolso");
            }

        }
    }

    public void actualizarEfectivoItems() {
        desembolsoEfectivoNoEntregadoList = desembolsoDeEfectivoService.efectivoPendienteDeEntrega();
    }

    public List<Efectivo> getDesembolsoEfectivoNoEntregadoList() {
        return desembolsoEfectivoNoEntregadoList;
    }

    public void setDesembolsoEfectivoNoEntregadoList(List<Efectivo> desembolsoEfectivoNoEntregadoList) {
        this.desembolsoEfectivoNoEntregadoList = desembolsoEfectivoNoEntregadoList;
    }

    public Efectivo getEfectivoSelected() {
        return efectivoSelected;
    }

    public void setEfectivoSelected(Efectivo efectivoSelected) {
        this.efectivoSelected = efectivoSelected;
    }
}
