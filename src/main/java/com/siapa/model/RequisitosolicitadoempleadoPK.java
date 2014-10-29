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
public class RequisitosolicitadoempleadoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQUISITOLINEACREDITOEMPLEADO_ID", nullable = false)
    private int requisitolineacreditoempleadoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASESORIA_ID", nullable = false)
    private int asesoriaId;

    public RequisitosolicitadoempleadoPK() {
    }

    public RequisitosolicitadoempleadoPK(int requisitolineacreditoempleadoId, int asesoriaId) {
        this.requisitolineacreditoempleadoId = requisitolineacreditoempleadoId;
        this.asesoriaId = asesoriaId;
    }

    public int getRequisitolineacreditoempleadoId() {
        return requisitolineacreditoempleadoId;
    }

    public void setRequisitolineacreditoempleadoId(int requisitolineacreditoempleadoId) {
        this.requisitolineacreditoempleadoId = requisitolineacreditoempleadoId;
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
        hash += (int) requisitolineacreditoempleadoId;
        hash += (int) asesoriaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitosolicitadoempleadoPK)) {
            return false;
        }
        RequisitosolicitadoempleadoPK other = (RequisitosolicitadoempleadoPK) object;
        if (this.requisitolineacreditoempleadoId != other.requisitolineacreditoempleadoId) {
            return false;
        }
        if (this.asesoriaId != other.asesoriaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.RequisitosolicitadoempleadoPK[ requisitolineacreditoempleadoId=" + requisitolineacreditoempleadoId + ", asesoriaId=" + asesoriaId + " ]";
    }
    
}
