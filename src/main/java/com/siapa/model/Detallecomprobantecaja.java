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
@Table(catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallecomprobantecaja.findAll", query = "SELECT d FROM Detallecomprobantecaja d")})
public class Detallecomprobantecaja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DCC_ID", nullable = false)
    private Long dccId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DCC_CODIGO", nullable = false, length = 30)
    private String dccCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DCC_CONCEPTO", nullable = false, length = 100)
    private String dccConcepto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DCC_PRECIOUNITARIO", precision = 10, scale = 2)
    private BigDecimal dccPreciounitario;
    @Column(name = "DCC_VENTASNOSUJETAS", precision = 10, scale = 2)
    private BigDecimal dccVentasnosujetas;
    @Column(name = "DCC_VENTASEXENTAS", precision = 10, scale = 2)
    private BigDecimal dccVentasexentas;
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
    @JoinColumn(name = "CC_ID", referencedColumnName = "CC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Comprobantecaja ccId;

    public Detallecomprobantecaja() {
    }

    public Detallecomprobantecaja(Long dccId) {
        this.dccId = dccId;
    }

    public Detallecomprobantecaja(Long dccId, String dccCodigo, String dccConcepto, String usuarioRegistro, Date fechaRegistro) {
        this.dccId = dccId;
        this.dccCodigo = dccCodigo;
        this.dccConcepto = dccConcepto;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Long getDccId() {
        return dccId;
    }

    public void setDccId(Long dccId) {
        this.dccId = dccId;
    }

    public String getDccCodigo() {
        return dccCodigo;
    }

    public void setDccCodigo(String dccCodigo) {
        this.dccCodigo = dccCodigo;
    }

    public String getDccConcepto() {
        return dccConcepto;
    }

    public void setDccConcepto(String dccConcepto) {
        this.dccConcepto = dccConcepto;
    }

    public BigDecimal getDccPreciounitario() {
        return dccPreciounitario;
    }

    public void setDccPreciounitario(BigDecimal dccPreciounitario) {
        this.dccPreciounitario = dccPreciounitario;
    }

    public BigDecimal getDccVentasnosujetas() {
        return dccVentasnosujetas;
    }

    public void setDccVentasnosujetas(BigDecimal dccVentasnosujetas) {
        this.dccVentasnosujetas = dccVentasnosujetas;
    }

    public BigDecimal getDccVentasexentas() {
        return dccVentasexentas;
    }

    public void setDccVentasexentas(BigDecimal dccVentasexentas) {
        this.dccVentasexentas = dccVentasexentas;
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

    public Comprobantecaja getCcId() {
        return ccId;
    }

    public void setCcId(Comprobantecaja ccId) {
        this.ccId = ccId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dccId != null ? dccId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallecomprobantecaja)) {
            return false;
        }
        Detallecomprobantecaja other = (Detallecomprobantecaja) object;
        if ((this.dccId == null && other.dccId != null) || (this.dccId != null && !this.dccId.equals(other.dccId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Detallecomprobantecaja[ dccId=" + dccId + " ]";
    }
    
}
