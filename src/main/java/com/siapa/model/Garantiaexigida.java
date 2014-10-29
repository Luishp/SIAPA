/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marlon.andrade
 */
@Entity
@Table(name="garantiaexigida", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Garantiaexigida.findAll", query = "SELECT g FROM Garantiaexigida g")})
public class Garantiaexigida implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GarantiaexigidaPK garantiaexigidaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GE_CANTIDAD", nullable = false)
    private int geCantidad;
    @JoinColumn(name = "GARANTIA_ID", referencedColumnName = "GARANTIA_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Garantia garantia;
    @JoinColumn(name = "DETALLELINEACREDITO_ID", referencedColumnName = "DETALLELINEACREDITO_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Detallelineacredito detallelineacredito;

    public Garantiaexigida() {
    }

    public Garantiaexigida(GarantiaexigidaPK garantiaexigidaPK) {
        this.garantiaexigidaPK = garantiaexigidaPK;
    }

    public Garantiaexigida(GarantiaexigidaPK garantiaexigidaPK, int geCantidad) {
        this.garantiaexigidaPK = garantiaexigidaPK;
        this.geCantidad = geCantidad;
    }

    public Garantiaexigida(int detallelineacreditoId, int garantiaId) {
        this.garantiaexigidaPK = new GarantiaexigidaPK(detallelineacreditoId, garantiaId);
    }

    public GarantiaexigidaPK getGarantiaexigidaPK() {
        return garantiaexigidaPK;
    }

    public void setGarantiaexigidaPK(GarantiaexigidaPK garantiaexigidaPK) {
        this.garantiaexigidaPK = garantiaexigidaPK;
    }

    public int getGeCantidad() {
        return geCantidad;
    }

    public void setGeCantidad(int geCantidad) {
        this.geCantidad = geCantidad;
    }

    public Garantia getGarantia() {
        return garantia;
    }

    public void setGarantia(Garantia garantia) {
        this.garantia = garantia;
    }

    public Detallelineacredito getDetallelineacredito() {
        return detallelineacredito;
    }

    public void setDetallelineacredito(Detallelineacredito detallelineacredito) {
        this.detallelineacredito = detallelineacredito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (garantiaexigidaPK != null ? garantiaexigidaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Garantiaexigida)) {
            return false;
        }
        Garantiaexigida other = (Garantiaexigida) object;
        if ((this.garantiaexigidaPK == null && other.garantiaexigidaPK != null) || (this.garantiaexigidaPK != null && !this.garantiaexigidaPK.equals(other.garantiaexigidaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Garantiaexigida[ garantiaexigidaPK=" + garantiaexigidaPK + " ]";
    }
    
}
