package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.AsesoriaLazyModel;
import com.siapa.managedbean.lazymodel.RequisitosLineaCreditoLazyModel;
import com.siapa.model.Asesoria;
import com.siapa.model.Asociados;
import com.siapa.model.Detallelineacredito;
import com.siapa.model.Formapago;
import com.siapa.model.Garantia;
import com.siapa.model.Garantiaexigida;
import com.siapa.model.Lineacredito;
import com.siapa.model.Periodicidadpago;
import com.siapa.model.PrestamosAsociados;
import com.siapa.model.Promocion;
import com.siapa.model.Requisitolineacreditoempleado;
import com.siapa.model.ResumenCrediticio;
import com.siapa.model.Tipoasesoria;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.service.AsesoriaService;
import com.siapa.service.AsociadoService;
import com.siapa.service.ConfiguracionSistemaService;
import com.siapa.service.DetalleLineaCreditoService;
import com.siapa.service.FormaPagoService;
import com.siapa.service.GarantiaAsignadaAsesoriaService;
import com.siapa.service.GarantiaExigidaService;
import com.siapa.service.GarantiaService;
import com.siapa.service.LineaCreditoService;
import com.siapa.service.PeriodicidadPagoService;
import com.siapa.service.PrestamoService;
import com.siapa.service.PromocionService;
import com.siapa.service.RequisitoLineaCreditoEmpleadoService;
import com.siapa.service.RequisitoSolicitadoEmpleadoService;
import com.siapa.service.TipoAsesoriaService;
import com.siapa.service.generic.GenericService;
import com.siapa.utils.FormulasHelper;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.validation.ValidationException;
import org.primefaces.event.CellEditEvent;
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
@Named("asesoriaManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class AsesoriaManagedBean extends GenericManagedBean<Asesoria, Integer> {

    public static Logger log = LoggerFactory.getLogger(SolicitudManagedBean.class.getName());

    @Autowired
    @Qualifier(value = "asesoriaService")
    private AsesoriaService asesoriaService;
    @Autowired
    @Qualifier(value = "asociadoService")
    private AsociadoService asociadoService;
    @Autowired
    @Qualifier(value = "requisitoLineaCreditoEmpleadoService")
    private RequisitoLineaCreditoEmpleadoService requisitoLineaCreditoEmpleadoService;
    @Autowired
    @Qualifier(value = "requisitoSolicitadoEmpleadoService")
    private RequisitoSolicitadoEmpleadoService requisitoSolicitadoEmpleadoService;
    @Autowired
    @Qualifier(value = "lineaCreditoService")
    private LineaCreditoService lineaCreditoService;
    @Autowired
    @Qualifier(value = "promocionService")
    private PromocionService promocionService;
    @Autowired
    @Qualifier(value = "prestamoService")
    private PrestamoService prestamoService;
    @Autowired
    @Qualifier(value = "formaPagoService")
    private FormaPagoService formaPagoService;
    @Autowired
    @Qualifier(value = "periodicidadPagoService")
    private PeriodicidadPagoService periodicidadPagoService;
    @Autowired
    @Qualifier(value = "detalleLineaCreditoService")
    private DetalleLineaCreditoService detalleLineaCreditoService;
    @Autowired
    @Qualifier(value = "configuracionSistemaService")
    private ConfiguracionSistemaService configuracionSistemaService;
    @Autowired
    @Qualifier(value = "tipoAsesoriaService")
    private TipoAsesoriaService tipoAsesoriaService;
    @Autowired
    @Qualifier(value = "garantiaExigidaService")
    private GarantiaExigidaService garantiaExigidaService;
    @Autowired
    @Qualifier(value = "garantiaService")
    private GarantiaService garantiaService;
    @Autowired
    @Qualifier(value = "garantiaAsignadaAsesoriaService")
    private GarantiaAsignadaAsesoriaService garantiaAsignadaAsesoriaService;
    

    /*    Objetos Utilizados */
    private Asociados asociado;
    private String codigoAsociado;
    private String nombreAsociado;
    private Asesoria asesoria;
    private ResumenCrediticio resumenCrediticio;
    private boolean hipotecario = true;
    private boolean isCompleta;
    private Detallelineacredito detalleLineaCredito;

    // selectManyCheckbox
    private Requisitolineacreditoempleado[] requisitosSeleccionados;
    private List<Requisitolineacreditoempleado> requisitosItems;
    private LazyDataModel<Requisitolineacreditoempleado> requisitoslazyItems;

    //  combos 
    private List<Promocion> promociones;
    private List<Promocion> promocionesSelecionadas;

    private Lineacredito lineaCreditoSelect;
    private List<Lineacredito> lineasCreditoListComb;

    private List<Formapago> formaPagoList;
    private Formapago formaPagoSeleccionada;

    private List<Periodicidadpago> periodicidadPagoList;
    private Periodicidadpago periodicidadPagoSeleccionada;

    private List<Tipoasesoria> tipoasesoriaList;
    private Tipoasesoria tipoAsesoriaSeleccionada;

    private List<Garantiaexigida> garantiasExigidasList;
    private List<Garantia> garantiasList;
    private Garantia[] garantiasSeleccionadas;
    
    //variables
    private BigDecimal recalMonto;
    private Integer recalPlazo;
    private BigDecimal recalCuota;
    private boolean edit;
    private boolean bandasignarGarantia;
    private boolean bandCalcularAsignarGarantia;
    private String categoria;
    
    //Configuracion Sistema
    @PostConstruct
    public void init() {
        loadLazyModels();
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
            crearResumenCrediticio(asociado);

            if (asociado == null) {
                asociado = new Asociados();
                JsfUtil.addErrorMessage("ERROR:", "No se encontro un Asociado con el codigo " + codigoAsociado);
                categoria="";
            } else {
                asesoria.setIdasociados(asociado);
                categoria="A";
                JsfUtil.addSuccessMessage("Correcto ", "Asociado encontrado " + codigoAsociado);
            }

        } catch (ValidationException ve) {
            String msj = "Error realizando busqueda de el asociado v: " + ve.getCause();
            JsfUtil.addErrorMessage(msj);
        } catch (Exception e) {
            String msj = "Error realizando busqueda de el asociado: " + e.getCause();
            JsfUtil.addErrorMessage(msj);
        }
    }

    /**
     * Metodo para redirigir a la vista de creacion de asesorias
     *
     * @param event Evento del boton accionado en la vista
     */
    public void toCreateAsesoria(ActionEvent event) {
        try {
            asesoria = null;
            FacesContext contex = FacesContext.getCurrentInstance();
            asesoria = new Asesoria();
            cargarListas();
            bandCalcularAsignarGarantia=true;
            contex.getExternalContext().redirect("/siacofinges/views/asesoria/create.xhtml");
        } catch (IOException ex) {
            log.error("Error al rederigir a la pagina de asesoria", null, ex);
        }
    }

    /**
     * Metodo para cargar las listas necesarias para los combos de la asesoria
     * de credito
     */
    public void cargarListas() {
        promociones = promocionService.findAll();
        lineasCreditoListComb = lineaCreditoService.findAllActives();
        formaPagoList = formaPagoService.findAll();
        periodicidadPagoList = periodicidadPagoService.findAll();
        tipoasesoriaList = tipoAsesoriaService.findAll();
    }

    /**
     * Metodo para asignar valores en el dialogo de asignar asesoria
     *
     */
    public void dialogAsignarAsesoria() {
        codigoAsociado=asesoria.getIdasociados().getCodigo();
        nombreAsociado=asesoria.getIdasociados().getIdasocnatu().getNombreCompleto();
        
        if (!bandasignarGarantia) {
            garantiasExigidasList = garantiaExigidaService.findByDlcId(detalleLineaCredito.getDetallelineacreditoId());
            garantiasList = garantiaService.findAll();
        }
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
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
     
    /**
     *
     * @param event
     */
    public void onselect(SelectEvent event) {

    }
    
    /**
     *Metodo para guardar la asignacion de garantias a una asesoria
     * @param event
     */
    public void guardarAsignacion(ActionEvent event) {
        bandasignarGarantia=true;
    }

    /**
     * Metodo para almacenar una Asesoria de Credito y asociarla a un
     * determinado asociado
     *
     *
     * @param event Evento del boton accionado en la vista
     */
    public void saveAsesoria(ActionEvent event) {
        try {
            FacesContext contex=FacesContext.getCurrentInstance();
            
            if (getUsuario() != null) {

                String msj = "Guardado con exito";
                
                if(isCompleta){asesoria.setAsesoriaCompleta(true);}else{asesoria.setAsesoriaCompleta(false);}
                
                    asesoria.setPromocionList(new HashSet<Promocion>(promocionesSelecionadas));
                
                if (!edit) {
                    asesoria.setUsuarioRegistro(getUsuario());
                    asesoria.setFechaRegistro(new Date());
                    getAsesoriaService().save(asesoria);
                    categoria = "";
                } else {
                    asesoria.setUsuarioUltimamodificacion(getUsuario());
                    asesoria.setFechaUltimamodificacion(new Date());
                    getAsesoriaService().merge(asesoria);
                    categoria = "";
                }
                guardarDocumentos(asesoria, requisitosSeleccionados);
                guardarGarantias(asesoria,garantiasList);
                limpiar();
                JsfUtil.addSuccessMessage("Correcto", msj);
            }
            contex.getExternalContext().redirect("/siacofinges/views/asesoria/index.xhtml");
        } catch (IOException e) {
            JsfUtil.addErrorMessage("Error", "Almacenando asesoria");
            log.error("Error almacenando la asesoria" + e.getCause());
        }
      
    }

    /**
     * Metodo para guardar los requisitos asociados a una asesoria
     * @param asesoria
     * @param requisitosSeleccionados 
     */
    public void guardarDocumentos(Asesoria asesoria, Requisitolineacreditoempleado[] requisitosSeleccionados) {
        try {
            requisitoSolicitadoEmpleadoService.saveDocumentos(asesoria, requisitosSeleccionados);
        } catch (Exception e) {
            log.error("ERROR " + e.getCause());

        }
    }
    
    /**
     * Metodo para guardar la asignacion de garantias a una asesoria
     * @param asesoria
     * @param garantias
     */
    public void guardarGarantias(Asesoria asesoria, List<Garantia> garantias) {
        try {
            garantiaAsignadaAsesoriaService.saveGarantiasAsignadas(asesoria, garantias);
        } catch (Exception e) {
            log.error("ERROR " + e.getCause());

        }
    }
    
    public void limpiar(){
       asociado=null;     
       asesoria=null;
       requisitosSeleccionados=null;
       requisitosItems=null;
       lineaCreditoSelect=null;
       hipotecario=false;
       detalleLineaCredito=null;
       requisitosItems=null;
       formaPagoSeleccionada=null;
       formaPagoList=null;
       periodicidadPagoSeleccionada=null;
       periodicidadPagoList=null;
       tipoAsesoriaSeleccionada=null;
       tipoasesoriaList=null;
       garantiasSeleccionadas=null;
       garantiasList=null;
       promocionesSelecionadas=null;
       promociones=null;
       codigoAsociado=null;
       lineasCreditoListComb=null;
       garantiasList=null;
       bandasignarGarantia=false;
       bandCalcularAsignarGarantia=false;
       setSelected(null);
       categoria="";
       }

    /**
     * Metodo para establecer los requisitos solicitados al asociado en base a
     * la linea de credito
     */
    public void establecerRequisitos() {

        asesoria.setAsesoriaValorpropiedad(null);
        asesoria.setAsesoriaValorconstruccion(null);
        asesoria.setAsesoriaValorcompraventa(null);
        asesoria.setAsesoriaValorhipotecaactual(null);
        asesoria.setAsesoriaValorhipotecaanterior(null);
        asesoria.setAsesoriaHonorariovaluo(null);
        asesoria.setAsesoriaCancelacionhipoteca(BigDecimal.ZERO);
        asesoria.setAsesoriaComisionotorgamiento(BigDecimal.ZERO);
        asesoria.setAsesoriaImpuestohipoteca(BigDecimal.ZERO);
        asesoria.setAsesoriaImpuestocompraventa(BigDecimal.ZERO);
        asesoria.setAsesoriaImpuestotransferencia(BigDecimal.ZERO);
        asesoria.setAsesoriaSegurodanio(BigDecimal.ZERO);
        
        if (lineaCreditoSelect != null) {
            hipotecario = lineaCreditoSelect.getLineacreditoId() != 2;
            
            detalleLineaCredito = detalleLineaCreditoService.getDetalleLineaCredito(lineaCreditoSelect.getLineacreditoId(), asesoria.getAsesoriaMonto());
            
            if (asesoria.getAsesoriaMonto().compareTo(detalleLineaCredito.getDetallelineacreditoMonto()) == 1) {
                  bandCalcularAsignarGarantia=true;
                  JsfUtil.addErrorMessage("Monto", "El Monto Solicitado es mayor que el maximo de la Linea de Credito Solicitado");
            } else {
                bandCalcularAsignarGarantia=false;
            }

            if (detalleLineaCredito == null) {
                detalleLineaCredito = new Detallelineacredito();
            }else{
                 asesoria.setDetallelineacreditoId(detalleLineaCredito);
                 asesoria.setAsesoriaTasa(detalleLineaCredito.getDetallelineacreditoTasa());
            }
            
            
            
        } else {
            detalleLineaCredito = new Detallelineacredito();
        }

        requisitosItems = requisitoLineaCreditoEmpleadoService
                .findRequisitosByIdEmpleado(lineaCreditoSelect
                        .getLineacreditoId());

    }

    /**
     * Metodo para crear el apartado de la asesoria de el resumen crediticio del
     * asociado
     *
     * @param asociado
     */
    public void crearResumenCrediticio(Asociados asociado) {
        resumenCrediticio = new ResumenCrediticio();

        BigDecimal saldo = BigDecimal.ZERO;
        BigDecimal cuota = BigDecimal.ZERO;
        BigDecimal saldoC = BigDecimal.ZERO;
        
        int numeroPrestamoDeudor = 0;
        int numeroPrestamoCodeudor = 0;
        
        
        List<PrestamosAsociados> prestamos;
        prestamos = prestamoService.findPrestamosByAsociadoRc(asociado.getIdasociados());
       
        
        for (PrestamosAsociados p : prestamos) {
            if (p.getTipo().equals("D")) {
                saldo = saldo.add(p.getPrestamo().getPrestamoSaldo());
                cuota = cuota.add(p.getPrestamo().getPrestamoCuota());
                numeroPrestamoDeudor++;
            } else {
                saldoC = saldoC.add(p.getPrestamo().getPrestamoSaldo());
                numeroPrestamoCodeudor++;
            }
        }
        
        resumenCrediticio.setSaldoActualDeudor(saldo);
        resumenCrediticio.setNumeroPrestamoDeudor(numeroPrestamoDeudor);
        resumenCrediticio.setSumatoriaCuotas(cuota);
        
        resumenCrediticio.setSaldoActualCodeudor(saldoC);
        resumenCrediticio.setNumeroPrestamoCodeudor(numeroPrestamoCodeudor);


    }

//  CALCULOS DE CUOTA Y GASTOS ESTIMADOS SEGUN LINEA DE CREDITO
    /**
     * Metodo para calcular la cuota que desea el asociado en base a la liena de
     * credito
     */
    public void calcularCuotaGastos() {

        try {

            Integer lcvivienda = configuracionSistemaService.findValueInteger("lc.vivienda");
            Integer linea=0;
            BigDecimal monto = asesoria.getAsesoriaMonto() == null ? BigDecimal.ZERO : asesoria.getAsesoriaMonto();
            BigDecimal interes = detalleLineaCredito.getDetallelineacreditoTasa() == null ? BigDecimal.ZERO : detalleLineaCredito.getDetallelineacreditoTasa();
            Integer plazo = asesoria.getAsesoriaPlazo();
            BigDecimal cuota;
            BigDecimal seguroDeuda;
            BigDecimal seguroDanio=BigDecimal.ZERO;
            
            BigDecimal complementoAportacion;
            BigDecimal impuestoHipoteca=BigDecimal.ZERO;
            BigDecimal impuestoCompraventa=BigDecimal.ZERO;
            BigDecimal impuestoTransferencia=BigDecimal.ZERO;
            BigDecimal gastoTotal;
            BigDecimal  cancelacionHipoteca=BigDecimal.ZERO;
            BigDecimal comisionxotorgamiento=BigDecimal.ZERO;
            
            asesoria.setAsesoriaCancelacionhipoteca(BigDecimal.ZERO);
            asesoria.setAsesoriaComisionotorgamiento(BigDecimal.ZERO);
            asesoria.setAsesoriaImpuestohipoteca(BigDecimal.ZERO);
            asesoria.setAsesoriaImpuestocompraventa(BigDecimal.ZERO);
            asesoria.setAsesoriaImpuestotransferencia(BigDecimal.ZERO);
            asesoria.setAsesoriaSegurodanio(BigDecimal.ZERO);
            
            if (asesoria.getAsesoriaPlazo() > 0) {
                
                cuota = FormulasHelper.cuotaCredito(monto, interes, plazo);
                asesoria.setAsesoriaCapitalinteres(cuota);
                seguroDeuda=FormulasHelper.seguroDeuda(monto);
                asesoria.setAsesoriaSegurodeuda(seguroDeuda);
                
                complementoAportacion=FormulasHelper.calculoComplementoAportacion(monto,asesoria.getIdasociados().getAportacion());
                asesoria.setAsesoriaRelacionaportacion(complementoAportacion);
                
                switch (lineaCreditoSelect.getLineacreditoId().intValue()) {
                    case 1: {
                        
                        

                          break;
                    }
                    case 2: {
                        seguroDanio = FormulasHelper.seguroDanios(asesoria.getAsesoriaValorconstruccion());
                        impuestoHipoteca = FormulasHelper.impuestoHipoteca(monto);
                        impuestoCompraventa = FormulasHelper.impuestoCompraVenta(asesoria.getAsesoriaValorpropiedad());
                        impuestoTransferencia = FormulasHelper.impuestoTransferencia(monto);
                        
                        asesoria.setAsesoriaSegurodanio(seguroDanio);
                        asesoria.setAsesoriaImpuestohipoteca(impuestoHipoteca);
                        asesoria.setAsesoriaImpuestocompraventa(impuestoCompraventa);
                        asesoria.setAsesoriaImpuestotransferencia(impuestoTransferencia);
                        
                        break;
                    }
                    case 3: {

                            break;
                    }
                    case 4: {
                            break;
                    }
                    case 5: {
                            break;
                    }
                    case 6: {
                            break;
                    }
                    case 7: {
                        
                            break;
                    }
                    case 8: {
                            break;
                    }
                    case 9: {
                            break;
                    }
                    case 10: {
                            break;
                    }
                }
                gastoTotal = FormulasHelper.calculoGastosTotales(complementoAportacion, comisionxotorgamiento, impuestoHipoteca, cancelacionHipoteca, impuestoCompraventa, impuestoTransferencia);
                asesoria.setAsesoriaCuota(cuota.add(seguroDeuda).add(seguroDanio));
                asesoria.setAsesoriaTotalgasto(gastoTotal);
            } else {
                JsfUtil.addErrorMessage("Plazo", "Debe ser mayor que 0");
            }
            
        } catch (Exception e) {
            JsfUtil.addErrorMessage("ERROR", "General");
            log.error("ERROR : " + e);
        }

    }

    /**
     * Metodo para calcular la cuota de credito con la definicion de nuevos
     * parametros de el credito
     *
     * @param event evento del boton presionado en la capa de la vista
     */
    public void reCalcular(ActionEvent event) {
        BigDecimal interes;
        try {
            BigDecimal seguroDeuda;
            BigDecimal seguroDanio;
            
            Integer lcvivienda = configuracionSistemaService.findValueInteger("lc.vivienda");
            interes = detalleLineaCredito.getDetallelineacreditoTasa() == null ? BigDecimal.ZERO : detalleLineaCredito.getDetallelineacreditoTasa();
            if (interes == null) {
                JsfUtil.addErrorMessage("ERROR", "Favor Seleccione una Linea de Credito en la seccion Parametros de Credito");
            } else {

                if (recalMonto != null && recalPlazo != null) {
                    recalCuota = FormulasHelper.cuotaCredito(recalMonto, interes, recalPlazo);
                    seguroDeuda = FormulasHelper.seguroDeuda(recalMonto);
                    recalCuota = recalCuota.add(seguroDeuda);
           
                    switch (lineaCreditoSelect.getLineacreditoId().intValue()) {
                        case 1: {

                            break;
                        }
                        case 2: {
                            seguroDanio = FormulasHelper.seguroDanios(asesoria.getAsesoriaValorconstruccion());
                            recalCuota = recalCuota.add(seguroDanio);
                            break;
                        }
                        case 3: {
                            break;
                        }
                        case 4: {
                            break;
                        }
                        case 5: {
                            break;
                        }
                        case 6: {
                            break;
                        }
                        case 7: {

                            break;
                        }
                        case 8: {
                            break;
                        }
                        case 9: {
                            break;
                        }
                        case 10: {
                            break;
                        }
                    }

                } else {
                    JsfUtil.addErrorMessage("ERROR", "Favor Ingrese los parametros requeridos");
                }

            }

        } catch (Exception e) {
            log.error("Error " + e.getCause());
            JsfUtil.addErrorMessage("ERROR", "Favor Seleccione una Linea de Credito en la seccion Parametros de Credito");
        }

    }

    /**
     * Metodo para redirigir a la pagina de edicion de una asesoria
     * @param event 
     */
    public void toEdit(ActionEvent event) {

        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            cargarListas();
            List<Requisitolineacreditoempleado> rqitems=new ArrayList<Requisitolineacreditoempleado>();
            promocionesSelecionadas=new ArrayList<Promocion>();
            edit=true; 
            asesoria=asesoriaService.findAsesoriaById(getSelected().getAsesoriaId());
            promocionesSelecionadas.addAll(asesoria.getPromocionList());
            asociado=asesoria.getIdasociados();
            codigoAsociado=asociado.getCodigo();
            periodicidadPagoSeleccionada=asesoria.getPpId();
            tipoAsesoriaSeleccionada=asesoria.getTaId();
            formaPagoSeleccionada=asesoria.getFpId();
            detalleLineaCredito=asesoria.getDetallelineacreditoId();
             
            if(detalleLineaCredito!=null){
               lineaCreditoSelect=detalleLineaCredito.getLineacreditoId();
               hipotecario = lineaCreditoSelect.getLineacreditoId() != 2;
               requisitosItems=lineaCreditoSelect.getRequisitolineacreditoempleadoList();
            }
            
            rqitems=requisitoSolicitadoEmpleadoService.findRequisitosLineaCreditoByAsesoria(asesoria.getAsesoriaId());
            requisitosSeleccionados=new Requisitolineacreditoempleado[rqitems.size()];
            int i=0;
            for(Requisitolineacreditoempleado rlce:rqitems){
               requisitosSeleccionados[i] =rlce;
               i++;
            }
            isCompleta = asesoria.getAsesoriaCompleta();
             categoria="";
            contex.getExternalContext().redirect("/siacofinges/views/asesoria/edit.xhtml");
        } catch (IOException ex) {
            log.error("Error al rederigir a la pagina de asesoria", null, ex);
        }
    }

    @Override
    public GenericService<Asesoria, Integer> getService() {
        return asesoriaService;
    }

    @Override
    public LazyDataModel<Asesoria> getNewLazyModel() {
        return new AsesoriaLazyModel(asesoriaService);
    }

    public LazyDataModel<Requisitolineacreditoempleado> getRequisitosLazyModel() {
        return new RequisitosLineaCreditoLazyModel(requisitoLineaCreditoEmpleadoService);
    }

    public LazyDataModel<Requisitolineacreditoempleado> getRequisitoslazyItems() {
        return requisitoslazyItems;
    }

    public void setRequisitoslazyItems(LazyDataModel<Requisitolineacreditoempleado> requisitoslazyItems) {
        this.requisitoslazyItems = requisitoslazyItems;
    }

    public AsesoriaService getAsesoriaService() {
        return asesoriaService;
    }

    public void setAsesoriaService(AsesoriaService asesoriaService) {
        this.asesoriaService = asesoriaService;
    }

    public AsociadoService getAsociadoService() {
        return asociadoService;
    }

    public void setAsociadoService(AsociadoService asociadoService) {
        this.asociadoService = asociadoService;
    }

    public Asociados getAsociado() {
        return asociado;
    }

    public void setAsociado(Asociados asociado) {
        this.asociado = asociado;
    }

    public String getCodigoAsociado() {
        return codigoAsociado;
    }

    public void setCodigoAsociado(String codigoAsociado) {
        this.codigoAsociado = codigoAsociado;
    }

    public Asesoria getAsesoria() {
        return asesoria;
    }

    public void setAsesoria(Asesoria asesoria) {
        this.asesoria = asesoria;
    }

    public Requisitolineacreditoempleado[] getRequisitosSeleccionados() {
        return requisitosSeleccionados;
    }

    public void setRequisitosSeleccionados(Requisitolineacreditoempleado[] requisitosSeleccionados) {
        this.requisitosSeleccionados = requisitosSeleccionados;
    }

    public RequisitoLineaCreditoEmpleadoService getRequisitoLineaCreditoEmpleadoService() {
        return requisitoLineaCreditoEmpleadoService;
    }

    public void setRequisitoLineaCreditoEmpleadoService(RequisitoLineaCreditoEmpleadoService requisitoLineaCreditoEmpleadoService) {
        this.requisitoLineaCreditoEmpleadoService = requisitoLineaCreditoEmpleadoService;
    }

    public List<Requisitolineacreditoempleado> getRequisitosItems() {
        return requisitosItems;
    }

    public void setRequisitosItems(List<Requisitolineacreditoempleado> requisitosItems) {
        this.requisitosItems = requisitosItems;
    }

    public RequisitoSolicitadoEmpleadoService getRequisitoSolicitadoEmpleadoService() {
        return requisitoSolicitadoEmpleadoService;
    }

    public void setRequisitoSolicitadoEmpleadoService(RequisitoSolicitadoEmpleadoService requisitoSolicitadoEmpleadoService) {
        this.requisitoSolicitadoEmpleadoService = requisitoSolicitadoEmpleadoService;
    }

    public PromocionService getPromocionService() {
        return promocionService;
    }

    public void setPromocionService(PromocionService promocionService) {
        this.promocionService = promocionService;
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

    public LineaCreditoService getLineaCreditoService() {
        return lineaCreditoService;
    }

    public void setLineaCreditoService(LineaCreditoService lineaCreditoService) {
        this.lineaCreditoService = lineaCreditoService;
    }

    public Lineacredito getLineaCreditoSelect() {
        return lineaCreditoSelect;
    }

    public void setLineaCreditoSelect(Lineacredito lineaCreditoSelect) {
        this.lineaCreditoSelect = lineaCreditoSelect;
    }

    public List<Lineacredito> getLineasCreditoListComb() {
        return lineasCreditoListComb;
    }

    public void setLineasCreditoListComb(List<Lineacredito> lineasCreditoListComb) {
        this.lineasCreditoListComb = lineasCreditoListComb;
    }

    public PrestamoService getPrestamoService() {
        return prestamoService;
    }

    public void setPrestamoService(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    public ResumenCrediticio getResumenCrediticio() {
        return resumenCrediticio;
    }

    public void setResumenCrediticio(ResumenCrediticio resumenCrediticio) {
        this.resumenCrediticio = resumenCrediticio;
    }

    public FormaPagoService getFormaPagoService() {
        return formaPagoService;
    }

    public void setFormaPagoService(FormaPagoService formaPagoService) {
        this.formaPagoService = formaPagoService;
    }

    public PeriodicidadPagoService getPeriodicidadPagoService() {
        return periodicidadPagoService;
    }

    public void setPeriodicidadPagoService(PeriodicidadPagoService periodicidadPagoService) {
        this.periodicidadPagoService = periodicidadPagoService;
    }

    public List<Formapago> getFormaPagoList() {
        return formaPagoList;
    }

    public void setFormaPagoList(List<Formapago> formaPagoList) {
        this.formaPagoList = formaPagoList;
    }

    public Formapago getFormaPagoSeleccionada() {
        return formaPagoSeleccionada;
    }

    public void setFormaPagoSeleccionada(Formapago formaPagoSeleccionada) {
        this.formaPagoSeleccionada = formaPagoSeleccionada;
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

    public boolean isHipotecario() {
        return hipotecario;
    }

    public void setHipotecario(boolean hipotecario) {
        this.hipotecario = hipotecario;
    }

    public DetalleLineaCreditoService getDetalleLineaCreditoService() {
        return detalleLineaCreditoService;
    }

    public void setDetalleLineaCreditoService(DetalleLineaCreditoService detalleLineaCreditoService) {
        this.detalleLineaCreditoService = detalleLineaCreditoService;
    }

    public Detallelineacredito getDetalleLineaCredito() {
        return detalleLineaCredito;
    }

    public void setDetalleLineaCredito(Detallelineacredito detalleLineaCredito) {
        this.detalleLineaCredito = detalleLineaCredito;
    }

    public ConfiguracionSistemaService getConfiguracionSistemaService() {
        return configuracionSistemaService;
    }

    public void setConfiguracionSistemaService(ConfiguracionSistemaService configuracionSistemaService) {
        this.configuracionSistemaService = configuracionSistemaService;
    }

    public BigDecimal getRecalMonto() {
        return recalMonto;
    }

    public void setRecalMonto(BigDecimal recalMonto) {
        this.recalMonto = recalMonto;
    }

    public Integer getRecalPlazo() {
        return recalPlazo;
    }

    public void setRecalPlazo(Integer recalPlazo) {
        this.recalPlazo = recalPlazo;
    }

    public BigDecimal getRecalCuota() {
        return recalCuota;
    }

    public void setRecalCuota(BigDecimal recalCuota) {
        this.recalCuota = recalCuota;
    }

    public TipoAsesoriaService getTipoAsesoriaService() {
        return tipoAsesoriaService;
    }

    public void setTipoAsesoriaService(TipoAsesoriaService tipoAsesoriaService) {
        this.tipoAsesoriaService = tipoAsesoriaService;
    }

    public List<Tipoasesoria> getTipoasesoriaList() {
        return tipoasesoriaList;
    }

    public void setTipoasesoriaList(List<Tipoasesoria> tipoasesoriaList) {
        this.tipoasesoriaList = tipoasesoriaList;
    }

    public Tipoasesoria getTipoAsesoriaSeleccionada() {
        return tipoAsesoriaSeleccionada;
    }

    public void setTipoAsesoriaSeleccionada(Tipoasesoria tipoAsesoriaSeleccionada) {
        this.tipoAsesoriaSeleccionada = tipoAsesoriaSeleccionada;
    }

    public List<Garantiaexigida> getGarantiasExigidasList() {
        return garantiasExigidasList;
    }

    public void setGarantiasExigidasList(List<Garantiaexigida> garantiasExigidasList) {
        this.garantiasExigidasList = garantiasExigidasList;
    }

    public Garantia[] getGarantiasSeleccionadas() {
        return garantiasSeleccionadas;
    }

    public void setGarantiasSeleccionadas(Garantia[] garantiasSeleccionadas) {
        this.garantiasSeleccionadas = garantiasSeleccionadas;
    }

    public List<Garantia> getGarantiasList() {
        return garantiasList;
    }

    public void setGarantiasList(List<Garantia> garantiasList) {
        this.garantiasList = garantiasList;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public boolean isIsCompleta() {
        return isCompleta;
    }

    public void setIsCompleta(boolean isCompleta) {
        this.isCompleta = isCompleta;
    }

    public String getNombreAsociado() {
        return nombreAsociado;
    }

    public void setNombreAsociado(String nombreAsociado) {
        this.nombreAsociado = nombreAsociado;
    }

    public boolean isBandasignarGarantia() {
        return bandasignarGarantia;
    }

    public void setBandasignarGarantia(boolean bandasignarGarantia) {
        this.bandasignarGarantia = bandasignarGarantia;
    }

    public boolean isBandCalcularAsignarGarantia() {
        return bandCalcularAsignarGarantia;
    }

    public void setBandCalcularAsignarGarantia(boolean bandCalcularAsignarGarantia) {
        this.bandCalcularAsignarGarantia = bandCalcularAsignarGarantia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
