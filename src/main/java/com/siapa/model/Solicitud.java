/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "solicitud", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "SOLICITUD_ID", nullable = false)
    private Integer solicitudId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "SOLICITUD_CODIGOASOCIADO", nullable = false, length = 40)
    private String solicitudCodigoasociado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SOLICITUD_NOMBRE1", nullable = false, length = 20)
    private String solicitudNombre1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SOLICITUD_NOMBRE2", nullable = false, length = 20)
    private String solicitudNombre2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SOLICITUD_APELLIDO1", nullable = false, length = 20)
    private String solicitudApellido1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SOLICITUD_APELLIDO2", nullable = false, length = 20)
    private String solicitudApellido2;
    @Size(max = 20)
    @Column(name = "SOLICITUD_APELLIDOCASADA", length = 20)
    private String solicitudApellidocasada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "SOLICITUD_DUILUGAR", nullable = false, length = 150)
    private String solicitudDuilugar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOLICITUD_DUIFECHAEXP", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date solicitudDuifechaexp;
    @Size(max = 50)
    @Column(name = "SOLICITUD_RESIDENCIAEXNTRANJERA", length = 50)
    private String solicitudResidenciaexntranjera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SOLICITUD_ESTATUSLEGAL", nullable = false, length = 30)
    private String solicitudEstatuslegal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SOLICITUD_ESTADOCIVIL", nullable = false, length = 20)
    private String solicitudEstadocivil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SOLICITUD_PROFESION", nullable = false, length = 50)
    private String solicitudProfesion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOLICITUD_NUMDEPENDIENTE", nullable = false)
    private int solicitudNumdependiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "SOLICITUD_DIRECCIONRESIDENCIA", nullable = false, length = 500)
    private String solicitudDireccionresidencia;
    @Column(name = "SOLICITUD_TIEMPORESIDIRANIO")
    private Integer solicitudTiemporesidiranio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOLICITUD_TIEMPORESIDIRMES", nullable = false)
    private int solicitudTiemporesidirmes;
    @Size(max = 9)
    @Column(name = "SOLICITUD_TELEFONO", length = 9)
    private String solicitudTelefono;
    @Size(max = 9)
    @Column(name = "SOLICITUD_CELULAR", length = 9)
    private String solicitudCelular;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOLICITUD_MONTOSOLICITADO", nullable = false, precision = 10, scale = 2)
    private BigDecimal solicitudMontosolicitado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOLICITUD_PLAZOSOLICITADO", nullable = false)
    private int solicitudPlazosolicitado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "SOLICITUD_DESTINO", nullable = false, length = 200)
    private String solicitudDestino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOLICITUD_SUELDO", nullable = false, precision = 10, scale = 2)
    private BigDecimal solicitudSueldo;
    @Column(name = "SOLICITUD_FECHASUELDO")
    private Integer solicitudFechasueldo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOLICITUD_DIAPAGO", nullable = false)
    private int solicitudDiapago;
    @Column(name = "SOLICITUD_LISTAPARAANALISIS")
    private Boolean solicitudListaparaanalisis;
    @Size(max = 60)
    @Column(name = "SOLICITUD_NOMBREEMPRESA", length = 60)
    private String solicitudNombreempresa;
    @Size(max = 500)
    @Column(name = "SOLICITUD_DIRECCIONEMPRESA", length = 500)
    private String solicitudDireccionempresa;
    @Size(max = 30)
    @Column(name = "SOLICITUD_CARGO", length = 30)
    private String solicitudCargo;
    @Size(max = 9)
    @Column(name = "SOLICITUD_TELEFONOEMPRESA", length = 9)
    private String solicitudTelefonoempresa;
    @Size(max = 9)
    @Column(name = "SOLICITUD_FAXEMPRESA", length = 9)
    private String solicitudFaxempresa;
    @Column(name = "SOLICITUD_TIEMPOTRABAJOANIO")
    private Integer solicitudTiempotrabajoanio;
    @Column(name = "SOLICITUD_TIEMPOTRABAJOMES")
    private Integer solicitudTiempotrabajomes;
    @Column(name = "SOLICITUD_NEGOCIONRC")
    private Integer solicitudNegocionrc;
    @Size(max = 17)
    @Column(name = "SOLICITUD_NEGOCIONIT", length = 17)
    private String solicitudNegocionit;
    @Size(max = 200)
    @Column(name = "SOLICITUD_NEGOCIOACTIVIDAD", length = 200)
    private String solicitudNegocioactividad;
    @Column(name = "SOLICITUD_NEGOCIOPROPIETARIOUNICO")
    private Boolean solicitudNegociopropietariounico;
    @Column(name = "SOLICITUD_NEGOCIONUMPROPIETARIO")
    private Integer solicitudNegocionumpropietario;
    @Column(name = "SOLICITUD_NEGOCIOPARTICIPACION", precision = 3, scale = 2)
    private BigDecimal solicitudNegocioparticipacion;
    @Size(max = 60)
    @Column(name = "SOLICTUD_NOMBREEMPRESAANTERIOR", length = 60)
    private String solictudNombreempresaanterior;
    @Size(max = 500)
    @Column(name = "SOLICTUD_DIRECCIONEMPRESAANTERIOR", length = 500)
    private String solictudDireccionempresaanterior;
    @Size(max = 9)
    @Column(name = "SOLICTUD_TELEFONOANTERIOR", length = 9)
    private String solictudTelefonoanterior;
    @Size(max = 30)
    @Column(name = "SOLICTUD_CARGOANTERIOR", length = 30)
    private String solictudCargoanterior;
    @Column(name = "SOLICTUD_FECHAINGRESOANTERIOR")
    @Temporal(TemporalType.DATE)
    private Date solictudFechaingresoanterior;
    @Column(name = "SOLICTUD_FECHARETIROANTERIOR")
    @Temporal(TemporalType.DATE)
    private Date solictudFecharetiroanterior;
    @Column(name = "SOLICITUD_GASTOVIDA", precision = 10, scale = 2)
    private BigDecimal solicitudGastovida;
    @Size(max = 7)
    @Column(name = "SOLICITUD_CODIGOASOCIADOCONYUGUE", length = 7)
    private String solicitudCodigoasociadoconyugue;
    @Size(max = 60)
    @Column(name = "SOLICITUD_NOMBRECOMPLETOCONYUGE", length = 60)
    private String solicitudNombrecompletoconyuge;
    @Size(max = 9)
    @Column(name = "SOLICITUD_TELEFONOCONYUGE", length = 9)
    private String solicitudTelefonoconyuge;
    @Size(max = 60)
    @Column(name = "SOLICITUD_NOMBREEMPRESACONYUGUE", length = 60)
    private String solicitudNombreempresaconyugue;
    @Size(max = 500)
    @Column(name = "SOLCITUD_DIRECCIONEMPRESACONYUGE", length = 500)
    private String solcitudDireccionempresaconyuge;
    @Column(name = "SOLICITUD_TIEMPOTRABAJOANIOCONYUGUE")
    private Integer solicitudTiempotrabajoanioconyugue;
    @Column(name = "SOLICITUD_TIEMOPTRABAJOMESCONYUGUE")
    private Integer solicitudTiemoptrabajomesconyugue;
    @Size(max = 30)
    @Column(name = "SOLICITUD_CARGOCONYUGUE", length = 30)
    private String solicitudCargoconyugue;
    @Column(name = "SOLICITUD_SUELDOCONYUGUE", precision = 10, scale = 2)
    private BigDecimal solicitudSueldoconyugue;
    @Column(name = "SOLICITUD_NUMDEPENDIENTECONYUGUE")
    private Integer solicitudNumdependienteconyugue;
    @Column(name = "SOLICITUD_PAGODEUDAACTUAL", precision = 10, scale = 2)
    private BigDecimal solicitudPagodeudaactual;
    @Column(name = "SOLICITUD_PAGOVIVIENDA", precision = 10, scale = 2)
    private BigDecimal solicitudPagovivienda;
    @Column(name = "SOLICITUD_DESCUENTO", precision = 10, scale = 2)
    private BigDecimal solicitudDescuento;
    @Column(name = "SOLICITUD_TOTALEGRESO", precision = 10, scale = 2)
    private BigDecimal solicitudTotalegreso;
    @Column(name = "SOLICITUD_SUELDOCONYUGE", precision = 10, scale = 2)
    private BigDecimal solicitudSueldoconyuge;
    @Column(name = "SOLICITUD_INGRESOCOMISION", precision = 10, scale = 2)
    private BigDecimal solicitudIngresoComision;
    @Column(name = "SOLICITUD_INGRESOOTROS", precision = 10, scale = 2)
    private BigDecimal solicitudIngresoOtros;
    @Column(name = "SOLICTUD_INGRESONEGOCIOPROPIO", precision = 10, scale = 2)
    private BigDecimal solicitudIngresoNegocioPropio;
    @Column(name = "SOLICITUD_TOTALINGRESO", precision = 10, scale = 2)
    private BigDecimal solicitudTotalingreso;
    @Column(name = "SOLICITUD_RENTANETA", precision = 10, scale = 2)
    private BigDecimal solicitudRentaneta;
    @Column(name = "SOLICITUD_APORTACIONACTIVO", precision = 10, scale = 2)
    private BigDecimal solicitudAportacionactivo;
    @Column(name = "SOLICITUD_AHORROACTIVO", precision = 10, scale = 2)
    private BigDecimal solicitudAhorroactivo;
    @Column(name = "SOLICITUD_OTROACTIVO", precision = 10, scale = 2)
    private BigDecimal solicitudOtroactivo;
    @Column(name = "SOLICITUD_VALORPROPIEDAD", precision = 10, scale = 2)
    private BigDecimal solicitudValorpropiedad;
    @Column(name = "SOLICITUD_VALORVEHICULO", precision = 10, scale = 2)
    private BigDecimal solicitudValorvehiculo;
    @Column(name = "SOLICITUD_TOTALACTIVO", precision = 10, scale = 2)
    private BigDecimal solicitudTotalactivo;
    @Column(name = "SOLICITUD_PRESTAMO", precision = 10, scale = 2)
    private BigDecimal solicitudPrestamo;
    @Column(name = "SOLICITUD_DEUDAIF", precision = 10, scale = 2)
    private BigDecimal solicitudDeudaif;
    @Column(name = "SOLICITUD_OTRADEUDA", precision = 10, scale = 2)
    private BigDecimal solicitudOtradeuda;
    @Column(name = "SOLICITUD_TOTALPASIVO", precision = 10, scale = 2)
    private BigDecimal solicitudTotalpasivo;
    @Column(name = "SOLICITUD_CAPITAL", precision = 10, scale = 2)
    private BigDecimal solicitudCapital;
    @Column(name = "SOLICITUD_COMPLETA")
    private Boolean solicitudCompleta;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitud", fetch = FetchType.LAZY)
    private Set<Ingreso> ingresoList;
    @OneToMany(mappedBy = "solicitudId", fetch = FetchType.LAZY)
    private Set<Asesoria> asesoriaList;
    @OneToMany(mappedBy = "solicitudId", fetch = FetchType.LAZY)
    private Set<Tiporesidencia> tiporesidenciaList;
    @OneToMany(mappedBy = "solicitudId", fetch = FetchType.LAZY)
    private Set<Referenciafamiliar> referenciafamiliarList;
    @OneToMany(mappedBy = "solicitudId", fetch = FetchType.LAZY)
    private Set<Tipoempresa> tipoempresaList;
    @OneToMany(mappedBy = "solicitudId", fetch = FetchType.LAZY)
    private Set<Analisis> analisisList;
    @OneToMany(mappedBy = "solicitudId", fetch = FetchType.LAZY)
    private Set<Deuda> deudaList;
    @OneToMany(mappedBy = "solicitudId", fetch = FetchType.LAZY)
    private Set<Referenciapersonal> referenciapersonalList;
    @JoinColumn(name = "FP_ID", referencedColumnName = "FP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Formapago fpId;
    @JoinColumn(name = "PP_ID", referencedColumnName = "PP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Periodicidadpago ppId;
    @OneToMany(mappedBy = "solicitudId", fetch = FetchType.LAZY)
    private Set<Propiedad> propiedadList;
    @JoinColumn(name = "SUCURSAL_ID", referencedColumnName = "SUCURSAL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sucursal sucursalId;
    @JoinColumn(name = "ASESORIA_ID", referencedColumnName = "ASESORIA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Asesoria asesoriaId;

    public Solicitud() {
    }

    public Solicitud(Integer solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Solicitud(Integer solicitudId, String solicitudCodigoasociado, String solicitudNombre1, String solicitudNombre2, String solicitudApellido1, String solicitudApellido2, String solicitudDuilugar, Date solicitudDuifechaexp, String solicitudEstatuslegal, String solicitudEstadocivil, String solicitudProfesion, int solicitudNumdependiente, String solicitudDireccionresidencia, int solicitudTiemporesidirmes, BigDecimal solicitudMontosolicitado, int solicitudPlazosolicitado, String solicitudDestino, int solicitudDiapago, String usuarioRegistro, Date fechaRegistro) {
        this.solicitudId = solicitudId;
        this.solicitudCodigoasociado = solicitudCodigoasociado;
        this.solicitudNombre1 = solicitudNombre1;
        this.solicitudNombre2 = solicitudNombre2;
        this.solicitudApellido1 = solicitudApellido1;
        this.solicitudApellido2 = solicitudApellido2;
        this.solicitudDuilugar = solicitudDuilugar;
        this.solicitudDuifechaexp = solicitudDuifechaexp;
        this.solicitudEstatuslegal = solicitudEstatuslegal;
        this.solicitudEstadocivil = solicitudEstadocivil;
        this.solicitudProfesion = solicitudProfesion;
        this.solicitudNumdependiente = solicitudNumdependiente;
        this.solicitudDireccionresidencia = solicitudDireccionresidencia;
        this.solicitudTiemporesidirmes = solicitudTiemporesidirmes;
        this.solicitudMontosolicitado = solicitudMontosolicitado;
        this.solicitudPlazosolicitado = solicitudPlazosolicitado;
        this.solicitudDestino = solicitudDestino;
        this.solicitudDiapago = solicitudDiapago;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Integer solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getSolicitudCodigoasociado() {
        return solicitudCodigoasociado;
    }

    public void setSolicitudCodigoasociado(String solicitudCodigoasociado) {
        this.solicitudCodigoasociado = solicitudCodigoasociado;
    }

    public String getSolicitudNombre1() {
        return solicitudNombre1;
    }

    public void setSolicitudNombre1(String solicitudNombre1) {
        this.solicitudNombre1 = solicitudNombre1;
    }

    public String getSolicitudNombre2() {
        return solicitudNombre2;
    }

    public void setSolicitudNombre2(String solicitudNombre2) {
        this.solicitudNombre2 = solicitudNombre2;
    }

    public String getSolicitudApellido1() {
        return solicitudApellido1;
    }

    public void setSolicitudApellido1(String solicitudApellido1) {
        this.solicitudApellido1 = solicitudApellido1;
    }

    public String getSolicitudApellido2() {
        return solicitudApellido2;
    }

    public void setSolicitudApellido2(String solicitudApellido2) {
        this.solicitudApellido2 = solicitudApellido2;
    }

    public String getSolicitudApellidocasada() {
        return solicitudApellidocasada;
    }

    public void setSolicitudApellidocasada(String solicitudApellidocasada) {
        this.solicitudApellidocasada = solicitudApellidocasada;
    }

    public String getSolicitudDuilugar() {
        return solicitudDuilugar;
    }

    public void setSolicitudDuilugar(String solicitudDuilugar) {
        this.solicitudDuilugar = solicitudDuilugar;
    }

    public Date getSolicitudDuifechaexp() {
        return solicitudDuifechaexp;
    }

    public void setSolicitudDuifechaexp(Date solicitudDuifechaexp) {
        this.solicitudDuifechaexp = solicitudDuifechaexp;
    }

    public String getSolicitudResidenciaexntranjera() {
        return solicitudResidenciaexntranjera;
    }

    public void setSolicitudResidenciaexntranjera(String solicitudResidenciaexntranjera) {
        this.solicitudResidenciaexntranjera = solicitudResidenciaexntranjera;
    }

    public String getSolicitudEstatuslegal() {
        return solicitudEstatuslegal;
    }

    public void setSolicitudEstatuslegal(String solicitudEstatuslegal) {
        this.solicitudEstatuslegal = solicitudEstatuslegal;
    }

    public String getSolicitudEstadocivil() {
        return solicitudEstadocivil;
    }

    public void setSolicitudEstadocivil(String solicitudEstadocivil) {
        this.solicitudEstadocivil = solicitudEstadocivil;
    }

    public String getSolicitudProfesion() {
        return solicitudProfesion;
    }

    public void setSolicitudProfesion(String solicitudProfesion) {
        this.solicitudProfesion = solicitudProfesion;
    }

    public int getSolicitudNumdependiente() {
        return solicitudNumdependiente;
    }

    public void setSolicitudNumdependiente(int solicitudNumdependiente) {
        this.solicitudNumdependiente = solicitudNumdependiente;
    }

    public String getSolicitudDireccionresidencia() {
        return solicitudDireccionresidencia;
    }

    public void setSolicitudDireccionresidencia(String solicitudDireccionresidencia) {
        this.solicitudDireccionresidencia = solicitudDireccionresidencia;
    }

    public Integer getSolicitudTiemporesidiranio() {
        return solicitudTiemporesidiranio;
    }

    public void setSolicitudTiemporesidiranio(Integer solicitudTiemporesidiranio) {
        this.solicitudTiemporesidiranio = solicitudTiemporesidiranio;
    }

    public int getSolicitudTiemporesidirmes() {
        return solicitudTiemporesidirmes;
    }

    public void setSolicitudTiemporesidirmes(int solicitudTiemporesidirmes) {
        this.solicitudTiemporesidirmes = solicitudTiemporesidirmes;
    }

    public String getSolicitudTelefono() {
        return solicitudTelefono;
    }

    public void setSolicitudTelefono(String solicitudTelefono) {
        this.solicitudTelefono = solicitudTelefono;
    }

    public String getSolicitudCelular() {
        return solicitudCelular;
    }

    public void setSolicitudCelular(String solicitudCelular) {
        this.solicitudCelular = solicitudCelular;
    }

    public BigDecimal getSolicitudMontosolicitado() {
        return solicitudMontosolicitado;
    }

    public void setSolicitudMontosolicitado(BigDecimal solicitudMontosolicitado) {
        this.solicitudMontosolicitado = solicitudMontosolicitado;
    }

    public int getSolicitudPlazosolicitado() {
        return solicitudPlazosolicitado;
    }

    public void setSolicitudPlazosolicitado(int solicitudPlazosolicitado) {
        this.solicitudPlazosolicitado = solicitudPlazosolicitado;
    }

    public String getSolicitudDestino() {
        return solicitudDestino;
    }

    public void setSolicitudDestino(String solicitudDestino) {
        this.solicitudDestino = solicitudDestino;
    }

    public Integer getSolicitudFechasueldo() {
        return solicitudFechasueldo;
    }

    public void setSolicitudFechasueldo(Integer solicitudFechasueldo) {
        this.solicitudFechasueldo = solicitudFechasueldo;
    }

    public int getSolicitudDiapago() {
        return solicitudDiapago;
    }

    public void setSolicitudDiapago(int solicitudDiapago) {
        this.solicitudDiapago = solicitudDiapago;
    }

    public Boolean getSolicitudListaparaanalisis() {
        return solicitudListaparaanalisis;
    }

    public void setSolicitudListaparaanalisis(Boolean solicitudListaparaanalisis) {
        this.solicitudListaparaanalisis = solicitudListaparaanalisis;
    }

    public String getSolicitudNombreempresa() {
        return solicitudNombreempresa;
    }

    public void setSolicitudNombreempresa(String solicitudNombreempresa) {
        this.solicitudNombreempresa = solicitudNombreempresa;
    }

    public String getSolicitudDireccionempresa() {
        return solicitudDireccionempresa;
    }

    public void setSolicitudDireccionempresa(String solicitudDireccionempresa) {
        this.solicitudDireccionempresa = solicitudDireccionempresa;
    }

    public String getSolicitudCargo() {
        return solicitudCargo;
    }

    public void setSolicitudCargo(String solicitudCargo) {
        this.solicitudCargo = solicitudCargo;
    }

    public String getSolicitudTelefonoempresa() {
        return solicitudTelefonoempresa;
    }

    public void setSolicitudTelefonoempresa(String solicitudTelefonoempresa) {
        this.solicitudTelefonoempresa = solicitudTelefonoempresa;
    }

    public String getSolicitudFaxempresa() {
        return solicitudFaxempresa;
    }

    public void setSolicitudFaxempresa(String solicitudFaxempresa) {
        this.solicitudFaxempresa = solicitudFaxempresa;
    }

    public Integer getSolicitudTiempotrabajoanio() {
        return solicitudTiempotrabajoanio;
    }

    public void setSolicitudTiempotrabajoanio(Integer solicitudTiempotrabajoanio) {
        this.solicitudTiempotrabajoanio = solicitudTiempotrabajoanio;
    }

    public Integer getSolicitudTiempotrabajomes() {
        return solicitudTiempotrabajomes;
    }

    public void setSolicitudTiempotrabajomes(Integer solicitudTiempotrabajomes) {
        this.solicitudTiempotrabajomes = solicitudTiempotrabajomes;
    }

    public Integer getSolicitudNegocionrc() {
        return solicitudNegocionrc;
    }

    public void setSolicitudNegocionrc(Integer solicitudNegocionrc) {
        this.solicitudNegocionrc = solicitudNegocionrc;
    }

    public String getSolicitudNegocionit() {
        return solicitudNegocionit;
    }

    public void setSolicitudNegocionit(String solicitudNegocionit) {
        this.solicitudNegocionit = solicitudNegocionit;
    }

    public String getSolicitudNegocioactividad() {
        return solicitudNegocioactividad;
    }

    public void setSolicitudNegocioactividad(String solicitudNegocioactividad) {
        this.solicitudNegocioactividad = solicitudNegocioactividad;
    }

    public Boolean getSolicitudNegociopropietariounico() {
        return solicitudNegociopropietariounico;
    }

    public void setSolicitudNegociopropietariounico(Boolean solicitudNegociopropietariounico) {
        this.solicitudNegociopropietariounico = solicitudNegociopropietariounico;
    }

    public Integer getSolicitudNegocionumpropietario() {
        return solicitudNegocionumpropietario;
    }

    public void setSolicitudNegocionumpropietario(Integer solicitudNegocionumpropietario) {
        this.solicitudNegocionumpropietario = solicitudNegocionumpropietario;
    }

    public BigDecimal getSolicitudNegocioparticipacion() {
        return solicitudNegocioparticipacion;
    }

    public void setSolicitudNegocioparticipacion(BigDecimal solicitudNegocioparticipacion) {
        this.solicitudNegocioparticipacion = solicitudNegocioparticipacion;
    }

    public String getSolictudNombreempresaanterior() {
        return solictudNombreempresaanterior;
    }

    public void setSolictudNombreempresaanterior(String solictudNombreempresaanterior) {
        this.solictudNombreempresaanterior = solictudNombreempresaanterior;
    }

    public String getSolictudDireccionempresaanterior() {
        return solictudDireccionempresaanterior;
    }

    public void setSolictudDireccionempresaanterior(String solictudDireccionempresaanterior) {
        this.solictudDireccionempresaanterior = solictudDireccionempresaanterior;
    }

    public String getSolictudTelefonoanterior() {
        return solictudTelefonoanterior;
    }

    public void setSolictudTelefonoanterior(String solictudTelefonoanterior) {
        this.solictudTelefonoanterior = solictudTelefonoanterior;
    }

    public String getSolictudCargoanterior() {
        return solictudCargoanterior;
    }

    public void setSolictudCargoanterior(String solictudCargoanterior) {
        this.solictudCargoanterior = solictudCargoanterior;
    }

    public Date getSolictudFechaingresoanterior() {
        return solictudFechaingresoanterior;
    }

    public void setSolictudFechaingresoanterior(Date solictudFechaingresoanterior) {
        this.solictudFechaingresoanterior = solictudFechaingresoanterior;
    }

    public Date getSolictudFecharetiroanterior() {
        return solictudFecharetiroanterior;
    }

    public void setSolictudFecharetiroanterior(Date solictudFecharetiroanterior) {
        this.solictudFecharetiroanterior = solictudFecharetiroanterior;
    }

    public BigDecimal getSolicitudGastovida() {
        return solicitudGastovida;
    }

    public void setSolicitudGastovida(BigDecimal solicitudGastovida) {
        this.solicitudGastovida = solicitudGastovida;
    }

    public String getSolicitudCodigoasociadoconyugue() {
        return solicitudCodigoasociadoconyugue;
    }

    public void setSolicitudCodigoasociadoconyugue(String solicitudCodigoasociadoconyugue) {
        this.solicitudCodigoasociadoconyugue = solicitudCodigoasociadoconyugue;
    }

    public String getSolicitudNombrecompletoconyuge() {
        return solicitudNombrecompletoconyuge;
    }

    public void setSolicitudNombrecompletoconyuge(String solicitudNombrecompletoconyuge) {
        this.solicitudNombrecompletoconyuge = solicitudNombrecompletoconyuge;
    }

    public String getSolicitudTelefonoconyuge() {
        return solicitudTelefonoconyuge;
    }

    public void setSolicitudTelefonoconyuge(String solicitudTelefonoconyuge) {
        this.solicitudTelefonoconyuge = solicitudTelefonoconyuge;
    }

    public String getSolicitudNombreempresaconyugue() {
        return solicitudNombreempresaconyugue;
    }

    public void setSolicitudNombreempresaconyugue(String solicitudNombreempresaconyugue) {
        this.solicitudNombreempresaconyugue = solicitudNombreempresaconyugue;
    }

    public String getSolcitudDireccionempresaconyuge() {
        return solcitudDireccionempresaconyuge;
    }

    public void setSolcitudDireccionempresaconyuge(String solcitudDireccionempresaconyuge) {
        this.solcitudDireccionempresaconyuge = solcitudDireccionempresaconyuge;
    }

    public Integer getSolicitudTiempotrabajoanioconyugue() {
        return solicitudTiempotrabajoanioconyugue;
    }

    public void setSolicitudTiempotrabajoanioconyugue(Integer solicitudTiempotrabajoanioconyugue) {
        this.solicitudTiempotrabajoanioconyugue = solicitudTiempotrabajoanioconyugue;
    }

    public Integer getSolicitudTiemoptrabajomesconyugue() {
        return solicitudTiemoptrabajomesconyugue;
    }

    public void setSolicitudTiemoptrabajomesconyugue(Integer solicitudTiemoptrabajomesconyugue) {
        this.solicitudTiemoptrabajomesconyugue = solicitudTiemoptrabajomesconyugue;
    }

    public String getSolicitudCargoconyugue() {
        return solicitudCargoconyugue;
    }

    public void setSolicitudCargoconyugue(String solicitudCargoconyugue) {
        this.solicitudCargoconyugue = solicitudCargoconyugue;
    }

    public BigDecimal getSolicitudSueldoconyugue() {
        return solicitudSueldoconyugue;
    }

    public void setSolicitudSueldoconyugue(BigDecimal solicitudSueldoconyugue) {
        this.solicitudSueldoconyugue = solicitudSueldoconyugue;
    }

    public Integer getSolicitudNumdependienteconyugue() {
        return solicitudNumdependienteconyugue;
    }

    public void setSolicitudNumdependienteconyugue(Integer solicitudNumdependienteconyugue) {
        this.solicitudNumdependienteconyugue = solicitudNumdependienteconyugue;
    }

    public BigDecimal getSolicitudPagodeudaactual() {
        return solicitudPagodeudaactual;
    }

    public void setSolicitudPagodeudaactual(BigDecimal solicitudPagodeudaactual) {
        this.solicitudPagodeudaactual = solicitudPagodeudaactual;
    }

    public BigDecimal getSolicitudPagovivienda() {
        return solicitudPagovivienda;
    }

    public void setSolicitudPagovivienda(BigDecimal solicitudPagovivienda) {
        this.solicitudPagovivienda = solicitudPagovivienda;
    }

    public BigDecimal getSolicitudDescuento() {
        return solicitudDescuento;
    }

    public void setSolicitudDescuento(BigDecimal solicitudDescuento) {
        this.solicitudDescuento = solicitudDescuento;
    }

    public BigDecimal getSolicitudTotalegreso() {
        return solicitudTotalegreso;
    }

    public void setSolicitudTotalegreso(BigDecimal solicitudTotalegreso) {
        this.solicitudTotalegreso = solicitudTotalegreso;
    }

    public BigDecimal getSolicitudSueldoconyuge() {
        return solicitudSueldoconyuge;
    }

    public void setSolicitudSueldoconyuge(BigDecimal solicitudSueldoconyuge) {
        this.solicitudSueldoconyuge = solicitudSueldoconyuge;
    }

    public BigDecimal getSolicitudTotalingreso() {
        return solicitudTotalingreso;
    }

    public void setSolicitudTotalingreso(BigDecimal solicitudTotalingreso) {
        this.solicitudTotalingreso = solicitudTotalingreso;
    }

    public BigDecimal getSolicitudRentaneta() {
        return solicitudRentaneta;
    }

    public void setSolicitudRentaneta(BigDecimal solicitudRentaneta) {
        this.solicitudRentaneta = solicitudRentaneta;
    }

    public BigDecimal getSolicitudAportacionactivo() {
        return solicitudAportacionactivo;
    }

    public void setSolicitudAportacionactivo(BigDecimal solicitudAportacionactivo) {
        this.solicitudAportacionactivo = solicitudAportacionactivo;
    }

    public BigDecimal getSolicitudAhorroactivo() {
        return solicitudAhorroactivo;
    }

    public void setSolicitudAhorroactivo(BigDecimal solicitudAhorroactivo) {
        this.solicitudAhorroactivo = solicitudAhorroactivo;
    }

    public BigDecimal getSolicitudOtroactivo() {
        return solicitudOtroactivo;
    }

    public void setSolicitudOtroactivo(BigDecimal solicitudOtroactivo) {
        this.solicitudOtroactivo = solicitudOtroactivo;
    }

    public BigDecimal getSolicitudValorpropiedad() {
        return solicitudValorpropiedad;
    }

    public void setSolicitudValorpropiedad(BigDecimal solicitudValorpropiedad) {
        this.solicitudValorpropiedad = solicitudValorpropiedad;
    }

    public BigDecimal getSolicitudValorvehiculo() {
        return solicitudValorvehiculo;
    }

    public void setSolicitudValorvehiculo(BigDecimal solicitudValorvehiculo) {
        this.solicitudValorvehiculo = solicitudValorvehiculo;
    }

    public BigDecimal getSolicitudTotalactivo() {
        return solicitudTotalactivo;
    }

    public void setSolicitudTotalactivo(BigDecimal solicitudTotalactivo) {
        this.solicitudTotalactivo = solicitudTotalactivo;
    }

    public BigDecimal getSolicitudPrestamo() {
        return solicitudPrestamo;
    }

    public void setSolicitudPrestamo(BigDecimal solicitudPrestamo) {
        this.solicitudPrestamo = solicitudPrestamo;
    }

    public BigDecimal getSolicitudDeudaif() {
        return solicitudDeudaif;
    }

    public void setSolicitudDeudaif(BigDecimal solicitudDeudaif) {
        this.solicitudDeudaif = solicitudDeudaif;
    }

    public BigDecimal getSolicitudOtradeuda() {
        return solicitudOtradeuda;
    }

    public void setSolicitudOtradeuda(BigDecimal solicitudOtradeuda) {
        this.solicitudOtradeuda = solicitudOtradeuda;
    }

    public BigDecimal getSolicitudTotalpasivo() {
        return solicitudTotalpasivo;
    }

    public void setSolicitudTotalpasivo(BigDecimal solicitudTotalpasivo) {
        this.solicitudTotalpasivo = solicitudTotalpasivo;
    }

    public BigDecimal getSolicitudCapital() {
        return solicitudCapital;
    }

    public void setSolicitudCapital(BigDecimal solicitudCapital) {
        this.solicitudCapital = solicitudCapital;
    }

    public Boolean getSolicitudCompleta() {
        return solicitudCompleta;
    }

    public void setSolicitudCompleta(Boolean solicitudCompleta) {
        this.solicitudCompleta = solicitudCompleta;
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
    
    public Formapago getFpId() {
        return fpId;
    }

    public void setFpId(Formapago fpId) {
        this.fpId = fpId;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Ingreso> getIngresoList() {
        return ingresoList;
    }

    public void setIngresoList(Set<Ingreso> ingresoList) {
        this.ingresoList = ingresoList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Asesoria> getAsesoriaList() {
        return asesoriaList;
    }

    public void setAsesoriaList(Set<Asesoria> asesoriaList) {
        this.asesoriaList = asesoriaList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Tiporesidencia> getTiporesidenciaList() {
        return tiporesidenciaList;
    }

    public void setTiporesidenciaList(Set<Tiporesidencia> tiporesidenciaList) {
        this.tiporesidenciaList = tiporesidenciaList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Referenciafamiliar> getReferenciafamiliarList() {
        return referenciafamiliarList;
    }

    public void setReferenciafamiliarList(Set<Referenciafamiliar> referenciafamiliarList) {
        this.referenciafamiliarList = referenciafamiliarList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Tipoempresa> getTipoempresaList() {
        return tipoempresaList;
    }

    public void setTipoempresaList(Set<Tipoempresa> tipoempresaList) {
        this.tipoempresaList = tipoempresaList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Analisis> getAnalisisList() {
        return analisisList;
    }

    public void setAnalisisList(Set<Analisis> analisisList) {
        this.analisisList = analisisList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Deuda> getDeudaList() {
        return deudaList;
    }

    public void setDeudaList(Set<Deuda> deudaList) {
        this.deudaList = deudaList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Referenciapersonal> getReferenciapersonalList() {
        return referenciapersonalList;
    }

    public void setReferenciapersonalList(Set<Referenciapersonal> referenciapersonalList) {
        this.referenciapersonalList = referenciapersonalList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Propiedad> getPropiedadList() {
        return propiedadList;
    }

    public void setPropiedadList(Set<Propiedad> propiedadList) {
        this.propiedadList = propiedadList;
    }

    public Sucursal getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Sucursal sucursalId) {
        this.sucursalId = sucursalId;
    }

    public Asesoria getAsesoriaId() {
        return asesoriaId;
    }

    public void setAsesoriaId(Asesoria asesoriaId) {
        this.asesoriaId = asesoriaId;
    }

    public BigDecimal getSolicitudSueldo() {
        return solicitudSueldo;
    }

    public void setSolicitudSueldo(BigDecimal solicitudSueldo) {
        this.solicitudSueldo = solicitudSueldo;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solicitudId != null ? solicitudId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.solicitudId == null && other.solicitudId != null) || (this.solicitudId != null && !this.solicitudId.equals(other.solicitudId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Solicitud[ solicitudId=" + solicitudId + " ]";
    }

    public String getNombreCompleto() {
        String nombreCompleto = "";

        if (solicitudNombre1 != null && !solicitudNombre1.trim().equalsIgnoreCase("")) {
            nombreCompleto = nombreCompleto + solicitudNombre1 + " ";
        }

        if (solicitudNombre2 != null && !solicitudNombre2.trim().equalsIgnoreCase("")) {
            nombreCompleto = nombreCompleto + solicitudNombre2;
        }

        if (solicitudApellido1 != null && !solicitudApellido1.trim().equalsIgnoreCase("")) {

            if (nombreCompleto != null && !nombreCompleto.trim().equalsIgnoreCase("")) {
                nombreCompleto = nombreCompleto + ", ";
            }
            nombreCompleto = nombreCompleto + solicitudApellido1 + " ";
        }

        if (solicitudApellido2 != null && !solicitudApellido2.trim().equalsIgnoreCase("")) {
            nombreCompleto = nombreCompleto + solicitudApellido2;
        }

        return nombreCompleto;
    }

    public Periodicidadpago getPpId() {
        return ppId;
    }

    public void setPpId(Periodicidadpago ppId) {
        this.ppId = ppId;
    }

    public BigDecimal getSolicitudIngresoComision() {
        return solicitudIngresoComision;
    }

    public void setSolicitudIngresoComision(BigDecimal solicitudIngresoComision) {
        this.solicitudIngresoComision = solicitudIngresoComision;
    }

    public BigDecimal getSolicitudIngresoOtros() {
        return solicitudIngresoOtros;
    }

    public void setSolicitudIngresoOtros(BigDecimal solicitudIngresoOtros) {
        this.solicitudIngresoOtros = solicitudIngresoOtros;
    }

    public BigDecimal getSolicitudIngresoNegocioPropio() {
        return solicitudIngresoNegocioPropio;
    }

    public void setSolicitudIngresoNegocioPropio(BigDecimal solicitudIngresoNegocioPropio) {
        this.solicitudIngresoNegocioPropio = solicitudIngresoNegocioPropio;
    }

}
