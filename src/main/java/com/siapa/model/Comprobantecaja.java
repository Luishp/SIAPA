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
@Table(name = "comprobantecaja", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comprobantecaja.findAll", query = "SELECT c FROM Comprobantecaja c")})
public class Comprobantecaja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CC_ID", nullable = false)
    private Long ccId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CC_VENTAGRABADA", precision = 10, scale = 2)
    private BigDecimal ccVentagrabada;
    @Column(name = "CC_IVARETENIDO", precision = 10, scale = 2)
    private BigDecimal ccIvaretenido;
    @Column(name = "CC_VENTANOSUJETA", precision = 10, scale = 2)
    private BigDecimal ccVentanosujeta;
    @Column(name = "CC_VENTAEXENTA", precision = 10, scale = 2)
    private BigDecimal ccVentaexenta;
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
    @OneToMany(mappedBy = "ccId", fetch = FetchType.LAZY)
    private List<Desembolso> desembolsoList;
    @OneToMany(mappedBy = "ccId", fetch = FetchType.LAZY)
    private List<Detallecomprobantecaja> detallecomprobantecajaList;
    @JoinColumn(name = "PAGOPRESTAMO_ID", referencedColumnName = "PAGOPRESTAMO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pagoprestamo pagoprestamoId;
    @JoinColumn(name = "DESEMBOLSO_ID", referencedColumnName = "DESEMBOLSO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Desembolso desembolsoId;
    @JoinColumn(name = "CAJA_ID", referencedColumnName = "CAJA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Caja cajaId;

    public Comprobantecaja() {
    }

    public Comprobantecaja(Long ccId) {
        this.ccId = ccId;
    }

    public Comprobantecaja(Long ccId, String usuarioRegistro, Date fechaRegistro) {
        this.ccId = ccId;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Long getCcId() {
        return ccId;
    }

    public void setCcId(Long ccId) {
        this.ccId = ccId;
    }

    public BigDecimal getCcVentagrabada() {
        return ccVentagrabada;
    }

    public void setCcVentagrabada(BigDecimal ccVentagrabada) {
        this.ccVentagrabada = ccVentagrabada;
    }

    public BigDecimal getCcIvaretenido() {
        return ccIvaretenido;
    }

    public void setCcIvaretenido(BigDecimal ccIvaretenido) {
        this.ccIvaretenido = ccIvaretenido;
    }

    public BigDecimal getCcVentanosujeta() {
        return ccVentanosujeta;
    }

    public void setCcVentanosujeta(BigDecimal ccVentanosujeta) {
        this.ccVentanosujeta = ccVentanosujeta;
    }

    public BigDecimal getCcVentaexenta() {
        return ccVentaexenta;
    }

    public void setCcVentaexenta(BigDecimal ccVentaexenta) {
        this.ccVentaexenta = ccVentaexenta;
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
    public List<Desembolso> getDesembolsoList() {
        return desembolsoList;
    }

    public void setDesembolsoList(List<Desembolso> desembolsoList) {
        this.desembolsoList = desembolsoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Detallecomprobantecaja> getDetallecomprobantecajaList() {
        return detallecomprobantecajaList;
    }

    public void setDetallecomprobantecajaList(List<Detallecomprobantecaja> detallecomprobantecajaList) {
        this.detallecomprobantecajaList = detallecomprobantecajaList;
    }

    public Pagoprestamo getPagoprestamoId() {
        return pagoprestamoId;
    }

    public void setPagoprestamoId(Pagoprestamo pagoprestamoId) {
        this.pagoprestamoId = pagoprestamoId;
    }

    public Desembolso getDesembolsoId() {
        return desembolsoId;
    }

    public void setDesembolsoId(Desembolso desembolsoId) {
        this.desembolsoId = desembolsoId;
    }

    public Caja getCajaId() {
        return cajaId;
    }

    public void setCajaId(Caja cajaId) {
        this.cajaId = cajaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccId != null ? ccId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comprobantecaja)) {
            return false;
        }
        Comprobantecaja other = (Comprobantecaja) object;
        if ((this.ccId == null && other.ccId != null) || (this.ccId != null && !this.ccId.equals(other.ccId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Comprobantecaja[ ccId=" + ccId + " ]";
    }

}
