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
@Table(name = "lineacredito", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineacredito.findAll", query = "SELECT l FROM Lineacredito l")})
public class Lineacredito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "LINEACREDITO_ID", nullable = false)
    private Integer lineacreditoId;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "LINEACREDITO_NOMBRE", nullable = true, length = 60)
    private String lineacreditoNombre;
    @Column(name = "LINEACREDITO_GRUPO")
    private Short lineacreditoGrupo;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "LINEACREDITO_DESTINO", nullable = true, length = 200)
    private String lineacreditoDestino;
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
    @OneToMany(mappedBy = "lineacreditoId", fetch = FetchType.EAGER)
    private List<Requisitolineacreditoempleado> requisitolineacreditoempleadoList;
    @OneToMany(mappedBy = "lineacreditoId", fetch = FetchType.LAZY)
    private List<Detallelineacredito> detallelineacreditoList;
    @OneToMany(mappedBy = "lineacreditoId", fetch = FetchType.LAZY)
    private List<Requisitolineacreditonegocio> requisitolineacreditonegocioList;

    public Lineacredito() {
    }

    public Lineacredito(Integer lineacreditoId) {
        this.lineacreditoId = lineacreditoId;
    }

    public Lineacredito(Integer lineacreditoId, String lineacreditoNombre, String lineacreditoDestino, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.lineacreditoId = lineacreditoId;
        this.lineacreditoNombre = lineacreditoNombre;
        this.lineacreditoDestino = lineacreditoDestino;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getLineacreditoId() {
        return lineacreditoId;
    }

    public void setLineacreditoId(Integer lineacreditoId) {
        this.lineacreditoId = lineacreditoId;
    }

    public String getLineacreditoNombre() {
        return lineacreditoNombre;
    }

    public void setLineacreditoNombre(String lineacreditoNombre) {
        this.lineacreditoNombre = lineacreditoNombre;
    }

    public Short getLineacreditoGrupo() {
        return lineacreditoGrupo;
    }

    public void setLineacreditoGrupo(Short lineacreditoGrupo) {
        this.lineacreditoGrupo = lineacreditoGrupo;
    }

    public String getLineacreditoDestino() {
        return lineacreditoDestino;
    }

    public void setLineacreditoDestino(String lineacreditoDestino) {
        this.lineacreditoDestino = lineacreditoDestino;
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

    @XmlTransient
    @JsonIgnore
    public List<Requisitolineacreditoempleado> getRequisitolineacreditoempleadoList() {
        return requisitolineacreditoempleadoList;
    }

    public void setRequisitolineacreditoempleadoList(List<Requisitolineacreditoempleado> requisitolineacreditoempleadoList) {
        this.requisitolineacreditoempleadoList = requisitolineacreditoempleadoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Detallelineacredito> getDetallelineacreditoList() {
        return detallelineacreditoList;
    }

    public void setDetallelineacreditoList(List<Detallelineacredito> detallelineacreditoList) {
        this.detallelineacreditoList = detallelineacreditoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Requisitolineacreditonegocio> getRequisitolineacreditonegocioList() {
        return requisitolineacreditonegocioList;
    }

    public void setRequisitolineacreditonegocioList(List<Requisitolineacreditonegocio> requisitolineacreditonegocioList) {
        this.requisitolineacreditonegocioList = requisitolineacreditonegocioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lineacreditoId != null ? lineacreditoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineacredito)) {
            return false;
        }
        Lineacredito other = (Lineacredito) object;
        if ((this.lineacreditoId == null && other.lineacreditoId != null) || (this.lineacreditoId != null && !this.lineacreditoId.equals(other.lineacreditoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Lineacredito[ lineacreditoId=" + lineacreditoId + " ]";
    }

}
