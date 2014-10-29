package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.model.Analisis;
import com.siapa.model.Garantia;
import com.siapa.model.Garantiaasignadaasesoria;
import com.siapa.service.RegistrarGarantiasService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Named("registroGarantiasManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class RegistroGarantiasManagedBean extends GenericManagedBean<Analisis, Integer> {

    public static Logger log = LoggerFactory.getLogger(RegistroGarantiasManagedBean.class.getName());

    @Autowired
    @Qualifier(value = "registrarGarantiasService")
    private RegistrarGarantiasService registrarGarantiasService;
    private List<Analisis> anlisisItems;
    private List<Garantia> tiposGarantias;
//    private Garantia garantiaSelected;
    private Integer garantiaSelected;
    private SelectItem[] opcionesGarantias;

    private final String urlprendaria = "/siacofinges/views/garantia/prendaria/index.xhtml";
    private final String urlreal = "/siacofinges/views/garantia/real/index.xhtml";
    private final String urlcodeudor = "/siacofinges/views/garantia/codeudor/index.xhtml";
    private final String urlhipotecaria = "/siacofinges/views/garantia/hipotecaria/index.xhtml";

    @PostConstruct
    public void init() {
        cargarAnalisisListos();
//        tiposGarantias = garantiaService.findAll();
    }

    private SelectItem[] optionsGarantias() {
        SelectItem[] options = new SelectItem[4];
        options[0] = new SelectItem(1, "Real");
        options[1] = new SelectItem(2, "Hipotecaria");
        options[2] = new SelectItem(3, "Prendaria");
        options[3] = new SelectItem(4, "Codeudor Solidario");

        return options;
    }

    public RegistroGarantiasManagedBean() {
        opcionesGarantias = optionsGarantias();
    }

    public void cargarAnalisisListos() {
        anlisisItems = registrarGarantiasService.findAll();

        for (Analisis an : anlisisItems) {

            Analisis requeridas = registrarGarantiasService.findById(an.getAnalisisId());

            Set<Garantiaasignadaasesoria> rgr = requeridas.getSolicitudId().getAsesoriaId().getGarantiaasignadaasesoriaList();
        
            for (Garantiaasignadaasesoria ga : rgr) {

                switch (ga.getGarantia().getGarantiaId().intValue()) {
                    case 1:
                        an.setgRealReq(ga.getGaasCantidad());
                        break;
                    case 2:
                        an.setgHipotecariaReq(ga.getGaasCantidad());
                        break;
                    case 3:
                        an.setgPrendariaReq(ga.getGaasCantidad());
                        break;
                    case 4:
                        an.setgCodeudorReq(ga.getGaasCantidad());
                        break;
                    default:
                        break;
                }

            }

            Analisis analisisRegistradas = registrarGarantiasService.findById(an.getAnalisisId());

            an.setgRealReg(analisisRegistradas.getRegistrogarantiarealList().size());
            an.setgCodeudorReg(analisisRegistradas.getRegistrogarantiacodeudorList().size());
            an.setgHipotecariaReg(analisisRegistradas.getRegistrogarantiahipotecariaList().size());
            an.setgPrendariaReg(analisisRegistradas.getRegistrogarantiaprendariaList().size());
            
            
            if((an.getgRealReg()>=an.getgRealReq()) && (an.getgPrendariaReg()>=an.getgPrendariaReq()) && (an.getgCodeudorReg()>=an.getgCodeudorReq()) && (an.getgHipotecariaReg()>=an.getgHipotecariaReq()) ){
                an.setColor(1);
            }

        }

    }

    public void transferir(ActionEvent event) {

        FacesContext context = FacesContext.getCurrentInstance();
        Analisis requeridas = registrarGarantiasService.findById(getSelected().getAnalisisId());
        String codigoSolictud=requeridas.getSolicitudId().getSolicitudId().toString();
        String nombreSocio=requeridas.getSolicitudId().getNombreCompleto();
        String codigoSocio=requeridas.getSolicitudId().getSolicitudCodigoasociado();    
        
        context.getExternalContext().getSessionMap().put("codigoSolicitud", codigoSolictud);
        context.getExternalContext().getSessionMap().put("codigoSocio", codigoSocio);
        context.getExternalContext().getSessionMap().put("nombreSocio", nombreSocio);
        
        context.getExternalContext().getSessionMap().put("idAnalisis", getSelected().getAnalisisId());
        context.getExternalContext().getSessionMap().put("idGarantia", garantiaSelected);
        Integer var=garantiaSelected;
        limpiar();
        
        try {
            switch (var) {
                case 1:
                    context.getExternalContext().redirect(urlreal);
                    break;
                case 2:
                    context.getExternalContext().redirect(urlhipotecaria);
                    break;
                case 3:
                    context.getExternalContext().redirect(urlprendaria);
                    break;
                case 4:
                    context.getExternalContext().redirect(urlcodeudor);
                    break;

            }

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(RegistroGarantiasManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    public void limpiar(){
        anlisisItems=null;
        garantiaSelected=null;
        setSelected(null);
    }
    
    /**
     *
     * @param event
     */
    public void onselect(SelectEvent event) {

        System.out.println("" + getGarantiaSelected());
    }

    public List<Analisis> getAnlisisItems() {
        return anlisisItems;
    }

    public void setAnlisisItems(List<Analisis> anlisisItems) {
        this.anlisisItems = anlisisItems;
    }

    @Override
    public GenericService<Analisis, Integer> getService() {
        return registrarGarantiasService;
    }

    @Override
    public LazyDataModel<Analisis> getNewLazyModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Garantia> getTiposGarantias() {
        return tiposGarantias;
    }

    public void setTiposGarantias(List<Garantia> tiposGarantias) {
        this.tiposGarantias = tiposGarantias;
    }

    public SelectItem[] getOpcionesGarantias() {
        return opcionesGarantias;
    }

    public void setOpcionesGarantias(SelectItem[] opcionesGarantias) {
        this.opcionesGarantias = opcionesGarantias;
    }

    public Integer getGarantiaSelected() {
        return garantiaSelected;
    }

    public void setGarantiaSelected(Integer garantiaSelected) {
        this.garantiaSelected = garantiaSelected;
    }

}
