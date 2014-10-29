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
public class GarantiaasignadaanalisisPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANALISIS_ID", nullable = false)
    private int analisisId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GARANTIA_ID", nullable = false)
    private int garantiaId;

    public GarantiaasignadaanalisisPK() {
    }

    public GarantiaasignadaanalisisPK(int analisisId, int garantiaId) {
        this.analisisId = analisisId;
        this.garantiaId = garantiaId;
    }

    public int getAnalisisId() {
        return analisisId;
    }

    public void setAnalisisId(int analisisId) {
        this.analisisId = analisisId;
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
        hash += (int) analisisId;
        hash += (int) garantiaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GarantiaasignadaanalisisPK)) {
            return false;
        }
        GarantiaasignadaanalisisPK other = (GarantiaasignadaanalisisPK) object;
        if (this.analisisId != other.analisisId) {
            return false;
        }
        if (this.garantiaId != other.garantiaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.GarantiaasignadaanalisisPK[ analisisId=" + analisisId + ", garantiaId=" + garantiaId + " ]";
    }
    
}
