/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author marlon.andrade
 */
@Embeddable
public class GarantiaexigidaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "DETALLELINEACREDITO_ID", nullable = false)
    private int detallelineacreditoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GARANTIA_ID", nullable = false)
    private int garantiaId;

    public GarantiaexigidaPK() {
    }

    public GarantiaexigidaPK(int detallelineacreditoId, int garantiaId) {
        this.detallelineacreditoId = detallelineacreditoId;
        this.garantiaId = garantiaId;
    }

    public int getDetallelineacreditoId() {
        return detallelineacreditoId;
    }

    public void setDetallelineacreditoId(int detallelineacreditoId) {
        this.detallelineacreditoId = detallelineacreditoId;
    }

    public int getGarantiaId() {
        return garantiaId;
    }

    public void setGarantiaId(int garantiaId) {
        this.garantiaId = garantiaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) detallelineacreditoId;
        hash += (int) garantiaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GarantiaexigidaPK)) {
            return false;
        }
        GarantiaexigidaPK other = (GarantiaexigidaPK) object;
        if (this.detallelineacreditoId != other.detallelineacreditoId) {
            return false;
        }
        if (this.garantiaId != other.garantiaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.GarantiaexigidaPK[ detallelineacreditoId=" + detallelineacreditoId + ", garantiaId=" + garantiaId + " ]";
    }
    
}
