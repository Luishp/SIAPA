/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
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
@Table(name="tipodeduccion", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodeduccion.findAll", query = "SELECT t FROM Tipodeduccion t")})
public class Tipodeduccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPODEDUCCION_ID", nullable = false)
    private Integer tipodeduccionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TIPODEDUCCION_NOMBRE", nullable = false, length = 100)
    private String tipodeduccionNombre;
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
    @JoinColumn(name = "CC_ID2", referencedColumnName = "CC_ID2")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cuentacontable ccId2;

    public Tipodeduccion() {
    }

    public Tipodeduccion(Integer tipodeduccionId) {
        this.tipodeduccionId = tipodeduccionId;
    }

    public Tipodeduccion(Integer tipodeduccionId, String tipodeduccionNombre, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.tipodeduccionId = tipodeduccionId;
        this.tipodeduccionNombre = tipodeduccionNombre;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getTipodeduccionId() {
        return tipodeduccionId;
    }

    public void setTipodeduccionId(Integer tipodeduccionId) {
        this.tipodeduccionId = tipodeduccionId;
    }

    public String getTipodeduccionNombre() {
        return tipodeduccionNombre;
    }

    public void setTipodeduccionNombre(String tipodeduccionNombre) {
        this.tipodeduccionNombre = tipodeduccionNombre;
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

  
    public Cuentacontable getCcId2() {
        return ccId2;
    }

    public void setCcId2(Cuentacontable ccId2) {
        this.ccId2 = ccId2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipodeduccionId != null ? tipodeduccionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodeduccion)) {
            return false;
        }
        Tipodeduccion other = (Tipodeduccion) object;
        if ((this.tipodeduccionId == null && other.tipodeduccionId != null) || (this.tipodeduccionId != null && !this.tipodeduccionId.equals(other.tipodeduccionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Tipodeduccion[ tipodeduccionId=" + tipodeduccionId + " ]";
    }
    
}
