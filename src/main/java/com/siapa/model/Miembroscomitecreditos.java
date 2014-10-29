/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name="miembroscomitecreditos", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Miembroscomitecreditos.findAll", query = "SELECT m FROM Miembroscomitecreditos m")})
public class Miembroscomitecreditos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MCC_ID", nullable = false)
    private Integer mccId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MCC_NOMBRE", nullable = false, length = 100)
    private String mccNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "MCC_CARGO", nullable = false, length = 60)
    private String mccCargo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MCC_ESTADO", nullable = false)
    private boolean mccEstado;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "miembroscomitecreditos", fetch = FetchType.LAZY)
    private Set<Asistente> asistenteList;

    public Miembroscomitecreditos() {
    }

    public Miembroscomitecreditos(Integer mccId) {
        this.mccId = mccId;
    }

    public Miembroscomitecreditos(Integer mccId, String mccNombre, String mccCargo, boolean mccEstado, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.mccId = mccId;
        this.mccNombre = mccNombre;
        this.mccCargo = mccCargo;
        this.mccEstado = mccEstado;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getMccId() {
        return mccId;
    }

    public void setMccId(Integer mccId) {
        this.mccId = mccId;
    }

    public String getMccNombre() {
        return mccNombre;
    }

    public void setMccNombre(String mccNombre) {
        this.mccNombre = mccNombre;
    }

    public String getMccCargo() {
        return mccCargo;
    }

    public void setMccCargo(String mccCargo) {
        this.mccCargo = mccCargo;
    }

    public boolean getMccEstado() {
        return mccEstado;
    }

    public void setMccEstado(boolean mccEstado) {
        this.mccEstado = mccEstado;
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

    @XmlTransient
    @JsonIgnore
    public Set<Asistente> getAsistenteList() {
        return asistenteList;
    }

    public void setAsistenteList(Set<Asistente> asistenteList) {
        this.asistenteList = asistenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mccId != null ? mccId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Miembroscomitecreditos)) {
            return false;
        }
        Miembroscomitecreditos other = (Miembroscomitecreditos) object;
        if ((this.mccId == null && other.mccId != null) || (this.mccId != null && !this.mccId.equals(other.mccId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Miembroscomitecreditos[ mccId=" + mccId + " ]";
    }
    
}
