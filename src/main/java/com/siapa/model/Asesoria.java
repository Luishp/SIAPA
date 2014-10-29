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
@Table(name = "asesoria", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asesoria.findAll", query = "SELECT a FROM Asesoria a")})
public class Asesoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "ASESORIA_ID", nullable = true)
    private Integer asesoriaId;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 20)
//    @Column(name = "ASESORIA_TIPO", nullable = false, length = 20)
//    private String asesoriaTipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASESORIA_INGRESO", nullable = false, precision = 10, scale = 2)
    private BigDecimal asesoriaIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASESORIA_MONTO", nullable = false, precision = 10, scale = 2)
    private BigDecimal asesoriaMonto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASESORIA_PLAZO", nullable = false)
    private Integer asesoriaPlazo;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 20)
//    @Column(name = "ASESORIA_PERIODICIDADPAGO", nullable = false, length = 20)
//    private String asesoriaPeriodicidadpago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASESORIA_TASA", nullable = false, precision = 4, scale = 4)
    private BigDecimal asesoriaTasa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASESORIA_HONORARIOJURIDICO", nullable = false, precision = 10, scale = 2)
    private BigDecimal asesoriaHonorariojuridico;
    @Column(name = "ASESORIA_VALORPROPIEDAD", precision = 10, scale = 2)
    private BigDecimal asesoriaValorpropiedad;
    @Column(name = "ASESORIA_VALORCONSTRUCCION", precision = 10, scale = 2)
    private BigDecimal asesoriaValorconstruccion;
    @Column(name = "ASESORIA_VALORCOMPRAVENTA", precision = 10, scale = 2)
    private BigDecimal asesoriaValorcompraventa;
    @Column(name = "ASESORIA_VALORHIPOTECAACTUAL", precision = 10, scale = 2)
    private BigDecimal asesoriaValorhipotecaactual;
    @Column(name = "ASESORIA_VALORHIPOTECAANTERIOR", precision = 10, scale = 2)
    private BigDecimal asesoriaValorhipotecaanterior;
    @Column(name = "ASESORIA_HONORARIOVALUO", precision = 10, scale = 2)
    private BigDecimal asesoriaHonorariovaluo;
    @Column(name = "ASESORIA_RELACIONAPORTACION", precision = 10, scale = 2)
    private BigDecimal asesoriaRelacionaportacion;
    @Column(name = "ASESORIA_COMISIONOTORGAMIENTO", precision = 10, scale = 2)
    private BigDecimal asesoriaComisionotorgamiento;
    @Column(name = "ASESORIA_IMPUESTOHIPOTECA", precision = 10, scale = 2)
    private BigDecimal asesoriaImpuestohipoteca;
    @Column(name = "ASESORIA_CANCELACIONHIPOTECA", precision = 10, scale = 2)
    private BigDecimal asesoriaCancelacionhipoteca;
    @Column(name = "ASESORIA_IMPUESTOCOMPRAVENTA", precision = 10, scale = 2)
    private BigDecimal asesoriaImpuestocompraventa;
    @Column(name = "ASESORIA_IMPUESTOTRANSFERENCIA", precision = 10, scale = 2)
    private BigDecimal asesoriaImpuestotransferencia;
    @Column(name = "ASESORIA_TOTALGASTO", precision = 10, scale = 2)
    private BigDecimal asesoriaTotalgasto;
    @Column(name = "ASESORIA_CAPITALINTERES", precision = 10, scale = 2)
    private BigDecimal asesoriaCapitalinteres;
    @Column(name = "ASESORIA_SEGURODEUDA", precision = 10, scale = 2)
    private BigDecimal asesoriaSegurodeuda;
    @Column(name = "ASESORIA_SEGURODANIO", precision = 10, scale = 2)
    private BigDecimal asesoriaSegurodanio;
    @Column(name = "ASESORIA_CUOTA", precision = 10, scale = 2)
    private BigDecimal asesoriaCuota;
    @Size(max = 500)
    @Column(name = "ASESORIA_COMENTARIO", length = 500)
    private String asesoriaComentario;
    @Column(name = "ASESORIA_COMPLETA")
    private Boolean asesoriaCompleta;
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
    @JoinTable(name = "fk_asesoria_promocion", joinColumns = {
        @JoinColumn(name = "ASESORIA_ID", referencedColumnName = "ASESORIA_ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "PROMOCION_ID", referencedColumnName = "PROMOCION_ID", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Promocion> promocionList;
    @JoinColumn(name = "SUCURSAL_ID", referencedColumnName = "SUCURSAL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sucursal sucursalId;
    @JoinColumn(name = "IDASOCIADOS", referencedColumnName = "idasociados")
    @ManyToOne(fetch = FetchType.LAZY)
    private Asociados idasociados;
    @JoinColumn(name = "DETALLELINEACREDITO_ID", referencedColumnName = "DETALLELINEACREDITO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Detallelineacredito detallelineacreditoId;
    @JoinColumn(name = "SOLICITUD_ID", referencedColumnName = "SOLICITUD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Solicitud solicitudId;
    @JoinColumn(name = "PP_ID", referencedColumnName = "PP_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Periodicidadpago ppId;
    @JoinColumn(name = "FP_ID", referencedColumnName = "FP_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Formapago fpId;
    @JoinColumn(name = "TA_ID", referencedColumnName = "TA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tipoasesoria taId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asesoria", fetch = FetchType.LAZY)
    private Set<Requisitosolicitadonegocio> requisitosolicitadonegocioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asesoria", fetch = FetchType.LAZY)
    private Set<Requisitosolicitadogarantia> requisitosolicitadogarantiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asesoria", fetch = FetchType.LAZY)
    private Set<Garantiaasignadaasesoria> garantiaasignadaasesoriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asesoria", fetch = FetchType.LAZY)
    private Set<Requisitosolicitadoempleado> requisitosolicitadoempleadoList;
    @OneToMany(mappedBy = "asesoriaId", fetch = FetchType.LAZY)
    private Set<Solicitud> solicitudList;

    public Asesoria() {
    }

    public Asesoria(Integer asesoriaId) {
        this.asesoriaId = asesoriaId;
    }

    public Asesoria(Integer asesoriaId, BigDecimal asesoriaIngreso, BigDecimal asesoriaMonto, int asesoriaPlazo, BigDecimal asesoriaTasa, BigDecimal asesoriaHonorariojuridico, String usuarioRegistro, Date fechaRegistro) {
        this.asesoriaId = asesoriaId;
        this.asesoriaIngreso = asesoriaIngreso;
        this.asesoriaMonto = asesoriaMonto;
        this.asesoriaPlazo = asesoriaPlazo;
        this.asesoriaTasa = asesoriaTasa;
        this.asesoriaHonorariojuridico = asesoriaHonorariojuridico;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Asociados getIdasociados() {
        return idasociados;
    }

    public void setIdasociados(Asociados idasociados) {
        this.idasociados = idasociados;
    }

    public Integer getAsesoriaId() {
        return asesoriaId;
    }

    public void setAsesoriaId(Integer asesoriaId) {
        this.asesoriaId = asesoriaId;
    }

    public BigDecimal getAsesoriaIngreso() {
        return asesoriaIngreso;
    }

    public void setAsesoriaIngreso(BigDecimal asesoriaIngreso) {
        this.asesoriaIngreso = asesoriaIngreso;
    }

    public BigDecimal getAsesoriaMonto() {
        return asesoriaMonto;
    }

    public void setAsesoriaMonto(BigDecimal asesoriaMonto) {
        this.asesoriaMonto = asesoriaMonto;
    }

    public Integer getAsesoriaPlazo() {
        return asesoriaPlazo;
    }

    public void setAsesoriaPlazo(Integer asesoriaPlazo) {
        this.asesoriaPlazo = asesoriaPlazo;
    }

    public BigDecimal getAsesoriaTasa() {
        return asesoriaTasa;
    }

    public void setAsesoriaTasa(BigDecimal asesoriaTasa) {
        this.asesoriaTasa = asesoriaTasa;
    }

    public BigDecimal getAsesoriaHonorariojuridico() {
        return asesoriaHonorariojuridico;
    }

    public void setAsesoriaHonorariojuridico(BigDecimal asesoriaHonorariojuridico) {
        this.asesoriaHonorariojuridico = asesoriaHonorariojuridico;
    }

    public BigDecimal getAsesoriaValorpropiedad() {
        return asesoriaValorpropiedad;
    }

    public void setAsesoriaValorpropiedad(BigDecimal asesoriaValorpropiedad) {
        this.asesoriaValorpropiedad = asesoriaValorpropiedad;
    }

    public BigDecimal getAsesoriaValorconstruccion() {
        return asesoriaValorconstruccion;
    }

    public void setAsesoriaValorconstruccion(BigDecimal asesoriaValorconstruccion) {
        this.asesoriaValorconstruccion = asesoriaValorconstruccion;
    }

    public BigDecimal getAsesoriaValorcompraventa() {
        return asesoriaValorcompraventa;
    }

    public void setAsesoriaValorcompraventa(BigDecimal asesoriaValorcompraventa) {
        this.asesoriaValorcompraventa = asesoriaValorcompraventa;
    }

    public BigDecimal getAsesoriaValorhipotecaactual() {
        return asesoriaValorhipotecaactual;
    }

    public void setAsesoriaValorhipotecaactual(BigDecimal asesoriaValorhipotecaactual) {
        this.asesoriaValorhipotecaactual = asesoriaValorhipotecaactual;
    }

    public BigDecimal getAsesoriaValorhipotecaanterior() {
        return asesoriaValorhipotecaanterior;
    }

    public void setAsesoriaValorhipotecaanterior(BigDecimal asesoriaValorhipotecaanterior) {
        this.asesoriaValorhipotecaanterior = asesoriaValorhipotecaanterior;
    }

    public BigDecimal getAsesoriaHonorariovaluo() {
        return asesoriaHonorariovaluo;
    }

    public void setAsesoriaHonorariovaluo(BigDecimal asesoriaHonorariovaluo) {
        this.asesoriaHonorariovaluo = asesoriaHonorariovaluo;
    }

    public BigDecimal getAsesoriaRelacionaportacion() {
        return asesoriaRelacionaportacion;
    }

    public void setAsesoriaRelacionaportacion(BigDecimal asesoriaRelacionaportacion) {
        this.asesoriaRelacionaportacion = asesoriaRelacionaportacion;
    }

    public BigDecimal getAsesoriaComisionotorgamiento() {
        return asesoriaComisionotorgamiento;
    }

    public void setAsesoriaComisionotorgamiento(BigDecimal asesoriaComisionotorgamiento) {
        this.asesoriaComisionotorgamiento = asesoriaComisionotorgamiento;
    }

    public BigDecimal getAsesoriaImpuestohipoteca() {
        return asesoriaImpuestohipoteca;
    }

    public void setAsesoriaImpuestohipoteca(BigDecimal asesoriaImpuestohipoteca) {
        this.asesoriaImpuestohipoteca = asesoriaImpuestohipoteca;
    }

    public BigDecimal getAsesoriaCancelacionhipoteca() {
        return asesoriaCancelacionhipoteca;
    }

    public void setAsesoriaCancelacionhipoteca(BigDecimal asesoriaCancelacionhipoteca) {
        this.asesoriaCancelacionhipoteca = asesoriaCancelacionhipoteca;
    }

    public BigDecimal getAsesoriaImpuestocompraventa() {
        return asesoriaImpuestocompraventa;
    }

    public void setAsesoriaImpuestocompraventa(BigDecimal asesoriaImpuestocompraventa) {
        this.asesoriaImpuestocompraventa = asesoriaImpuestocompraventa;
    }

    public BigDecimal getAsesoriaImpuestotransferencia() {
        return asesoriaImpuestotransferencia;
    }

    public void setAsesoriaImpuestotransferencia(BigDecimal asesoriaImpuestotransferencia) {
        this.asesoriaImpuestotransferencia = asesoriaImpuestotransferencia;
    }

    public BigDecimal getAsesoriaTotalgasto() {
        return asesoriaTotalgasto;
    }

    public void setAsesoriaTotalgasto(BigDecimal asesoriaTotalgasto) {
        this.asesoriaTotalgasto = asesoriaTotalgasto;
    }

    public BigDecimal getAsesoriaCapitalinteres() {
        return asesoriaCapitalinteres;
    }

    public void setAsesoriaCapitalinteres(BigDecimal asesoriaCapitalinteres) {
        this.asesoriaCapitalinteres = asesoriaCapitalinteres;
    }

    public BigDecimal getAsesoriaSegurodeuda() {
        return asesoriaSegurodeuda;
    }

    public void setAsesoriaSegurodeuda(BigDecimal asesoriaSegurodeuda) {
        this.asesoriaSegurodeuda = asesoriaSegurodeuda;
    }

    public BigDecimal getAsesoriaSegurodanio() {
        return asesoriaSegurodanio;
    }

    public void setAsesoriaSegurodanio(BigDecimal asesoriaSegurodanio) {
        this.asesoriaSegurodanio = asesoriaSegurodanio;
    }

    public BigDecimal getAsesoriaCuota() {
        return asesoriaCuota;
    }

    public void setAsesoriaCuota(BigDecimal asesoriaCuota) {
        this.asesoriaCuota = asesoriaCuota;
    }

    public String getAsesoriaComentario() {
        return asesoriaComentario;
    }

    public void setAsesoriaComentario(String asesoriaComentario) {
        this.asesoriaComentario = asesoriaComentario;
    }

    public Boolean getAsesoriaCompleta() {
        return asesoriaCompleta;
    }

    public void setAsesoriaCompleta(Boolean asesoriaCompleta) {
        this.asesoriaCompleta = asesoriaCompleta;
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
    public Set<Promocion> getPromocionList() {
        return promocionList;
    }

    public void setPromocionList(Set<Promocion> promocionList) {
        this.promocionList = promocionList;
    }

    public Sucursal getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Sucursal sucursalId) {
        this.sucursalId = sucursalId;
    }

    public Detallelineacredito getDetallelineacreditoId() {
        return detallelineacreditoId;
    }

    public void setDetallelineacreditoId(Detallelineacredito detallelineacreditoId) {
        this.detallelineacreditoId = detallelineacreditoId;
    }

    public Solicitud getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Solicitud solicitudId) {
        this.solicitudId = solicitudId;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Requisitosolicitadonegocio> getRequisitosolicitadonegocioList() {
        return requisitosolicitadonegocioList;
    }

    public void setRequisitosolicitadonegocioList(Set<Requisitosolicitadonegocio> requisitosolicitadonegocioList) {
        this.requisitosolicitadonegocioList = requisitosolicitadonegocioList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Requisitosolicitadogarantia> getRequisitosolicitadogarantiaList() {
        return requisitosolicitadogarantiaList;
    }

    public void setRequisitosolicitadogarantiaList(Set<Requisitosolicitadogarantia> requisitosolicitadogarantiaList) {
        this.requisitosolicitadogarantiaList = requisitosolicitadogarantiaList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Garantiaasignadaasesoria> getGarantiaasignadaasesoriaList() {
        return garantiaasignadaasesoriaList;
    }

    public void setGarantiaasignadaasesoriaList(Set<Garantiaasignadaasesoria> garantiaasignadaasesoriaList) {
        this.garantiaasignadaasesoriaList = garantiaasignadaasesoriaList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Requisitosolicitadoempleado> getRequisitosolicitadoempleadoList() {
        return requisitosolicitadoempleadoList;
    }

    public void setRequisitosolicitadoempleadoList(Set<Requisitosolicitadoempleado> requisitosolicitadoempleadoList) {
        this.requisitosolicitadoempleadoList = requisitosolicitadoempleadoList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(Set<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asesoriaId != null ? asesoriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asesoria)) {
            return false;
        }
        Asesoria other = (Asesoria) object;
        if ((this.asesoriaId == null && other.asesoriaId != null) || (this.asesoriaId != null && !this.asesoriaId.equals(other.asesoriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Asesoria[ asesoriaId=" + asesoriaId + " ]";
    }

    public Periodicidadpago getPpId() {
        return ppId;
    }

    public void setPpId(Periodicidadpago ppId) {
        this.ppId = ppId;
    }

    public Formapago getFpId() {
        return fpId;
    }

    public void setFpId(Formapago fpId) {
        this.fpId = fpId;
    }

    public Tipoasesoria getTaId() {
        return taId;
    }

    public void setTaId(Tipoasesoria taId) {
        this.taId = taId;
    }

}
