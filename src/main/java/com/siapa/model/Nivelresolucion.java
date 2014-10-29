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
@Table(name="nivelresolucion",catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nivelresolucion.findAll", query = "SELECT n FROM Nivelresolucion n")})
public class Nivelresolucion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NR_ID", nullable = false)
    private Integer nrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NR_NOMBRE", nullable = false, length = 100)
    private String nrNombre;
    @Size(max = 500)
    @Column(name = "NR_DESCRIPCION", length = 500)
    private String nrDescripcion;
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
    @OneToMany(mappedBy = "nrId", fetch = FetchType.LAZY)
    private List<Resolucion> resolucionList;

    public Nivelresolucion() {
    }

    public Nivelresolucion(Integer nrId) {
        this.nrId = nrId;
    }

    public Nivelresolucion(Integer nrId, String nrNombre, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.nrId = nrId;
        this.nrNombre = nrNombre;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getNrId() {
        return nrId;
    }

    public void setNrId(Integer nrId) {
        this.nrId = nrId;
    }

    public String getNrNombre() {
        return nrNombre;
    }

    public void setNrNombre(String nrNombre) {
        this.nrNombre = nrNombre;
    }

    public String getNrDescripcion() {
        return nrDescripcion;
    }

    public void setNrDescripcion(String nrDescripcion) {
        this.nrDescripcion = nrDescripcion;
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
    public List<Resolucion> getResolucionList() {
        return resolucionList;
    }

    public void setResolucionList(List<Resolucion> resolucionList) {
        this.resolucionList = resolucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrId != null ? nrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nivelresolucion)) {
            return false;
        }
        Nivelresolucion other = (Nivelresolucion) object;
        if ((this.nrId == null && other.nrId != null) || (this.nrId != null && !this.nrId.equals(other.nrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Nivelresolucion[ nrId=" + nrId + " ]";
    }
    
}
