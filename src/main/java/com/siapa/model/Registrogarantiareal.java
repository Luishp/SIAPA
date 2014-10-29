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
@Table(name="registrogarantiareal",catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registrogarantiareal.findAll", query = "SELECT r FROM Registrogarantiareal r")})
public class Registrogarantiareal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "RGR_ID", nullable = false)
    private Integer rgrId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RGR_TIPO", nullable = false)
    private int rgrTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "RGR_NUMEROCUENTA", nullable = false, length = 10)
    private String rgrNumerocuenta;
    @Size(max = 10)
    @Column(name = "RGR_NUMERODEPOSITO", length = 10)
    private String rgrNumerodeposito;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "RGR_PORCENTAJEPIGNORADO", nullable = false, precision = 3, scale = 3)
    private BigDecimal rgrPorcentajepignorado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RGR_MONTODEPOSITO", nullable = false, precision = 10, scale = 2)
    private BigDecimal rgrMontodeposito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RGR_MONTOPIGNORADO", nullable = false, precision = 10, scale = 2)
    private BigDecimal rgrMontopignorado;
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
    @Column(name = "RGR_VALIDAR")
    private Boolean rgrValidar;
    @JoinColumn(name = "ANALISIS_ID", referencedColumnName = "ANALISIS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Analisis analisisId;

    public Registrogarantiareal() {
    }

    public Registrogarantiareal(Integer rgrId) {
        this.rgrId = rgrId;
    }

    public Registrogarantiareal(Integer rgrId, int rgrTipo, String rgrNumerocuenta, BigDecimal rgrPorcentajepignorado, BigDecimal rgrMontopignorado, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.rgrId = rgrId;
        this.rgrTipo = rgrTipo;
        this.rgrNumerocuenta = rgrNumerocuenta;
        this.rgrPorcentajepignorado = rgrPorcentajepignorado;
        this.rgrMontopignorado = rgrMontopignorado;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getRgrId() {
        return rgrId;
    }

    public void setRgrId(Integer rgrId) {
        this.rgrId = rgrId;
    }

    public int getRgrTipo() {
        return rgrTipo;
    }

    public void setRgrTipo(int rgrTipo) {
        this.rgrTipo = rgrTipo;
    }

    public String getRgrNumerocuenta() {
        return rgrNumerocuenta;
    }

    public void setRgrNumerocuenta(String rgrNumerocuenta) {
        this.rgrNumerocuenta = rgrNumerocuenta;
    }

    public String getRgrNumerodeposito() {
        return rgrNumerodeposito;
    }

    public void setRgrNumerodeposito(String rgrNumerodeposito) {
        this.rgrNumerodeposito = rgrNumerodeposito;
    }

    public BigDecimal getRgrPorcentajepignorado() {
        return rgrPorcentajepignorado;
    }

    public void setRgrPorcentajepignorado(BigDecimal rgrPorcentajepignorado) {
        this.rgrPorcentajepignorado = rgrPorcentajepignorado;
    }

    public BigDecimal getRgrMontopignorado() {
        return rgrMontopignorado;
    }

    public void setRgrMontopignorado(BigDecimal rgrMontopignorado) {
        this.rgrMontopignorado = rgrMontopignorado;
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

    public Boolean getRgrValidar() {
        return rgrValidar;
    }

    public void setRgrValidar(Boolean rgrValidar) {
        this.rgrValidar = rgrValidar;
    }

    public Analisis getAnalisisId() {
        return analisisId;
    }

    public void setAnalisisId(Analisis analisisId) {
        this.analisisId = analisisId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rgrId != null ? rgrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registrogarantiareal)) {
            return false;
        }
        Registrogarantiareal other = (Registrogarantiareal) object;
        if ((this.rgrId == null && other.rgrId != null) || (this.rgrId != null && !this.rgrId.equals(other.rgrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Registrogarantiareal[ rgrId=" + rgrId + " ]";
    }

    public BigDecimal getRgrMontodeposito() {
        return rgrMontodeposito;
    }

    public void setRgrMontodeposito(BigDecimal rgrMontodeposito) {
        this.rgrMontodeposito = rgrMontodeposito;
    }
    
}
