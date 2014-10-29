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
@Table(name="tiporesolucion", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiporesolucion.findAll", query = "SELECT t FROM Tiporesolucion t")})
public class Tiporesolucion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPORESOLUCION_ID", nullable = false)
    private Integer tiporesolucionId;
    @Size(max = 100)
    @Column(name = "TIPORESOLUCION_NOMBRE", length = 100)
    private String tiporesolucionNombre;
    @Size(max = 500)
    @Column(name = "TIPORESOLUCION_DESCRIPCION", length = 500)
    private String tiporesolucionDescripcion;
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
    @OneToMany(mappedBy = "tiporesolucionId", fetch = FetchType.LAZY)
    private Set<Resolucion> resolucionList;
    @OneToMany(mappedBy = "tiporesolucionId", fetch = FetchType.LAZY)
    private Set<Analisisenagendacomitecreditos> analisisenagendacomitecreditosList;
    @OneToMany(mappedBy = "tiporesolucionId", fetch = FetchType.LAZY)
    private Set<Analisis> analisisList;

    public Tiporesolucion() {
    }

    public Tiporesolucion(Integer tiporesolucionId) {
        this.tiporesolucionId = tiporesolucionId;
    }

    public Tiporesolucion(Integer tiporesolucionId, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.tiporesolucionId = tiporesolucionId;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getTiporesolucionId() {
        return tiporesolucionId;
    }

    public void setTiporesolucionId(Integer tiporesolucionId) {
        this.tiporesolucionId = tiporesolucionId;
    }

    public String getTiporesolucionNombre() {
        return tiporesolucionNombre;
    }

    public void setTiporesolucionNombre(String tiporesolucionNombre) {
        this.tiporesolucionNombre = tiporesolucionNombre;
    }

    public String getTiporesolucionDescripcion() {
        return tiporesolucionDescripcion;
    }

    public void setTiporesolucionDescripcion(String tiporesolucionDescripcion) {
        this.tiporesolucionDescripcion = tiporesolucionDescripcion;
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
    public Set<Resolucion> getResolucionList() {
        return resolucionList;
    }

    public void setResolucionList(Set<Resolucion> resolucionList) {
        this.resolucionList = resolucionList;
    }
    
    @XmlTransient
    @JsonIgnore
    public Set<Analisisenagendacomitecreditos> getAnalisisenagendacomitecreditosList() {
        return analisisenagendacomitecreditosList;
    }

    public void setAnalisisenagendacomitecreditosList(Set<Analisisenagendacomitecreditos> analisisenagendacomitecreditosList) {
        this.analisisenagendacomitecreditosList = analisisenagendacomitecreditosList;
    }
    
    @XmlTransient
    @JsonIgnore
    public Set<Analisis> getAnalisisList() {
        return analisisList;
    }

    public void setAnalisisList(Set<Analisis> analisisList) {
        this.analisisList = analisisList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiporesolucionId != null ? tiporesolucionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiporesolucion)) {
            return false;
        }
        Tiporesolucion other = (Tiporesolucion) object;
        if ((this.tiporesolucionId == null && other.tiporesolucionId != null) || (this.tiporesolucionId != null && !this.tiporesolucionId.equals(other.tiporesolucionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Tiporesolucion[ tiporesolucionId=" + tiporesolucionId + " ]";
    }
    
}
