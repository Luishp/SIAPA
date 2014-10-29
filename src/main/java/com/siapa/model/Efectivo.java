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
@Table(name = "efectivo", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Efectivo.findAll", query = "SELECT e FROM Efectivo e")})
public class Efectivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "EFECTIVO_ID", nullable = true)
    private Integer efectivoId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "EFECTIVO_CANTIDAD", precision = 10, scale = 2)
    private BigDecimal efectivoCantidad;
    @Column(name = "EFECTIVO_ENTREGADO")
    private Boolean efectivoEntregado;
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
    @JoinColumn(name = "CAJA_ID", referencedColumnName = "CAJA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Caja cajaId;

    public Efectivo() {
    }

    public Efectivo(Integer efectivoId) {
        this.efectivoId = efectivoId;
    }

    public Efectivo(Integer efectivoId, String usuarioRegistro, Date fechaRegistro) {
        this.efectivoId = efectivoId;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getEfectivoId() {
        return efectivoId;
    }

    public void setEfectivoId(Integer efectivoId) {
        this.efectivoId = efectivoId;
    }

    public BigDecimal getEfectivoCantidad() {
        return efectivoCantidad;
    }

    public void setEfectivoCantidad(BigDecimal efectivoCantidad) {
        this.efectivoCantidad = efectivoCantidad;
    }

    public Boolean getEfectivoEntregado() {
        return efectivoEntregado;
    }

    public void setEfectivoEntregado(Boolean efectivoEntregado) {
        this.efectivoEntregado = efectivoEntregado;
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

    public Caja getCajaId() {
        return cajaId;
    }

    public void setCajaId(Caja cajaId) {
        this.cajaId = cajaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (efectivoId != null ? efectivoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Efectivo)) {
            return false;
        }
        Efectivo other = (Efectivo) object;
        if ((this.efectivoId == null && other.efectivoId != null) || (this.efectivoId != null && !this.efectivoId.equals(other.efectivoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Efectivo[ efectivoId=" + efectivoId + " ]";
    }

}
