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
public class GarantiaasignadaasesoriaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "GARANTIA_ID", nullable = false)
    private int garantiaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASESORIA_ID", nullable = false)
    private int asesoriaId;

    public GarantiaasignadaasesoriaPK() {
    }

    public GarantiaasignadaasesoriaPK(int garantiaId, int asesoriaId) {
        this.garantiaId = garantiaId;
        this.asesoriaId = asesoriaId;
    }

    public int getGarantiaId() {
        return garantiaId;
    }

    public void setGarantiaId(int garantiaId) {
        this.garantiaId = garantiaId;
    }

    public int getAsesoriaId() {
        return asesoriaId;
    }

    public void setAsesoriaId(int asesoriaId) {
        this.asesoriaId = asesoriaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) garantiaId;
        hash += (int) asesoriaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GarantiaasignadaasesoriaPK)) {
            return false;
        }
        GarantiaasignadaasesoriaPK other = (GarantiaasignadaasesoriaPK) object;
        if (this.garantiaId != other.garantiaId) {
            return false;
        }
        if (this.asesoriaId != other.asesoriaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.GarantiaasignadaasesoriaPK[ garantiaId=" + garantiaId + ", asesoriaId=" + asesoriaId + " ]";
    }
    
}
