
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.model.Analisis;
import com.siapa.model.Nivelresolucion;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.service.AnalisisService;
import com.siapa.service.NivelResolucionService;
import com.siapa.service.generic.GenericService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionListener;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Josue Rogelio 
 */
@Named("enviarAnalisisManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class EnviarAnalisisManagedBean extends GenericManagedBean<Analisis, Integer>{

@Autowired
    @Qualifier(value = "analisisService")
    private AnalisisService analisisService;
@Autowired
    @Qualifier(value = "nivelResolucionService")
    private NivelResolucionService nivelResolucionService;
//declaracion de listas
private List<Analisis> analisisItems;
private List<Analisis> analisisSelectedList;
private Analisis analisisSelected;
private List<Nivelresolucion> nivelesResolucion;
private Nivelresolucion nivelResolucionSelected;



    @PostConstruct
    public void init() {
        analisisItems = analisisService.buscarParaEnvioResolucion();
        nivelesResolucion=nivelResolucionService.findAllActives();
    }
    
        /**
     *
     * @param event
     */
    public void onselect(SelectEvent event) {

        System.out.println("" + getNivelResolucionSelected());
        System.out.println("");
    }

    public void updateAnalisis(ActionListener event) {
        try {
            analisisService.enviarResolucion(analisisSelectedList, nivelResolucionSelected);
              analisisItems = analisisService.buscarParaEnvioResolucion();
        } catch (Exception e) {
             JsfUtil.addErrorMessage("ERROR", "Enviando Analisis a Asesorias");
        }
     
    }
    
    @Override
    public GenericService<Analisis, Integer> getService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LazyDataModel<Analisis> getNewLazyModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AnalisisService getAnalisisService() {
        return analisisService;
    }

    public void setAnalisisService(AnalisisService analisisService) {
        this.analisisService = analisisService;
    }

    public List<Analisis> getAnalisisItems() {
        return analisisItems;
    }

    public void setAnalisisItems(List<Analisis> analisisItems) {
        this.analisisItems = analisisItems;
    }

    public Analisis getAnalisisSelected() {
        return analisisSelected;
    }

    public void setAnalisisSelected(Analisis analisisSelected) {
        this.analisisSelected = analisisSelected;
    }

    public List<Analisis> getAnalisisSelectedList() {
        return analisisSelectedList;
    }

    public void setAnalisisSelectedList(List<Analisis> analisisSelectedList) {
        this.analisisSelectedList = analisisSelectedList;
    }

    public List<Nivelresolucion> getNivelesResolucion() {
        return nivelesResolucion;
    }

    public void setNivelesResolucion(List<Nivelresolucion> nivelesResolucion) {
        this.nivelesResolucion = nivelesResolucion;
    }

    public NivelResolucionService getNivelResolucionService() {
        return nivelResolucionService;
    }

    public void setNivelResolucionService(NivelResolucionService nivelResolucionService) {
        this.nivelResolucionService = nivelResolucionService;
    }

    public Nivelresolucion getNivelResolucionSelected() {
        return nivelResolucionSelected;
    }

    public void setNivelResolucionSelected(Nivelresolucion nivelResolucionSelected) {
        this.nivelResolucionSelected = nivelResolucionSelected;
    }

}
