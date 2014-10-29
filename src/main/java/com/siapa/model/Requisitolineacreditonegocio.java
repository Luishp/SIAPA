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
@Table(name="requisitolineacreditonegocio",catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisitolineacreditonegocio.findAll", query = "SELECT r FROM Requisitolineacreditonegocio r")})
public class Requisitolineacreditonegocio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
//    @Basic(optional = false)
    @GeneratedValue
//    @NotNull
    @Column(name = "REQUISITO_LINEACREDITONEGOCIO_ID", nullable = false)
    private Integer requisitoLineacreditonegocioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "REQUISITO_LINEACREDITONEGOCIO_NOMBRE", nullable = false, length = 60)
    private String requisitoLineacreditonegocioNombre;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitolineacreditonegocio", fetch = FetchType.LAZY)
    private List<Requisitosolicitadonegocio> requisitosolicitadonegocioList;
    @JoinColumn(name = "LINEACREDITO_ID", referencedColumnName = "LINEACREDITO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Lineacredito lineacreditoId;

    public Requisitolineacreditonegocio() {
    }

    public Requisitolineacreditonegocio(Integer requisitoLineacreditonegocioId) {
        this.requisitoLineacreditonegocioId = requisitoLineacreditonegocioId;
    }

    public Requisitolineacreditonegocio(Integer requisitoLineacreditonegocioId, String requisitoLineacreditonegocioNombre, String usuarioRegistro, Date fechaRegistro) {
        this.requisitoLineacreditonegocioId = requisitoLineacreditonegocioId;
        this.requisitoLineacreditonegocioNombre = requisitoLineacreditonegocioNombre;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getRequisitoLineacreditonegocioId() {
        return requisitoLineacreditonegocioId;
    }

    public void setRequisitoLineacreditonegocioId(Integer requisitoLineacreditonegocioId) {
        this.requisitoLineacreditonegocioId = requisitoLineacreditonegocioId;
    }

    public String getRequisitoLineacreditonegocioNombre() {
        return requisitoLineacreditonegocioNombre;
    }

    public void setRequisitoLineacreditonegocioNombre(String requisitoLineacreditonegocioNombre) {
        this.requisitoLineacreditonegocioNombre = requisitoLineacreditonegocioNombre;
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
    public List<Requisitosolicitadonegocio> getRequisitosolicitadonegocioList() {
        return requisitosolicitadonegocioList;
    }

    public void setRequisitosolicitadonegocioList(List<Requisitosolicitadonegocio> requisitosolicitadonegocioList) {
        this.requisitosolicitadonegocioList = requisitosolicitadonegocioList;
    }

    public Lineacredito getLineacreditoId() {
        return lineacreditoId;
    }

    public void setLineacreditoId(Lineacredito lineacreditoId) {
        this.lineacreditoId = lineacreditoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitoLineacreditonegocioId != null ? requisitoLineacreditonegocioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisitolineacreditonegocio)) {
            return false;
        }
        Requisitolineacreditonegocio other = (Requisitolineacreditonegocio) object;
        if ((this.requisitoLineacreditonegocioId == null && other.requisitoLineacreditonegocioId != null) || (this.requisitoLineacreditonegocioId != null && !this.requisitoLineacreditonegocioId.equals(other.requisitoLineacreditonegocioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Requisitolineacreditonegocio[ requisitoLineacreditonegocioId=" + requisitoLineacreditonegocioId + " ]";
    }

}
