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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
@Table(name = "sucursal", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s")})
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "SUCURSAL_ID", nullable = true)
    private Integer sucursalId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SUCURSAL_NOMBRE", nullable = false, length = 100)
    private String sucursalNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "SUCURSAL_DIRECCION", nullable = false, length = 500)
    private String sucursalDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "SUCURSAL_TELEFONO", nullable = false, length = 9)
    private String sucursalTelefono;
    @Size(max = 9)
    @Column(name = "SUCURSAL_FAX", length = 9)
    private String sucursalFax;
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
    @OneToMany(mappedBy = "sucursalId", fetch = FetchType.LAZY)
    private List<Asesoria> asesoriaList;
    @OneToMany(mappedBy = "sucursalId", fetch = FetchType.LAZY)
    private List<Caja> cajaList;
    @OneToMany(mappedBy = "sucursalId", fetch = FetchType.LAZY)
    private List<Desembolso> desembolsoList;
    @OneToMany(mappedBy = "sucursalId", fetch = FetchType.LAZY)
    private List<Analisis> analisisList;
    @OneToMany(mappedBy = "sucursalId", fetch = FetchType.LAZY)
    private List<Resolucion> resolucionList;
    @OneToMany(mappedBy = "sucursalId", fetch = FetchType.LAZY)
    private List<Solicitud> solicitudList;

    public Sucursal() {
    }

    public Sucursal(Integer sucursalId) {
        this.sucursalId = sucursalId;
    }

    public Sucursal(Integer sucursalId, String sucursalNombre, String sucursalDireccion, String sucursalTelefono, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.sucursalId = sucursalId;
        this.sucursalNombre = sucursalNombre;
        this.sucursalDireccion = sucursalDireccion;
        this.sucursalTelefono = sucursalTelefono;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Integer sucursalId) {
        this.sucursalId = sucursalId;
    }

    public String getSucursalNombre() {
        return sucursalNombre;
    }

    public void setSucursalNombre(String sucursalNombre) {
        this.sucursalNombre = sucursalNombre;
    }

    public String getSucursalDireccion() {
        return sucursalDireccion;
    }

    public void setSucursalDireccion(String sucursalDireccion) {
        this.sucursalDireccion = sucursalDireccion;
    }

    public String getSucursalTelefono() {
        return sucursalTelefono;
    }

    public void setSucursalTelefono(String sucursalTelefono) {
        this.sucursalTelefono = sucursalTelefono;
    }

    public String getSucursalFax() {
        return sucursalFax;
    }

    public void setSucursalFax(String sucursalFax) {
        this.sucursalFax = sucursalFax;
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
    public List<Asesoria> getAsesoriaList() {
        return asesoriaList;
    }

    public void setAsesoriaList(List<Asesoria> asesoriaList) {
        this.asesoriaList = asesoriaList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Caja> getCajaList() {
        return cajaList;
    }

    public void setCajaList(List<Caja> cajaList) {
        this.cajaList = cajaList;
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
    public List<Analisis> getAnalisisList() {
        return analisisList;
    }

    public void setAnalisisList(List<Analisis> analisisList) {
        this.analisisList = analisisList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Resolucion> getResolucionList() {
        return resolucionList;
    }

    public void setResolucionList(List<Resolucion> resolucionList) {
        this.resolucionList = resolucionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sucursalId != null ? sucursalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.sucursalId == null && other.sucursalId != null) || (this.sucursalId != null && !this.sucursalId.equals(other.sucursalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Sucursal[ sucursalId=" + sucursalId + " ]";
    }

}
