package com.siapa.managedbean;

import com.siapa.jasper.Reporte;
import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.DesembolsoLazyModel;
import com.siapa.model.Ahorro;
import com.siapa.model.Analisis;
import com.siapa.model.Banco;
import com.siapa.model.Cheque;
import com.siapa.model.Deducciones;
import com.siapa.model.Desembolso;
import com.siapa.model.Pagaduria;
import com.siapa.model.Prestamo;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.pojos.rpt.comprobantedesembolso.RptComprobanteDesembolso;
import com.siapa.pojos.rpt.tablateoricaamortizacion.ReporteTablaTeoricaAmortizacionPojo;
import com.siapa.service.AhorroService;
import com.siapa.service.AnalisisService;
import com.siapa.service.BancoService;
import com.siapa.service.ChequeService;
import com.siapa.service.DeduccionService;
import com.siapa.service.DesembolsoService;
import com.siapa.service.PagaduriaService;
import com.siapa.service.PrestamoService;
import com.siapa.service.ResolucionService;
import com.siapa.service.SolicitudService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Named("desembolsoCreditoManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class DesembolsoCreditoManagedBean extends GenericManagedBean<Desembolso, Integer> {

    @Autowired
    @Qualifier(value = "desembolsoService")
    private DesembolsoService desembolsoService;

    @Autowired
    @Qualifier(value = "solicitudService")
    private SolicitudService solicitudService;
    @Autowired
    @Qualifier(value = "analisisService")
    private AnalisisService analisisService;
    @Autowired
    @Qualifier(value = "resolucionService")
    private ResolucionService resolucionService;
    @Autowired
    @Qualifier(value = "pagaduriaService")
    private PagaduriaService pagaduriaService;

    //servicios de los hijos de desembolso
    @Autowired
    @Qualifier(value = "ahorroService")
    private AhorroService ahorroService;
    @Autowired
    @Qualifier(value = "chequeService")
    private ChequeService chequeService;
    @Autowired
    @Qualifier(value = "deduccionService")
    private DeduccionService deduccionService;
    @Autowired
    @Qualifier(value = "prestamoService")
    private PrestamoService prestamoService;
    @Autowired
    @Qualifier(value = "bancoService")
    private BancoService bancoService;

    //Listados
    private List<Analisis> analisisItems;
    private List<Pagaduria> pagaduriaList;
    private List<Desembolso> desembolsosItems;
    private List<Desembolso> desembolsosCompletos;
    private List<Desembolso> desembolsosReporte;

    //actualizarDesembolsosCompletos
    private Analisis analisisSelected;
    private Desembolso desembolsoToEdit;
    private Desembolso desembolsoToAply;
    private BigDecimal tasaEfectiva;
    private BigDecimal cuota;
    private BigDecimal costasProcesales;
    private BigDecimal tasaEfectivaInEdit;
    private BigDecimal cuotaInEdit;
    private BigDecimal costasProcesalesInEdit;
    private BigDecimal tasaEfectivaInAply;
    private BigDecimal cuotaInAply;
    private BigDecimal costasProcesalesInAply;

    //variables para los crud del desembolso
    //modelos
    private Prestamo prestamoSelected;
    private Ahorro ahorroSelected;
    private Cheque chequeSelected;
    private Deducciones deduccionesSelected;

    //listas de hijos del desembolso.
    private List<Prestamo> prestamoList;
    private List<Ahorro> ahorroList;
    private List<Cheque> chequeList;
    private List<Deducciones> deduccionesList;

    private List<Banco> bancoList;
    private String reportName;
    private Desembolso desembolsoToReport;

    @Override
    public GenericService<Desembolso, Integer> getService() {
        return desembolsoService;
    }

    @PostConstruct
    public void init() {
        actualizarAnalisisItems();
        actualizarDesembolsoItems();
        actualizarDesembolsosCompletos();
    }

    @Override
    public LazyDataModel<Desembolso> getNewLazyModel() {
        return new DesembolsoLazyModel(desembolsoService);
    }

    public DesembolsoCreditoManagedBean() {
    }

    @Override
    public void saveNew(ActionEvent event) {
        if (getUsuario() != null) {
            String msg = ResourceBundle.getBundle("/crudbundle").getString(Desembolso.class.getSimpleName() + "Created");
            Date hoy = new Date();

            try {
                getSelected().setUsuarioUltimamodificacion(getUsuario());
                getSelected().setFechaUltimamodificacion(hoy);
                desembolsoService.merge(getSelected());

                actualizarAnalisisItems();
                actualizarDesembolsoItems();

                if (getSelected().getDesembolsoListo()) {
                    FacesContext contex = FacesContext.getCurrentInstance();
                    contex.getExternalContext().redirect("/siacofinges/views/desembolso/ingresardesembolso/index.xhtml");
                }

                JsfUtil.addSuccessMessage(msg);

            } catch (Exception e) {
                desembolsoService.delete(getSelected());
                JsfUtil.addErrorMessage("No se pudo guardar el desembolso");
            }

        }
    }

    @Override
    public void save(ActionEvent event) {
        if (getUsuario() != null) {
            String msg = ResourceBundle.getBundle("/crudbundle").getString(Desembolso.class.getSimpleName() + "Updated");
            Date hoy = new Date();

            try {
                //Guardar desembolso

                desembolsoToEdit.setUsuarioUltimamodificacion(getUsuario());
                desembolsoToEdit.setFechaUltimamodificacion(hoy);
                desembolsoService.merge(desembolsoToEdit);

                actualizarAnalisisItems();
                actualizarDesembolsoItems();

                if (desembolsoToEdit.getDesembolsoListo()) {
                    FacesContext contex = FacesContext.getCurrentInstance();
                    contex.getExternalContext().redirect("/siacofinges/views/desembolso/ingresardesembolso/index.xhtml");
                }
                JsfUtil.addSuccessMessage(msg);

            } catch (Exception e) {
                JsfUtil.addErrorMessage("No se pudo modificar el desembolso");
            }

        }
    }

    public void aply(ActionEvent event) {
        if (getUsuario() != null) {
            String msg = "Aplicacion exitosa";
            Date hoy = new Date();

            try {
                //Guardar prestamo

                Prestamo prestamo = new Prestamo();

                prestamo.setDesembolsoId(desembolsoToAply);
                prestamo.setPrestamoMonto(desembolsoToAply.getResolucionId().getAnalisisId().getAnalisisMonto());
                prestamo.setPrestamoPlazo(desembolsoToAply.getResolucionId().getAnalisisId().getAnalisisPlazo());
                prestamo.setPrestamoTasa(desembolsoToAply.getResolucionId().getAnalisisId().getAnalisisTasa());
                prestamo.setPrestamoSaldo(prestamo.getPrestamoMonto());

                BigDecimal c = desembolsoToAply.getDesembolsoCapitalmasinteres().add(desembolsoToAply.getDesembolsoSeguros().add(desembolsoToAply.getDesembolsoExtraprima().add(desembolsoToAply.getDesembolsoAportcion().add(desembolsoToAply.getDesembolsoAhorroprogramado()))));

                prestamo.setPrestamoCuota(c);
                prestamo.setPrestamoFechapago(desembolsoToAply.getDesembolsoFechaprimerpago());
                prestamo.setPrestamoFechavencimiento(desembolsoToAply.getDesembolsoFechavencimiento());
                prestamo.setPrestamoCategoria("A");

                prestamo.setActivo("SI");
                prestamo.setUsuarioRegistro(getUsuario());
                prestamo.setFechaRegistro(hoy);

                prestamo = prestamoService.merge(prestamo);

                //Actualizar desembolso
                if (prestamo.getPrestamoId() != null) {
                    desembolsoToAply.setPrestamoId(prestamo);
                    desembolsoToAply.setUsuarioUltimamodificacion(getUsuario());
                    desembolsoToAply.setFechaUltimamodificacion(hoy);
                    desembolsoToAply.setDesembolsoCompleto(Boolean.TRUE);
                    desembolsoService.merge(desembolsoToAply);

                    actualizarAnalisisItems();
                    actualizarDesembolsoItems();
                    actualizarDesembolsosCompletos();
                    actualizarDesembolsosParaReporte();

                    FacesContext contex = FacesContext.getCurrentInstance();
                    contex.getExternalContext().redirect("/siacofinges/views/reportes/desembolso/index.xhtml");
                    JsfUtil.addSuccessMessage(msg);

                }

            } catch (Exception e) {
                JsfUtil.addErrorMessage("No se pudo aplicar el desembolso");
            }

        }
    }

    /**
     * Metodo para redirigir de la vista de ingreso de desembolso
     *
     * @param event Evento del boton accionado en la vista
     */
    public void toCrete(ActionEvent event) {

        Date hoy = new Date();
        try {
            analisisSelected = analisisService.fillAnalisis(analisisSelected);
            pagaduriaList = pagaduriaService.findAllActives();

            setSelected(new Desembolso());

            getSelected().setResolucionId(analisisSelected.getResolucionId());
            getSelected().setSucursalId(analisisSelected.getSucursalId());

            getSelected().setDesembolsoTasaefectiva(solicitudService.calcularTasaEfectiva(getAnalisisSelected().getAnalisisTasa()));
            getSelected().setDesembolsoFechaprimerpago(GregorianCalendar.getInstance().getTime());
            calcularFechaVencimiento();

            getSelected().setDesembolsoCapitalmasinteres(analisisSelected.getAnalisisCuotacapitalmasintereses());
            getSelected().setDesembolsoSeguros(analisisSelected.getAnalisisSegurodeuda().add(analisisSelected.getAnalisisSegurodano()));
            getSelected().setDesembolsoAportcion(new BigDecimal("0.00"));
            getSelected().setDesembolsoAhorroprogramado(new BigDecimal("0.00"));
            getSelected().setDesembolsoExtraprima(new BigDecimal("0.00"));

            getSelected().setDesembolsoDireccioncobro(" ");
            getSelected().setUsuarioRegistro(getUsuario());
            getSelected().setFechaRegistro(hoy);

            getSelected().setDesembolsoCompleto(Boolean.FALSE);
            getSelected().setDesembolsoListo(Boolean.FALSE);

            calcularCuota();
            calcularCostasProcesales();

            setSelected(desembolsoService.merge(getSelected()));

            analisisSelected.getResolucionId().setDesembolsoId(getSelected());
            resolucionService.merge(analisisSelected.getResolucionId());

            //para el converter de banco
            cargarListas();

            actualizarAnalisisItems();
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/siacofinges/views/desembolso/ingresardesembolso/desembolsoIndex.xhtml");
            JsfUtil.addErrorMessage("Desembolso creado con exito");
        } catch (IOException ex) {

            if (getSelected().getDesembolsoId() != null) {

                analisisSelected.getResolucionId().setDesembolsoId(null);
                resolucionService.merge(analisisSelected.getResolucionId());

                desembolsoService.delete(getSelected());
            }

            JsfUtil.addErrorMessage("No se pudo crear el desembolso");
            Logger.getLogger(SolicitudManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toEdit(ActionEvent event) {

        Date hoy = new Date();
        try {
            pagaduriaList = pagaduriaService.findAllActives();

            desembolsoToEdit = desembolsoService.fillDesembolso(desembolsoToEdit);
            setSelected(desembolsoToEdit);

            analisisSelected = analisisService.fillAnalisis(desembolsoToEdit.getResolucionId().getAnalisisId());

            calcularFechaVencimiento();

            calcularCuota();
            calcularCostasProcesales();
            cargarListas();

            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/siacofinges/views/desembolso/ingresardesembolso/desembolsoIndex.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(SolicitudManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void printComprobante() {

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        List<RptComprobanteDesembolso> list = new ArrayList<RptComprobanteDesembolso>();
        list.add(desembolsoService.fillComprobanteDesembolso(desembolsoToReport));
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        Reporte reporte = new Reporte("desembolso", "ReportedeComprobantedeDesembolso", request);
        reporte.setDataSource(new JRBeanCollectionDataSource(new HashSet<RptComprobanteDesembolso>(list)));
        reporte.setReportInSession(request, response);
        setReportName(reporte.getNombreLogico());
        RequestContext.getCurrentInstance().addCallbackParam("reportName", getReportName());

    }

    public void printTabla() {

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        List<ReporteTablaTeoricaAmortizacionPojo> list = new ArrayList<ReporteTablaTeoricaAmortizacionPojo>();
        list.add(desembolsoService.fillTablaAmortizacion(desembolsoToReport));
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        Reporte reporte = new Reporte("desembolso", "rpt_tablaTeoricaDeAmortizacion", request);
        reporte.setDataSource(new JRBeanCollectionDataSource(new HashSet<ReporteTablaTeoricaAmortizacionPojo>(list)));
        reporte.setReportInSession(request, response);
        setReportName(reporte.getNombreLogico());
        RequestContext.getCurrentInstance().addCallbackParam("reportName", getReportName());

    }

    public void toAply(ActionEvent event) {

        Date hoy = new Date();
        try {

            desembolsoToAply = desembolsoService.fillDesembolso(desembolsoToAply);

            desembolsoToAply.setDesembolsoTasaefectiva(solicitudService.calcularTasaEfectiva(desembolsoToAply.getResolucionId().getAnalisisId().getAnalisisTasa()));
            calcularFechaVencimientoInAply();

            desembolsoToAply.setUsuarioUltimamodificacion(getUsuario());
            desembolsoToAply.setFechaUltimamodificacion(hoy);
            setSelected(desembolsoToAply);
            calcularCuotaInAply();
            calcularCostasProcesalesInAply();
            cargarListas();
            
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/siacofinges/views/desembolso/aplicardesembolso/desembolsoIndex.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(SolicitudManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private BigDecimal calcularCuota() {
        BigDecimal res;

        if (getAnalisisSelected().getAnalisisCuotacapitalmasintereses() == null) {
            getAnalisisSelected().setAnalisisCuotacapitalmasintereses(new BigDecimal(0));
        }
        if (getAnalisisSelected().getAnalisisSegurodeuda() == null) {
            getAnalisisSelected().setAnalisisSegurodeuda(new BigDecimal(0));
        }

        if (getSelected().getDesembolsoExtraprima() == null) {
            getSelected().setDesembolsoExtraprima(new BigDecimal(0));
        }
        if (getSelected().getDesembolsoAportcion() == null) {
            getSelected().setDesembolsoAportcion(new BigDecimal(0));
        }
        if (getSelected().getDesembolsoAhorroprogramado() == null) {
            getSelected().setDesembolsoAhorroprogramado(new BigDecimal(0));
        }

        BigDecimal totalAnalisis = getAnalisisSelected().getAnalisisCuotacapitalmasintereses().add(getAnalisisSelected().getAnalisisSegurodeuda());
        BigDecimal totalDesembolso = getSelected().getDesembolsoExtraprima().add(getSelected().getDesembolsoAportcion().add(getSelected().getDesembolsoAhorroprogramado()));

        res = totalAnalisis.add(totalDesembolso);

        return res;
    }

    private BigDecimal calcularCuotaInEdit() {
        BigDecimal res;

        if (desembolsoToEdit.getResolucionId().getAnalisisId().getAnalisisCuotacapitalmasintereses() == null) {
            desembolsoToEdit.getResolucionId().getAnalisisId().setAnalisisCuotacapitalmasintereses(new BigDecimal(0));
        }
        if (desembolsoToEdit.getResolucionId().getAnalisisId().getAnalisisSegurodeuda() == null) {
            desembolsoToEdit.getResolucionId().getAnalisisId().setAnalisisSegurodeuda(new BigDecimal(0));
        }

        if (desembolsoToEdit.getDesembolsoExtraprima() == null) {
            desembolsoToEdit.setDesembolsoExtraprima(new BigDecimal(0));
        }
        if (desembolsoToEdit.getDesembolsoAportcion() == null) {
            desembolsoToEdit.setDesembolsoAportcion(new BigDecimal(0));
        }
        if (desembolsoToEdit.getDesembolsoAhorroprogramado() == null) {
            desembolsoToEdit.setDesembolsoAhorroprogramado(new BigDecimal(0));
        }

        BigDecimal totalAnalisis = desembolsoToEdit.getResolucionId().getAnalisisId().getAnalisisCuotacapitalmasintereses().add(desembolsoToEdit.getResolucionId().getAnalisisId().getAnalisisSegurodeuda());
        BigDecimal totalDesembolso = desembolsoToEdit.getDesembolsoExtraprima().add(desembolsoToEdit.getDesembolsoAportcion().add(desembolsoToEdit.getDesembolsoAhorroprogramado()));

        res = totalAnalisis.add(totalDesembolso);

        return res;
    }

    private BigDecimal calcularCuotaInAply() {
        BigDecimal res;

        if (desembolsoToAply.getResolucionId().getAnalisisId().getAnalisisCuotacapitalmasintereses() == null) {
            desembolsoToAply.getResolucionId().getAnalisisId().setAnalisisCuotacapitalmasintereses(new BigDecimal(0));
        }
        if (desembolsoToAply.getResolucionId().getAnalisisId().getAnalisisSegurodeuda() == null) {
            desembolsoToAply.getResolucionId().getAnalisisId().setAnalisisSegurodeuda(new BigDecimal(0));
        }

        if (desembolsoToAply.getDesembolsoExtraprima() == null) {
            desembolsoToAply.setDesembolsoExtraprima(new BigDecimal(0));
        }
        if (desembolsoToAply.getDesembolsoAportcion() == null) {
            desembolsoToAply.setDesembolsoAportcion(new BigDecimal(0));
        }
        if (desembolsoToAply.getDesembolsoAhorroprogramado() == null) {
            desembolsoToAply.setDesembolsoAhorroprogramado(new BigDecimal(0));
        }

        BigDecimal totalAnalisis = desembolsoToAply.getResolucionId().getAnalisisId().getAnalisisCuotacapitalmasintereses().add(desembolsoToAply.getResolucionId().getAnalisisId().getAnalisisSegurodeuda());
        BigDecimal totalDesembolso = desembolsoToAply.getDesembolsoExtraprima().add(desembolsoToAply.getDesembolsoAportcion().add(desembolsoToAply.getDesembolsoAhorroprogramado()));

        res = totalAnalisis.add(totalDesembolso);

        return res;
    }

    private BigDecimal calcularCostasProcesales() {
        BigDecimal res;

        if (getSelected().getDesembolsoCostasprocesales() == null) {
            getSelected().setDesembolsoCostasprocesales(new BigDecimal(0));
        }
        if (getSelected().getDesembolsoCapitaldiferido() == null) {
            getSelected().setDesembolsoCapitaldiferido(new BigDecimal(0));
        }
        if (getSelected().getDesembolsoInteresdiferidos() == null) {
            getSelected().setDesembolsoInteresdiferidos(new BigDecimal(0));
        }

        BigDecimal totalDesembolso = getSelected().getDesembolsoCostasprocesales().add(getSelected().getDesembolsoCapitaldiferido().add(getSelected().getDesembolsoCapitaldiferido()));

        res = totalDesembolso;

        return res;
    }

    private BigDecimal calcularCostasProcesalesInEdit() {
        BigDecimal res;

        if (desembolsoToEdit.getDesembolsoCostasprocesales() == null) {
            desembolsoToEdit.setDesembolsoCostasprocesales(new BigDecimal(0));
        }
        if (desembolsoToEdit.getDesembolsoCapitaldiferido() == null) {
            desembolsoToEdit.setDesembolsoCapitaldiferido(new BigDecimal(0));
        }
        if (desembolsoToEdit.getDesembolsoInteresdiferidos() == null) {
            desembolsoToEdit.setDesembolsoInteresdiferidos(new BigDecimal(0));
        }

        BigDecimal totalDesembolso = desembolsoToEdit.getDesembolsoCostasprocesales().add(desembolsoToEdit.getDesembolsoCapitaldiferido().add(desembolsoToEdit.getDesembolsoCapitaldiferido()));

        res = totalDesembolso;

        return res;
    }

    private BigDecimal calcularCostasProcesalesInAply() {
        BigDecimal res;

        if (desembolsoToAply.getDesembolsoCostasprocesales() == null) {
            desembolsoToAply.setDesembolsoCostasprocesales(new BigDecimal(0));
        }
        if (desembolsoToAply.getDesembolsoCapitaldiferido() == null) {
            desembolsoToAply.setDesembolsoCapitaldiferido(new BigDecimal(0));
        }
        if (desembolsoToAply.getDesembolsoInteresdiferidos() == null) {
            desembolsoToAply.setDesembolsoInteresdiferidos(new BigDecimal(0));
        }

        BigDecimal totalDesembolso = desembolsoToAply.getDesembolsoCostasprocesales().add(desembolsoToAply.getDesembolsoCapitaldiferido().add(desembolsoToAply.getDesembolsoCapitaldiferido()));

        res = totalDesembolso;

        return res;
    }

    public void calcularFechaVencimiento() {

        //crear calendario con fecha de primer pago
        Calendar c = GregorianCalendar.getInstance();
        c.setTime(getSelected().getDesembolsoFechaprimerpago());

        //sumar plazo(meses)
        c.add(Calendar.MONTH, analisisSelected.getAnalisisPlazo() - 1);

        //asignar fecha de vencimineto
        getSelected().setDesembolsoFechavencimiento(c.getTime());
    }

    public void calcularFechaVencimientoInEdit() {

        //crear calendario con fecha de primer pago
        Calendar c = GregorianCalendar.getInstance();
        c.setTime(desembolsoToEdit.getDesembolsoFechaprimerpago());

        //sumar plazo(meses)
        c.add(Calendar.MONTH, desembolsoToEdit.getResolucionId().getAnalisisId().getAnalisisPlazo() - 1);

        //asignar fecha de vencimineto
        desembolsoToEdit.setDesembolsoFechavencimiento(c.getTime());
    }

    public void calcularFechaVencimientoInAply() {

        //crear calendario con fecha de primer pago
        Calendar c = GregorianCalendar.getInstance();
        c.setTime(desembolsoToAply.getDesembolsoFechaprimerpago());

        //sumar plazo(meses)
        c.add(Calendar.MONTH, desembolsoToAply.getResolucionId().getAnalisisId().getAnalisisPlazo() - 1);

        //asignar fecha de vencimineto
        desembolsoToAply.setDesembolsoFechavencimiento(c.getTime());
    }

    public void actualizarAnalisisItems() {
        analisisItems = analisisService.buscarParaDesembolso();
    }

    public void actualizarDesembolsoItems() {
        desembolsosItems = desembolsoService.buscarParaEditar();
    }

    public void actualizarDesembolsosCompletos() {
        desembolsosCompletos = desembolsoService.buscarParaAplicar();
    }

    public void actualizarDesembolsosParaReporte() {
        desembolsosReporte = desembolsoService.buscarParaReporte();
    }

    public void clean() {
        this.setSelected(null);

    }

    public Ahorro ahorroPrepareCreate(ActionEvent event) {
        Ahorro newItem;
        newItem = new Ahorro();
        this.ahorroSelected = newItem;
        initializeEmbeddableKey();
        return newItem;
    }

    public Cheque chequePrepareCreate(ActionEvent event) {
        Cheque newItem;
        newItem = new Cheque();
        this.chequeSelected = newItem;
        initializeEmbeddableKey();
        return newItem;
    }

    public Deducciones deduccionPrepareCreate(ActionEvent event) {
        Deducciones newItem;
        newItem = new Deducciones();
        this.deduccionesSelected = newItem;
        initializeEmbeddableKey();
        return newItem;
    }

    public Prestamo prestamoPrepareCreate(ActionEvent event) {
        Prestamo newItem;
        newItem = new Prestamo();
        this.prestamoSelected = newItem;
        initializeEmbeddableKey();
        return newItem;
    }

    public void cargarListas() {

        prestamoList = prestamoService.findPrestamosByDesembolso(getSelected().getDesembolsoId());
        deduccionesList = deduccionService.findDeduccionesByDesembolso(getSelected().getDesembolsoId());
        ahorroList = ahorroService.findAhorroByDesembolso(getSelected().getDesembolsoId());
        chequeList = chequeService.findChequesByDesembolso(getSelected().getDesembolsoId());
        bancoList = bancoService.findAllActives();

    }

    public void saveAhorro(ActionEvent event) {

        try {

            if (getUsuario() != null) {
                String msj = "Registro del ahorro  creado exitosamente.";
                getAhorroSelected().setUsuarioRegistro(getUsuario());
                getAhorroSelected().setFechaRegistro(new Date());
                getAhorroSelected().setDesembolsoId(getSelected());
                ahorroService.save(ahorroSelected);
                JsfUtil.addSuccessMessage(msj);
            }
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Error, no se pudo crear el registro." + e);
        }
        cargarListas();
    }

    public void updateAhorro(ActionEvent event) {
        String msg = "Registro de ahorro, Actualizado exitosamente.";
        getAhorroSelected().setUsuarioUltimamodificacion(getUsuario());
        getAhorroSelected().setFechaUltimamodificacion(new Date());
        ahorroService.merge(ahorroSelected);
        if (!isValidationFailed()) {
            items = null;
        }
    }

    public void saveDeduccion(ActionEvent event) {

        try {

            if (getUsuario() != null) {
                String msj = "Registro del Deduccion creado exitosamente.";
                getDeduccionesSelected().setUsuarioRegistro(getUsuario());
                getDeduccionesSelected().setFechaRegistro(new Date());
                getDeduccionesSelected().setDesembolsoId(getSelected());
                deduccionService.save(deduccionesSelected);
                JsfUtil.addSuccessMessage(msj);
            }
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Error, no se pudo crear el registro." + e);
        }
        cargarListas();
    }

    public void updateDeduccion(ActionEvent event) {
        String msg = "Registro de deduccion, Actualizado exitosamente.";
        getDeduccionesSelected().setUsuarioUltimamodificacion(getUsuario());
        getDeduccionesSelected().setFechaUltimamodificacion(new Date());
        deduccionService.merge(deduccionesSelected);
        if (!isValidationFailed()) {
            items = null;
        }
    }

    public void saveCheque(ActionEvent event) {

        try {

            if (getUsuario() != null) {
                String msj = "Registro de cheque  creado exitosamente.";
                getChequeSelected().setUsuarioRegistro(getUsuario());
                getChequeSelected().setFechaRegistro(new Date());
                getChequeSelected().setDesembolsoId(getSelected());
                getChequeSelected().setActivo("SI");
                chequeService.save(chequeSelected);
                JsfUtil.addSuccessMessage(msj);
            }
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Error, no se pudo crear el registro." + e);
        }
        cargarListas();
    }

    public void updateCheque(ActionEvent event) {
        String msg = "Registro de cheque, Actualizado exitosamente.";
        getChequeSelected().setUsuarioUltimamodificacion(getUsuario());
        getChequeSelected().setFechaUltimamodificacion(new Date());
        chequeService.merge(chequeSelected);
        if (!isValidationFailed()) {
            items = null;
        }
    }

    public void savePrestamo(ActionEvent event) {

        try {

            if (getUsuario() != null) {
                String msj = "Registro del prestamo  creado exitosamente.";
                getPrestamoSelected().setUsuarioRegistro(getUsuario());
                getPrestamoSelected().setFechaRegistro(new Date());
                getPrestamoSelected().setDesembolsoId(getSelected());
                prestamoService.save(prestamoSelected);
                JsfUtil.addSuccessMessage(msj);
            }
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Error, no se pudo crear el registro." + e);
        }
        cargarListas();
    }

    public void updatePrestamo(ActionEvent event) {
        String msg = "Registro de Prestamo, Actualizado exitosamente.";
        getPrestamoSelected().setUsuarioUltimamodificacion(getUsuario());
        getPrestamoSelected().setFechaUltimamodificacion(new Date());
        prestamoService.merge(prestamoSelected);
        if (!isValidationFailed()) {
            items = null;
        }
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

    public BigDecimal getTasaEfectiva() {
        return tasaEfectiva;
    }

    public void setTasaEfectiva(BigDecimal tasaEfectiva) {
        this.tasaEfectiva = tasaEfectiva;
    }

    public List<Pagaduria> getPagaduriaList() {
        return pagaduriaList;
    }

    public void setPagaduriaList(List<Pagaduria> pagaduriaList) {
        this.pagaduriaList = pagaduriaList;
    }

    public BigDecimal getCuota() {

        cuota = calcularCuota();

        return cuota;
    }

    public void setCuota(BigDecimal cuota) {
        this.cuota = cuota;
    }

    public BigDecimal getCostasProcesales() {
        costasProcesales = calcularCostasProcesales();
        return costasProcesales;
    }

    public void setCostasProcesales(BigDecimal costasProcesales) {
        this.costasProcesales = costasProcesales;
    }

    public List<Desembolso> getDesembolsosItems() {
        return desembolsosItems;
    }

    public void setDesembolsosItems(List<Desembolso> desembolsosItems) {
        this.desembolsosItems = desembolsosItems;
    }

    public Desembolso getDesembolsoToEdit() {
        return desembolsoToEdit;
    }

    public void setDesembolsoToEdit(Desembolso desembolsoToEdit) {
        this.desembolsoToEdit = desembolsoToEdit;
    }

    public BigDecimal getTasaEfectivaInEdit() {
        return tasaEfectivaInEdit;
    }

    public void setTasaEfectivaInEdit(BigDecimal tasaEfectivaInEdit) {
        this.tasaEfectivaInEdit = tasaEfectivaInEdit;
    }

    public BigDecimal getCuotaInEdit() {
        cuotaInEdit = calcularCuotaInEdit();
        return cuotaInEdit;
    }

    public void setCuotaInEdit(BigDecimal cuotaInEdit) {
        this.cuotaInEdit = cuotaInEdit;
    }

    public BigDecimal getCostasProcesalesInEdit() {
        costasProcesalesInEdit = calcularCostasProcesalesInEdit();
        return costasProcesalesInEdit;
    }

    public void setCostasProcesalesInEdit(BigDecimal costasProcesalesInEdit) {
        this.costasProcesalesInEdit = costasProcesalesInEdit;
    }

    public List<Desembolso> getDesembolsosCompletos() {
        return desembolsosCompletos;
    }

    public void setDesembolsosCompletos(List<Desembolso> desembolsosCompletos) {
        this.desembolsosCompletos = desembolsosCompletos;
    }

    public Desembolso getDesembolsoToAply() {
        return desembolsoToAply;
    }

    public void setDesembolsoToAply(Desembolso desembolsoToAply) {
        this.desembolsoToAply = desembolsoToAply;
    }

    public BigDecimal getTasaEfectivaInAply() {
        return tasaEfectivaInAply;
    }

    public void setTasaEfectivaInAply(BigDecimal tasaEfectivaInAply) {
        this.tasaEfectivaInAply = tasaEfectivaInAply;
    }

    public BigDecimal getCuotaInAply() {
        cuotaInAply = calcularCuotaInAply();
        return cuotaInAply;
    }

    public void setCuotaInAply(BigDecimal cuotaInAply) {
        this.cuotaInAply = cuotaInAply;
    }

    public BigDecimal getCostasProcesalesInAply() {
        costasProcesalesInAply = calcularCostasProcesalesInAply();
        return costasProcesalesInAply;
    }

    public void setCostasProcesalesInAply(BigDecimal costasProcesalesInAply) {
        this.costasProcesalesInAply = costasProcesalesInAply;
    }

    public Prestamo getPrestamoSelected() {
        return prestamoSelected;
    }

    public void setPrestamoSelected(Prestamo prestamoSelected) {
        this.prestamoSelected = prestamoSelected;
    }

    public Ahorro getAhorroSelected() {
        return ahorroSelected;
    }

    public void setAhorroSelected(Ahorro ahorroSelected) {
        this.ahorroSelected = ahorroSelected;
    }

    public Cheque getChequeSelected() {
        return chequeSelected;
    }

    public void setChequeSelected(Cheque chequeSelected) {
        this.chequeSelected = chequeSelected;
    }

    public Deducciones getDeduccionesSelected() {
        return deduccionesSelected;
    }

    public void setDeduccionesSelected(Deducciones deduccionesSelected) {
        this.deduccionesSelected = deduccionesSelected;
    }

    public List<Prestamo> getPrestamoList() {
        return prestamoList;
    }

    public void setPrestamoList(List<Prestamo> prestamoList) {
        this.prestamoList = prestamoList;
    }

    public List<Ahorro> getAhorroList() {
        return ahorroList;
    }

    public void setAhorroList(List<Ahorro> ahorroList) {
        this.ahorroList = ahorroList;
    }

    public List<Cheque> getChequeList() {
        return chequeList;
    }

    public void setChequeList(List<Cheque> chequeList) {
        this.chequeList = chequeList;
    }

    public List<Deducciones> getDeduccionesList() {
        return deduccionesList;
    }

    public void setDeduccionesList(List<Deducciones> deduccionesList) {
        this.deduccionesList = deduccionesList;
    }

    public List<Banco> getBancoList() {
        return bancoList;
    }

    public void setBancoList(List<Banco> bancoList) {
        this.bancoList = bancoList;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public Desembolso getDesembolsoToReport() {
        return desembolsoToReport;
    }

    public void setDesembolsoToReport(Desembolso desembolsoToReport) {
        this.desembolsoToReport = desembolsoToReport;
    }

    public List<Desembolso> getDesembolsosReporte() {
        return desembolsosReporte;
    }

    public void setDesembolsosReporte(List<Desembolso> desembolsosReporte) {
        this.desembolsosReporte = desembolsosReporte;
    }

}
