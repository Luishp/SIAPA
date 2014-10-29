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
@Table(name = "cheque", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cheque.findAll", query = "SELECT c FROM Cheque c")})
public class Cheque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue
    @Column(name = "CHEQUE_ID", nullable = false)
    private Integer chequeId;
    @Column(name = "CHEQUE_FECHA")
    @Temporal(TemporalType.DATE)
    private Date chequeFecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CHEQUE_MONTO", precision = 10, scale = 2)
    private BigDecimal chequeMonto;
    @Size(max = 100)
    @Column(name = "CHEQUE_BENEFICIARIO", length = 100)
    private String chequeBeneficiario;
    @Size(max = 500)
    @Column(name = "CHEQUE_CONCEPTO", length = 500)
    private String chequeConcepto;
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
    @JoinColumn(name = "DESEMBOLSO_ID", referencedColumnName = "DESEMBOLSO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Desembolso desembolsoId;
    @JoinColumn(name = "BANCO_ID", referencedColumnName = "BANCO_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Banco bancoId;

    public Cheque() {
    }

    public Cheque(Integer chequeId) {
        this.chequeId = chequeId;
    }

    public Cheque(Integer chequeId, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.chequeId = chequeId;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getChequeId() {
        return chequeId;
    }

    public void setChequeId(Integer chequeId) {
        this.chequeId = chequeId;
    }

    public Date getChequeFecha() {
        return chequeFecha;
    }

    public void setChequeFecha(Date chequeFecha) {
        this.chequeFecha = chequeFecha;
    }

    public BigDecimal getChequeMonto() {
        return chequeMonto;
    }

    public void setChequeMonto(BigDecimal chequeMonto) {
        this.chequeMonto = chequeMonto;
    }

    public String getChequeBeneficiario() {
        return chequeBeneficiario;
    }

    public void setChequeBeneficiario(String chequeBeneficiario) {
        this.chequeBeneficiario = chequeBeneficiario;
    }

    public String getChequeConcepto() {
        return chequeConcepto;
    }

    public void setChequeConcepto(String chequeConcepto) {
        this.chequeConcepto = chequeConcepto;
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

    public Desembolso getDesembolsoId() {
        return desembolsoId;
    }

    public void setDesembolsoId(Desembolso desembolsoId) {
        this.desembolsoId = desembolsoId;
    }

    public Banco getBancoId() {
        return bancoId;
    }

    public void setBancoId(Banco bancoId) {
        this.bancoId = bancoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chequeId != null ? chequeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cheque)) {
            return false;
        }
        Cheque other = (Cheque) object;
        if ((this.chequeId == null && other.chequeId != null) || (this.chequeId != null && !this.chequeId.equals(other.chequeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Cheque[ chequeId=" + chequeId + " ]";
    }

}
