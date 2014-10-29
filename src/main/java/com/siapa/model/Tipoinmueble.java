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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "tipoinmueble", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoinmueble.findAll", query = "SELECT d FROM Tipoinmueble d")})
public class Tipoinmueble implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "TIM_ID", nullable = false)
    private Integer tipoInmuebleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIM_NOMBRE", nullable = false, length = 50)
    private String tipoInmuebleNombre;
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

    public Tipoinmueble() {
    }

    public Tipoinmueble(Integer tipoInmuebleId) {
        this.tipoInmuebleId = tipoInmuebleId;
    }

    public Tipoinmueble(Integer tipoInmuebleId, String tipoInmuebleNombre, String usuarioRegistro, Date fechaRegistro) {
        this.tipoInmuebleId = tipoInmuebleId;
        this.tipoInmuebleNombre = tipoInmuebleNombre;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getDeudaId() {
        return tipoInmuebleId;
    }

    public void setDeudaId(Integer tipoInmuebleId) {
        this.tipoInmuebleId = tipoInmuebleId;
    }

    public Integer getTipoInmuebleId() {
        return tipoInmuebleId;
    }

    public void setTipoInmuebleId(Integer tipoInmuebleId) {
        this.tipoInmuebleId = tipoInmuebleId;
    }

    public String getTipoInmuebleNombre() {
        return tipoInmuebleNombre;
    }

    public void setTipoInmuebleNombre(String tipoInmuebleNombre) {
        this.tipoInmuebleNombre = tipoInmuebleNombre;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoInmuebleId != null ? tipoInmuebleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deuda)) {
            return false;
        }
        Tipoinmueble other = (Tipoinmueble) object;
        return (this.tipoInmuebleId != null || other.tipoInmuebleId == null) && (this.tipoInmuebleId == null || this.tipoInmuebleId.equals(other.tipoInmuebleId));
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Tipoinmueble[ tipoInmuebleId=" + tipoInmuebleId + " ]";
    }

}
