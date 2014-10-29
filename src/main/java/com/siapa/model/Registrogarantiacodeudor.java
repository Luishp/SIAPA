package com.siapa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author marlon.andrade
 */
@Entity
@Table(name="registrogarantiacodeudor",catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registrogarantiacodeudor.findAll", query = "SELECT r FROM Registrogarantiacodeudor r")})
public class Registrogarantiacodeudor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "RGC_ID", nullable = true)
    private Integer rgcId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RGC_FECHACREACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date rgcFechacreacion;
    @Size(max = 50)
    @Column(name = "RGC_RESIDENCIAEXTRANJERA", length = 50)
    private String rgcResidenciaextranjera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "RGC_ESTATUSLEGAL", nullable = false, length = 30)
    private String rgcEstatuslegal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "RGC_ESTADOCIVIL", nullable = false, length = 20)
    private String rgcEstadocivil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "RGC_PROFESION", nullable = false, length = 50)
    private String rgcProfesion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RGC_NUMDEPENDIENTE", nullable = false)
    private int rgcNumdependiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "RGC_DIRECCIONRESIDENCIA", nullable = false, length = 500)
    private String rgcDireccionresidencia;
    @Column(name = "RGC_TIEMPORESIDIRANIO")
    private Integer rgcTiemporesidiranio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RGC_TIEMPORESIDIRMES", nullable = false)
    private int rgcTiemporesidirmes;
    @Size(max = 9)
    @Column(name = "RGC_TELEFONO", length = 9)
    private String rgcTelefono;
    @Size(max = 9)
    @Column(name = "RGC_CELULAR", length = 9)
    private String rgcCelular;
    @Size(max = 100)
    @Column(name = "RGC_EMAIL", length = 100)
    private String rgcEmail;
    @Size(max = 60)
    @Column(name = "RGC_NOMBREEMPRESA", length = 60)
    private String rgcNombreempresa;
    @Size(max = 500)
    @Column(name = "RGC_DIRECCIONEMPRESA", length = 500)
    private String rgcDireccionempresa;
    @Size(max = 30)
    @Column(name = "RGC_CARGO", length = 30)
    private String rgcCargo;
    @Size(max = 9)
    @Column(name = "RGC_TELEFONOEMPRESA", length = 9)
    private String rgcTelefonoempresa;
    @Size(max = 9)
    @Column(name = "RGC_FAXEMPRESA", length = 9)
    private String rgcFaxempresa;
    @Column(name = "RGC_TIEMPOTRABAJOANIO")
    private Integer rgcTiempotrabajoanio;
    @Column(name = "RGC_TIEMPOTRABAJOMES")
    private Integer rgcTiempotrabajomes;
    @Column(name = "RGC_NEGOCIONRC")
    private Integer rgcNegocionrc;
    @Size(max = 17)
    @Column(name = "RGC_NEGOCIONIT", length = 17)
    private String rgcNegocionit;
    @Size(max = 200)
    @Column(name = "RGC_NEGOCIOACTIVIDAD", length = 200)
    private String rgcNegocioactividad;
    @Column(name = "RGC_NEGOCIOPROPIETARIOUNICO")
    private Boolean rgcNegociopropietariounico;
    @Column(name = "RGC_NEGOCIONUMPROPIETARIO")
    private Integer rgcNegocionumpropietario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RGC_NEGOCIOPARTICIPACION", precision = 3, scale = 2)
    private BigDecimal rgcNegocioparticipacion;
    @Size(max = 60)
    @Column(name = "RGC_NOMBREEMPRESAANTERIOR", length = 60)
    private String rgcNombreempresaanterior;
    @Size(max = 500)
    @Column(name = "RGC_DIRECCIONEMPRESAANTERIOR", length = 500)
    private String rgcDireccionempresaanterior;
    @Size(max = 9)
    @Column(name = "RGC_TELEFONOANTERIOR", length = 9)
    private String rgcTelefonoanterior;
    @Size(max = 30)
    @Column(name = "RGC_CARGOANTERIOR", length = 30)
    private String rgcCargoanterior;
    @Column(name = "RGC_FECHAINGRESOANTERIOR")
    @Temporal(TemporalType.DATE)
    private Date rgcFechaingresoanterior;
    @Column(name = "RGC_FECHARETIROANTERIOR")
    @Temporal(TemporalType.DATE)
    private Date rgcFecharetiroanterior;
    @Size(max = 60)
    @Column(name = "RGC_NOMBRECOMPLETOCONYUGE", length = 60)
    private String rgcNombrecompletoconyuge;
    @Column(name = "RGC_SUELDOCONYUGE", precision = 10, scale = 2)
    private BigDecimal rgcSueldoconyuge;
    @Size(max = 500)
    @Column(name = "RGC_LUGARTRABAJOCONYUGE", length = 500)
    private String rgcLugartrabajoconyuge;
    @Size(max = 9)
    @Column(name = "RGC_TELEFONOCONYUGE", length = 9)
    private String rgcTelefonoconyuge;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RGC_GASTOVIDA", nullable = false, precision = 10, scale = 2)
    private BigDecimal rgcGastovida;
    @Column(name = "RGC_PAGODEUDAACTUAL", precision = 10, scale = 2)
    private BigDecimal rgcPagodeudaactual;
    @Column(name = "RGC_PAGOVIVIENDA", precision = 10, scale = 2)
    private BigDecimal rgcPagovivienda;
    @Column(name = "RGC_DESCUENTO", precision = 10, scale = 2)
    private BigDecimal rgcDescuento;
    @Column(name = "RGC_TOTALEGRESO", precision = 10, scale = 2)
    private BigDecimal rgcTotalegreso;
    @Column(name = "RGC_TOTALINGRESO", precision = 10, scale = 2)
    private BigDecimal rgcTotalingreso;
    @Column(name = "RGC_RENTANETA", precision = 10, scale = 2)
    private BigDecimal rgcRentaneta;
    @Column(name = "RGC_APORTACIONAHORROACTIVO", precision = 10, scale = 2)
    private BigDecimal rgcAportacionahorroactivo;
    @Column(name = "RGC_OTROACTIVO", precision = 10, scale = 2)
    private BigDecimal rgcOtroactivo;
    @Column(name = "RGC_VALORPROPIEDAD", precision = 10, scale = 2)
    private BigDecimal rgcValorpropiedad;
    @Column(name = "RGC_VALORVEHICULO", precision = 10, scale = 2)
    private BigDecimal rgcValorvehiculo;
    @Column(name = "RGC_TOTALACTIVO", precision = 10, scale = 2)
    private BigDecimal rgcTotalactivo;
    @Column(name = "RGC_PRESTAMO", precision = 10, scale = 2)
    private BigDecimal rgcPrestamo;
    @Column(name = "RGC_DEUDAIF", precision = 10, scale = 2)
    private BigDecimal rgcDeudaif;
    @Column(name = "RGC_OTRADEUDA", precision = 10, scale = 2)
    private BigDecimal rgcOtradeuda;
    @Column(name = "RGC_TOTALPASIVO", precision = 10, scale = 2)
    private BigDecimal rgcTotalpasivo;
    @Column(name = "RGC_CAPITAL", precision = 10, scale = 2)
    private BigDecimal rgcCapital;
    @Column(name = "RGC_COMPLETA")
    private Boolean rgcCompleta;
        // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RGC_SUELDO")
    private BigDecimal rgcSueldo;
    @Column(name = "RGC_TIEMPOTRABAJOANIOSCONYUGE")
    private Integer rgcTiempotrabajoaniosconyuge;
    @Column(name = "RGC_TIEMPOTRABAJOMESESCONYUGE")
    private Integer rgcTiempotrabajomesesconyuge;
    @Column(name = "RGC_CARGOCONYUGE")
    private String rgcCargoconyuge;
    @Column(name = "RGC_COMISION")
    private BigDecimal rgcComision;
    @Column(name = "RGC_INGRESOOTROS")
    private BigDecimal rgcIngresootros;
    @Column(name = "RGC_NEGOCIOPROPIO")
    private BigDecimal rgcNegociopropio;
    @Column(name = "RGC_NOMBREEMPRESACONYUGE")
    private String rgcNombreempresaconyuge;
    @Column(name = "RGC_VALIDAR")
    @Temporal(TemporalType.DATE)
    private Date rgcValidar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "USUARIO_REGISTRO", nullable = false, length = 15)
    private String usuarioRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 15)
    @Column(name = "USUARIO_ULTIMAMODIFICACION", length = 15)
    private String usuarioUltimamodificacion;
    @Column(name = "FECHA_ULTIMAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimamodificacion;
    @JoinColumn(name = "CODEUDOR_ID", referencedColumnName = "CODEUDOR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Codeudor codeudorId;
    @JoinColumn(name = "ANALISIS_ID", referencedColumnName = "ANALISIS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Analisis analisisId;
    @OneToMany(mappedBy = "rgcId", fetch = FetchType.LAZY)
    private List<Referenciafamiliar> referenciafamiliarList;
    @OneToMany(mappedBy = "rgcId", fetch = FetchType.LAZY)
    private List<Tipoempresa> tipoempresaList;
    @OneToMany(mappedBy = "rgcId", fetch = FetchType.LAZY)
    private List<Analisiscodeudor> analisiscodeudorList;
    @OneToMany(mappedBy = "rgcId", fetch = FetchType.LAZY)
    private List<Deuda> deudaList;
    @OneToMany(mappedBy = "rgcId", fetch = FetchType.LAZY)
    private List<Referenciapersonal> referenciapersonalList;
    @OneToMany(mappedBy = "rgcId", fetch = FetchType.LAZY)
    private List<Propiedad> propiedadList;
    @JoinColumn(name = "TR_ID", referencedColumnName = "TR_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Tiporesidencia tipoResidencia;
    
    public Registrogarantiacodeudor() {
    }

    public Registrogarantiacodeudor(Integer rgcId) {
        this.rgcId = rgcId;
    }

    public Registrogarantiacodeudor(Integer rgcId, Date rgcFechacreacion, String rgcEstatuslegal, String rgcEstadocivil, String rgcProfesion, int rgcNumdependiente, String rgcDireccionresidencia, int rgcTiemporesidirmes, BigDecimal rgcGastovida, String usuarioRegistro, Date fechaRegistro) {
        this.rgcId = rgcId;
        this.rgcFechacreacion = rgcFechacreacion;
        this.rgcEstatuslegal = rgcEstatuslegal;
        this.rgcEstadocivil = rgcEstadocivil;
        this.rgcProfesion = rgcProfesion;
        this.rgcNumdependiente = rgcNumdependiente;
        this.rgcDireccionresidencia = rgcDireccionresidencia;
        this.rgcTiemporesidirmes = rgcTiemporesidirmes;
        this.rgcGastovida = rgcGastovida;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getRgcId() {
        return rgcId;
    }

    public void setRgcId(Integer rgcId) {
        this.rgcId = rgcId;
    }

    public Date getRgcFechacreacion() {
        return rgcFechacreacion;
    }

    public void setRgcFechacreacion(Date rgcFechacreacion) {
        this.rgcFechacreacion = rgcFechacreacion;
    }

    public String getRgcResidenciaextranjera() {
        return rgcResidenciaextranjera;
    }

    public void setRgcResidenciaextranjera(String rgcResidenciaextranjera) {
        this.rgcResidenciaextranjera = rgcResidenciaextranjera;
    }

    public String getRgcEstatuslegal() {
        return rgcEstatuslegal;
    }

    public void setRgcEstatuslegal(String rgcEstatuslegal) {
        this.rgcEstatuslegal = rgcEstatuslegal;
    }

    public String getRgcEstadocivil() {
        return rgcEstadocivil;
    }

    public void setRgcEstadocivil(String rgcEstadocivil) {
        this.rgcEstadocivil = rgcEstadocivil;
    }

    public String getRgcProfesion() {
        return rgcProfesion;
    }

    public void setRgcProfesion(String rgcProfesion) {
        this.rgcProfesion = rgcProfesion;
    }

    public int getRgcNumdependiente() {
        return rgcNumdependiente;
    }

    public void setRgcNumdependiente(int rgcNumdependiente) {
        this.rgcNumdependiente = rgcNumdependiente;
    }

    public String getRgcDireccionresidencia() {
        return rgcDireccionresidencia;
    }

    public void setRgcDireccionresidencia(String rgcDireccionresidencia) {
        this.rgcDireccionresidencia = rgcDireccionresidencia;
    }

    public Integer getRgcTiemporesidiranio() {
        return rgcTiemporesidiranio;
    }

    public void setRgcTiemporesidiranio(Integer rgcTiemporesidiranio) {
        this.rgcTiemporesidiranio = rgcTiemporesidiranio;
    }

    public int getRgcTiemporesidirmes() {
        return rgcTiemporesidirmes;
    }

    public void setRgcTiemporesidirmes(int rgcTiemporesidirmes) {
        this.rgcTiemporesidirmes = rgcTiemporesidirmes;
    }

    public String getRgcTelefono() {
        return rgcTelefono;
    }

    public void setRgcTelefono(String rgcTelefono) {
        this.rgcTelefono = rgcTelefono;
    }

    public String getRgcCelular() {
        return rgcCelular;
    }

    public void setRgcCelular(String rgcCelular) {
        this.rgcCelular = rgcCelular;
    }

    public String getRgcEmail() {
        return rgcEmail;
    }

    public void setRgcEmail(String rgcEmail) {
        this.rgcEmail = rgcEmail;
    }

    public String getRgcNombreempresa() {
        return rgcNombreempresa;
    }

    public void setRgcNombreempresa(String rgcNombreempresa) {
        this.rgcNombreempresa = rgcNombreempresa;
    }

    public String getRgcDireccionempresa() {
        return rgcDireccionempresa;
    }

    public void setRgcDireccionempresa(String rgcDireccionempresa) {
        this.rgcDireccionempresa = rgcDireccionempresa;
    }

    public String getRgcCargo() {
        return rgcCargo;
    }

    public void setRgcCargo(String rgcCargo) {
        this.rgcCargo = rgcCargo;
    }

    public String getRgcTelefonoempresa() {
        return rgcTelefonoempresa;
    }

    public void setRgcTelefonoempresa(String rgcTelefonoempresa) {
        this.rgcTelefonoempresa = rgcTelefonoempresa;
    }

    public String getRgcFaxempresa() {
        return rgcFaxempresa;
    }

    public void setRgcFaxempresa(String rgcFaxempresa) {
        this.rgcFaxempresa = rgcFaxempresa;
    }

    public Integer getRgcTiempotrabajoanio() {
        return rgcTiempotrabajoanio;
    }

    public void setRgcTiempotrabajoanio(Integer rgcTiempotrabajoanio) {
        this.rgcTiempotrabajoanio = rgcTiempotrabajoanio;
    }

    public Integer getRgcTiempotrabajomes() {
        return rgcTiempotrabajomes;
    }

    public void setRgcTiempotrabajomes(Integer rgcTiempotrabajomes) {
        this.rgcTiempotrabajomes = rgcTiempotrabajomes;
    }

    public Integer getRgcNegocionrc() {
        return rgcNegocionrc;
    }

    public void setRgcNegocionrc(Integer rgcNegocionrc) {
        this.rgcNegocionrc = rgcNegocionrc;
    }

    public String getRgcNegocionit() {
        return rgcNegocionit;
    }

    public void setRgcNegocionit(String rgcNegocionit) {
        this.rgcNegocionit = rgcNegocionit;
    }

    public String getRgcNegocioactividad() {
        return rgcNegocioactividad;
    }

    public void setRgcNegocioactividad(String rgcNegocioactividad) {
        this.rgcNegocioactividad = rgcNegocioactividad;
    }

    public Boolean getRgcNegociopropietariounico() {
        return rgcNegociopropietariounico;
    }

    public void setRgcNegociopropietariounico(Boolean rgcNegociopropietariounico) {
        this.rgcNegociopropietariounico = rgcNegociopropietariounico;
    }

    public Integer getRgcNegocionumpropietario() {
        return rgcNegocionumpropietario;
    }

    public void setRgcNegocionumpropietario(Integer rgcNegocionumpropietario) {
        this.rgcNegocionumpropietario = rgcNegocionumpropietario;
    }

    public BigDecimal getRgcNegocioparticipacion() {
        return rgcNegocioparticipacion;
    }

    public void setRgcNegocioparticipacion(BigDecimal rgcNegocioparticipacion) {
        this.rgcNegocioparticipacion = rgcNegocioparticipacion;
    }

    public String getRgcNombreempresaanterior() {
        return rgcNombreempresaanterior;
    }

    public void setRgcNombreempresaanterior(String rgcNombreempresaanterior) {
        this.rgcNombreempresaanterior = rgcNombreempresaanterior;
    }

    public String getRgcDireccionempresaanterior() {
        return rgcDireccionempresaanterior;
    }

    public void setRgcDireccionempresaanterior(String rgcDireccionempresaanterior) {
        this.rgcDireccionempresaanterior = rgcDireccionempresaanterior;
    }

    public String getRgcTelefonoanterior() {
        return rgcTelefonoanterior;
    }

    public void setRgcTelefonoanterior(String rgcTelefonoanterior) {
        this.rgcTelefonoanterior = rgcTelefonoanterior;
    }

    public String getRgcCargoanterior() {
        return rgcCargoanterior;
    }

    public void setRgcCargoanterior(String rgcCargoanterior) {
        this.rgcCargoanterior = rgcCargoanterior;
    }

    public Date getRgcFechaingresoanterior() {
        return rgcFechaingresoanterior;
    }

    public void setRgcFechaingresoanterior(Date rgcFechaingresoanterior) {
        this.rgcFechaingresoanterior = rgcFechaingresoanterior;
    }

    public Date getRgcFecharetiroanterior() {
        return rgcFecharetiroanterior;
    }

    public void setRgcFecharetiroanterior(Date rgcFecharetiroanterior) {
        this.rgcFecharetiroanterior = rgcFecharetiroanterior;
    }

    public String getRgcNombrecompletoconyuge() {
        return rgcNombrecompletoconyuge;
    }

    public void setRgcNombrecompletoconyuge(String rgcNombrecompletoconyuge) {
        this.rgcNombrecompletoconyuge = rgcNombrecompletoconyuge;
    }

    public BigDecimal getRgcSueldoconyuge() {
        return rgcSueldoconyuge;
    }

    public void setRgcSueldoconyuge(BigDecimal rgcSueldoconyuge) {
        this.rgcSueldoconyuge = rgcSueldoconyuge;
    }

    public String getRgcLugartrabajoconyuge() {
        return rgcLugartrabajoconyuge;
    }

    public void setRgcLugartrabajoconyuge(String rgcLugartrabajoconyuge) {
        this.rgcLugartrabajoconyuge = rgcLugartrabajoconyuge;
    }

    public String getRgcTelefonoconyuge() {
        return rgcTelefonoconyuge;
    }

    public void setRgcTelefonoconyuge(String rgcTelefonoconyuge) {
        this.rgcTelefonoconyuge = rgcTelefonoconyuge;
    }

    public BigDecimal getRgcGastovida() {
        return rgcGastovida;
    }

    public void setRgcGastovida(BigDecimal rgcGastovida) {
        this.rgcGastovida = rgcGastovida;
    }

    public BigDecimal getRgcPagodeudaactual() {
        return rgcPagodeudaactual;
    }

    public void setRgcPagodeudaactual(BigDecimal rgcPagodeudaactual) {
        this.rgcPagodeudaactual = rgcPagodeudaactual;
    }

    public BigDecimal getRgcPagovivienda() {
        return rgcPagovivienda;
    }

    public void setRgcPagovivienda(BigDecimal rgcPagovivienda) {
        this.rgcPagovivienda = rgcPagovivienda;
    }

    public BigDecimal getRgcDescuento() {
        return rgcDescuento;
    }

    public void setRgcDescuento(BigDecimal rgcDescuento) {
        this.rgcDescuento = rgcDescuento;
    }

    public BigDecimal getRgcTotalegreso() {
        return rgcTotalegreso;
    }

    public void setRgcTotalegreso(BigDecimal rgcTotalegreso) {
        this.rgcTotalegreso = rgcTotalegreso;
    }

    public BigDecimal getRgcTotalingreso() {
        return rgcTotalingreso;
    }

    public void setRgcTotalingreso(BigDecimal rgcTotalingreso) {
        this.rgcTotalingreso = rgcTotalingreso;
    }

    public BigDecimal getRgcRentaneta() {
        return rgcRentaneta;
    }

    public void setRgcRentaneta(BigDecimal rgcRentaneta) {
        this.rgcRentaneta = rgcRentaneta;
    }

    public BigDecimal getRgcAportacionahorroactivo() {
        return rgcAportacionahorroactivo;
    }

    public void setRgcAportacionahorroactivo(BigDecimal rgcAportacionahorroactivo) {
        this.rgcAportacionahorroactivo = rgcAportacionahorroactivo;
    }

    public BigDecimal getRgcOtroactivo() {
        return rgcOtroactivo;
    }

    public void setRgcOtroactivo(BigDecimal rgcOtroactivo) {
        this.rgcOtroactivo = rgcOtroactivo;
    }

    public BigDecimal getRgcValorpropiedad() {
        return rgcValorpropiedad;
    }

    public void setRgcValorpropiedad(BigDecimal rgcValorpropiedad) {
        this.rgcValorpropiedad = rgcValorpropiedad;
    }

    public BigDecimal getRgcValorvehiculo() {
        return rgcValorvehiculo;
    }

    public void setRgcValorvehiculo(BigDecimal rgcValorvehiculo) {
        this.rgcValorvehiculo = rgcValorvehiculo;
    }

    public BigDecimal getRgcTotalactivo() {
        return rgcTotalactivo;
    }

    public void setRgcTotalactivo(BigDecimal rgcTotalactivo) {
        this.rgcTotalactivo = rgcTotalactivo;
    }

    public BigDecimal getRgcPrestamo() {
        return rgcPrestamo;
    }

    public void setRgcPrestamo(BigDecimal rgcPrestamo) {
        this.rgcPrestamo = rgcPrestamo;
    }

    public BigDecimal getRgcDeudaif() {
        return rgcDeudaif;
    }

    public void setRgcDeudaif(BigDecimal rgcDeudaif) {
        this.rgcDeudaif = rgcDeudaif;
    }

    public BigDecimal getRgcOtradeuda() {
        return rgcOtradeuda;
    }

    public void setRgcOtradeuda(BigDecimal rgcOtradeuda) {
        this.rgcOtradeuda = rgcOtradeuda;
    }

    public BigDecimal getRgcTotalpasivo() {
        return rgcTotalpasivo;
    }

    public void setRgcTotalpasivo(BigDecimal rgcTotalpasivo) {
        this.rgcTotalpasivo = rgcTotalpasivo;
    }

    public BigDecimal getRgcCapital() {
        return rgcCapital;
    }

    public void setRgcCapital(BigDecimal rgcCapital) {
        this.rgcCapital = rgcCapital;
    }

    public Boolean getRgcCompleta() {
        return rgcCompleta;
    }

    public void setRgcCompleta(Boolean rgcCompleta) {
        this.rgcCompleta = rgcCompleta;
    }

    public Date getRgcValidar() {
        return rgcValidar;
    }

    public void setRgcValidar(Date rgcValidar) {
        this.rgcValidar = rgcValidar;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUsuarioUltimamodificacion() {
        return usuarioUltimamodificacion;
    }

    public void setUsuarioUltimamodificacion(String usuarioUltimamodificacion) {
        this.usuarioUltimamodificacion = usuarioUltimamodificacion;
    }

    public Date getFechaUltimamodificacion() {
        return fechaUltimamodificacion;
    }

    public void setFechaUltimamodificacion(Date fechaUltimamodificacion) {
        this.fechaUltimamodificacion = fechaUltimamodificacion;
    }

    public Codeudor getCodeudorId() {
        return codeudorId;
    }

    public void setCodeudorId(Codeudor codeudorId) {
        this.codeudorId = codeudorId;
    }

    public Analisis getAnalisisId() {
        return analisisId;
    }

    public void setAnalisisId(Analisis analisisId) {
        this.analisisId = analisisId;
    }

    @XmlTransient
    @JsonIgnore
    public List<Referenciafamiliar> getReferenciafamiliarList() {
        return referenciafamiliarList;
    }

    public void setReferenciafamiliarList(List<Referenciafamiliar> referenciafamiliarList) {
        this.referenciafamiliarList = referenciafamiliarList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Tipoempresa> getTipoempresaList() {
        return tipoempresaList;
    }

    public void setTipoempresaList(List<Tipoempresa> tipoempresaList) {
        this.tipoempresaList = tipoempresaList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Analisiscodeudor> getAnalisiscodeudorList() {
        return analisiscodeudorList;
    }

    public void setAnalisiscodeudorList(List<Analisiscodeudor> analisiscodeudorList) {
        this.analisiscodeudorList = analisiscodeudorList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Deuda> getDeudaList() {
        return deudaList;
    }

    public void setDeudaList(List<Deuda> deudaList) {
        this.deudaList = deudaList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Referenciapersonal> getReferenciapersonalList() {
        return referenciapersonalList;
    }

    public void setReferenciapersonalList(List<Referenciapersonal> referenciapersonalList) {
        this.referenciapersonalList = referenciapersonalList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Propiedad> getPropiedadList() {
        return propiedadList;
    }

    public void setPropiedadList(List<Propiedad> propiedadList) {
        this.propiedadList = propiedadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rgcId != null ? rgcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registrogarantiacodeudor)) {
            return false;
        }
        Registrogarantiacodeudor other = (Registrogarantiacodeudor) object;
        if ((this.rgcId == null && other.rgcId != null) || (this.rgcId != null && !this.rgcId.equals(other.rgcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Registrogarantiacodeudor[ rgcId=" + rgcId + " ]";
    }

    public Tiporesidencia getTipoResidencia() {
        return tipoResidencia;
    }

    public void setTipoResidencia(Tiporesidencia tipoResidencia) {
        this.tipoResidencia = tipoResidencia;
    }

    public BigDecimal getRgcSueldo() {
        return rgcSueldo;
    }

    public void setRgcSueldo(BigDecimal rgcSueldo) {
        this.rgcSueldo = rgcSueldo;
    }

    public Integer getRgcTiempotrabajoaniosconyuge() {
        return rgcTiempotrabajoaniosconyuge;
    }

    public void setRgcTiempotrabajoaniosconyuge(Integer rgcTiempotrabajoaniosconyuge) {
        this.rgcTiempotrabajoaniosconyuge = rgcTiempotrabajoaniosconyuge;
    }

    public Integer getRgcTiempotrabajomesesconyuge() {
        return rgcTiempotrabajomesesconyuge;
    }

    public void setRgcTiempotrabajomesesconyuge(Integer rgcTiempotrabajomesesconyuge) {
        this.rgcTiempotrabajomesesconyuge = rgcTiempotrabajomesesconyuge;
    }

    public String getRgcCargoconyuge() {
        return rgcCargoconyuge;
    }

    public void setRgcCargoconyuge(String rgcCargoconyuge) {
        this.rgcCargoconyuge = rgcCargoconyuge;
    }

    public BigDecimal getRgcComision() {
        return rgcComision;
    }

    public void setRgcComision(BigDecimal rgcComision) {
        this.rgcComision = rgcComision;
    }

    public BigDecimal getRgcIngresootros() {
        return rgcIngresootros;
    }

    public void setRgcIngresootros(BigDecimal rgcIngresootros) {
        this.rgcIngresootros = rgcIngresootros;
    }

    public BigDecimal getRgcNegociopropio() {
        return rgcNegociopropio;
    }

    public void setRgcNegociopropio(BigDecimal rgcNegociopropio) {
        this.rgcNegociopropio = rgcNegociopropio;
    }

    public String getRgcNombreempresaconyuge() {
        return rgcNombreempresaconyuge;
    }

    public void setRgcNombreempresaconyuge(String rgcNombreempresaconyuge) {
        this.rgcNombreempresaconyuge = rgcNombreempresaconyuge;
    }
    
}
