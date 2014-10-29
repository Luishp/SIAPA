/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
@Table(name = "propiedad", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propiedad.findAll", query = "SELECT p FROM Propiedad p")})
public class Propiedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "PROPIEDAD_ID", nullable = true)
    private Integer propiedadId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PROPIEDAD_CLASE", nullable = false, length = 100)
    private String propiedadClase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "PROPIEDAD_UBICACION", nullable = false, length = 300)
    private String propiedadUbicacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROPIEDAD_VALOR", nullable = false, precision = 10, scale = 2)
    private BigDecimal propiedadValor;
    @Size(max = 60)
    @Column(name = "PROPIEDAD_HIPOTECAFAVOR", length = 60)
    private String propiedadHipotecafavor;
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
    @JoinColumn(name = "SOLICITUD_ID", referencedColumnName = "SOLICITUD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Solicitud solicitudId;
    @JoinColumn(name = "RGC_ID", referencedColumnName = "RGC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Registrogarantiacodeudor rgcId;

    public Propiedad() {
    }

    public Propiedad(Integer propiedadId) {
        this.propiedadId = propiedadId;
    }

    public Propiedad(Integer propiedadId, String propiedadClase, String propiedadUbicacion, BigDecimal propiedadValor, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.propiedadId = propiedadId;
        this.propiedadClase = propiedadClase;
        this.propiedadUbicacion = propiedadUbicacion;
        this.propiedadValor = propiedadValor;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getPropiedadId() {
        return propiedadId;
    }

    public void setPropiedadId(Integer propiedadId) {
        this.propiedadId = propiedadId;
    }

    public String getPropiedadClase() {
        return propiedadClase;
    }

    public void setPropiedadClase(String propiedadClase) {
        this.propiedadClase = propiedadClase;
    }

    public String getPropiedadUbicacion() {
        return propiedadUbicacion;
    }

    public void setPropiedadUbicacion(String propiedadUbicacion) {
        this.propiedadUbicacion = propiedadUbicacion;
    }

    public BigDecimal getPropiedadValor() {
        return propiedadValor;
    }

    public void setPropiedadValor(BigDecimal propiedadValor) {
        this.propiedadValor = propiedadValor;
    }

    public String getPropiedadHipotecafavor() {
        return propiedadHipotecafavor;
    }

    public void setPropiedadHipotecafavor(String propiedadHipotecafavor) {
        this.propiedadHipotecafavor = propiedadHipotecafavor;
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

    public Solicitud getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Solicitud solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Registrogarantiacodeudor getRgcId() {
        return rgcId;
    }

    public void setRgcId(Registrogarantiacodeudor rgcId) {
        this.rgcId = rgcId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propiedadId != null ? propiedadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propiedad)) {
            return false;
        }
        Propiedad other = (Propiedad) object;
        if ((this.propiedadId == null && other.propiedadId != null) || (this.propiedadId != null && !this.propiedadId.equals(other.propiedadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Propiedad[ propiedadId=" + propiedadId + " ]";
    }

}
