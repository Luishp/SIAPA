package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.AsesoriaLazyModel;
import com.siapa.managedbean.lazymodel.PrestamoLazyModel;
import com.siapa.managedbean.lazymodel.PropiedadLazyModel;
import com.siapa.model.Analisis;
import com.siapa.model.Asesoria;
import com.siapa.model.Asociados;
import com.siapa.model.Codeudor;
import com.siapa.model.Deuda;
import com.siapa.model.Formapago;
import com.siapa.model.Fuenteingreso;
import com.siapa.model.Ingreso;
import com.siapa.model.Periodicidadpago;
import com.siapa.model.Prestamo;
import com.siapa.model.Prestamofinanciero;
import com.siapa.model.Promocion;
import com.siapa.model.Propiedad;
import com.siapa.model.Referenciafamiliar;
import com.siapa.model.Referenciapersonal;
import com.siapa.model.Requisitosolicitadoempleado;
import com.siapa.model.Registrogarantiacodeudor;
import com.siapa.model.Registrogarantiahipotecaria;
import com.siapa.model.Tipodeuda;
import com.siapa.model.Tipoempresa;
import com.siapa.model.Tiporesidencia;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.service.AnalisisService;
import com.siapa.service.AsesoriaService;
import com.siapa.service.AsociadoService;
import com.siapa.service.CodeudorService;
import com.siapa.service.ConfiguracionSistemaService;
import com.siapa.service.DeudaService;
import com.siapa.service.FormaPagoService;
import com.siapa.service.FuentesIngresoService;
import com.siapa.service.GarantiaCodeudorService;
import com.siapa.service.IngresoService;
import com.siapa.service.PeriodicidadPagoService;
import com.siapa.service.PrestamoFinancieroService;
import com.siapa.service.PrestamoService;
import com.siapa.service.PromocionService;
import com.siapa.service.PropiedadService;
import com.siapa.service.ReferenciaFamiliarService;
import com.siapa.service.ReferenciaPersonalService;
import com.siapa.service.RequisitoSolicitadoEmpleadoService;
import com.siapa.service.TipoDeudaService;
import com.siapa.service.TipoEmpresaService;
import com.siapa.service.TipoResidenciaService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.validation.ValidationException;
import org.hibernate.HibernateException;
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
@Named("garantiaCodeudorManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class GarantiaCodeudorManagedBean extends GenericManagedBean<Registrogarantiacodeudor, Integer> {
    
    private static final Logger log = LoggerFactory.getLogger(GarantiaCodeudorManagedBean.class);
    @Autowired
    @Qualifier(value = "garantiaCodeudorService")
    private GarantiaCodeudorService garantiaCodeudorService;
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
    @Autowired
    @Qualifier(value = "tipoResidenciaService")
    private TipoResidenciaService tipoResidenciaService;
    @Autowired
    @Qualifier(value = "codeudorService")
    private CodeudorService codeudorService;
    @Autowired
    @Qualifier(value = "analisisService")
    private AnalisisService analisisService;
    
    Registrogarantiacodeudor registrogarantiacodeudor;
    Asociados asociado;
    private Ingreso nuevoIngreso;
    private boolean garantiaCodeudorCompleta;
    private Integer idGarantiaCodeudor;
    private Codeudor codeudor;
    private String codigoAsociado;
    private Asesoria asesoriaSelected;
    private List<Asesoria> asesoriaItems;
    private LazyDataModel<Asesoria> asesorialazyItems;
    private SelectItem[] asesoriaActivoOptionsFilter;
    private SelectItem[] asesoriaActivoOptions;
    private SelectItem[] estadoCivilOptions;
    private SelectItem[] estatusLegalOptions;
    private SelectItem[] profesionesOptions;

    private Propiedad propiedadSelected;
    private List<Propiedad> propiedadItems;
    private SelectItem[] propiedadActivoOptionsFilter;
    private SelectItem[] propiedadActivoOptions;

    private Prestamo prestamoSelected;
    private List<Prestamo> prestamoItems;
    private LazyDataModel<Prestamo> prestamoLazyItems;
    private SelectItem[] prestamoActivoOptionsFilter;
    private SelectItem[] prestamoActivoOptions;

    private Prestamofinanciero prestamofinSelected;
    private List<Prestamofinanciero> prestamofinItems;
    private LazyDataModel<Prestamofinanciero> prestamofinLazyItems;
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
    private Integer idAnalisis;
    private Integer idTipoGarantia;
    private String nombreAsociado;
    private String codigoSocio;
    private String codigoSolicitud;
    // selectManyCheckbox
    private Requisitosolicitadoempleado[] requisitosSeleccionados;
    private List<Requisitosolicitadoempleado> requisitosItems;
    private LazyDataModel<Requisitosolicitadoempleado> requisitoslazyItems;
 private final String urlgarantias = "/siacofinges/views/garantia/index.xhtml";
    private List<Registrogarantiacodeudor> listaCodeudores;
    
    
    private List<Tiporesidencia> tipoResidenciaList;
    private Tiporesidencia tipoResidenciaSelect;
    
    /**
     * Metodo init de la clase Registro Garantia Codeudor
     */
    @PostConstruct
    public void init() {
        loadLazyModels();
        FacesContext context = FacesContext.getCurrentInstance();
        idAnalisis = (Integer) context.getExternalContext().getSessionMap().get("idAnalisis");
        idTipoGarantia = (Integer) context.getExternalContext().getSessionMap().get("idGarantia");
        nombreAsociado = (String) context.getExternalContext().getSessionMap().get("nombreSocio");
        codigoSocio = (String) context.getExternalContext().getSessionMap().get("codigoSocio");
        codigoSolicitud = (String) context.getExternalContext().getSessionMap().get("codigoSolicitud");

        context.getExternalContext().getSessionMap().remove("idAnalisis");
        context.getExternalContext().getSessionMap().remove("idGarantia");
        context.getExternalContext().getSessionMap().remove("nombreSocio");
        context.getExternalContext().getSessionMap().remove("codigoSocio");
        context.getExternalContext().getSessionMap().remove("codigoSolicitud");
        
        cargarCodeudores(idAnalisis);
    }

    /**
     * Constructor de la clase GarantiaCodeudorManagedBean
     */
    public GarantiaCodeudorManagedBean() {
        propiedadActivoOptionsFilter = propiedadCreateFilterOptions();
        propiedadActivoOptions = propiedadCreateActivoOptions();
        prestamoActivoOptionsFilter = prestamoCreateFilterOptions();
//        prestamoActivoOptions = prestamoCreateActivoOptions();
        prestamofinActivoOptionsFilter = prestamofinCreateFilterOptions();
        prestamofinActivoOptions = prestamofinCreateActivoOptions();
        deudaCActivoOptions = deudaCCreateActivoOptions();
        deudaTActivoOptions = deudaTCreateActivoOptions();
        estadoCivilOptions = estadoCivilCreateActivoOptions();
        estatusLegalOptions = estatusLegalCreateActivoOptions();
        profesionesOptions = profesionesCreateFilterOptions();
    }

    /**
     * Metodo para Inicializar la lista de asesorias que aun no tienen una
     * registrogarantiacodeudor de Credito Asociada
     */
    private void cargarCodeudores(Integer idGarantiaCodeudor) {
        try {
            listaCodeudores=garantiaCodeudorService.findByAnalisisId(idGarantiaCodeudor);
        } catch (Exception e) {
            log.debug("Error al cargar codeudores asignados" + e);
        }
    }
    
        /**
     * Metodo para buscar un asociado para asignarle un asesoria de un credito
     * solicitado
     *
     * @param event
     */
    public void buscarAsociado(ActionEvent event) {
 
        try {
            asociado = asociadoService.findByCodigo(codigoAsociado);

            if (asociado != null) {
                codeudor=new Codeudor();
                codeudor.setCodeudorNombre1(asociado.getIdasocnatu().getDuiNombre1());
                codeudor.setCodeudorNombre2(asociado.getIdasocnatu().getDuiNombre2());
                codeudor.setCodeudorApellido1(asociado.getIdasocnatu().getDuiApellido1());
                codeudor.setCodeudorApellido2(asociado.getIdasocnatu().getDuiApellido2());
                codeudor.setCodeudorApellidocasada(asociado.getIdasocnatu().getDuiApecasada());
                codeudor.setCodeudorDui(asociado.getIdasocnatu().getNoDui());
                codeudor.setCodeudorNit(asociado.getIdasocnatu().getNoNit());
                codeudor.setCodeudorIsss(asociado.getIdasocnatu().getNoIsss());
                codeudor.setCodeudorDuifechaexp(asociado.getIdasocnatu().getDateExped());
                codeudor.setCodeudorDuilugar(asociado.getIdasocnatu().getLugarExped());
                codeudor.setCodeudorCodigoasociado(asociado.getCodigo());
                registrogarantiacodeudor.setRgcAportacionahorroactivo(asociado.getAportacion());
                registrogarantiacodeudor.setAnalisisId(null);
                JsfUtil.addSuccessMessage("Correcto ", "Asociado encontrado " + codigoAsociado);
            } else {
                codeudor=new Codeudor();
                registrogarantiacodeudor.setRgcAportacionahorroactivo(BigDecimal.ZERO);
                JsfUtil.addErrorMessage("ERROR:", "No se encontro un Asociado con el codigo " + codigoAsociado);
            }

        } catch (ValidationException ve) {
            String msj = "Error realizando busqueda de el asociado v: " + ve.getCause();
            JsfUtil.addErrorMessage(msj);
        } catch (Exception e) {
            String msj = "Error realizando busqueda de el asociado: " + e.getCause();
            JsfUtil.addErrorMessage(msj);
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
    
        private SelectItem[] profesionesCreateFilterOptions() {

        SelectItem[] options = new SelectItem[6];
            options[0] = new SelectItem("Ing. Quimico", "Ingeniero Quimico");
            options[1] = new SelectItem("Ing. Mecanico", "Ingeniero Mecanico");
            options[2] = new SelectItem("Ing. de Sistemas Informaticos", "Ing. de Sistemas Informaticos");
            options[3] = new SelectItem("Ing. Electrico", "Ing. Electrico");
            options[4] = new SelectItem("Ing. Civil", "Ing. Civil");
            options[5] = new SelectItem("Ing. de Alimentos", "Ing. de Alimentos");
            return options;
    }

    private SelectItem[] estadoCivilCreateActivoOptions() {

        SelectItem[] options = new SelectItem[4];
        options[0] = new SelectItem("Soltero", "Soltero");
        options[1] = new SelectItem("Casado", "Casado");
        options[2] = new SelectItem("Divorciado", "Divorciado");
        options[3] = new SelectItem("Acompaniado", "Acompaniado");
        return options;
    }

        private SelectItem[] estatusLegalCreateActivoOptions() {

        SelectItem[] options = new SelectItem[2];
        options[0] = new SelectItem("Nacionalizado", "Nacionalizado");
        options[1] = new SelectItem("Residente", "Residente");
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
     * Metodo para almacenar una Deuda relacionada con la registrogarantiacodeudor de Credito
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
                getDeudaCSelected().setRgcId(registrogarantiacodeudor);
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

//    public void guardarFuenteIngreso(ActionEvent event) {
//        boolean repetido = false;
//        
//        
//        for (Ingreso ingr : ingresos) {
//            if (ingr.getFuenteingreso().getFiId() == fuentesIngresoSelected.getFiId()) {
//                repetido = true;
//            }
//        }
//
//        if (repetido) {
//            for (Ingreso ingr : ingresos) {
//                if (ingr.getFuenteingreso().getFiId() == fuentesIngresoSelected.getFiId()) {
//                    BigDecimal cant;
//                    cant = ingr.getIngresoCantidad();
//                    cant = cant.add(nuevoIngreso.getIngresoCantidad());
//                    ingr.setIngresoCantidad(cant);
//                    ingresoService.merge(ingr);
//                }
//            }
//        } else {
//            IngresoPK ingPK = new IngresoPK();
//            ingPK.setFiId(fuentesIngresoSelected.getFiId());
//            ingPK.setRegistrogarantiacodeudorId(registrogarantiacodeudor.getRegistrogarantiacodeudorId());
//            nuevoIngreso.setIngresoPK(ingPK);
//            nuevoIngreso.setFuenteingreso(fuentesIngresoSelected);
//            nuevoIngreso.setRegistrogarantiacodeudor(registrogarantiacodeudor);
//            ingresoService.save(nuevoIngreso);
//        }
//
//        ingresos = ingresoService.findIngresosByRegistrogarantiacodeudor(registrogarantiacodeudor.getRegistrogarantiacodeudorId());
//    }
//    
    
    
    

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
     * Metodo para almacenar una Deuda relacionada con la registrogarantiacodeudor de Credito
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
                getDeudaTSelected().setRgcId(registrogarantiacodeudor);
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
     * Metodo para almacenar una propiedad relacionada con la registrogarantiacodeudor de
     * Credito del Asociado
     *
     * @param event Evento del boton accionado en la vista
     */
    public void savePropiedad(ActionEvent event) {

        if (getUsuario() != null) {
            String msj = "propiedad Creada";
            getPropiedadSelected().setRgcId(this.registrogarantiacodeudor);
            getPropiedadSelected().setUsuarioRegistro(getUsuario());
            getPropiedadSelected().setFechaRegistro(new Date());
            propiedadService.save(propiedadSelected);
        }
        cargarListas();
    }

    /**
     * Metodo para actualizar una propiedad relacionado con la registrogarantiacodeudor de
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
     * Metodo para almacenar un prestamo relacionado con la registrogarantiacodeudor de Credito
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
    public Prestamofinanciero prestamofinPrepareCreate(ActionEvent event) {
        Prestamofinanciero newItem;
        newItem = new Prestamofinanciero();
        this.prestamofinSelected = newItem;
        initializeEmbeddableKey();
        return newItem;

    }

    /**
     * Metodo para almacenar un prestamo relacionado con la registrogarantiacodeudor de Credito
     * del Asociado
     *
     * @param event Evento del boton accionado en la vista
     */
    public void savePrestamofin(ActionEvent event) {
        if (getUsuario() != null) {
            String msj = "Prestamo Creado";
            getPrestamofinSelected().setUsuarioRegistro(getUsuario());
            getPrestamofinSelected().setFechaRegistro(new Date());
            getPrestamofinSelected().setRgcId(registrogarantiacodeudor);
            prestamoFinancieroService.save(prestamofinSelected);
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
        prestamoFinancieroService.merge(prestamofinSelected);
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
            getRefFamSelected().setRgcId(this.registrogarantiacodeudor);
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
     * Metodo para quitar una Refrencia Familiar asociada a una registrogarantiacodeudor de
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
     * Metodo para almacenar una Referencia Personal relacionada a una registrogarantiacodeudor
     * de Credito
     *
     * @param event Evento del boton accionado en la vista
     */
    public void saveReferenciaPer(ActionEvent event) {

        if (getUsuario() != null) {
            String msj = "Referencia Personal Creada";
            getRefPerSelected().setRgcId(registrogarantiacodeudor);
            getRefPerSelected().setUsuarioRegistro(getUsuario());
            getRefPerSelected().setFechaRegistro(new Date());
            referenciaPersonalService.save(refPerSelected);
        }
        cargarListas();
    }

    /**
     * Metodo para actualizar una Refrencia Personal relacionada a la registrogarantiacodeudor
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
     * Metodo para quitar una Refrencia Personal asociada a una registrogarantiacodeudor de
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
     * Registrogarantiacodeudor de Credito
     *
     * @param event Evento del boton accionado en la vista
     */
    public void calcularRentaNetaMensual(ActionEvent event) {
        try {

            BigDecimal sueldo = this.registrogarantiacodeudor.getRgcSueldo() == null ? new BigDecimal(BigInteger.ZERO) : this.registrogarantiacodeudor.getRgcSueldo();
            BigDecimal totalIngresos = new BigDecimal(BigInteger.ZERO);
           
            BigDecimal negocioPropio=this.registrogarantiacodeudor.getRgcNegociopropio() == null ? new BigDecimal(BigInteger.ZERO) : this.registrogarantiacodeudor.getRgcNegociopropio();
            BigDecimal comision=this.registrogarantiacodeudor.getRgcComision() == null ? new BigDecimal(BigInteger.ZERO) : this.registrogarantiacodeudor.getRgcComision();
            BigDecimal otrosIngresos = this.registrogarantiacodeudor.getRgcIngresootros() == null ? new BigDecimal(BigInteger.ZERO) : this.registrogarantiacodeudor.getRgcIngresootros();
            BigDecimal gastoVida = this.registrogarantiacodeudor.getRgcGastovida() == null ? new BigDecimal(BigInteger.ZERO) : this.registrogarantiacodeudor.getRgcGastovida();
            BigDecimal pagoDeuda = this.registrogarantiacodeudor.getRgcPagodeudaactual() == null ? new BigDecimal(BigInteger.ZERO) : this.registrogarantiacodeudor.getRgcPagodeudaactual();
            BigDecimal pagoVivienda = this.registrogarantiacodeudor.getRgcPagovivienda() == null ? new BigDecimal(BigInteger.ZERO) : this.registrogarantiacodeudor.getRgcPagovivienda();
            BigDecimal otrosDescuentos = this.registrogarantiacodeudor.getRgcDescuento() == null ? new BigDecimal(BigInteger.ZERO) : this.registrogarantiacodeudor.getRgcDescuento();
            BigDecimal totalEgresos = new BigDecimal(BigInteger.ZERO);

            totalIngresos = totalIngresos.add(sueldo).add(comision).add(otrosIngresos).add(negocioPropio);
            totalEgresos = totalEgresos.add(gastoVida).add(pagoDeuda).add(pagoVivienda).add(otrosDescuentos);

            registrogarantiacodeudor.setRgcTotalingreso(totalIngresos);
            registrogarantiacodeudor.setRgcTotalegreso(totalEgresos);
            registrogarantiacodeudor.setRgcRentaneta(totalIngresos.subtract(totalEgresos));
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
     * Registrogarantiacodeudor de Credito
     *
     * @param event Evento del boton accionado en la vista
     */
    public void calcularCapitalActual(ActionEvent event) {
        try {
            BigDecimal aportaciones = registrogarantiacodeudor.getRgcAportacionahorroactivo() == null ? new BigDecimal(BigInteger.ZERO) : registrogarantiacodeudor.getRgcAportacionahorroactivo();
           
            BigDecimal otrosActivos = registrogarantiacodeudor.getRgcOtroactivo()== null ? new BigDecimal(BigInteger.ZERO) : registrogarantiacodeudor.getRgcOtroactivo();
            BigDecimal propiedades = registrogarantiacodeudor.getRgcValorpropiedad() == null ? new BigDecimal(BigInteger.ZERO) : registrogarantiacodeudor.getRgcValorpropiedad();
            BigDecimal vehiculos = registrogarantiacodeudor.getRgcValorvehiculo() == null ? new BigDecimal(BigInteger.ZERO) : registrogarantiacodeudor.getRgcValorvehiculo();
            BigDecimal totalActivos = new BigDecimal(BigInteger.ZERO);

            BigDecimal prestamos = registrogarantiacodeudor.getRgcPrestamo()== null ? new BigDecimal(BigInteger.ZERO) : registrogarantiacodeudor.getRgcPrestamo();
            BigDecimal deudaOtrasInst = registrogarantiacodeudor.getRgcDeudaif()== null ? new BigDecimal(BigInteger.ZERO) : registrogarantiacodeudor.getRgcDeudaif();
            BigDecimal deudaOtros = registrogarantiacodeudor.getRgcOtradeuda()== null ? new BigDecimal(BigInteger.ZERO) : registrogarantiacodeudor.getRgcOtradeuda();
            BigDecimal totalPasivos = new BigDecimal(BigInteger.ZERO);

            
            
            totalActivos = totalActivos.add(aportaciones).add(otrosActivos).add(propiedades).add(vehiculos);
            totalPasivos = totalPasivos.add(prestamos).add(deudaOtrasInst).add(deudaOtros);

            registrogarantiacodeudor.setRgcTotalactivo(totalActivos);
            registrogarantiacodeudor.setRgcTotalpasivo(totalPasivos);
            registrogarantiacodeudor.setRgcCapital(totalActivos.subtract(totalPasivos));
        } catch (Exception e) {

            String msge = "";
            Throwable cause = JsfUtil.getRootCause(e.getCause());
            if (cause != null) {
                msge = cause.getLocalizedMessage();
            }
            if (msge.length() > 0) {
                JsfUtil.addErrorMessage("ERROR Calculando el Capital Actual " + refPerSelected.getRpId());
            } else {
                JsfUtil.addErrorMessage(e, "ERROR " + refPerSelected.getRpId());
            }
        }

    }

    /**
     * Metodo para inicializar las listas a utilizar en los componente de la
     * vista de la Registrogarantiacodeudor de Credito
     */
    public void cargarListas() {

        try {
              tipoResidenciaList=tipoResidenciaService.findAll();
            
            
//            propiedadItems = propiedadService.findAllPropiedadesByRegistrogarantiacodeudor(registrogarantiacodeudor.get());
//            prestamoItems = prestamoService.findPrestamosByAsociado(asociado.getIdasociados());
//            prestamofinItems = prestamoFinancieroService.findPrestamosfinancierosByRegistrogarantiacodeudor(registrogarantiacodeudor.getRegistrogarantiacodeudorId());
//
//            deudaCItems = deudaService.deudasComercialesByIdAsociado();
//            deudaTItems = deudaService.deudasTarjetasByIdAsociado();
//
//            refFamItems = referenciaFamiliarService.findAllReferenciasFamiliaresByRegistrogarantiacodeudor(registrogarantiacodeudor.getRegistrogarantiacodeudorId());
//            refPerItems = referenciaPersonalService.findAllReferenciasPersonalesByRegistrogarantiacodeudor(registrogarantiacodeudor.getRegistrogarantiacodeudorId());
//            ingresos = ingresoService.findIngresosByRegistrogarantiacodeudor(registrogarantiacodeudor.getRegistrogarantiacodeudorId());
//
//            tipoEmpresaList = tipoEmpresaService.findAll();
//            formaPagoList = formaPagoService.findAll();
//            periodicidadPagoList = periodicidadPagoService.findAll();
//            promociones = promocionService.findAll();

        } catch (Exception e) {
            log.error("Error Cargando las lista necesarias para la Garantia Codeudor", e);
        }

    }

    /**
     * Metodo para redirigir de la vista de seleccion de Asesorias a la vista de
     * la registrogarantiacodeudor de Credito
     *
     * @param event Evento del boton accionado en la vista
     */
    public void toRegistroGarantiaCodeudor(ActionEvent event) {

        FacesContext contex = FacesContext.getCurrentInstance();
        registrogarantiacodeudor = new Registrogarantiacodeudor();
        String user = getUsuario();
        boolean band = true;
        try {
            if (user != null) {
//                registrogarantiacodeudor.setRgc(socio.getIdasocnatu().getDuiNombre1());
//                registrogarantiacodeudor.setRegistrogarantiacodeudorNombre2(socio.getIdasocnatu().getDuiNombre2());
//                registrogarantiacodeudor.setRegistrogarantiacodeudorApellido1(socio.getIdasocnatu().getDuiApellido1());
//                registrogarantiacodeudor.setRegistrogarantiacodeudorApellido2(socio.getIdasocnatu().getDuiApellido2());
//                registrogarantiacodeudor.setRegistrogarantiacodeudorDuilugar(socio.getIdasocnatu().getLugarExped());
//                registrogarantiacodeudor.setRegistrogarantiacodeudorDuifechaexp(new Date());
//                registrogarantiacodeudor.setRegistrogarantiacodeudorEstatuslegal(socio.getIdasocnatu().getEstatusLegal());
//                registrogarantiacodeudor.setRegistrogarantiacodeudorEstadocivil(socio.getIdasocnatu().getEstadoFam());
//                registrogarantiacodeudor.setRegistrogarantiacodeudorProfesion(socio.getIdasocnatu().getNivelEstudio());
//                registrogarantiacodeudor.setRegistrogarantiacodeudorNumdependiente(socio.getIdasocnatu().getPerdepen());
//                registrogarantiacodeudor.setRegistrogarantiacodeudorDireccionresidencia(socio.getIdasocnatu().getDireccionRes());
//                registrogarantiacodeudor.setRegistrogarantiacodeudorTiemporesidirmes(socio.getIdasocnatu().getThanios());
//                registrogarantiacodeudor.setRegistrogarantiacodeudorAportacionactivo(socio.getAportacion());
//                registrogarantiacodeudor.setRegistrogarantiacodeudorTelefono(socio.getIdasocnatu().getTelCasa1());
//                registrogarantiacodeudor.setRegistrogarantiacodeudorCelular(socio.getIdasocnatu().getTelCel1());
//                registrogarantiacodeudor.setRegistrogarantiacodeudorMontosolicitado(asesoriaSelected.getAsesoriaMonto());
//                registrogarantiacodeudor.setRegistrogarantiacodeudorPlazosolicitado(asesoriaSelected.getAsesoriaPlazo());
//                registrogarantiacodeudor.setRegistrogarantiacodeudorSueldo(asesoriaSelected.getAsesoriaIngreso());
//                registrogarantiacodeudor.setRegistrogarantiacodeudorDestino("");
//                registrogarantiacodeudor.setRegistrogarantiacodeudorDiapago(30); //revisar
//                registrogarantiacodeudor.setUsuarioRegistro(user);
//                registrogarantiacodeudor.setFechaRegistro(new Date());
//                registrogarantiacodeudor.setRegistrogarantiacodeudorCompleta(false);
               
//                getService().save(registrogarantiacodeudor);

//                if (registrogarantiacodeudor.getRegistrogarantiacodeudorId() != null) {
//                    Asesoria asesoria = asesoriaService.findAsesoriaById(registrogarantiacodeudor.getAsesoriaId().getAsesoriaId());
//                    asesoria.setRegistrogarantiacodeudorId(registrogarantiacodeudor);
//                    asesoriaService.merge(asesoria);
//                    registrogarantiacodeudor.setAsesoriaId(asesoria);
//                    asociado = asesoria.getIdasociados();
//                }
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
                contex.getExternalContext().redirect("/siacofinges/views/garantia/codeudor/index.xhtml");
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(GarantiaCodeudorManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (band) {
            try {
                contex.getExternalContext().redirect("/siacofinges/views/garantia/codeudor/codeudorIndex.xhtml");
            } catch (IOException e) {
                log.error("Error al redirigir a la pagina de Registro de Garantia Codeudor" + e);
            }
        }
    }

    /**
     * Metodo para redirigir a la vista de la registrogarantiacodeudor de credito para ser
     * modificada
     *
     * @param event
     */
    public void toRegistrarCodeudor(ActionEvent event) {
        FacesContext contex = FacesContext.getCurrentInstance();
        List<Requisitosolicitadoempleado> requisitos;
     
        ingresos = new ArrayList<Ingreso>();
        boolean band = true;
        try {
            registrogarantiacodeudor = garantiaCodeudorService.findById(getSelected().getRgcId());
//            ingresos = ingresoService.findIngresosByRegistrogarantiacodeudor(registrogarantiacodeudor.getRgcId());  //Revisar
            requisitos = requisitoSolicitadoEmpleadoService.findRequisitosByAsesoria(asesoriaSelected.getAsesoriaId());

            requisitosSeleccionados = new Requisitosolicitadoempleado[requisitos.size()];

            int i = 0;
            for (Requisitosolicitadoempleado rlce : requisitos) {
                requisitosSeleccionados[i] = rlce;
                i++;
            }
//            asociado = asociadoService.findById(registrogarantiacodeudor.getAsesoriaId().getIdasociados().getIdasociados());
//            garantiaCodeudorCompleta = registrogarantiacodeudor.getRegistrogarantiacodeudorCompleta();
            cargarListas();

        } catch (Exception e) {
            band = false;
            String msg = "";
            Throwable cause = JsfUtil.getRootCause(e.getCause());
            if (cause != null) {
                msg = cause.getLocalizedMessage();
            }
            if (msg.length() > 0) {
                JsfUtil.addErrorMessage("Error al editar la registrogarantiacodeudor de Credito ");
            } else {
                JsfUtil.addErrorMessage(e, "Error al editar la registrogarantiacodeudor de Credito  ");
            }

            try {
                contex.getExternalContext().redirect("/siacofinges/views/garantia/codeudor/index.xhtml");
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(GarantiaCodeudorManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (band) {
            try {
                contex.getExternalContext().redirect("/siacofinges/views/garantia/codeudor/form.xhtml");
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(GarantiaCodeudorManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Metodo para actualizar la registrogarantiacodeudor con los datos ingresados
     *
     * @param event
     */
    public void update(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();

            if (garantiaCodeudorCompleta) {
//                registrogarantiacodeudor.setRegistrogarantiacodeudorCompleta(true);
            } else {
//                registrogarantiacodeudor.setRegistrogarantiacodeudorCompleta(false);
            }
            
            try {
                
                codeudor.setUsuarioRegistro(getUsuario());
                codeudor.setFechaRegistro(new Date());
                codeudorService.save(codeudor);
                Analisis analisis =analisisService.findById(idAnalisis);
                registrogarantiacodeudor.setAnalisisId(analisis);
                registrogarantiacodeudor.setCodeudorId(codeudor);
                registrogarantiacodeudor.setUsuarioRegistro(getUsuario());
                registrogarantiacodeudor.setFechaRegistro(new Date());
                registrogarantiacodeudor.setRgcFechacreacion(new Date());
                garantiaCodeudorService.save(registrogarantiacodeudor);
                registrogarantiacodeudor = null;
                asesoriaSelected = null;
                garantiaCodeudorCompleta = false;
            } catch (Exception e) {
                System.out.println("Error"+e);
                JsfUtil.addErrorMessage("Error al guardar la garantia Codeudor");
            }
     
            try {
                cargarCodeudores(idAnalisis);
                JsfUtil.addSuccessMessage("Operacion realizada con Exito");
                contex.getExternalContext().redirect("/siacofinges/views/garantia/codeudor/index.xhtml");
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(GarantiaCodeudorManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (HibernateException e) {
            log.debug("Error al actualizar la registrogarantiacodeudor de Credito " + e);
            manejaException(e);
        }
    }

    /**
     * Metodo para el registrar el cumplimiento de los documentos solicitados en
     * la asesoria de Credito
     *
     */
    public void documentosRecibidos() {
//        requisitosItems = requisitoSolicitadoEmpleadoService.findRequisitosByAsesoria(registrogarantiacodeudor.getAsesoriaId().getAsesoriaId());

    }

    /**
     * Metodo para el actualizar los documentos y marcarlos como recibidos
     *
     * @param event
     */
    public void updateDocumentosRecibido(ActionEvent event) {
//        requisitoSolicitadoEmpleadoService.updateRequisitosByAsesoria(requisitosSeleccionados, registrogarantiacodeudor.getAsesoriaId().getAsesoriaId());
    }

    /**
     * Metodo para redirigir de la vista de seleccion de Asesorias
     *
     * @param event Evento del boton accionado en la vista
     */
    public void cancelar(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            getSelected().setRgcId(null);
            asesoriaService.merge(asesoriaSelected);
            getService().delete(registrogarantiacodeudor);
            registrogarantiacodeudor = null;
            setSelected(null);
            try {
                cargarCodeudores(idGarantiaCodeudor);
                contex.getExternalContext().redirect("/siacofinges/views/garantia/codeudor/index.xhtml");
            } catch (IOException ex) {
                log.debug("Error al redirigir a el listado de Garantias Codeudor" + ex);
            }

        } catch (HibernateException e) {
            log.debug("Error al actualizar la registrogarantiacodeudor de Credito " + e);
            manejaException(e);
        }
    }
    
    
    public void cancelar1(ActionEvent event) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect(urlgarantias);

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(GarantiaCodeudorManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*LAZY MODELS */
    @Override
    public LazyDataModel<Registrogarantiacodeudor> getNewLazyModel() {
        return null;
    }

    public LazyDataModel<Propiedad> getPropiedadLazyModel() {
//        propiedadItems = propiedadService.findAllPropiedadesByRegistrogarantiacodeudor(this.registrogarantiacodeudor.getRgcId());
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
    public Registrogarantiacodeudor getRegistrogarantiacodeudor() {
        return registrogarantiacodeudor;
    }

    public void setRegistrogarantiacodeudor(Registrogarantiacodeudor registrogarantiacodeudor) {
        this.registrogarantiacodeudor = registrogarantiacodeudor;
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

    public boolean isGarantiaCodeudorCompleta() {
        return garantiaCodeudorCompleta;
    }

    public void setGarantiaCodeudorCompleta(boolean garantiaCodeudorCompleta) {
        this.garantiaCodeudorCompleta = garantiaCodeudorCompleta;
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
    public GenericService<Registrogarantiacodeudor, Integer> getService() {
        return garantiaCodeudorService;
    }

    public Prestamofinanciero getPrestamofinSelected() {
        return prestamofinSelected;
    }

    public void setPrestamofinSelected(Prestamofinanciero prestamofinSelected) {
        this.prestamofinSelected = prestamofinSelected;
    }

    public List<Prestamofinanciero> getPrestamofinItems() {
        return prestamofinItems;
    }

    public void setPrestamofinItems(List<Prestamofinanciero> prestamofinItems) {
        this.prestamofinItems = prestamofinItems;
    }

    public LazyDataModel<Prestamofinanciero> getPrestamofinLazyItems() {
        return prestamofinLazyItems;
    }

    public void setPrestamofinLazyItems(LazyDataModel<Prestamofinanciero> prestamofinLazyItems) {
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

    public Integer getIdGarantiaCodeudor() {
        return idGarantiaCodeudor;
    }

    public void setIdGarantiaCodeudor(Integer idGarantiaCodeudor) {
        this.idGarantiaCodeudor = idGarantiaCodeudor;
    }

    public List<Registrogarantiacodeudor> getListaCodeudores() {
        return listaCodeudores;
    }

    public void setListaCodeudores(List<Registrogarantiacodeudor> listaCodeudores) {
        this.listaCodeudores = listaCodeudores;
    }

    public Codeudor getCodeudor() {
        return codeudor;
    }

    public void setCodeudor(Codeudor codeudor) {
        this.codeudor = codeudor;
    }

    public List<Tiporesidencia> getTipoResidenciaList() {
        return tipoResidenciaList;
    }

    public void setTipoResidenciaList(List<Tiporesidencia> tipoResidenciaList) {
        this.tipoResidenciaList = tipoResidenciaList;
    }

    public Tiporesidencia getTipoResidenciaSelect() {
        return tipoResidenciaSelect;
    }

    public void setTipoResidenciaSelect(Tiporesidencia tipoResidenciaSelect) {
        this.tipoResidenciaSelect = tipoResidenciaSelect;
    }

    public String getCodigoAsociado() {
        return codigoAsociado;
    }

    public void setCodigoAsociado(String codigoAsociado) {
        this.codigoAsociado = codigoAsociado;
    }

    public Integer getIdAnalisis() {
        return idAnalisis;
    }

    public void setIdAnalisis(Integer idAnalisis) {
        this.idAnalisis = idAnalisis;
    }

    public Integer getIdTipoGarantia() {
        return idTipoGarantia;
    }

    public void setIdTipoGarantia(Integer idTipoGarantia) {
        this.idTipoGarantia = idTipoGarantia;
    }

    public String getNombreAsociado() {
        return nombreAsociado;
    }

    public void setNombreAsociado(String nombreAsociado) {
        this.nombreAsociado = nombreAsociado;
    }

    public String getCodigoSocio() {
        return codigoSocio;
    }

    public void setCodigoSocio(String codigoSocio) {
        this.codigoSocio = codigoSocio;
    }

    public String getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public void setCodigoSolicitud(String codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }

    public SelectItem[] getEstadoCivilOptions() {
        return estadoCivilOptions;
    }

    public void setEstadoCivilOptions(SelectItem[] estadoCivilOptions) {
        this.estadoCivilOptions = estadoCivilOptions;
    }

    public SelectItem[] getEstatusLegalOptions() {
        return estatusLegalOptions;
    }

    public void setEstatusLegalOptions(SelectItem[] estatusLegalOptions) {
        this.estatusLegalOptions = estatusLegalOptions;
    }

    public SelectItem[] getProfesionesOptions() {
        return profesionesOptions;
    }

    public void setProfesionesOptions(SelectItem[] profesionesOptions) {
        this.profesionesOptions = profesionesOptions;
    }

    
    
    
    
}
