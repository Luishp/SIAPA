package com.siapa.managedbean;

import com.siapa.jasper.Reporte;
import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.AsesoriaLazyModel;
import com.siapa.managedbean.lazymodel.PrestamoLazyModel;
import com.siapa.managedbean.lazymodel.PropiedadLazyModel;
import com.siapa.managedbean.lazymodel.SolicitudLazyModel;
import com.siapa.model.Asesoria;
import com.siapa.model.Asociados;
import com.siapa.model.Deuda;
import com.siapa.model.Formapago;
import com.siapa.model.Fuenteingreso;
import com.siapa.model.Ingreso;
import com.siapa.model.IngresoPK;
import com.siapa.model.Periodicidadpago;
import com.siapa.model.Prestamo;
import com.siapa.model.Promocion;
import com.siapa.model.Propiedad;
import com.siapa.model.Referenciafamiliar;
import com.siapa.model.Referenciapersonal;
import com.siapa.model.Requisitosolicitadoempleado;
import com.siapa.model.Solicitud;
import com.siapa.model.Tipodeuda;
import com.siapa.model.Tipoempresa;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.pojos.rpt.asesoria.ReporteAsesoriaCreditopojo;
import com.siapa.pojos.rpt.solicitud.ReporteSolicitudCredito;
import com.siapa.service.AsesoriaService;
import com.siapa.service.AsociadoService;
import com.siapa.service.ConfiguracionSistemaService;
import com.siapa.service.DeudaService;
import com.siapa.service.FormaPagoService;
import com.siapa.service.FuentesIngresoService;
import com.siapa.service.IngresoService;
import com.siapa.service.PeriodicidadPagoService;
import com.siapa.service.PrestamoFinancieroService;
import com.siapa.service.PrestamoService;
import com.siapa.service.PromocionService;
import com.siapa.service.PropiedadService;
import com.siapa.service.ReferenciaFamiliarService;
import com.siapa.service.ReferenciaPersonalService;
import com.siapa.service.RequisitoSolicitadoEmpleadoService;
import com.siapa.service.SolicitudService;
import com.siapa.service.TipoDeudaService;
import com.siapa.service.TipoEmpresaService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.HibernateException;
import org.primefaces.context.RequestContext;
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
@Named("solicitudManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class SolicitudManagedBean extends GenericManagedBean<Solicitud, Integer> {

    private static final Logger log = LoggerFactory.getLogger(SolicitudManagedBean.class);
    @Autowired
    @Qualifier(value = "solicitudService")
    private SolicitudService solicitudService;
    @Autowired
    @Qualifier(value = "asociadoService")
    private AsociadoService asociadoService;
    @Autowired
    @Qualifier(value = "propiedadService")
    private PropiedadService propiedadService;
    @Autowired
    @Qualifier(value = "prestamoService")
    private PrestamoService prestamoService;
    @Autowired
    @Qualifier(value = "prestamoFinancieroService")
    private PrestamoFinancieroService prestamoFinancieroService;
    @Autowired
    @Qualifier(value = "asesoriaService")
    private AsesoriaService asesoriaService;
    @Autowired
    @Qualifier(value = "referenciaFamiliarService")
    private ReferenciaFamiliarService referenciaFamiliarService;
    @Autowired
    @Qualifier(value = "referenciaPersonalService")
    private ReferenciaPersonalService referenciaPersonalService;
    @Autowired
    @Qualifier(value = "tipoEmpresaService")
    private TipoEmpresaService tipoEmpresaService;
    @Autowired
    @Qualifier(value = "formaPagoService")
    private FormaPagoService formaPagoService;
    @Autowired
    @Qualifier(value = "periodicidadPagoService")
    private PeriodicidadPagoService periodicidadPagoService;
    @Autowired
    @Qualifier(value = "promocionService")
    private PromocionService promocionService;
    @Autowired
    @Qualifier(value = "deudaService")
    private DeudaService deudaService;
    @Autowired
    @Qualifier(value = "tipoDeudaService")
    private TipoDeudaService tipoDeudaService;
    @Autowired
    @Qualifier(value = "configuracionSistemaService")
    private ConfiguracionSistemaService configuracionSistemaService;
    @Autowired
    @Qualifier(value = "requisitoSolicitadoEmpleadoService")
    private RequisitoSolicitadoEmpleadoService requisitoSolicitadoEmpleadoService;
    @Autowired
    @Qualifier(value = "fuentesIngresoService")
    private FuentesIngresoService fuentesIngresoService;
    @Autowired
    @Qualifier(value = "ingresoService")
    private IngresoService ingresoService;

    Solicitud solicitud;
    Asociados asociado;
    private Ingreso nuevoIngreso;
    private boolean solictudCompleta;

    private Asesoria asesoriaSelected;
    private List<Asesoria> asesoriaItems;
    private LazyDataModel<Asesoria> asesorialazyItems;
    private SelectItem[] asesoriaActivoOptionsFilter;
    private SelectItem[] asesoriaActivoOptions;

    private Propiedad propiedadSelected;
    private List<Propiedad> propiedadItems;
    private SelectItem[] propiedadActivoOptionsFilter;
    private SelectItem[] propiedadActivoOptions;

    private Prestamo prestamoSelected;
    private List<Prestamo> prestamoItems;
    private LazyDataModel<Prestamo> prestamoLazyItems;
    private SelectItem[] prestamoActivoOptionsFilter;
    private SelectItem[] prestamoActivoOptions;

    private Deuda prestamofinSelected;
    private List<Deuda> prestamofinItems;
    private LazyDataModel<Deuda> prestamofinLazyItems;
    private SelectItem[] prestamofinActivoOptionsFilter;
    private SelectItem[] prestamofinActivoOptions;

    private Referenciafamiliar refFamSelected;
    private List<Referenciafamiliar> refFamItems;
    private SelectItem[] refFamActivoOptionsFilter;
    private SelectItem[] refFamActivoOptions;

    private Referenciapersonal refPerSelected;
    private List<Referenciapersonal> refPerItems;
    private SelectItem[] refPerActivoOptionsFilter;
    private SelectItem[] refPerActivoOptions;

    private Deuda deudaCSelected;
    private List<Deuda> deudaCItems;
    private SelectItem[] deudaCActivoOptions;

    private Deuda deudaTSelected;
    private List<Deuda> deudaTItems;
    private SelectItem[] deudaTActivoOptions;

    private String reportName;
    private String reportName1;

    /*COMBOS*/
    private List<Tipoempresa> tipoEmpresaList;
    private Tipoempresa tipoEmpresaSeleccionado;
    private List<Formapago> formaPagoList;
    private Formapago formaPagoSeleccionada;
    private List<Periodicidadpago> periodicidadPagoList;
    private Periodicidadpago periodicidadPagoSeleccionada;
    private List<Promocion> promociones;
    private List<Promocion> promocionesSelecionadas;
    private Promocion promocion;
    private List<Fuenteingreso> fuentesIngresoList;
    private Fuenteingreso fuentesIngresoSelected;
    private List<Ingreso> ingresos;
    private Ingreso ingresoSelected;
    // selectManyCheckbox
    private Requisitosolicitadoempleado[] requisitosSeleccionados;
    private List<Requisitosolicitadoempleado> requisitosItems;
    private LazyDataModel<Requisitosolicitadoempleado> requisitoslazyItems;
    private boolean editando;
    /**
     * Metodo init de la clase SolicitudManagedBean
     */
    @PostConstruct
    public void init() {
        loadLazyModels();
        cargarAsesorias();

    }

    /**
     * Constructor de la clase SolicitudManagedBean
     */
    public SolicitudManagedBean() {
        propiedadActivoOptionsFilter = propiedadCreateFilterOptions();
        propiedadActivoOptions = propiedadCreateActivoOptions();
        prestamoActivoOptionsFilter = prestamoCreateFilterOptions();
        prestamoActivoOptions = prestamoCreateActivoOptions();
        prestamofinActivoOptionsFilter = prestamofinCreateFilterOptions();
        prestamofinActivoOptions = prestamofinCreateActivoOptions();
        deudaCActivoOptions = deudaCCreateActivoOptions();
        deudaTActivoOptions = deudaTCreateActivoOptions();

    }

    /**
     * Metodo para Inicializar la lista de asesorias que aun no tienen una
     * solicitud de Credito Asociada
     */
    private void cargarAsesorias() {
        try {
            asesoriaItems = asesoriaService.findAsesoriaWithoutSolicitud();
        } catch (Exception e) {
            log.debug("Error al cargar las asesorias sin una solicitud asociada" + e);
        }
    }

    private SelectItem[] propiedadCreateFilterOptions() {

        SelectItem[] options = new SelectItem[3];
        options[0] = new SelectItem("", "Select");
        options[1] = new SelectItem("SI", "Si");
        options[2] = new SelectItem("NO", "No");

        return options;
    }

    private SelectItem[] propiedadCreateActivoOptions() {

        SelectItem[] options = new SelectItem[2];
        options[0] = new SelectItem("SI", "Si");
        options[1] = new SelectItem("NO", "No");

        return options;
    }

    private SelectItem[] prestamoCreateFilterOptions() {

        SelectItem[] options = new SelectItem[3];
        options[0] = new SelectItem("", "Select");
        options[1] = new SelectItem("SI", "Si");
        options[2] = new SelectItem("NO", "No");

        return options;
    }

    private SelectItem[] prestamoCreateActivoOptions() {

        SelectItem[] options = new SelectItem[2];
        options[0] = new SelectItem("SI", "Si");
        options[1] = new SelectItem("NO", "No");

        return options;
    }

    private SelectItem[] prestamofinCreateFilterOptions() {

        SelectItem[] options = new SelectItem[3];
        options[0] = new SelectItem("", "Select");
        options[1] = new SelectItem("SI", "Si");
        options[2] = new SelectItem("NO", "No");

        return options;
    }

    private SelectItem[] prestamofinCreateActivoOptions() {

        SelectItem[] options = new SelectItem[2];
        options[0] = new SelectItem("SI", "Si");
        options[1] = new SelectItem("NO", "No");

        return options;
    }

    /*METODOS PARA ALMACENAR ,ACTUALIZAR PROPIEDADES;*/
    /**
     * Metodo que prepara la creacion de un objeto del tipo Propiedad
     *
     * @param event
     * @return objeto del tipo Propiedad Inicializado
     */
    public Propiedad propiedadPrepareCreate(ActionEvent event) {
        Propiedad newItem;
        newItem = new Propiedad();
        this.propiedadSelected = newItem;
        initializeEmbeddableKey();
        return newItem;

    }

    ////////////////////////////////////////
        /*METODOS PARA ALMACENAR ,ACTUALIZAR DEUDAS;*/
    /**
     * Metodo que prepara la creacion de un objeto del tipo Deuda Comercial
     *
     * @param event
     * @return objeto del tipo Propiedad Inicializado
     */
    public Deuda deudaCPrepareCreate(ActionEvent event) {
        Deuda newItem;
        newItem = new Deuda();
        this.deudaCSelected = newItem;
        return newItem;
    }

    /**
     * Metodo para almacenar una Deuda relacionada con la solicitud de Credito
     * del Asociado
     *
     * @param event Evento del boton accionado en la vista
     */
    public void saveDeudaC(ActionEvent event) {

        try {
            if (getUsuario() != null) {
                String msj = "Registro de la Deuda Creado";

                Integer idTipoDeuda = configuracionSistemaService.findValueInteger("td.comercial");
                Tipodeuda td = tipoDeudaService.findById(idTipoDeuda);

                getDeudaCSelected().setTdId(td);
                getDeudaCSelected().setSolicitudId(solicitud);
                getDeudaCSelected().setUsuarioRegistro(getUsuario());
                getDeudaCSelected().setFechaRegistro(new Date());
                deudaService.save(deudaCSelected);
                JsfUtil.addSuccessMessage(msj);
            }
        } catch (Exception ex) {
            manejaException(ex);
        }

        cargarListas();
    }

    public void dialogFuenteIngreso(ActionEvent event) {
        nuevoIngreso = new Ingreso();
        fuentesIngresoSelected = new Fuenteingreso();
        fuentesIngresoList = fuentesIngresoService.findAll();

    }

    public void guardarFuenteIngreso(ActionEvent event) {
        boolean repetido = false;
        
        
        for (Ingreso ingr : ingresos) {
            if (ingr.getFuenteingreso().getFiId() == fuentesIngresoSelected.getFiId()) {
                repetido = true;
            }
        }

        if (repetido) {
            for (Ingreso ingr : ingresos) {
                if (ingr.getFuenteingreso().getFiId() == fuentesIngresoSelected.getFiId()) {
                    BigDecimal cant;
                    cant = ingr.getIngresoCantidad();
                    cant = cant.add(nuevoIngreso.getIngresoCantidad());
                    ingr.setIngresoCantidad(cant);
                    ingresoService.merge(ingr);
                }
            }
        } else {
            IngresoPK ingPK = new IngresoPK();
            ingPK.setFiId(fuentesIngresoSelected.getFiId());
            ingPK.setSolicitudId(solicitud.getSolicitudId());
            nuevoIngreso.setIngresoPK(ingPK);
            nuevoIngreso.setFuenteingreso(fuentesIngresoSelected);
            nuevoIngreso.setSolicitud(solicitud);
            ingresoService.save(nuevoIngreso);
        }

        ingresos = ingresoService.findIngresosBySolicitud(solicitud.getSolicitudId());
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

    private SelectItem[] deudaCCreateActivoOptions() {

        SelectItem[] options = new SelectItem[2];
        options[0] = new SelectItem("SI", "Si");
        options[1] = new SelectItem("NO", "No");

        return options;
    }

    /*METODOS PARA ALMACENAR ,ACTUALIZAR DEUDAS;*/
    /**
     * Metodo que prepara la creacion de un objeto del tipo Propiedad
     *
     * @param event
     * @return objeto del tipo Propiedad Inicializado
     */
    public Deuda deudaTPrepareCreate(ActionEvent event) {
        Deuda newItem;
        newItem = new Deuda();
        this.deudaTSelected = newItem;
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
                getDeudaTSelected().setSolicitudId(solicitud);
                getDeudaTSelected().setUsuarioRegistro(getUsuario());
                getDeudaTSelected().setFechaRegistro(new Date());
                deudaService.save(deudaTSelected);
            }
        } catch (Exception e) {
            manejaException(e);
        }
        cargarListas();
    }

    private SelectItem[] deudaTCreateActivoOptions() {

        SelectItem[] options = new SelectItem[2];
        options[0] = new SelectItem("SI", "Si");
        options[1] = new SelectItem("NO", "No");

        return options;
    }

    /**
     * Metodo para almacenar una propiedad relacionada con la solicitud de
     * Credito del Asociado
     *
     * @param event Evento del boton accionado en la vista
     */
    public void savePropiedad(ActionEvent event) {

        if (getUsuario() != null) {
            String msj = "propiedad Creada";
            getPropiedadSelected().setSolicitudId(this.solicitud);
            getPropiedadSelected().setUsuarioRegistro(getUsuario());
            getPropiedadSelected().setFechaRegistro(new Date());
            propiedadService.save(propiedadSelected);
        }
        cargarListas();
    }

    /**
     * Metodo para actualizar una propiedad relacionado con la solicitud de
     * credito del asociado
     *
     * @param event Evento del boton accionado en la vista
     */
    public void updatePropiedad(ActionEvent event) {
        String msg = "Propiedad Actualizada";
        getPropiedadSelected().setUsuarioUltimamodificacion(getUsuario());
        getPropiedadSelected().setFechaUltimamodificacion(new Date());
        propiedadService.merge(propiedadSelected);
        if (!isValidationFailed()) {
            items = null;
        }
    }

    /*METODOS PARA ALMACENAR ,ACTUALIZAR PRESTAMOS;*/
    /**
     * Metodo que prepara la creacion de un objeto del tipo Prestamo
     *
     * @param event
     * @return objeto del tipo Prestamo Inicializado
     */
    public Prestamo prestamoPrepareCreate(ActionEvent event) {
        Prestamo newItem;
        newItem = new Prestamo();
        this.prestamoSelected = newItem;
        initializeEmbeddableKey();
        return newItem;

    }

    /**
     * Metodo para almacenar un prestamo relacionado con la solicitud de Credito
     * del Asociado
     *
     * @param event Evento del boton accionado en la vista
     */
    public void savePrestamo(ActionEvent event) {
        if (getUsuario() != null) {
            String msj = "Prestamo Creado";
            getPrestamoSelected().setUsuarioRegistro(getUsuario());
            getPrestamoSelected().setFechaRegistro(new Date());
            prestamoService.save(prestamoSelected);
        }
        cargarListas();
    }

    /**
     * Metodo para actualizar un Prestamo del Asociado
     *
     * @param event Evento del boton accionado en la vista
     */
    public void updatePrestamo(ActionEvent event) {
        String msg = "Prestamo Actualizado";
        getPrestamoSelected().setUsuarioUltimamodificacion(getUsuario());
        getPrestamoSelected().setFechaUltimamodificacion(new Date());
        prestamoService.merge(prestamoSelected);
        if (!isValidationFailed()) {
            items = null;
        }
    }

    /*METODOS PARA ALMACENAR ,ACTUALIZAR PRESTAMOS;*/
    /**
     * Metodo que prepara la creacion de un objeto del tipo Prestamo
     *
     * @param event
     * @return objeto del tipo Prestamo Inicializado
     */
    public Deuda prestamofinPrepareCreate(ActionEvent event) {
        Deuda newItem;
        newItem = new Deuda();
        this.prestamofinSelected = newItem;
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
            BigDecimal interes=getPrestamofinSelected().getDeudaTasa()==null?BigDecimal.ZERO:getPrestamofinSelected().getDeudaTasa().divide(new BigDecimal(100));
            getPrestamofinSelected().setDeudaTasa(interes);
            Integer idTipoDeuda = configuracionSistemaService.findValueInteger("td.prestamofin");
            Tipodeuda td = tipoDeudaService.findById(idTipoDeuda);
            getPrestamofinSelected().setTdId(td);
            getPrestamofinSelected().setUsuarioRegistro(getUsuario());
            getPrestamofinSelected().setFechaRegistro(new Date());
            getPrestamofinSelected().setSolicitudId(solicitud);
            deudaService.save(prestamofinSelected);
        }
        cargarListas();
    }

    /**
     * Metodo para actualizar un Prestamo del Asociado
     *
     * @param event Evento del boton accionado en la vista
     */
    public void updatePrestamofin(ActionEvent event) {
        String msg = "Prestamo Financiero Actualizado";
        getPrestamofinSelected().setUsuarioUltimamodificacion(getUsuario());
        getPrestamofinSelected().setFechaUltimamodificacion(new Date());
        deudaService.merge(prestamofinSelected);
        if (!isValidationFailed()) {
            items = null;
        }
    }

    /*METODOS PARA ALMACENAR ,ACTUALIZAR REFERENCIAS FAMILIARES;*/
    /**
     * Metodo que prepara la creacion de un objeto del tipo Referenciafamiliar
     *
     * @param event Evento del boton accionado en la vista
     * @return objeto del tipo Referenciafamiliar Inicializado
     */
    public Referenciafamiliar referenciaFamPrepareCreate(ActionEvent event) {
        Referenciafamiliar newItem;
        newItem = new Referenciafamiliar();
        this.refFamSelected = newItem;
        initializeEmbeddableKey();
        return newItem;

    }

    /**
     * Metodo para almacenar una Referencia Familiar
     *
     * @param event Evento del boton accionado en la vista
     */
    public void saveReferenciaFam(ActionEvent event) {

        if (getUsuario() != null) {
            String msj = "Referencia Familiar Creada";
            getRefFamSelected().setSolicitudId(this.solicitud);
            getRefFamSelected().setUsuarioRegistro(getUsuario());
            getRefFamSelected().setFechaRegistro(new Date());
            referenciaFamiliarService.save(refFamSelected);
        }
        cargarListas();
    }

    /**
     * Metodo para actualizar una Refrencia Familiar
     *
     * @param event evento del boton accionado en la vista
     */
    public void updaterReferenciaFam(ActionEvent event) {
        String msg = "Referencia Familiar Actualizada";
        getRefFamSelected().setUsuarioUltimamodificacion(getUsuario());
        getRefFamSelected().setFechaUltimamodificacion(new Date());
        referenciaFamiliarService.merge(refFamSelected);
        if (!isValidationFailed()) {
            items = null;
        }
    }

    /**
     * Metodo para quitar una Refrencia Familiar asociada a una solicitud de
     * Credito
     *
     * @param event Evento del boton accionado en la vista
     */
    public void quitarReferenciaFam(ActionEvent event) {
        try {
            referenciaFamiliarService.delete(refFamSelected);
            cargarListas();
        } catch (Exception e) {
            cargarListas();
            String msge = "";
            Throwable cause = JsfUtil.getRootCause(e.getCause());
            if (cause != null) {
                msge = cause.getLocalizedMessage();
            }
            if (msge.length() > 0) {
                JsfUtil.addErrorMessage("ERROR ELIMINANDO REFERENCIA FAMILIAR " + refFamSelected.getRfId());
            } else {
                JsfUtil.addErrorMessage(e, "ERROR ELIMINANDO REFERENCIA FAMILIAR " + refFamSelected.getRfId());
            }
        }

    }

    /*METODOS PARA ALMACENAR ,ACTUALIZAR REFERENCIAS FAMILIARES;*/
    /**
     * Metodo que prepara la creacion de un objeto del tipo Referenciapersonal
     *
     * @param event Evento del botono accionado en la vista
     * @return objeto del tipo Referenciapersonal Inicializado
     */
    public Referenciapersonal referenciaPerPrepareCreate(ActionEvent event) {
        Referenciapersonal newItem;
        newItem = new Referenciapersonal();
        this.refPerSelected = newItem;
        initializeEmbeddableKey();
        return newItem;

    }

    /**
     * Metodo para almacenar una Referencia Personal relacionada a una solicitud
     * de Credito
     *
     * @param event Evento del boton accionado en la vista
     */
    public void saveReferenciaPer(ActionEvent event) {

        if (getUsuario() != null) {
            String msj = "Referencia Personal Creada";
            getRefPerSelected().setSolicitudId(solicitud);
            getRefPerSelected().setUsuarioRegistro(getUsuario());
            getRefPerSelected().setFechaRegistro(new Date());
            referenciaPersonalService.save(refPerSelected);
        }
        cargarListas();
    }

    /**
     * Metodo para actualizar una Refrencia Personal relacionada a la solicitud
     * de credito
     *
     * @param event evento del boton accionado en la vista
     */
    public void updaterReferenciaPer(ActionEvent event) {
        String msg = "Referencia Personal Actualizada";
        getRefPerSelected().setUsuarioUltimamodificacion(getUsuario());
        getRefPerSelected().setFechaUltimamodificacion(new Date());
        referenciaPersonalService.merge(refPerSelected);
        if (!isValidationFailed()) {
            items = null;
        }
    }

    /**
     * Metodo para quitar una Refrencia Personal asociada a una solicitud de
     * Credito
     *
     * @param event Evento del boton accionado en la vista
     */
    public void quitarReferenciaPer(ActionEvent event) {
        try {
            referenciaPersonalService.delete(refPerSelected);
            cargarListas();
        } catch (Exception e) {
            cargarListas();
            String msge = "";
            Throwable cause = JsfUtil.getRootCause(e.getCause());
            if (cause != null) {
                msge = cause.getLocalizedMessage();
            }
            if (msge.length() > 0) {
                JsfUtil.addErrorMessage("ERROR ELIMINANDO REFERENCIA PERSONAL " + refPerSelected.getRpId());
            } else {
                JsfUtil.addErrorMessage(e, "ERROR ELIMINANDO REFERENCIA PERSONAL " + refPerSelected.getRpId());
            }
        }

    }

    /**
     * Metodo para calcular la renta neta mensual del asociado relacionado a la
     * Solicitud de Credito
     *
     * @param event Evento del boton accionado en la vista
     */
    public void calcularRentaNetaMensual(ActionEvent event) {
        try {

            BigDecimal sueldo = this.solicitud.getSolicitudSueldo();
            BigDecimal comision = this.solicitud.getSolicitudIngresoComision() == null ? new BigDecimal(BigInteger.ZERO) : this.solicitud.getSolicitudIngresoComision();
            BigDecimal otrosIngresos = this.solicitud.getSolicitudIngresoOtros() == null ? new BigDecimal(BigInteger.ZERO) : this.solicitud.getSolicitudIngresoOtros();
            BigDecimal negocioPropio = this.solicitud.getSolicitudIngresoNegocioPropio()== null ? new BigDecimal(BigInteger.ZERO) : this.solicitud.getSolicitudIngresoNegocioPropio();
            BigDecimal totalIngresos = new BigDecimal(BigInteger.ZERO);

            BigDecimal gastoVida = this.solicitud.getSolicitudGastovida() == null ? new BigDecimal(BigInteger.ZERO) : this.solicitud.getSolicitudGastovida();
            BigDecimal pagoDeuda = this.solicitud.getSolicitudPagodeudaactual() == null ? new BigDecimal(BigInteger.ZERO) : this.solicitud.getSolicitudPagodeudaactual();
            BigDecimal pagoVivienda = this.solicitud.getSolicitudPagovivienda() == null ? new BigDecimal(BigInteger.ZERO) : this.solicitud.getSolicitudPagovivienda();
            BigDecimal otrosDescuentos = this.solicitud.getSolicitudDescuento() == null ? new BigDecimal(BigInteger.ZERO) : this.solicitud.getSolicitudDescuento();
            BigDecimal totalEgresos = new BigDecimal(BigInteger.ZERO);

            totalIngresos = totalIngresos.add(sueldo).add(comision).add(otrosIngresos).add(negocioPropio);
            totalEgresos = totalEgresos.add(gastoVida).add(pagoDeuda).add(pagoVivienda).add(otrosDescuentos);

            solicitud.setSolicitudTotalingreso(totalIngresos);
            solicitud.setSolicitudTotalegreso(totalEgresos);
            solicitud.setSolicitudRentaneta(totalIngresos.subtract(totalEgresos));
            solicitudService.merge(this.solicitud);
        } catch (Exception e) {
            String msge = "";
            Throwable cause = JsfUtil.getRootCause(e.getCause());
            if (cause != null) {
                msge = cause.getLocalizedMessage();
            }
            if (msge.length() > 0) {
                JsfUtil.addErrorMessage("ERROR CALCULANDO RENTA NETA MENSUAL " + refPerSelected.getRpId());
            } else {
                JsfUtil.addErrorMessage(e, "ERROR ELIMINANDO REFERENCIA PERSONAL " + refPerSelected.getRpId());
            }
        }

    }

    /**
     * Metodo para calcular el capital actual del Asociado relacionado a la
     * Solicitud de Credito
     *
     * @param event Evento del boton accionado en la vista
     */
    public void calcularCapitalActual(ActionEvent event) {
        try {
            BigDecimal aportaciones = solicitud.getSolicitudAportacionactivo() == null ? new BigDecimal(BigInteger.ZERO) : solicitud.getSolicitudAportacionactivo();
            BigDecimal ahorros = solicitud.getSolicitudAhorroactivo() == null ? new BigDecimal(BigInteger.ZERO) : this.solicitud.getSolicitudAhorroactivo();
            BigDecimal otrosActivos = solicitud.getSolicitudOtroactivo() == null ? new BigDecimal(BigInteger.ZERO) : solicitud.getSolicitudOtroactivo();
            BigDecimal propiedades = solicitud.getSolicitudValorpropiedad() == null ? new BigDecimal(BigInteger.ZERO) : solicitud.getSolicitudValorpropiedad();
            BigDecimal vehiculos = solicitud.getSolicitudValorvehiculo() == null ? new BigDecimal(BigInteger.ZERO) : solicitud.getSolicitudValorvehiculo();
            BigDecimal totalActivos = new BigDecimal(BigInteger.ZERO);

            BigDecimal prestamos = solicitud.getSolicitudPrestamo() == null ? new BigDecimal(BigInteger.ZERO) : solicitud.getSolicitudPrestamo();
            BigDecimal deudaOtrasInst = solicitud.getSolicitudDeudaif() == null ? new BigDecimal(BigInteger.ZERO) : solicitud.getSolicitudDeudaif();
            BigDecimal deudaOtros = solicitud.getSolicitudOtradeuda() == null ? new BigDecimal(BigInteger.ZERO) : solicitud.getSolicitudOtradeuda();
            BigDecimal totalPasivos = new BigDecimal(BigInteger.ZERO);

            totalActivos = totalActivos.add(aportaciones).add(ahorros).add(otrosActivos).add(propiedades).add(vehiculos);
            totalPasivos = totalPasivos.add(prestamos).add(deudaOtrasInst).add(deudaOtros);

            solicitud.setSolicitudTotalactivo(totalActivos);
            solicitud.setSolicitudTotalpasivo(totalPasivos);
            solicitud.setSolicitudCapital(totalActivos.subtract(totalPasivos));
            solicitudService.merge(solicitud);
        } catch (Exception e) {

            String msge = "";
            Throwable cause = JsfUtil.getRootCause(e.getCause());
            if (cause != null) {
                msge = cause.getLocalizedMessage();
            }
            if (msge.length() > 0) {
                JsfUtil.addErrorMessage("ERROR ELIMINANDO REFERENCIA PERSONAL " + refPerSelected.getRpId());
            } else {
                JsfUtil.addErrorMessage(e, "ERROR ELIMINANDO REFERENCIA PERSONAL " + refPerSelected.getRpId());
            }
        }

    }

    /**
     * Metodo para inicializar las listas a utilizar en los componente de la
     * vista de la Solicitud de Credito
     */
    public void cargarListas() {

        try {
            propiedadItems = propiedadService.findAllPropiedadesBySolicitud(solicitud.getSolicitudId());
            prestamoItems = prestamoService.findPrestamosByAsociado(asociado.getIdasociados());
           
            prestamofinItems = deudaService.deudasPrestamosFinByIdSolicitud(solicitud.getSolicitudId());  
            deudaCItems = deudaService.deudasComercialesByIdAsociado(solicitud.getSolicitudId());
            deudaTItems = deudaService.deudasTarjetasByIdAsociado(solicitud.getSolicitudId());

            refFamItems = referenciaFamiliarService.findAllReferenciasFamiliaresBySolicitud(solicitud.getSolicitudId());
            refPerItems = referenciaPersonalService.findAllReferenciasPersonalesBySolicitud(solicitud.getSolicitudId());
            ingresos = ingresoService.findIngresosBySolicitud(solicitud.getSolicitudId());

            tipoEmpresaList = tipoEmpresaService.findAll();
            formaPagoList = formaPagoService.findAll();
            periodicidadPagoList = periodicidadPagoService.findAll();
            promociones = promocionService.findAll();

        } catch (Exception e) {
            log.error("Error Cargando las lista necesarias para la solicitud", e);
        }

    }

    /**
     * Metodo para redirigir de la vista de seleccion de Asesorias a la vista de
     * la solicitud de Credito
     *
     * @param event Evento del boton accionado en la vista
     */
    public void toSolicitud(ActionEvent event) {

        FacesContext contex = FacesContext.getCurrentInstance();
        solicitud = new Solicitud();
        String user = getUsuario();
        Asociados socio;
        promocionesSelecionadas = new ArrayList<Promocion>();
        boolean band = true;
        try {
            if (user != null) {
                asesoriaSelected = asesoriaService.findAsesoriaById(asesoriaSelected.getAsesoriaId());
                socio = asesoriaSelected.getIdasociados();
                promocionesSelecionadas.addAll(asesoriaSelected.getPromocionList());
                solicitud.setAsesoriaId(asesoriaSelected);
                solicitud.setFpId(asesoriaSelected.getFpId());
                solicitud.setPpId(asesoriaSelected.getPpId());
                solicitud.setSolicitudCodigoasociado(asesoriaSelected.getIdasociados().getCodigo());
                solicitud.setSolicitudNombre1(socio.getIdasocnatu().getDuiNombre1());
                solicitud.setSolicitudNombre2(socio.getIdasocnatu().getDuiNombre2());
                solicitud.setSolicitudApellido1(socio.getIdasocnatu().getDuiApellido1());
                solicitud.setSolicitudApellido2(socio.getIdasocnatu().getDuiApellido2());
                solicitud.setSolicitudDuilugar(socio.getIdasocnatu().getLugarExped());
                solicitud.setSolicitudDuifechaexp(new Date());
                solicitud.setSolicitudEstatuslegal(socio.getIdasocnatu().getEstatusLegal());
                solicitud.setSolicitudEstadocivil(socio.getIdasocnatu().getEstadoFam());
                solicitud.setSolicitudProfesion(socio.getIdasocnatu().getNivelEstudio());
                solicitud.setSolicitudNumdependiente(socio.getIdasocnatu().getPerdepen());
                solicitud.setSolicitudDireccionresidencia(socio.getIdasocnatu().getDireccionRes());
                solicitud.setSolicitudTiemporesidirmes(socio.getIdasocnatu().getThanios());
                solicitud.setSolicitudAportacionactivo(socio.getAportacion());
                solicitud.setSolicitudTelefono(socio.getIdasocnatu().getTelCasa1());
                solicitud.setSolicitudCelular(socio.getIdasocnatu().getTelCel1());
                solicitud.setSolicitudMontosolicitado(asesoriaSelected.getAsesoriaMonto());
                solicitud.setSolicitudPlazosolicitado(asesoriaSelected.getAsesoriaPlazo());
                solicitud.setSolicitudSueldo(asesoriaSelected.getAsesoriaIngreso());
                solicitud.setSolicitudDestino(" ");
                solicitud.setSolicitudDiapago(30); //revisar
                solicitud.setUsuarioRegistro(user);
                solicitud.setFechaRegistro(new Date());
                solicitud.setSolicitudCompleta(false);
                getService().save(solicitud);

                if (solicitud.getSolicitudId() != null) {
                    Asesoria asesoria = asesoriaService.findAsesoriaById(solicitud.getAsesoriaId().getAsesoriaId());
                    asesoria.setSolicitudId(solicitud);
                    asesoriaService.merge(asesoria);
                    solicitud.setAsesoriaId(asesoria);
                    asociado = asesoria.getIdasociados();
                }
                cargarListas();

            }
        } catch (Exception e) {
            try {
                String msg = "";
                Throwable cause = JsfUtil.getRootCause(e.getCause());
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage("ERROR CREANDO LA SOLICITUD PARA LA ASESORIA " + asesoriaSelected.getAsesoriaId());
                } else {
                    JsfUtil.addErrorMessage(e, "ERROR CREANDO LA SOLICITUD PARA LA ASESORIA " + asesoriaSelected.getAsesoriaId());
                }
                band = false;
                contex.getExternalContext().redirect("/siacofinges/views/solicitud/index.xhtml");
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(SolicitudManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (band) {
            try {
                contex.getExternalContext().redirect("/siacofinges/views/solicitud/solicitudIndex.xhtml");
            } catch (IOException e) {
                log.error("Error al redirigir a la pagina de solicitud" + e);
            }
        }
    }

    /**
     * Metodo para redirigir a la vista de la solicitud de credito para ser
     * modificada
     *
     * @param event
     */
    public void toEdit(ActionEvent event) {
        FacesContext contex = FacesContext.getCurrentInstance();
        List<Requisitosolicitadoempleado> requisitos;
        promocionesSelecionadas = new ArrayList<Promocion>();
        ingresos = new ArrayList<Ingreso>();
        boolean band = true;
        editando=true;
        try {
            solicitud = solicitudService.findById(getSelected().getSolicitudId());
            asesoriaSelected = solicitud.getAsesoriaId();
            promocionesSelecionadas.addAll(solicitud.getAsesoriaId().getPromocionList());
            ingresos = ingresoService.findIngresosBySolicitud(solicitud.getSolicitudId());
            requisitos = requisitoSolicitadoEmpleadoService.findRequisitosByAsesoria(asesoriaSelected.getAsesoriaId());

            requisitosSeleccionados = new Requisitosolicitadoempleado[requisitos.size()];

            int i = 0;
            for (Requisitosolicitadoempleado rlce : requisitos) {
                requisitosSeleccionados[i] = rlce;
                i++;
            }
            asociado = asociadoService.findById(solicitud.getAsesoriaId().getIdasociados().getIdasociados());
            solictudCompleta = solicitud.getSolicitudCompleta();
            cargarListas();

        } catch (Exception e) {
            band = false;
            String msg = "";
            Throwable cause = JsfUtil.getRootCause(e.getCause());
            if (cause != null) {
                msg = cause.getLocalizedMessage();
            }
            if (msg.length() > 0) {
                JsfUtil.addErrorMessage("Error al editar la solicitud de Credito ");
            } else {
                JsfUtil.addErrorMessage(e, "Error al editar la solicitud de Credito  ");
            }

            try {
                editando=false;
                contex.getExternalContext().redirect("/siacofinges/views/solicitud/solicitudEdit.xhtml");
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(SolicitudManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (band) {
            try {
                contex.getExternalContext().redirect("/siacofinges/views/solicitud/solicitudIndex.xhtml");
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(SolicitudManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Metodo para actualizar la solicitud con los datos ingresados
     *
     * @param event
     */
    public void update(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();

            if (solictudCompleta) {
                solicitud.setSolicitudCompleta(true);
            } else {
                solicitud.setSolicitudCompleta(false);
            }

            solicitudService.merge(solicitud);
            solicitud = null;
            asesoriaSelected = null;
            solictudCompleta = false;
            try {
                
                if(!editando){
                  editando=false;  
                  cargarAsesorias();
                  JsfUtil.addSuccessMessage("Operacion realizada con Exito");
                  contex.getExternalContext().redirect("/siacofinges/views/solicitud/index.xhtml");
                }else{
                    editando=false;
                    contex.getExternalContext().redirect("/siacofinges/views/solicitud/solicitudEdit.xhtml"); 
                }
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(SolicitudManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (HibernateException e) {
            log.debug("Error al actualizar la solicitud de Credito " + e);
            manejaException(e);
        }
    }

    /**
     * Metodo para el registrar el cumplimiento de los documentos solicitados en
     * la asesoria de Credito
     *
     */
    public void documentosRecibidos() {
        requisitosItems = requisitoSolicitadoEmpleadoService.findRequisitosByAsesoria(solicitud.getAsesoriaId().getAsesoriaId());

    }

    /**
     * Metodo para el actualizar los documentos y marcarlos como recibidos
     *
     * @param event
     */
    public void updateDocumentosRecibido(ActionEvent event) {
        requisitoSolicitadoEmpleadoService.updateRequisitosByAsesoria(requisitosSeleccionados, solicitud.getAsesoriaId().getAsesoriaId());
    }

    public void print() {

        if (getSelected() != null && getSelected().getSolicitudId() != null) {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            List<ReporteSolicitudCredito> list = new ArrayList<ReporteSolicitudCredito>();
            list.add(solicitudService.prepararSolicitudParaReporte(getSelected().getSolicitudId()));
            HttpServletRequest request = (HttpServletRequest) context.getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getResponse();
            Reporte reporte = new Reporte("solicitud", "SolicitudesDeCredito", request);
            reporte.setDataSource(new JRBeanCollectionDataSource(new HashSet<ReporteSolicitudCredito>(list)));
            reporte.setReportInSession(request, response);
            setReportName(reporte.getNombreLogico());
            RequestContext.getCurrentInstance().addCallbackParam("reportName", getReportName());
        }
    }

    public void printAsesoria() {
         ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            List<ReporteAsesoriaCreditopojo> list = new ArrayList<ReporteAsesoriaCreditopojo>();
            list.add(asesoriaService.fillAsesoriaRpt(asesoriaSelected));
            HttpServletRequest request = (HttpServletRequest) context.getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getResponse();
            Reporte reporte = new Reporte("asesoria", "InformedeAsesoriadeCredito", request);
          //  reporte.addParameter("asesoria_id", 5);
            reporte.setDataSource(new JRBeanCollectionDataSource(new HashSet<ReporteAsesoriaCreditopojo>(list)));
            reporte.setReportInSession(request, response);
            setReportName(reporte.getNombreLogico());
            RequestContext.getCurrentInstance().addCallbackParam("reportName", getReportName());
       
    }

    /**
     * Metodo para redirigir de la vista de seleccion de Asesorias
     *
     * @param event Evento del boton accionado en la vista
     */
    public void cancelar(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            asesoriaSelected.setSolicitudId(null);
            asesoriaService.merge(asesoriaSelected);
            getService().delete(solicitud);
            solicitud = null;
            asesoriaSelected = null;
            try {
                cargarAsesorias();
                contex.getExternalContext().redirect("/siacofinges/views/solicitud/index.xhtml");
            } catch (IOException ex) {
                log.debug("Error al redirigir a el listado de asesorias" + ex);
            }

        } catch (HibernateException e) {
            log.debug("Error al actualizar la solicitud de Credito " + e);
            manejaException(e);
        }
    }

    /*LAZY MODELS */
    @Override
    public LazyDataModel<Solicitud> getNewLazyModel() {
        return new SolicitudLazyModel(solicitudService);
    }

    public LazyDataModel<Propiedad> getPropiedadLazyModel() {
        propiedadItems = propiedadService.findAllPropiedadesBySolicitud(this.solicitud.getSolicitudId());
        return new PropiedadLazyModel(propiedadItems, propiedadService);
    }

    public LazyDataModel<Prestamo> getPrestamoLazyModel() {
        return new PrestamoLazyModel(prestamoService);
    }

    public LazyDataModel<Asesoria> getAsesoriaLazyModel() {
        return new AsesoriaLazyModel(asesoriaService);
    }

    /* getter y setter de las Propiedades*/
    public Propiedad getPropiedadSelected() {
        return propiedadSelected;
    }

    public void setPropiedadSelected(Propiedad propiedadSelected) {
        this.propiedadSelected = propiedadSelected;
    }

    public List<Propiedad> getPropiedadItems() {
        return propiedadItems;
    }

    public void setPropiedadItems(List<Propiedad> propiedadItems) {
        this.propiedadItems = propiedadItems;
    }

    public SelectItem[] getPropiedadActivoOptionsFilter() {
        return propiedadActivoOptionsFilter;
    }

    public void setPropiedadActivoOptionsFilter(SelectItem[] propiedadActivoOptionsFilter) {
        this.propiedadActivoOptionsFilter = propiedadActivoOptionsFilter;
    }

    public SelectItem[] getPropiedadActivoOptions() {
        return propiedadActivoOptions;
    }

    public void setPropiedadActivoOptions(SelectItem[] propiedadActivoOptions) {
        this.propiedadActivoOptions = propiedadActivoOptions;
    }

    //Fin getter y setter de las Propiedad   
    /*SETTER Y GETTER DE PRESTAMO*/
    public Prestamo getPrestamoSelected() {
        return prestamoSelected;
    }

    public void setPrestamoSelected(Prestamo prestamoSelected) {
        this.prestamoSelected = prestamoSelected;
    }

    public List<Prestamo> getPrestamoItems() {
        return prestamoItems;
    }

    public void setPrestamoItems(List<Prestamo> prestamoItems) {
        this.prestamoItems = prestamoItems;
    }

    public LazyDataModel<Prestamo> getPrestamoLazyItems() {
        return prestamoLazyItems;
    }

    public void setPrestamoLazyItems(LazyDataModel<Prestamo> prestamoLazyItems) {
        this.prestamoLazyItems = prestamoLazyItems;
    }

    public SelectItem[] getPrestamoActivoOptionsFilter() {
        return prestamoActivoOptionsFilter;
    }

    public void setPrestamoActivoOptionsFilter(SelectItem[] prestamoActivoOptionsFilter) {
        this.prestamoActivoOptionsFilter = prestamoActivoOptionsFilter;
    }

    public SelectItem[] getPrestamoActivoOptions() {
        return prestamoActivoOptions;
    }

    public void setPrestamoActivoOptions(SelectItem[] prestamoActivoOptions) {
        this.prestamoActivoOptions = prestamoActivoOptions;
    }
    /* FIN GETTER Y SETTER DE PRESTAMO*/

    /* INICIO 
     */
    public Asesoria getAsesoriaSelected() {
        return asesoriaSelected;
    }

    public void setAsesoriaSelected(Asesoria asesoriaSelected) {
        this.asesoriaSelected = asesoriaSelected;
    }

    public Formapago getFormaPagoSeleccionada() {
        return formaPagoSeleccionada;
    }

    public void setFormaPagoSeleccionada(Formapago formaPagoSeleccionada) {
        this.formaPagoSeleccionada = formaPagoSeleccionada;
    }

    public List<Asesoria> getAsesoriaItems() {
        return asesoriaItems;
    }

    public void setAsesoriaItems(List<Asesoria> asesoriaItems) {
        this.asesoriaItems = asesoriaItems;
    }

    public LazyDataModel<Asesoria> getAsesorialazyItems() {
        return asesorialazyItems;
    }

    public void setAsesorialazyItems(LazyDataModel<Asesoria> asesorialazyItems) {
        this.asesorialazyItems = asesorialazyItems;
    }

    public SelectItem[] getAsesoriaActivoOptionsFilter() {
        return asesoriaActivoOptionsFilter;
    }

    public void setAsesoriaActivoOptionsFilter(SelectItem[] asesoriaActivoOptionsFilter) {
        this.asesoriaActivoOptionsFilter = asesoriaActivoOptionsFilter;
    }

    public SelectItem[] getAsesoriaActivoOptions() {
        return asesoriaActivoOptions;
    }

    public void setAsesoriaActivoOptions(SelectItem[] asesoriaActivoOptions) {
        this.asesoriaActivoOptions = asesoriaActivoOptions;
    }

    /*  FIN */
    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Asociados getAsociado() {
        return asociado;
    }

    public void setAsociado(Asociados asociado) {
        this.asociado = asociado;
    }

    /* REFERENCIA FAMILIAR   */
    public Referenciafamiliar getRefFamSelected() {
        return refFamSelected;
    }

    public void setRefFamSelected(Referenciafamiliar refFamSelected) {
        this.refFamSelected = refFamSelected;
    }

    public List<Referenciafamiliar> getRefFamItems() {
        return refFamItems;
    }

    public void setRefFamItems(List<Referenciafamiliar> refFamItems) {
        this.refFamItems = refFamItems;
    }

    public SelectItem[] getRefFamActivoOptionsFilter() {
        return refFamActivoOptionsFilter;
    }

    public void setRefFamActivoOptionsFilter(SelectItem[] refFamActivoOptionsFilter) {
        this.refFamActivoOptionsFilter = refFamActivoOptionsFilter;
    }

    public SelectItem[] getRefFamActivoOptions() {
        return refFamActivoOptions;
    }

    public void setRefFamActivoOptions(SelectItem[] refFamActivoOptions) {
        this.refFamActivoOptions = refFamActivoOptions;
    }

    /*FIN REFERENCIA FAMILIAR*/
    /*INICION REFERENCIA PERSONAL*/
    public Referenciapersonal getRefPerSelected() {
        return refPerSelected;
    }

    public void setRefPerSelected(Referenciapersonal refPerSelected) {
        this.refPerSelected = refPerSelected;
    }

    public List<Referenciapersonal> getRefPerItems() {
        return refPerItems;
    }

    public void setRefPerItems(List<Referenciapersonal> refPerItems) {
        this.refPerItems = refPerItems;
    }

    public SelectItem[] getRefPerActivoOptionsFilter() {
        return refPerActivoOptionsFilter;
    }

    public void setRefPerActivoOptionsFilter(SelectItem[] refPerActivoOptionsFilter) {
        this.refPerActivoOptionsFilter = refPerActivoOptionsFilter;
    }

    public SelectItem[] getRefPerActivoOptions() {
        return refPerActivoOptions;
    }

    public void setRefPerActivoOptions(SelectItem[] refPerActivoOptions) {
        this.refPerActivoOptions = refPerActivoOptions;
    }

    /*Lista Combos*/
    public List<Tipoempresa> getTipoEmpresaList() {
        return tipoEmpresaList;
    }

    public void setTipoEmpresaList(List<Tipoempresa> tipoEmpresaList) {
        this.tipoEmpresaList = tipoEmpresaList;
    }

    public Tipoempresa getTipoEmpresaSeleccionado() {
        return tipoEmpresaSeleccionado;
    }

    public void setTipoEmpresaSeleccionado(Tipoempresa tipoEmpresaSeleccionado) {
        this.tipoEmpresaSeleccionado = tipoEmpresaSeleccionado;
    }

    public List<Formapago> getFormaPagoList() {
        return formaPagoList;
    }

    public void setFormaPagoList(List<Formapago> formaPagoList) {
        this.formaPagoList = formaPagoList;
    }

    public List<Periodicidadpago> getPeriodicidadPagoList() {
        return periodicidadPagoList;
    }

    public void setPeriodicidadPagoList(List<Periodicidadpago> periodicidadPagoList) {
        this.periodicidadPagoList = periodicidadPagoList;
    }

    public Periodicidadpago getPeriodicidadPagoSeleccionada() {
        return periodicidadPagoSeleccionada;
    }

    public void setPeriodicidadPagoSeleccionada(Periodicidadpago periodicidadPagoSeleccionada) {
        this.periodicidadPagoSeleccionada = periodicidadPagoSeleccionada;
    }

    public List<Promocion> getPromociones() {
        return promociones;
    }

    public void setPromociones(List<Promocion> promociones) {
        this.promociones = promociones;
    }

    public List<Promocion> getPromocionesSelecionadas() {
        return promocionesSelecionadas;
    }

    public void setPromocionesSelecionadas(List<Promocion> promocionesSelecionadas) {
        this.promocionesSelecionadas = promocionesSelecionadas;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public Deuda getDeudaCSelected() {
        return deudaCSelected;
    }

    public void setDeudaCSelected(Deuda deudaCSelected) {
        this.deudaCSelected = deudaCSelected;
    }

    public List<Deuda> getDeudaCItems() {
        return deudaCItems;
    }

    public void setDeudaCItems(List<Deuda> deudaCItems) {
        this.deudaCItems = deudaCItems;
    }

    public Deuda getDeudaTSelected() {
        return deudaTSelected;
    }

    public void setDeudaTSelected(Deuda deudaTSelected) {
        this.deudaTSelected = deudaTSelected;
    }

    public List<Deuda> getDeudaTItems() {
        return deudaTItems;
    }

    public void setDeudaTItems(List<Deuda> deudaTItems) {
        this.deudaTItems = deudaTItems;
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

    public boolean isSolictudCompleta() {
        return solictudCompleta;
    }

    public void setSolictudCompleta(boolean solictudCompleta) {
        this.solictudCompleta = solictudCompleta;
    }

    public Requisitosolicitadoempleado[] getRequisitosSeleccionados() {
        return requisitosSeleccionados;
    }

    public void setRequisitosSeleccionados(Requisitosolicitadoempleado[] requisitosSeleccionados) {
        this.requisitosSeleccionados = requisitosSeleccionados;
    }

    public List<Requisitosolicitadoempleado> getRequisitosItems() {
        return requisitosItems;
    }

    public void setRequisitosItems(List<Requisitosolicitadoempleado> requisitosItems) {
        this.requisitosItems = requisitosItems;
    }

    public LazyDataModel<Requisitosolicitadoempleado> getRequisitoslazyItems() {
        return requisitoslazyItems;
    }

    public void setRequisitoslazyItems(LazyDataModel<Requisitosolicitadoempleado> requisitoslazyItems) {
        this.requisitoslazyItems = requisitoslazyItems;
    }

    @Override
    public GenericService<Solicitud, Integer> getService() {
        return solicitudService;
    }

    public Deuda getPrestamofinSelected() {
        return prestamofinSelected;
    }

    public void setPrestamofinSelected(Deuda prestamofinSelected) {
        this.prestamofinSelected = prestamofinSelected;
    }

    public List<Deuda> getPrestamofinItems() {
        return prestamofinItems;
    }

    public void setPrestamofinItems(List<Deuda> prestamofinItems) {
        this.prestamofinItems = prestamofinItems;
    }

    public LazyDataModel<Deuda> getPrestamofinLazyItems() {
        return prestamofinLazyItems;
    }

    public void setPrestamofinLazyItems(LazyDataModel<Deuda> prestamofinLazyItems) {
        this.prestamofinLazyItems = prestamofinLazyItems;
    }

    public List<Fuenteingreso> getFuentesIngresoList() {
        return fuentesIngresoList;
    }

    public void setFuentesIngresoList(List<Fuenteingreso> fuentesIngresoList) {
        this.fuentesIngresoList = fuentesIngresoList;
    }

    public List<Ingreso> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<Ingreso> ingresos) {
        this.ingresos = ingresos;
    }

    public Ingreso getNuevoIngreso() {
        return nuevoIngreso;
    }

    public void setNuevoIngreso(Ingreso nuevoIngreso) {
        this.nuevoIngreso = nuevoIngreso;
    }

    public Fuenteingreso getFuentesIngresoSelected() {
        return fuentesIngresoSelected;
    }

    public void setFuentesIngresoSelected(Fuenteingreso fuentesIngresoSelected) {
        this.fuentesIngresoSelected = fuentesIngresoSelected;
    }

    public Ingreso getIngresoSelected() {
        return ingresoSelected;
    }

    public void setIngresoSelected(Ingreso ingresoSelected) {
        this.ingresoSelected = ingresoSelected;
    }

    public String getReportName1() {
        return reportName1;
    }

    public void setReportName1(String reportName1) {
        this.reportName1 = reportName1;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

}
