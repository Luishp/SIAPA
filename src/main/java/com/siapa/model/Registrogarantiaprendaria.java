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
@Table(name="registrogarantiaprendaria",catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registrogarantiaprendaria.findAll", query = "SELECT r FROM Registrogarantiaprendaria r")})
public class Registrogarantiaprendaria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "RGP_PLACA", nullable = false, length = 7)
    private String rgpPlaca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "RGP_CLASE", nullable = false, length = 30)
    private String rgpClase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "RGP_MARCA", nullable = false, length = 30)
    private String rgpMarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "RGP_ANIO", nullable = false, length = 4)
    private String rgpAnio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "RGP_MODELO", nullable = false, length = 30)
    private String rgpModelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "RGP_PERITOVALUADOR", nullable = false, length = 100)
    private String rgpPeritovaluador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RGP_FECHAVALUO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date rgpFechavaluo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "RGP_VALORVALUO", nullable = false, precision = 10, scale = 2)
    private BigDecimal rgpValorvaluo;
    @Size(max = 30)
    @Column(name = "RGP_CARNETNOTARIO", length = 30)
    private String rgpCarnetnotario;
    @Size(max = 100)
    @Column(name = "RGP_NOMBRENOTARIO", length = 100)
    private String rgpNombrenotario;
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
    @Column(name = "RGP_VALIDAR")
    private Boolean rgpValidar;
    @JoinColumn(name = "ANALISIS_ID", referencedColumnName = "ANALISIS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Analisis analisisId;

    public Registrogarantiaprendaria() {
    }

    public Registrogarantiaprendaria(String rgpPlaca) {
        this.rgpPlaca = rgpPlaca;
    }

    public Registrogarantiaprendaria(String rgpPlaca, String rgpClase, String rgpMarca, String rgpAnio, String rgpModelo, String rgpPeritovaluador, Date rgpFechavaluo, BigDecimal rgpValorvaluo, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.rgpPlaca = rgpPlaca;
        this.rgpClase = rgpClase;
        this.rgpMarca = rgpMarca;
        this.rgpAnio = rgpAnio;
        this.rgpModelo = rgpModelo;
        this.rgpPeritovaluador = rgpPeritovaluador;
        this.rgpFechavaluo = rgpFechavaluo;
        this.rgpValorvaluo = rgpValorvaluo;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public String getRgpPlaca() {
        return rgpPlaca;
    }

    public void setRgpPlaca(String rgpPlaca) {
        this.rgpPlaca = rgpPlaca;
    }

    public String getRgpClase() {
        return rgpClase;
    }

    public void setRgpClase(String rgpClase) {
        this.rgpClase = rgpClase;
    }

    public String getRgpMarca() {
        return rgpMarca;
    }

    public void setRgpMarca(String rgpMarca) {
        this.rgpMarca = rgpMarca;
    }

    public String getRgpAnio() {
        return rgpAnio;
    }

    public void setRgpAnio(String rgpAnio) {
        this.rgpAnio = rgpAnio;
    }

    public String getRgpModelo() {
        return rgpModelo;
    }

    public void setRgpModelo(String rgpModelo) {
        this.rgpModelo = rgpModelo;
    }

    public String getRgpPeritovaluador() {
        return rgpPeritovaluador;
    }

    public void setRgpPeritovaluador(String rgpPeritovaluador) {
        this.rgpPeritovaluador = rgpPeritovaluador;
    }

    public Date getRgpFechavaluo() {
        return rgpFechavaluo;
    }

    public void setRgpFechavaluo(Date rgpFechavaluo) {
        this.rgpFechavaluo = rgpFechavaluo;
    }

    public BigDecimal getRgpValorvaluo() {
        return rgpValorvaluo;
    }

    public void setRgpValorvaluo(BigDecimal rgpValorvaluo) {
        this.rgpValorvaluo = rgpValorvaluo;
    }

    public String getRgpCarnetnotario() {
        return rgpCarnetnotario;
    }

    public void setRgpCarnetnotario(String rgpCarnetnotario) {
        this.rgpCarnetnotario = rgpCarnetnotario;
    }

    public String getRgpNombrenotario() {
        return rgpNombrenotario;
    }

    public void setRgpNombrenotario(String rgpNombrenotario) {
        this.rgpNombrenotario = rgpNombrenotario;
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

    public Boolean getRgpValidar() {
        return rgpValidar;
    }

    public void setRgpValidar(Boolean rgpValidar) {
        this.rgpValidar = rgpValidar;
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
        hash += (rgpPlaca != null ? rgpPlaca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registrogarantiaprendaria)) {
            return false;
        }
        Registrogarantiaprendaria other = (Registrogarantiaprendaria) object;
        if ((this.rgpPlaca == null && other.rgpPlaca != null) || (this.rgpPlaca != null && !this.rgpPlaca.equals(other.rgpPlaca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Registrogarantiaprendaria[ rgpPlaca=" + rgpPlaca + " ]";
    }
    
}
