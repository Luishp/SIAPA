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
@Table(catalog = "siacofinges", schema = "", name = "registrogarantiahipotecaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registrogarantiahipotecaria.findAll", query = "SELECT r FROM Registrogarantiahipotecaria r")})
public class Registrogarantiahipotecaria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "RGH_ID", nullable = true)
    private Integer rghId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "RGH_MATRICULA", nullable = false, length = 30)
    private String rghMatricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "RGH_DIRECCION", nullable = false, length = 100)
    private String rghDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "RGH_PERITOVALUADOR", nullable = false, length = 100)
    private String rghPeritovaluador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RGH_FECHAVALUO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date rghFechavaluo;
    @Size(max = 2)
    @Column(name = "RGH_CALIFICACION", length = 2)
    private String rghCalificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RGH_FECHACONSTRUCCION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date rghFechaconstruccion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "RGH_AREAREGISTRAL", nullable = false, precision = 10, scale = 3)
    private BigDecimal rghArearegistral;
    @Column(name = "RGH_VALORCAMPO", precision = 10, scale = 3)
    private BigDecimal rghValorcampo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RGH_VALORTIERRA", nullable = false, precision = 10, scale = 2)
    private BigDecimal rghValortierra;
    @Column(name = "RGH_VALORCONSTRUCCION", precision = 10, scale = 2)
    private BigDecimal rghValorconstruccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RGH_VALORVALUO", nullable = false, precision = 10, scale = 2)
    private BigDecimal rghValorvaluo;
    @Size(max = 100)
    @Column(name = "RGH_NOMBREINSTITUCION", length = 100)
    private String rghNombreinstitucion;
    @Column(name = "RGH_VALORHIPOTECA", precision = 10, scale = 2)
    private BigDecimal rghValorhipoteca;
    @Column(name = "RGH_SALDOACTUAL", precision = 10, scale = 2)
    private BigDecimal rghSaldoactual;
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
    @Column(name = "RGH_VALIDAR")
    private Boolean rghValidar;
    @JoinColumn(name = "ANALISIS_ID", referencedColumnName = "ANALISIS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Analisis analisisId;
    @JoinColumn(name = "TIM_ID", referencedColumnName = "TIM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tipoinmueble tipoInmuebleId;
    @JoinColumn(name = "ID_MUNICIPIO", referencedColumnName = "ID_MUNICIPIO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Municipios idMunicipio;
    public Registrogarantiahipotecaria() {
    }

    public Registrogarantiahipotecaria(Integer rghId) {
        this.rghId = rghId;
    }

    public Registrogarantiahipotecaria(Integer rghId,String rghMatricula, String rghDireccion, String rghPeritovaluador, Date rghFechavaluo, Date rghFechaconstruccion, BigDecimal rghArearegistral, BigDecimal rghValortierra, BigDecimal rghValorvaluo, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.rghId = rghId;
        this.rghMatricula = rghMatricula;
        this.rghDireccion = rghDireccion;
        this.rghPeritovaluador = rghPeritovaluador;
        this.rghFechavaluo = rghFechavaluo;
        this.rghFechaconstruccion = rghFechaconstruccion;
        this.rghArearegistral = rghArearegistral;
        this.rghValortierra = rghValortierra;
        this.rghValorvaluo = rghValorvaluo;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getRghId() {
        return rghId;
    }

    public void setRghId(Integer rghId) {
        this.rghId = rghId;
    }

    public String getRghMatricula() {
        return rghMatricula;
    }

    public void setRghMatricula(String rghMatricula) {
        this.rghMatricula = rghMatricula;
    }

    public String getRghDireccion() {
        return rghDireccion;
    }

    public void setRghDireccion(String rghDireccion) {
        this.rghDireccion = rghDireccion;
    }

    public String getRghPeritovaluador() {
        return rghPeritovaluador;
    }

    public void setRghPeritovaluador(String rghPeritovaluador) {
        this.rghPeritovaluador = rghPeritovaluador;
    }

    public Date getRghFechavaluo() {
        return rghFechavaluo;
    }

    public void setRghFechavaluo(Date rghFechavaluo) {
        this.rghFechavaluo = rghFechavaluo;
    }

    public String getRghCalificacion() {
        return rghCalificacion;
    }

    public void setRghCalificacion(String rghCalificacion) {
        this.rghCalificacion = rghCalificacion;
    }

    public Date getRghFechaconstruccion() {
        return rghFechaconstruccion;
    }

    public void setRghFechaconstruccion(Date rghFechaconstruccion) {
        this.rghFechaconstruccion = rghFechaconstruccion;
    }

    public BigDecimal getRghArearegistral() {
        return rghArearegistral;
    }

    public void setRghArearegistral(BigDecimal rghArearegistral) {
        this.rghArearegistral = rghArearegistral;
    }

    public BigDecimal getRghValorcampo() {
        return rghValorcampo;
    }

    public void setRghValorcampo(BigDecimal rghValorcampo) {
        this.rghValorcampo = rghValorcampo;
    }

    public BigDecimal getRghValortierra() {
        return rghValortierra;
    }

    public void setRghValortierra(BigDecimal rghValortierra) {
        this.rghValortierra = rghValortierra;
    }

    public BigDecimal getRghValorconstruccion() {
        return rghValorconstruccion;
    }

    public void setRghValorconstruccion(BigDecimal rghValorconstruccion) {
        this.rghValorconstruccion = rghValorconstruccion;
    }

    public BigDecimal getRghValorvaluo() {
        return rghValorvaluo;
    }

    public void setRghValorvaluo(BigDecimal rghValorvaluo) {
        this.rghValorvaluo = rghValorvaluo;
    }

    public String getRghNombreinstitucion() {
        return rghNombreinstitucion;
    }

    public void setRghNombreinstitucion(String rghNombreinstitucion) {
        this.rghNombreinstitucion = rghNombreinstitucion;
    }

    public BigDecimal getRghValorhipoteca() {
        return rghValorhipoteca;
    }

    public void setRghValorhipoteca(BigDecimal rghValorhipoteca) {
        this.rghValorhipoteca = rghValorhipoteca;
    }

    public BigDecimal getRghSaldoactual() {
        return rghSaldoactual;
    }

    public void setRghSaldoactual(BigDecimal rghSaldoactual) {
        this.rghSaldoactual = rghSaldoactual;
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

    public Boolean getRghValidar() {
        return rghValidar;
    }

    public void setRghValidar(Boolean rghValidar) {
        this.rghValidar = rghValidar;
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
        hash += (rghId != null ? rghId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registrogarantiahipotecaria)) {
            return false;
        }
        Registrogarantiahipotecaria other = (Registrogarantiahipotecaria) object;
        if ((this.rghId == null && other.rghId != null) || (this.rghId != null && !this.rghId.equals(other.rghId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Registrogarantiahipotecaria[ rghId=" + rghId + " ]";
    }

    public Tipoinmueble getTipoInmuebleId() {
        return tipoInmuebleId;
    }

    public void setTipoInmuebleId(Tipoinmueble tipoInmuebleId) {
        this.tipoInmuebleId = tipoInmuebleId;
    }

    public Municipios getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Municipios idMunicipio) {
        this.idMunicipio = idMunicipio;
    }
    
}
