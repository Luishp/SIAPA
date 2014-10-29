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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "garantia", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Garantia.findAll", query = "SELECT g FROM Garantia g")})
public class Garantia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
//    @Basic(optional = false)
//    @NotNull
    @GeneratedValue
    @Column(name = "GARANTIA_ID", nullable = false)
    private Integer garantiaId;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "GARANTIA_NOMBRE", nullable = true, length = 50)
    private String garantiaNombre;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "GARANTIA_TIPO", nullable = true, length = 50)
    private String garantiaTipo;
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
    @JoinTable(name = "fk_tipogarantia_requisitotipogarantia", joinColumns = {
        @JoinColumn(name = "GARANTIA_ID", referencedColumnName = "GARANTIA_ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "RG_ID", referencedColumnName = "RG_ID", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Requisitogarantia> requisitogarantiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "garantia", fetch = FetchType.LAZY)
    private List<Garantiaexigida> garantiaexigidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "garantia", fetch = FetchType.LAZY)
    private List<Garantiaasignadaanalisis> garantiaasignadaanalisisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "garantia", fetch = FetchType.LAZY)
    private List<Garantiaasignadaasesoria> garantiaasignadaasesoriaList;
    private transient Integer cantidad;

    public Garantia() {
    }

    public Garantia(Integer garantiaId) {
        this.garantiaId = garantiaId;
    }

    public Garantia(Integer garantiaId, String garantiaNombre, String garantiaTipo, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.garantiaId = garantiaId;
        this.garantiaNombre = garantiaNombre;
        this.garantiaTipo = garantiaTipo;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getGarantiaId() {
        return garantiaId;
    }

    public void setGarantiaId(Integer garantiaId) {
        this.garantiaId = garantiaId;
    }

    public String getGarantiaNombre() {
        return garantiaNombre;
    }

    public void setGarantiaNombre(String garantiaNombre) {
        this.garantiaNombre = garantiaNombre;
    }

    public String getGarantiaTipo() {
        return garantiaTipo;
    }

    public void setGarantiaTipo(String garantiaTipo) {
        this.garantiaTipo = garantiaTipo;
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
    public List<Requisitogarantia> getRequisitogarantiaList() {
        return requisitogarantiaList;
    }

    public void setRequisitogarantiaList(List<Requisitogarantia> requisitogarantiaList) {
        this.requisitogarantiaList = requisitogarantiaList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Garantiaexigida> getGarantiaexigidaList() {
        return garantiaexigidaList;
    }

    public void setGarantiaexigidaList(List<Garantiaexigida> garantiaexigidaList) {
        this.garantiaexigidaList = garantiaexigidaList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Garantiaasignadaanalisis> getGarantiaasignadaanalisisList() {
        return garantiaasignadaanalisisList;
    }

    public void setGarantiaasignadaanalisisList(List<Garantiaasignadaanalisis> garantiaasignadaanalisisList) {
        this.garantiaasignadaanalisisList = garantiaasignadaanalisisList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Garantiaasignadaasesoria> getGarantiaasignadaasesoriaList() {
        return garantiaasignadaasesoriaList;
    }

    public void setGarantiaasignadaasesoriaList(List<Garantiaasignadaasesoria> garantiaasignadaasesoriaList) {
        this.garantiaasignadaasesoriaList = garantiaasignadaasesoriaList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.garantiaId != null ? this.garantiaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Garantia other = (Garantia) obj;
        if (this.garantiaId != other.garantiaId && (this.garantiaId == null || !this.garantiaId.equals(other.garantiaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Garantia[ garantiaId=" + garantiaId + " ]";
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
