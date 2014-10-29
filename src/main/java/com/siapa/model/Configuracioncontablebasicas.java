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
@Table(catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuracioncontablebasicas.findAll", query = "SELECT c FROM Configuracioncontablebasicas c")})
public class Configuracioncontablebasicas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CCB_ID", nullable = false)
    private Integer ccbId;
    @Size(max = 100)
    @Column(name = "CCB_NOMBRE", length = 100)
    private String ccbNombre;
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

    public Configuracioncontablebasicas() {
    }

    public Configuracioncontablebasicas(Integer ccbId) {
        this.ccbId = ccbId;
    }

    public Configuracioncontablebasicas(Integer ccbId, String usuarioRegistro, Date fechaRegistro) {
        this.ccbId = ccbId;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getCcbId() {
        return ccbId;
    }

    public void setCcbId(Integer ccbId) {
        this.ccbId = ccbId;
    }

    public String getCcbNombre() {
        return ccbNombre;
    }

    public void setCcbNombre(String ccbNombre) {
        this.ccbNombre = ccbNombre;
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
        hash += (ccbId != null ? ccbId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuracioncontablebasicas)) {
            return false;
        }
        Configuracioncontablebasicas other = (Configuracioncontablebasicas) object;
        if ((this.ccbId == null && other.ccbId != null) || (this.ccbId != null && !this.ccbId.equals(other.ccbId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Configuracioncontablebasicas[ ccbId=" + ccbId + " ]";
    }
    
}
