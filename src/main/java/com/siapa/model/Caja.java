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
@Table(name = "caja", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caja.findAll", query = "SELECT c FROM Caja c")})
public class Caja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "CAJA_ID", nullable = true)
    private Integer cajaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CAJA_NOMBRE", nullable = false, length = 100)
    private String cajaNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "CAJA_DESCRIPCION", nullable = false, length = 500)
    private String cajaDescripcion;
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
    @JoinColumn(name = "SUCURSAL_ID", referencedColumnName = "SUCURSAL_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Sucursal sucursalId;
    @JoinColumn(name = "CC_ID2", referencedColumnName = "CC_ID2")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cuentacontable ccId2;
    @OneToMany(mappedBy = "cajaId", fetch = FetchType.LAZY)
    private List<Efectivo> efectivoList;
    @OneToMany(mappedBy = "cajaId", fetch = FetchType.LAZY)
    private List<Comprobantecaja> comprobantecajaList;

    public Caja() {
    }

    public Caja(Integer cajaId) {
        this.cajaId = cajaId;
    }

    public Caja(Integer cajaId, String cajaNombre, String cajaDescripcion, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.cajaId = cajaId;
        this.cajaNombre = cajaNombre;
        this.cajaDescripcion = cajaDescripcion;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getCajaId() {
        return cajaId;
    }

    public void setCajaId(Integer cajaId) {
        this.cajaId = cajaId;
    }

    public String getCajaNombre() {
        return cajaNombre;
    }

    public void setCajaNombre(String cajaNombre) {
        this.cajaNombre = cajaNombre;
    }

    public String getCajaDescripcion() {
        return cajaDescripcion;
    }

    public void setCajaDescripcion(String cajaDescripcion) {
        this.cajaDescripcion = cajaDescripcion;
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

    public Sucursal getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Sucursal sucursalId) {
        this.sucursalId = sucursalId;
    }

    public Cuentacontable getCcId2() {
        return ccId2;
    }

    public void setCcId2(Cuentacontable ccId2) {
        this.ccId2 = ccId2;
    }

    @XmlTransient
    @JsonIgnore
    public List<Efectivo> getEfectivoList() {
        return efectivoList;
    }

    public void setEfectivoList(List<Efectivo> efectivoList) {
        this.efectivoList = efectivoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Comprobantecaja> getComprobantecajaList() {
        return comprobantecajaList;
    }

    public void setComprobantecajaList(List<Comprobantecaja> comprobantecajaList) {
        this.comprobantecajaList = comprobantecajaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cajaId != null ? cajaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caja)) {
            return false;
        }
        Caja other = (Caja) object;
        if ((this.cajaId == null && other.cajaId != null) || (this.cajaId != null && !this.cajaId.equals(other.cajaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Caja[ cajaId=" + cajaId + " ]";
    }

}
