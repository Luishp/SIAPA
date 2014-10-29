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
@Table(name = "resolucion", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resolucion.findAll", query = "SELECT r FROM Resolucion r")})
public class Resolucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "RESOLUCION_ID", nullable = false)
    private Integer resolucionId;
    @Column(name = "RESOLUCION_APLICARORDEN")
    private Boolean resolucionAplicarorden;
    @Size(max = 500)
    @Column(name = "RESOLUCION_OBSERVACIONES", length = 500)
    private String resolucionObservaciones;
    @Column(name = "RESOLUCION_CUBRIRRELACION")
    private Boolean resolucionCubrirrelacion;
    @Column(name = "RESOLUCION_ELABORARLIQUIDACION")
    private Boolean resolucionElaborarliquidacion;
    @Column(name = "RESOLUCION_ORDENDESCUENTOCODEUDOR")
    private Boolean resolucionOrdendescuentocodeudor;
    @Column(name = "RESOLUCION_ORDENDESCUENTODEUDOR")
    private Boolean resolucionOrdendescuentodeudor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RESOLUCION_SALDOPRESTAMO", precision = 10, scale = 2)
    private BigDecimal resolucionSaldoprestamo;
    @Column(name = "RESOLUCION_INTERESFECHA", precision = 10, scale = 2)
    private BigDecimal resolucionInteresfecha;
    @Column(name = "RESOLUCION_APORTACION", precision = 10, scale = 2)
    private BigDecimal resolucionAportacion;
    @Column(name = "RESOLUCION_OTRO", precision = 10, scale = 2)
    private BigDecimal resolucionOtro;
    @Column(name = "RESOLUCION_LIQUIDOARECIBIR", precision = 10, scale = 2)
    private BigDecimal resolucionLiquidoarecibir;
    @Column(name = "RESOLUCION_CUOTATOTAL", precision = 10, scale = 2)
    private BigDecimal resolucionCuotatotal;
    @Size(max = 500)
    @Column(name = "RESOLUCION_COMENTARIO", length = 500)
    private String resolucionComentario;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_RESOLUCION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaResolucion;
    @Size(max = 15)
    @Column(name = "USUARIO_ULTIMAMODIFICACION", length = 15)
    private String usuarioUltimamodificacion;
    @Column(name = "FECHA_ULTIMAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimamodificacion;
    @OneToMany(mappedBy = "resolucionId", fetch = FetchType.LAZY)
    private List<Desembolso> desembolsoList;
    @OneToMany(mappedBy = "resolucionId", fetch = FetchType.LAZY)
    private List<Analisis> analisisList;
    @JoinColumn(name = "TIPORESOLUCION_ID", referencedColumnName = "TIPORESOLUCION_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tiporesolucion tiporesolucionId;
    @JoinColumn(name = "SUCURSAL_ID", referencedColumnName = "SUCURSAL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sucursal sucursalId;
    @JoinColumn(name = "DESEMBOLSO_ID", referencedColumnName = "DESEMBOLSO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Desembolso desembolsoId;
    @JoinColumn(name = "NR_ID", referencedColumnName = "NR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Nivelresolucion nrId;
    @JoinColumn(name = "ANALISIS_ID", referencedColumnName = "ANALISIS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Analisis analisisId;

    public Resolucion() {
    }

    public Resolucion(Integer resolucionId) {
        this.resolucionId = resolucionId;
    }

    public Resolucion(Integer resolucionId, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.resolucionId = resolucionId;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getResolucionId() {
        return resolucionId;
    }

    public void setResolucionId(Integer resolucionId) {
        this.resolucionId = resolucionId;
    }

    public Boolean getResolucionAplicarorden() {
        return resolucionAplicarorden;
    }

    public void setResolucionAplicarorden(Boolean resolucionAplicarorden) {
        this.resolucionAplicarorden = resolucionAplicarorden;
    }

    public String getResolucionObservaciones() {
        return resolucionObservaciones;
    }

    public void setResolucionObservaciones(String resolucionObservaciones) {
        this.resolucionObservaciones = resolucionObservaciones;
    }

    public Boolean getResolucionCubrirrelacion() {
        return resolucionCubrirrelacion;
    }

    public void setResolucionCubrirrelacion(Boolean resolucionCubrirrelacion) {
        this.resolucionCubrirrelacion = resolucionCubrirrelacion;
    }

    public Boolean getResolucionElaborarliquidacion() {
        return resolucionElaborarliquidacion;
    }

    public void setResolucionElaborarliquidacion(Boolean resolucionElaborarliquidacion) {
        this.resolucionElaborarliquidacion = resolucionElaborarliquidacion;
    }

    public Boolean getResolucionOrdendescuentocodeudor() {
        return resolucionOrdendescuentocodeudor;
    }

    public void setResolucionOrdendescuentocodeudor(Boolean resolucionOrdendescuentocodeudor) {
        this.resolucionOrdendescuentocodeudor = resolucionOrdendescuentocodeudor;
    }

    public Boolean getResolucionOrdendescuentodeudor() {
        return resolucionOrdendescuentodeudor;
    }

    public void setResolucionOrdendescuentodeudor(Boolean resolucionOrdendescuentodeudor) {
        this.resolucionOrdendescuentodeudor = resolucionOrdendescuentodeudor;
    }

    public BigDecimal getResolucionSaldoprestamo() {
        return resolucionSaldoprestamo;
    }

    public void setResolucionSaldoprestamo(BigDecimal resolucionSaldoprestamo) {
        this.resolucionSaldoprestamo = resolucionSaldoprestamo;
    }

    public BigDecimal getResolucionInteresfecha() {
        return resolucionInteresfecha;
    }

    public void setResolucionInteresfecha(BigDecimal resolucionInteresfecha) {
        this.resolucionInteresfecha = resolucionInteresfecha;
    }

    public BigDecimal getResolucionAportacion() {
        return resolucionAportacion;
    }

    public void setResolucionAportacion(BigDecimal resolucionAportacion) {
        this.resolucionAportacion = resolucionAportacion;
    }

    public BigDecimal getResolucionOtro() {
        return resolucionOtro;
    }

    public void setResolucionOtro(BigDecimal resolucionOtro) {
        this.resolucionOtro = resolucionOtro;
    }

    public BigDecimal getResolucionLiquidoarecibir() {
        return resolucionLiquidoarecibir;
    }

    public void setResolucionLiquidoarecibir(BigDecimal resolucionLiquidoarecibir) {
        this.resolucionLiquidoarecibir = resolucionLiquidoarecibir;
    }

    public BigDecimal getResolucionCuotatotal() {
        return resolucionCuotatotal;
    }

    public void setResolucionCuotatotal(BigDecimal resolucionCuotatotal) {
        this.resolucionCuotatotal = resolucionCuotatotal;
    }

    public String getResolucionComentario() {
        return resolucionComentario;
    }

    public void setResolucionComentario(String resolucionComentario) {
        this.resolucionComentario = resolucionComentario;
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

    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
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
    public List<Desembolso> getDesembolsoList() {
        return desembolsoList;
    }

    public void setDesembolsoList(List<Desembolso> desembolsoList) {
        this.desembolsoList = desembolsoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Analisis> getAnalisisList() {
        return analisisList;
    }

    public void setAnalisisList(List<Analisis> analisisList) {
        this.analisisList = analisisList;
    }

    public Tiporesolucion getTiporesolucionId() {
        return tiporesolucionId;
    }

    public void setTiporesolucionId(Tiporesolucion tiporesolucionId) {
        this.tiporesolucionId = tiporesolucionId;
    }

    public Sucursal getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Sucursal sucursalId) {
        this.sucursalId = sucursalId;
    }

    public Desembolso getDesembolsoId() {
        return desembolsoId;
    }

    public void setDesembolsoId(Desembolso desembolsoId) {
        this.desembolsoId = desembolsoId;
    }

    public Nivelresolucion getNrId() {
        return nrId;
    }

    public void setNrId(Nivelresolucion nrId) {
        this.nrId = nrId;
    }

    public Analisis getAnalisisId() {
        return analisisId;
    }

    public void setAnalisisId(Analisis analisisId) {
        this.analisisId = analisisId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resolucionId != null ? resolucionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resolucion)) {
            return false;
        }
        Resolucion other = (Resolucion) object;
        if ((this.resolucionId == null && other.resolucionId != null) || (this.resolucionId != null && !this.resolucionId.equals(other.resolucionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Resolucion[ resolucionId=" + resolucionId + " ]";
    }

}
