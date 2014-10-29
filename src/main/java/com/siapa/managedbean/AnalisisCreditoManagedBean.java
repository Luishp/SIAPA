package com.siapa.managedbean;

import com.siapa.jasper.Reporte;
import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.AnalisisLazyModel;
import com.siapa.managedbean.lazymodel.ConsultaBuroCreditoLazyModel;
import com.siapa.model.Analisis;
import com.siapa.model.Asesoria;
import com.siapa.model.Asociados;
import com.siapa.model.Consultaburocredito;
import com.siapa.model.Deuda;
import com.siapa.model.Formapago;
import com.siapa.model.Garantia;
import com.siapa.model.Garantiaexigida;
import com.siapa.model.Periodicidadpago;
import com.siapa.model.Promocion;
import com.siapa.model.Solicitud;
import com.siapa.model.Tipodeuda;
import com.siapa.model.Tiposolicitud;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.service.AnalisisService;
import com.siapa.service.AsesoriaService;
import com.siapa.service.ConfiguracionSistemaService;
import com.siapa.service.ConsultaBuroCreditoService;
import com.siapa.service.DeudaService;
import com.siapa.service.FormaPagoService;
import com.siapa.service.GarantiaExigidaService;
import com.siapa.service.GarantiaService;
import com.siapa.service.PeriodicidadPagoService;
import com.siapa.service.PromocionService;
import com.siapa.service.SolicitudService;
import com.siapa.service.TipoDeudaService;
import com.siapa.service.TipoSolicitudService;
import com.siapa.service.generic.GenericService;
import com.siapa.utils.FormulasHelper;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author JosueRogelio
 */
@Named("analisisCreditoManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class AnalisisCreditoManagedBean extends GenericManagedBean<Analisis, Integer> {

    private final static Log log = LogFactory.getLog(AnalisisCreditoManagedBean.class);

    @Autowired
    @Qualifier(value = "solicitudService")
    private SolicitudService solicitudService;

    @Autowired
    @Qualifier(value = "analisisService")
    private AnalisisService analisisService;

    @Autowired
    @Qualifier(value = "consultaBuroCreditoService")
    private ConsultaBuroCreditoService consultaBuroCreditoService;

    @Autowired
    @Qualifier(value = "garantiaExigidaService")
    private GarantiaExigidaService garantiaExigidaService;
    @Autowired
    @Qualifier(value = "garantiaService")
    private GarantiaService garantiaService;

    @Autowired
    @Qualifier(value = "asesoriaService")
    private AsesoriaService asesoriaService;

    @Autowired
    @Qualifier(value = "tipoSolicitudService")
    private TipoSolicitudService tipoSolicitudService;
    @Autowired
    @Qualifier(value = "formaPagoService")
    private FormaPagoService formaPagoService;
    @Autowired
    @Qualifier(value = "periodicidadPagoService")
    private PeriodicidadPagoService periodicidadPagoService;
    @Autowired
    @Qualifier(value = "tipoDeudaService")
    private TipoDeudaService tipoDeudaService;
    @Autowired
    @Qualifier(value = "promocionService")
    private PromocionService promocionService;
    @Autowired
    @Qualifier(value = "deudaService")
    private DeudaService deudaService;
    @Autowired
    @Qualifier(value = "configuracionSistemaService")
    private ConfiguracionSistemaService configuracionSistemaService;

    //variables del modelo
    private List<Solicitud> solicitudItems;
    private Analisis analisis;
    private Solicitud solicitudSelected;

    private Asociados asociado;
    private String codigoAsociado;
    private String nombreAsociado;
    private double vecesSalario;

    private List<Analisis> analisisItems;
    private Consultaburocredito cbSelected;
    private Deuda deudaSelected;
    private Deuda deudaTSelected;
    private Deuda prestamoFinSelected;
    private List<Consultaburocredito> consultaBuroCreditoList;
    private LazyDataModel<Consultaburocredito> cbLazyItems;

    private List<Garantiaexigida> garantiasExigidasList;
    private List<Garantia> garantiasList;

    //booleanos
    private boolean analisisCompleto;
    private boolean exameMed;
    private boolean poseeCob;
    private boolean problemSalud;

    //Combos si y no 
    private SelectItem[] examenMedicoOptions;
    private SelectItem[] poseeCoberturaOptions;
    private SelectItem[] problemaSaludOptions;

    //combos
    private List<Tiposolicitud> tipoSolicitudList;
    private List<Formapago> formaPagoList;
    private List<Periodicidadpago> periodicidadPagoList;
    private List<Tipodeuda> tipoDeudaList;
    private List<Deuda> deudaList;
    private List<Deuda> deudaPFList;
    private List<Deuda> deudaTarjetaCredito;
    private List<Promocion> promocionList;
    private List<Promocion> promociones;

    //combos de si o no 
    private SelectItem[] deudaCActivoOptions;
    private SelectItem[] deudaTActivoOptions;
    private SelectItem[] prestamofinActivoOptions;

    private boolean editando;

    private String reportName;
    
    //para situacion crediticia
    private BigDecimal situacionSinFinanciaiemto;
    private BigDecimal situacionConFinanciaiemto;
    private BigDecimal conclusionSituacion;
    
    //deudas seleccionadas.
    private List<Deuda> deudasComercialesSeleccionadasList;

    @Override
    public GenericService<Analisis, Integer> getService() {
        return analisisService;
    }

    @Override
    public LazyDataModel<Analisis> getNewLazyModel() {
        return new AnalisisLazyModel(analisisService);
    }

    @PostConstruct
    public void init() {
        loadLazyModels();
        cargarSolicitudesTerminadas();
        cargarAnalisisIncompletos();

    }

    public AnalisisCreditoManagedBean() {
        examenMedicoOptions = examenMedCreateFilterOptions();
        poseeCoberturaOptions = coberturaCreateFilterOptions();
        problemaSaludOptions = problemSaludCreateFilterOptions();
        prestamofinActivoOptions = prestamofinCreateActivoOptions();
        deudaCActivoOptions = deudaCCreateActivoOptions();
        deudaTActivoOptions = deudaTCreateActivoOptions();
    }

    public void cargarListas() {
        consultaBuroCreditoList = consultaBuroCreditoService.findBurosByAnalisis(analisis.getAnalisisId());
        tipoSolicitudList = tipoSolicitudService.findAll();
        formaPagoList = formaPagoService.findAll();
        periodicidadPagoList = periodicidadPagoService.findAll();
        tipoDeudaList = tipoDeudaService.findAll();
        setPromociones(promocionService.findAll());
        deudaList = deudaService.findDeudasComercialesByAnalisis(analisis.getAnalisisId());
        deudaTarjetaCredito = deudaService.findDeudasTarjetasByAnalisis(analisis.getAnalisisId());
        deudaPFList = deudaService.deudasPrestamosFinByAnalisis(analisis.getAnalisisId());
    }

    private void cargarSolicitudesTerminadas() {
        try {
            solicitudItems = solicitudService.findAllReadies();
        } catch (Exception e) {
            log.debug("Error al tratar de cargar las solicitudes listar para realizar un analisis..." + e.getStackTrace());

        }
    }

    public void cargarAnalisisIncompletos() {
        try {
            analisisItems = analisisService.buscarAnalisisIncompletos();
        } catch (Exception e) {
        }
    }

    /**
     * Metodo para asignar valores en el dialogo de asignar asesoria
     *
     */
    public void dialogAsignarAsesoria() {

        codigoAsociado = asociado.getCodigo();
        nombreAsociado = asociado.getIdasocnatu().getNombreCompleto();
        Solicitud solicitud = solicitudService.findById(analisis.getSolicitudId().getSolicitudId());
        Integer idde = solicitud.getAsesoriaId().getDetallelineacreditoId().getDetallelineacreditoId();
        garantiasExigidasList = garantiaExigidaService.findByDlcId(idde);

        garantiasList = garantiaService.findAll();
    }

    /**
     * Metodo para capturar el evento de la edicion de la celda de cantidad en
     * la asignacion de garantias a la asesorias
     *
     * @param event
     */
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "valor Cambiado", "" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    /**
     * Metodo para guardar la asignacion de garantias a una asesoria
     *
     * @param event
     */
    public void guardarAsignacion(ActionEvent event) {
        System.out.println("entra");
    }

    private SelectItem[] examenMedCreateFilterOptions() {

        SelectItem[] options = new SelectItem[2];

        options[0] = new SelectItem(true, "Si");
        options[1] = new SelectItem(false, "No");

        return options;
    }

    private SelectItem[] coberturaCreateFilterOptions() {

        SelectItem[] options = new SelectItem[2];

        options[0] = new SelectItem(true, "Si");
        options[1] = new SelectItem(false, "No");

        return options;
    }

    private SelectItem[] problemSaludCreateFilterOptions() {

        SelectItem[] options = new SelectItem[2];

        options[0] = new SelectItem(true, "Si");
        options[1] = new SelectItem(false, "No");

        return options;
    }

    private SelectItem[] deudaCCreateActivoOptions() {

        SelectItem[] options = new SelectItem[2];
        options[0] = new SelectItem("SI", "Si");
        options[1] = new SelectItem("NO", "No");

        return options;
    }

    private SelectItem[] deudaTCreateActivoOptions() {

        SelectItem[] options = new SelectItem[2];
        options[0] = new SelectItem("SI", "Si");
        options[1] = new SelectItem("NO", "No");

        return options;
    }

    private SelectItem[] prestamofinCreateActivoOptions() {

        SelectItem[] options = new SelectItem[2];
        options[0] = new SelectItem("SI", "Si");
        options[1] = new SelectItem("NO", "No");

        return options;
    }

    public void toCreateAnalisis(ActionEvent event) {
        if (solicitudSelected != null && getUsuario() != null) {
            FacesContext contex = FacesContext.getCurrentInstance();
            this.analisis = new Analisis();
            Asesoria asesoria = new Asesoria();
            boolean bandera = true;
            situacionSinFinanciaiemto=BigDecimal.ZERO;
            situacionConFinanciaiemto=BigDecimal.ZERO;
            conclusionSituacion=BigDecimal.ZERO;
            deudaPFList = new ArrayList<Deuda>();
            deudaList = new ArrayList<Deuda>();
            deudaTarjetaCredito = new ArrayList<Deuda>();
            List<Deuda> deudasSolicitud;

            try {
                solicitudSelected = solicitudService.findSolicitudByIdSolicitud(solicitudSelected.getSolicitudId());
                asesoria = solicitudSelected.getAsesoriaId();
                asociado = asesoria.getIdasociados();
                deudasSolicitud = new ArrayList<Deuda>(solicitudSelected.getDeudaList());
                promocionList = new ArrayList<Promocion>(solicitudSelected.getAsesoriaId().getPromocionList());
                //1 Tarjeta de credito
                //2 Prestamos financieros
                //3 Deudas Comerciales.
                if (deudasSolicitud.size() > 0) {
                    for (Deuda d : deudasSolicitud) {
                        if (d.getTdId().getTdId().equals(new Integer("2"))) {
                            deudaPFList.add(d);
                        } else if (d.getTdId().getTdId().equals(new Integer("3"))) {
                            deudaList.add(d);
                        } else if (d.getTdId().getTdId().equals(new Integer("1"))) {
                            deudaTarjetaCredito.add(d);
                        }
                    }
                }

//                deudaList = new ArrayList<Deuda>(analisis.getDeudaList());
                analisis.setSolicitudId(solicitudSelected);
                analisis.setSucursalId(solicitudSelected.getSucursalId());
                analisis.setAnalisisMonto(solicitudSelected.getSolicitudMontosolicitado());
                analisis.setAnalisisPlazo(solicitudSelected.getSolicitudPlazosolicitado());
                analisis.setAnalisisTasa(solicitudSelected.getAsesoriaId().getAsesoriaTasa());

                analisis.setAnalisisSegurodano(solicitudSelected.getAsesoriaId().getAsesoriaSegurodanio());
                analisis.setAnalisisSegurodeuda(solicitudSelected.getAsesoriaId().getAsesoriaSegurodeuda());

                //ingresos
                analisis.setAnalisisTotalingreso(solicitudSelected.getSolicitudTotalingreso());

                //Deudas
                analisis.setAnalisisGastovida(solicitudSelected.getSolicitudGastovida());
                analisis.setAnalisisPagodeudaactual(solicitudSelected.getSolicitudPagodeudaactual());
                analisis.setAnalisisPagovivienda(solicitudSelected.getSolicitudPagovivienda());
                analisis.setAnalisisDescuentoley(solicitudSelected.getSolicitudDescuento());
                analisis.setAnalisisTotalegreso(solicitudSelected.getSolicitudTotalegreso());
                analisis.setAnalisisRentaneta(solicitudSelected.getSolicitudRentaneta());
                //Activos
                analisis.setAnalisisAportaciones(solicitudSelected.getSolicitudAportacionactivo());
                analisis.setAnalisisAhorro(solicitudSelected.getSolicitudAhorroactivo());
                analisis.setAnalisisOtroactivo(solicitudSelected.getSolicitudOtroactivo());
                analisis.setAnalisisValorpropiedad(solicitudSelected.getSolicitudValorpropiedad());
                analisis.setAnalisisValorvehiculo(solicitudSelected.getSolicitudValorvehiculo());
                analisis.setAnalisisTotalactivo(solicitudSelected.getSolicitudTotalactivo());
                //Pasivos.
                analisis.setAnalisisPrestamo(solicitudSelected.getSolicitudPrestamo());
                analisis.setAnalisisDeudacomercial(solicitudSelected.getSolicitudDeudaif());
                analisis.setAnalisisDeudapersonal(solicitudSelected.getSolicitudOtradeuda());
                analisis.setAnalisisTotalpasivo(solicitudSelected.getSolicitudTotalpasivo());
                analisis.setAnalisisCapitalactual(solicitudSelected.getSolicitudCapital());
                analisis.setUsuarioRegistro(getUsuario());
                analisis.setFechaRegistro(new Date());
                analisis.setAnalisisCompleto(false);
                analisis.setAnalisisFechacreacion(new Date());
                analisis.setAnalisisCostasprocesales(BigDecimal.ZERO);
                analisis.setAnalisisInteresdiferido(BigDecimal.ZERO);
                analisis.setAnalisisCapitaldiferido(BigDecimal.ZERO);
                getService().save(analisis);
                for (Deuda d : deudaList) {
                    d.setAnalisisId(analisis);
                    deudaService.merge(d);
                }
                for (Deuda d : deudaPFList) {
                    d.setAnalisisId(analisis);
                    deudaService.merge(d);
                }
                for (Deuda d : deudaTarjetaCredito) {
                    d.setAnalisisId(analisis);
                    deudaService.merge(d);
                }

                cargarListas();

            } catch (Exception ex) {
                Logger.getLogger(SolicitudManagedBean.class.getName()).log(Level.SEVERE, null, ex);
                try {
                    String msg = "";
                    Throwable cause = JsfUtil.getRootCause(ex.getCause());
                    if (cause != null) {
                        msg = cause.getLocalizedMessage();
                    }
                    if (msg.length() > 0) {
                        JsfUtil.addErrorMessage("ERROR CREANDO EL ANALISIS DE CREDITO PARA LA SOLICITUD:" + solicitudSelected.getSolicitudId());
                    } else {
                        JsfUtil.addErrorMessage(ex, "ERROR CREANDO EL ANALISIS DE CREDITO PARA LA SOLICITUD:" + solicitudSelected.getSolicitudId());
                    }
                    bandera = false;
                    contex.getExternalContext().redirect("/siacofinges/views/analisis/index.xhtml");
                } catch (IOException e) {
                    java.util.logging.Logger.getLogger(SolicitudManagedBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (bandera) {
                try {
                    contex.getExternalContext().redirect("/siacofinges/views/analisis/create.xhtml");
                } catch (Exception e) {
                    log.error("Error al redirigir a la pagina de el analisis de credito" + e);
                }
            }
        } else {
            JsfUtil.addErrorMessage("Error al cargar la Solicitud de credito.");
        }

    }

    public void update(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            analisis.setAnalisisCompleto(analisisCompleto);
            analisis.setAnalisisExamenmedico(exameMed);
            analisis.setAnalisisPoseecobertura(poseeCob);
            analisis.setAnalisisDeclaraproblemasalud(problemSalud);
            analisis.setAnalisisTasa(analisis.getAnalisisTasa().divide(BigDecimal.valueOf(100)));
            List<Deuda> totalDeudas = new ArrayList<Deuda>();
            totalDeudas.addAll(deudaList);
            totalDeudas.addAll(deudaPFList);
            totalDeudas.addAll(deudaTarjetaCredito);
            analisis.setDeudaList(new HashSet<Deuda>(totalDeudas));
            analisisService.merge(analisis);
            analisis = null;
            solicitudSelected = null;
            analisisCompleto = false;
            try {
                if (!isEditando()) {
                    setEditando(false);
                    cargarSolicitudesTerminadas();
                    JsfUtil.addSuccessMessage("Operacion realizada con Exito");
                    contex.getExternalContext().redirect("/siacofinges/views/analisis/index.xhtml");
                } else {
                    setEditando(false);
                    contex.getExternalContext().redirect("/siacofinges/views/analisis/analisisEdit.xhtml");
                }

            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(AnalisisCreditoManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (HibernateException e) {
            log.debug("Error al actualizar el analisis de Credito " + e);
            manejaException(e);
        }
    }

    public void toEdit(ActionEvent event) {
        FacesContext contex = FacesContext.getCurrentInstance();
        boolean bandera = true;
        deudaPFList = new ArrayList<Deuda>();
        deudaList = new ArrayList<Deuda>();
        deudaTarjetaCredito = new ArrayList<Deuda>();
        setEditando(true);
        situacionSinFinanciaiemto=BigDecimal.ZERO;
        situacionConFinanciaiemto=BigDecimal.ZERO;
        conclusionSituacion=BigDecimal.ZERO;
        try {
            analisis = analisisService.fillAnalisis(getSelected());
            solicitudSelected = analisis.getSolicitudId();
//            deudaList = new HashSet<Deuda>(analisis.getDeudaList());
            List<Deuda> deudasAnalisis = new ArrayList<Deuda>(analisis.getDeudaList());
            if (deudasAnalisis.size() > 0) {
                for (Deuda d : deudasAnalisis) {
                    if (d.getTdId().getTdId().equals(new Integer("2"))) {
                        deudaPFList.add(d);
                    } else if (d.getTdId().getTdId().equals(new Integer("3"))) {
                        deudaList.add(d);
                    } else if (d.getTdId().getTdId().equals(new Integer("1"))) {
                        deudaTarjetaCredito.add(d);
                    }
                }
            }
            analisis.setUsuarioUltimamodificacion(getUsuario());
            analisis.setFechaUltimamodificacion(new Date());
            consultaBuroCreditoList = new ArrayList<Consultaburocredito>(analisis.getConsultaburocreditoList());
            promocionList = new ArrayList<Promocion>(solicitudSelected.getAsesoriaId().getPromocionList());
            setExameMed(analisis.getAnalisisExamenmedico());
            setProblemSalud(analisis.getAnalisisDeclaraproblemasalud());
            setPoseeCob(analisis.getAnalisisPoseecobertura());
            cargarListas();

        } catch (Exception e) {
            bandera = false;
            String msg = "";
            Throwable cause = JsfUtil.getRootCause(e.getCause());
            if (cause != null) {
                msg = cause.getLocalizedMessage();
            }
            if (msg.length() > 0) {
                JsfUtil.addErrorMessage("Error al editar el analisis de Credito ");
            } else {
                JsfUtil.addErrorMessage(e, "Error al editar el analisis de Credito  ");
            }

            try {
                setEditando(false);
                contex.getExternalContext().redirect("/siacofinges/views/analisis/analisisEdit.xhtml");
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(AnalisisCreditoManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (bandera) {
            try {
                contex.getExternalContext().redirect("/siacofinges/views/analisis/create.xhtml");
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(AnalisisCreditoManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void cancelar(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            getService().delete(analisis);
            analisis = null;
            solicitudSelected = null;
            try {
                cargarSolicitudesTerminadas();
                contex.getExternalContext().redirect("/siacofinges/views/analisis/index.xhtml");
            } catch (IOException ex) {
                log.debug("Error al redirigir a el listado de solicitudes" + ex);
            }

        } catch (HibernateException e) {
            log.debug("Error al el analisis de credito." + e);
            manejaException(e);
        }
    }

    private void manejaException(Exception ex) {
        String msg = "";
        Throwable cause = JsfUtil.getRootCause(ex.getCause());
        if (cause != null) {
            msg = cause.getLocalizedMessage();
        }
        if (msg.length() > 0) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/crudbundle")
                    .getString("PersistenceErrorOccured"));
        } else {
            JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/crudbundle")
                    .getString("PersistenceErrorOccured"));
        }
    }

    public void saveBuroCredito(ActionEvent event) {
        if (getUsuario() != null) {
            try {
                String msj = "Buros de Credito Creado";
                getCbSelected().setAnalisisId(analisis);
                getCbSelected().setUsuarioRegistro(getUsuario());
                getCbSelected().setFechaRegistro(new Date());
                getConsultaBuroCreditoService().save(cbSelected);
                JsfUtil.addSuccessMessage(msj);
            } catch (Exception e) {
                JsfUtil.addErrorMessage("Error al Ingresar un buro de credito.");
            }

        }
        cargarListas();
    }

    public void updateBuroCredito(ActionEvent event) {
        String msg = "Detalle de Linea de credito Actualizada";
        getCbSelected().setFechaUltimamodificacion(new Date());
        getCbSelected().setUsuarioUltimamodificacion(getUsuario());
        try {
            getConsultaBuroCreditoService().merge(cbSelected);
            if (!isValidationFailed()) {
                items = null;
            }
            JsfUtil.addSuccessMessage(msg);
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Error al intentar actualizar el buro de credito" + getCbSelected().getCbcNombre());
        }
        cargarListas();
    }

    public void quitarReferenciaPer(ActionEvent event) {

    }

    public Consultaburocredito agregarBuro(ActionEvent event) {
        Consultaburocredito newItem;
        newItem = new Consultaburocredito();
        this.cbSelected = newItem;
        return newItem;
    }

    public void calcularRentaNetaMensual(ActionEvent event) {
        try {

            BigDecimal sueldo = this.solicitudSelected.getSolicitudSueldo() == null ? new BigDecimal(BigInteger.ZERO) : this.solicitudSelected.getSolicitudSueldo();
            BigDecimal comision = this.solicitudSelected.getSolicitudIngresoComision() == null ? new BigDecimal(BigInteger.ZERO) : this.solicitudSelected.getSolicitudIngresoComision();
            BigDecimal otrosIngresos = this.solicitudSelected.getSolicitudIngresoOtros()== null ? new BigDecimal(BigInteger.ZERO) : this.solicitudSelected.getSolicitudIngresoOtros();
            BigDecimal negocioPropio = this.solicitudSelected.getSolicitudIngresoNegocioPropio() == null ? new BigDecimal(BigInteger.ZERO) : this.solicitudSelected.getSolicitudIngresoNegocioPropio();
            BigDecimal totalIngresos = new BigDecimal(BigInteger.ZERO);
            BigDecimal totalliquido = new BigDecimal(BigInteger.ZERO);

            BigDecimal gastoVida = this.analisis.getAnalisisGastovida() == null ? new BigDecimal(BigInteger.ZERO) : this.analisis.getAnalisisGastovida();
            BigDecimal pagoDeuda = this.analisis.getAnalisisPagodeudaactual() == null ? new BigDecimal(BigInteger.ZERO) : this.analisis.getAnalisisPagodeudaactual();
            BigDecimal pagoVivienda = this.analisis.getAnalisisPagovivienda() == null ? new BigDecimal(BigInteger.ZERO) : this.analisis.getAnalisisPagovivienda();
            BigDecimal otrosDescuentos = this.analisis.getAnalisisDescuentoley() == null ? new BigDecimal(BigInteger.ZERO) : this.analisis.getAnalisisDescuentoley();
            BigDecimal totalEgresos = new BigDecimal(BigInteger.ZERO);

            totalIngresos = totalIngresos.add(sueldo).add(comision).add(otrosIngresos).add(negocioPropio);
            totalEgresos = totalEgresos.add(gastoVida).add(pagoDeuda).add(pagoVivienda).add(otrosDescuentos);
            totalliquido = sueldo.subtract(otrosDescuentos);

            analisis.setAnalisisTotalingreso(totalIngresos);
            analisis.setAnalisisTotalegreso(totalEgresos);
            analisis.setAnalisisRentaneta(totalIngresos.subtract(totalEgresos));
            analisis.setAnalisisTotalliquido(totalliquido);
//            analisisService.merge(this.analisis);
        } catch (Exception e) {
            String msge = "";
            Throwable cause = JsfUtil.getRootCause(e.getCause());
            if (cause != null) {
                msge = cause.getLocalizedMessage();
            }
            if (msge.length() > 0) {
                JsfUtil.addErrorMessage("ERROR CALCULANDO RENTA NETA MENSUAL ");
            } else {
                JsfUtil.addErrorMessage(e, "ERROR ELIMINANDO REFERENCIA PERSONAL ");
            }
        }

    }

    public void calcularCapitalActual(ActionEvent event) {
        try {
            BigDecimal aportaciones = analisis.getAnalisisAportaciones() == null ? new BigDecimal(BigInteger.ZERO) : analisis.getAnalisisAportaciones();
            BigDecimal ahorros = analisis.getAnalisisAhorro() == null ? new BigDecimal(BigInteger.ZERO) : this.analisis.getAnalisisAhorro();
            BigDecimal otrosActivos = analisis.getAnalisisOtroactivo() == null ? new BigDecimal(BigInteger.ZERO) : analisis.getAnalisisOtroactivo();
            BigDecimal propiedades = analisis.getAnalisisValorpropiedad() == null ? new BigDecimal(BigInteger.ZERO) : analisis.getAnalisisValorpropiedad();
            BigDecimal vehiculos = analisis.getAnalisisValorvehiculo() == null ? new BigDecimal(BigInteger.ZERO) : analisis.getAnalisisValorvehiculo();
            BigDecimal totalActivos = new BigDecimal(BigInteger.ZERO);

            BigDecimal prestamos = analisis.getAnalisisPrestamo() == null ? new BigDecimal(BigInteger.ZERO) : analisis.getAnalisisPrestamo();
            BigDecimal deudaOtrasInst = analisis.getAnalisisDeudacomercial() == null ? new BigDecimal(BigInteger.ZERO) : analisis.getAnalisisDeudacomercial();
            BigDecimal deudaOtros = analisis.getAnalisisDeudapersonal() == null ? new BigDecimal(BigInteger.ZERO) : analisis.getAnalisisDeudapersonal();
            BigDecimal totalPasivos = new BigDecimal(BigInteger.ZERO);

            totalActivos = totalActivos.add(aportaciones).add(ahorros).add(otrosActivos).add(propiedades).add(vehiculos);
            totalPasivos = totalPasivos.add(prestamos).add(deudaOtrasInst).add(deudaOtros);

            analisis.setAnalisisTotalactivo(totalActivos);
            analisis.setAnalisisTotalpasivo(totalPasivos);
            analisis.setAnalisisCapitalactual(totalActivos.subtract(totalPasivos));

        } catch (Exception e) {

            String msge = "";
            Throwable cause = JsfUtil.getRootCause(e.getCause());
            if (cause != null) {
                msge = cause.getLocalizedMessage();
            }
            if (msge.length() > 0) {
                JsfUtil.addErrorMessage("ERROR CALCULANDO CAPITAL ACTUAL");
            } else {
                JsfUtil.addErrorMessage(e, "ERROR CALCULANDO CAPITAL ACTUAL ");
            }
        }

    }

    public void calcularSituacion(){
        BigDecimal deudasComerciales=BigDecimal.ZERO;
        BigDecimal deudasTarjeta=BigDecimal.ZERO;
        BigDecimal prestamos=BigDecimal.ZERO;
        
        situacionSinFinanciaiemto=BigDecimal.ZERO;
        situacionConFinanciaiemto=BigDecimal.ZERO;
        for(Deuda d: deudaList){
            deudasComerciales=deudasComerciales.add(d.getDeudaCuota());
        }
        for(Deuda d: deudaTarjetaCredito){
            deudasTarjeta=deudasTarjeta.add(d.getDeudaPagominimo());
        }
        for(Deuda d: deudaPFList){
            prestamos=prestamos.add(d.getDeudaCuota());
        }
//        analisis.setAnalisis
        situacionSinFinanciaiemto=situacionSinFinanciaiemto.add(deudasComerciales.add(deudasTarjeta).add(prestamos));
        situacionConFinanciaiemto=situacionConFinanciaiemto.add(situacionSinFinanciaiemto.add(analisis.getAnalisisCuotacapitalmasintereses()).add(analisis.getAnalisisSegurodano()).add(analisis.getAnalisisSegurodeuda().add(prestamos)));
        conclusionSituacion=conclusionSituacion.add(situacionSinFinanciaiemto.subtract(situacionConFinanciaiemto));
    }
    
    public void calcularCuotaGastos() {
        BigDecimal monto = analisis.getAnalisisMonto() == null ? BigDecimal.ZERO : analisis.getAnalisisMonto();
        BigDecimal interes = analisis.getAnalisisTasa() == null ? BigDecimal.ZERO : analisis.getAnalisisTasa().divide(BigDecimal.valueOf(100));
        Integer plazo = analisis.getAnalisisPlazo();
        BigDecimal cuota;
        BigDecimal seguroDeuda;
        BigDecimal seguroDanio = BigDecimal.ZERO;
        vecesSalario = monto.doubleValue() / solicitudSelected.getSolicitudSueldo().doubleValue();

        if (analisis.getAnalisisPlazo() != null) {
            cuota = FormulasHelper.cuotaCredito(monto, interes, plazo);
            analisis.setAnalisisCuotacapitalmasintereses(cuota);
            seguroDeuda = FormulasHelper.seguroDeuda(monto);
            analisis.setAnalisisSegurodeuda(seguroDeuda);
        }

    }

    //deuda comercial
    public Deuda deudaCPrepareCreate(ActionEvent event) {
        Deuda newItem;
        newItem = new Deuda();
        this.deudaSelected = newItem;
        return newItem;
    }

    //deuda comercial
    public void saveDeudaC(ActionEvent event) {

        try {
            if (getUsuario() != null) {
                String msj = "Registro de la Deuda Creado";

                Integer idTipoDeuda = configuracionSistemaService.findValueInteger("td.comercial");
                Tipodeuda td = tipoDeudaService.findById(idTipoDeuda);

                getDeudaSelected().setTdId(td);
                getDeudaSelected().setAnalisisId(analisis);
                getDeudaSelected().setUsuarioRegistro(getUsuario());
                getDeudaSelected().setFechaRegistro(new Date());
                deudaService.save(deudaSelected);
                JsfUtil.addSuccessMessage(msj);
            }
        } catch (Exception ex) {
            manejaException(ex);
        }

        cargarListas();
    }

    public Deuda deudaTPrepareCreate(ActionEvent event) {
        Deuda newItem;
        newItem = new Deuda();
        this.setDeudaTSelected(newItem);
        return newItem;

    }

    /**
     * Metodo para almacenar una Deuda relacionada con la solicitud de Credito
     * del Asociado
     *
     * @param event Evento del boton accionado en la vista
     */
    public void saveDeudaT(ActionEvent event) {

        try {

            if (getUsuario() != null) {
                String msj = "Registro de la Deuda Creado";

                Integer idTipoDeuda = configuracionSistemaService.findValueInteger("td.tarjetac");
                Tipodeuda td = tipoDeudaService.findById(idTipoDeuda);
                getDeudaTSelected().setTdId(td);
                getDeudaTSelected().setAnalisisId(analisis);
                getDeudaTSelected().setUsuarioRegistro(getUsuario());
                getDeudaTSelected().setFechaRegistro(new Date());
                deudaService.save(getDeudaTSelected());
            }
        } catch (Exception e) {
            manejaException(e);
        }
        cargarListas();
    }

    public Deuda prestamofinPrepareCreate(ActionEvent event) {
        Deuda newItem;
        newItem = new Deuda();
        this.prestamoFinSelected = newItem;
        initializeEmbeddableKey();
        return newItem;

    }

    /**
     * Metodo para almacenar un prestamo relacionado con la solicitud de Credito
     * del Asociado
     *
     * @param event Evento del boton accionado en la vista
     */
    public void savePrestamofin(ActionEvent event) {
        if (getUsuario() != null) {
            String msj = "Prestamo Creado";

            Integer idTipoDeuda = configuracionSistemaService.findValueInteger("td.prestamofin");
            Tipodeuda td = tipoDeudaService.findById(idTipoDeuda);
            getPrestamoFinSelected().setTdId(td);
            getPrestamoFinSelected().setUsuarioRegistro(getUsuario());
            getPrestamoFinSelected().setFechaRegistro(new Date());
            getPrestamoFinSelected().setAnalisisId(analisis);
            deudaService.save(getPrestamoFinSelected());
        }
        cargarListas();
    }

    public void print() {

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//        List<Asesoria> list = new ArrayList<Asesoria>();
//        list.add(asesoriaService.findAsesoriaById(getAsesoriaSelected().getAsesoriaId()));
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        Reporte reporte = new Reporte("asesoria", "InformedeAsesoriadeCredito", request);
//        reporte.addParameter("asesoria_id", getAsesoriaSelected().getAsesoriaId());
//        reporte.setDataSource(new JRBeanCollectionDataSource(new HashSet<Asesoria>(list)));
        reporte.setReportInSession(request, response);
        setReportName(reporte.getNombreLogico());
        RequestContext.getCurrentInstance().
                addCallbackParam("reportName", getReportName());
    }

    public AnalisisService getAnalisisService() {
        return analisisService;
    }

    public void setAnalisisService(AnalisisService analisisService) {
        this.analisisService = analisisService;
    }

    public Analisis getAnalisis() {
        return analisis;
    }

    public void setAnalisis(Analisis analisis) {
        this.analisis = analisis;
    }

    public Consultaburocredito getCbSelected() {
        return cbSelected;
    }

    public void setCbSelected(Consultaburocredito cbSelected) {
        this.cbSelected = cbSelected;
    }

    public ConsultaBuroCreditoService getConsultaBuroCreditoService() {
        return consultaBuroCreditoService;
    }

    public void setConsultaBuroCreditoService(ConsultaBuroCreditoService consultaBuroCreditoService) {
        this.consultaBuroCreditoService = consultaBuroCreditoService;
    }

    public LazyDataModel<Consultaburocredito> getCbLazyItems() {
        return new ConsultaBuroCreditoLazyModel(consultaBuroCreditoService);
    }

    public void setCbLazyItems(LazyDataModel<Consultaburocredito> cbLazyItems) {
        this.cbLazyItems = cbLazyItems;
    }

    public List<Analisis> getAnalisisItems() {
        return analisisItems;
    }

    public void setAnalisisItems(List<Analisis> analisisItems) {
        this.analisisItems = analisisItems;
    }

    public SolicitudService getSolicitudService() {
        return solicitudService;
    }

    public void setSolicitudService(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    public List<Solicitud> getSolicitudItems() {
        return solicitudItems;
    }

    public void setSolicitudItems(List<Solicitud> solicitudItems) {
        this.solicitudItems = solicitudItems;
    }

    public Solicitud getSolicitudSelected() {
        return solicitudSelected;
    }

    public void setSolicitudSelected(Solicitud solicitudSelected) {
        this.solicitudSelected = solicitudSelected;
    }

    public SelectItem[] getExamenMedicoOptions() {
        return examenMedicoOptions;
    }

    public void setExamenMedicoOptions(SelectItem[] examenMedicoOptions) {
        this.examenMedicoOptions = examenMedicoOptions;
    }

    public SelectItem[] getPoseeCoberturaOptions() {
        return poseeCoberturaOptions;
    }

    public void setPoseeCoberturaOptions(SelectItem[] poseeCoberturaOptions) {
        this.poseeCoberturaOptions = poseeCoberturaOptions;
    }

    public SelectItem[] getProblemaSaludOptions() {
        return problemaSaludOptions;
    }

    public void setProblemaSaludOptions(SelectItem[] problemaSaludOptions) {
        this.problemaSaludOptions = problemaSaludOptions;
    }

    public boolean isAnalisisCompleto() {
        return analisisCompleto;
    }

    public void setAnalisisCompleto(boolean analisisCompleto) {
        this.analisisCompleto = analisisCompleto;
    }

    public Asociados getAsociado() {
        return asociado;
    }

    public void setAsociado(Asociados asociado) {
        this.asociado = asociado;
    }

    public List<Garantiaexigida> getGarantiasExigidasList() {
        return garantiasExigidasList;
    }

    public void setGarantiasExigidasList(List<Garantiaexigida> garantiasExigidasList) {
        this.garantiasExigidasList = garantiasExigidasList;
    }

    public List<Garantia> getGarantiasList() {
        return garantiasList;
    }

    public void setGarantiasList(List<Garantia> garantiasList) {
        this.garantiasList = garantiasList;
    }

    public String getCodigoAsociado() {
        return codigoAsociado;
    }

    public void setCodigoAsociado(String codigoAsociado) {
        this.codigoAsociado = codigoAsociado;
    }

    public String getNombreAsociado() {
        return nombreAsociado;
    }

    public void setNombreAsociado(String nombreAsociado) {
        this.nombreAsociado = nombreAsociado;
    }

    /**
     * @return the reportName
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * @param reportName the reportName to set
     */
    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public List<Consultaburocredito> getConsultaBuroCreditoList() {
        return consultaBuroCreditoList;
    }

    public void setConsultaBuroCreditoList(List<Consultaburocredito> consultaBuroCreditoList) {
        this.consultaBuroCreditoList = consultaBuroCreditoList;
    }

    public List<Tiposolicitud> getTipoSolicitudList() {
        return tipoSolicitudList;
    }

    public void setTipoSolicitudList(List<Tiposolicitud> tipoSolicitudList) {
        this.tipoSolicitudList = tipoSolicitudList;
    }

    public AsesoriaService getAsesoriaService() {
        return asesoriaService;
    }

    public void setAsesoriaService(AsesoriaService asesoriaService) {
        this.asesoriaService = asesoriaService;
    }

    public TipoSolicitudService getTipoSolicitudService() {
        return tipoSolicitudService;
    }

    public void setTipoSolicitudService(TipoSolicitudService tipoSolicitudService) {
        this.tipoSolicitudService = tipoSolicitudService;
    }

    public FormaPagoService getFormaPagoService() {
        return formaPagoService;
    }

    public void setFormaPagoService(FormaPagoService formaPagoService) {
        this.formaPagoService = formaPagoService;
    }

    public List<Formapago> getFormaPagoList() {
        return formaPagoList;
    }

    public void setFormaPagoList(List<Formapago> formaPagoList) {
        this.formaPagoList = formaPagoList;
    }

    public PeriodicidadPagoService getPeriodicidadPagoService() {
        return periodicidadPagoService;
    }

    public void setPeriodicidadPagoService(PeriodicidadPagoService periodicidadPagoService) {
        this.periodicidadPagoService = periodicidadPagoService;
    }

    public List<Periodicidadpago> getPeriodicidadPagoList() {
        return periodicidadPagoList;
    }

    public void setPeriodicidadPagoList(List<Periodicidadpago> periodicidadPagoList) {
        this.periodicidadPagoList = periodicidadPagoList;
    }

    public List<Tipodeuda> getTipoDeudaList() {
        return tipoDeudaList;
    }

    public void setTipoDeudaList(List<Tipodeuda> tipoDeudaList) {
        this.tipoDeudaList = tipoDeudaList;
    }

    public TipoDeudaService getTipoDeudaService() {
        return tipoDeudaService;
    }

    public void setTipoDeudaService(TipoDeudaService tipoDeudaService) {
        this.tipoDeudaService = tipoDeudaService;
    }

    public Deuda getDeudaSelected() {
        return deudaSelected;
    }

    public void setDeudaSelected(Deuda deudaSelected) {
        this.deudaSelected = deudaSelected;
    }

    public List<Deuda> getDeudaList() {
        return deudaList;
    }

    public void setDeudaList(List<Deuda> deudaList) {
        this.deudaList = deudaList;
    }

    public boolean isExameMed() {
        return exameMed;
    }

    public void setExameMed(boolean exameMed) {
        this.exameMed = exameMed;
    }

    public boolean isPoseeCob() {
        return poseeCob;
    }

    public void setPoseeCob(boolean poseeCob) {
        this.poseeCob = poseeCob;
    }

    public boolean isProblemSalud() {
        return problemSalud;
    }

    public void setProblemSalud(boolean problemSalud) {
        this.problemSalud = problemSalud;
    }

    public List<Promocion> getPromocionList() {
        return promocionList;
    }

    public void setPromocionList(List<Promocion> promocionList) {
        this.promocionList = promocionList;
    }

    public List<Promocion> getPromociones() {
        return promociones;
    }

    public void setPromociones(List<Promocion> promociones) {
        this.promociones = promociones;
    }

    public List<Deuda> getDeudaPFList() {
        return deudaPFList;
    }

    public void setDeudaPFList(List<Deuda> deudaPFList) {
        this.deudaPFList = deudaPFList;
    }

    public double getVecesSalario() {
        return vecesSalario;
    }

    public void setVecesSalario(double vecesSalario) {
        this.vecesSalario = vecesSalario;
    }

    public List<Deuda> getDeudaTarjetaCredito() {
        return deudaTarjetaCredito;
    }

    public void setDeudaTarjetaCredito(List<Deuda> deudaTarjetaCredito) {
        this.deudaTarjetaCredito = deudaTarjetaCredito;
    }

    public Deuda getDeudaTSelected() {
        return deudaTSelected;
    }

    public void setDeudaTSelected(Deuda deudaTSelected) {
        this.deudaTSelected = deudaTSelected;
    }

    public Deuda getPrestamoFinSelected() {
        return prestamoFinSelected;
    }

    public void setPrestamoFinSelected(Deuda prestamoFinSelected) {
        this.prestamoFinSelected = prestamoFinSelected;
    }

    public SelectItem[] getDeudaCActivoOptions() {
        return deudaCActivoOptions;
    }

    public void setDeudaCActivoOptions(SelectItem[] deudaCActivoOptions) {
        this.deudaCActivoOptions = deudaCActivoOptions;
    }

    public SelectItem[] getDeudaTActivoOptions() {
        return deudaTActivoOptions;
    }

    public void setDeudaTActivoOptions(SelectItem[] deudaTActivoOptions) {
        this.deudaTActivoOptions = deudaTActivoOptions;
    }

    public SelectItem[] getPrestamofinActivoOptions() {
        return prestamofinActivoOptions;
    }

    public void setPrestamofinActivoOptions(SelectItem[] prestamofinActivoOptions) {
        this.prestamofinActivoOptions = prestamofinActivoOptions;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

    public List<Deuda> getDeudasComercialesSeleccionadasList() {
        return deudasComercialesSeleccionadasList;
    }

    public void setDeudasComercialesSeleccionadasList(List<Deuda> deudasComercialesSeleccionadasList) {
        this.deudasComercialesSeleccionadasList = deudasComercialesSeleccionadasList;
    }

    public BigDecimal getSituacionSinFinanciaiemto() {
        return situacionSinFinanciaiemto;
    }

    public void setSituacionSinFinanciaiemto(BigDecimal situacionSinFinanciaiemto) {
        this.situacionSinFinanciaiemto = situacionSinFinanciaiemto;
    }

    public BigDecimal getSituacionConFinanciaiemto() {
        return situacionConFinanciaiemto;
    }

    public void setSituacionConFinanciaiemto(BigDecimal situacionConFinanciaiemto) {
        this.situacionConFinanciaiemto = situacionConFinanciaiemto;
    }

    public BigDecimal getConclusionSituacion() {
        return conclusionSituacion;
    }

    public void setConclusionSituacion(BigDecimal conclusionSituacion) {
        this.conclusionSituacion = conclusionSituacion;
    }

}
