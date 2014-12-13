/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.DetalleMuestreoLazyModel;
import com.siapa.model.DetalleMuestreo;
import com.siapa.model.Muestreo;
import com.siapa.service.MuestreoService;
import com.siapa.service.generic.GenericService;
import com.siapa.service.DetalleMuestreoService;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
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
 * @author WalterGM
 */
@Named("detallemuestreoManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class DetalleMuestreoManagedBean extends GenericManagedBean<DetalleMuestreo, Integer> {

    @Autowired
    @Qualifier(value = "DetalleMuestreoService")
    private DetalleMuestreoService detallemuestreoService;

    @Autowired
    @Qualifier(value = "muestreoService")
    private MuestreoService muestreoService;

    private DetalleMuestreo detallemuestreo;
    private Muestreo muestreo;
    private List<Muestreo> listMuestreo;
    private List<DetalleMuestreo> listadetalle;

    @PostConstruct
    public void init() {
        loadLazyModels();
        detallemuestreo = new DetalleMuestreo();
        listMuestreo = muestreoService.findAll();

    }

    @Override
    public GenericService<DetalleMuestreo, Integer> getService() {
        return detallemuestreoService;
    }

    @Override
    public LazyDataModel<DetalleMuestreo> getNewLazyModel() {
        return new DetalleMuestreoLazyModel(detallemuestreoService);
    }

    public void toCreateDetalleMuestreo(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            listMuestreo = muestreoService.findAll();
            setSelected(new DetalleMuestreo());
            contex.getExternalContext().redirect("/siapa/views/detalleMuestreo/Create.xhtml");

        } catch (IOException ex) {

        }
    }

    @Override
    public void saveNew(ActionEvent event) {
        DetalleMuestreo detallemuestreo = getDetallemuestreo();
        detallemuestreo.setIdMuestreo(muestreo);
        detallemuestreoService.save(detallemuestreo);
        BigInteger cant = detallemuestreoService.cantidad(muestreo.getIdMuestreo());

        BigDecimal dividir = new BigDecimal(cant);
        List<DetalleMuestreo> q = detallemuestreoService.findAll();
        BigDecimal suma = BigDecimal.ZERO;
        BigDecimal promedio = BigDecimal.ZERO;

        for (DetalleMuestreo detalle : q) {
            if (detalle.getIdMuestreo().getIdMuestreo() == muestreo.getIdMuestreo()) {
                suma = suma.add(detalle.getPesoDetalleMuestreo());
            }
        }
        int sumaint=suma.intValue();
        int cantint=cant.intValue();
        //int prom=sumaint/cantint;
      //  promedio=new BigDecimal(prom);
      //  System.out.println(prom);
        promedio=suma.divide(dividir);
        Muestreo newMuestreo = getMuestreo();
        newMuestreo.setPesoPromedioMuestreo(suma.divide(dividir));
        //  muestreo.setPesoPromedioMuestreo(suma);
        System.out.println(promedio);
        muestreoService.merge(newMuestreo);

        loadLazyModels();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful"));
        try {
            FacesContext context1 = FacesContext.getCurrentInstance();
            context1.getExternalContext().redirect("/siapa/views/detalleMuestreo/index.xhtml");
        } catch (IOException e) {

        }

    }

    public void toIndexMuestreo(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();

            contex.getExternalContext().redirect("/siapa/views/detalleMuestreo/index.xhtml");

        } catch (IOException ex) {

        }
    }

    public void llenar() {
        System.out.println("punto");

    }

    public DetalleMuestreo getDetallemuestreo() {
        return detallemuestreo;
    }

    public void setDetallemuestreo(DetalleMuestreo detallemuestreo) {
        this.detallemuestreo = detallemuestreo;
    }

    public Muestreo getMuestreo() {
        return muestreo;
    }

    public void setMuestreo(Muestreo muestreo) {
        this.muestreo = muestreo;
    }

    public List<Muestreo> getListMuestreo() {
        return listMuestreo;
    }

    public void setListMuestreo(List<Muestreo> listMuestreo) {
        this.listMuestreo = listMuestreo;
    }

}
