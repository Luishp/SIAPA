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
public class RequisitosolicitadonegocioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQUISITO_LINEACREDITONEGOCIO_ID", nullable = false)
    private int requisitoLineacreditonegocioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASESORIA_ID", nullable = false)
    private int asesoriaId;

    public RequisitosolicitadonegocioPK() {
    }

    public RequisitosolicitadonegocioPK(int requisitoLineacreditonegocioId, int asesoriaId) {
        this.requisitoLineacreditonegocioId = requisitoLineacreditonegocioId;
        this.asesoriaId = asesoriaId;
    }

    public int getRequisitoLineacreditonegocioId() {
        return requisitoLineacreditonegocioId;
    }

    public void setRequisitoLineacreditonegocioId(int requisitoLineacreditonegocioId) {
        this.requisitoLineacreditonegocioId = requisitoLineacreditonegocioId;
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
        hash += (int) requisitoLineacreditonegocioId;
        hash += (int) asesoriaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitosolicitadonegocioPK)) {
            return false;
        }
        RequisitosolicitadonegocioPK other = (RequisitosolicitadonegocioPK) object;
        if (this.requisitoLineacreditonegocioId != other.requisitoLineacreditonegocioId) {
            return false;
        }
        if (this.asesoriaId != other.asesoriaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.RequisitosolicitadonegocioPK[ requisitoLineacreditonegocioId=" + requisitoLineacreditonegocioId + ", asesoriaId=" + asesoriaId + " ]";
    }
    
}
