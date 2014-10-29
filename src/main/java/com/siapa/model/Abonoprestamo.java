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
    @NamedQuery(name = "Abonoprestamo.findAll", query = "SELECT a FROM Abonoprestamo a")})
public class Abonoprestamo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AP_ID", nullable = false)
    private Integer apId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AP_MONTO", precision = 10, scale = 2)
    private BigDecimal apMonto;
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
    @JoinColumn(name = "PRESTAMO_ID", referencedColumnName = "PRESTAMO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Prestamo prestamoId;
    @JoinColumn(name = "DESEMBOLSO_ID", referencedColumnName = "DESEMBOLSO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Desembolso desembolsoId;

    public Abonoprestamo() {
    }

    public Abonoprestamo(Integer apId) {
        this.apId = apId;
    }

    public Abonoprestamo(Integer apId, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.apId = apId;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getApId() {
        return apId;
    }

    public void setApId(Integer apId) {
        this.apId = apId;
    }

    public BigDecimal getApMonto() {
        return apMonto;
    }

    public void setApMonto(BigDecimal apMonto) {
        this.apMonto = apMonto;
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

    public Prestamo getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(Prestamo prestamoId) {
        this.prestamoId = prestamoId;
    }

    public Desembolso getDesembolsoId() {
        return desembolsoId;
    }

    public void setDesembolsoId(Desembolso desembolsoId) {
        this.desembolsoId = desembolsoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apId != null ? apId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Abonoprestamo)) {
            return false;
        }
        Abonoprestamo other = (Abonoprestamo) object;
        if ((this.apId == null && other.apId != null) || (this.apId != null && !this.apId.equals(other.apId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Abonoprestamo[ apId=" + apId + " ]";
    }
    
}
