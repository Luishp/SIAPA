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
@Table(name = "ahorro", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ahorro.findAll", query = "SELECT a FROM Ahorro a")})
public class Ahorro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue
    @Column(name = "AHORRO_ID", nullable = false)
    private Integer ahorroId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AHORRO_MONTO", precision = 10, scale = 2)
    private BigDecimal ahorroMonto;
    @Column(name = "AHORRO_CUENTA")
    private Integer ahorroCuenta;
    @Column(name = "AHORRO_APLICADO")
    private Boolean ahorroAplicado;
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
    @JoinColumn(name = "DESEMBOLSO_ID", referencedColumnName = "DESEMBOLSO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Desembolso desembolsoId;

    public Ahorro() {
    }

    public Ahorro(Integer ahorroId) {
        this.ahorroId = ahorroId;
    }

    public Ahorro(Integer ahorroId, String usuarioRegistro, Date fechaRegistro) {
        this.ahorroId = ahorroId;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getAhorroId() {
        return ahorroId;
    }

    public void setAhorroId(Integer ahorroId) {
        this.ahorroId = ahorroId;
    }

    public BigDecimal getAhorroMonto() {
        return ahorroMonto;
    }

    public void setAhorroMonto(BigDecimal ahorroMonto) {
        this.ahorroMonto = ahorroMonto;
    }

    public Integer getAhorroCuenta() {
        return ahorroCuenta;
    }

    public void setAhorroCuenta(Integer ahorroCuenta) {
        this.ahorroCuenta = ahorroCuenta;
    }

    public Boolean getAhorroAplicado() {
        return ahorroAplicado;
    }

    public void setAhorroAplicado(Boolean ahorroAplicado) {
        this.ahorroAplicado = ahorroAplicado;
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

    public Desembolso getDesembolsoId() {
        return desembolsoId;
    }

    public void setDesembolsoId(Desembolso desembolsoId) {
        this.desembolsoId = desembolsoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ahorroId != null ? ahorroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ahorro)) {
            return false;
        }
        Ahorro other = (Ahorro) object;
        if ((this.ahorroId == null && other.ahorroId != null) || (this.ahorroId != null && !this.ahorroId.equals(other.ahorroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Ahorro[ ahorroId=" + ahorroId + " ]";
    }

}
