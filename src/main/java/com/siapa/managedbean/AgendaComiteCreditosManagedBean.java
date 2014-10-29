package com.siapa.managedbean;

import com.siapa.jasper.Reporte;
import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.AgendaComiteCreditosLazyModel;
import com.siapa.model.Agendacomitecreditos;
import com.siapa.model.Analisis;
import com.siapa.model.Analisisenagendacomitecreditos;
import com.siapa.model.Asistente;
import com.siapa.model.AsistentePK;
import com.siapa.model.Miembroscomitecreditos;
import com.siapa.model.Tiporesolucion;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.pojos.rpt.actacomitecredito.ReporteActaComiteCreditopojo;
import com.siapa.pojos.rpt.informegerencial.RptInformeGerencial;
import com.siapa.service.AgendaComiteCreditosService;
import com.siapa.service.AnalisisEnAgendaComiteCreditosService;
import com.siapa.service.AnalisisService;
import com.siapa.service.AsistenteService;
import com.siapa.service.MiembrosComiteCreditosService;
import com.siapa.service.TipoResolucionService;
import com.siapa.service.generic.GenericService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author angel montenegro
 */
@Named("agendaComiteCreditosManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class AgendaComiteCreditosManagedBean extends GenericManagedBean<Agendacomitecreditos, Integer> {

    @Autowired
    @Qualifier(value = "agendaComiteCreditosService")
    private AgendaComiteCreditosService agendaComiteCreditosService;

    @Autowired
    @Qualifier(value = "miembrosComiteCreditosService")
    private MiembrosComiteCreditosService miembrosComiteCreditosService;

    @Autowired
    @Qualifier(value = "analisisService")
    private AnalisisService analisisService;

    @Autowired
    @Qualifier(value = "asistenteService")
    private AsistenteService asistenteService;

    @Autowired
    @Qualifier(value = "analisisEnAgendaComiteCreditosService")
    private AnalisisEnAgendaComiteCreditosService analisisEnAgendaComiteCreditosService;

    @Autowired
    @Qualifier(value = "tipoResolucionService")
    private TipoResolucionService tipoResolucionService;

    //Listados
    private List<Agendacomitecreditos> agendacomitecreditosList;
    private List<Miembroscomitecreditos> miembrosComitedeCreditosList;
    private List<Analisis> analisisCompletos = new ArrayList<Analisis>();
    private List<Asistente> asistentesPosibles = new ArrayList<Asistente>();
    private List<Asistente> asistentes = new ArrayList<Asistente>();
    private List<Analisis> analisisParaInforme = new ArrayList<Analisis>();
    private List<Asistente> asistentesParaInforme = new ArrayList<Asistente>();
    private List<Analisis> analisisParaActa = new ArrayList<Analisis>();
    private List<Asistente> asistentesParaActa = new ArrayList<Asistente>();
    private List<Analisis> analisis = new ArrayList<Analisis>();
    private List<Tiporesolucion> tiporesolucionList = new ArrayList<Tiporesolucion>();
    private List<Analisisenagendacomitecreditos> analisisenagendacomitecreditosList = new ArrayList<Analisisenagendacomitecreditos>();
    private List<Agendacomitecreditos> reunionesPendientes;
    private List<Agendacomitecreditos> reunionesRealizadas;

    //variables
    private Agendacomitecreditos agendaSelected;
    private Agendacomitecreditos actaSelected;
    private Date fechaInicialActa;
    private Date fechaFinalActa;
    private Analisis analisisSelectedParaInforme;

    private String reportName;

    @Override
    public GenericService<Agendacomitecreditos, Integer> getService() {
        return agendaComiteCreditosService;
    }

    @PostConstruct
    public void init() {
        loadLazyModels();
        fechaFinalActa = new Date();
        fechaInicialActa = new Date();
        reunionesRealizadas = agendaComiteCreditosService.buscarRealizadas(fechaInicialActa, fechaFinalActa);
        reunionesPendientes = agendaComiteCreditosService.reunionesPendientes();
        tiporesolucionList = tipoResolucionService.findAll();
    }

    @Override
    public LazyDataModel<Agendacomitecreditos> getNewLazyModel() {
        return new AgendaComiteCreditosLazyModel(agendaComiteCreditosService);
    }

    public AgendaComiteCreditosManagedBean() {
    }

    @Override
    public void saveNew(ActionEvent event) {
        if (getUsuario() != null) {

            if (getSelected() != null) {
                this.setEmbeddableKeys();
                try {
                    getSelected().setUsuarioRegistro(getUsuario());
                    getSelected().setFechaRegistro(new Date());
                    getSelected().setActivo("SI");

                    agendaComiteCreditosService.saveNew(getSelected(), asistentesPosibles, analisisCompletos);

                    clean();

                    reunionesPendientes = agendaComiteCreditosService.reunionesPendientes();
                    JsfUtil.addSuccessMessage("Reunion ingresada exitosamente");
                } catch (Exception ex) {
                    String msg = "";
                    Throwable cause = JsfUtil.getRootCause(ex.getCause());
                    if (cause != null) {
                        msg = cause.getLocalizedMessage();
                    }
                    if (msg.length() > 0) {
                        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/crudbundle").getString("PersistenceErrorOccured"));
                        //JsfUtil.addErrorMessage(msg);
                    } else {
                        JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/crudbundle").getString("PersistenceErrorOccured"));
                    }
                }
            }
        }
    }

    @Override
    public void save(ActionEvent event) {
        if (getUsuario() != null) {

            if (getSelected() != null) {
                // this.setEmbeddableKeys();
                try {

                    getSelected().setUsuarioUltimamodificacion(getUsuario());
                    getSelected().setFechaUltimamodificacion(new Date());

                    agendaComiteCreditosService.update(getSelected(), asistentes, analisis);

                    clean();
                    JsfUtil.addSuccessMessage("Reunion actualizada exitosamente");
                } catch (Exception ex) {
                    String msg = "";
                    Throwable cause = JsfUtil.getRootCause(ex.getCause());
                    if (cause != null) {
                        msg = cause.getLocalizedMessage();
                    }
                    if (msg.length() > 0) {
                        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/crudbundle").getString("PersistenceErrorOccured"));
                        //JsfUtil.addErrorMessage(msg);
                    } else {
                        JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/crudbundle").getString("PersistenceErrorOccured"));
                    }
                }
            }
        }
    }

    public void close(ActionEvent event) {
        if (getUsuario() != null) {

            if (getSelected() != null) {
                // this.setEmbeddableKeys();
                try {

                    getSelected().setUsuarioUltimamodificacion(getUsuario());
                    getSelected().setFechaUltimamodificacion(new Date());

                    agendaComiteCreditosService.close(getSelected(), asistentes, analisisenagendacomitecreditosList);

                    clean();
                    setSelected(null);
                    reunionesPendientes = agendaComiteCreditosService.reunionesPendientes();
                    JsfUtil.addSuccessMessage("Reunion actualizada exitosamente");
                } catch (Exception ex) {
                    String msg = "";
                    Throwable cause = JsfUtil.getRootCause(ex.getCause());
                    if (cause != null) {
                        msg = cause.getLocalizedMessage();
                    }
                    if (msg.length() > 0) {
                        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/crudbundle").getString("PersistenceErrorOccured"));
                        //JsfUtil.addErrorMessage(msg);
                    } else {
                        JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/crudbundle").getString("PersistenceErrorOccured"));
                    }
                }
            }
        }
    }

    public void toCreate() {

        miembrosComitedeCreditosList = miembrosComiteCreditosService.findAllActives();
        analisisCompletos = analisisService.buscarListosParaAgenda();
        asistentesPosibles.clear();
        for (Miembroscomitecreditos miembro : miembrosComitedeCreditosList) {
            AsistentePK tmpPK = new AsistentePK();
            Asistente tmp = new Asistente();
            tmp.setAsistentePK(tmpPK);
            tmp.getAsistentePK().setMccId(miembro.getMccId());
            tmp.setMiembroscomitecreditos(miembro);
            tmp.setAsistenteAsistira(true);
            asistentesPosibles.add(tmp);
        }
        setSelected(new Agendacomitecreditos());
    }

    public Agendacomitecreditos prepareView(ActionEvent event) {

        if (getSelected() != null) {
            analisis = analisisService.findByAccId(getSelected().getAccId());
            asistentes = asistenteService.findByAccId(getSelected().getAccId());
        }
        return null;
    }

    public Agendacomitecreditos prepareViewRptGerencial(ActionEvent event) {

        if (getAgendaSelected() != null) {
            analisisParaInforme = analisisService.findByAccId(getAgendaSelected().getAccId());
            asistentesParaInforme = asistenteService.findByAccId(getAgendaSelected().getAccId());
        }

        return null;
    }

    public Agendacomitecreditos prepareViewActa(ActionEvent event) {

        if (getActaSelected() != null) {
            analisisParaActa = analisisService.findByAccId(getActaSelected().getAccId());
            asistentesParaActa = asistenteService.findByAccId(getActaSelected().getAccId());
        }

        return null;
    }

    public Agendacomitecreditos prepareEdit(ActionEvent event) {

        if (getSelected() != null) {

            analisis = analisisService.findByAccId(getSelected().getAccId());
            asistentes = asistenteService.findByAccId(getSelected().getAccId());

            for (Analisis anls : analisis) {
                anls.setSelected(true);
            }
        }
        return null;
    }

    public Agendacomitecreditos prepareClose(ActionEvent event) {

        if (getSelected() != null) {
            analisisenagendacomitecreditosList = analisisEnAgendaComiteCreditosService.buscarAnalisisEnAgenda(getSelected().getAccId());
            asistentes = asistenteService.findByAccId(getSelected().getAccId());
        }
        return null;
    }

    public void printInformeGerencial() {

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        List<RptInformeGerencial> list = new ArrayList<RptInformeGerencial>();
        list.add(analisisService.fillAnalisisParaInformeGerencial(analisisSelectedParaInforme));
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        Reporte reporte = new Reporte("resolucion", "rpt_informeGerencial", request);
        reporte.setDataSource(new JRBeanCollectionDataSource(new HashSet<RptInformeGerencial>(list)));
        reporte.setReportInSession(request, response);
        setReportName(reporte.getNombreLogico());
        RequestContext.getCurrentInstance().addCallbackParam("reportName", getReportName());

    }

    public void printActa() {

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        List<ReporteActaComiteCreditopojo> list = new ArrayList<ReporteActaComiteCreditopojo>();
        list.add(agendaComiteCreditosService.fillAgendaParaActaComite(actaSelected));
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        Reporte reporte = new Reporte("resolucion", "rpt_actaDeComiteDeCreditos", request);
        reporte.setDataSource(new JRBeanCollectionDataSource(new HashSet<ReporteActaComiteCreditopojo>(list)));
        reporte.setReportInSession(request, response);
        setReportName(reporte.getNombreLogico());
        RequestContext.getCurrentInstance().addCallbackParam("reportName", getReportName());
        
    }

    public void findRealizadas() {
        reunionesRealizadas = agendaComiteCreditosService.buscarRealizadas(fechaInicialActa, fechaFinalActa);
    }

    public void refreshPendientes() {
        reunionesPendientes = agendaComiteCreditosService.reunionesPendientes();
    }

    public void refreshLazy() {
        loadLazyModels();
    }

    public void clean() {
        this.setSelected(null);

    }

    public List<Agendacomitecreditos> getAgendacomitecreditosList() {
        return agendacomitecreditosList;
    }

    public void setAgendacomitecreditosList(List<Agendacomitecreditos> agendacomitecreditosList) {
        this.agendacomitecreditosList = agendacomitecreditosList;
    }

    public List<Miembroscomitecreditos> getMiembrosComitedeCreditosList() {
        return miembrosComitedeCreditosList;
    }

    public void setMiembrosComitedeCreditosList(List<Miembroscomitecreditos> miembrosComitedeCreditosList) {
        this.miembrosComitedeCreditosList = miembrosComitedeCreditosList;
    }

    public List<Analisis> getAnalisisCompletos() {
        return analisisCompletos;
    }

    public void setAnalisisCompletos(List<Analisis> analisisCompletos) {
        this.analisisCompletos = analisisCompletos;
    }

    public List<Asistente> getAsistentesPosibles() {
        return asistentesPosibles;
    }

    public void setAsistentesPosibles(List<Asistente> asistentesPosibles) {
        this.asistentesPosibles = asistentesPosibles;
    }

    public List<Asistente> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(List<Asistente> asistentes) {
        this.asistentes = asistentes;
    }

    public List<Analisis> getAnalisis() {
        return analisis;
    }

    public void setAnalisis(List<Analisis> analisis) {
        this.analisis = analisis;
    }

    public List<Analisisenagendacomitecreditos> getAnalisisenagendacomitecreditosList() {
        return analisisenagendacomitecreditosList;
    }

    public void setAnalisisenagendacomitecreditosList(List<Analisisenagendacomitecreditos> analisisenagendacomitecreditosList) {
        this.analisisenagendacomitecreditosList = analisisenagendacomitecreditosList;
    }

    public List<Tiporesolucion> getTiporesolucionList() {
        return tiporesolucionList;
    }

    public void setTiporesolucionList(List<Tiporesolucion> tiporesolucionList) {
        this.tiporesolucionList = tiporesolucionList;
    }

    public List<Agendacomitecreditos> getReunionesPendientes() {
        return reunionesPendientes;
    }

    public void setReunionesPendientes(List<Agendacomitecreditos> reunionesPendientes) {
        this.reunionesPendientes = reunionesPendientes;
    }

    public Agendacomitecreditos getAgendaSelected() {
        return agendaSelected;
    }

    public void setAgendaSelected(Agendacomitecreditos agendaSelected) {
        this.agendaSelected = agendaSelected;
    }

    public List<Analisis> getAnalisisParaInforme() {
        return analisisParaInforme;
    }

    public void setAnalisisParaInforme(List<Analisis> analisisParaInforme) {
        this.analisisParaInforme = analisisParaInforme;
    }

    public List<Asistente> getAsistentesParaInforme() {
        return asistentesParaInforme;
    }

    public void setAsistentesParaInforme(List<Asistente> asistentesParaInforme) {
        this.asistentesParaInforme = asistentesParaInforme;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public List<Analisis> getAnalisisParaActa() {
        return analisisParaActa;
    }

    public void setAnalisisParaActa(List<Analisis> analisisParaActa) {
        this.analisisParaActa = analisisParaActa;
    }

    public List<Asistente> getAsistentesParaActa() {
        return asistentesParaActa;
    }

    public void setAsistentesParaActa(List<Asistente> asistentesParaActa) {
        this.asistentesParaActa = asistentesParaActa;
    }

    public List<Agendacomitecreditos> getReunionesRealizadas() {
        return reunionesRealizadas;
    }

    public void setReunionesRealizadas(List<Agendacomitecreditos> reunionesRealizadas) {
        this.reunionesRealizadas = reunionesRealizadas;
    }

    public Agendacomitecreditos getActaSelected() {
        return actaSelected;
    }

    public void setActaSelected(Agendacomitecreditos actaSelected) {
        this.actaSelected = actaSelected;
    }

    public Date getFechaInicialActa() {
        return fechaInicialActa;
    }

    public void setFechaInicialActa(Date fechaInicialActa) {
        this.fechaInicialActa = fechaInicialActa;
    }

    public Date getFechaFinalActa() {
        return fechaFinalActa;
    }

    public void setFechaFinalActa(Date fechaFinalActa) {
        this.fechaFinalActa = fechaFinalActa;
    }

    public Analisis getAnalisisSelectedParaInforme() {
        return analisisSelectedParaInforme;
    }

    public void setAnalisisSelectedParaInforme(Analisis analisisSelectedParaInforme) {
        this.analisisSelectedParaInforme = analisisSelectedParaInforme;
    }

}
