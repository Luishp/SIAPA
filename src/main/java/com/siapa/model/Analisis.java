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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "analisis", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Analisis.findAll", query = "SELECT a FROM Analisis a")})
public class Analisis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "ANALISIS_ID", nullable = false)
    private Integer analisisId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANALISIS_FECHACREACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date analisisFechacreacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ANALISIS_MONTO", precision = 10, scale = 2)
    private BigDecimal analisisMonto;
    @Column(name = "ANALISIS_PLAZO")
    private Integer analisisPlazo;
    @Column(name = "ANALISIS_TASA", precision = 4, scale = 4)
    private BigDecimal analisisTasa;
    @Column(name = "ANALISIS_GASTOVIDA", precision = 10, scale = 2)
    private BigDecimal analisisGastovida;
    @Column(name = "ANALISIS_PAGODEUDAACTUAL", precision = 10, scale = 2)
    private BigDecimal analisisPagodeudaactual;
    @Column(name = "ANALISIS_PAGOVIVIENDA", precision = 10, scale = 2)
    private BigDecimal analisisPagovivienda;
    @Column(name = "ANALISIS_DESCUENTOLEY", precision = 10, scale = 2)
    private BigDecimal analisisDescuentoley;
    @Column(name = "ANALISIS_TOTALEGRESO", precision = 10, scale = 2)
    private BigDecimal analisisTotalegreso;
    @Column(name = "ANALISIS_TOTALINGRESO", precision = 10, scale = 2)
    private BigDecimal analisisTotalingreso;
    @Column(name = "ANALISIS_RENTANETA", precision = 10, scale = 2)
    private BigDecimal analisisRentaneta;
    @Column(name = "ANALISIS_TOTALLIQUIDO", precision = 10, scale = 2)
    private BigDecimal analisisTotalliquido;
    @Column(name = "ANALISIS_APORTACIONES", precision = 10, scale = 2)
    private BigDecimal analisisAportaciones;
    @Column(name = "ANALISIS_AHORRO", precision = 10, scale = 2)
    private BigDecimal analisisAhorro;
    @Column(name = "ANALISIS_OTROACTIVO", precision = 10, scale = 2)
    private BigDecimal analisisOtroactivo;
    @Column(name = "ANALISIS_VALORPROPIEDAD", precision = 10, scale = 2)
    private BigDecimal analisisValorpropiedad;
    @Column(name = "ANALISIS_VALORVEHICULO", precision = 10, scale = 2)
    private BigDecimal analisisValorvehiculo;
    @Column(name = "ANALISIS_TOTALACTIVO", precision = 10, scale = 2)
    private BigDecimal analisisTotalactivo;
    @Column(name = "ANALISIS_PRESTAMO", precision = 10, scale = 2)
    private BigDecimal analisisPrestamo;
    @Column(name = "ANALISIS_TARJETACREDITO", precision = 10, scale = 2)
    private BigDecimal analisisTarjetacredito;
    @Column(name = "ANALISIS_DEUDACOMERCIAL", precision = 10, scale = 2)
    private BigDecimal analisisDeudacomercial;
    @Column(name = "ANALISIS_DEUDAPERSONAL", precision = 10, scale = 2)
    private BigDecimal analisisDeudapersonal;
    @Column(name = "ANALISIS_TOTALPASIVO", precision = 10, scale = 2)
    private BigDecimal analisisTotalpasivo;
    @Column(name = "ANALISIS_CAPITALACTUAL", precision = 10, scale = 2)
    private BigDecimal analisisCapitalactual;
    @Column(name = "ANALISIS_CUOTACAPITALMASINTERESES", precision = 10, scale = 2)
    private BigDecimal analisisCuotacapitalmasintereses;
    @Column(name = "ANALISIS_SEGURODEUDA", precision = 10, scale = 2)
    private BigDecimal analisisSegurodeuda;
    @Column(name = "ANALISIS_SEGURODANO", precision = 10, scale = 2)
    private BigDecimal analisisSegurodano;
    @Column(name = "ANALISIS_CAPITALDIFERIDO", precision = 10, scale = 2)
    private BigDecimal analisisCapitaldiferido;
    @Column(name = "ANALISIS_INTERESDIFERIDO", precision = 10, scale = 2)
    private BigDecimal analisisInteresdiferido;
    @Column(name = "ANALISIS_COSTASPROCESALES", precision = 10, scale = 2)
    private BigDecimal analisisCostasprocesales;
    @Column(name = "ANALISIS_EXAMENMEDICO")
    private Boolean analisisExamenmedico;
    @Column(name = "ANALISIS_POSEECOBERTURA")
    private Boolean analisisPoseecobertura;
    @Column(name = "ANALISIS_DECLARAPROBLEMASALUD")
    private Boolean analisisDeclaraproblemasalud;
    @Size(max = 500)
    @Column(name = "ANALISIS_OBSERVACION", length = 500)
    private String analisisObservacion;
    @Size(max = 500)
    @Column(name = "ANALISIS_CONCLUSION", length = 500)
    private String analisisConclusion;
    @Size(max = 500)
    @Column(name = "ANALISIS_RECOMENDACION", length = 500)
    private String analisisRecomendacion;
    @Size(max = 2)
    @Column(name = "ANALISIS_CATEGORIAASOCIADO", length = 2)
    private String analisisCategoriaasociado;
    @Column(name = "ANALISIS_COMPLETO")
    private Boolean analisisCompleto;
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
    @JoinTable(name = "fk_analisis_promocion", joinColumns = {
        @JoinColumn(name = "ANALISIS_ID", referencedColumnName = "ANALISIS_ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "PROMOCION_ID", referencedColumnName = "PROMOCION_ID", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Promocion> promocionList;
    @OneToMany(mappedBy = "analisisId", fetch = FetchType.LAZY)
    private List<Registrogarantiacodeudor> registrogarantiacodeudorList;
   
    @OneToMany(mappedBy = "analisisId", fetch = FetchType.LAZY)
    private List<Descuento> descuentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "analisis", fetch = FetchType.LAZY)
    private List<Ingresoanalisis> ingresoanalisisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "analisis", fetch = FetchType.LAZY)
    private List<Garantiaasignadaanalisis> garantiaasignadaanalisisList;
    @JoinColumn(name = "SUCURSAL_ID", referencedColumnName = "SUCURSAL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sucursal sucursalId;
    @JoinColumn(name = "SOLICITUD_ID", referencedColumnName = "SOLICITUD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Solicitud solicitudId;
    @JoinColumn(name = "RESOLUCION_ID", referencedColumnName = "RESOLUCION_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Resolucion resolucionId;
    @JoinColumn(name = "NR_ID", referencedColumnName = "NR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Nivelresolucion nrId;
    @JoinColumn(name = "TS_ID", referencedColumnName = "TS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tiposolicitud tsId;
    @JoinColumn(name = "TIPORESOLUCION_ID", referencedColumnName = "TIPORESOLUCION_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tiporesolucion tiporesolucionId;
    @OneToMany(mappedBy = "analisisId", fetch = FetchType.LAZY)
    private Set<Deuda> deudaList;
    @OneToMany(mappedBy = "analisisId", fetch = FetchType.LAZY)
    private Set<Registrogarantiaprendaria> registrogarantiaprendariaList;
    @OneToMany(mappedBy = "analisisId", fetch = FetchType.LAZY)
    private Set<Registrogarantiareal> registrogarantiarealList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "analisis", fetch = FetchType.LAZY)
    private Set<Analisisenagendacomitecreditos> analisisenagendacomitecreditosList;
    @OneToMany(mappedBy = "analisisId", fetch = FetchType.LAZY)
    private Set<Registrogarantiahipotecaria> registrogarantiahipotecariaList;
    @OneToMany(mappedBy = "analisisId", fetch = FetchType.LAZY)
    private Set<Consultaburocredito> consultaburocreditoList;
    @OneToMany(mappedBy = "analisisId", fetch = FetchType.LAZY)
    private Set<Resolucion> resolucionList;
    private transient boolean selected;
    private transient int gHipotecariaReq;
    private transient int gHipotecariaReg;
    private transient int gPrendariaReq;
    private transient int gPrendariaReg;
    private transient int gCodeudorReq;
    private transient int gCodeudorReg;
    private transient int gRealReq;
    private transient int gRealReg;
    private transient int color;
     
    public Analisis() {
    }

    public Analisis(Integer analisisId) {
        this.analisisId = analisisId;
    }

    public Analisis(Integer analisisId, Date analisisFechacreacion, String usuarioRegistro, Date fechaRegistro) {
        this.analisisId = analisisId;
        this.analisisFechacreacion = analisisFechacreacion;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getAnalisisId() {
        return analisisId;
    }

    public void setAnalisisId(Integer analisisId) {
        this.analisisId = analisisId;
    }

    public Date getAnalisisFechacreacion() {
        return analisisFechacreacion;
    }

    public void setAnalisisFechacreacion(Date analisisFechacreacion) {
        this.analisisFechacreacion = analisisFechacreacion;
    }

    public BigDecimal getAnalisisMonto() {
        return analisisMonto;
    }

    public void setAnalisisMonto(BigDecimal analisisMonto) {
        this.analisisMonto = analisisMonto;
    }

    public Integer getAnalisisPlazo() {
        return analisisPlazo;
    }

    public void setAnalisisPlazo(Integer analisisPlazo) {
        this.analisisPlazo = analisisPlazo;
    }

    public BigDecimal getAnalisisTasa() {
        return analisisTasa;
    }

    public void setAnalisisTasa(BigDecimal analisisTasa) {
        this.analisisTasa = analisisTasa;
    }

    public BigDecimal getAnalisisGastovida() {
        return analisisGastovida;
    }

    public void setAnalisisGastovida(BigDecimal analisisGastovida) {
        this.analisisGastovida = analisisGastovida;
    }

    public BigDecimal getAnalisisPagodeudaactual() {
        return analisisPagodeudaactual;
    }

    public void setAnalisisPagodeudaactual(BigDecimal analisisPagodeudaactual) {
        this.analisisPagodeudaactual = analisisPagodeudaactual;
    }

    public BigDecimal getAnalisisPagovivienda() {
        return analisisPagovivienda;
    }

    public void setAnalisisPagovivienda(BigDecimal analisisPagovivienda) {
        this.analisisPagovivienda = analisisPagovivienda;
    }

    public BigDecimal getAnalisisDescuentoley() {
        return analisisDescuentoley;
    }

    public void setAnalisisDescuentoley(BigDecimal analisisDescuentoley) {
        this.analisisDescuentoley = analisisDescuentoley;
    }

    public BigDecimal getAnalisisTotalegreso() {
        return analisisTotalegreso;
    }

    public void setAnalisisTotalegreso(BigDecimal analisisTotalegreso) {
        this.analisisTotalegreso = analisisTotalegreso;
    }

    public BigDecimal getAnalisisTotalingreso() {
        return analisisTotalingreso;
    }

    public void setAnalisisTotalingreso(BigDecimal analisisTotalingreso) {
        this.analisisTotalingreso = analisisTotalingreso;
    }

    public BigDecimal getAnalisisRentaneta() {
        return analisisRentaneta;
    }

    public void setAnalisisRentaneta(BigDecimal analisisRentaneta) {
        this.analisisRentaneta = analisisRentaneta;
    }

    public BigDecimal getAnalisisTotalliquido() {
        return analisisTotalliquido;
    }

    public void setAnalisisTotalliquido(BigDecimal analisisTotalliquido) {
        this.analisisTotalliquido = analisisTotalliquido;
    }

    public BigDecimal getAnalisisAportaciones() {
        return analisisAportaciones;
    }

    public void setAnalisisAportaciones(BigDecimal analisisAportaciones) {
        this.analisisAportaciones = analisisAportaciones;
    }

    public BigDecimal getAnalisisAhorro() {
        return analisisAhorro;
    }

    public void setAnalisisAhorro(BigDecimal analisisAhorro) {
        this.analisisAhorro = analisisAhorro;
    }

    public BigDecimal getAnalisisOtroactivo() {
        return analisisOtroactivo;
    }

    public void setAnalisisOtroactivo(BigDecimal analisisOtroactivo) {
        this.analisisOtroactivo = analisisOtroactivo;
    }

    public BigDecimal getAnalisisValorpropiedad() {
        return analisisValorpropiedad;
    }

    public void setAnalisisValorpropiedad(BigDecimal analisisValorpropiedad) {
        this.analisisValorpropiedad = analisisValorpropiedad;
    }

    public BigDecimal getAnalisisValorvehiculo() {
        return analisisValorvehiculo;
    }

    public void setAnalisisValorvehiculo(BigDecimal analisisValorvehiculo) {
        this.analisisValorvehiculo = analisisValorvehiculo;
    }

    public BigDecimal getAnalisisTotalactivo() {
        return analisisTotalactivo;
    }

    public void setAnalisisTotalactivo(BigDecimal analisisTotalactivo) {
        this.analisisTotalactivo = analisisTotalactivo;
    }

    public BigDecimal getAnalisisPrestamo() {
        return analisisPrestamo;
    }

    public void setAnalisisPrestamo(BigDecimal analisisPrestamo) {
        this.analisisPrestamo = analisisPrestamo;
    }

    public BigDecimal getAnalisisTarjetacredito() {
        return analisisTarjetacredito;
    }

    public void setAnalisisTarjetacredito(BigDecimal analisisTarjetacredito) {
        this.analisisTarjetacredito = analisisTarjetacredito;
    }

    public BigDecimal getAnalisisDeudacomercial() {
        return analisisDeudacomercial;
    }

    public void setAnalisisDeudacomercial(BigDecimal analisisDeudacomercial) {
        this.analisisDeudacomercial = analisisDeudacomercial;
    }

    public BigDecimal getAnalisisDeudapersonal() {
        return analisisDeudapersonal;
    }

    public void setAnalisisDeudapersonal(BigDecimal analisisDeudapersonal) {
        this.analisisDeudapersonal = analisisDeudapersonal;
    }

    public BigDecimal getAnalisisTotalpasivo() {
        return analisisTotalpasivo;
    }

    public void setAnalisisTotalpasivo(BigDecimal analisisTotalpasivo) {
        this.analisisTotalpasivo = analisisTotalpasivo;
    }

    public BigDecimal getAnalisisCapitalactual() {
        return analisisCapitalactual;
    }

    public void setAnalisisCapitalactual(BigDecimal analisisCapitalactual) {
        this.analisisCapitalactual = analisisCapitalactual;
    }

    public BigDecimal getAnalisisCuotacapitalmasintereses() {
        return analisisCuotacapitalmasintereses;
    }

    public void setAnalisisCuotacapitalmasintereses(BigDecimal analisisCuotacapitalmasintereses) {
        this.analisisCuotacapitalmasintereses = analisisCuotacapitalmasintereses;
    }

    public BigDecimal getAnalisisSegurodeuda() {
        return analisisSegurodeuda;
    }

    public void setAnalisisSegurodeuda(BigDecimal analisisSegurodeuda) {
        this.analisisSegurodeuda = analisisSegurodeuda;
    }

    public BigDecimal getAnalisisSegurodano() {
        return analisisSegurodano;
    }

    public void setAnalisisSegurodano(BigDecimal analisisSegurodano) {
        this.analisisSegurodano = analisisSegurodano;
    }

    public BigDecimal getAnalisisCapitaldiferido() {
        return analisisCapitaldiferido;
    }

    public void setAnalisisCapitaldiferido(BigDecimal analisisCapitaldiferido) {
        this.analisisCapitaldiferido = analisisCapitaldiferido;
    }

    public BigDecimal getAnalisisInteresdiferido() {
        return analisisInteresdiferido;
    }

    public void setAnalisisInteresdiferido(BigDecimal analisisInteresdiferido) {
        this.analisisInteresdiferido = analisisInteresdiferido;
    }

    public BigDecimal getAnalisisCostasprocesales() {
        return analisisCostasprocesales;
    }

    public void setAnalisisCostasprocesales(BigDecimal analisisCostasprocesales) {
        this.analisisCostasprocesales = analisisCostasprocesales;
    }

    public Boolean getAnalisisExamenmedico() {
        return analisisExamenmedico;
    }

    public void setAnalisisExamenmedico(Boolean analisisExamenmedico) {
        this.analisisExamenmedico = analisisExamenmedico;
    }

    public Boolean getAnalisisPoseecobertura() {
        return analisisPoseecobertura;
    }

    public void setAnalisisPoseecobertura(Boolean analisisPoseecobertura) {
        this.analisisPoseecobertura = analisisPoseecobertura;
    }

    public Boolean getAnalisisDeclaraproblemasalud() {
        return analisisDeclaraproblemasalud;
    }

    public void setAnalisisDeclaraproblemasalud(Boolean analisisDeclaraproblemasalud) {
        this.analisisDeclaraproblemasalud = analisisDeclaraproblemasalud;
    }

    public String getAnalisisObservacion() {
        return analisisObservacion;
    }

    public void setAnalisisObservacion(String analisisObservacion) {
        this.analisisObservacion = analisisObservacion;
    }

    public String getAnalisisConclusion() {
        return analisisConclusion;
    }

    public void setAnalisisConclusion(String analisisConclusion) {
        this.analisisConclusion = analisisConclusion;
    }

    public String getAnalisisRecomendacion() {
        return analisisRecomendacion;
    }

    public void setAnalisisRecomendacion(String analisisRecomendacion) {
        this.analisisRecomendacion = analisisRecomendacion;
    }

    public String getAnalisisCategoriaasociado() {
        return analisisCategoriaasociado;
    }

    public void setAnalisisCategoriaasociado(String analisisCategoriaasociado) {
        this.analisisCategoriaasociado = analisisCategoriaasociado;
    }

    public Boolean getAnalisisCompleto() {
        return analisisCompleto;
    }

    public void setAnalisisCompleto(Boolean analisisCompleto) {
        this.analisisCompleto = analisisCompleto;
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

    @XmlTransient
    @JsonIgnore
    public List<Promocion> getPromocionList() {
        return promocionList;
    }

    public void setPromocionList(List<Promocion> promocionList) {
        this.promocionList = promocionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Registrogarantiacodeudor> getRegistrogarantiacodeudorList() {
        return registrogarantiacodeudorList;
    }

    public void setRegistrogarantiacodeudorList(List<Registrogarantiacodeudor> registrogarantiacodeudorList) {
        this.registrogarantiacodeudorList = registrogarantiacodeudorList;
    }

   
    @XmlTransient
    @JsonIgnore
    public List<Descuento> getDescuentoList() {
        return descuentoList;
    }

    public void setDescuentoList(List<Descuento> descuentoList) {
        this.descuentoList = descuentoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Ingresoanalisis> getIngresoanalisisList() {
        return ingresoanalisisList;
    }

    public void setIngresoanalisisList(List<Ingresoanalisis> ingresoanalisisList) {
        this.ingresoanalisisList = ingresoanalisisList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Garantiaasignadaanalisis> getGarantiaasignadaanalisisList() {
        return garantiaasignadaanalisisList;
    }

    public void setGarantiaasignadaanalisisList(List<Garantiaasignadaanalisis> garantiaasignadaanalisisList) {
        this.garantiaasignadaanalisisList = garantiaasignadaanalisisList;
    }

    public Sucursal getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Sucursal sucursalId) {
        this.sucursalId = sucursalId;
    }

    public Solicitud getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Solicitud solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Resolucion getResolucionId() {
        return resolucionId;
    }

    public void setResolucionId(Resolucion resolucionId) {
        this.resolucionId = resolucionId;
    }
    
    public Tiposolicitud getTsId() {
        return tsId;
    }

    public void setTsId(Tiposolicitud tsId) {
        this.tsId = tsId;
    }
    
    public Tiporesolucion getTiporesolucionId() {
        return tiporesolucionId;
    }

    public void setTiporesolucionId(Tiporesolucion tiporesolucionId) {
        this.tiporesolucionId = tiporesolucionId;
    }
    
    public Nivelresolucion getNrId() {
        return nrId;
    }

    public void setNrId(Nivelresolucion nrId) {
        this.nrId = nrId;
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
    public Set<Registrogarantiaprendaria> getRegistrogarantiaprendariaList() {
        return registrogarantiaprendariaList;
    }

    public void setRegistrogarantiaprendariaList(Set<Registrogarantiaprendaria> registrogarantiaprendariaList) {
        this.registrogarantiaprendariaList = registrogarantiaprendariaList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Registrogarantiareal> getRegistrogarantiarealList() {
        return registrogarantiarealList;
    }

    public void setRegistrogarantiarealList(Set<Registrogarantiareal> registrogarantiarealList) {
        this.registrogarantiarealList = registrogarantiarealList;
    }
     
    @XmlTransient
    @JsonIgnore
    public Set<Analisisenagendacomitecreditos> getAnalisisenagendacomitecreditosList() {
        return analisisenagendacomitecreditosList;
    }

    public void setAnalisisenagendacomitecreditosList(Set<Analisisenagendacomitecreditos> analisisenagendacomitecreditosList) {
        this.analisisenagendacomitecreditosList = analisisenagendacomitecreditosList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Registrogarantiahipotecaria> getRegistrogarantiahipotecariaList() {
        return registrogarantiahipotecariaList;
    }

    public void setRegistrogarantiahipotecariaList(Set<Registrogarantiahipotecaria> registrogarantiahipotecariaList) {
        this.registrogarantiahipotecariaList = registrogarantiahipotecariaList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Consultaburocredito> getConsultaburocreditoList() {
        return consultaburocreditoList;
    }

    public void setConsultaburocreditoList(Set<Consultaburocredito> consultaburocreditoList) {
        this.consultaburocreditoList = consultaburocreditoList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Resolucion> getResolucionList() {
        return resolucionList;
    }

    public void setResolucionList(Set<Resolucion> resolucionList) {
        this.resolucionList = resolucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (analisisId != null ? analisisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Analisis)) {
            return false;
        }
        Analisis other = (Analisis) object;
        if ((this.analisisId == null && other.analisisId != null) || (this.analisisId != null && !this.analisisId.equals(other.analisisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Analisis[ analisisId=" + analisisId + " ]";
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getgHipotecariaReq() {
        return gHipotecariaReq;
    }

    public void setgHipotecariaReq(int gHipotecariaReq) {
        this.gHipotecariaReq = gHipotecariaReq;
    }

    public int getgHipotecariaReg() {
        return gHipotecariaReg;
    }

    public void setgHipotecariaReg(int gHipotecariaReg) {
        this.gHipotecariaReg = gHipotecariaReg;
    }

    public int getgPrendariaReq() {
        return gPrendariaReq;
    }

    public void setgPrendariaReq(int gPrendariaReq) {
        this.gPrendariaReq = gPrendariaReq;
    }

    public int getgPrendariaReg() {
        return gPrendariaReg;
    }

    public void setgPrendariaReg(int gPrendariaReg) {
        this.gPrendariaReg = gPrendariaReg;
    }

    public int getgCodeudorReq() {
        return gCodeudorReq;
    }

    public void setgCodeudorReq(int gCodeudorReq) {
        this.gCodeudorReq = gCodeudorReq;
    }

    public int getgCodeudorReg() {
        return gCodeudorReg;
    }

    public void setgCodeudorReg(int gCodeudorReg) {
        this.gCodeudorReg = gCodeudorReg;
    }

    public int getgRealReq() {
        return gRealReq;
    }

    public void setgRealReq(int gRealReq) {
        this.gRealReq = gRealReq;
    }

    public int getgRealReg() {
        return gRealReg;
    }

    public void setgRealReg(int gRealReg) {
        this.gRealReg = gRealReg;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

}
