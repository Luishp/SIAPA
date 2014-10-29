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
@Table(name = "cuentacontable", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuentacontable.findAll", query = "SELECT c FROM Cuentacontable c")})
public class Cuentacontable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CC_ID2", nullable = false, length = 20)
    private String ccId2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "CC_NOMBRECUENTA", nullable = false, length = 250)
    private String ccNombrecuenta;
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
    @OneToMany(mappedBy = "ccId2", fetch = FetchType.LAZY)
    private List<Caja> cajaList;
    @OneToMany(mappedBy = "ccId2", fetch = FetchType.LAZY)
    private List<Tipodeduccion> tipodeduccionList;
    @OneToMany(mappedBy = "ccId2", fetch = FetchType.LAZY)
    private List<Lineacredito> lineacreditoList;
    @OneToMany(mappedBy = "ccId2", fetch = FetchType.LAZY)
    private List<Configuracioncontablebasicas> configuracioncontablebasicasList;
    @OneToMany(mappedBy = "ccId2", fetch = FetchType.LAZY)
    private List<Banco> bancoList;

    public Cuentacontable() {
    }

    public Cuentacontable(String ccId2) {
        this.ccId2 = ccId2;
    }

    public Cuentacontable(String ccId2, String ccNombrecuenta, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.ccId2 = ccId2;
        this.ccNombrecuenta = ccNombrecuenta;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public String getCcId2() {
        return ccId2;
    }

    public void setCcId2(String ccId2) {
        this.ccId2 = ccId2;
    }

    public String getCcNombrecuenta() {
        return ccNombrecuenta;
    }

    public void setCcNombrecuenta(String ccNombrecuenta) {
        this.ccNombrecuenta = ccNombrecuenta;
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
    public List<Caja> getCajaList() {
        return cajaList;
    }

    public void setCajaList(List<Caja> cajaList) {
        this.cajaList = cajaList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Tipodeduccion> getTipodeduccionList() {
        return tipodeduccionList;
    }

    public void setTipodeduccionList(List<Tipodeduccion> tipodeduccionList) {
        this.tipodeduccionList = tipodeduccionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Lineacredito> getLineacreditoList() {
        return lineacreditoList;
    }

    public void setLineacreditoList(List<Lineacredito> lineacreditoList) {
        this.lineacreditoList = lineacreditoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Configuracioncontablebasicas> getConfiguracioncontablebasicasList() {
        return configuracioncontablebasicasList;
    }

    public void setConfiguracioncontablebasicasList(List<Configuracioncontablebasicas> configuracioncontablebasicasList) {
        this.configuracioncontablebasicasList = configuracioncontablebasicasList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Banco> getBancoList() {
        return bancoList;
    }

    public void setBancoList(List<Banco> bancoList) {
        this.bancoList = bancoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccId2 != null ? ccId2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentacontable)) {
            return false;
        }
        Cuentacontable other = (Cuentacontable) object;
        if ((this.ccId2 == null && other.ccId2 != null) || (this.ccId2 != null && !this.ccId2.equals(other.ccId2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Cuentacontable[ ccId2=" + ccId2 + " ]";
    }

}
