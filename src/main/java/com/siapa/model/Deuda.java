/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marlon.andrade
 */
@Entity
@Table(name = "deuda", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deuda.findAll", query = "SELECT d FROM Deuda d")})
public class Deuda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "DEUDA_ID", nullable = false)
    private Integer deudaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DEUDA_NOMBREINSTITUCION", nullable = false, length = 100)
    private String deudaNombreinstitucion;
    @Size(max = 15)
    @Column(name = "DEUDA_NUMPRESTAMO", length = 15)
    private String deudaNumprestamo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "DEUDA_CUOTA", nullable = true, precision = 10, scale = 2)
    private BigDecimal deudaCuota;
    @Column(name = "DEUDA_FECHAOTORGADO")
    @Temporal(TemporalType.DATE)
    private Date deudaFechaotorgado;
    @Column(name = "DEUDA_VALORORIGINAL", precision = 10, scale = 2)
    private BigDecimal deudaValororiginal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEUDA_SALDOACTUAL", nullable = false, precision = 10, scale = 2)
    private BigDecimal deudaSaldoactual;
    @Size(max = 20)
    @Column(name = "DEUDA_NUMTARJETA_", length = 20)
    private String deudaNumtarjeta;
    @Column(name = "DEUDA_LIMITE", precision = 10, scale = 2)
    private BigDecimal deudaLimite;
    @Column(name = "DEUDA_PAGOMINIMO", precision = 10, scale = 2)
    private BigDecimal deudaPagominimo;
    @Column(name = "DEUDA_FECHAVENCIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date deudaFechavencimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEUDA_LIQUIDAR", nullable = false)
    private boolean deudaLiquidar;
    @Column(name = "DEUDA_MORA", precision = 10, scale = 2)
    private BigDecimal deudaMora;
    @Column(name = "DEUDA_MONTO", precision = 10, scale = 2)
    private BigDecimal deudaMonto;
    @Column(name = "DEUDA_PLAZO", nullable = true)
    private Integer deudaPlazo;
    @Column(name = "DEUDA_TASA", precision = 4, scale = 4)
    private BigDecimal deudaTasa;
    
    @Column(name = "DEUDA_FECHAPAGO")
    @Temporal(TemporalType.DATE)
    private Date deudaFechapago;
    @Column(name = "DEUDA_FECHAULTIMOPAGO")
    @Temporal(TemporalType.DATE)
    private Date deudaFechaultimopago;
    @Column(name = "DEUDA_FECHAULTIMACAPITAL")
    @Temporal(TemporalType.DATE)
    private Date deudaFechaultimacapital;
    @Column(name = "DEUDA_FECHAULTIMAINTERES")
    @Temporal(TemporalType.DATE)
    private Date deudaFechaultimainteres;
    @Size(max = 2)
    @Column(name = "DEUDA_CATEGORIA", length = 2)
    private String deudaCategoria;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String activo;
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
    @JoinColumn(name = "TD_ID", referencedColumnName = "TD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tipodeuda tdId;
    @JoinColumn(name = "SOLICITUD_ID", referencedColumnName = "SOLICITUD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Solicitud solicitudId;
    @JoinColumn(name = "RGC_ID", referencedColumnName = "RGC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Registrogarantiacodeudor rgcId;
    @JoinColumn(name = "ANALISIS_ID", referencedColumnName = "ANALISIS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Analisis analisisId;
    @JoinColumn(name = "AC_ID", referencedColumnName = "AC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Analisiscodeudor acId;

    public Deuda() {
    }

    public Deuda(Integer deudaId) {
        this.deudaId = deudaId;
    }

    public Deuda(Integer deudaId, String deudaNombreinstitucion, BigDecimal deudaCuota, BigDecimal deudaSaldoactual, boolean deudaLiquidar, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.deudaId = deudaId;
        this.deudaNombreinstitucion = deudaNombreinstitucion;
        this.deudaCuota = deudaCuota;
        this.deudaSaldoactual = deudaSaldoactual;
        this.deudaLiquidar = deudaLiquidar;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getDeudaId() {
        return deudaId;
    }

    public void setDeudaId(Integer deudaId) {
        this.deudaId = deudaId;
    }

    public String getDeudaNombreinstitucion() {
        return deudaNombreinstitucion;
    }

    public void setDeudaNombreinstitucion(String deudaNombreinstitucion) {
        this.deudaNombreinstitucion = deudaNombreinstitucion;
    }

    public String getDeudaNumprestamo() {
        return deudaNumprestamo;
    }

    public void setDeudaNumprestamo(String deudaNumprestamo) {
        this.deudaNumprestamo = deudaNumprestamo;
    }

    public BigDecimal getDeudaCuota() {
        return deudaCuota;
    }

    public void setDeudaCuota(BigDecimal deudaCuota) {
        this.deudaCuota = deudaCuota;
    }

    public Date getDeudaFechaotorgado() {
        return deudaFechaotorgado;
    }

    public void setDeudaFechaotorgado(Date deudaFechaotorgado) {
        this.deudaFechaotorgado = deudaFechaotorgado;
    }

    public BigDecimal getDeudaValororiginal() {
        return deudaValororiginal;
    }

    public void setDeudaValororiginal(BigDecimal deudaValororiginal) {
        this.deudaValororiginal = deudaValororiginal;
    }

    public BigDecimal getDeudaSaldoactual() {
        return deudaSaldoactual;
    }

    public void setDeudaSaldoactual(BigDecimal deudaSaldoactual) {
        this.deudaSaldoactual = deudaSaldoactual;
    }

    public String getDeudaNumtarjeta() {
        return deudaNumtarjeta;
    }

    public void setDeudaNumtarjeta(String deudaNumtarjeta) {
        this.deudaNumtarjeta = deudaNumtarjeta;
    }

    public BigDecimal getDeudaLimite() {
        return deudaLimite;
    }

    public void setDeudaLimite(BigDecimal deudaLimite) {
        this.deudaLimite = deudaLimite;
    }

    public BigDecimal getDeudaPagominimo() {
        return deudaPagominimo;
    }

    public void setDeudaPagominimo(BigDecimal deudaPagominimo) {
        this.deudaPagominimo = deudaPagominimo;
    }

    public Date getDeudaFechavencimiento() {
        return deudaFechavencimiento;
    }

    public void setDeudaFechavencimiento(Date deudaFechavencimiento) {
        this.deudaFechavencimiento = deudaFechavencimiento;
    }

    public boolean getDeudaLiquidar() {
        return deudaLiquidar;
    }

    public void setDeudaLiquidar(boolean deudaLiquidar) {
        this.deudaLiquidar = deudaLiquidar;
    }

    public BigDecimal getDeudaMora() {
        return deudaMora;
    }

    public void setDeudaMora(BigDecimal deudaMora) {
        this.deudaMora = deudaMora;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
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

    public Tipodeuda getTdId() {
        return tdId;
    }

    public void setTdId(Tipodeuda tdId) {
        this.tdId = tdId;
    }

    public Solicitud getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Solicitud solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Registrogarantiacodeudor getRgcId() {
        return rgcId;
    }

    public void setRgcId(Registrogarantiacodeudor rgcId) {
        this.rgcId = rgcId;
    }

    public Analisis getAnalisisId() {
        return analisisId;
    }

    public void setAnalisisId(Analisis analisisId) {
        this.analisisId = analisisId;
    }

    public Analisiscodeudor getAcId() {
        return acId;
    }

    public void setAcId(Analisiscodeudor acId) {
        this.acId = acId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deudaId != null ? deudaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deuda)) {
            return false;
        }
        Deuda other = (Deuda) object;
        if ((this.deudaId == null && other.deudaId != null) || (this.deudaId != null && !this.deudaId.equals(other.deudaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Deuda[ deudaId=" + deudaId + " ]";
    }

    public BigDecimal getDeudaMonto() {
        return deudaMonto;
    }

    public void setDeudaMonto(BigDecimal deudaMonto) {
        this.deudaMonto = deudaMonto;
    }

    public Integer getDeudaPlazo() {
        return deudaPlazo;
    }

    public void setDeudaPlazo(Integer deudaPlazo) {
        this.deudaPlazo = deudaPlazo;
    }

    public BigDecimal getDeudaTasa() {
        return deudaTasa;
    }

    public void setDeudaTasa(BigDecimal deudaTasa) {
        this.deudaTasa = deudaTasa;
    }

    public Date getDeudaFechapago() {
        return deudaFechapago;
    }

    public void setDeudaFechapago(Date deudaFechapago) {
        this.deudaFechapago = deudaFechapago;
    }

    public Date getDeudaFechaultimopago() {
        return deudaFechaultimopago;
    }

    public void setDeudaFechaultimopago(Date deudaFechaultimopago) {
        this.deudaFechaultimopago = deudaFechaultimopago;
    }

    public Date getDeudaFechaultimacapital() {
        return deudaFechaultimacapital;
    }

    public void setDeudaFechaultimacapital(Date deudaFechaultimacapital) {
        this.deudaFechaultimacapital = deudaFechaultimacapital;
    }

    public Date getDeudaFechaultimainteres() {
        return deudaFechaultimainteres;
    }

    public void setDeudaFechaultimainteres(Date deudaFechaultimainteres) {
        this.deudaFechaultimainteres = deudaFechaultimainteres;
    }

    public String getDeudaCategoria() {
        return deudaCategoria;
    }

    public void setDeudaCategoria(String deudaCategoria) {
        this.deudaCategoria = deudaCategoria;
    }

}
