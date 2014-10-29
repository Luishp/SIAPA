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
@Table(catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provisiondiaria.findAll", query = "SELECT p FROM Provisiondiaria p")})
public class Provisiondiaria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROVISIONDIARIA_ID", nullable = false)
    private Integer provisiondiariaId;
    @Column(name = "PROVISIONDIARIA_FECHA")
    @Temporal(TemporalType.DATE)
    private Date provisiondiariaFecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PROVISIONDIARIA_INTERESNORMAL", precision = 10, scale = 2)
    private BigDecimal provisiondiariaInteresnormal;
    @Column(name = "PROVISIONDIARIA_INTERESMORATORIO", precision = 10, scale = 2)
    private BigDecimal provisiondiariaInteresmoratorio;
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
    @JoinColumn(name = "PRESTAMO_ID", referencedColumnName = "PRESTAMO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Prestamo prestamoId;

    public Provisiondiaria() {
    }

    public Provisiondiaria(Integer provisiondiariaId) {
        this.provisiondiariaId = provisiondiariaId;
    }

    public Provisiondiaria(Integer provisiondiariaId, String usuarioRegistro, Date fechaRegistro) {
        this.provisiondiariaId = provisiondiariaId;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getProvisiondiariaId() {
        return provisiondiariaId;
    }

    public void setProvisiondiariaId(Integer provisiondiariaId) {
        this.provisiondiariaId = provisiondiariaId;
    }

    public Date getProvisiondiariaFecha() {
        return provisiondiariaFecha;
    }

    public void setProvisiondiariaFecha(Date provisiondiariaFecha) {
        this.provisiondiariaFecha = provisiondiariaFecha;
    }

    public BigDecimal getProvisiondiariaInteresnormal() {
        return provisiondiariaInteresnormal;
    }

    public void setProvisiondiariaInteresnormal(BigDecimal provisiondiariaInteresnormal) {
        this.provisiondiariaInteresnormal = provisiondiariaInteresnormal;
    }

    public BigDecimal getProvisiondiariaInteresmoratorio() {
        return provisiondiariaInteresmoratorio;
    }

    public void setProvisiondiariaInteresmoratorio(BigDecimal provisiondiariaInteresmoratorio) {
        this.provisiondiariaInteresmoratorio = provisiondiariaInteresmoratorio;
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

    public Prestamo getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(Prestamo prestamoId) {
        this.prestamoId = prestamoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provisiondiariaId != null ? provisiondiariaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provisiondiaria)) {
            return false;
        }
        Provisiondiaria other = (Provisiondiaria) object;
        if ((this.provisiondiariaId == null && other.provisiondiariaId != null) || (this.provisiondiariaId != null && !this.provisiondiariaId.equals(other.provisiondiariaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Provisiondiaria[ provisiondiariaId=" + provisiondiariaId + " ]";
    }
    
}
