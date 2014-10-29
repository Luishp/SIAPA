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
public class RequisitosolicitadogarantiaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "RG_ID", nullable = false)
    private int rgId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASESORIA_ID", nullable = false)
    private int asesoriaId;

    public RequisitosolicitadogarantiaPK() {
    }

    public RequisitosolicitadogarantiaPK(int rgId, int asesoriaId) {
        this.rgId = rgId;
        this.asesoriaId = asesoriaId;
    }

    public int getRgId() {
        return rgId;
    }

    public void setRgId(int rgId) {
        this.rgId = rgId;
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
        hash += (int) rgId;
        hash += (int) asesoriaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitosolicitadogarantiaPK)) {
            return false;
        }
        RequisitosolicitadogarantiaPK other = (RequisitosolicitadogarantiaPK) object;
        if (this.rgId != other.rgId) {
            return false;
        }
        if (this.asesoriaId != other.asesoriaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.RequisitosolicitadogarantiaPK[ rgId=" + rgId + ", asesoriaId=" + asesoriaId + " ]";
    }
    
}
