/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name="requisitogarantia", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisitogarantia.findAll", query = "SELECT r FROM Requisitogarantia r")})
public class Requisitogarantia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RG_ID", nullable = false)
    private Integer rgId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "RG_NOMBRE", nullable = false, length = 60)
    private String rgNombre;
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
    @ManyToMany(mappedBy = "requisitogarantiaList", fetch = FetchType.LAZY)
    private List<Garantia> garantiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitogarantia", fetch = FetchType.LAZY)
    private List<Requisitosolicitadogarantia> requisitosolicitadogarantiaList;

    public Requisitogarantia() {
    }

    public Requisitogarantia(Integer rgId) {
        this.rgId = rgId;
    }

    public Requisitogarantia(Integer rgId, String rgNombre, String usuarioRegistro, Date fechaRegistro) {
        this.rgId = rgId;
        this.rgNombre = rgNombre;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getRgId() {
        return rgId;
    }

    public void setRgId(Integer rgId) {
        this.rgId = rgId;
    }

    public String getRgNombre() {
        return rgNombre;
    }

    public void setRgNombre(String rgNombre) {
        this.rgNombre = rgNombre;
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
    public List<Garantia> getGarantiaList() {
        return garantiaList;
    }

    public void setGarantiaList(List<Garantia> garantiaList) {
        this.garantiaList = garantiaList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Requisitosolicitadogarantia> getRequisitosolicitadogarantiaList() {
        return requisitosolicitadogarantiaList;
    }

    public void setRequisitosolicitadogarantiaList(List<Requisitosolicitadogarantia> requisitosolicitadogarantiaList) {
        this.requisitosolicitadogarantiaList = requisitosolicitadogarantiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rgId != null ? rgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisitogarantia)) {
            return false;
        }
        Requisitogarantia other = (Requisitogarantia) object;
        if ((this.rgId == null && other.rgId != null) || (this.rgId != null && !this.rgId.equals(other.rgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Requisitogarantia[ rgId=" + rgId + " ]";
    }
    
}
