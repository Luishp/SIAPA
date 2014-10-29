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
import javax.persistence.ManyToOne;
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
@Table(name = "requisitolineacreditoempleado", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisitolineacreditoempleado.findAll", query = "SELECT r FROM Requisitolineacreditoempleado r")})
public class Requisitolineacreditoempleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
//    @Basic(optional = false)
    @GeneratedValue
//    @NotNull
    @Column(name = "REQUISITOLINEACREDITOEMPLEADO_ID", nullable = false)
    private Integer requisitolineacreditoempleadoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "REQUISITOLINEACREDITOEMPLEADO_NOMBRE", nullable = false, length = 60)
    private String requisitolineacreditoempleadoNombre;
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
    @JoinColumn(name = "LINEACREDITO_ID", referencedColumnName = "LINEACREDITO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Lineacredito lineacreditoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitolineacreditoempleado", fetch = FetchType.LAZY)
    private List<Requisitosolicitadoempleado> requisitosolicitadoempleadoList;

    public Requisitolineacreditoempleado() {
    }

    public Requisitolineacreditoempleado(Integer requisitolineacreditoempleadoId) {
        this.requisitolineacreditoempleadoId = requisitolineacreditoempleadoId;
    }

    public Requisitolineacreditoempleado(Integer requisitolineacreditoempleadoId, String requisitolineacreditoempleadoNombre, String usuarioRegistro, Date fechaRegistro) {
        this.requisitolineacreditoempleadoId = requisitolineacreditoempleadoId;
        this.requisitolineacreditoempleadoNombre = requisitolineacreditoempleadoNombre;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getRequisitolineacreditoempleadoId() {
        return requisitolineacreditoempleadoId;
    }

    public void setRequisitolineacreditoempleadoId(Integer requisitolineacreditoempleadoId) {
        this.requisitolineacreditoempleadoId = requisitolineacreditoempleadoId;
    }

    public String getRequisitolineacreditoempleadoNombre() {
        return requisitolineacreditoempleadoNombre;
    }

    public void setRequisitolineacreditoempleadoNombre(String requisitolineacreditoempleadoNombre) {
        this.requisitolineacreditoempleadoNombre = requisitolineacreditoempleadoNombre;
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

    public Lineacredito getLineacreditoId() {
        return lineacreditoId;
    }

    public void setLineacreditoId(Lineacredito lineacreditoId) {
        this.lineacreditoId = lineacreditoId;
    }

    @XmlTransient
    @JsonIgnore
    public List<Requisitosolicitadoempleado> getRequisitosolicitadoempleadoList() {
        return requisitosolicitadoempleadoList;
    }

    public void setRequisitosolicitadoempleadoList(List<Requisitosolicitadoempleado> requisitosolicitadoempleadoList) {
        this.requisitosolicitadoempleadoList = requisitosolicitadoempleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitolineacreditoempleadoId != null ? requisitolineacreditoempleadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisitolineacreditoempleado)) {
            return false;
        }
        Requisitolineacreditoempleado other = (Requisitolineacreditoempleado) object;
        if ((this.requisitolineacreditoempleadoId == null && other.requisitolineacreditoempleadoId != null) || (this.requisitolineacreditoempleadoId != null && !this.requisitolineacreditoempleadoId.equals(other.requisitolineacreditoempleadoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Requisitolineacreditoempleado[ requisitolineacreditoempleadoId=" + requisitolineacreditoempleadoId + " ]";
    }

}
