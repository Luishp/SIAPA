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
@Table(catalog = "siacofinges", schema = "", name="Descuento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descuento.findAll", query = "SELECT d FROM Descuento d")})
public class Descuento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue
    @Column(name = "DESCUENTO_ID", nullable = false)
    private Integer descuentoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DECUENTO_NOMBREINSTITUCION", nullable = false, length = 50)
    private String decuentoNombreinstitucion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESCEUNTO_CUOTA", nullable = false, precision = 10, scale = 2)
    private BigDecimal desceuntoCuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESCUENTO_PORCENTAJE", nullable = false, precision = 3, scale = 2)
    private BigDecimal descuentoPorcentaje;
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
    @JoinColumn(name = "ANALISIS_ID", referencedColumnName = "ANALISIS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Analisis analisisId;
    @JoinColumn(name = "AC_ID", referencedColumnName = "AC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Analisiscodeudor acId;

    public Descuento() {
    }

    public Descuento(Integer descuentoId) {
        this.descuentoId = descuentoId;
    }

    public Descuento(Integer descuentoId, String decuentoNombreinstitucion, BigDecimal desceuntoCuota, BigDecimal descuentoPorcentaje, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.descuentoId = descuentoId;
        this.decuentoNombreinstitucion = decuentoNombreinstitucion;
        this.desceuntoCuota = desceuntoCuota;
        this.descuentoPorcentaje = descuentoPorcentaje;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getDescuentoId() {
        return descuentoId;
    }

    public void setDescuentoId(Integer descuentoId) {
        this.descuentoId = descuentoId;
    }

    public String getDecuentoNombreinstitucion() {
        return decuentoNombreinstitucion;
    }

    public void setDecuentoNombreinstitucion(String decuentoNombreinstitucion) {
        this.decuentoNombreinstitucion = decuentoNombreinstitucion;
    }

    public BigDecimal getDesceuntoCuota() {
        return desceuntoCuota;
    }

    public void setDesceuntoCuota(BigDecimal desceuntoCuota) {
        this.desceuntoCuota = desceuntoCuota;
    }

    public BigDecimal getDescuentoPorcentaje() {
        return descuentoPorcentaje;
    }

    public void setDescuentoPorcentaje(BigDecimal descuentoPorcentaje) {
        this.descuentoPorcentaje = descuentoPorcentaje;
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
        hash += (descuentoId != null ? descuentoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descuento)) {
            return false;
        }
        Descuento other = (Descuento) object;
        if ((this.descuentoId == null && other.descuentoId != null) || (this.descuentoId != null && !this.descuentoId.equals(other.descuentoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Descuento[ descuentoId=" + descuentoId + " ]";
    }
    
}
